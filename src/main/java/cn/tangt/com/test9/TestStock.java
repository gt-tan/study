package cn.tangt.com.test9;

/**
 * @author tan
 * @date 2022/05/05 20:13
 */
public class TestStock {
    public static void main(String[] args) {
        DividendStock ds = new DividendStock("Oracle");
        ds.purchase(200, 32);
        ds.purchase(350, 40);
        ds.payDividend(2.8);
        System.out.println(ds);
        System.out.println(ds.getProfit(50));
    }
}