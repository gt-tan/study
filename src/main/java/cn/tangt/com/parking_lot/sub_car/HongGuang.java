package cn.tangt.com.parking_lot.sub_car;

import cn.tangt.com.parking_lot.Car;

/**
 * @author : tgt
 * @version : 1.0
 * @class : HongGuang
 * @description : HongGuang
 * @date : 2022/4/3
 */
public class HongGuang extends Car {

    public HongGuang(String number) {
        super(number);
    }

    @Override
    protected String initBrand() {
        return "五菱宏光";
    }

    @Override
    protected String initModel() {
        return "面包车";
    }
}
