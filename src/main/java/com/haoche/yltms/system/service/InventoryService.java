package com.haoche.yltms.system.service;

import com.haoche.yltms.system.model.InventoryInfo;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.vo.TableData;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface InventoryService {
    TableData findInventorys(Integer page, Integer limit, Map<String, String> params);

    void saveAndUpdate(InventoryInfo inventoryInfo, User user);

    void update(InventoryInfo inventoryInfo, User user);

    InventoryInfo findInventory(String shopId, String vehicleId);

    void updateAmount(String shopId, String vehicleId, int n);
}
