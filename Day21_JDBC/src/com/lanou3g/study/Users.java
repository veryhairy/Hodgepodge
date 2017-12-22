package com.lanou3g.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Users {

    public static void insert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/querymany" + "?user=root&password=123"
        );
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String uname = scanner.nextLine();
        System.out.println("请输入年龄");
        String age = scanner.nextLine();
        System.out.println("请输入居住地");
        String loc = scanner.nextLine();

        PreparedStatement preparedStatement =
                conn.prepareStatement("INSERT INTO hw_user VALUES (NULL ,?,?,?)");


        preparedStatement.setString(1, uname);
        preparedStatement.setString(2, age);
        preparedStatement.setString(3, loc);

        preparedStatement.executeQuery();


    }
}
