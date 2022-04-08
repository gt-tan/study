package cn.tangt.com.test1;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : ComputerDistance
 * @description : 计算距离
 * @date : 2022/3/1
 */
public class ComputerDistance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a point with two coordinates: ");
        Double x = input.nextDouble();
        Double y = input.nextDouble();
        Double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        if (distance < 10) {
            System.out.println("Point (" + x + ", " + y + ") is in the circle");
        } else {
            System.out.println("Point (" + x + ", " + y + ") is not in the circle");
        }
    }
}