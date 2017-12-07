package com.xiongcz.jdbc.connection;


import com.xiongcz.jdbc.dao.StudentDao;
import com.xiongcz.jdbc.model.Student;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MysqlConnection {
    static Logger log = Logger.getLogger(MysqlConnection.class);

    //使用jcbc连接mysql
    public static void main (String[] args){
        Connection connection=null;
        Statement statement=null;

        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2. 获取数据库连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/stc",
                    "root",
                    "mysql"
            );

            //3. 创建会话
            statement = connection.createStatement();

            //4. 执行数据库操作
            //statement.execute("CREATE TABLE students (id INT ,name CHARACTER )");

            Student student = new Student();
            student.setId(7);
            student.setName("z");

            StudentDao studentDao = new StudentDao();
            studentDao.setStatement(statement);

            //studentDao.insertStudent(student);
            //studentDao.deleteStudentById(4);
            //studentDao.updateStudent(student);
            ArrayList<Student> students = studentDao.queryStudentByid(6);
            for (Student s:students) {
                log.info(s.toString());
            }


        } catch (ClassNotFoundException e) {
            log.error("jdbc drivier not found");
            e.printStackTrace();
        }catch (SQLException e) {
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
