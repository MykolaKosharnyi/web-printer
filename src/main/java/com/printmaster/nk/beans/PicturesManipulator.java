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
	    			logger.info(String.format("Load pictures from %s folder, with id=%d to the FILEMETA.", directory, id));
				} catch (IOException e) {
					logger.error(String.format("Can't load pistures from %s folder, with id=%d to the FILEMETA", directory, id), e);
				}
	    		files.add(fm);
	    	}
	}
	
    public List<String> createFolderAndWriteToItPictures(String directory, String concreteFolder, long id, PicturesContainer files){
		
    	List<String> pictures = new ArrayList<String>();
		
		if(new File(directory + File.separator + 
        		concreteFolder + File.separator + id).mkdir()){
        	logger.info(String.format("Load pictures from %s folder, with id=%d to the FILEMETA.", directory, id));        	
        } else {
        	logger.error(String.format("Don't create new %s folder!", directory));
        }
        
		if (files != null && files.size()!=0) {
			for (FileMeta fm : files.getFiles()) {
				try {
					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
							directory + File.separator + concreteFolder
		    				+ File.separator + id + File.separator + fm.getFileName()));
					pictures.add(fm.getFileName());
					logger.info(String.format("Add path of the pictures to %s with id=%d", directory, id));      
				} catch (IOException e) {
					logger.error(String.format("Can't add paths of the pictures to %s with id=%d", directory, id), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
    					concreteFolder + File.separator + id + File.separator + "default.jpg"));
    			pictures.add("default.jpg");
    			logger.info(String.format("User didn't add any picture to the %s with id=%d, so picture of the product will has name 'default.jpg' ",
    					directory, id));
			} catch (IOException e) {
				logger.error(String.format("Can't add path of the default picture to %s with id=%d", directory, id), e);
			}
		}
		
		return pictures;
	}
	
    public void changeOrderPictures(String type, List<String> selectedIds, PicturesContainer files){
    	logger.info(String.format("change order of pictures in %s section, in FILEMETA", type));    
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
		logger.info(String.format("remove picture with name '%s' from FILEMETA, in %s section", namePicture, type));  
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
            
            logger.info(String.format("pictute added to the FILEMETA successful - %s", fileMeta.getFileName()));  
            files.add(fileMeta);
        }  
    	return fileName;
    }
	
	public String uploadPictureToExistedProduct(MultipartHttpServletRequest request, String directory, String concreteFolder, long id) {
		return uploadPicture(request, directory, concreteFolder, Long.toString(id));
	}
	
	public String uploadPicture(MultipartHttpServletRequest request, String directory, String concreteFolder, String subject) {
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
						+ File.separator + subject + File.separator + fileName));
			} catch (IOException e) {
				logger.error("Don't write picture to the folder", e);
			}

		}
		return fileName;
	}
	
    public void removePicture(String name, String directory, String concreteFolder, long id){
    	removePicture( name,  directory,  concreteFolder,  Long.toString(id));
    }
    
    public void removePicture(String name, String directory, String concreteFolder, String subjectFolder){
    	try {
    		FileUtils.forceDelete(new File(directory + File.separator + concreteFolder + File.separator + subjectFolder + File.separator + name));
		} catch (IOException e) {
			logger.error(String.format("Can't delete picture from %s folder, in concrete = %d, with name = %s", concreteFolder, subjectFolder, name), e);
		} 
    }
	
    public void loadDefaultPicture(String directory, String concreteFolder, long id){
    	File fi = new File(directory + File.separator + "default.jpg");
		try {
			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
					directory + File.separator + concreteFolder + File.separator + id + File.separator + "default.jpg"));
		} catch (IOException e) {
			logger.error(String.format("Can't load the default picture to %s folder, with id = %d", concreteFolder, id), e);
		}
    }
	
    public void removeAllPricturesOfConcreteProduct(String directory, String concreteFolder, long id){
    	try {
    		FileUtils.deleteDirectory(new File(directory + File.separator + 
    				concreteFolder + File.separator + id));
    		logger.info(String.format("deleted all pictures from %s folder, with id = %d", concreteFolder, id));
		} catch (IOException e) {
			logger.error(String.format("Deleting all pictures from %s folder, with id = %d, has a problem: ", concreteFolder, id), e);
		}
    }

	public void createDirectoryForPictures(String directory, String concreteFolder, long id) {
		if(new File(directory + File.separator + concreteFolder + File.separator + id).mkdir()){
        	logger.info(String.format("Create new folder for %s with id=%d.", concreteFolder, id));        	
        } else {
        	logger.error(String.format("Don't create new %s folder!", concreteFolder));
        }
	}

}
