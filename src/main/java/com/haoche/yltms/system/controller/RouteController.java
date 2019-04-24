package com.haoche.yltms.system.controller;

import com.haoche.yltms.config.LoginInterceptor;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private UserService userService;

    @RequestMapping("/browseVehicle")
    public String browseVehicle(HttpSession session, Model model){
        User user = (User) session.getAttribute(LoginInterceptor.SESSION_KEY);
        model.addAttribute("account",user != null?userService.findById(user.getId()):null);
        return "ylt/lease";
    }

    @RequestMapping("/helpInfo")
    public String helpInfo(HttpSession session, Model model){
        User user = (User) session.getAttribute(LoginInterceptor.SESSION_KEY);
        model.addAttribute("account",user != null?userService.findById(user.getId()):null);
        return "ylt/help";
    }

    @RequestMapping("/aboutUs")
    public String about(HttpSession session, Model model){
        User user = (User) session.getAttribute(LoginInterceptor.SESSION_KEY);
        model.addAttribute("account",user != null?userService.findById(user.getId()):null);
        return "ylt/about";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(LoginInterceptor.SESSION_KEY);
        return "redirect:/";
    }

}
