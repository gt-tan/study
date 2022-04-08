package cn.tangt.com.test1;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : LotteryTicket
 * @description : 彩票
 * @date : 2022/3/4
 */
public class LotteryTicket {
    public static void main(String[] args) {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        while (a == b) {
            b = (int) (Math.random() * 10);
        }
        System.out.println(a + " " + b);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个两位数: ");
        int ticket = scanner.nextInt();
        int c = ticket / 10;
        int d = ticket % 10;
        if (c == a && d == b) {
            System.out.println("您的彩票中了10000美元");
        } else if (c == b && d == a) {
            System.out.println("您的彩票中了3000美元");
        } else if (c == a || c == b || d == a || d == b) {
            System.out.println("您的彩票中了1000美元");
        } else {
            System.out.println("很遗憾, 你没有中奖");
        }
    }
}
