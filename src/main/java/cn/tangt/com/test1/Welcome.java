package cn.tangt.com.test1;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Welcome
 * @description : Welcome
 * @date : 2022/3/12
 */
public class Welcome {
    public static void main(String[] args) {
        String s1 = "Welcome";
        String s2 = "welcome";
//        boolean isEqual = s1 == s2;
//        System.out.println(isEqual);  // false

//        boolean isEqual = s1.equalsIgnoreCase(s2);
//        System.out.println(isEqual);  // true

//        int x = s1.compareTo(s2);
//        System.out.println(x);    // -32

//        int x = s1.compareToIgnoreCase(s2);
//        System.out.println(x);    // 0

//        boolean b = s1.startsWith("AAA");
//        System.out.println(b);    // false

//        boolean b = s1.endsWith("AAA");
//        System.out.println(b);    // false

//        int x = s1.length();
//        System.out.println(x);  // 7

//        char x = s1.charAt(0);
//        System.out.println(x);  // W

//        String s3 = s1 + s2;
//        System.out.println(s3); // Welcomewelcome

//        s1 = s1.substring(1);
//        System.out.println(s1); // elcome

//        s1 = s1.substring(1, 4);
//        System.out.println(s1); // elc

//        String s3 = s1.toLowerCase();
//        System.out.println(s3); // welcome

//        String s3 = s1.trim();
//        System.out.println(s3); // welcome

//        int x = s1.indexOf('e');
//        System.out.println(x);  // 1

        int x = s1.indexOf("abc");
        System.out.println(x);  // -1
    }
}
