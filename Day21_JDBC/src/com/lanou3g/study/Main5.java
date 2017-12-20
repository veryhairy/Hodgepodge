package com.lanou3g.study;

import java.sql.*;

public class Main5 {
    /**
     *
     *1,PrepareStatement可以使用动态参数
     *       Statement只能执行静态的sql语句
     *2防止sql注入
     *      什么是sql注入？
     *
     *
     */


    public static void main(String[] args) {

     JdbcUtil.execute(conn -> {
         try {
             PreparedStatement pstate =
                     conn.prepareStatement
             ("SELECT * FROM hw_user WHERE loc=? AND age>?;");
             pstate.setString(1,"北京");
             pstate.setInt(2,20);

             ResultSet rs = pstate.executeQuery();
             JdbcUtil.shoeRS(rs);
             return pstate;
         } catch (SQLException e) {
             e.printStackTrace();
         }


         return null;
     });



     String user = "zhangSan";
     String password = "123";
     String sql = "select * from user where username="
             +user+"and password="+password;




    }
}
