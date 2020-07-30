package com.yang;

import java.sql.*;

public class try_with_resource {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://127.0.0.1:3306/hjb_0730?useSSL=false&characterEncoding=utf8";
        String user="root";
        String password="sg7188916";
        try(Connection connection= DriverManager.getConnection(url,user,password)){
            try(Statement s=connection.createStatement()){
                String sql="show tables";
               try(ResultSet r=s.executeQuery(sql)){
                   while(r.next()){
                       System.out.println(r.getString(1));
                   }
               }
            }
        }
    }
}
