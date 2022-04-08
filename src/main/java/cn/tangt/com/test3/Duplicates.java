package cn.tangt.com.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Duplicates
 * @description : Duplicates
 * @date : 2022/3/20
 */
public class Duplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list1:");
        int n1 = scanner.nextInt();
        int[] list1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            list1[i] = scanner.nextInt();
        }
        System.out.println("Enter list2:");
        int n2 = scanner.nextInt();
        int[] list2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            list2[i] = scanner.nextInt();
        }
        List<Integer> list3 = eliminateDuplicates(list1, list2);
        List<Integer> list4 = mergeDuplicatesOrder(list1, list2);
        System.out.println("After eliminate Duplicates data,the Array is:");
        System.out.println(list3);
        System.out.println("After order and eliminate Duplicates data,the Array is:");
        System.out.println(list4);
    }

    public static List<Integer> eliminateDuplicates(int[] list) {
        List<Integer> l = new ArrayList<>();
        for (int j : list) {
            if (!l.contains(j)) {
                l.add(j);
            }
        }
        return l;
    }

    public static List<Integer> eliminateDuplicates(int[] list1, int[] list2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < list1.length + list2.length; i++) {
            if (i < list1.length) {
                list.add(list1[i]);
            } else {
                list.add(list2[i - list1.length]);
            }
        }
        int[] list3 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            list3[i] = list.get(i);
        }
        return eliminateDuplicates(list3);
    }

    public static List<Integer> mergeDuplicatesOrder(int[] list1, int[] list2) {
        List<Integer> list = eliminateDuplicates(list1, list2);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int t = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, t);
                }
            }
        }

        Collections.sort(list);
        return list;
    }

}