package cn.tangt.com.parking_lot;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Transaction
 * @description : Transaction
 * @date : 2022/4/3
 */
public class Transaction implements Serializable {

    private String orderId;
    private Date enterTime;
    private Date exitTime;
    private double charge;
    private Car car;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

    public Transaction(String orderId, Car car) {
        this.orderId = orderId;
        this.car = car;
        enterTime = new Date();
    }

    // getter和setter方法
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    // 返回出入库的格式化日期
    public String getSdfEnterTime() {
        return sdf.format(enterTime);
    }

    public String getSdfExitTime() {
        return sdf.format(exitTime);
    }

    @Override
    public String toString() {
        return "订单号: " + orderId +
                ", 入库时间: " + getSdfEnterTime() +
                ", 出库时间: " + getSdfExitTime() +
                ", 收费: " + charge +
                ", " + car;
    }
}
