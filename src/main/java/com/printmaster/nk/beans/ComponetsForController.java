package com.printmaster.nk.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.Product;
import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.Scanner;
import com.printmaster.nk.model.UseWithProduct;

@Component
public class ComponetsForController {

	private Logger logger = Logger.getLogger(ComponetsForController.class);
	
	@Autowired
	public ReclamOnSite reklam;

	public ArrayList<JSONObject> showSimplestArrayOfPrinter(Set<Printer> set){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(Printer currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			standartOutPutDataOfProduct(currentProduct, curObj);

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	public ArrayList<JSONObject> showSimplestArrayOfPrinter3D(Set<Printer3D> set){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(Printer3D currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			standartOutPutDataOfProduct(currentProduct, curObj);

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	public ArrayList<JSONObject> showSimplestArrayOfDigitalPrinter(Set<DigitalPrinter> set){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(DigitalPrinter currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			standartOutPutDataOfProduct(currentProduct, curObj);

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	public ArrayList<JSONObject> showSimplestArrayOfCutter(Set<Cutter> set){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(Cutter currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			standartOutPutDataOfProduct(currentProduct, curObj);

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	public ArrayList<JSONObject> showSimplestArrayOfLaminator(Set<Laminator> set){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(Laminator currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			standartOutPutDataOfProduct(currentProduct, curObj);

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	public ArrayList<JSONObject> showSimplestArrayOfLaser(Set<Laser> set){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(Laser currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			standartOutPutDataOfProduct(currentProduct, curObj);

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	public ArrayList<JSONObject> showSimplestArrayOfScanner(Set<Scanner> set){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(Scanner currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			standartOutPutDataOfProduct(currentProduct, curObj);

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<JSONObject> showSimplestArrayOfRip(Set<Rip> set){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(Rip currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			curObj.put("id", currentProduct.getId());
			curObj.put("partNumber", currentProduct.getPartNumber());
			
			curObj.put("leftSharesLink", currentProduct.getLeftSharesLink());
			curObj.put("leftSharesLinkColorText", currentProduct.getLeftSharesLinkColorText());
			curObj.put("leftSharesLinkColorFone", currentProduct.getLeftSharesLinkColorFone());
			
			curObj.put("rightSharesLink", currentProduct.getRightSharesLink());
			curObj.put("rightSharesLinkColorText", currentProduct.getRightSharesLinkColorText());
			curObj.put("rightSharesLinkColorFone", currentProduct.getRightSharesLinkColorFone());
			
			curObj.put("prise", currentProduct.getPrise());
			curObj.put("name", currentProduct.getName());
			curObj.put("pathPictures", currentProduct.getPathPictures());

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<JSONObject> showSimplestArrayOfUseWithProduct(Set<UseWithProduct> set){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(UseWithProduct currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			curObj.put("id", currentProduct.getId());
			curObj.put("partNumber", currentProduct.getPartNumber());
			curObj.put("prise", currentProduct.getPrise());
			curObj.put("name", currentProduct.getName());
			curObj.put("pathPictures", currentProduct.getPathPictures());
			curObj.put("typeProduct", currentProduct.getTypeProduct());

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<JSONObject> showSimplestArray(Set<? extends Product> set, String type){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(Product currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			standartOutPutDataOfProduct(currentProduct, curObj);
			curObj.put("type", type);

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<JSONObject> showSimplestArrayWichCheckboxes(Set<? extends Product> set, String type){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(Product currentProduct : set){
			JSONObject curObj = new JSONObject();
			
			standartOutPutDataOfProduct(currentProduct, curObj);
			curObj.put("type", type);
			curObj.put("showOnSite", currentProduct.isShowOnSite());
			curObj.put("showOnHomePage", currentProduct.isShowOnHomePage());
			curObj.put("showOnLeftSide", currentProduct.isShowOnLeftSide());

			arrayResult.add(curObj);
		}
		return arrayResult;
	}

	@SuppressWarnings("unchecked")
	private void standartOutPutDataOfProduct(Product currentProduct, JSONObject curObj) {
		curObj.put("id", currentProduct.getId());
		curObj.put("partNumber", currentProduct.getPartNumber());
		
		curObj.put("leftSharesLink", currentProduct.getLeftSharesLink());
		curObj.put("leftSharesLinkColorText", currentProduct.getLeftSharesLinkColorText());
		curObj.put("leftSharesLinkColorFone", currentProduct.getLeftSharesLinkColorFone());
		
		curObj.put("rightSharesLink", currentProduct.getRightSharesLink());
		curObj.put("rightSharesLinkColorText", currentProduct.getRightSharesLinkColorText());
		curObj.put("rightSharesLinkColorFone", currentProduct.getRightSharesLinkColorFone());
		
		curObj.put("prise", currentProduct.getPrise());
		curObj.put("name", currentProduct.getName());
		curObj.put("pathPictures", currentProduct.getPathPictures());
	}
		
    public void updateInLeftField(Product product, boolean isShow, String typeProduct){
		
    	ReklamProduct reklamProduct = new ReklamProduct();
        reklamProduct.setType(typeProduct);
        reklamProduct.setId(product.getId());
        reklamProduct.setPartNumber(product.getPartNumber());
        
        reklamProduct.setLeftSharesLink(product.getLeftSharesLink());
        reklamProduct.setLeftSharesLinkColorText(product.getLeftSharesLinkColorText());
        reklamProduct.setLeftSharesLinkColorFone(product.getLeftSharesLinkColorFone());
        
        reklamProduct.setRightSharesLink(product.getRightSharesLink());
        reklamProduct.setRightSharesLinkColorText(product.getRightSharesLinkColorText());
        reklamProduct.setRightSharesLinkColorFone(product.getRightSharesLinkColorFone());
        
        reklamProduct.setPathToPicture(product.getPathPictures().get(0));
        reklamProduct.setNameProduct(product.getName());
        reklamProduct.setPriceProduct(product.getPrise());       
 	
        if(isShow){
        	reklam.addReklam(reklamProduct); 
        } else {
        	reklam.deleteReklam(reklamProduct);
        }
             
    }
    
    public void updateInLeftField(Rip product, boolean isShow){
		
    	ReklamProduct reklamProduct = new ReklamProduct();
        reklamProduct.setType("rip");
        reklamProduct.setId(product.getId());
        reklamProduct.setPartNumber(product.getPartNumber());
        
        reklamProduct.setLeftSharesLink(product.getLeftSharesLink());
        reklamProduct.setLeftSharesLinkColorText(product.getLeftSharesLinkColorText());
        reklamProduct.setLeftSharesLinkColorFone(product.getLeftSharesLinkColorFone());
        
        reklamProduct.setRightSharesLink(product.getRightSharesLink());
        reklamProduct.setRightSharesLinkColorText(product.getRightSharesLinkColorText());
        reklamProduct.setRightSharesLinkColorFone(product.getRightSharesLinkColorFone());
        
        reklamProduct.setPathToPicture(product.getPathPictures().get(0));
        reklamProduct.setNameProduct(product.getName());
        reklamProduct.setPriceProduct(product.getPrise());       
 	
        if(isShow){
        	reklam.addReklam(reklamProduct); 
        } else {
        	reklam.deleteReklam(reklamProduct);
        }
             
    }
    
    public void updateInLeftField(UseWithProduct product, boolean isShow){
		
    	ReklamProduct reklamProduct = new ReklamProduct();
        reklamProduct.setType("use_with_product");
        reklamProduct.setId(product.getId());
        reklamProduct.setPartNumber(product.getPartNumber());
        
        reklamProduct.setPathToPicture(product.getPathPictures().get(0));
        reklamProduct.setNameProduct(product.getName());
        reklamProduct.setPriceProduct(product.getPrise());       
 	
        if(isShow){
        	reklam.addReklam(reklamProduct); 
        } else {
        	reklam.deleteReklam(reklamProduct);
        }
             
    }

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
    
    public void removePicture(String type, String namePicture, PicturesContainer files){
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
}
