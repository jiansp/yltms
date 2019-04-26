package com.haoche.yltms.system.service.impl;

import com.haoche.yltms.system.model.Feedback;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.repository.FeedbackRepository;
import com.haoche.yltms.system.service.FeedbackService;
import com.haoche.yltms.utils.CopyUtils;
import com.haoche.yltms.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Feedback findById(String id) {
        return this.feedbackRepository.getOne(id);
    }

    @Override
    public Page<Feedback> findFeedbacks(Integer pageNo, Integer limit, Map<String, String> params) {
        String username = params.get("username");
        Specification<Feedback> specification = (Specification<Feedback>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<String> isDelete = root.get("isDelete");
            Predicate p1 = criteriaBuilder.isNull(isDelete);
            Predicate p3 = criteriaBuilder.notEqual(isDelete,"1");
            Predicate p = criteriaBuilder.or(p1,p3);
            if (!StringUtils.isEmpty(username)) {
                Path<String> usernamePath = root.get("name");
                Predicate p2 = criteriaBuilder.like(usernamePath, "%" + username + "%");
                return criteriaBuilder.and(p, p2);
            }
            return p;
        };
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "createTime");
        PageRequest pageable = PageRequest.of(pageNo - 1, limit, sort);
        Page<Feedback> page = this.feedbackRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public void saveAndUpdate(Feedback feedback, User user) {
        Date now = new Date();
        if (StringUtils.isEmpty(feedback.getId())) {
            feedback.setId(UUIDGenerator.getUUID());
            feedback.setCreateTime(now);
            feedback.setCreator(user.getId());
            feedback.setStatus(Feedback.SUBMMIT);
            feedback.setUser(user);
            this.feedbackRepository.save(feedback);
        } else {
            Feedback old = this.feedbackRepository.getOne(feedback.getId());
            feedback.setModifier(user.getId());
            feedback.setModifyTime(now);
            CopyUtils.copyProperties(feedback, old);
            this.feedbackRepository.save(old);

        }
    }

    @Override
    public void del(String id, String userId) {
        Date now = new Date();
        Feedback feedback = this.feedbackRepository.getOne(id);
        feedback.setIsDelete(Feedback.IS_DETELE);
        feedback.setDeleter(userId);
        feedback.setDeleteTime(now);
        this.feedbackRepository.save(feedback);
    }
}
