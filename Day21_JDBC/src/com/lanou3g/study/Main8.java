package com.lanou3g.study;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main8 {
    public static void main(String[] args) {
        //dbUtil是apache公司给我们提供的一个工具类
        //强行翻译 询问执行者
        QueryRunner qr = new QueryRunner();
        String sql = "select * from hw_user";
        try {
            List<User> query = qr.query
                    (JdbcUtil.getConnection(), sql, new ResultSetHandler<List<User>>() {

                @Override
                public List<User> handle(ResultSet resultSet) throws SQLException {
                    //TODO 把resultset中的数据封装到一个对象中
                    List<User> users=new ArrayList<>();
                    while (resultSet.next()){
                        User user = new User();
                        user.setId(resultSet.getInt(1));
                        user.setUname(resultSet.getString(2));
                        user.setAge(resultSet.getInt(3));
                        user.setLoc(resultSet.getString(4));
                        users.add(user); }
                    return users;
                }
            });

            System.out.println(query);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
