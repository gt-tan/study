package cn.tangt.com.test6;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Circle2D
 * @description : Circle2D
 * @date : 2022/4/8
 */
public class Circle2D {
    private Point p;
    private double radius;

    private static final double PI = 3.14;

    public Circle2D() {
        this.p = new Point();
        this.radius = 1;
    }

    public Circle2D(double x, double y, double radius) {
        this.p = new Point(x, y);
        this.radius = radius;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }

    public double distance(Point p) {
        return p.distance(this.p);
    }

    public boolean contains(double x, double y) {
        return Point.distance(x, y, p.getX(), p.getY()) < radius;
    }

    public boolean contains(Point p1) {
        return p.distance(p1) < radius;
    }

    public boolean contains(Circle2D circle) {
        return p.distance(circle.getP()) < radius - circle.getRadius();
    }

    public boolean overlaps(Circle2D circle) {
        return p.distance(circle.getP()) < radius + circle.getRadius();
    }
}

class TestCircle {
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println("周长: " + c1.getPerimeter());
        System.out.println("面积: " + c1.getArea());
        System.out.println(c1.contains(3, 3));
        System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println(c1.contains(new Circle2D(3, 5, 2.3)));
    }
}