package com.haoche.yltms.system.controller;

import com.haoche.yltms.config.LoginInterceptor;
import com.haoche.yltms.system.model.InventoryInfo;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.InventoryService;
import com.haoche.yltms.system.vo.Result;
import com.haoche.yltms.system.vo.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @ResponseBody
    @RequestMapping("/getInventoryTable")
    public TableData getUserTable(Integer page, Integer limit, String shopId){
        TableData tableData = new TableData();
        Map<String,String> params = new HashMap<>();
        params.put("shopId",shopId);
        try {
            tableData = this.inventoryService.findInventorys(page,limit,params);
            tableData.setCode(TableData.SUCCESS);
        } catch (Exception e){
            e.printStackTrace();
            tableData.setMsg(e.getMessage());
        }
        return tableData;
    }
    @ResponseBody
    @RequestMapping("/save")
    public Result save(@SessionAttribute(LoginInterceptor.SESSION_KEY) User user, InventoryInfo inventoryInfo){
        Result result = new Result();
        try {
            this.inventoryService.saveAndUpdate(inventoryInfo,user);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/edit")
    public String edit(String shopId, Model model){
        model.addAttribute("shopId",shopId);
        return "inventory/edit";
    }

    @ResponseBody
    @RequestMapping("/getInventory")
    public Result getInventory(String shopId, String vehicleId){
        Result result = new Result();
        try {
            InventoryInfo inventoryInfo = this.inventoryService.findInventory(shopId, vehicleId);
            result.setSuccess(true);
            result.setObj(inventoryInfo);
        } catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
        }
        return result;
    }


}
