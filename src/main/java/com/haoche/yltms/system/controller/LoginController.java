package com.haoche.yltms.system.controller;

import com.haoche.yltms.system.WebSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY)String account, Model model){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "content";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
