package com.xiongcz.jdbc.connection;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceConnection {
    static Logger log = Logger.getLogger(DataSourceConnection.class);

    //使用jcbc连接mysql
    public static void main (String[] args){
        Connection connection=null;
        Statement statement=null;

        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/stc");
            dataSource.setUser("root");
            dataSource.setPassword("mysql");

            connection= dataSource.getConnection();
            //3. 创建会话
            statement = connection.createStatement();

            //4. 执行数据库操作
            statement.execute("INSERT INTO students (id, name) VALUES (3,'ab')");


        /*} catch (ClassNotFoundException e) {
            log.error("jdbc drivier not found");
            e.printStackTrace();
        */}catch (SQLException e) {
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
