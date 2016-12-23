package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.printmaster.nk.beans.ComponentsForControllers;

@Controller
public class PicturesHomePageController {

	private Logger logger = Logger.getLogger(PicturesHomePageController.class);
	
    private String directory = "/var/www/localhost/images";
	
	private static final String PATH_TO_JSON_FILE = "/var/www/localhost/home.json";
	
    @RequestMapping(value="/admin/pictures", method=RequestMethod.GET)
	public ModelAndView addNewPrinter() {
		logger.info("/admin/pictures page.");
	    return new ModelAndView("admin/pictures");
	}
    
    @Autowired
    ComponentsForControllers componets;
    
    
    private class RowPicturesInformation{
		//private String nameRow;
		private List<PictureInformation> picturesInfo;
		
		public RowPicturesInformation(List<PictureInformation> subTypesInfo) {
			this.picturesInfo = subTypesInfo;
		}

		public List<PictureInformation> getPicturesInfo() {
			return picturesInfo;
		}

		public void setPicturesInfo(List<PictureInformation> picturesInfo) {
			this.picturesInfo = picturesInfo;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((picturesInfo == null) ? 0 : picturesInfo.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RowPicturesInformation other = (RowPicturesInformation) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (picturesInfo == null) {
				if (other.picturesInfo != null)
					return false;
			} else if (!picturesInfo.equals(other.picturesInfo))
				return false;
			return true;
		}
		private PicturesHomePageController getOuterType() {
			return PicturesHomePageController.this;
		}
	}
	
	private class PictureInformation{
		private String position;
		private String headOfPage;
		private String nameOfJsonObject;

		public PictureInformation(String nameSubType, String headOfPage, String nameOfJsonArray) {
			this.position = nameSubType;
			this.headOfPage = headOfPage;
			this.nameOfJsonObject = nameOfJsonArray;
		}
		
		public PictureInformation(String nameSubType) {
			this.position = nameSubType;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getHeadOfPage() {
			return headOfPage;
		}

		public void setHeadOfPage(String headOfPage) {
			this.headOfPage = headOfPage;
		}

		public String getNameOfJsonObject() {
			return nameOfJsonObject;
		}

		public void setNameOfJsonObject(String nameOfJsonObject) {
			this.nameOfJsonObject = nameOfJsonObject;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((position == null) ? 0 : position.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PictureInformation other = (PictureInformation) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (position == null) {
				if (other.position != null)
					return false;
			} else if (!position.equals(other.position))
				return false;
			return true;
		}

		private PicturesHomePageController getOuterType() {
			return PicturesHomePageController.this;
		}
	}
    
    
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    /**
	 *  BIG REKLAM 
	 * */
	@RequestMapping(value = "/admin/pictures/big_animation_reklam", method = RequestMethod.GET)
		public ModelAndView showBigReklamAnimation(Model model) {
		logger.info("/admin/pictures/big_animation_reklam page.");

		JSONObject home = (JSONObject) getJsonPicturesLinksContainer().get("homeJSON");

		model.addAttribute("headOfPage", "Изменение изображений центральной рекламы на главном меню");
		model.addAttribute("listPictures", (JSONArray) home.get("listPicturesOfCentralReklam"));

		return new ModelAndView("admin/pictures/big_animation_reklam");
	}

	/**
     * @return JSONObject which contain all links for pictures on home page.
     */
    private JSONObject getJsonPicturesLinksContainer(){
    	JSONParser parser = new JSONParser();
    	
    	JSONObject result = null;
		try {
			result = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
    	
    	return result;
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/admin/pictures/central_reklam/upload_pictures", method = RequestMethod.POST)
    	public @ResponseBody String uploadPictureCentralReklam(MultipartHttpServletRequest request) {
    	
    	logger.info("upload new picture to central reklam on home page"); 	

        String fileName = componets.uploadPicture(request, directory, "home", "big_reklam");

			JSONObject obj = getJsonPicturesLinksContainer();

			JSONObject homeJSON = (obj.get("homeJSON") != null) ? (JSONObject) obj.get("homeJSON"): new JSONObject();

			// check if these sub-directories has pictures
			JSONArray listPicturesOfCentralReklam =  (homeJSON.get("listPicturesOfCentralReklam") != null) ? 
					(JSONArray) homeJSON.get("listPicturesOfCentralReklam") : new JSONArray();

			listPicturesOfCentralReklam.add(fileName);
			homeJSON.put("listPicturesOfCentralReklam", listPicturesOfCentralReklam);

			obj.put("homeJSON", homeJSON);

			writeResultInLocalFile(obj);
			     
         return fileName;
    }	
	
	/**
     * @param obj input JSONObject which we wrote to file in concrete directory.
     */
	private void writeResultInLocalFile(JSONObject obj) {
		try {
			
			Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
			out.write(obj.toJSONString());
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/central_reklam/change_order_pictures", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
		public @ResponseBody void changeOrderPicturesCentralReklam(@RequestBody List<String> selectedIds) {

		logger.info("change order pictures in central rekalam");

		JSONObject obj = getJsonPicturesLinksContainer();

		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		JSONArray listPicturesOfCentralReklam = new JSONArray();

		for (String fileName : selectedIds)
			listPicturesOfCentralReklam.add(fileName);
		homeJSON.put("listPicturesOfCentralReklam", listPicturesOfCentralReklam);

		obj.put("homeJSON", homeJSON);

		writeResultInLocalFile(obj);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/central_reklam/remove_picture/{name_picture}", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
		public @ResponseBody void removePicturesCentralReklam(@PathVariable("name_picture") String name) {

		String namePicture = name.replace(":", ".");
		logger.info("delete picture in home page, from central big reklam");
		
		componets.removePicture(namePicture, directory, "home", "big_reklam"); 

		JSONObject obj = getJsonPicturesLinksContainer();

		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		JSONArray listPicturesOfCentralReklam = (JSONArray) homeJSON.get("listPicturesOfCentralReklam");

		listPicturesOfCentralReklam.remove(namePicture);
		homeJSON.put("listPicturesOfCentralReklam", listPicturesOfCentralReklam);

		obj.put("homeJSON", homeJSON);

		writeResultInLocalFile(obj);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 	right of big reklam 
	 * */
	 @RequestMapping(value="/admin/pictures/right_of_reklam/{position}", method = RequestMethod.GET)
	    public ModelAndView showOnRightOfBigReclam(Model model, @PathVariable("position") String position){
	    	
	    	String pathToPage = "admin";
	    	
	    	JSONParser parser = new JSONParser();
	    	try {
	    		JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
			
	    		JSONObject home = (JSONObject) obj.get("homeJSON");
	    		
				if(position.equals("1")){
					model.addAttribute("subDirectory", position);
					model.addAttribute("headOfPage", "Изменение отображения верхней картинки справа от рекламы");
					model.addAttribute("listPictures", (JSONObject) home.get("listPicturesRightOfReklam1"));
					pathToPage = "admin/pictures/right_of_reklam";
					
	        	} else if(position.equals("2")){
					model.addAttribute("subDirectory", position);
					model.addAttribute("headOfPage", "Изменение отображения центральной картинки справа от рекламы");
	        		model.addAttribute("listPictures", (JSONObject) home.get("listPicturesRightOfReklam2"));
	        		pathToPage = "admin/pictures/right_of_reklam";
	        		
	        	} else if(position.equals("3")){
					model.addAttribute("subDirectory", position);
					model.addAttribute("headOfPage", "Изменение отображения нижней картинки справа от рекламы");
	        		model.addAttribute("listPictures", (JSONObject) home.get("listPicturesRightOfReklam3"));
	        		pathToPage = "admin/pictures/right_of_reklam";
	        		
	        	}
	   
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}	   
	    	return new ModelAndView(pathToPage);
	    }
	 
	 @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/right_of_reklam/{position}/save_description/{description}",
	    		method = RequestMethod.POST)
	    public @ResponseBody void saveDescriptionPicturesOnRightOfBigReclam(
	    		@PathVariable("position") String position,
	    		@PathVariable("description") String description) {
		
		 JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = null;
					if( obj.get("homeJSON") != null ){
						homeJSON = (JSONObject) obj.get("homeJSON");
						} else {
							homeJSON = new JSONObject();
						}

					if(position.equals("1")){
						
						JSONObject listPicturesRightOfReklam1 = null;
						if(homeJSON.get("listPicturesRightOfReklam1") != null){
							listPicturesRightOfReklam1 = (JSONObject) homeJSON.get("listPicturesRightOfReklam1");
							homeJSON.remove("listPicturesRightOfReklam1");
						} else {
							listPicturesRightOfReklam1 = new JSONObject();
						}
						
						if(listPicturesRightOfReklam1.get("description") != null){
							listPicturesRightOfReklam1.remove("description");
							listPicturesRightOfReklam1.put("description", description);
						} else {
							listPicturesRightOfReklam1.put("description", description);
						}
						
						homeJSON.put("listPicturesRightOfReklam1", listPicturesRightOfReklam1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject listPicturesRightOfReklam2 = null;
						if(homeJSON.get("listPicturesRightOfReklam2") != null){
							listPicturesRightOfReklam2 = (JSONObject) homeJSON.get("listPicturesRightOfReklam2");
							homeJSON.remove("listPicturesRightOfReklam2");
						} else {
							listPicturesRightOfReklam2 = new JSONObject();
						}
						
						if(listPicturesRightOfReklam2.get("description") != null){
							listPicturesRightOfReklam2.remove("description");
							listPicturesRightOfReklam2.put("description", description);
						} else {
							listPicturesRightOfReklam2.put("description", description);
						}
						
						homeJSON.put("listPicturesRightOfReklam2", listPicturesRightOfReklam2);
						
		        	} else if(position.equals("3")){
		        		
		        		JSONObject listPicturesRightOfReklam3 = null;
						if(homeJSON.get("listPicturesRightOfReklam3") != null){
							listPicturesRightOfReklam3 = (JSONObject) homeJSON.get("listPicturesRightOfReklam3");
							homeJSON.remove("listPicturesRightOfReklam3");
						} else {
							listPicturesRightOfReklam3 = new JSONObject();
						}
						
						if(listPicturesRightOfReklam3.get("description") != null){
							listPicturesRightOfReklam3.remove("description");
							listPicturesRightOfReklam3.put("description", description);
						} else {
							listPicturesRightOfReklam3.put("description", description);
						}
						
						homeJSON.put("listPicturesRightOfReklam3", listPicturesRightOfReklam3);
						
		        	}

					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
	 }
	 
	 @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/right_of_reklam/{position}/upload_pictures",
	    		method = RequestMethod.POST)
	    public @ResponseBody String uploadPicturesRightOFBigReclam(MultipartHttpServletRequest request,
	    		@PathVariable("position") String position) {
	    	
	    	logger.info("upload new picture to the right of big reklam on home page"); 	
	    
	        Iterator<String> itr =  request.getFileNames();
	        MultipartFile mpf = null;
	        String fileName = null;

	        while(itr.hasNext()){
	            mpf = request.getFile(itr.next()); 
	    		fileName = new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 

				try {
					FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(directory + File.separator + "home" + 
				File.separator + "right_of_reklam" + File.separator + position + File.separator + fileName));

				} catch (IOException e) {
					logger.error("Don't write picture to the folder", e);
				} 
	        }
			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = null;
					if( obj.get("homeJSON") != null ){
						homeJSON = (JSONObject) obj.get("homeJSON");
						} else {
							homeJSON = new JSONObject();
						}

					//add new pictures to the and
					if(position.equals("1")){
						
						JSONObject listPicturesRightOfReklam1 = null;
						//check if these subdirectories has pictures
						if(homeJSON.get("listPicturesRightOfReklam1") != null){
							listPicturesRightOfReklam1 = (JSONObject) homeJSON.get("listPicturesRightOfReklam1");
							homeJSON.remove("listPicturesRightOfReklam1");
						} else {
							listPicturesRightOfReklam1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(listPicturesRightOfReklam1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) listPicturesRightOfReklam1.get("fileNameArray");
							listPicturesRightOfReklam1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						listPicturesRightOfReklam1.put("fileNameArray", fileNameArray);
						homeJSON.put("listPicturesRightOfReklam1", listPicturesRightOfReklam1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject listPicturesRightOfReklam2 = null;
						//check if these subdirectories has pictures
						if(homeJSON.get("listPicturesRightOfReklam2") != null){
							listPicturesRightOfReklam2 = (JSONObject) homeJSON.get("listPicturesRightOfReklam2");
							homeJSON.remove("listPicturesRightOfReklam2");
						} else {
							listPicturesRightOfReklam2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(listPicturesRightOfReklam2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) listPicturesRightOfReklam2.get("fileNameArray");
							listPicturesRightOfReklam2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						listPicturesRightOfReklam2.put("fileNameArray", fileNameArray);
						homeJSON.put("listPicturesRightOfReklam2", listPicturesRightOfReklam2);
						
		        	} else if(position.equals("3")){
		        		
		        		JSONObject listPicturesRightOfReklam3 = null;
						//check if these subdirectories has pictures
						if(homeJSON.get("listPicturesRightOfReklam3") != null){
							listPicturesRightOfReklam3 = (JSONObject) homeJSON.get("listPicturesRightOfReklam3");
							homeJSON.remove("listPicturesRightOfReklam3");
						} else {
							listPicturesRightOfReklam3 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(listPicturesRightOfReklam3.get("fileNameArray") != null){
							fileNameArray = (JSONArray) listPicturesRightOfReklam3.get("fileNameArray");
							listPicturesRightOfReklam3.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						listPicturesRightOfReklam3.put("fileNameArray", fileNameArray);
						homeJSON.put("listPicturesRightOfReklam3", listPicturesRightOfReklam3);
						
		        	}

					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}	
	        
	         return fileName;
	    }
	    
	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/right_of_reklam/{position}/change_order_pictures",
						method = RequestMethod.POST,
						consumes="application/json",
						headers = "content-type=application/x-www-form-urlencoded")
	    public @ResponseBody void changeOrderPicturesRightOfBigReclam(
	    		@RequestBody List<String> selectedIds,
	    		@PathVariable("position") String position) {
	    	
	    	logger.info("change order pictures in left of reklam"); 	

			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = (JSONObject) obj.get("homeJSON");		

					if(position.equals("1")){
						
						JSONObject listPicturesRightOfReklam1 = null;
						
						if(homeJSON.get("listPicturesRightOfReklam1") != null){
							listPicturesRightOfReklam1 = (JSONObject) homeJSON.get("listPicturesRightOfReklam1");
							homeJSON.remove("listPicturesRightOfReklam1");
						} else {
							listPicturesRightOfReklam1 = new JSONObject();
						}
						
						if(listPicturesRightOfReklam1.get("fileNameArray") != null){
							listPicturesRightOfReklam1.remove("fileNameArray");
						} 
						
						JSONArray fileNameArray = new JSONArray();
						
						for(String fileName: selectedIds)
							fileNameArray.add(fileName);
						listPicturesRightOfReklam1.put("fileNameArray", fileNameArray);
						homeJSON.put("listPicturesRightOfReklam1", listPicturesRightOfReklam1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject listPicturesRightOfReklam2 = null;
						
						if(homeJSON.get("listPicturesRightOfReklam2") != null){
							listPicturesRightOfReklam2 = (JSONObject) homeJSON.get("listPicturesRightOfReklam2");
							homeJSON.remove("listPicturesRightOfReklam2");
						} else {
							listPicturesRightOfReklam2 = new JSONObject();
						}
						
						if(listPicturesRightOfReklam2.get("fileNameArray") != null){
							listPicturesRightOfReklam2.remove("fileNameArray");
						} 
						
						JSONArray fileNameArray = new JSONArray();
						
						for(String fileName: selectedIds)
							fileNameArray.add(fileName);
						listPicturesRightOfReklam2.put("fileNameArray", fileNameArray);
						homeJSON.put("listPicturesRightOfReklam2", listPicturesRightOfReklam2);
						
		        	} else if(position.equals("3")){
		        		
		        		JSONObject listPicturesRightOfReklam3 = null;
						
						if(homeJSON.get("listPicturesRightOfReklam3") != null){
							listPicturesRightOfReklam3 = (JSONObject) homeJSON.get("listPicturesRightOfReklam3");
							homeJSON.remove("listPicturesRightOfReklam3");
						} else {
							listPicturesRightOfReklam3 = new JSONObject();
						}
						
						if(listPicturesRightOfReklam3.get("fileNameArray") != null){
							listPicturesRightOfReklam3.remove("fileNameArray");
						} 
						
						JSONArray fileNameArray = new JSONArray();
						
						for(String fileName: selectedIds)
							fileNameArray.add(fileName);
						listPicturesRightOfReklam3.put("fileNameArray", fileNameArray);
						homeJSON.put("listPicturesRightOfReklam3", listPicturesRightOfReklam3);
						
		        	}

					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}  	
	    }
	    
	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/right_of_reklam/{position}/remove_picture/{name_picture}",
						method = RequestMethod.POST,consumes="application/json",
						headers = "content-type=application/x-www-form-urlencoded")
	    public @ResponseBody void removePicturesRightOfBigReclam(@PathVariable("name_picture") String name,
	    		@PathVariable("position") String position) {

	    	String namePicture = name.replace(":", ".");
	    	logger.info("delete picture in menu, from: right_of_reklam, in subType: " + position); 	

	    	try {
	    		FileUtils.forceDelete(new File(directory + File.separator + "home" + 
	    				File.separator + "right_of_reklam" + File.separator + position
	    				+ File.separator + namePicture));
	    		
			} catch (IOException e) {
				logger.error("Can't delete picture from the folder", e);
			} 
	    	
			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

					if(position.equals("1")){
						
						JSONObject listPicturesRightOfReklam1 = (JSONObject) homeJSON.get("listPicturesRightOfReklam1");
						homeJSON.remove("listPicturesRightOfReklam1");
						
						JSONArray fileNameArray = (JSONArray) listPicturesRightOfReklam1.get("fileNameArray");
						listPicturesRightOfReklam1.remove("fileNameArray");
						
						fileNameArray.remove(namePicture);

						listPicturesRightOfReklam1.put("fileNameArray", fileNameArray);
						homeJSON.put("listPicturesRightOfReklam1", listPicturesRightOfReklam1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject listPicturesRightOfReklam2 = (JSONObject) homeJSON.get("listPicturesRightOfReklam2");
						homeJSON.remove("listPicturesRightOfReklam2");
						
						JSONArray fileNameArray = (JSONArray) listPicturesRightOfReklam2.get("fileNameArray");
						listPicturesRightOfReklam2.remove("fileNameArray");
						
						fileNameArray.remove(namePicture);

						listPicturesRightOfReklam2.put("fileNameArray", fileNameArray);
						homeJSON.put("listPicturesRightOfReklam2", listPicturesRightOfReklam2);
						
		        	} else if(position.equals("3")){
		        		
		        		JSONObject listPicturesRightOfReklam3 = (JSONObject) homeJSON.get("listPicturesRightOfReklam3");
						homeJSON.remove("listPicturesRightOfReklam3");
						
						JSONArray fileNameArray = (JSONArray) listPicturesRightOfReklam3.get("fileNameArray");
						listPicturesRightOfReklam3.remove("fileNameArray");
						
						fileNameArray.remove(namePicture);

						listPicturesRightOfReklam3.put("fileNameArray", fileNameArray);
						homeJSON.put("listPicturesRightOfReklam3", listPicturesRightOfReklam3);
						
		        	}

					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
	    }

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * pictures at the right of each products block
	 */
	    @RequestMapping(value="/admin/pictures/home_products_block/{typeProduct}", method = RequestMethod.GET)
	    public ModelAndView showHomeProductsBlock(Model model, @PathVariable("typeProduct") String typeProduct){
	    	
	    	JSONParser parser = new JSONParser();
	    	try {
	    		JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
				JSONObject home = (JSONObject) obj.get("homeJSON");
			
			if (typeProduct.equals("printer_block")) {

				model.addAttribute("directory", typeProduct);
				model.addAttribute("headOfPage", "Изменение изображения справа в блоке принтеров на главном меню");
				model.addAttribute("listPictures", (JSONArray) home.get("list_printer_block"));

			} else if (typeProduct.equals("3d_printer_block")) {
				
				model.addAttribute("directory", typeProduct);
				model.addAttribute("headOfPage", "Изменение изображения справа в блоке 3Д принтеров на главном меню");
				model.addAttribute("listPictures", (JSONArray) home.get("list_3d_printer_block"));

			} else if(typeProduct.equals("digital_printer_block")){
				
				model.addAttribute("directory", typeProduct);
				model.addAttribute("headOfPage", "Изменение изображения справа в блоке цыфровых принтеров на главном меню");
				model.addAttribute("listPictures", (JSONArray) home.get("list_digital_printer_block"));
				
			} else if(typeProduct.equals("laminator_block")){
				
				model.addAttribute("directory", typeProduct);
				model.addAttribute("headOfPage", "Изменение изображения справа в блоке ламинаторов на главном меню");
				model.addAttribute("listPictures", (JSONArray) home.get("list_laminator_block"));
				
			} else if(typeProduct.equals("laser_block")){
				
				model.addAttribute("directory", typeProduct);
				model.addAttribute("headOfPage", "Изменение изображения справа в блоке лазеров на главном меню");
				model.addAttribute("listPictures", (JSONArray) home.get("list_laser_block"));
				
			} else if(typeProduct.equals("cutter_block")){
				
				model.addAttribute("directory", typeProduct);
				model.addAttribute("headOfPage", "Изменение изображения справа в блоке фрезеров на главном меню");
				model.addAttribute("listPictures", (JSONArray) home.get("list_cutter_block"));
				
			} else if(typeProduct.equals("scaner_block")){
				
				model.addAttribute("directory", typeProduct);
				model.addAttribute("headOfPage", "Изменение изображения справа в блоке сканеров на главном меню");
				model.addAttribute("listPictures", (JSONArray) home.get("list_scaner_block"));
				
			} else if(typeProduct.equals("previously_used_block")){
				
				model.addAttribute("directory", typeProduct);
				model.addAttribute("headOfPage", "Изменение изображения справа в блоке б/у товаров на главном меню");
				model.addAttribute("listPictures", (JSONArray) home.get("list_previously_used_block"));
				
			} else if(typeProduct.equals("rip_block")){
				
				model.addAttribute("directory", typeProduct);
				model.addAttribute("headOfPage", "Изменение изображения справа в блоке ПО на главном меню");
				model.addAttribute("listPictures", (JSONArray) home.get("list_rip_block"));
				
			}
	   
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}	   
	    	return new ModelAndView("admin/pictures/right_in_product_block");
	    }
	    
	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/home_products_block/{typeProduct}/upload_pictures", method = RequestMethod.POST)
	    public @ResponseBody String uploadPicturesToHomeProductsBlock(MultipartHttpServletRequest request,
	        	   @PathVariable("typeProduct") String typeProduct) {
	    	
	    	logger.info("upload new picture to products block on home page"); 	
	    
	        Iterator<String> itr =  request.getFileNames();
	        MultipartFile mpf = null;
	        String fileName = null;

	        while(itr.hasNext()){
	            mpf = request.getFile(itr.next()); 
	    		fileName = new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 

				try {
					FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(directory + File.separator + "home" + 
				File.separator + "product_block" + File.separator + typeProduct + File.separator + fileName));

				} catch (IOException e) {
					logger.error("Don't write picture to the folder", e);
				} 
	        }
			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));

				JSONObject homeJSON = null;
				if (obj.get("homeJSON") != null) {
					homeJSON = (JSONObject) obj.get("homeJSON");
				} else {
					homeJSON = new JSONObject();
				}

				if (typeProduct.equals("printer_block")) {
					
					JSONArray list_printer_block = null;
					if (homeJSON.get("list_printer_block") != null) {
						list_printer_block = (JSONArray) homeJSON.get("list_printer_block");
						homeJSON.remove("list_printer_block");
					} else {
						list_printer_block = new JSONArray();
					}

					list_printer_block.add(fileName);
					homeJSON.put("list_printer_block", list_printer_block);

				} else if (typeProduct.equals("3d_printer_block")) {
					
					JSONArray list_3d_printer_block = null;
					if (homeJSON.get("list_3d_printer_block") != null) {
						list_3d_printer_block = (JSONArray) homeJSON.get("list_3d_printer_block");
						homeJSON.remove("list_3d_printer_block");
					} else {
						list_3d_printer_block = new JSONArray();
					}

					list_3d_printer_block.add(fileName);
					homeJSON.put("list_3d_printer_block", list_3d_printer_block);

				} else if(typeProduct.equals("digital_printer_block")){
					
					JSONArray list_digital_printer_block = null;
					if (homeJSON.get("list_digital_printer_block") != null) {
						list_digital_printer_block = (JSONArray) homeJSON.get("list_digital_printer_block");
						homeJSON.remove("list_digital_printer_block");
					} else {
						list_digital_printer_block = new JSONArray();
					}

					list_digital_printer_block.add(fileName);
					homeJSON.put("list_digital_printer_block", list_digital_printer_block);
					
				} else if(typeProduct.equals("laminator_block")){
					
					JSONArray list_laminator_block = null;
					if (homeJSON.get("list_laminator_block") != null) {
						list_laminator_block = (JSONArray) homeJSON.get("list_laminator_block");
						homeJSON.remove("list_laminator_block");
					} else {
						list_laminator_block = new JSONArray();
					}

					list_laminator_block.add(fileName);
					homeJSON.put("list_laminator_block", list_laminator_block);
					
				} else if(typeProduct.equals("laser_block")){
					
					JSONArray list_laser_block = null;
					if (homeJSON.get("list_laser_block") != null) {
						list_laser_block = (JSONArray) homeJSON.get("list_laser_block");
						homeJSON.remove("list_laser_block");
					} else {
						list_laser_block = new JSONArray();
					}

					list_laser_block.add(fileName);
					homeJSON.put("list_laser_block", list_laser_block);
					
				} else if(typeProduct.equals("cutter_block")){
					
					JSONArray list_cutter_block = null;
					if (homeJSON.get("list_cutter_block") != null) {
						list_cutter_block = (JSONArray) homeJSON.get("list_cutter_block");
						homeJSON.remove("list_cutter_block");
					} else {
						list_cutter_block = new JSONArray();
					}

					list_cutter_block.add(fileName);
					homeJSON.put("list_cutter_block", list_cutter_block);
					
				} else if(typeProduct.equals("scaner_block")){
					
					JSONArray list_scaner_block = null;
					if (homeJSON.get("list_scaner_block") != null) {
						list_scaner_block = (JSONArray) homeJSON.get("list_scaner_block");
						homeJSON.remove("list_scaner_block");
					} else {
						list_scaner_block = new JSONArray();
					}

					list_scaner_block.add(fileName);
					homeJSON.put("list_scaner_block", list_scaner_block);
					
				} else if(typeProduct.equals("previously_used_block")){
					
					JSONArray list_previously_used_block = null;
					if (homeJSON.get("list_previously_used_block") != null) {
						list_previously_used_block = (JSONArray) homeJSON.get("list_previously_used_block");
						homeJSON.remove("list_previously_used_block");
					} else {
						list_previously_used_block = new JSONArray();
					}

					list_previously_used_block.add(fileName);
					homeJSON.put("list_previously_used_block", list_previously_used_block);
					
				} else if(typeProduct.equals("rip_block")){
					
					JSONArray list_rip_block = null;
					if (homeJSON.get("list_rip_block") != null) {
						list_rip_block = (JSONArray) homeJSON.get("list_rip_block");
						homeJSON.remove("list_rip_block");
					} else {
						list_rip_block = new JSONArray();
					}

					list_rip_block.add(fileName);
					homeJSON.put("list_rip_block", list_rip_block);
					
				}

				if (obj.get("homeJSON") != null)
					obj.remove("homeJSON");

				obj.put("homeJSON", homeJSON);

				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
	        
	         return fileName;
	    }
	    
	    @SuppressWarnings("unchecked")
		@RequestMapping(value = "/admin/pictures/home_products_block/{typeProduct}/change_order_pictures", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
		public @ResponseBody void changeOrderPicturesHomeProductsBlock(@RequestBody List<String> selectedIds, 
					@PathVariable("typeProduct") String typeProduct) {

			logger.info("change order pictures in central rekalam");

			JSONParser parser = new JSONParser();

			try {
				JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));

				JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

				if (typeProduct.equals("printer_block")) {
					
					JSONArray list_printer_block = null;
					// check if these subdirectories has pictures
					if (homeJSON.get("list_printer_block") != null) {
						homeJSON.remove("list_printer_block");
					}
					list_printer_block = new JSONArray();

					for (String fileName : selectedIds)
						list_printer_block.add(fileName);
					homeJSON.put("list_printer_block", list_printer_block);

				} else if (typeProduct.equals("3d_printer_block")) {
					
					JSONArray list_3d_printer_block = null;
					// check if these subdirectories has pictures
					if (homeJSON.get("list_3d_printer_block") != null) {
						homeJSON.remove("list_3d_printer_block");
					}
					list_3d_printer_block = new JSONArray();

					for (String fileName : selectedIds)
						list_3d_printer_block.add(fileName);
					homeJSON.put("list_3d_printer_block", list_3d_printer_block);

				} else if(typeProduct.equals("digital_printer_block")){
					
					JSONArray list_digital_printer_block = null;
					// check if these subdirectories has pictures
					if (homeJSON.get("list_digital_printer_block") != null) {
						homeJSON.remove("list_digital_printer_block");
					}
					list_digital_printer_block = new JSONArray();

					for (String fileName : selectedIds)
						list_digital_printer_block.add(fileName);
					homeJSON.put("list_digital_printer_block", list_digital_printer_block);
					
				} else if(typeProduct.equals("laminator_block")){
					
					JSONArray list_laminator_block = null;
					// check if these subdirectories has pictures
					if (homeJSON.get("list_laminator_block") != null) {
						homeJSON.remove("list_laminator_block");
					}
					list_laminator_block = new JSONArray();

					for (String fileName : selectedIds)
						list_laminator_block.add(fileName);
					homeJSON.put("list_laminator_block", list_laminator_block);
					
				} else if(typeProduct.equals("laser_block")){
					
					JSONArray list_laser_block = null;
					// check if these subdirectories has pictures
					if (homeJSON.get("list_laser_block") != null) {
						homeJSON.remove("list_laser_block");
					}
					list_laser_block = new JSONArray();

					for (String fileName : selectedIds)
						list_laser_block.add(fileName);
					homeJSON.put("list_laser_block", list_laser_block);
					
				} else if(typeProduct.equals("cutter_block")){
					
					JSONArray list_cutter_block = null;
					// check if these subdirectories has pictures
					if (homeJSON.get("list_cutter_block") != null) {
						homeJSON.remove("list_cutter_block");
					}
					list_cutter_block = new JSONArray();

					for (String fileName : selectedIds)
						list_cutter_block.add(fileName);
					homeJSON.put("list_cutter_block", list_cutter_block);
					
				} else if(typeProduct.equals("scaner_block")){
					
					JSONArray list_scaner_block = null;
					if (homeJSON.get("list_scaner_block") != null) {
						homeJSON.remove("list_scaner_block");
					}
					list_scaner_block = new JSONArray();

					for (String fileName : selectedIds)
						list_scaner_block.add(fileName);
					homeJSON.put("list_scaner_block", list_scaner_block);
					
				} else if(typeProduct.equals("previously_used_block")){
					
					JSONArray list_previously_used_block = null;
					if (homeJSON.get("list_previously_used_block") != null) {
						homeJSON.remove("list_previously_used_block");
					}
					list_previously_used_block = new JSONArray();

					for (String fileName : selectedIds)
						list_previously_used_block.add(fileName);
					homeJSON.put("list_previously_used_block", list_previously_used_block);
					
				} else if(typeProduct.equals("rip_block")){
					
					JSONArray list_rip_block = null;
					if (homeJSON.get("list_rip_block") != null) {
						homeJSON.remove("list_rip_block");
					}
					list_rip_block = new JSONArray();

					for (String fileName : selectedIds)
						list_rip_block.add(fileName);
					homeJSON.put("list_rip_block", list_rip_block);
					
				}

				if (obj.get("homeJSON") != null)
					obj.remove("homeJSON");

				obj.put("homeJSON", homeJSON);

				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
	    
	    @SuppressWarnings("unchecked")
		@RequestMapping(value = "/admin/pictures/home_products_block/{typeProduct}/remove_picture/{name_picture}", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
		public @ResponseBody void removePicturesHomeProductBlocks(@PathVariable("name_picture") String name,
				   @PathVariable("typeProduct") String typeProduct) {

			String namePicture = name.replace(":", ".");
			logger.info("delete picture in home page, from product block");

			try {
				FileUtils.forceDelete(new File(directory + File.separator + "home" + File.separator + "product_block"
						+ File.separator + typeProduct + File.separator + namePicture));

			} catch (IOException e) {
				logger.error("Can't delete picture from the folder", e);
			}

			JSONParser parser = new JSONParser();

			try {
				JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));

				JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

				if (typeProduct.equals("printer_block")) {
					
					JSONArray list_printer_block = (JSONArray) homeJSON.get("list_printer_block");
					homeJSON.remove("list_printer_block");

					list_printer_block.remove(namePicture);
					homeJSON.put("list_printer_block", list_printer_block);

				} else if (typeProduct.equals("3d_printer_block")) {
					
					JSONArray list_3d_printer_block = (JSONArray) homeJSON.get("list_3d_printer_block");
					homeJSON.remove("list_3d_printer_block");

					list_3d_printer_block.remove(namePicture);
					homeJSON.put("list_3d_printer_block", list_3d_printer_block);

				} else if(typeProduct.equals("digital_printer_block")){
					
					JSONArray list_digital_printer_block = (JSONArray) homeJSON.get("list_digital_printer_block");
					homeJSON.remove("list_digital_printer_block");

					list_digital_printer_block.remove(namePicture);
					homeJSON.put("list_digital_printer_block", list_digital_printer_block);
					
				} else if(typeProduct.equals("laminator_block")){
					
					JSONArray list_laminator_block = (JSONArray) homeJSON.get("list_laminator_block");
					homeJSON.remove("list_laminator_block");

					list_laminator_block.remove(namePicture);
					homeJSON.put("list_laminator_block", list_laminator_block);
					
				} else if(typeProduct.equals("laser_block")){
					
					JSONArray list_laser_block = (JSONArray) homeJSON.get("list_laser_block");
					homeJSON.remove("list_laser_block");

					list_laser_block.remove(namePicture);
					homeJSON.put("list_laser_block", list_laser_block);
					
				} else if(typeProduct.equals("cutter_block")){
					
					JSONArray list_cutter_block = (JSONArray) homeJSON.get("list_cutter_block");
					homeJSON.remove("list_cutter_block");

					list_cutter_block.remove(namePicture);
					homeJSON.put("list_cutter_block", list_cutter_block);
					
				} else if(typeProduct.equals("scaner_block")){
					
					JSONArray list_scaner_block = (JSONArray) homeJSON.get("list_scaner_block");
					homeJSON.remove("list_scaner_block");

					list_scaner_block.remove(namePicture);
					homeJSON.put("list_scaner_block", list_scaner_block);
					
				} else if(typeProduct.equals("previously_used_block")){
					
					JSONArray list_previously_used_block = (JSONArray) homeJSON.get("list_previously_used_block");
					homeJSON.remove("list_previously_used_block");

					list_previously_used_block.remove(namePicture);
					homeJSON.put("list_previously_used_block", list_previously_used_block);
					
				} else if(typeProduct.equals("rip_block")){
					
					JSONArray list_rip_block = (JSONArray) homeJSON.get("list_rip_block");
					homeJSON.remove("list_rip_block");

					list_rip_block.remove(namePicture);
					homeJSON.put("list_rip_block", list_rip_block);
					
				}

				if (obj.get("homeJSON") != null)
					obj.remove("homeJSON");

				obj.put("homeJSON", homeJSON);

				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

		}
	    
	    
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    
	    Map<String, RowPicturesInformation> picturesInTopProductSection = new HashMap<String, RowPicturesInformation>(){
			private static final long serialVersionUID = 1L;
			{
				put("printer_top", new RowPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", "Изменение картинки отображения над подразделом принтеров №1", "list_printer_top1"),
								new PictureInformation("2", "Изменение картинки отображения над подразделом принтеров №2", "list_printer_top2"),
								new PictureInformation("3", "Изменение картинки отображения над подразделом принтеров №3", "list_printer_top3")
							)));
				
				put("digital_printer_top", new RowPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", "Изменение картинки отображения над подразделом цыфровых принтеров №1", "list_digital_printer_top1"),
								new PictureInformation("2", "Изменение картинки отображения над подразделом цыфровых принтеров №2", "list_digital_printer_top2"),
								new PictureInformation("3", "Изменение картинки отображения над подразделом цыфровых принтеров №3", "list_digital_printer_top3")
							)));
				
				put("laser_top", new RowPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", "Изменение картинки отображения над подразделом лазеров №1", "list_laser_top1"),
								new PictureInformation("2", "Изменение картинки отображения над подразделом лазеров №2", "list_laser_top2"),
								new PictureInformation("3", "Изменение картинки отображения над подразделом лазеров №3", "list_laser_top3")
							)));
				
				put("scaner_top", new RowPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", "Изменение картинки отображения над подразделом сканеров №1", "list_scaner_top1"),
								new PictureInformation("2", "Изменение картинки отображения над подразделом сканеров №2", "list_scaner_top2"),
								new PictureInformation("3", "Изменение картинки отображения над подразделом сканеров №3", "list_scaner_top3")
							)));

				put("rip_top", new RowPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", "Изменение картинки отображения над подразделом ПО №1", "list_rip_top1"),
								new PictureInformation("2", "Изменение картинки отображения над подразделом ПО №2", "list_rip_top2"),
								new PictureInformation("3", "Изменение картинки отображения над подразделом ПО №3", "list_rip_top3")
							)));
				
				put("3d_printer_top", new RowPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", "Изменение картинки отображения над подразделом 3D принтеров №1", "list_3d_printer_top1"),
								new PictureInformation("2", "Изменение картинки отображения над подразделом 3D принтеров №2", "list_3d_printer_top2")
							)));
			
				put("laminator_top", new RowPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", "Изменение картинки отображения над подразделом ламинаторов №1", "list_laminator_top1"),
								new PictureInformation("2", "Изменение картинки отображения над подразделом ламинаторов №2", "list_laminator_top2")
							)));
				
				put("cutter_top", new RowPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", "Изменение картинки отображения над подразделом фрезеров №1", "list_cutter_top1"),
								new PictureInformation("2", "Изменение картинки отображения над подразделом фрезеров №2", "list_cutter_top2")
							)));
				
				put("previously_used_top", new RowPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", "Изменение картинки отображения над подразделом б/у товаров №1", "list_previously_used_top1"),
								new PictureInformation("2", "Изменение картинки отображения над подразделом б/у товаров №2", "list_previously_used_top2")
							)));
				
			}
		};
	    
	    
	    
	    

	/**
	 * block with three big pictures
	 */
	    @RequestMapping(value="/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}", method = RequestMethod.GET)
	    public ModelAndView showThreeBigPictures(Model model, @PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
	    							 @PathVariable("position") String position){

			JSONObject homeJSON = (JSONObject) getJsonPicturesLinksContainer().get("homeJSON");
	
			if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {
	
				List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();
	
				if (pictures.contains(new PictureInformation(position))) {
	
					PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));
	
					model.addAttribute("directory", inTopOfTypeProduct);
					model.addAttribute("subDirectory", position);
					model.addAttribute("headOfPage", picture.headOfPage);
					model.addAttribute("listPictures", (JSONObject) homeJSON.get(picture.getNameOfJsonObject()));
	
				}
			}
	
			return new ModelAndView("admin/pictures/three_big_pictures");
	    }
	    
	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}/save_description/{href}",
	    		method = RequestMethod.POST)
	    public @ResponseBody void saveHrefPictureOnThreeBigPictures(@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
	    		@PathVariable("position") String position,
	    		@PathVariable("href") String href) {
		
		 JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = null;
					if( obj.get("homeJSON") != null ){
						homeJSON = (JSONObject) obj.get("homeJSON");
						} else {
							homeJSON = new JSONObject();
						}

					if(inTopOfTypeProduct.equals("printer_top")){
						
						if(position.equals("1")){
							JSONObject list_printer_top1 = null;
							if(homeJSON.get("list_printer_top1") != null){
								list_printer_top1 = (JSONObject) homeJSON.get("list_printer_top1");
								homeJSON.remove("list_printer_top1");
							} else {
								list_printer_top1 = new JSONObject();
							}
							
							if(list_printer_top1.get("href") != null){
								list_printer_top1.remove("href");
								list_printer_top1.put("href", href);
							} else {
								list_printer_top1.put("href", href);
							}
							
							homeJSON.put("list_printer_top1", list_printer_top1);
							
			        	} else if(position.equals("2")){
			        		JSONObject list_printer_top2 = null;
							if(homeJSON.get("list_printer_top2") != null){
								list_printer_top2 = (JSONObject) homeJSON.get("list_printer_top2");
								homeJSON.remove("list_printer_top2");
							} else {
								list_printer_top2 = new JSONObject();
							}
							
							if(list_printer_top2.get("href") != null){
								list_printer_top2.remove("href");
								list_printer_top2.put("href", href);
							} else {
								list_printer_top2.put("href", href);
							}
							
							homeJSON.put("list_printer_top2", list_printer_top2);
			        		
			        	} else if(position.equals("3")){
			        		JSONObject list_printer_top3 = null;
							if(homeJSON.get("list_printer_top3") != null){
								list_printer_top3 = (JSONObject) homeJSON.get("list_printer_top3");
								homeJSON.remove("list_printer_top3");
							} else {
								list_printer_top3 = new JSONObject();
							}
							
							if(list_printer_top3.get("href") != null){
								list_printer_top3.remove("href");
								list_printer_top3.put("href", href);
							} else {
								list_printer_top3.put("href", href);
							}
							
							homeJSON.put("list_printer_top3", list_printer_top3);
			        		
			        	} 
					
					} else if(inTopOfTypeProduct.equals("digital_printer_top")){
						
						if(position.equals("1")){
							
							JSONObject list_digital_printer_top1 = null;
							if(homeJSON.get("list_digital_printer_top1") != null){
								list_digital_printer_top1 = (JSONObject) homeJSON.get("list_digital_printer_top1");
								homeJSON.remove("list_digital_printer_top1");
							} else {
								list_digital_printer_top1 = new JSONObject();
							}
							
							if(list_digital_printer_top1.get("href") != null){
								list_digital_printer_top1.remove("href");
								list_digital_printer_top1.put("href", href);
							} else {
								list_digital_printer_top1.put("href", href);
							}
							
							homeJSON.put("list_digital_printer_top1", list_digital_printer_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_digital_printer_top2 = null;
							if(homeJSON.get("list_digital_printer_top2") != null){
								list_digital_printer_top2 = (JSONObject) homeJSON.get("list_digital_printer_top2");
								homeJSON.remove("list_digital_printer_top2");
							} else {
								list_digital_printer_top2 = new JSONObject();
							}
							
							if(list_digital_printer_top2.get("href") != null){
								list_digital_printer_top2.remove("href");
								list_digital_printer_top2.put("href", href);
							} else {
								list_digital_printer_top2.put("href", href);
							}
							
							homeJSON.put("list_digital_printer_top2", list_digital_printer_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_digital_printer_top3 = null;
							if(homeJSON.get("list_digital_printer_top3") != null){
								list_digital_printer_top3 = (JSONObject) homeJSON.get("list_digital_printer_top3");
								homeJSON.remove("list_digital_printer_top3");
							} else {
								list_digital_printer_top3 = new JSONObject();
							}
							
							if(list_digital_printer_top3.get("href") != null){
								list_digital_printer_top3.remove("href");
								list_digital_printer_top3.put("href", href);
							} else {
								list_digital_printer_top3.put("href", href);
							}
							
							homeJSON.put("list_digital_printer_top3", list_digital_printer_top3);
			        		
			        	} 
						
					} else if(inTopOfTypeProduct.equals("laser_top")){
						
						if(position.equals("1")){
	
							JSONObject list_laser_top1 = null;
							if(homeJSON.get("list_laser_top1") != null){
								list_laser_top1 = (JSONObject) homeJSON.get("list_laser_top1");
								homeJSON.remove("list_laser_top1");
							} else {
								list_laser_top1 = new JSONObject();
							}
							
							if(list_laser_top1.get("href") != null){
								list_laser_top1.remove("href");
								list_laser_top1.put("href", href);
							} else {
								list_laser_top1.put("href", href);
							}
							
							homeJSON.put("list_laser_top1", list_laser_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_laser_top2 = null;
							if(homeJSON.get("list_laser_top2") != null){
								list_laser_top2 = (JSONObject) homeJSON.get("list_laser_top2");
								homeJSON.remove("list_laser_top2");
							} else {
								list_laser_top2 = new JSONObject();
							}
							
							if(list_laser_top2.get("href") != null){
								list_laser_top2.remove("href");
								list_laser_top2.put("href", href);
							} else {
								list_laser_top2.put("href", href);
							}
							
							homeJSON.put("list_laser_top2", list_laser_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_laser_top3 = null;
							if(homeJSON.get("list_laser_top3") != null){
								list_laser_top3 = (JSONObject) homeJSON.get("list_laser_top3");
								homeJSON.remove("list_laser_top3");
							} else {
								list_laser_top3 = new JSONObject();
							}
							
							if(list_laser_top3.get("href") != null){
								list_laser_top3.remove("href");
								list_laser_top3.put("href", href);
							} else {
								list_laser_top3.put("href", href);
							}
							
							homeJSON.put("list_laser_top3", list_laser_top3);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("scaner_top")){
						
						if(position.equals("1")){
							
							JSONObject list_scaner_top1 = null;
							if(homeJSON.get("list_scaner_top1") != null){
								list_scaner_top1 = (JSONObject) homeJSON.get("list_scaner_top1");
								homeJSON.remove("list_scaner_top1");
							} else {
								list_scaner_top1 = new JSONObject();
							}
							
							if(list_scaner_top1.get("href") != null){
								list_scaner_top1.remove("href");
								list_scaner_top1.put("href", href);
							} else {
								list_scaner_top1.put("href", href);
							}
							
							homeJSON.put("list_scaner_top1", list_scaner_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_scaner_top2 = null;
							if(homeJSON.get("list_scaner_top2") != null){
								list_scaner_top2 = (JSONObject) homeJSON.get("list_scaner_top2");
								homeJSON.remove("list_scaner_top2");
							} else {
								list_scaner_top2 = new JSONObject();
							}
							
							if(list_scaner_top2.get("href") != null){
								list_scaner_top2.remove("href");
								list_scaner_top2.put("href", href);
							} else {
								list_scaner_top2.put("href", href);
							}
							
							homeJSON.put("list_scaner_top2", list_scaner_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_scaner_top3 = null;
							if(homeJSON.get("list_scaner_top3") != null){
								list_scaner_top3 = (JSONObject) homeJSON.get("list_scaner_top3");
								homeJSON.remove("list_scaner_top3");
							} else {
								list_scaner_top3 = new JSONObject();
							}
							
							if(list_scaner_top3.get("href") != null){
								list_scaner_top3.remove("href");
								list_scaner_top3.put("href", href);
							} else {
								list_scaner_top3.put("href", href);
							}
							
							homeJSON.put("list_scaner_top3", list_scaner_top3);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("rip_top")){
						
						if(position.equals("1")){
							
							JSONObject list_rip_top1 = null;
							if(homeJSON.get("list_rip_top1") != null){
								list_rip_top1 = (JSONObject) homeJSON.get("list_rip_top1");
								homeJSON.remove("list_rip_top1");
							} else {
								list_rip_top1 = new JSONObject();
							}
							
							if(list_rip_top1.get("href") != null){
								list_rip_top1.remove("href");
								list_rip_top1.put("href", href);
							} else {
								list_rip_top1.put("href", href);
							}
							
							homeJSON.put("list_rip_top1", list_rip_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_rip_top2 = null;
							if(homeJSON.get("list_rip_top2") != null){
								list_rip_top2 = (JSONObject) homeJSON.get("list_rip_top2");
								homeJSON.remove("list_rip_top2");
							} else {
								list_rip_top2 = new JSONObject();
							}
							
							if(list_rip_top2.get("href") != null){
								list_rip_top2.remove("href");
								list_rip_top2.put("href", href);
							} else {
								list_rip_top2.put("href", href);
							}
							
							homeJSON.put("list_rip_top2", list_rip_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_rip_top3 = null;
							if(homeJSON.get("list_rip_top3") != null){
								list_rip_top3 = (JSONObject) homeJSON.get("list_rip_top3");
								homeJSON.remove("list_rip_top3");
							} else {
								list_rip_top3 = new JSONObject();
							}
							
							if(list_rip_top3.get("href") != null){
								list_rip_top3.remove("href");
								list_rip_top3.put("href", href);
							} else {
								list_rip_top3.put("href", href);
							}
							
							homeJSON.put("list_rip_top3", list_rip_top3);
			        		
			        	} 
					}

					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
	 }

	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}/upload_pictures",
	    		method = RequestMethod.POST)
	    public @ResponseBody String uploadPicturesOnThreeBigPictures(MultipartHttpServletRequest request,
	    	   @PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
			   @PathVariable("position") String position) {
	    	
	    	logger.info("upload new picture to the one of thee big pictures on home page"); 	
	    
	        Iterator<String> itr =  request.getFileNames();
	        MultipartFile mpf = null;
	        String fileName = null;

	        while(itr.hasNext()){
	            mpf = request.getFile(itr.next()); 
	    		fileName = new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 

				try {
					FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(directory + File.separator + "home" 
				+ File.separator + "three_big_pictures" + File.separator
				+ inTopOfTypeProduct + File.separator + position + File.separator + fileName));

				} catch (IOException e) {
					logger.error("Don't write picture to the folder", e);
				} 
	          	
			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
			
				JSONObject homeJSON = null;
				if( obj.get("homeJSON") != null ){
					homeJSON = (JSONObject) obj.get("homeJSON");
					} else {
						homeJSON = new JSONObject();
					}
				
				if(inTopOfTypeProduct.equals("printer_top")){
		    		
					if(position.equals("1")){
						
						JSONObject list_printer_top1 = null;
						//check if these subdirectories has pictures
						if(homeJSON.get("list_printer_top1") != null){
							list_printer_top1 = (JSONObject) homeJSON.get("list_printer_top1");
							homeJSON.remove("list_printer_top1");
						} else {
							list_printer_top1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_printer_top1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_printer_top1.get("fileNameArray");
							list_printer_top1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_printer_top1.put("fileNameArray", fileNameArray);
						homeJSON.put("list_printer_top1", list_printer_top1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject list_printer_top2 = null;
						if(homeJSON.get("list_printer_top2") != null){
							list_printer_top2 = (JSONObject) homeJSON.get("list_printer_top2");
							homeJSON.remove("list_printer_top2");
						} else {
							list_printer_top2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_printer_top2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_printer_top2.get("fileNameArray");
							list_printer_top2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_printer_top2.put("fileNameArray", fileNameArray);
						homeJSON.put("list_printer_top2", list_printer_top2);
		        		
		        	} else if(position.equals("3")){
		        		
		        		JSONObject list_printer_top3 = null;
						if(homeJSON.get("list_printer_top3") != null){
							list_printer_top3 = (JSONObject) homeJSON.get("list_printer_top3");
							homeJSON.remove("list_printer_top3");
						} else {
							list_printer_top3 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_printer_top3.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_printer_top3.get("fileNameArray");
							list_printer_top3.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_printer_top3.put("fileNameArray", fileNameArray);
						homeJSON.put("list_printer_top3", list_printer_top3);
		        		
		        	} 
				
				} else if(inTopOfTypeProduct.equals("digital_printer_top")){
					
					if(position.equals("1")){
						
						JSONObject list_digital_printer_top1 = null;
						if(homeJSON.get("list_digital_printer_top1") != null){
							list_digital_printer_top1 = (JSONObject) homeJSON.get("list_digital_printer_top1");
							homeJSON.remove("list_digital_printer_top1");
						} else {
							list_digital_printer_top1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_digital_printer_top1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_digital_printer_top1.get("fileNameArray");
							list_digital_printer_top1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_digital_printer_top1.put("fileNameArray", fileNameArray);
						homeJSON.put("list_digital_printer_top1", list_digital_printer_top1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject list_digital_printer_top2 = null;
						if(homeJSON.get("list_digital_printer_top2") != null){
							list_digital_printer_top2 = (JSONObject) homeJSON.get("list_digital_printer_top2");
							homeJSON.remove("list_digital_printer_top2");
						} else {
							list_digital_printer_top2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_digital_printer_top2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_digital_printer_top2.get("fileNameArray");
							list_digital_printer_top2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_digital_printer_top2.put("fileNameArray", fileNameArray);
						homeJSON.put("list_digital_printer_top2", list_digital_printer_top2);
		        		
		        	} else if(position.equals("3")){
		        		
		        		JSONObject list_digital_printer_top3 = null;
						if(homeJSON.get("list_digital_printer_top3") != null){
							list_digital_printer_top3 = (JSONObject) homeJSON.get("list_digital_printer_top3");
							homeJSON.remove("list_digital_printer_top3");
						} else {
							list_digital_printer_top3 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_digital_printer_top3.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_digital_printer_top3.get("fileNameArray");
							list_digital_printer_top3.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_digital_printer_top3.put("fileNameArray", fileNameArray);
						homeJSON.put("list_digital_printer_top3", list_digital_printer_top3);
		        		
		        	} 
					
				} else if(inTopOfTypeProduct.equals("laser_top")){
					
					if(position.equals("1")){
						
						JSONObject list_laser_top1 = null;
						if(homeJSON.get("list_laser_top1") != null){
							list_laser_top1 = (JSONObject) homeJSON.get("list_laser_top1");
							homeJSON.remove("list_laser_top1");
						} else {
							list_laser_top1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_laser_top1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_laser_top1.get("fileNameArray");
							list_laser_top1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_laser_top1.put("fileNameArray", fileNameArray);
						homeJSON.put("list_laser_top1", list_laser_top1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject list_laser_top2 = null;
						if(homeJSON.get("list_laser_top2") != null){
							list_laser_top2 = (JSONObject) homeJSON.get("list_laser_top2");
							homeJSON.remove("list_laser_top2");
						} else {
							list_laser_top2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_laser_top2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_laser_top2.get("fileNameArray");
							list_laser_top2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_laser_top2.put("fileNameArray", fileNameArray);
						homeJSON.put("list_laser_top2", list_laser_top2);
		        		
		        	} else if(position.equals("3")){
		        		
		        		JSONObject list_laser_top3 = null;
						if(homeJSON.get("list_laser_top3") != null){
							list_laser_top3 = (JSONObject) homeJSON.get("list_laser_top3");
							homeJSON.remove("list_laser_top3");
						} else {
							list_laser_top3 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_laser_top3.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_laser_top3.get("fileNameArray");
							list_laser_top3.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_laser_top3.put("fileNameArray", fileNameArray);
						homeJSON.put("list_laser_top3", list_laser_top3);
		        		
		        	}
					
				} else if(inTopOfTypeProduct.equals("scaner_top")){
					
					if(position.equals("1")){
						
						JSONObject list_scaner_top1 = null;
						if(homeJSON.get("list_scaner_top1") != null){
							list_scaner_top1 = (JSONObject) homeJSON.get("list_scaner_top1");
							homeJSON.remove("list_scaner_top1");
						} else {
							list_scaner_top1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_scaner_top1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_scaner_top1.get("fileNameArray");
							list_scaner_top1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_scaner_top1.put("fileNameArray", fileNameArray);
						homeJSON.put("list_scaner_top1", list_scaner_top1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject list_scaner_top2 = null;
						if(homeJSON.get("list_scaner_top2") != null){
							list_scaner_top2 = (JSONObject) homeJSON.get("list_scaner_top2");
							homeJSON.remove("list_scaner_top2");
						} else {
							list_scaner_top2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_scaner_top2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_scaner_top2.get("fileNameArray");
							list_scaner_top2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_scaner_top2.put("fileNameArray", fileNameArray);
						homeJSON.put("list_scaner_top2", list_scaner_top2);
		        		
		        	} else if(position.equals("3")){
		        		
		        		JSONObject list_scaner_top3 = null;
						if(homeJSON.get("list_scaner_top3") != null){
							list_scaner_top3 = (JSONObject) homeJSON.get("list_scaner_top3");
							homeJSON.remove("list_scaner_top3");
						} else {
							list_scaner_top3 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_scaner_top3.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_scaner_top3.get("fileNameArray");
							list_scaner_top3.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_scaner_top3.put("fileNameArray", fileNameArray);
						homeJSON.put("list_scaner_top3", list_scaner_top3);
		        		
		        	}
					
				} else if(inTopOfTypeProduct.equals("rip_top")){
					
					if(position.equals("1")){
						
						JSONObject list_rip_top1 = null;
						if(homeJSON.get("list_rip_top1") != null){
							list_rip_top1 = (JSONObject) homeJSON.get("list_rip_top1");
							homeJSON.remove("list_rip_top1");
						} else {
							list_rip_top1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_rip_top1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_rip_top1.get("fileNameArray");
							list_rip_top1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_rip_top1.put("fileNameArray", fileNameArray);
						homeJSON.put("list_rip_top1", list_rip_top1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject list_rip_top2 = null;
						if(homeJSON.get("list_rip_top2") != null){
							list_rip_top2 = (JSONObject) homeJSON.get("list_rip_top2");
							homeJSON.remove("list_rip_top2");
						} else {
							list_rip_top2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_rip_top2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_rip_top2.get("fileNameArray");
							list_rip_top2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_rip_top2.put("fileNameArray", fileNameArray);
						homeJSON.put("list_rip_top2", list_rip_top2);
		        		
		        	} else if(position.equals("3")){
		        		
		        		JSONObject list_rip_top3 = null;
						if(homeJSON.get("list_rip_top3") != null){
							list_rip_top3 = (JSONObject) homeJSON.get("list_rip_top3");
							homeJSON.remove("list_rip_top3");
						} else {
							list_rip_top3 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_rip_top3.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_rip_top3.get("fileNameArray");
							list_rip_top3.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_rip_top3.put("fileNameArray", fileNameArray);
						homeJSON.put("list_rip_top3", list_rip_top3);
		        		
		        	} 
				}
				
				if( obj.get("homeJSON") != null )
					obj.remove("homeJSON");
				
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}	
	        }
	         return fileName;
	    }

	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}/change_order_pictures",
						method = RequestMethod.POST,
						consumes="application/json",
						headers = "content-type=application/x-www-form-urlencoded")
	    public @ResponseBody void changeOrderPicturesHomeThreeBigPictures(
	    		@RequestBody List<String> selectedIds,
	    		@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
				@PathVariable("position") String position) {
	    	
	    	logger.info("change order pictures in three big pictures, home"); 	

			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = (JSONObject) obj.get("homeJSON");		

					if(inTopOfTypeProduct.equals("printer_top")){
			    		
						if(position.equals("1")){
							
							JSONObject list_printer_top1 = null;
							
							if(homeJSON.get("list_printer_top1") != null){
								list_printer_top1 = (JSONObject) homeJSON.get("list_printer_top1");
								homeJSON.remove("list_printer_top1");
							} else {
								list_printer_top1 = new JSONObject();
							}
							
							if(list_printer_top1.get("fileNameArray") != null){
								list_printer_top1.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_printer_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_printer_top1", list_printer_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_printer_top2 = null;
							
							if(homeJSON.get("list_printer_top2") != null){
								list_printer_top2 = (JSONObject) homeJSON.get("list_printer_top2");
								homeJSON.remove("list_printer_top2");
							} else {
								list_printer_top2 = new JSONObject();
							}
							
							if(list_printer_top2.get("fileNameArray") != null){
								list_printer_top2.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_printer_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_printer_top2", list_printer_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_printer_top3 = null;
							
							if(homeJSON.get("list_printer_top3") != null){
								list_printer_top3 = (JSONObject) homeJSON.get("list_printer_top3");
								homeJSON.remove("list_printer_top3");
							} else {
								list_printer_top3 = new JSONObject();
							}
							
							if(list_printer_top3.get("fileNameArray") != null){
								list_printer_top3.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_printer_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_printer_top3", list_printer_top3);
			        		
			        	} 
					
					} else if(inTopOfTypeProduct.equals("digital_printer_top")){
						
						if(position.equals("1")){
							
							JSONObject list_digital_printer_top1 = null;
							
							if(homeJSON.get("list_digital_printer_top1") != null){
								list_digital_printer_top1 = (JSONObject) homeJSON.get("list_digital_printer_top1");
								homeJSON.remove("list_digital_printer_top1");
							} else {
								list_digital_printer_top1 = new JSONObject();
							}
							
							if(list_digital_printer_top1.get("fileNameArray") != null){
								list_digital_printer_top1.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_digital_printer_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_digital_printer_top1", list_digital_printer_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_digital_printer_top2 = null;
							
							if(homeJSON.get("list_digital_printer_top2") != null){
								list_digital_printer_top2 = (JSONObject) homeJSON.get("list_digital_printer_top2");
								homeJSON.remove("list_digital_printer_top2");
							} else {
								list_digital_printer_top2 = new JSONObject();
							}
							
							if(list_digital_printer_top2.get("fileNameArray") != null){
								list_digital_printer_top2.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_digital_printer_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_digital_printer_top2", list_digital_printer_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_digital_printer_top3 = null;
							
							if(homeJSON.get("list_digital_printer_top3") != null){
								list_digital_printer_top3 = (JSONObject) homeJSON.get("list_digital_printer_top3");
								homeJSON.remove("list_digital_printer_top3");
							} else {
								list_digital_printer_top3 = new JSONObject();
							}
							
							if(list_digital_printer_top3.get("fileNameArray") != null){
								list_digital_printer_top3.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_digital_printer_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_digital_printer_top3", list_digital_printer_top3);
			        		
			        	} 
						
					} else if(inTopOfTypeProduct.equals("laser_top")){
						
						if(position.equals("1")){
							
							JSONObject list_laser_top1 = null;
							
							if(homeJSON.get("list_laser_top1") != null){
								list_laser_top1 = (JSONObject) homeJSON.get("list_laser_top1");
								homeJSON.remove("list_laser_top1");
							} else {
								list_laser_top1 = new JSONObject();
							}
							
							if(list_laser_top1.get("fileNameArray") != null){
								list_laser_top1.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_laser_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laser_top1", list_laser_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_laser_top2 = null;
							
							if(homeJSON.get("list_laser_top2") != null){
								list_laser_top2 = (JSONObject) homeJSON.get("list_laser_top2");
								homeJSON.remove("list_laser_top2");
							} else {
								list_laser_top2 = new JSONObject();
							}
							
							if(list_laser_top2.get("fileNameArray") != null){
								list_laser_top2.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_laser_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laser_top2", list_laser_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_laser_top3 = null;
							
							if(homeJSON.get("list_laser_top3") != null){
								list_laser_top3 = (JSONObject) homeJSON.get("list_laser_top3");
								homeJSON.remove("list_laser_top3");
							} else {
								list_laser_top3 = new JSONObject();
							}
							
							if(list_laser_top3.get("fileNameArray") != null){
								list_laser_top3.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_laser_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laser_top3", list_laser_top3);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("scaner_top")){
						
						if(position.equals("1")){
							
							JSONObject list_scaner_top1 = null;
							
							if(homeJSON.get("list_scaner_top1") != null){
								list_scaner_top1 = (JSONObject) homeJSON.get("list_scaner_top1");
								homeJSON.remove("list_scaner_top1");
							} else {
								list_scaner_top1 = new JSONObject();
							}
							
							if(list_scaner_top1.get("fileNameArray") != null){
								list_scaner_top1.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_scaner_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_scaner_top1", list_scaner_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_scaner_top2 = null;
							
							if(homeJSON.get("list_scaner_top2") != null){
								list_scaner_top2 = (JSONObject) homeJSON.get("list_scaner_top2");
								homeJSON.remove("list_scaner_top2");
							} else {
								list_scaner_top2 = new JSONObject();
							}
							
							if(list_scaner_top2.get("fileNameArray") != null){
								list_scaner_top2.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_scaner_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_scaner_top2", list_scaner_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_scaner_top3 = null;
							
							if(homeJSON.get("list_scaner_top3") != null){
								list_scaner_top3 = (JSONObject) homeJSON.get("list_scaner_top3");
								homeJSON.remove("list_scaner_top3");
							} else {
								list_scaner_top3 = new JSONObject();
							}
							
							if(list_scaner_top3.get("fileNameArray") != null){
								list_scaner_top3.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_scaner_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_scaner_top3", list_scaner_top3);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("rip_top")){
						
						if(position.equals("1")){
							
							JSONObject list_rip_top1 = null;
							
							if(homeJSON.get("list_rip_top1") != null){
								list_rip_top1 = (JSONObject) homeJSON.get("list_rip_top1");
								homeJSON.remove("list_rip_top1");
							} else {
								list_rip_top1 = new JSONObject();
							}
							
							if(list_rip_top1.get("fileNameArray") != null){
								list_rip_top1.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_rip_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_rip_top1", list_rip_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_rip_top2 = null;
							
							if(homeJSON.get("list_rip_top2") != null){
								list_rip_top2 = (JSONObject) homeJSON.get("list_rip_top2");
								homeJSON.remove("list_rip_top2");
							} else {
								list_rip_top2 = new JSONObject();
							}
							
							if(list_rip_top2.get("fileNameArray") != null){
								list_rip_top2.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_rip_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_rip_top2", list_rip_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_rip_top3 = null;
							
							if(homeJSON.get("list_rip_top3") != null){
								list_rip_top3 = (JSONObject) homeJSON.get("list_rip_top3");
								homeJSON.remove("list_rip_top3");
							} else {
								list_rip_top3 = new JSONObject();
							}
							
							if(list_rip_top3.get("fileNameArray") != null){
								list_rip_top3.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_rip_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_rip_top3", list_rip_top3);
			        		
			        	} 
					} 

					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}  	
	    }

	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}/remove_picture/{name_picture}",
						method = RequestMethod.POST,consumes="application/json",
						headers = "content-type=application/x-www-form-urlencoded")
	    public @ResponseBody void removePicturesThreeBigPictures(@PathVariable("name_picture") String name,
	    		@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
				@PathVariable("position") String position) {

	    	String namePicture = name.replace(":", ".");
	    	logger.info("delete picture in home, from: 'three big pictures', in top of type product: " + inTopOfTypeProduct); 	

	    	try {
	    		FileUtils.forceDelete(new File(directory + File.separator + "home" + 
	    				File.separator + "three_big_pictures" + File.separator + inTopOfTypeProduct
	    				+ File.separator + position + File.separator + namePicture));
	    		
			} catch (IOException e) {
				logger.error("Can't delete picture from the folder", e);
			} 
	    	
			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = (JSONObject) obj.get("homeJSON");
					
					if(inTopOfTypeProduct.equals("printer_top")){
			    		
						if(position.equals("1")){
							
							JSONObject list_printer_top1 = (JSONObject) homeJSON.get("list_printer_top1");
							homeJSON.remove("list_printer_top1");
							
							JSONArray fileNameArray = (JSONArray) list_printer_top1.get("fileNameArray");
							list_printer_top1.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_printer_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_printer_top1", list_printer_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_printer_top2 = (JSONObject) homeJSON.get("list_printer_top2");
							homeJSON.remove("list_printer_top2");
							
							JSONArray fileNameArray = (JSONArray) list_printer_top2.get("fileNameArray");
							list_printer_top2.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_printer_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_printer_top2", list_printer_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_printer_top3 = (JSONObject) homeJSON.get("list_printer_top3");
							homeJSON.remove("list_printer_top3");
							
							JSONArray fileNameArray = (JSONArray) list_printer_top3.get("fileNameArray");
							list_printer_top3.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_printer_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_printer_top3", list_printer_top3);
			        		
			        	} 
					
					} else if(inTopOfTypeProduct.equals("digital_printer_top")){
						
						if(position.equals("1")){
							
							JSONObject list_digital_printer_top1 = (JSONObject) homeJSON.get("list_digital_printer_top1");
							homeJSON.remove("list_digital_printer_top1");
							
							JSONArray fileNameArray = (JSONArray) list_digital_printer_top1.get("fileNameArray");
							list_digital_printer_top1.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_digital_printer_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_digital_printer_top1", list_digital_printer_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_digital_printer_top2 = (JSONObject) homeJSON.get("list_digital_printer_top2");
							homeJSON.remove("list_digital_printer_top2");
							
							JSONArray fileNameArray = (JSONArray) list_digital_printer_top2.get("fileNameArray");
							list_digital_printer_top2.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_digital_printer_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_digital_printer_top2", list_digital_printer_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_digital_printer_top3 = (JSONObject) homeJSON.get("list_digital_printer_top3");
							homeJSON.remove("list_digital_printer_top3");
							
							JSONArray fileNameArray = (JSONArray) list_digital_printer_top3.get("fileNameArray");
							list_digital_printer_top3.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_digital_printer_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_digital_printer_top3", list_digital_printer_top3);
			        		
			        	} 
						
					} else if(inTopOfTypeProduct.equals("laser_top")){
						
						if(position.equals("1")){
							
							JSONObject list_laser_top1 = (JSONObject) homeJSON.get("list_laser_top1");
							homeJSON.remove("list_laser_top1");
							
							JSONArray fileNameArray = (JSONArray) list_laser_top1.get("fileNameArray");
							list_laser_top1.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_laser_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laser_top1", list_laser_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_laser_top2 = (JSONObject) homeJSON.get("list_laser_top2");
							homeJSON.remove("list_laser_top2");
							
							JSONArray fileNameArray = (JSONArray) list_laser_top2.get("fileNameArray");
							list_laser_top2.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_laser_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laser_top2", list_laser_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_laser_top3 = (JSONObject) homeJSON.get("list_laser_top3");
							homeJSON.remove("list_laser_top3");
							
							JSONArray fileNameArray = (JSONArray) list_laser_top3.get("fileNameArray");
							list_laser_top3.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_laser_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laser_top3", list_laser_top3);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("scaner_top")){
						
						if(position.equals("1")){
							
							JSONObject list_scaner_top1 = (JSONObject) homeJSON.get("list_scaner_top1");
							homeJSON.remove("list_scaner_top1");
							
							JSONArray fileNameArray = (JSONArray) list_scaner_top1.get("fileNameArray");
							list_scaner_top1.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_scaner_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_scaner_top1", list_scaner_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_scaner_top2 = (JSONObject) homeJSON.get("list_scaner_top2");
							homeJSON.remove("list_scaner_top2");
							
							JSONArray fileNameArray = (JSONArray) list_scaner_top2.get("fileNameArray");
							list_scaner_top2.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_scaner_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_scaner_top2", list_scaner_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_scaner_top3 = (JSONObject) homeJSON.get("list_scaner_top3");
							homeJSON.remove("list_scaner_top3");
							
							JSONArray fileNameArray = (JSONArray) list_scaner_top3.get("fileNameArray");
							list_scaner_top3.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_scaner_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_scaner_top3", list_scaner_top3);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("rip_top")){
						
						if(position.equals("1")){
							
							JSONObject list_rip_top1 = (JSONObject) homeJSON.get("list_rip_top1");
							homeJSON.remove("list_rip_top1");
							
							JSONArray fileNameArray = (JSONArray) list_rip_top1.get("fileNameArray");
							list_rip_top1.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_rip_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_rip_top1", list_rip_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_rip_top2 = (JSONObject) homeJSON.get("list_rip_top2");
							homeJSON.remove("list_rip_top2");
							
							JSONArray fileNameArray = (JSONArray) list_rip_top2.get("fileNameArray");
							list_rip_top2.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_rip_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_rip_top2", list_rip_top2);
			        		
			        	} else if(position.equals("3")){
			        		
			        		JSONObject list_rip_top3 = (JSONObject) homeJSON.get("list_rip_top3");
							homeJSON.remove("list_rip_top3");
							
							JSONArray fileNameArray = (JSONArray) list_rip_top3.get("fileNameArray");
							list_rip_top3.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_rip_top3.put("fileNameArray", fileNameArray);
							homeJSON.put("list_rip_top3", list_rip_top3);
			        		
			        	} 
					} 
					
					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
	    }

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * block with two narrow pictures
	 */
	    @RequestMapping(value="/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}", method = RequestMethod.GET)
	    public ModelAndView showTwoNarrowPictures(Model model, @PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
	    							 @PathVariable("position") String position){
	    	
	    	JSONObject homeJSON = (JSONObject) getJsonPicturesLinksContainer().get("homeJSON");
	    	
			if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {
	
				List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();
	
				if (pictures.contains(new PictureInformation(position))) {
	
					PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));
	
					model.addAttribute("directory", inTopOfTypeProduct);
					model.addAttribute("subDirectory", position);
					model.addAttribute("headOfPage", picture.headOfPage);
					model.addAttribute("listPictures", (JSONObject) homeJSON.get(picture.getNameOfJsonObject()));
	
				}
			}
			
	    	return new ModelAndView("admin/pictures/two_narrow_pictures");
	    }
	 
	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}/save_description/{href}",
	    		method = RequestMethod.POST)
	    public @ResponseBody void saveHrefPictureOnTwoNarrowPictures(@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
	    	   @PathVariable("position") String position,
	    	   @PathVariable("href") String href) {
		
		 JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = null;
					if( obj.get("homeJSON") != null ){
						homeJSON = (JSONObject) obj.get("homeJSON");
						} else {
							homeJSON = new JSONObject();
						}

					if(inTopOfTypeProduct.equals("3d_printer_top")){
						
						if(position.equals("1")){
							
							JSONObject list_3d_printer_top1 = null;
							if(homeJSON.get("list_3d_printer_top1") != null){
								list_3d_printer_top1 = (JSONObject) homeJSON.get("list_3d_printer_top1");
								homeJSON.remove("list_3d_printer_top1");
							} else {
								list_3d_printer_top1 = new JSONObject();
							}
							
							if(list_3d_printer_top1.get("href") != null){
								list_3d_printer_top1.remove("href");
								list_3d_printer_top1.put("href", href);
							} else {
								list_3d_printer_top1.put("href", href);
							}
							
							homeJSON.put("list_3d_printer_top1", list_3d_printer_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_3d_printer_top2 = null;
							if(homeJSON.get("list_3d_printer_top2") != null){
								list_3d_printer_top2 = (JSONObject) homeJSON.get("list_3d_printer_top2");
								homeJSON.remove("list_3d_printer_top2");
							} else {
								list_3d_printer_top2 = new JSONObject();
							}
							
							if(list_3d_printer_top2.get("href") != null){
								list_3d_printer_top2.remove("href");
								list_3d_printer_top2.put("href", href);
							} else {
								list_3d_printer_top2.put("href", href);
							}
							
							homeJSON.put("list_3d_printer_top2", list_3d_printer_top2);
			        		
			        	}
					
					} else if(inTopOfTypeProduct.equals("laminator_top")){
						
						if(position.equals("1")){
							
							JSONObject list_laminator_top1 = null;
							if(homeJSON.get("list_laminator_top1") != null){
								list_laminator_top1 = (JSONObject) homeJSON.get("list_laminator_top1");
								homeJSON.remove("list_laminator_top1");
							} else {
								list_laminator_top1 = new JSONObject();
							}
							
							if(list_laminator_top1.get("href") != null){
								list_laminator_top1.remove("href");
								list_laminator_top1.put("href", href);
							} else {
								list_laminator_top1.put("href", href);
							}
							
							homeJSON.put("list_laminator_top1", list_laminator_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_laminator_top2 = null;
							if(homeJSON.get("list_laminator_top2") != null){
								list_laminator_top2 = (JSONObject) homeJSON.get("list_laminator_top2");
								homeJSON.remove("list_laminator_top2");
							} else {
								list_laminator_top2 = new JSONObject();
							}
							
							if(list_laminator_top2.get("href") != null){
								list_laminator_top2.remove("href");
								list_laminator_top2.put("href", href);
							} else {
								list_laminator_top2.put("href", href);
							}
							
							homeJSON.put("list_laminator_top2", list_laminator_top2);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("cutter_top")){
						
						if(position.equals("1")){
	
							JSONObject list_cutter_top1 = null;
							if(homeJSON.get("list_cutter_top1") != null){
								list_cutter_top1 = (JSONObject) homeJSON.get("list_cutter_top1");
								homeJSON.remove("list_cutter_top1");
							} else {
								list_cutter_top1 = new JSONObject();
							}
							
							if(list_cutter_top1.get("href") != null){
								list_cutter_top1.remove("href");
								list_cutter_top1.put("href", href);
							} else {
								list_cutter_top1.put("href", href);
							}
							
							homeJSON.put("list_cutter_top1", list_cutter_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_cutter_top2 = null;
							if(homeJSON.get("list_cutter_top2") != null){
								list_cutter_top2 = (JSONObject) homeJSON.get("list_cutter_top2");
								homeJSON.remove("list_cutter_top2");
							} else {
								list_cutter_top2 = new JSONObject();
							}
							
							if(list_cutter_top2.get("href") != null){
								list_cutter_top2.remove("href");
								list_cutter_top2.put("href", href);
							} else {
								list_cutter_top2.put("href", href);
							}
							
							homeJSON.put("list_cutter_top2", list_cutter_top2);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("previously_used_top")){
						
						if(position.equals("1")){
							
							JSONObject list_previously_used_top1 = null;
							if(homeJSON.get("list_previously_used_top1") != null){
								list_previously_used_top1 = (JSONObject) homeJSON.get("list_previously_used_top1");
								homeJSON.remove("list_previously_used_top1");
							} else {
								list_previously_used_top1 = new JSONObject();
							}
							
							if(list_previously_used_top1.get("href") != null){
								list_previously_used_top1.remove("href");
								list_previously_used_top1.put("href", href);
							} else {
								list_previously_used_top1.put("href", href);
							}
							
							homeJSON.put("list_previously_used_top1", list_previously_used_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_previously_used_top2 = null;
							if(homeJSON.get("list_previously_used_top2") != null){
								list_previously_used_top2 = (JSONObject) homeJSON.get("list_previously_used_top2");
								homeJSON.remove("list_previously_used_top2");
							} else {
								list_previously_used_top2 = new JSONObject();
							}
							
							if(list_previously_used_top2.get("href") != null){
								list_previously_used_top2.remove("href");
								list_previously_used_top2.put("href", href);
							} else {
								list_previously_used_top2.put("href", href);
							}
							
							homeJSON.put("list_previously_used_top2", list_previously_used_top2);
			        		
			        	}
						
					}

					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
	 }

	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}/upload_pictures",
	    		method = RequestMethod.POST)
	    public @ResponseBody String uploadPicturesOnTwoNarrowPictures(MultipartHttpServletRequest request,
	    	   @PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
			   @PathVariable("position") String position) {
	    	
	    	logger.info("upload new picture to the one of two narrows pictures on home page"); 	
	    
	        Iterator<String> itr =  request.getFileNames();
	        MultipartFile mpf = null;
	        String fileName = null;

	        while(itr.hasNext()){
	            mpf = request.getFile(itr.next()); 
	    		fileName = new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 

				try {
					FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(directory + File.separator + "home" 
				+ File.separator + "two_narrow_pictures" + File.separator
				+ inTopOfTypeProduct + File.separator + position + File.separator + fileName));

				} catch (IOException e) {
					logger.error("Don't write picture to the folder", e);
				} 
	          	
			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
			
				JSONObject homeJSON = null;
				if( obj.get("homeJSON") != null ){
					homeJSON = (JSONObject) obj.get("homeJSON");
					} else {
						homeJSON = new JSONObject();
					}
				
				if(inTopOfTypeProduct.equals("3d_printer_top")){
		    		
					if(position.equals("1")){
						
						JSONObject list_3d_printer_top1 = null;
						//check if these subdirectories has pictures
						if(homeJSON.get("list_3d_printer_top1") != null){
							list_3d_printer_top1 = (JSONObject) homeJSON.get("list_3d_printer_top1");
							homeJSON.remove("list_3d_printer_top1");
						} else {
							list_3d_printer_top1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_3d_printer_top1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_3d_printer_top1.get("fileNameArray");
							list_3d_printer_top1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_3d_printer_top1.put("fileNameArray", fileNameArray);
						homeJSON.put("list_3d_printer_top1", list_3d_printer_top1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject list_3d_printer_top2 = null;
						if(homeJSON.get("list_3d_printer_top2") != null){
							list_3d_printer_top2 = (JSONObject) homeJSON.get("list_3d_printer_top2");
							homeJSON.remove("list_3d_printer_top2");
						} else {
							list_3d_printer_top2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_3d_printer_top2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_3d_printer_top2.get("fileNameArray");
							list_3d_printer_top2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_3d_printer_top2.put("fileNameArray", fileNameArray);
						homeJSON.put("list_3d_printer_top2", list_3d_printer_top2);
		        		
		        	}
				
				} else if(inTopOfTypeProduct.equals("laminator_top")){
					
					if(position.equals("1")){
						
						JSONObject list_laminator_top1 = null;
						if(homeJSON.get("list_laminator_top1") != null){
							list_laminator_top1 = (JSONObject) homeJSON.get("list_laminator_top1");
							homeJSON.remove("list_laminator_top1");
						} else {
							list_laminator_top1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_laminator_top1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_laminator_top1.get("fileNameArray");
							list_laminator_top1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_laminator_top1.put("fileNameArray", fileNameArray);
						homeJSON.put("list_laminator_top1", list_laminator_top1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject list_laminator_top2 = null;
						if(homeJSON.get("list_laminator_top2") != null){
							list_laminator_top2 = (JSONObject) homeJSON.get("list_laminator_top2");
							homeJSON.remove("list_laminator_top2");
						} else {
							list_laminator_top2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_laminator_top2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_laminator_top2.get("fileNameArray");
							list_laminator_top2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_laminator_top2.put("fileNameArray", fileNameArray);
						homeJSON.put("list_laminator_top2", list_laminator_top2);
		        		
		        	} 
					
				} else if(inTopOfTypeProduct.equals("cutter_top")){
					
					if(position.equals("1")){
						
						JSONObject list_cutter_top1 = null;
						if(homeJSON.get("list_cutter_top1") != null){
							list_cutter_top1 = (JSONObject) homeJSON.get("list_cutter_top1");
							homeJSON.remove("list_cutter_top1");
						} else {
							list_cutter_top1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_cutter_top1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_cutter_top1.get("fileNameArray");
							list_cutter_top1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_cutter_top1.put("fileNameArray", fileNameArray);
						homeJSON.put("list_cutter_top1", list_cutter_top1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject list_cutter_top2 = null;
						if(homeJSON.get("list_cutter_top2") != null){
							list_cutter_top2 = (JSONObject) homeJSON.get("list_cutter_top2");
							homeJSON.remove("list_cutter_top2");
						} else {
							list_cutter_top2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_cutter_top2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_cutter_top2.get("fileNameArray");
							list_cutter_top2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_cutter_top2.put("fileNameArray", fileNameArray);
						homeJSON.put("list_cutter_top2", list_cutter_top2);
		        		
		        	}
					
				} else if(inTopOfTypeProduct.equals("previously_used_top")){
					
					if(position.equals("1")){
						
						JSONObject list_previously_used_top1 = null;
						if(homeJSON.get("list_previously_used_top1") != null){
							list_previously_used_top1 = (JSONObject) homeJSON.get("list_previously_used_top1");
							homeJSON.remove("list_previously_used_top1");
						} else {
							list_previously_used_top1 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_previously_used_top1.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_previously_used_top1.get("fileNameArray");
							list_previously_used_top1.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_previously_used_top1.put("fileNameArray", fileNameArray);
						homeJSON.put("list_previously_used_top1", list_previously_used_top1);
						
		        	} else if(position.equals("2")){
		        		
		        		JSONObject list_previously_used_top2 = null;
						if(homeJSON.get("list_previously_used_top2") != null){
							list_previously_used_top2 = (JSONObject) homeJSON.get("list_previously_used_top2");
							homeJSON.remove("list_previously_used_top2");
						} else {
							list_previously_used_top2 = new JSONObject();
						}
						
						JSONArray fileNameArray = null;
						if(list_previously_used_top2.get("fileNameArray") != null){
							fileNameArray = (JSONArray) list_previously_used_top2.get("fileNameArray");
							list_previously_used_top2.remove("fileNameArray");
						} else {
							fileNameArray = new JSONArray();
						}
						
						fileNameArray.add(fileName);

						list_previously_used_top2.put("fileNameArray", fileNameArray);
						homeJSON.put("list_previously_used_top2", list_previously_used_top2);
		        		
		        	}	
				}
				
				if( obj.get("homeJSON") != null )
					obj.remove("homeJSON");
				
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}	
	        }
	         return fileName;
	    }

	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}/change_order_pictures",
						method = RequestMethod.POST,
						consumes="application/json",
						headers = "content-type=application/x-www-form-urlencoded")
	    public @ResponseBody void changeOrderPicturesHomeTwoNarrowPictures(
	    		@RequestBody List<String> selectedIds,
	    		@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
				@PathVariable("position") String position) {
	    	
	    	logger.info("change order pictures in two narrow pictures, home"); 	

			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = (JSONObject) obj.get("homeJSON");		

					if(inTopOfTypeProduct.equals("3d_printer_top")){
			    		
						if(position.equals("1")){
							
							JSONObject list_3d_printer_top1 = null;
							
							if(homeJSON.get("list_3d_printer_top1") != null){
								list_3d_printer_top1 = (JSONObject) homeJSON.get("list_3d_printer_top1");
								homeJSON.remove("list_3d_printer_top1");
							} else {
								list_3d_printer_top1 = new JSONObject();
							}
							
							if(list_3d_printer_top1.get("fileNameArray") != null){
								list_3d_printer_top1.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_3d_printer_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_3d_printer_top1", list_3d_printer_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_3d_printer_top2 = null;
							
							if(homeJSON.get("list_3d_printer_top1") != null){
								list_3d_printer_top2 = (JSONObject) homeJSON.get("list_3d_printer_top1");
								homeJSON.remove("list_3d_printer_top1");
							} else {
								list_3d_printer_top2 = new JSONObject();
							}
							
							if(list_3d_printer_top2.get("fileNameArray") != null){
								list_3d_printer_top2.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_3d_printer_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_3d_printer_top1", list_3d_printer_top2);
			        		
			        	}
					
					} else if(inTopOfTypeProduct.equals("laminator_top")){
						
						if(position.equals("1")){
							
							JSONObject list_laminator_top1 = null;
							
							if(homeJSON.get("list_laminator_top1") != null){
								list_laminator_top1 = (JSONObject) homeJSON.get("list_laminator_top1");
								homeJSON.remove("list_laminator_top1");
							} else {
								list_laminator_top1 = new JSONObject();
							}
							
							if(list_laminator_top1.get("fileNameArray") != null){
								list_laminator_top1.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_laminator_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laminator_top1", list_laminator_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_laminator_top2 = null;
							
							if(homeJSON.get("list_laminator_top2") != null){
								list_laminator_top2 = (JSONObject) homeJSON.get("list_laminator_top2");
								homeJSON.remove("list_laminator_top2");
							} else {
								list_laminator_top2 = new JSONObject();
							}
							
							if(list_laminator_top2.get("fileNameArray") != null){
								list_laminator_top2.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_laminator_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laminator_top2", list_laminator_top2);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("cutter_top")){
						
						if(position.equals("1")){
							
							JSONObject list_cutter_top1 = null;
							
							if(homeJSON.get("list_cutter_top1") != null){
								list_cutter_top1 = (JSONObject) homeJSON.get("list_cutter_top1");
								homeJSON.remove("list_cutter_top1");
							} else {
								list_cutter_top1 = new JSONObject();
							}
							
							if(list_cutter_top1.get("fileNameArray") != null){
								list_cutter_top1.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_cutter_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_cutter_top1", list_cutter_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_cutter_top2 = null;
							
							if(homeJSON.get("list_cutter_top2") != null){
								list_cutter_top2 = (JSONObject) homeJSON.get("list_cutter_top2");
								homeJSON.remove("list_cutter_top2");
							} else {
								list_cutter_top2 = new JSONObject();
							}
							
							if(list_cutter_top2.get("fileNameArray") != null){
								list_cutter_top2.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_cutter_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_cutter_top2", list_cutter_top2);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("previously_used_top")){
						
						if(position.equals("1")){
							
							JSONObject list_previously_used_top1 = null;
							
							if(homeJSON.get("list_previously_used_top1") != null){
								list_previously_used_top1 = (JSONObject) homeJSON.get("list_previously_used_top1");
								homeJSON.remove("list_previously_used_top1");
							} else {
								list_previously_used_top1 = new JSONObject();
							}
							
							if(list_previously_used_top1.get("fileNameArray") != null){
								list_previously_used_top1.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_previously_used_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_previously_used_top1", list_previously_used_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_previously_used_top2 = null;
							
							if(homeJSON.get("list_previously_used_top2") != null){
								list_previously_used_top2 = (JSONObject) homeJSON.get("list_previously_used_top2");
								homeJSON.remove("list_previously_used_top2");
							} else {
								list_previously_used_top2 = new JSONObject();
							}
							
							if(list_previously_used_top2.get("fileNameArray") != null){
								list_previously_used_top2.remove("fileNameArray");
							} 
							
							JSONArray fileNameArray = new JSONArray();
							
							for(String fileName: selectedIds)
								fileNameArray.add(fileName);
							list_previously_used_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_previously_used_top2", list_previously_used_top2);
			        		
			        	}
					} 

					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}  	
	    }

	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}/remove_picture/{name_picture}",
						method = RequestMethod.POST,consumes="application/json",
						headers = "content-type=application/x-www-form-urlencoded")
	    public @ResponseBody void removePicturesTwoNarrowPictures(@PathVariable("name_picture") String name,
	    		@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
				@PathVariable("position") String position) {

	    	String namePicture = name.replace(":", ".");
	    	logger.info("delete picture in home, from: 'two narrow pictures', in top of type product: " + inTopOfTypeProduct); 	

	    	try {
	    		FileUtils.forceDelete(new File(directory + File.separator + "home" + 
	    				File.separator + "two_narrow_pictures" + File.separator + inTopOfTypeProduct
	    				+ File.separator + position + File.separator + namePicture));
	    		
			} catch (IOException e) {
				logger.error("Can't delete picture from the folder", e);
			} 
	    	
			JSONParser parser = new JSONParser();
			
			try {
				JSONObject obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8"));
					
					JSONObject homeJSON = (JSONObject) obj.get("homeJSON");
					
					if(inTopOfTypeProduct.equals("3d_printer_top")){
			    		
						if(position.equals("1")){
							
							JSONObject list_3d_printer_top1 = (JSONObject) homeJSON.get("list_3d_printer_top1");
							homeJSON.remove("list_3d_printer_top1");
							
							JSONArray fileNameArray = (JSONArray) list_3d_printer_top1.get("fileNameArray");
							list_3d_printer_top1.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_3d_printer_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_3d_printer_top1", list_3d_printer_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_3d_printer_top2 = (JSONObject) homeJSON.get("list_3d_printer_top2");
							homeJSON.remove("list_3d_printer_top2");
							
							JSONArray fileNameArray = (JSONArray) list_3d_printer_top2.get("fileNameArray");
							list_3d_printer_top2.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_3d_printer_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_3d_printer_top2", list_3d_printer_top2);
			        		
			        	}
					
					} else if(inTopOfTypeProduct.equals("laminator_top")){
						
						if(position.equals("1")){
							
							JSONObject list_laminator_top1 = (JSONObject) homeJSON.get("list_laminator_top1");
							homeJSON.remove("list_laminator_top1");
							
							JSONArray fileNameArray = (JSONArray) list_laminator_top1.get("fileNameArray");
							list_laminator_top1.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_laminator_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laminator_top1", list_laminator_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_laminator_top2 = (JSONObject) homeJSON.get("list_laminator_top2");
							homeJSON.remove("list_laminator_top2");
							
							JSONArray fileNameArray = (JSONArray) list_laminator_top2.get("fileNameArray");
							list_laminator_top2.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_laminator_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_laminator_top2", list_laminator_top2);
			        		
			        	} 
						
					} else if(inTopOfTypeProduct.equals("cutter_top")){
						
						if(position.equals("1")){
							
							JSONObject list_cutter_top1 = (JSONObject) homeJSON.get("list_cutter_top1");
							homeJSON.remove("list_cutter_top1");
							
							JSONArray fileNameArray = (JSONArray) list_cutter_top1.get("fileNameArray");
							list_cutter_top1.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_cutter_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_cutter_top1", list_cutter_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_cutter_top2 = (JSONObject) homeJSON.get("list_cutter_top2");
							homeJSON.remove("list_cutter_top2");
							
							JSONArray fileNameArray = (JSONArray) list_cutter_top2.get("fileNameArray");
							list_cutter_top2.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_cutter_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_cutter_top2", list_cutter_top2);
			        		
			        	}
						
					} else if(inTopOfTypeProduct.equals("previously_used_top")){
						
						if(position.equals("1")){
							
							JSONObject list_previously_used_top1 = (JSONObject) homeJSON.get("list_previously_used_top1");
							homeJSON.remove("list_previously_used_top1");
							
							JSONArray fileNameArray = (JSONArray) list_previously_used_top1.get("fileNameArray");
							list_previously_used_top1.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_previously_used_top1.put("fileNameArray", fileNameArray);
							homeJSON.put("list_previously_used_top1", list_previously_used_top1);
							
			        	} else if(position.equals("2")){
			        		
			        		JSONObject list_previously_used_top2 = (JSONObject) homeJSON.get("list_previously_used_top2");
							homeJSON.remove("list_previously_used_top2");
							
							JSONArray fileNameArray = (JSONArray) list_previously_used_top2.get("fileNameArray");
							list_previously_used_top2.remove("fileNameArray");
							
							fileNameArray.remove(namePicture);

							list_previously_used_top2.put("fileNameArray", fileNameArray);
							homeJSON.put("list_previously_used_top2", list_previously_used_top2);
			        		
			        	}
						
					} 
					
					if( obj.get("homeJSON") != null )
						obj.remove("homeJSON");
					
				obj.put("homeJSON", homeJSON);
				
				Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
	    }
}
