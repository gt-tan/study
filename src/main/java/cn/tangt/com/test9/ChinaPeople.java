package cn.tangt.com.test9;

/**
 * @author tan
 * @date 2022/05/05 20:05
 */
public class ChinaPeople extends People {
    public ChinaPeople() {
    }

    public void Gongfu() {
        System.out.println("坐如钟，站如松，睡如弓");
    }

    public void speakHello() {
        System.out.println("你好");
    }

    public void averageHeight() {
        height = 173;
        System.out.println("中国人的平均身高是：" + height + "厘米");
    }

    public void averageWeight() {
        weight = 67.34;
        System.out.println("中国人的平均体重是：" + weight + "公斤");
    }
}