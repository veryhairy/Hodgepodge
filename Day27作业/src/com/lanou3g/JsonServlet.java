package com.lanou3g;

import net.sf.json.JSONArray;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
//        //每次一接受到请求，就返回一个JSON数据
//        List<User> list =new ArrayList<>();
//        Random random =new Random();
//        for (int i = 0; i<20;i++){
//            User u = new User();
//            u.setUname("user:"+i);
//            u.setGender( random.nextBoolean()?"男":"女");
//            u.setAge(i+"");
//
//            list.add(u);
//        }
//        //使用json-lib包中的工具类，将集合users转换成JSON数据
//        JSONArray jsonArray =JSONArray.fromObject(list);
//        resp.getWriter().write(jsonArray.toString());
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/querymany", "root", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            List<User> query = new Query().query(con, "select * from hw_user ",
                    new BeanListHandler<User>(User.class));
            JSONArray jsonArray =JSONArray.fromObject(query);
                    resp.getWriter().write(jsonArray.toString());


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
