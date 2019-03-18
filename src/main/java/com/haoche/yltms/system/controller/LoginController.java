package com.haoche.yltms.system.controller;

import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.LoginService;
import com.haoche.yltms.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;


    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result content(HttpSession session, String username, String password) {
        User user = this.loginService.getUserByUsername(username);
        if(user != null){
            session.setAttribute("USER", user);
        }
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg(username + password);
        result.setObj(session.getAttribute("USER"));
        return result;
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


}
