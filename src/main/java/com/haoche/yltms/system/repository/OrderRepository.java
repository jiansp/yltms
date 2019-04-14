package com.haoche.yltms.system.repository;

import com.haoche.yltms.system.model.RentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository extends JpaRepository<RentOrder,String>, JpaSpecificationExecutor<RentOrder> {
}
