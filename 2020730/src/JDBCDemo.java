import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动，挑选数据库
        Class.forName("com.mysql.jdbc.Driver");
        //建立数据库连接
        //写明mysql服务端所在地
        String database="huojianban_0605";
        String user="root";
        String password="sg7188916";
        String url="jdbc:mysql://127.0.0.1:3306/"+database+"?useSSL=false&characterEncoding=utf8";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

        //执行sql语言
        //1.创建Statement对象
        /*Statement statement = connection.createStatement();
        String sql="select * from student_0605";
        ResultSet r=statement.executeQuery(sql);
        while(r.next()){
           String id=r.getString(1);
           String sn=r.getString(2);
           String name=r.getString(3);
           String sex=r.getString(4);
            System.out.println(id);
            System.out.println(sn);
            System.out.println(name);
        }
        statement.close();*/

        Statement statement = connection.createStatement();
        String sql="insert into student_0605 (sn,name,sex) values ('20200730','张三','男')";
        int row = statement.executeUpdate(sql);
        System.out.println(row);
        statement.close();
        connection.close();
    }
}
