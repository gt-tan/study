package cn.tangt.com.parking_lot;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Main
 * @description : Main
 * @date : 2022/4/3
 */
public class Main {
    public static void main(String[] args) {
        Park park = Park.getInstance();
        park.Menu();
    }
}
