package cn.tangt.com.test5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Recursion
 * @description : Recursion
 * @date : 2022/4/3
 */
class Recursion {
    private static String str = "";

    public static void reverseDisplay(int value) {
        if (value == 0) {
            System.out.println(str);
            return;
        }
        str += (char) (value % 10 + '0');
        reverseDisplay(value / 10);
    }

    public static int largest(int[] list) {
        if (list.length == 2) return Math.max(list[0], list[1]);
        else if (list.length == 1) return list[0];
        int len = list.length;
        int[] list1 = Arrays.copyOfRange(list, 0, len / 2 + 1);
        int[] list2 = Arrays.copyOfRange(list, len / 2 + 1, len);
        return Math.max(largest(list1), largest(list2));
    }

    public static int largest(int[] list, int high) {
        if (high == list.length - 1) return list[high];
        else return Math.max(list[high], largest(list, high + 1));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int i = input.nextInt();
        System.out.print("The reversal of " + i + " is ");
        reverseDisplay(i);
        System.out.print("Enter 8 integers: ");

        int[] list = new int[8];
        for (i = 0; i < list.length; i++)
            list[i] = input.nextInt();
        System.out.println("The largest element is " + largest(list));
        input.close();
    }
}
