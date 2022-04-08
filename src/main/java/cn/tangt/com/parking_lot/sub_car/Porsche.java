package cn.tangt.com.parking_lot.sub_car;

import cn.tangt.com.parking_lot.Car;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Porsche
 * @description : Porsche
 * @date : 2022/4/3
 */
public class Porsche extends Car {

    public Porsche(String number) {
        super(number);
    }

    @Override
    protected String initBrand() {
        return "保时捷";
    }

    @Override
    protected String initModel() {
        return "SUV";
    }
}
