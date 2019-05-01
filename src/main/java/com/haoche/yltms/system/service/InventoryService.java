package com.haoche.yltms.system.service;

import com.haoche.yltms.system.model.InventoryInfo;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.vo.TableData;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface InventoryService {
    TableData findInventorys(Integer page, Integer limit, Map<String, String> params);

    void saveAndUpdate(InventoryInfo inventoryInfo, User user);
}
