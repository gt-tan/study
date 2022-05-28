package cn.tangt.com.test9;

/**
 * @author tan
 * @date 2022/05/05 20:17
 */
public class StoolDemo {
    public static void main(String[] args) {
        topCylinder tc = new topCylinder(3.0, 1);
        middleCylinder mc = new middleCylinder(1.5, 5);
        bottomCylinder bc = new bottomCylinder(4, 1);
        Stool st = new Stool(tc, mc, bc);
        System.out.println("Area is " + st.Area());
        System.out.println("Vol is " + st.vol());
    }
}

class Cylinder {
    public double radius;
    public double height;

    Cylinder() {
    }

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double Area() {
        return 2 * Math.PI * radius * radius + 2 * Math.PI * radius * height;
    }

    public double vol() {
        return Math.PI * radius * radius * height;
    }
}

class topCylinder extends Cylinder {
    topCylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
}

class middleCylinder extends Cylinder {
    middleCylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
}

class bottomCylinder extends Cylinder {
    bottomCylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
}

class Stool {
    public topCylinder t;
    public middleCylinder m;
    public bottomCylinder b;

    public Stool(topCylinder t, middleCylinder m, bottomCylinder b) {
        this.t = t;
        this.m = m;
        this.b = b;
    }

    public double Area() {
        return t.Area() + m.Area() + b.Area();
    }

    public double vol() {
        return t.vol() + m.vol() + b.vol();
    }
}