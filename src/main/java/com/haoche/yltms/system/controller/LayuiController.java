package com.haoche.yltms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LayuiController {

    @RequestMapping("/")
    public String layui(){
        return "content";
    }
}
