package com.haoche.yltms.system.controller;

import com.haoche.yltms.config.LoginInterceptor;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.StatisticsService;
import com.haoche.yltms.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/index")
    public String index(@SessionAttribute(LoginInterceptor.SESSION_KEY) User user, Model model,String index) {
        user.setIndex(index);
        model.addAttribute("account",user);
        return "admIndex";
    }

    @RequestMapping("/getVehicleFreq")
    @ResponseBody
    public Result getVehicleFreq(){
        Result result = new Result();
        try {
            result.setSuccess(true);
            result.setObj(this.statisticsService.findVehicleFreq());
        } catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getShopFreq")
    @ResponseBody
    public Result getShopFreq(){
        Result result = new Result();
        try {
            result.setSuccess(true);
            result.setObj(this.statisticsService.findShopFreq());
        } catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/getFreq")
    @ResponseBody
    public Result getFreq(){
        Result result = new Result();
        try {
            result.setSuccess(true);
            result.setObj(this.statisticsService.findFreq());
        } catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/getIncome")
    @ResponseBody
    public Result getIncome(){
        Result result = new Result();
        try {
            result.setSuccess(true);
            result.setObj(this.statisticsService.findIncome());
        } catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
