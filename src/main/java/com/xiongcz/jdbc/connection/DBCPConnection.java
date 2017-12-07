package com.xiongcz.jdbc.connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPConnection {
    static Logger log = Logger.getLogger(MysqlConnection.class);

    //使用jcbc连接mysql
    public static void main (String[] args){
        Connection connection=null;
        Statement statement=null;

        try {
/*            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2. 获取数据库连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/stc",
                    "root",
                    "mysql"
            );*/
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/stc");
            dataSource.setUsername("root");
            dataSource.setPassword("mysql");

            connection =dataSource.getConnection();
            //3. 创建会话
            statement = connection.createStatement();

            //4. 执行数据库操作
            statement.execute("INSERT INTO students (id, name) VALUES (5,'c')");

        } /*catch (ClassNotFoundException e) {
            log.error("jdbc drivier not found");
            e.printStackTrace();
        }*/catch (SQLException e) {
            log.error("数据库连接失败"+e.getMessage());
            e.printStackTrace();
        }finally {
            //5. 关闭连接
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
