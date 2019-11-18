package com.agile.agiletest.traintickets.service;


import com.agile.agiletest.traintickets.Result.Result;
import com.agile.agiletest.traintickets.pojo.Trips;

/**
 * 查询车票信息
 */
public interface TripsService {
    /**
     * 查询所有车票信息
     * */
    public abstract Result getAlltrips(Trips trips);
    /**
     *查询目标车票信息
     * */
    public abstract Result getAimtrips(Trips trips);


    /**
     * 购买车票
     */
    public abstract Result buyTicket(String username, int carInfoId, String carNum);

    /**
     * 退票
     * @param personId
     */
    public abstract Result ticketRetund(int personId, String carNum, String startTime, String reachTime);

    /**
     * 付钱
     */
    public abstract Result payMoney(int orderId);

}
