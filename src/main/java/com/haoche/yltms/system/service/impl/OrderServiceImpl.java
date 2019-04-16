package com.haoche.yltms.system.service.impl;

import com.haoche.yltms.system.model.RentOrder;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.model.Vehicle;
import com.haoche.yltms.system.repository.OrderRepository;
import com.haoche.yltms.system.repository.UserRepository;
import com.haoche.yltms.system.repository.VehicleRepository;
import com.haoche.yltms.system.service.OrderService;
import com.haoche.yltms.system.service.SerialNumberService;
import com.haoche.yltms.utils.CopyUtils;
import com.haoche.yltms.utils.DateUtils;
import com.haoche.yltms.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SerialNumberService serialNumberService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    @Transient
    public void saveAndUpdate(RentOrder order, User user) {
        Date now = new Date();
        if(!StringUtils.isEmpty(order.getUserId())){
            User user1 = this.userRepository.getOne(order.getUserId());
            order.setUser(user1);
        }
        if(!StringUtils.isEmpty(order.getVehicleId())){
            Vehicle vehicle = this.vehicleRepository.getOne(order.getVehicleId());
            order.setVehicle(vehicle);
        }
        int duration = DateUtils.differentDaysByMillisecond(order.getReturnTime(), order.getObtainTime());
        String costRent = String.valueOf(Integer.valueOf(order.getRent()) * duration);
        order.setDuration(String.valueOf(duration));
        order.setCostRent(costRent);
        if (StringUtils.isEmpty(order.getId())) {
            String orderNo = String.format("%04",this.serialNumberService.getOrderNo());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = format.format(now);
            order.setId(UUIDGenerator.getUUID());
            order.setCreateTime(now);
            order.setCreator(user.getId());
            order.setOrderStatus(RentOrder.UN_PAY);
            order.setOrderNo(date + orderNo);
            this.orderRepository.save(order);
        } else {
            RentOrder old = this.orderRepository.getOne(order.getId());
            order.setModifier(user.getId());
            order.setModifyTime(now);
            CopyUtils.copyProperties(order, old);
            this.orderRepository.save(old);

        }
    }

    @Override
    public Page<RentOrder> findRentOrders(Integer pageNo, Integer limit, Map<String, String> params) {
        String orderNo = params.get("orderNo");
        Specification<RentOrder> specification = (Specification<RentOrder>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<String> isDelete = root.get("isDelete");
            Predicate p1 = criteriaBuilder.isNull(isDelete);
            Predicate p3 = criteriaBuilder.notEqual(isDelete,"1");
            Predicate p = criteriaBuilder.or(p1,p3);
            if (!StringUtils.isEmpty(orderNo)) {
                Path<String> orderNoPath = root.get("orderNo");
                Predicate p2 = criteriaBuilder.like(orderNoPath, "%" + orderNo + "%");
                return criteriaBuilder.and(p, p2);
            }
            return p;
        };
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "orderNo");
        PageRequest pageable = PageRequest.of(pageNo - 1, limit, sort);
        Page<RentOrder> page = this.orderRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public List<RentOrder> findOrders(Map<String, String> params) {
            String userId = params.get("userId");
            return this.orderRepository.findOrders(userId);
        }

}
