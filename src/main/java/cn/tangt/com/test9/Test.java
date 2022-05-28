package cn.tangt.com.test9;

/**
 * @author tan
 * @date 2022/05/05 20:02
 */
public class Test {
    public static void main(String[] args) {

        ChinaPeople chinaPeople = new ChinaPeople();
        AmericanPeople americanPeople = new AmericanPeople();
        BeijingPeople beijingPeople = new BeijingPeople();

        chinaPeople.speakHello();
        chinaPeople.averageHeight();
        chinaPeople.averageWeight();
        chinaPeople.Gongfu();

        americanPeople.speakHello();
        americanPeople.averageHeight();
        americanPeople.averageWeight();
        americanPeople.Boxing();

        beijingPeople.speakHello();
        beijingPeople.averageHeight();
        beijingPeople.averageWeight();
        beijingPeople.BeijingOpera();
    }
}