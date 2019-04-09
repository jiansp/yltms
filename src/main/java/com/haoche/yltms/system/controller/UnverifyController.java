package com.haoche.yltms.system.controller;

import com.haoche.yltms.system.model.Vehicle;
import com.haoche.yltms.system.service.VehicleService;
import com.haoche.yltms.system.vo.Result;
import com.haoche.yltms.system.vo.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/unverify")
public class UnverifyController {
    @Autowired
    private VehicleService vehicleService;

    @ResponseBody
    @RequestMapping("/getVehicleInfo")
    public Result getUserTable(String type){
        Result result = new Result();
        Map<String,String> params = new HashMap<>();
        params.put("type",type);
        try {
            List<Vehicle> vehicles = this.vehicleService.findVehicles(params);
            result.setSuccess(true);
            result.setObj(vehicles);
        } catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
