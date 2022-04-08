package cn.tangt.com.test3;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Work
 * @description : work
 * @date : 2022/3/18
 */
public class FindRoots {

    public static void main(String[] args) {
        double a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a, b, c:");
        double[] eqn = new double[3];
        a = scanner.nextDouble();
        eqn[0] = a;
        b = scanner.nextDouble();
        eqn[1] = b;
        c = scanner.nextDouble();
        eqn[2] = c;
        double[] roots = new double[2];
        int cnt = solveQuadratic(eqn, roots);
        if (cnt < 0) {
            System.out.println("The equation has no roots");
        } else if (cnt == 0) {
            System.out.println("The equation has one roots: " + roots[0]);
        } else {
            System.out.println("The equation has two roots: " + roots[0] + ", " + roots[1]);
        }
    }

    public static int solveQuadratic(double[] eqn, double[] roots) {
        int delta = (int) (eqn[1] * eqn[1] - 4 * eqn[0] * eqn[2]);
        if (delta >= 0) {
            roots[0] = (-eqn[1] + Math.sqrt(delta)) / 2 * eqn[0];
            roots[1] = (-eqn[1] - Math.sqrt(delta)) / 2 * eqn[0];
        }
        return delta;
    }
}
