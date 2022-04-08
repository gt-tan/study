package cn.tangt.com.parking_lot.sub_car;

import cn.tangt.com.parking_lot.Car;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Ferrari
 * @description : Ferrari
 * @date : 2022/4/3
 */
public class Ferrari extends Car {

    public Ferrari(String number) {
        super(number);
    }

    @Override
    protected String initBrand() {
        return "法拉利";
    }

    @Override
    protected String initModel() {
        return "跑车";
    }
}
