package com.xiongcz.hibernate.one2one_foreign.dao;



import com.xiongcz.hibernate.one2one_foreign.entity.Student;
import com.xiongcz.hibernate.one2one_foreign.entity.StudentCard;
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
        StudentCard studentCard = new StudentCard();
        studentCard.setMoney(200);

        Student student = new Student();
        //student.setId(2);
        student.setName("xiongcz");
        student.setAge(23);

        student.setStudentCard(studentCard);
        studentDao.save(student);
        studentDao.release();
    }

    @Test
    public void testGetStudent(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        StudentDao studentDao = new StudentDao();
        studentDao.setSession(session);
        Student student = studentDao.getStudent(2);
        System.out.println(student);
        studentDao.release();
    }

    @Test
    public void testDelStudent(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        StudentDao studentDao = new StudentDao();
        studentDao.setSession(session);
        studentDao.delStudent(2);
        studentDao.release();
    }

    @Test
    public void testModStudent(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        StudentDao studentDao = new StudentDao();
        studentDao.setSession(session);
        Student student = new Student();
        student.setId(3);
        student.setName("pingyuan");
        studentDao.modStudent(student);
        studentDao.release();
    }
}
