package cn.tangt.com.parking_lot.sub_car;

import cn.tangt.com.parking_lot.Car;

/**
 * @author : tgt
 * @version : 1.0
 * @class : RollsRoyce
 * @description : RollsRoyce
 * @date : 2022/4/3
 */
public class RollsRoyce extends Car {

    public RollsRoyce(String number) {
        super(number);
    }

    @Override
    protected String initBrand() {
        return "劳斯莱斯";
    }

    @Override
    protected String initModel() {
        return "轿车";
    }
}
