package com.haoche.yltms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/route")
public class RouteController {

    @RequestMapping("/browseVehicle")
    public String browseVehicle(){
        return "ylt/booking";
    }
}
