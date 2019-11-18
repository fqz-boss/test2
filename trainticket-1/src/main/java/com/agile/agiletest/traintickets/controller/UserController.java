package com.agile.agiletest.traintickets.controller;



import com.agile.agiletest.traintickets.Result.Result;
import com.agile.agiletest.traintickets.pojo.Person;
import com.agile.agiletest.traintickets.pojo.User;
import com.agile.agiletest.traintickets.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * login function
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/updateUserInfo")
    public Result updateUserInfo(@RequestBody JSONObject jsonObject){
    	System.out.println("UserController");
        Result result = null;
        String username = jsonObject.getString("username");
        String trueName = jsonObject.getString("trueName");
        String idCardNum = jsonObject.getString("idCardNum");
        String phoneNum = jsonObject.getString("phoneNum");
        Integer age = jsonObject.getInteger("age");
        Person person = new Person(trueName, idCardNum, phoneNum, age);
        result = userService.updateUserInfo(person);
        return result;
    }

    @PostMapping("/getpersoninfo")
    public Result getPersonInfo(@RequestBody JSONObject jsonObject){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        return userService.getPersonInfo(username);
    }


}
