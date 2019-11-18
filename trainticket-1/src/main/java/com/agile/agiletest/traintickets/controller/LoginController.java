package com.agile.agiletest.traintickets.controller;

import com.agile.agiletest.traintickets.Result.Result;
import com.agile.agiletest.traintickets.dao.UserDao;
import com.agile.agiletest.traintickets.pojo.User;
import com.agile.agiletest.traintickets.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


   /*@Autowired
     private UserDao userDao;*/
   @Autowired
   private LoginService loginService;


     @RequestMapping("/login")

    public String log(){
     /*   User user =  userDao.getUserByUsername(username);
        session.setAttribute("user",user);*/
        return "login";
    }

      @RequestMapping("/index")
    public String index(){
         return "index";
     }

     @RequestMapping("/price")
    public String price(){
          return  "prices";

     }
    @RequestMapping("/contact")
    public String contact(){
        return  "contact";
    }

    @RequestMapping("/order")
    public String oderForm(){
        return  "orderform";
    }

    @RequestMapping("/perInfo")
    public String perInfo(){
        return  "perInfo";
    }

    @PostMapping("/updatePassword")
    @ResponseBody
    public Result updateUser(@RequestBody JSONObject jsonObject){
        User userData = new User();
        userData.setUsername(jsonObject.getString("username"));
        userData.setPassword(jsonObject.getString("passwordOld"));
        String newPassword = jsonObject.getString("passwordNew");
        Result result  = loginService.updateUser(userData, newPassword);
        return result;
    }

    /**
     * user regist
     * @param userData
     * @return
     */
    @PostMapping("/regist")
    @ResponseBody
    public Result registUser(@RequestBody User userData){
        System.out.println("注册");
        return loginService.registUser(userData);
    }
}
