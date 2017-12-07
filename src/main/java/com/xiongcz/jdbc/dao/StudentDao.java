package com.xiongcz.jdbc.dao;

import com.xiongcz.jdbc.model.Student;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class StudentDao {
    Statement statement;
    Logger logger = Logger.getLogger(Student.class);

    public void insertStudent(Student student){
        try {
            String sql = "INSERT into students (id, name) VALUES ("+student.getId()+","+"'"+student.getName()+"'"+")";
            logger.info(sql);
            boolean execute = statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteStudentById(int id){
        String sql = "delete from students where id = "+id;
        logger.info(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student){
        String sql = "update students set name="+"'"+student.getName()+"'"+"where id="+student.getId();
        logger.info(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<Student> queryStudentByid(int id){
        ArrayList<Student> list = new ArrayList<Student>();
        String sql = "select * from students where id="+id;
        logger.info(sql);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            Student student;
            while(resultSet.next()){
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                list.add(student);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
