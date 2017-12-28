package com.lanou3g;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class Query extends QueryRunner {
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh) throws SQLException {

        T t = super.query(conn, sql, rsh);

        return t;
    }
}