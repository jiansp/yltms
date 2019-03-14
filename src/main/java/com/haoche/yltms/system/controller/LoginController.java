package com.haoche.yltms.system.controller;

import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public User getUser(){
        return loginService.getUserByUsername("qwe");
    }
}
