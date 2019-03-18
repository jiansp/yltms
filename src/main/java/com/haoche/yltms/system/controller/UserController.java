package com.haoche.yltms.system.controller;

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

    @RequestMapping("/saveUser")
    @ResponseBody
    public Result saveUser(String username){
        Result result = new Result();
        /*try{
            this.userService.save(user);
            result.setSuccess(true);
        } catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }*/
        return result;

    }
}
