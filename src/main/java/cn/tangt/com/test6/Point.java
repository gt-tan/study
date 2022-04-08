package cn.tangt.com.test6;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Point
 * @description : Point
 * @date : 2022/4/8
 */
public class Point {
    private double x = 0;
    private double y = 0;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setLocation(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public void Translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public double distance(Point p1, Point p2) {
        return distance(p1.x, p1.y, p2.x, p2.y);
    }

    public double distance(Point p) {
        return distance(this, p);
    }

    @Override
    public String toString() {
        return "Point " +
                "x is " + x +
                ", y is " + y;
    }
}

class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 30.5);
        System.out.println(p1.distance(p2));
        p1.Translate(3, 5);
        System.out.println(p1);
    }
}
