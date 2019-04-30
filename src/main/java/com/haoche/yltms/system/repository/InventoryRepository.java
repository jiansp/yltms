package com.haoche.yltms.system.repository;

import com.haoche.yltms.system.model.InventoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InventoryRepository extends JpaRepository<InventoryInfo,String>, JpaSpecificationExecutor<InventoryInfo> {
}
