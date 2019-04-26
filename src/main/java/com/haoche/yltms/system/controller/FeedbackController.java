package com.haoche.yltms.system.controller;

import com.haoche.yltms.config.LoginInterceptor;
import com.haoche.yltms.system.model.Feedback;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.FeedbackService;
import com.haoche.yltms.system.vo.Result;
import com.haoche.yltms.system.vo.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @RequestMapping("/query")
    public String query(@SessionAttribute(LoginInterceptor.SESSION_KEY) User user, Model model, String index){
        user.setIndex(index);
        model.addAttribute("account",user);
        return "feedback/query";
    }

    @ResponseBody
    @RequestMapping("/getFeedbackTable")
    public TableData getUserTable(Integer page, Integer limit, String username){
        TableData tableData = new TableData();
        Map<String,String> params = new HashMap<>();
        params.put("username",username);
        try {
            Page<Feedback> feedbackPage = this.feedbackService.findFeedbacks(page,limit,params);
            tableData.setCode(TableData.SUCCESS);
            tableData.setCount(feedbackPage.getTotalElements());
            tableData.setData(feedbackPage.getContent());
        } catch (Exception e){
            e.printStackTrace();
            tableData.setMsg(e.getMessage());
        }
        return tableData;
    }

    @ResponseBody
    @RequestMapping("/save")
    public Result save(@SessionAttribute(LoginInterceptor.SESSION_KEY) User user, Feedback feedback){
        Result result = new Result();
        try {
            this.feedbackService.saveAndUpdate(feedback,user);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/del")
    public Result del(@SessionAttribute(LoginInterceptor.SESSION_KEY)User user,String id){
        Result result = new Result();
        try {
            if(StringUtils.isEmpty(id)){
                result.setMsg("删除失败，无法确定id");
                result.setSuccess(false);
            }else{
                this.feedbackService.del(id, user.getId());
                result.setSuccess(true);
            }
        } catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/process")
    public Result process(@SessionAttribute(LoginInterceptor.SESSION_KEY)User user,String id){
        Result result = new Result();
        try {
            if(StringUtils.isEmpty(id)){
                result.setMsg("处理失败，无法确定id");
                result.setSuccess(false);
            }else{
                Feedback feedback = this.feedbackService.findById(id);
                feedback.setStatus(Feedback.PROCESS);
                this.feedbackService.saveAndUpdate(feedback,user);
                result.setSuccess(true);
            }
        } catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
