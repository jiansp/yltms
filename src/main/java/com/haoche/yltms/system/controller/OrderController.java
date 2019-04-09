package com.haoche.yltms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/browseVehicle")
    public String browseVehicle(){
        return "lease";
    }
}
