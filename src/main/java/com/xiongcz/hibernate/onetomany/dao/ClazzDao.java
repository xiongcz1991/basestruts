package com.xiongcz.hibernate.onetomany.dao;


import com.xiongcz.hibernate.onetomany.entity.Clazz;
import org.hibernate.Session;

public class ClazzDao {
    private Session session;
    public void save(Clazz clazz){
        session.beginTransaction();
        session.save(clazz);
        session.getTransaction().commit();
    }

    public Clazz getStudent(int id){
        session.beginTransaction();
        Clazz clazz = session.get(Clazz.class, id);
        session.getTransaction().commit();
        return clazz;
    }

    public void delStudent(int id){
        session.beginTransaction();
        Clazz clazz = new Clazz();
        clazz.setCid(id);
        session.delete(clazz);
        session.getTransaction().commit();
    }

    public void modStudent(Clazz clazz){
        session.beginTransaction();
        session.update(clazz);
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
