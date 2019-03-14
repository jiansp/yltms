package com.haoche.yltms.system.controller;

import com.haoche.yltms.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
