package cn.tangt.com.test6;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : LinearEquatino
 * @description : LinearEquatino
 * @date : 2022/4/8
 */
public class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public boolean isSolvable() {
        return a * d - b * c != 0;
    }

    public double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }

    public double getY() {
        return (a * f - e * c) / (a * d - b * c);
    }
}

class TestLinearEquation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        double x1 = s.nextDouble();
        double y1 = s.nextDouble();
        double x2 = s.nextDouble();
        double y2 = s.nextDouble();
        double x3 = s.nextDouble();
        double y3 = s.nextDouble();
        double x4 = s.nextDouble();
        double y4 = s.nextDouble();
        LinearEquation linearEquation = new LinearEquation(y1 - y2, -(x1 - x2), y3 - y4, -(x3 - x4), (y1 - y2) * x1 - (x1 - x2) * y1, (y3 - y4) * x3 - (x3 - x4) * y4);
        if (linearEquation.isSolvable()) {
            System.out.println("The intersecting point is: (" +
                    linearEquation.getX() +
                    ", " + linearEquation.getY() + ")"
            );
        }  else {
            System.out.println("The two lines do not cross, they are parallel");
        }
    }
}