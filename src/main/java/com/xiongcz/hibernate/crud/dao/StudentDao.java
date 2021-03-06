package com.xiongcz.hibernate.crud.dao;

import com.xiongcz.hibernate.crud.entity.Student;
import org.hibernate.Session;

public class StudentDao {
    private Session session;
    public void save(Student s){
        session.beginTransaction();
        /*Student student = new Student();
        student.setId(1);
        student.setName("joker");
        student.setAge(21);*/
        session.save(s);
        session.getTransaction().commit();
    }

    public Student getStudent(int id){
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();

        return student;
    }

    public void delStudent(int id){
        session.beginTransaction();
        Student student = new Student();
        student.setId(id);
        session.delete(student);
        session.getTransaction().commit();
    }

    public void modStudent(Student s){
        session.beginTransaction();
        session.update(s);
        session.getTransaction().commit();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void release(){
        if (session!=null){
            session.close();
        }
    }
}
