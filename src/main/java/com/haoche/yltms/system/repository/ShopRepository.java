package com.haoche.yltms.system.repository;

import com.haoche.yltms.system.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, String>, JpaSpecificationExecutor<Shop> {

    @Query(value = "SELECT DISTINCT PROV FROM SHOP WHERE IS_DELETE IS NULL OR IS_DELETE <> 1",nativeQuery = true)
    List<String> findProv();
}
