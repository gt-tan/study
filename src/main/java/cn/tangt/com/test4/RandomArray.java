package cn.tangt.com.test4;

/**
 * @author : tgt
 * @version : 1.0
 * @class : RandomArray
 * @description : RandomArray
 * @date : 2022/3/25
 */
public class RandomArray {
    public static void main(String[] args) {
        int[] array = creatRandomArray();
        int[] ints = countDigits(array);
        reportResult(ints);
    }

    public static int[] creatRandomArray() {
        int[] ints = new int[100];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 100);
        }
        return ints;
    }

    public static int[] countDigits(int[] array) {
        int[] ints = new int[10];
        for (int i : array) {
            ints[i % 10]++;
        }
        return ints;
    }

    public static void reportResult(int[] count) {
        System.out.println("Digit Count");
        for (int i = 0; i < count.length; i++) {
            System.out.println(i + " " + count[i]);
        }
    }
}
