package com.printmaster.nk.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
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

@Slf4j

@Component
public class PicturesManipulator {
	private final static String NAME_DEFAULT_PICTURE = "default.jpg";
	
	public void copyPicturesToBuffer(List<String> pictures, String directory, String concreteFolder, long id, PicturesContainer files) {
		FileMeta fm = null;
		for (String path : pictures) {
			fm = new FileMeta();
			fm.setFileName(path);

			try {
				File fi = new File(directory + File.separator + concreteFolder + File.separator + id + File.separator + path);
				fm.setBytes(Files.readAllBytes(fi.toPath()));
				log.info(String.format("Load pictures from %s folder, with id=%d to the FILEMETA.", directory, id));
			} catch (IOException e) {
				log.error(String.format("Can't load pistures from %s folder, with id=%d to the FILEMETA", directory, id),e);
			}
			files.add(fm);
		}
	}
	
	public void createDirectoryForPictures(String directory, String concreteFolder, long id) {
		if(new File(directory + File.separator + concreteFolder + File.separator + id).mkdir()){
        	log.info(String.format("Create new folder for %s with id=%d.", concreteFolder, id));
        } else {
        	log.error(String.format("Don't create new %s folder!", concreteFolder));
        }
	}
	
    public List<String> createFolderAndWriteToItPictures(String directory, String concreteFolder, long id, PicturesContainer files){
		
    	List<String> pictures = new ArrayList<String>();
		
    	createDirectoryForPictures(directory, concreteFolder, id);
        
		if (files != null && files.size()!=0) {
			for (FileMeta fm : files.getFiles()) {
				try {
					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
							directory + File.separator + concreteFolder
		    				+ File.separator + id + File.separator + fm.getFileName()));
					pictures.add(fm.getFileName());
					log.info(String.format("Add path of the pictures to %s with id=%d", directory, id));
				} catch (IOException e) {
					log.error(String.format("Can't add paths of the pictures to %s with id=%d", directory, id), e);
				}
			}
		} else {
			loadDefaultPicture(directory, concreteFolder, id);
    		pictures.add(NAME_DEFAULT_PICTURE);
		}
		
		return pictures;
	}
    
    public String loadDefaultPicture(String directory, String concreteFolder, long id){
    	File fi = new File(directory + File.separator + NAME_DEFAULT_PICTURE);
		try {
			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
					directory + File.separator + concreteFolder + File.separator + id + File.separator + NAME_DEFAULT_PICTURE));
			log.info(String.format("User didn't add any picture to the %s with id=%d, so picture of the product will has name '%s' ",
					directory, id, NAME_DEFAULT_PICTURE));		
		} catch (IOException e) {
			log.error(String.format("Can't load the default picture to %s folder, with id = %d", concreteFolder, id), e);
		}
		
		return NAME_DEFAULT_PICTURE;
    }
	
    public void changeOrderPictures(String type, List<String> selectedIds, PicturesContainer files){
    	log.info(String.format("change order of pictures in %s section, in FILEMETA", type));
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
		log.info(String.format("remove picture with name '%s' from FILEMETA, in %s section", namePicture, type));
    }
	
	public String uploadPictureOnCreationProduct(MultipartHttpServletRequest request, PicturesContainer files){
    	log.info("upload new picture");
        
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
        String fileName = null;

        while(itr.hasNext()){
            mpf = request.getFile(itr.next()); 
            
            FileMeta fileMeta = new FileMeta();
    		
    		fileName = createNameForLoadedPicture(mpf);
            fileMeta.setFileName(fileName);

            try {
               fileMeta.setBytes(mpf.getBytes());
               log.info("WRITED new picture to the FILEMETA.");
           } catch (IOException e) {
               log.error("WRITTING picture to the FILEMETA has a problem: ",e);
           }
            
            log.info(String.format("pictute added to the FILEMETA successful - %s", fileMeta.getFileName()));
            files.add(fileMeta);
        }  
    	return fileName;
    }
	
	public String uploadPictureToExistedProduct(MultipartHttpServletRequest request, String directory, String concreteFolder, long id) {
		return uploadPicture(request, directory, concreteFolder, Long.toString(id));
	}
	
	public String uploadPicture(MultipartHttpServletRequest request, String directory, String concreteFolder, String subject) {
		log.info("upload new picture");

		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		String fileName = null;

		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());
			fileName = createNameForLoadedPicture(mpf);

			try {
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(directory + File.separator + concreteFolder
						+ File.separator + subject + File.separator + fileName));
			} catch (IOException e) {
				log.error("Don't write picture to the folder", e);
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
			log.error(String.format("Can't delete picture from %s folder, in concrete = %d, with name = %s", concreteFolder, subjectFolder, name), e);
		} 
    }
	
    public void removeAllPricturesOfConcreteProduct(String directory, String concreteFolder, long id){
    	try {
    		FileUtils.deleteDirectory(new File(directory + File.separator + 
    				concreteFolder + File.separator + id));
    		log.info(String.format("deleted all pictures from %s folder, with id = %d", concreteFolder, id));
		} catch (IOException e) {
			log.error(String.format("Deleting all pictures from %s folder, with id = %d, has a problem: ", concreteFolder, id), e);
		}
    }

    private String createNameForLoadedPicture(MultipartFile mpf){
    	String extentionOfFile = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part of file extension*/;
    	return System.currentTimeMillis() + "" + extentionOfFile;
    }

}
