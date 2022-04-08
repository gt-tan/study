package cn.tangt.com.test3;

import java.util.*;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Test3
 * @description : test3
 * @date : 2022/3/18
 */
public class Poker {
    public static void main(String[] args) {
        Random random = new Random();

        String[] type = {"Hearts", "Diamonds", "Spades", "Clubs"};
        List<String> list = new ArrayList<>();
        //使用list储存扑克牌并初始化
        for (int i = 1; i <= 13; i++) {
            if (i == 1) {
                for (int j = 0; j < 4; j++) {
                    list.add("A of " + type[j]);
                }
            } else if (i <= 10) {
                for (int j = 0; j < 4; j++) {
                    list.add(i + " of " + type[j]);
                }
            } else if (i == 11) {
                for (int j = 0; j < 4; j++) {
                    list.add("J of " + type[j]);
                }
            } else if (i == 12) {
                for (int j = 0; j < 4; j++) {
                    list.add("Q of " + type[j]);
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    list.add("K of " + type[j]);
                }
            }
        }
        list.add("joker");
        list.add("JOKER");
        //用户抽牌
        String[] result = new String[4];
        List<String> user = new ArrayList<>();
        int times = 0;
        while (true) {
            if (isMeet(user)) {
                for (String s : result) {
                    System.out.println(s);
                }
                System.out.println("Number of picks:" + times);
                return;
            }
            times++;
            int choose = random.nextInt(52) + 1;
            user.add(list.get(choose));
            if (list.get(choose).endsWith("Hearts")) {
                result[0] = list.get(choose);
            } else if (list.get(choose).endsWith("Diamonds")) {
                result[1] = list.get(choose);
            } else if (list.get(choose).endsWith("Spades")) {
                result[2] = list.get(choose);
            } else if (list.get(choose).endsWith("Clubs")) {
                result[3] = list.get(choose);
            }
        }
    }

    //判断用户的牌是否符合要求
    public static boolean isMeet(List<String> list) {
        //用t1,t2,t3,t4分别储存每组花色的个数
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t4 = 0;
        for (String s : list) {
            if (s.endsWith("Hearts")) {
                t1++;
            } else if (s.endsWith("Diamonds")) {
                t2++;
            } else if (s.endsWith("Spades")) {
                t3++;
            } else if (s.endsWith("Clubs")) {
                t4++;
            }
        }
        return t1 != 0 && t2 != 0 && t3 != 0 && t4 != 0;
    }
}
