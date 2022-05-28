package cn.tangt.com.test9;

/**
 * @author tan
 * @date 2022/05/05 20:04
 */
public class People {
    protected double weight;
    protected double height;

    public People() {
    }

    public People(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public void speakHello() {
        System.out.println("yayayay");
    }

    public void averageHeight() {
        height = 173;
        System.out.println("average height : " + height + "cm");
    }

    public void averageWeight() {
        weight = 70;
        System.out.println("average height : " + weight + "kg");
    }
}