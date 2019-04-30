package com.haoche.yltms.system.service.impl;

import com.haoche.yltms.system.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryService inventoryService;

}
