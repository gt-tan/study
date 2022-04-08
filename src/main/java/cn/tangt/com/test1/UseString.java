package cn.tangt.com.test1;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : UseString
 * @description : UseString
 * @date : 2022/3/11
 */
public class UseString {

    static String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    static void printOdd(String str) {
        for (int i = 1; i < str.length(); i += 2) {
            char c = str.charAt(i);
            System.out.print(c);
        }
        System.out.println();
    }

    static int upperCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println("The reversed string is " + reverse(string));
        printOdd(string);
        System.out.println("The count of uppercase is " + upperCount(string));
    }
}
