package com.yang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class MYSQLClient {

    private static String host="127.0.0.1";
    private static int port=3306;
    private static String user=null;
    private static String password="";
    private static String database=null;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        if(args.length==0){
            printUsageAndExit();
        }
        parseArguments(args);
       /* System.out.println(host);
        System.out.println(port);
        System.out.println(user);
        System.out.println(password);
        System.out.println(database);*/
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://%s:%d/%s?useSSL=false&characterEncoding=utf8",host,port,database;
        Connection connection = DriverManager.getConnection(url, user, password);
        printWelcome();
        Scanner scan=new Scanner(System.in);
        System.out.println("mysql> ");
        while(true){
            String cmd=scan.nextLine();
            if(cmd.equalsIgnoreCase("quit")){
                break;
            }
        }
        connection.close();

    }

    private static void printWelcome() {
        System.out.println("欢迎使用 mysqlclient");
    }

    private static void parseArguments(String[] args) {
        database=args[args.length-1];
        args=Arrays.copyOfRange(args,0,args.length-1);
        for (int i = 0; i < args.length; i++) {
            String arg=args[i];
            switch(arg){
                case "--help":
                    printUsageAndExit();
                case "-h":
                case "--host":
                    host=args[++i];
                    break;
                case "-P":
                case "--port":
                    port=Integer.parseInt(args[++i]);
                    break;
                case "-u":
                case "--user":
                    user=args[++i];
                    break;
                case "-p":
                case "--password":
                    password=args[++i];
                    break;
                default:
                    printUsageAndExit("不认识的选项: " + arg);
            }
        }
    }

    private static void printUsageAndExit(String... messages) {
        System.out.println("使用帮助: mysql [OPTIONS] [database]");
        System.out.println(" --help 打印帮助信息");
        System.out.println(" -h, --host 连接主机，默认是 127.0.0.1");
        System.out.println(" -p, --port 连接端口，默认是3306");
        System.out.println(" -u, --user mysql用户名，必须设置");
        System.out.println(" -p, --password mysql 密码");
        Arrays.stream(messages).peek(System.out::println);
    }

}
