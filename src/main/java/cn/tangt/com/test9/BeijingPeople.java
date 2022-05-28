package cn.tangt.com.test9;

/**
 * @author tan
 * @date 2022/05/05 20:07
 */
public class BeijingPeople extends ChinaPeople {
    public BeijingPeople() {
    }

    public void BeijingOpera() {
        System.out.println("京剧术语");
    }

    public void speakHello() {
        System.out.println("您好，吃了吗？");
    }

    public void averageHeight() {
        height = 167;
        System.out.println("北京人的平均身高是：" + height + "厘米");
    }

    public void averageWeight() {
        weight = 68.5;
        System.out.println("北京人的平均体重是：" + weight + "公斤");
    }
}