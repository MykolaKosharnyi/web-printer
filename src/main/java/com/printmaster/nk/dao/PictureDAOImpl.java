package com.printmaster.nk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.Picture;

@Repository
public class PictureDAOImpl implements PictureDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(PictureDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public int addPicture(Picture p) {
        Session session = this.sessionFactory.getCurrentSession();
       int id = (Integer) session.save(p);
        logger.info("Picture saved successfully, Picture Details="+p);
        return id;
    }
 
    @Override
    public void updatePicture(Picture p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Picture updated successfully, Picture Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Picture> listPictures() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Picture> pictureList = session.createQuery("from Picture").list();
        for(Picture p : pictureList){
            logger.info("Picture List::"+p);
        }
        return pictureList;
    }
 
    @Override
    public Picture getPictureById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Picture p = (Picture) session.load(Picture.class, new Integer(id));
        logger.info("Picture loaded successfully, Picture details="+p);
        return p;
    }
 
    @Override
    public void removePicture(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Picture p = (Picture) session.load(Picture.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Picture deleted successfully, picture details="+p);
    }
 
}