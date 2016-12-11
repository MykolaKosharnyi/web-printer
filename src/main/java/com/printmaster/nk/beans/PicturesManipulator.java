package com.printmaster.nk.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * This class all method of work with manipulating pictures in product
 * 
 * @author Mykola Kosharny
 * 
 */
@Component
public class PicturesManipulator {
	
	private Logger logger = Logger.getLogger(PicturesManipulator.class);
	
	public void copyPicturesToBuffer(List<String> pictures, String directory,
    		String concreteFolder, long id, PicturesContainer files){
		 FileMeta fm = null;
	    	for(String path : pictures){
	    		fm = new FileMeta();
	    		fm.setFileName(path);
	    		
	    		try {
	    			File fi = new File(directory + File.separator + 
	    					concreteFolder + File.separator + id + File.separator + path);
	    			fm.setBytes(Files.readAllBytes(fi.toPath()));
	    			logger.info("Load pictures from" + directory + "folder, with id " + id + " to the FILEMETA.");
				} catch (IOException e) {
					logger.error("Can't load pistures from" + directory + "folder, with id " + id + " to the FILEMETA", e);
				}
	    		files.add(fm);
	    	}
	}
	
    public List<String> createFolderAndWriteToItPictures(String directory, String concreteFolder, long id, PicturesContainer files){
		
    	List<String> pictures = new ArrayList<String>();
		
		if(new File(directory + File.separator + 
        		concreteFolder + File.separator + id).mkdir()){
        	logger.info("Create new " + directory + " folder! With id=" + id);
        } else {
        	logger.error("Don't create new " + directory + " folder!");
        }
        
		if (files != null && files.size()!=0) {
			for (FileMeta fm : files.getFiles()) {
				try {
					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
							directory + File.separator + concreteFolder
		    				+ File.separator + id + File.separator + fm.getFileName()));
					pictures.add(fm.getFileName());
					logger.info("Add path of the pictures to " + directory + " with id=" + id);
				} catch (IOException e) {
					logger.error("Can't add paths of the pictures to " + directory + " with id=" + id, e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
    					concreteFolder + File.separator + id + File.separator + "default.jpg"));
    			pictures.add("default.jpg");
    			logger.error("User didn't add any picture to the " + directory + " with id=" + id + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't add path of the default picture to " + directory + " with id=" + id, e);
			}
		}
		
		return pictures;
	}
	
    public void changeOrderPictures(String type, List<String> selectedIds, PicturesContainer files){
    	logger.info("change order of pictures in " + type + "section, in FILEMETA");
    	for(int i = 0; i < selectedIds.size(); i++){
    		for(int k = 0; k < files.size() ; k++){
        		if(files.get(k).getFileName().equals(selectedIds.get(i))){
        			Collections.swap(files.getFiles(), i, k);
        			break;
        		}
        	}
    	}  
    }
	
    public void removePictureFromPicturesContainer(String type, String namePicture, PicturesContainer files){
    	String name = namePicture.replace(":", ".");
		Iterator<FileMeta> fmi = files.getFiles().iterator();
		while(fmi.hasNext()){
    		if(fmi.next().getFileName().equals(name)){
    			fmi.remove();
    			break;
    		}
    	}
		logger.info("Remove picture with name  '" + namePicture + "' from FILEMETA, in" + type + " section ");
    }
	
	public String uploadPictureOnCreationProduct(MultipartHttpServletRequest request, PicturesContainer files){
    	logger.info("upload new picture");
        
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
        String fileName = null;

        while(itr.hasNext()){
            mpf = request.getFile(itr.next()); 
            
            FileMeta fileMeta = new FileMeta();
    		
    		fileName = files.size() + new Random().nextInt(1000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 
            fileMeta.setFileName(fileName);

            try {
               fileMeta.setBytes(mpf.getBytes());
               logger.info("WRITED new picture to the FILEMETA.");
           } catch (IOException e) {
               logger.error("WRITTING picture to the FILEMETA has a problem: ",e);
           }
            
            logger.info("pictute added to the FILEMETA successful - " + fileMeta.getFileName());
            files.add(fileMeta);
        }  
    	return fileName;
    }
	
	public String uploadPictureToExistedProduct(MultipartHttpServletRequest request, String directory, String concreteFolder, long id) {
		logger.info("upload new picture");

		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		String fileName = null;

		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());
			fileName = new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename()
							.lastIndexOf("."))/* last part is file extension */;

			try {
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(directory + File.separator + concreteFolder
						+ File.separator + id + File.separator + fileName));
			} catch (IOException e) {
				logger.error("Don't write picture to the folder", e);
			}

		}
		return fileName;
	}
	
    public void removePicture(String name, String directory, String concreteFolder, long id){
    	try {
    		FileUtils.forceDelete(new File(directory + File.separator + concreteFolder+ File.separator + id + File.separator + name));
		} catch (IOException e) {
			logger.error("Can't delete picture from " + concreteFolder + " folder, with id = " + id + ", with name = " + name, e);
		} 
    }
	
    public void loadDefaultPicture(String directory, String concreteFolder, long id){
    	File fi = new File(directory + File.separator + "default.jpg");
		try {
			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
					directory + File.separator + concreteFolder + File.separator + id + File.separator + "default.jpg"));
		} catch (IOException e) {
			logger.error("Can't load the default picture to " + concreteFolder + " folder, with id = " + id, e);
		}
    }
	
    public void removeAllPricturesOfConcreteProduct(String directory, String concreteFolder, long id){
    	try {
    		FileUtils.deleteDirectory(new File(directory + File.separator + 
    				concreteFolder + File.separator + id));
    		logger.info("deleted all pictures from " + concreteFolder + " folder, with id = " + id);
		} catch (IOException e) {
			logger.error("Deleting all pictures from " + concreteFolder + " folder, with id = " + id + ", has a problem: ", e);
		}
    }

}
