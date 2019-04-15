package com.haoche.yltms.system.controller;

import com.haoche.yltms.config.LoginInterceptor;
import com.haoche.yltms.system.model.RentOrder;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.OrderService;
import com.haoche.yltms.system.vo.Result;
import com.haoche.yltms.system.vo.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/browseVehicle")
    public String browseVehicle(){
        return "ylt/lease";
    }

    @RequestMapping("/order")
    public String order(){
        return "ylt/order";
    }

    @RequestMapping("/query")
    public String query(@SessionAttribute(LoginInterceptor.SESSION_KEY) User user, Model model){
        model.addAttribute("account",user);
        return "order/query";
    }

    @ResponseBody
    @RequestMapping("/getOrderTable")
    public TableData getUserTable(Integer page, Integer limit, String orderNo){
        TableData tableData = new TableData();
        Map<String,String> params = new HashMap<>();
        params.put("orderNo",orderNo);
        try {
            Page<RentOrder> orderPage = this.orderService.findRentOrders(page,limit,params);
            tableData.setCode(TableData.SUCCESS);
            tableData.setCount(orderPage.getTotalElements());
            tableData.setData(orderPage.getContent());
        } catch (Exception e){
            e.printStackTrace();
            tableData.setMsg(e.getMessage());
        }
        return tableData;
    }

    @ResponseBody
    @RequestMapping("/save")
    public Result save(@SessionAttribute(LoginInterceptor.SESSION_KEY) User user, RentOrder order){
        Result result = new Result();
        try {
            this.orderService.saveAndUpdate(order,user);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }
}
