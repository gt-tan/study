package cn.tangt.com.parking_lot;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Car
 * @description : Car
 * @date : 2022/4/3
 */
public abstract class Car implements Serializable {

    private final String number;
    private final String brand = initBrand();
    private final String model = initModel();

    public Car(String number) {
        this.number = number;
    }

    //getter方法
    public String getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    //子类初始化
    protected abstract String initBrand();

    protected abstract String initModel();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(number, car.number) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, brand, model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "车牌: " + number +
                ", 品牌: " + brand +
                ", 型号: " + model +
                '}';
    }
}