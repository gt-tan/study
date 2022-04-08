package cn.tangt.com.test4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : EqualArray
 * @description : EqualArray
 * @date : 2022/3/25
 */
public class EqualArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];
        System.out.println("Enter m1 (a 3 by 3 matrix) row by row:");
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter m2 (a 3 by 3 matrix) row by row:");
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                m2[i][j] = scanner.nextInt();
            }
        }
        if (absoluteEquals(m1, m2)) {
            System.out.println("The two arrays are strictly identical");
        } else {
            System.out.println("The two arrays are not strictly identical");
        }
        if (equals(m1, m2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }
    }

    public static boolean absoluteEquals(int[][] m1, int[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean equals(int[][] m1, int[][] m2) {
        int[] m11 = new int[9];
        int[] m22 = new int[9];
        for (int i = 0; i < m1.length; i++) {
            System.arraycopy(m1[i], 0, m11, i * 3, m1[i].length);
        }
        for (int i = 0; i < m2.length; i++) {
            System.arraycopy(m2[i], 0, m22, i * 3, m2[i].length);
        }
        Arrays.sort(m11);
        Arrays.sort(m22);
        for (int i = 0; i < m11.length; i++) {
            if (m11[i] != m22[i]) {
                return false;
            }
        }
        return true;
    }
}
