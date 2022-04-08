package cn.tangt.com.test4;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : tgt
 * @version : 1.0
 * @class : GCD
 * @description : GCD
 * @date : 2022/3/25
 */
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(11, 22, 33, 44, 55));
        System.out.println(gcd(48, 36, 12));
        System.out.println(gcd(19, 57));
    }

    public static int gcd(int n1, int n2) {
        return n2 == 0 ? n1 : gcd(n2, n1 % n2);
    }

    public static int gcd(int... numbers) {
        int divisor = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            divisor = gcd(divisor, numbers[i]);
        }
        return divisor;
    }
}
