package com.yang;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class datasource {
    public static void main(String[] args) throws SQLException {
        initDatasource();
        try(Connection c=getConnection()){
            String sql="select * from exam_result where english > ? and chinese > ?";
           try(PreparedStatement s=c.prepareStatement(sql)){
               //s.setInt(1,EI);
               //s.setInt(2,EI);
               try(ResultSet r=s.executeQuery()){
                   r.getString(1);
                   r.getString(2);
               }
           }
        }
    }
    private static DataSource dataSource=null;
    private static void initDatasource(){
        MysqlDataSource mysqlDataSource=new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("hjb_0730");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
