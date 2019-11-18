package com.agile.agiletest.traintickets.controller;



import com.agile.agiletest.traintickets.Result.Result;
import com.agile.agiletest.traintickets.service.OrderService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     *get all order
     * */
    @PostMapping("/getorder")
    public Result getOrder(@RequestBody JSONObject jsonObject){
        System.out.println("123");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("查订单"+username);
        Result result = orderService.getOrder(username);
        return result;
    }

    /**
     * change order
     * */
    @PostMapping("/changeorder")
    public Result changeOrder(@RequestBody JSONObject jsonObject){
        int orderid = jsonObject.getInteger("orderId");
        int tripsid = jsonObject.getInteger("tripsId");
        Result result = orderService.changeOrder(orderid,tripsid);
        return result;
    }
}
