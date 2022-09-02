package com.alating.alo.leetcode.array;


import java.util.Date;
import java.util.HashMap;


class Car{
    private String carId;
    private Integer type;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

class Order{
    private String carId;
    private Date enterTime;
    private Date outTime;
    private Integer cost;
    //0 - 代表进入
    // 1- 代表出去
    private Integer status;

    public Order(String carId,Date enterTime){
        this.carId=carId;
        this.enterTime=enterTime;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
public class Port {

    HashMap<String,Order> ordedMap=new HashMap<String,Order>();
    public boolean enter(Car car) throws Exception {

        if(ordedMap.get(car.getCarId())!=null || ordedMap.get(car.getCarId()).getStatus()!=2){
            throw new Exception("该车进入异常，上次出库未成功，轻确认。");
        }

        Order cur=new Order(car.getCarId(),new Date());
        cur.setStatus(0);

        ordedMap.put(car.getCarId(),cur);

        return true;
    }

    public int out(Car car) throws Exception{

        if(ordedMap.get(car.getCarId())!=null){
            throw new Exception("该车进入异常，5无入库记录，轻确认。");
        }

        Order cur=ordedMap.get(car.getCarId());
       // cur.

        return 0;


    }
}
