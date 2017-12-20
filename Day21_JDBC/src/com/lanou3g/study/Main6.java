package com.lanou3g.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main6 {
    public static void main(String[] args) {
        JdbcUtil.execute(conn -> {
            //大括号就是匿名内部类实现ExecuteInter接口时
            //复写的那个方法execute的方法体
            //conn就是execute方法的参数
            try {
                PreparedStatement pstate = conn.prepareStatement
                        ("insert into hw_user" +
                                " values (NULL ,'zhangSan',30,'上海');");
                //将30岁的张三插入到批处理中
                pstate.addBatch();
                //添加批处理任务
                pstate.addBatch
                        ("insert into hw_user" +
                                " values (NULL ,'liSi',10,'武汉');");
                pstate.addBatch
                        ("insert into hw_user" +
                                " values (NULL ,'zhangSan',11,'武汉');");

                //开始执行批处理任务
                pstate.executeBatch();
                return pstate;
            } catch (SQLException e) {
                e.printStackTrace();
            }
                return null;
        });

    }
}
