package cn.tangt.com.test1;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : DetectionPwd
 * @description : 检测密码
 * @date : 2022/3/11
 */
public class DetectionPwd {
    public static void main(String[] args) {
        System.out.println("Enter a pwd: ");
        Scanner scanner = new Scanner(System.in);
        String pwd = scanner.next();
        int num = 0, upper = 0, lower = 0;
        boolean flag = true;
        if (pwd.length() < 11) {
            System.out.println("该密码是无效密码！");
            return;
        }
        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                flag = false;
                break;
            } else if (c >= '0' && c <= '9') {
                num++;
            } else if (c >= 'A' && c <= 'Z') {
                upper++;
            } else if (c >= 'a' && c <= 'z') {
                lower++;
            }
        }
        if (flag) {
            if (num >= 2 && upper > 0 && lower > 0) {
                System.out.println("该密码是高强度有效密码！");
            } else {
                System.out.println("该密码是低强度有效密码！");
            }
        } else {
            System.out.println("该密码是无效密码！");
        }
    }
}
