package cn.tangt.com.tttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author tan
 * @date 2022/06/13 17:16
 */
public class Test {

    public static final String URL = "jdbc:mysql://120.76.246.175:3306/cblog";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        // 1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        // 3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username, password FROM user");
        // 如果有数据，rs.next()返回true
        while (rs.next()) {
            System.out.println(rs.getString("username") + " 年龄：" + rs.getString("password"));
        }
    }
}