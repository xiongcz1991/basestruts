package com.xiongcz.hibernate.dao;

import com.xiongcz.hibernate.entity.Student;
import com.xiongcz.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class StudentDaoTest {
    @Test
    public void testSave(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        StudentDao studentDao = new StudentDao();
        studentDao.setSession(session);
        Student student = new Student();
        student.setId(2);
        student.setName("xiongcz");
        student.setAge(23);
        studentDao.save(student);
        studentDao.release();
    }

    @Test
    public void testGetStudent(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        StudentDao studentDao = new StudentDao();
        studentDao.setSession(session);
        Student student = studentDao.getStudent(1);
        System.out.println(student);
        studentDao.release();
    }

    @Test
    public void testDelStudent(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        StudentDao studentDao = new StudentDao();
        studentDao.setSession(session);
        studentDao.delStudent(1);
        studentDao.release();
    }

    @Test
    public void testModStudent(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        StudentDao studentDao = new StudentDao();
        studentDao.setSession(session);
        Student student = new Student();
        student.setId(2);
        student.setName("pingyuan");
        studentDao.modStudent(student);
        studentDao.release();
    }
}
