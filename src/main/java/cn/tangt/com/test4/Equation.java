package cn.tangt.com.test4;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Equation
 * @description : Equation
 * @date : 2022/3/25
 */
public class Equation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a, b, c:");
        double[] eqn = new double[3];
        eqn[0] = scanner.nextDouble();
        eqn[1] = scanner.nextDouble();
        eqn[2] = scanner.nextDouble();
        double[] roots = new double[2];
        int cnt = QuadraticEquation.solveQuadratic(eqn, roots);
        if (cnt < 0) {
            System.out.println("The equation has no roots");
        } else if (cnt == 0) {
            System.out.println("The equation has one roots: " + roots[0]);
        } else {
            System.out.println("The equation has two roots: " + roots[0] + ", " + roots[1]);
        }
    }
}
