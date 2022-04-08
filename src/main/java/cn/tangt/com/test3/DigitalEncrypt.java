package cn.tangt.com.test3;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : TEst4
 * @description : test4
 * @date : 2022/3/18
 */
public class DigitalEncrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要加密的数字：");
        String number = scanner.next();
        String numberEncrypted = encryptString(number);
        System.out.println(number + "加密后为：" + numberEncrypted);
    }

    public static String encryptString(String data) {
        int n = data.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(data.charAt(i) + "");
            nums[i] = (x + 5) % 10;
        }
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(nums[i]);
        }
        return result.toString();
    }
}
