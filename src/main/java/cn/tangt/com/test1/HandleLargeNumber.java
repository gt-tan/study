package cn.tangt.com.test1;

/**
 * @author : tgt
 * @version : 1.0
 * @class : HandleLargeNumber
 * @description : HandleLargeNumber
 * @date : 2022/3/20
 */
public class HandleLargeNumber {
    public static void main(String[] args) {
        // 初始化两个加数数组，其中num1是大数，只考虑一位进位
        int[] num1 = {0, 9, 9, 7, 9, 4, 5, 6, 7, 2, 3, 4, 5, 6, 4, 7, 8, 9, 8, 7, 6, 9};
        int[] num2 = {0, 0, 5, 9, 1, 6, 4, 5, 6, 2, 3, 4, 5, 7, 2, 1, 3, 6, 0, 3, 2, 9};
        // 声明和num1长度相同的结果数组
        int[] result = new int[num1.length];
        // 打印两个数组
        printArray(num1);
        System.out.print(" \n 加上: \n");
        printArray(num2);
        System.out.print(" \n 等于: \n");
        addArray(num1, num2, result);
        printArray(result);
    }

    // 从数组元素不是0的索引开始打印数组
    // 可以用System.out.print方法在控制台上显示格式化输出，参考书本 P126 格式化控制台输出
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i);
        }
    }

    // 对num1和num2的各个元素进行加法运算，结果依次存放到数组result中。
    public static void addArray(int[] num1, int[] num2, int[] result) {
        int remained = 0;
        for (int i = num1.length - 1; i >= 0; --i) {
            int sum = num1[i] + num2[i] + remained;
            if (sum > 9) {
                result[i] = sum % 10;
                remained = 1;
            } else {
                result[i] = sum;
                remained = 0;
            }
        }
    }
}



