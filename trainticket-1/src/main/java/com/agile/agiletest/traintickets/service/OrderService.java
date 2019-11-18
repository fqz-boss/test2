package com.agile.agiletest.traintickets.service;


import com.agile.agiletest.traintickets.Result.Result;

/**
 * 订单处理
. * */
public interface OrderService {
  
    public abstract Result getOrder(String username);

    /**
     *订单改签
     */
    public abstract Result changeOrder(int orderId, int tripsId);
}
