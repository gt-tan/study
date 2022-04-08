package cn.tangt.com.test1;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : ISBNTest
 * @description : 检测ISBN
 * @date : 2022/3/11
 */
public class ISBNTest {
    public static void main(String[] args) {
        System.out.println("Enter the first 12-digit of an ISBN number as a string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        boolean flag = true;
        while (flag) {
            if (str.length() != 12) {
                System.out.println(str + " is an invalid input");
            } else {
                int d = 0;
                for (int i = 0; i < str.length() - 1; ++i) {
                    char c = str.charAt(i);
                    int num = Integer.parseInt(String.valueOf(c));
                    if (i % 2 == 0) {
                        d += num;
                    } else {
                        d += 3 * num;
                    }
                }
                d = 10 - d % 10;
                if (d == 10) {
                    d = 0;
                }
                System.out.println(str + d + " is an ISBN number");
                flag = false;
            }
            if (flag) {
                System.out.println("Again Enter the first 12-digit of an ISBN number as a string: ");
                str = scanner.next();
            }
        }
    }
}
