package com.haoche.yltms.system.service;

import com.haoche.yltms.system.model.Feedback;
import com.haoche.yltms.system.model.User;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface FeedbackService {
    Feedback findById(String id);

    Page<Feedback> findFeedbacks(Integer page, Integer limit, Map<String, String> params);

    void saveAndUpdate(Feedback feedback, User user);

    void del(String id, String id1);

}
