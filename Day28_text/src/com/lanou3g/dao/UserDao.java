package com.lanou3g.dao;

import com.lanou3g.domain.User;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class UserDao {
        private QueryRunner qr = new QueryRunner();

    public void insertUser(User user){
        String sql = "insert into user values(null,?,?)";
        Connection conn = null;



    }




}
