package com.printmaster.nk.beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.Product;
import com.printmaster.nk.model.HeadProduct;
import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.Scanner;
import com.printmaster.nk.model.UseWithProduct;

@Component
public class ComponentsForControllers {

	private Logger logger = Logger.getLogger(ComponentsForControllers.class);
	
	@Autowired
	public ReclamOnSite reklam;
	
	@Autowired
	public PicturesManipulator picturesManipulator;
	
	/**
	 * This method made every product more lightweight(without some characteristic),
	 * it was done for make products page more lightweight (for higher speed loading).
	 * 
	 * @param set input collection which we need to make lightweight
	 * @return lightweight version of input collection
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<JSONObject> makeLightWeightCollectionOfProduct(Set<? extends Product> set){
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
			
		for (Product currentProduct : set) {
			JSONObject curObj = new JSONObject();

			standartOutPutDataOfProduct(currentProduct, curObj);
			
			// add characteristic for concrete type product
			if (currentProduct instanceof Printer) {
				curObj.put("type", "printer");
				
				//add property that must be output only to printer at current time(in the future to all product)
				curObj.put("ratingOverallRating", ((Printer)currentProduct).getRatingOverallRating());
				//type of printhead
				curObj.put("typeOfPrinthead", ((Printer)currentProduct).getTypeOfPrinthead());
				//print resolution
				curObj.put("printResolution", ((Printer)currentProduct).getPrintResolution());
				curObj.put("inputFirstPrintResolution", ((Printer)currentProduct).getInputFirstPrintResolution());
				curObj.put("inputSecondPrintResolution", ((Printer)currentProduct).getInputSecondPrintResolution());
				//chromaticity
				curObj.put("chromaticity", ((Printer)currentProduct).getChromaticity());
				curObj.put("chromaticityCMYK", ((Printer)currentProduct).getChromaticityCMYK());
				curObj.put("chromaticityCMYKx2", ((Printer)currentProduct).getChromaticityCMYKx2());
				curObj.put("chromaticityCMYKLcLm", ((Printer)currentProduct).getChromaticityCMYKLcLm());
				curObj.put("chromaticityCMYKLcLmOG", ((Printer)currentProduct).getChromaticityCMYKLcLmOG());	

			} else if (currentProduct instanceof Printer3D) {
				curObj.put("type", "3d_printer");

			} else if (currentProduct instanceof DigitalPrinter) {
				curObj.put("type", "digital_printer");

			} else if (currentProduct instanceof Cutter) {
				curObj.put("type", "cutter");

			} else if (currentProduct instanceof Laminator) {
				curObj.put("type", "laminator");

			} else if (currentProduct instanceof Laser) {
				curObj.put("type", "laser");

			} else if (currentProduct instanceof Scanner) {
				curObj.put("type", "scanner");

			} else if (currentProduct instanceof Rip) {
				curObj.put("type", "rip");

			} else if (currentProduct instanceof UseWithProduct) {
				curObj.put("type", "use_with_product");
				curObj.put("typeProduct", ((UseWithProduct) currentProduct).getTypeProduct());
			}
			
			arrayResult.add(curObj);
		}
		return arrayResult;
	}	
	
	/**
	 * This method made every product more lightweight(without some characteristic),
	 * it was done for make products page more lightweight (for higher speed loading).
	 * 
	 * @param set input collection which we need to make lightweight
	 * @return lightweight version of input collection
	 */
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
			curObj.put("top", currentProduct.isTop());

			arrayResult.add(curObj);
		}
		return arrayResult;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<JSONObject> showSimplestArrayWichCheckboxes(Set<? extends HeadProduct> set, String type){
		
		ArrayList<JSONObject> arrayResult = new ArrayList<JSONObject>();
		for(HeadProduct currentProduct : set){
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

	/**
	 * Standard data characteristic of product which must be output in all
	 * types of product.
	 * 
	 * @param currentProduct
	 * @param curObj
	 */
	@SuppressWarnings("unchecked")
	private void standartOutPutDataOfProduct(Product currentProduct, JSONObject curObj) {
		curObj.put("top", currentProduct.isTop());
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
    
    /**
     * Adding to model json file with characteristic of this type product
     * @param model in which added json file of this type of product
     * @param typeOfProduct
     */
    public void setJSONtoModelAttribute(Model model, String typeOfProduct){
    	if(typeOfProduct.equals("printer")){//separate for printers because they need to sort by equipment
    		
    		try {
				model.addAttribute(typeOfProduct, sortEquipment((JSONObject)new JSONParser()
						.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/" + typeOfProduct + ".json"), "UTF-8"))));
			} catch (IOException | ParseException e) {
				logger.error("Error in read " + typeOfProduct + ".json file", e); 
			}
    		
    	} else if(typeOfProduct.equals("rip")){// rip has JSONArray in his structure
    		
    		try {
    			model.addAttribute(typeOfProduct , (JSONArray)new JSONParser()
    					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/" + typeOfProduct + ".json"), "UTF-8")));
    		} catch (IOException | ParseException e) {
    			logger.error("Error in read " + typeOfProduct + ".json file", e); 
    		}
    		
    	} else if(typeOfProduct.equals("3d_printer")){//bad naming of attribute in 3d printers
    		
    		try {
    			model.addAttribute("printer" , (JSONObject)new JSONParser()
    					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/" + typeOfProduct + ".json"), "UTF-8")));
    		} catch (IOException | ParseException e) {
    			logger.error("Error in read " + typeOfProduct + ".json file", e); 
    		}
    		
    	} else {
    		
    		try {
    			model.addAttribute(typeOfProduct , (JSONObject)new JSONParser()
    					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/" + typeOfProduct + ".json"), "UTF-8")));
    		} catch (IOException | ParseException e) {
    			logger.error("Error in read " + typeOfProduct + ".json file", e); 
    		}
    		
    	}
	}
    
    /**
     * Sort equipment manufacturer of PRINTER product
     * @param corectedJSONObject
     * @return
     */
	@SuppressWarnings("unchecked")
	private JSONObject sortEquipment(JSONObject corectedJSONObject){
		JSONArray arrayToSort = (JSONArray) corectedJSONObject.get("equipment_manufacturer");

		Collections.sort(arrayToSort);
		
		corectedJSONObject.put("equipment_manufacturer", arrayToSort);
		return corectedJSONObject;
	}
	
	/**
	 * This method used when one product must to be copy and we don't know id of
	 * new product so we must keep those pictures in buffer. 
	 * 
	 * @param pictures
	 * @param directory
	 * @param concreteFolder
	 * @param id
	 * @param files
	 */
	public void copyPicturesToBuffer(List<String> pictures, String directory,
    		String concreteFolder, long id, PicturesContainer files){
		picturesManipulator.copyPicturesToBuffer(pictures, directory, concreteFolder, id, files);
	}
    
	/**
	 * This method called when it had finished to add new product. It's just save pictures 
	 * from buffer to concrete folder on server.
	 * 
	 * @param directory
	 * @param concreteFolder
	 * @param id
	 * @param files
	 * @return
	 */
    public List<String> createFolderAndWriteToItPictures(String directory, String concreteFolder, long id, PicturesContainer files){
    	return picturesManipulator.createFolderAndWriteToItPictures(directory, concreteFolder, id, files);
	}
    
    /**
     * Change order pictures in pictures container. This operation change order while creation new product
     * 
     * @param type
     * @param selectedIds
     * @param files
     */
    public void changeOrderPictures(String type, List<String> selectedIds, PicturesContainer files){
    	picturesManipulator.changeOrderPictures(type, selectedIds, files);
    }
    
    /**
     * Remove picture from picture container. This operation remove picture while creation new product
     * 
     * @param type
     * @param namePicture
     * @param files
     */
    public void removePictureFromPicturesContainer(String type, String namePicture, PicturesContainer files){
    	picturesManipulator.removePictureFromPicturesContainer(type, namePicture, files);
    }

	/**
	 * Upload pictures to Files container of this product (files) 
	 * 
	 * @param request which has loaded pictures
	 * @param files file container
	 * @return name of added picture
	 */
	public String uploadPictureOnCreationProduct(MultipartHttpServletRequest request, PicturesContainer files){
		return picturesManipulator.uploadPictureOnCreationProduct(request, files);
    }
	
	/**
	 * Method for loading new picture for concrete existed product
	 * 
	 * @param request contain loaded picture
	 * @param directory
	 * @param concreteFolder
	 * @param id of added product
	 * @return name of added picture
	 */
	public String uploadPictureToExistedProduct(MultipartHttpServletRequest request, String directory, String concreteFolder, long id) {
		return picturesManipulator.uploadPictureToExistedProduct(request, directory, concreteFolder, id);
	}
	
	/**
	 * Uploading picture to concrete folder on server
	 */
	public String uploadPicture(MultipartHttpServletRequest request, String directory, String concreteFolder, String subject) {
		return picturesManipulator.uploadPicture(request, directory, concreteFolder, subject);
	}
	
	/**
	 * Remove picture from concrete product
	 * 
	 * @param name
	 * @param directory
	 * @param concreteFolder
	 * @param id
	 */
    public void removePicture(String name, String directory, String concreteFolder, long id){
    	picturesManipulator.removePicture(name, directory, concreteFolder, id);
    }  
    
    public void removePicture(String name, String directory, String concreteFolder, String concrete){
    	picturesManipulator.removePicture(name, directory, concreteFolder, concrete);
    }
    
    /**
     * Load default picture to concrete product if length of pictures equals to '0'
     * 
     * @param directory
     * @param concreteFolder
     * @param id
     */
    public void loadDefaultPicture(String directory, String concreteFolder, long id){
    	picturesManipulator.loadDefaultPicture(directory, concreteFolder, id);
    }
    
    /**
     * This method delete all pictures when concrete product is deleting
     * 
     * @param directory
     * @param concreteFolder
     * @param id
     */
    public void removeAllPricturesOfConcreteProduct(String directory, String concreteFolder, long id){
    	picturesManipulator.removeAllPricturesOfConcreteProduct(directory, concreteFolder, id);
    }
    
    /**
     * Create directory for keeping pictures concrete product/user
     * 
     * @param directory
     * @param concreteFolder
     * @param id
     */
    public void createDirectoryForPictures(String directory, String concreteFolder, long id){
    	picturesManipulator.createDirectoryForPictures(directory, concreteFolder, id);
    }
}
