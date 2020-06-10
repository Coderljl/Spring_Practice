package com.allen.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.注册驱动
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy","root","970330");
        //3.获取操作数据库预处理对象
        PreparedStatement psql =con.prepareStatement("select * from account");
        //4.执行sql语句，得到结果集
        ResultSet rs =psql.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        psql.close();
        con.close();

    }
}
