package com.xiongcz.jdbc.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C3p0Connection {
    static Logger log = Logger.getLogger(DataSourceConnection.class);

    //使用jcbc连接mysql
    public static void main (String[] args){
        Connection connection=null;
        Statement statement=null;

        try {
            /*MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/stc");
            dataSource.setUser("root");
            dataSource.setPassword("mysql");*/
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/stc");
            dataSource.setUser("root");
            dataSource.setPassword("mysql");

            connection= dataSource.getConnection();
            //3. 创建会话
            statement = connection.createStatement();

            //4. 执行数据库操作
            statement.execute("INSERT INTO students (id, name) VALUES (4,'b')");

        /*} catch (ClassNotFoundException e) {
            log.error("jdbc drivier not found");
            e.printStackTrace();
        */}catch (SQLException e) {
            log.error("数据库连接失败"+e.getMessage());
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } finally {
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
