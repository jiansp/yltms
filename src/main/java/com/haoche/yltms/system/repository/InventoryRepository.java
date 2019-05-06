package com.haoche.yltms.system.repository;

import com.haoche.yltms.system.model.InventoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryInfo,String>, JpaSpecificationExecutor<InventoryInfo> {
    @Query(value = "from InventoryInfo where (shop.id =:shopId or shop.shopName =:shopId) and vehicle.id =:vehicleId and (isDelete <> 1 or isDelete is null)")
    List<InventoryInfo> findByShopAndVehicle(@Param("shopId") String shopId,@Param("vehicleId") String vehicleId);

    }
