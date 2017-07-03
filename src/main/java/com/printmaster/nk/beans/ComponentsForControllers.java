package com.printmaster.nk.beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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

import com.printmaster.nk.model.entity.Cutter;
import com.printmaster.nk.model.entity.DigitalPrinter;
import com.printmaster.nk.model.entity.HeadProduct;
import com.printmaster.nk.model.entity.Laminator;
import com.printmaster.nk.model.entity.Laser;
import com.printmaster.nk.model.entity.Printer;
import com.printmaster.nk.model.entity.Printer3D;
import com.printmaster.nk.model.entity.Product;
import com.printmaster.nk.model.entity.Rip;
import com.printmaster.nk.model.entity.Scanner;
import com.printmaster.nk.model.entity.UseWithProduct;

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
			model.addAttribute(typeOfProduct, getShowedProperty(jsonObjectParser(typeOfProduct))); 
			
    	} else if(typeOfProduct.equals("rip")){// rip has JSONArray in his structure
    		model.addAttribute(typeOfProduct , jsonArrayParser(typeOfProduct));		
    		
    	} else if(typeOfProduct.equals("3d_printer")){//bad naming of attribute in 3d printers
    		model.addAttribute("printer" , jsonObjectParser(typeOfProduct));  
    		
    	} else {
    		model.addAttribute(typeOfProduct , jsonObjectParser(typeOfProduct));   		
    	}
	}
    
    /**
     * This method for getting JSON's of products characteristic for change them
     * @param model
     * @param typeOfProduct
     */
    public void setJSONtoModelAttributeForChanging(Model model, String typeOfProduct){
    	 if(typeOfProduct.equals("rip")){// rip has JSONArray in his structure
    		model.addAttribute("product" , jsonArrayParser(typeOfProduct));		
    		
    	} else {
    		model.addAttribute("product" , jsonObjectParser(typeOfProduct));   		
    	}
	}
    
    public JSONObject jsonObjectParser(String typeOfProduct){
    	try {
			return (JSONObject)new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/" + typeOfProduct + ".json"), "UTF-8"));
		} catch (IOException | ParseException e) {
			logger.error("Error in read " + typeOfProduct + ".json file", e);
			throw new RuntimeException(e);
		}
    }
    
    public JSONArray jsonArrayParser(String typeOfProduct){
    	try {
			return (JSONArray)new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/" + typeOfProduct + ".json"), "UTF-8"));
		} catch (IOException | ParseException e) {
			logger.error("Error in read " + typeOfProduct + ".json file", e);
			throw new RuntimeException(e);
		}
    }
    
    public boolean isParameterRepeated(String typeProduct, String nameParameter, String nameToCheck){
    	boolean isNoRepead = true;
    	
    	String check = nameToCheck.trim();
    	
    	if(typeProduct.equals("rip")){
   		 jsonArrayParser(typeProduct);		
   		
	   	} else {
	   		JSONObject jsonWithCharakteristic = jsonObjectParser(typeProduct);   
	   		JSONArray arrayParameters = (JSONArray) jsonWithCharakteristic.get(nameParameter);
	   		
	   		@SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = arrayParameters.iterator();
			while(iterator.hasNext()){
				JSONObject current = iterator.next();
				if(current.get("name").toString().equalsIgnoreCase(check)){
					isNoRepead= false;
					break;
				}
			}
	   	}
    	
    	return isNoRepead;
    }
    
    /**
     * For properties which used in internationalization
     * @param typeProduct
     * @param nameParameter
     * @param nameToCheck
     * @return
     */
    public boolean isParameterRepeatedI(String typeProduct, String nameParameter, String nameToCheck){
    	boolean isNoRepead = true;
    	
    	String check = nameToCheck.trim();
    	
    	if(typeProduct.equals("rip")){
   		 jsonArrayParser(typeProduct);		
   		
	   	} else {
	   		JSONObject jsonWithCharakteristic = jsonObjectParser(typeProduct);   
	   		JSONArray arrayParameters = (JSONArray) jsonWithCharakteristic.get(nameParameter);
	   		
	   		@SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = arrayParameters.iterator();
			while(iterator.hasNext()){
				JSONObject current = iterator.next();
				if(current.get("ru").toString().equalsIgnoreCase(check)){
					isNoRepead= false;
					break;
				}
			}
	   	}
    	
    	return isNoRepead;
    }
    
    public void showValueOfParameter(String typeProduct, String nameParameter, List<String> values){

    	if(typeProduct.equals("rip")){
    		 jsonArrayParser(typeProduct);		
    		
    	} else {
    		JSONObject jsonWithCharakteristic = jsonObjectParser(typeProduct);   
    		setParametersToShow(jsonWithCharakteristic, nameParameter, values);
    		saveObject(jsonWithCharakteristic, typeProduct);
    	}
    }
    
    public void setNewValueOfParameter(String typeProduct, String nameParameter, String value){

    	if(typeProduct.equals("rip")){
    		 jsonArrayParser(typeProduct);		
    		
    	} else {
    		JSONObject jsonWithCharakteristic = jsonObjectParser(typeProduct);   
    		setNewParameters(jsonWithCharakteristic, nameParameter, value);
    		saveObject(jsonWithCharakteristic, typeProduct);
    	}
    }
    
    public void setNewValueOfParameterI(String typeProduct, String nameParameter, String value){

    	if(typeProduct.equals("rip")){
    		 jsonArrayParser(typeProduct);		
    		
    	} else {
    		JSONObject jsonWithCharakteristic = jsonObjectParser(typeProduct);   
    		setNewParametersI(jsonWithCharakteristic, nameParameter, value);
    		saveObject(jsonWithCharakteristic, typeProduct);
    	}
    }
    
    @SuppressWarnings("unchecked")
	private JSONObject setParametersToShow(JSONObject changedObject, String nameParameter, List<String> values){
    	JSONArray arrayParameters = (JSONArray) changedObject.get(nameParameter);
    	
    	Iterator<JSONObject> iterator = arrayParameters.iterator();
		while(iterator.hasNext()){
			JSONObject current = iterator.next();
			current.put("show", values.contains(current.get("name")));
		}
		
		 Collections.sort(arrayParameters, new Comparator<JSONObject>(){
			@Override
			public int compare(JSONObject o1, JSONObject o2) {
				return ((String) o1.get("name")).toLowerCase().compareTo(((String) o2.get("name")).toLowerCase());
			}
		});
		
    	changedObject.put(nameParameter, arrayParameters);
    	return changedObject;
    }
    
    @SuppressWarnings("unchecked")
	private JSONObject setNewParameters(JSONObject changedObject, String nameParameter, String value){
    	JSONArray arrayParameters = (JSONArray) changedObject.get(nameParameter);
    	
    	JSONObject newValue = new JSONObject();
    	newValue.put("name", value);
    	newValue.put("show", true);
    	arrayParameters.add(newValue);
		
		 Collections.sort(arrayParameters, new Comparator<JSONObject>(){
			@Override
			public int compare(JSONObject o1, JSONObject o2) {
				return ((String) o1.get("name")).toLowerCase().compareTo(((String) o2.get("name")).toLowerCase());
			}
		});
		
    	changedObject.put(nameParameter, arrayParameters);
    	return changedObject;
    }
    
    @SuppressWarnings("unchecked")
	private JSONObject setNewParametersI(JSONObject changedObject, String nameParameter, String value){
    	JSONArray arrayParameters = (JSONArray) changedObject.get(nameParameter);
    	
    	JSONObject newValue = new JSONObject();
    	newValue.put("ru", value);
    	newValue.put("en", value);
    	newValue.put("show", true);
    	arrayParameters.add(newValue);
		
		 Collections.sort(arrayParameters, new Comparator<JSONObject>(){
			@Override
			public int compare(JSONObject o1, JSONObject o2) {
				return ((String) o1.get("ru")).toLowerCase().compareTo(((String) o2.get("ru")).toLowerCase());
			}
		});
		
    	changedObject.put(nameParameter, arrayParameters);
    	return changedObject;
    }
    
    /**
     * @param obj input JSONObject which we wrote to file in concrete directory.
     */
    public void saveObject(JSONObject jsonWithCharakteristic, String typeProduct){
    	try {
			Writer out = new PrintWriter("/var/www/localhost/products/" + typeProduct + ".json", "UTF-8");
			out.write(jsonWithCharakteristic.toJSONString());
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
    public void saveObject(JSONArray jsonWithCharakteristic, String typeProduct){
    	try {
			Writer out = new PrintWriter("/var/www/localhost/products/" + typeProduct + ".json", "UTF-8");
			out.write(jsonWithCharakteristic.toJSONString());
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
    /**
     * Sort equipment manufacturer of PRINTER product
     * @param corectedJSONObject
     * @return
     */
	@SuppressWarnings("unchecked")
	private JSONObject getShowedProperty(JSONObject corectedJSONObject){
		Set<String> keys = corectedJSONObject.keySet();
		
		for(String key : keys){
			if(!key.equals("type_of_printhead")){
				JSONArray arrayToPick = (JSONArray) corectedJSONObject.get(key);
				JSONArray showedArray = new JSONArray();
				
				Iterator<JSONObject> iterator = arrayToPick.iterator();
				while(iterator.hasNext()){
					JSONObject current = iterator.next();
					
					if(current.containsKey("name")){
						if( (boolean)current.get("show") ){
							showedArray.add(current.get("name"));
						}	
					} else if(current.containsKey("ru")){
						if( (boolean)current.get("show") ){
							showedArray.add(current);
						}
					}
	
				}			
				corectedJSONObject.put(key, showedArray);
			}
		}

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
    public String loadDefaultPicture(String directory, String concreteFolder, long id){
    	return picturesManipulator.loadDefaultPicture(directory, concreteFolder, id);
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
