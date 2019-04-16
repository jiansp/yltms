package com.haoche.yltms.system.repository;

import com.haoche.yltms.system.model.RentOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.Valid;
import java.util.List;

public interface OrderRepository extends JpaRepository<RentOrder,String>, JpaSpecificationExecutor<RentOrder> {

    @Query(value = "from RentOrder where ")
    List<RentOrder> findOrders(@Param("userId") String userId);
}
