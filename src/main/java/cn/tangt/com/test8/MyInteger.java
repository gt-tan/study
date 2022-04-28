package cn.tangt.com.test8;

import java.util.Arrays;

/**
 * @author tan
 * @date 2022/04/26 14:42
 */
public class MyInteger {
    private final int value;

    MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return (value + 1) % 2 == 0;
    }

    public boolean isPrime() {
        if (value == 1)
            return false;
        for (int i = 1; i < value; i++)
            if (value % i == 0)
                return false;
        return true;
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return (value + 1) % 2 == 0;
    }

    public static boolean isPrime(int value) {
        if (value == 1)
            return false;
        for (int i = 1; i < value; i++)
            if (value % i == 0)
                return false;
        return true;
    }

    public boolean equals(int value) {
        return this.value == value;
    }

    public boolean equals(MyInteger myInteger) {
        return this.value == myInteger.value;
    }

    public static int parseInt(char[] chars) {
        return Integer.parseInt(Arrays.toString(chars));
    }

    public static int parseInt(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(10);
        System.out.println("Test getValue: " + myInteger.getValue());
        System.out.println("Test isEven: " + myInteger.isEven());
        System.out.println("Test isPrime: " + myInteger.isPrime());
        System.out.println("Test isOdd: " + myInteger.isOdd());
        System.out.println("Test equals(int): " + myInteger.equals(12));
        System.out.println("Test equals(MyInteger): " + myInteger.equals(new MyInteger((10))));
        System.out.println("Test static isEven: " + MyInteger.isEven(10));
        System.out.println("Test static isOdd: " + MyInteger.isOdd(10));
        System.out.println("Test static isPrime: " + MyInteger.isPrime(10));
        System.out.println("Test static parseInt(char[]): " + MyInteger.parseInt(new String(new char[]{'1', '2', '3', '4'})));
        System.out.println("Test static parseInt(String): " + MyInteger.parseInt("1234"));
    }
}

