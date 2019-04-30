package com.haoche.yltms.system.controller;

import com.haoche.yltms.config.LoginInterceptor;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/query")
    public String query(@SessionAttribute(LoginInterceptor.SESSION_KEY) User user, Model model, String index){
        user.setIndex(index);
        model.addAttribute("account",user);
        return "inventory/query";
    }
}
