package cn.tangt.com.test1;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : FindMax
 * @description : nihao
 * @date : 2022/3/4
 */
public class FindMax {
    public static void main(String[] args) {
        System.out.println("Enter numbers, the program exits if the input is 0");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int max = num;
        int count = 1;
        while (num != 0) {
            num = scanner.nextInt();
            if (max == num) {
                count ++;
            } else if (max < num) {
                max = num;
                count = 1;
            }
        }
        System.out.println("The largest number is " + max);
        System.out.println("the occurrence count of the largest number is " + count);
    }
}
