package com.haoche.yltms.system.controller;

import com.haoche.yltms.config.LoginInterceptor;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.LoginService;
import com.haoche.yltms.system.service.UserService;
import com.haoche.yltms.system.vo.PageData;
import com.haoche.yltms.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public Result saveUser(User user) {
        Result result = new Result();
        try {
            if (this.loginService.getUserByUsername(user.getUsername(), User.GENERAL_USER) != null) {
                result.setSuccess(false);
                result.setMsg("该用户名已被使用");
                return result;
            }

            this.userService.save(user);
            result.setSuccess(true);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Result update(User user){
        Result result = new Result();
        try {
            if(StringUtils.isEmpty(user.getPasswordO())){
                this.userService.save(user);
                result.setSuccess(true);
            }else{
                this.userService.changePassword(user);
                result.setSuccess(true);
            }
        } catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/query")
    public String query(@SessionAttribute(LoginInterceptor.SESSION_KEY)User user, Model model){
        model.addAttribute("account",user);
        return "user/query";
    }

    @ResponseBody
    @RequestMapping("/getUserTable")
    public PageData getUserTable(){
        PageData pageData = new PageData();
        try {
            List<User> list = this.userService.findUsers();
            pageData.setCode(PageData.SUCCESS);
            pageData.setCount(list.size());
            pageData.setData(list);
        } catch (Exception e){
            e.printStackTrace();
            pageData.setMsg(e.getMessage());
        }
        return pageData;
    }
}
