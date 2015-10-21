package com.printmaster.nk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.PictureDAO;
import com.printmaster.nk.model.Picture;

@Service
public class PictureServiceImpl implements PictureService {
     
    private PictureDAO pictureDAO;
 
    public void setPictureDAO(PictureDAO pictureDAO) {
        this.pictureDAO = pictureDAO;
    }
 
    @Override
    @Transactional
    public int addPicture(Picture p) {
        return this.pictureDAO.addPicture(p);
    }
 
    @Override
    @Transactional
    public void updatePicture(Picture p) {
        this.pictureDAO.updatePicture(p);
    }
 
    @Override
    @Transactional
    public List<Picture> listPictures() {
        return this.pictureDAO.listPictures();
    }
 
    @Override
    @Transactional
    public Picture getPictureById(int id) {
        return this.pictureDAO.getPictureById(id);
    }
 
    @Override
    @Transactional
    public void removePicture(int id) {
        this.pictureDAO.removePicture(id);
    }
 
}
