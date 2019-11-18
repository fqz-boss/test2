package com.agile.agiletest.traintickets.pojo;


/**
 *查询订单信息
 * @author 41688
 * @version 0.1
 * */
public class Order {
    private int id;
    private int carInfoId;
    private int person_id;
    private int changeTimes;
    //0是预定未付款， 1是已经支付， 2是退票
    private int status;
    private String stautsMsg;

    public String getStautsMsg() {
        return stautsMsg;
    }

    public void setStautsMsg(String stautsMsg) {
        this.stautsMsg = stautsMsg;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", carInfoId=" + carInfoId +
                ", personId=" + person_id +
                ", changeTimes=" + changeTimes +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(int carInfoId) {
        this.carInfoId = carInfoId;
    }

    public int getPersonId() {
        return person_id;
    }

    public void setPersonId(int personId) {
        this.person_id = personId;
    }

    public int getChangeTimes() {
        return changeTimes;
    }

    public void setChangeTimes(int changeTimes) {
        this.changeTimes = changeTimes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Order() {
    }

    public Order(int id, int carInfoId, int personId, int changeTimes, int status) {
        this.id = id;
        this.carInfoId = carInfoId;
        this.person_id = personId;
        this.changeTimes = changeTimes;
        this.status = status;
    }
    public Order(int carInfoId, int personId, int changeTimes) {
        this.carInfoId = carInfoId;
        this.person_id = personId;
        this.changeTimes = changeTimes;
    }
}
