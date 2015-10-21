package com.printmaster.nk.dao;

import java.util.List;

import com.printmaster.nk.model.Picture;

public interface PictureDAO {
	 
	public int addPicture(Picture p);
	public void updatePicture(Picture p);
	public List<Picture> listPictures();
	public Picture getPictureById(int id);
	public void removePicture(int id);
    
}
