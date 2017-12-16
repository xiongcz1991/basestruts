package com.xiongcz.hibernate.onetomany.dao;


import com.xiongcz.hibernate.onetomany.entity.Clazz;
import com.xiongcz.hibernate.onetomany.entity.Student;
import com.xiongcz.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClazzDaoTest {
    @Test
    public void testSave(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        ClazzDao clazzDao = new ClazzDao();
        clazzDao.setSession(session);

        Clazz clazz = new Clazz();
        clazz.setCname("三一");
        clazz.setStudents(new ArrayList<Student>());
        List<Student> students = clazz.getStudents();
        for (int i=1;i<=10;i++){
            Student student = new Student();
            student.setAge(18+i);
            student.setName("xiongcz"+i);
            students.add(student);
        }
        clazzDao.save(clazz);

    }

/*    @Test
    public void testGetStudent() {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        com.xiongcz.hibernate.crud.dao.StudentDao studentDao = new com.xiongcz.hibernate.crud.dao.StudentDao();
        studentDao.setSession(session);
        Student student = studentDao.getStudent(1);
        System.out.println(student);
        studentDao.release();
    }

    @Test
    public void testDelStudent(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        com.xiongcz.hibernate.crud.dao.StudentDao studentDao = new com.xiongcz.hibernate.crud.dao.StudentDao();
        studentDao.setSession(session);
        studentDao.delStudent(1);
        studentDao.release();
    }

    @Test
    public void testModStudent(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        com.xiongcz.hibernate.crud.dao.StudentDao studentDao = new StudentDao();
        studentDao.setSession(session);
        Student student = new Student();
        student.setId(2);
        student.setName("pingyuan");
        studentDao.modStudent(student);
        studentDao.release();
    }*/
}
