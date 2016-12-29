package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.printmaster.nk.beans.ComponentsForControllers;

@Controller
public class PicturesHomePageController {

	private Logger logger = Logger.getLogger(PicturesHomePageController.class);
	
    private static final String DIRECTORY = "/var/www/localhost/images";
    private static final String CONCRETE_FOLDER = "home";
	private static final String PATH_TO_JSON_FILE = "/var/www/localhost/home.json";
	
    @RequestMapping(value="/admin/pictures", method=RequestMethod.GET)
	public ModelAndView addNewPrinter() {
		logger.info("/admin/pictures page.");
	    return new ModelAndView("admin/pictures");
	}
    
    @Autowired
    ComponentsForControllers componets;   
    
    private class BlockPicturesInformation{
		private List<PictureInformation> picturesInfo;
		
		public BlockPicturesInformation(List<PictureInformation> subTypesInfo) {
			this.picturesInfo = subTypesInfo;
		}

		public List<PictureInformation> getPicturesInfo() {
			return picturesInfo;
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
			BlockPicturesInformation other = (BlockPicturesInformation) obj;
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

		public String getHeadOfPage() {
			return headOfPage;
		}

		public String getNameOfJsonObject() {
			return nameOfJsonObject;
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

        String fileName = componets.uploadPicture(request, DIRECTORY, "home", "big_reklam");

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
		
		componets.removePicture(namePicture, DIRECTORY, "home", "big_reklam"); 

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		JSONArray listPicturesOfCentralReklam = (JSONArray) homeJSON.get("listPicturesOfCentralReklam");

		listPicturesOfCentralReklam.remove(namePicture);
		homeJSON.put("listPicturesOfCentralReklam", listPicturesOfCentralReklam);

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	List<PictureInformation> rightOfReklamPictures = new ArrayList<PictureInformation>(){
		private static final long serialVersionUID = 1L;
		{
			add(new PictureInformation("1", "Изменение отображения верхней картинки справа от рекламы", "listPicturesRightOfReklam1"));
			add(new PictureInformation("2", "Изменение отображения центральной картинки справа от рекламы", "listPicturesRightOfReklam2"));
			add(new PictureInformation("3", "Изменение отображения нижней картинки справа от рекламы", "listPicturesRightOfReklam3"));
		}
	};
	
	/**
	 * 	right of big reklam 
	 * */
	@RequestMapping(value = "/admin/pictures/right_of_reklam/{position}", method = RequestMethod.GET)
	public ModelAndView showOnRightOfBigReclam(Model model, @PathVariable("position") String position) {

		String pathToPage = "admin";

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject home = (JSONObject) obj.get("homeJSON");

		PictureInformation checkedPicture = new PictureInformation(position);
		if (rightOfReklamPictures.contains(checkedPicture)) {
			PictureInformation picture = rightOfReklamPictures.get(rightOfReklamPictures.indexOf(checkedPicture));

			model.addAttribute("subDirectory", position);
			model.addAttribute("headOfPage", picture.getHeadOfPage());
			model.addAttribute("listPictures", (JSONObject) home.get(picture.getNameOfJsonObject()));
			pathToPage = "admin/pictures/right_of_reklam";
		}

		return new ModelAndView(pathToPage);
	}
	 
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/right_of_reklam/{position}/save_description/{description}", method = RequestMethod.POST)
	public @ResponseBody void saveDescriptionPicturesOnRightOfBigReclam(@PathVariable("position") String position,
			@PathVariable("description") String description) {

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		PictureInformation checkedPicture = new PictureInformation(position);
		if (rightOfReklamPictures.contains(checkedPicture)) {
			PictureInformation picture = rightOfReklamPictures.get(rightOfReklamPictures.indexOf(checkedPicture));

			JSONObject pictureInformation = (homeJSON.get(picture.getNameOfJsonObject()) != null)
					? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

			pictureInformation.put("description", description);

			homeJSON.put(picture.getNameOfJsonObject(), pictureInformation);
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}
	 
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/right_of_reklam/{position}/upload_pictures", method = RequestMethod.POST)
	public @ResponseBody String uploadPicturesRightOFBigReclam(MultipartHttpServletRequest request,
			@PathVariable("position") String position) {

		logger.info("upload new picture to the right of big reklam on home page");

		String fileName = componets.uploadPicture(request, DIRECTORY, CONCRETE_FOLDER, "right_of_reklam" + File.separator + position);

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		// add new pictures to the end
		PictureInformation checkedPicture = new PictureInformation(position);
		if (rightOfReklamPictures.contains(checkedPicture)) {
			PictureInformation picture = rightOfReklamPictures.get(rightOfReklamPictures.indexOf(checkedPicture));

			JSONObject pictureInformation = (homeJSON.get(picture.getNameOfJsonObject()) != null)
					? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

			JSONArray fileNameArray = (pictureInformation.get("fileNameArray") != null)
					? (JSONArray) pictureInformation.get("fileNameArray") : new JSONArray();

			fileNameArray.add(fileName);

			pictureInformation.put("fileNameArray", fileNameArray);

			homeJSON.put(picture.getNameOfJsonObject(), pictureInformation);
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);

		return fileName;
	}
	    
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/right_of_reklam/{position}/change_order_pictures", method = RequestMethod.POST, 
	consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void changeOrderPicturesRightOfBigReclam(@RequestBody List<String> selectedIds,
			@PathVariable("position") String position) {

		logger.info("change order pictures in left of reklam");

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		PictureInformation checkedPicture = new PictureInformation(position);
		if (rightOfReklamPictures.contains(checkedPicture)) {
			PictureInformation picture = rightOfReklamPictures.get(rightOfReklamPictures.indexOf(checkedPicture));

			JSONObject pictureInformation = (homeJSON.get(picture.getNameOfJsonObject()) != null)
					? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

			JSONArray fileNameArray = new JSONArray();

			for (String fileName : selectedIds)
				fileNameArray.add(fileName);

			pictureInformation.put("fileNameArray", fileNameArray);

			homeJSON.put(picture.getNameOfJsonObject(), pictureInformation);
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}
	    
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/right_of_reklam/{position}/remove_picture/{name_picture}", 
	method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void removePicturesRightOfBigReclam(@PathVariable("name_picture") String name,
			@PathVariable("position") String position) {

		String namePicture = name.replace(":", ".");
		logger.info("delete picture in menu, from: right_of_reklam, in subType: " + position);

		componets.removePicture(namePicture, DIRECTORY, CONCRETE_FOLDER, "right_of_reklam" + File.separator + position);

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		PictureInformation checkedPicture = new PictureInformation(position);
		if (rightOfReklamPictures.contains(checkedPicture)) {
			PictureInformation picture = rightOfReklamPictures.get(rightOfReklamPictures.indexOf(checkedPicture));

			JSONObject pictureInformation = (homeJSON.get(picture.getNameOfJsonObject()) != null)
					? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

			JSONArray fileNameArray = (pictureInformation.get("fileNameArray") != null)
					? (JSONArray) pictureInformation.get("fileNameArray") : new JSONArray();

			fileNameArray.remove(namePicture);

			pictureInformation.put("fileNameArray", fileNameArray);

			homeJSON.put(picture.getNameOfJsonObject(), pictureInformation);
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * pictures at the right of each products block
	 */
	
	Map<String, PictureInformation> picturesRightInProductBlock = new HashMap<String, PictureInformation>(){
		private static final long serialVersionUID = 1L;
		{
			put("printer_block", new PictureInformation("", "Изменение изображения справа в блоке принтеров на главном меню", "list_printer_block"));
			put("3d_printer_block", new PictureInformation("", "Изменение изображения справа в блоке 3Д принтеров на главном меню", "list_3d_printer_block"));
			put("digital_printer_block", new PictureInformation("", "Изменение изображения справа в блоке цыфровых принтеров на главном меню", 
					"list_digital_printer_block"));
			put("laminator_block", new PictureInformation("", "Изменение изображения справа в блоке ламинаторов на главном меню", "list_laminator_block"));
			put("laser_block", new PictureInformation("", "Изменение изображения справа в блоке лазеров на главном меню", "list_laser_block"));
			put("cutter_block", new PictureInformation("", "Изменение изображения справа в блоке фрезеров на главном меню", "list_cutter_block"));
			put("scaner_block", new PictureInformation("", "Изменение изображения справа в блоке сканеров на главном меню", "list_scaner_block"));
			put("previously_used_block", new PictureInformation("", "Изменение изображения справа в блоке б/у товаров на главном меню", 
					"list_previously_used_block"));
			put("rip_block", new PictureInformation("", "Изменение изображения справа в блоке ПО на главном меню", "list_rip_block"));			
		}
	};
	
	@RequestMapping(value = "/admin/pictures/home_products_block/{typeProduct}", method = RequestMethod.GET)
	public ModelAndView showHomeProductsBlock(Model model, @PathVariable("typeProduct") String typeProduct) {

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject home = (JSONObject) obj.get("homeJSON");

		if (picturesRightInProductBlock.containsKey(typeProduct)) {
			PictureInformation pictureInfo = picturesRightInProductBlock.get(typeProduct);

			model.addAttribute("directory", typeProduct);
			model.addAttribute("headOfPage", pictureInfo.getHeadOfPage());
			model.addAttribute("listPictures", (JSONArray) home.get(pictureInfo.getNameOfJsonObject()));
		}

		return new ModelAndView("admin/pictures/right_in_product_block");
	}
	    
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/home_products_block/{typeProduct}/upload_pictures", method = RequestMethod.POST)
	public @ResponseBody String uploadPicturesToHomeProductsBlock(MultipartHttpServletRequest request,
			@PathVariable("typeProduct") String typeProduct) {

		logger.info("upload new picture to products block on home page");

		String fileName = componets.uploadPicture(request, DIRECTORY, CONCRETE_FOLDER, "product_block" + File.separator + typeProduct);

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		if (picturesRightInProductBlock.containsKey(typeProduct)) {
			PictureInformation pictureInfo = picturesRightInProductBlock.get(typeProduct);

			JSONArray listPictures = (homeJSON.get(pictureInfo.getNameOfJsonObject()) != null)
					? (JSONArray) homeJSON.get(pictureInfo.getNameOfJsonObject()) : new JSONArray();

			listPictures.add(fileName);
			homeJSON.put(pictureInfo.getNameOfJsonObject(), listPictures);
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);

		return fileName;
	}
	    
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/home_products_block/{typeProduct}/change_order_pictures", 
	method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void changeOrderPicturesHomeProductsBlock(@RequestBody List<String> selectedIds,
			@PathVariable("typeProduct") String typeProduct) {

		logger.info("change order pictures in central rekalam");

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		if (picturesRightInProductBlock.containsKey(typeProduct)) {
			PictureInformation pictureInfo = picturesRightInProductBlock.get(typeProduct);

			JSONArray listPictures = new JSONArray();

			for (String fileName : selectedIds)
				listPictures.add(fileName);

			homeJSON.put(pictureInfo.getNameOfJsonObject(), listPictures);
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}
	    
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/home_products_block/{typeProduct}/remove_picture/{name_picture}", 
	method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void removePicturesHomeProductBlocks(@PathVariable("name_picture") String name,
			@PathVariable("typeProduct") String typeProduct) {

		String namePicture = name.replace(":", ".");
		logger.info("delete picture in home page, from product block");

		componets.removePicture(namePicture, DIRECTORY, CONCRETE_FOLDER,
				"product_block" + File.separator + typeProduct);

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (JSONObject) obj.get("homeJSON");

		if (picturesRightInProductBlock.containsKey(typeProduct)) {
			PictureInformation pictureInfo = picturesRightInProductBlock.get(typeProduct);

			JSONArray listPictures = (homeJSON.get(pictureInfo.getNameOfJsonObject()) != null)
					? (JSONArray) homeJSON.get(pictureInfo.getNameOfJsonObject()) : new JSONArray();

			listPictures.remove(namePicture);
			homeJSON.put(pictureInfo.getNameOfJsonObject(), listPictures);
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}
	    
	    
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    	    
	    Map<String, BlockPicturesInformation> picturesInTopProductSection = new HashMap<String, BlockPicturesInformation>(){
			private static final long serialVersionUID = 1L;
			{
				final String standartPhrase = "Изменение картинки отображения над подразделом ";
				put("printer_top", new BlockPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", standartPhrase + "принтеров №1", "list_printer_top1"),
								new PictureInformation("2", standartPhrase + "принтеров №2", "list_printer_top2"),
								new PictureInformation("3", standartPhrase + "принтеров №3", "list_printer_top3")
							)));
				
				put("digital_printer_top", new BlockPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", standartPhrase + "цыфровых принтеров №1", "list_digital_printer_top1"),
								new PictureInformation("2", standartPhrase + "цыфровых принтеров №2", "list_digital_printer_top2"),
								new PictureInformation("3", standartPhrase + "цыфровых принтеров №3", "list_digital_printer_top3")
							)));
				
				put("laser_top", new BlockPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", standartPhrase + "лазеров №1", "list_laser_top1"),
								new PictureInformation("2", standartPhrase + "лазеров №2", "list_laser_top2"),
								new PictureInformation("3", standartPhrase + "лазеров №3", "list_laser_top3")
							)));
				
				put("scaner_top", new BlockPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", standartPhrase + "сканеров №1", "list_scaner_top1"),
								new PictureInformation("2", standartPhrase + "сканеров №2", "list_scaner_top2"),
								new PictureInformation("3", standartPhrase + "сканеров №3", "list_scaner_top3")
							)));

				put("rip_top", new BlockPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", standartPhrase + "ПО №1", "list_rip_top1"),
								new PictureInformation("2", standartPhrase + "ПО №2", "list_rip_top2"),
								new PictureInformation("3", standartPhrase + "ПО №3", "list_rip_top3")
							)));
				
				put("3d_printer_top", new BlockPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", standartPhrase + "3D принтеров №1", "list_3d_printer_top1"),
								new PictureInformation("2", standartPhrase + "3D принтеров №2", "list_3d_printer_top2")
							)));
			
				put("laminator_top", new BlockPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", standartPhrase + "ламинаторов №1", "list_laminator_top1"),
								new PictureInformation("2", standartPhrase + "ламинаторов №2", "list_laminator_top2")
							)));
				
				put("cutter_top", new BlockPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", standartPhrase + "фрезеров №1", "list_cutter_top1"),
								new PictureInformation("2", standartPhrase + "фрезеров №2", "list_cutter_top2")
							)));
				
				put("previously_used_top", new BlockPicturesInformation(
						Arrays.asList(
								new PictureInformation("1", standartPhrase + "б/у товаров №1", "list_previously_used_top1"),
								new PictureInformation("2", standartPhrase + "б/у товаров №2", "list_previously_used_top2")
							)));
				
			}
		}; 
	    
	/**
	 * block with three big pictures
	 */
	@RequestMapping(value = "/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}", method = RequestMethod.GET)
	public ModelAndView showThreeBigPictures(Model model, @PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct,
			@PathVariable("position") String position) {

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
	@RequestMapping(value = "/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}/save_description/{href}", method = RequestMethod.POST)
	public @ResponseBody void saveHrefPictureOnThreeBigPictures(
			@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct, @PathVariable("position") String position,
			@PathVariable("href") String href) {

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (obj.get("homeJSON") != null) ? (JSONObject) obj.get("homeJSON") : new JSONObject();

		if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {

			List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();

			if (pictures.contains(new PictureInformation(position))) {

				PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));

				JSONObject pictureInfo = (homeJSON.get(picture.getNameOfJsonObject()) != null)
						? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

				pictureInfo.put("href", href);

				homeJSON.put(picture.getNameOfJsonObject(), pictureInfo);
			}
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}/upload_pictures", method = RequestMethod.POST)
	public @ResponseBody String uploadPicturesOnThreeBigPictures(MultipartHttpServletRequest request,
			@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct, @PathVariable("position") String position) {

		logger.info("upload new picture to the one of thee big pictures on home page");

		String fileName = componets.uploadPicture(request, DIRECTORY, CONCRETE_FOLDER,
				"three_big_pictures" + File.separator + inTopOfTypeProduct + File.separator + position);

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (obj.get("homeJSON") != null) ? (JSONObject) obj.get("homeJSON") : new JSONObject();

		if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {

			List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();

			if (pictures.contains(new PictureInformation(position))) {

				PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));

				JSONObject pictureInfo = (homeJSON.get(picture.getNameOfJsonObject()) != null)
						? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

				JSONArray fileNameArray = (pictureInfo.get("fileNameArray") != null)
						? (JSONArray) pictureInfo.get("fileNameArray") : new JSONArray();
				fileNameArray.add(fileName);

				pictureInfo.put("fileNameArray", fileNameArray);
				homeJSON.put(picture.getNameOfJsonObject(), pictureInfo);
			}
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);

		return fileName;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}/change_order_pictures", 
	method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void changeOrderPicturesHomeThreeBigPictures(@RequestBody List<String> selectedIds,
			@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct, @PathVariable("position") String position) {

		logger.info("change order pictures in three big pictures, home");

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (obj.get("homeJSON") != null) ? (JSONObject) obj.get("homeJSON") : new JSONObject();

		if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {

			List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();

			if (pictures.contains(new PictureInformation(position))) {

				PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));

				JSONObject pictureInfo = (homeJSON.get(picture.getNameOfJsonObject()) != null)
						? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

				JSONArray fileNameArray = new JSONArray();
				for (String fileName : selectedIds)
					fileNameArray.add(fileName);

				pictureInfo.put("fileNameArray", fileNameArray);
				homeJSON.put(picture.getNameOfJsonObject(), pictureInfo);
			}
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/three_big_pictures/{inTopOfTypeProduct}/{position}/remove_picture/{name_picture}", 
	method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void removePicturesThreeBigPictures(@PathVariable("name_picture") String name,
			@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct, @PathVariable("position") String position) {

		String namePicture = name.replace(":", ".");
		logger.info("delete picture in home, from: 'three big pictures', in top of type product: " + inTopOfTypeProduct);

		componets.removePicture(namePicture, DIRECTORY, CONCRETE_FOLDER,
				"three_big_pictures" + File.separator + inTopOfTypeProduct + File.separator + position);

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (obj.get("homeJSON") != null) ? (JSONObject) obj.get("homeJSON") : new JSONObject();

		if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {

			List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();

			if (pictures.contains(new PictureInformation(position))) {

				PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));

				JSONObject pictureInfo = (homeJSON.get(picture.getNameOfJsonObject()) != null)
						? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

				JSONArray fileNameArray = (pictureInfo.get("fileNameArray") != null)
						? (JSONArray) pictureInfo.get("fileNameArray") : new JSONArray();

				fileNameArray.remove(namePicture);

				pictureInfo.put("fileNameArray", fileNameArray);
				homeJSON.put(picture.getNameOfJsonObject(), pictureInfo);
			}
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * block with two narrow pictures
	 */
	@RequestMapping(value = "/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}", method = RequestMethod.GET)
	public ModelAndView showTwoNarrowPictures(Model model,
			@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct, @PathVariable("position") String position) {

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
	@RequestMapping(value = "/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}/save_description/{href}", method = RequestMethod.POST)
	public @ResponseBody void saveHrefPictureOnTwoNarrowPictures(
			@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct, @PathVariable("position") String position,
			@PathVariable("href") String href) {

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (obj.get("homeJSON") != null) ? (JSONObject) obj.get("homeJSON") : new JSONObject();

		if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {

			List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();

			if (pictures.contains(new PictureInformation(position))) {

				PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));

				JSONObject pictureInfo = (homeJSON.get(picture.getNameOfJsonObject()) != null)
						? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

				pictureInfo.put("href", href);

				homeJSON.put(picture.getNameOfJsonObject(), pictureInfo);
			}
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}/upload_pictures", method = RequestMethod.POST)
	public @ResponseBody String uploadPicturesOnTwoNarrowPictures(MultipartHttpServletRequest request,
			@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct, @PathVariable("position") String position) {

		logger.info("upload new picture to the one of two narrows pictures on home page");

		String fileName = componets.uploadPicture(request, DIRECTORY, CONCRETE_FOLDER,
				"two_narrow_pictures" + File.separator + inTopOfTypeProduct + File.separator + position);

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (obj.get("homeJSON") != null) ? (JSONObject) obj.get("homeJSON") : new JSONObject();

		if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {

			List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();

			if (pictures.contains(new PictureInformation(position))) {

				PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));

				JSONObject pictureInfo = (homeJSON.get(picture.getNameOfJsonObject()) != null)
						? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

				JSONArray fileNameArray = (pictureInfo.get("fileNameArray") != null)
						? (JSONArray) pictureInfo.get("fileNameArray") : new JSONArray();
				fileNameArray.add(fileName);

				pictureInfo.put("fileNameArray", fileNameArray);
				homeJSON.put(picture.getNameOfJsonObject(), pictureInfo);
			}
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);

		return fileName;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}/change_order_pictures", 
	method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void changeOrderPicturesHomeTwoNarrowPictures(@RequestBody List<String> selectedIds,
			@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct, @PathVariable("position") String position) {

		logger.info("change order pictures in two narrow pictures, home");

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (obj.get("homeJSON") != null) ? (JSONObject) obj.get("homeJSON") : new JSONObject();

		if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {

			List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();

			if (pictures.contains(new PictureInformation(position))) {

				PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));

				JSONObject pictureInfo = (homeJSON.get(picture.getNameOfJsonObject()) != null)
						? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

				JSONArray fileNameArray = new JSONArray();
				for (String fileName : selectedIds)
					fileNameArray.add(fileName);

				pictureInfo.put("fileNameArray", fileNameArray);
				homeJSON.put(picture.getNameOfJsonObject(), pictureInfo);
			}
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pictures/two_narrow_pictures/{inTopOfTypeProduct}/{position}/remove_picture/{name_picture}", 
	method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void removePicturesTwoNarrowPictures(@PathVariable("name_picture") String name,
			@PathVariable("inTopOfTypeProduct") String inTopOfTypeProduct, @PathVariable("position") String position) {

		String namePicture = name.replace(":", ".");
		logger.info(
				"delete picture in home, from: 'two narrow pictures', in top of type product: " + inTopOfTypeProduct);

		componets.removePicture(namePicture, DIRECTORY, CONCRETE_FOLDER,
				"two_narrow_pictures" + File.separator + inTopOfTypeProduct + File.separator + position);

		JSONObject obj = getJsonPicturesLinksContainer();
		JSONObject homeJSON = (obj.get("homeJSON") != null) ? (JSONObject) obj.get("homeJSON") : new JSONObject();

		if (picturesInTopProductSection.containsKey(inTopOfTypeProduct)) {

			List<PictureInformation> pictures = picturesInTopProductSection.get(inTopOfTypeProduct).getPicturesInfo();

			if (pictures.contains(new PictureInformation(position))) {

				PictureInformation picture = pictures.get(pictures.indexOf(new PictureInformation(position)));

				JSONObject pictureInfo = (homeJSON.get(picture.getNameOfJsonObject()) != null)
						? (JSONObject) homeJSON.get(picture.getNameOfJsonObject()) : new JSONObject();

				JSONArray fileNameArray = (pictureInfo.get("fileNameArray") != null)
						? (JSONArray) pictureInfo.get("fileNameArray") : new JSONArray();

				fileNameArray.remove(namePicture);

				pictureInfo.put("fileNameArray", fileNameArray);
				homeJSON.put(picture.getNameOfJsonObject(), pictureInfo);
			}
		}

		obj.put("homeJSON", homeJSON);
		writeResultInLocalFile(obj);
	}
}
