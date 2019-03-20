package com.haoche.yltms.system.controller;

import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.LoginService;
import com.haoche.yltms.system.service.UserService;
import com.haoche.yltms.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public Result saveUser(User user){
        Result result = new Result();
        try{
            if(this.loginService.getUserByUsername(user.getUsername(), User.GENERAL_USER) !=null){
                result.setSuccess(false);
                result.setMsg("该用户名已被使用");
            }else{
                this.userService.save(user);
                result.setSuccess(true);
            }
        } catch (Exception e){
            e.printStackTrace();

        }
        return result;

    }
}
