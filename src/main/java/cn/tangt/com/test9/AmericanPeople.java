package cn.tangt.com.test9;

/**
 * @author tan
 * @date 2022/05/05 20:06
 */
public class AmericanPeople extends People {
    public AmericanPeople() {
    }

    public void Boxing() {
        System.out.println("straight punch Dash Ground Straight");
    }

    public void speakHello() {
        System.out.println("How do you do");
    }

    public void averageHeight() {
        height = 188;
        System.out.println("American average height : " + height + "cm");
    }

    public void averageWeight() {
        weight = 80.23;
        System.out.println("American average height : " + weight + "kg");
    }
}