package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
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
public class PicturesMenuController {
	
	private Logger logger = Logger.getLogger(PicturesMenuController.class);
	
	private final static String DIRECTORY = "/var/www/localhost/images";
	
	private final static String CONCRETE_FOLDER = "menu";
	
	private final static String PATH_TO_JSON_FILE = "/var/www/localhost" + File.separator + "pictures_head_menu.json";
	
	@Autowired
    ComponentsForControllers componets;
    
	private class TypeProductInformation{
		private String nameJsonObject;
		private List<SubTypeInformation> subTypesInfo;
		
		public TypeProductInformation(String nameJsonObject, List<SubTypeInformation> subTypesInfo) {
			this.nameJsonObject = nameJsonObject;
			this.subTypesInfo = subTypesInfo;
		}
		public String getNameJsonObject() {
			return nameJsonObject;
		}

		public List<SubTypeInformation> getSubTypesInfo() {
			return subTypesInfo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((nameJsonObject == null) ? 0 : nameJsonObject.hashCode());
			result = prime * result + ((subTypesInfo == null) ? 0 : subTypesInfo.hashCode());
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
			TypeProductInformation other = (TypeProductInformation) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (nameJsonObject == null) {
				if (other.nameJsonObject != null)
					return false;
			} else if (!nameJsonObject.equals(other.nameJsonObject))
				return false;
			if (subTypesInfo == null) {
				if (other.subTypesInfo != null)
					return false;
			} else if (!subTypesInfo.equals(other.subTypesInfo))
				return false;
			return true;
		}
		private PicturesMenuController getOuterType() {
			return PicturesMenuController.this;
		}
	}
	
	private class SubTypeInformation{
		private String nameSubType;
		private String headOfPage;
		private String nameOfJsonArray;

		public SubTypeInformation(String nameSubType, String headOfPage, String nameOfJsonArray) {
			this.nameSubType = nameSubType;
			this.headOfPage = headOfPage;
			this.nameOfJsonArray = nameOfJsonArray;
		}
		
		public SubTypeInformation(String nameSubType) {
			this.nameSubType = nameSubType;
		}
		
		public String getHeadOfPage() {
			return headOfPage;
		}

		public String getNameOfJsonArray() {
			return nameOfJsonArray;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((nameSubType == null) ? 0 : nameSubType.hashCode());
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
			SubTypeInformation other = (SubTypeInformation) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (nameSubType == null) {
				if (other.nameSubType != null)
					return false;
			} else if (!nameSubType.equals(other.nameSubType))
				return false;
			return true;
		}

		private PicturesMenuController getOuterType() {
			return PicturesMenuController.this;
		}
	}
	
	Map<String, TypeProductInformation> picturesLinkerToHoleTypeSection = new HashMap<String, TypeProductInformation>(){
		private static final long serialVersionUID = 1L;
		{
			put("printers", new TypeProductInformation("printersJSON", 
					Arrays.asList(
							new SubTypeInformation("dissolving", "Изменение картинки отображения СОЛЬВЕНТНЫХ ПРИНТЕРОВ", "listPicturesDissolvingPrinters"),
							new SubTypeInformation("ecosolvent", "Изменение картинки отображения ЭКОСОЛЬВЕНТНЫХ ПРИНТЕРОВ", "listPicturesEcosolventPrinters"),
							new SubTypeInformation("UV_roll", "Изменение картинки отображения UV РУЛОННИХ ПРИНТЕРОВ", "listPicturesUvRollPrinters"),
							new SubTypeInformation("UV_flatbed", "Изменение картинки отображения UV ПЛОСКОПЕЧАТНЫХ ПРИНТЕРОВ", "listPicturesUvFlatbedPrinters"),
							new SubTypeInformation("sublimation", "Изменение картинки отображения СУБЛИМАЦИОННЫХ ПРИНТЕРОВ", "listPicturesSublimationPrinters"),
							new SubTypeInformation("textile", "Изменение картинки отображения ТЕКСТИЛЬНЫХ ПРИНТЕРОВ", "listPicturesTextilePrinters"),
							new SubTypeInformation("water_pigment", "Изменение картинки отображения ВОДНЫХ/ПИГМЕНТНЫХ ПРИНТЕРОВ",
									"listPicturesWaterPigmentPrinters"),
							new SubTypeInformation("digital", "Изменение картинки отображения ЦИФРОВЫХ ПРИНТЕРОВ", "listPicturesDigitalPrinters"),
							new SubTypeInformation("SAPR-GIS", "Изменение картинки отображения САПР/ГИС ПРИНТЕРОВ", "listPictures_SAPR_GIS_Printers")
						)));
			
			put("printers3d", new TypeProductInformation("printers3dJSON", 
					Arrays.asList(
							new SubTypeInformation("FDM-extruder", "Изменение картинки отображения ЭКСТРУДНЫХ FDM ПРИНТЕРОВ", "list_3dPrintersFDM_Extruder"),
							new SubTypeInformation("photo_printing_polyjet", "Изменение картинки отображения ФОТО ПЕЧАТЬ Polyjet", 
									"list_3d_printers_photo_printing_polyjet"),
							new SubTypeInformation("laser_sintering_LENS", "Изменение картинки отображения 3D ПРИНТЕРЫ ЛАЗЕРНОГО СПЕКАНИЯ LENS", 
									"list_3d_printers_laser_sintering_LENS"),
							new SubTypeInformation("lamination_LOM", "Изменение картинки отображения ЛАМИНАЦИИ LOM", "list_3d_printers_lamination_LOM"),
							new SubTypeInformation("stereolithography_SL", "Изменение картинки отображения СТЕРЕОЛИТОГРАФИЯ SL", 
									"list_3d_printers_stereolithography_SL"),
							new SubTypeInformation("laser_sintering_LS", "Изменение картинки отображения ЛАЗЕРНОЕ СПЕКАНИЕ LS",
									"list_3d_printers_laser_sintering_LS"),
							new SubTypeInformation("powder_bonding_3DP", "Изменение картинки отображения ПОРОШКОВОГО СКЛЕИВАНИЯ 3DP",
									"list_3d_printers_powder_bonding_3DP")
						)));
			
			put("digital_printers", new TypeProductInformation("digital_printersJSON", 
					Arrays.asList(
							new SubTypeInformation("full_color_laser_printers", "Изменение картинки отображения 'Полноцветные лазерные принтеры'", 
									"list_full_color_laser_printers"),
							new SubTypeInformation("monochrome_laser_printers", "Изменение картинки отображения 'Монохромные лазерные принтеры'", 
									"list_monochrome_laser_printers"),
							new SubTypeInformation("full-color_inkjet_printers", "Изменение картинки отображения 'Полноцветные струйные принтеры'", 
									"list_full_color_inkjet_printers")
						)));
			
			put("laminator", new TypeProductInformation("laminatorJSON", 
					Arrays.asList(
							new SubTypeInformation("hot_lamination", "Изменение картинки отображения ГОРЯЧЕГО ЛАМИНИРОВАНИЯ", "list_hot_lamination"),
							new SubTypeInformation("cold_laminating", "Изменение картинки отображения ХОЛОДНОГО ЛАМИНИРОВАНИЯ", "list_cold_laminating"),
							new SubTypeInformation("liquid", "Изменение картинки отображения ЖИДКОГО ЛАМИНИРОВАНИЯ", "list_liquid"),
							new SubTypeInformation("flatbed_laminating_machine", "Изменение картинки отображения ПЛАНШЕТНЫЙ ЛАМИНАТОР", 
									"list_flatbed_laminating_machine")
						)));
			
			put("laser", new TypeProductInformation("laserJSON", 
					Arrays.asList(
							new SubTypeInformation("CO2_gas_lasers", "Изменение картинки отображения ГАЗОВЫЕ ЛАЗЕРЫ СО2", "list_CO2_gas_lasers"),
							new SubTypeInformation("solid_state_lasers", "Изменение картинки отображения ТВЕРДОТЕЛЬНЫЕ ЛАЗЕРЫ", "list_solid_state_lasers"),
							new SubTypeInformation("for_the_treatment_of_metal", "Изменение картинки отображения ЛАЗЕРА ДЛЯ ОБРАБОТКИ МЕТАЛА", 
									"list_for_the_treatment_of_metal"),
							new SubTypeInformation("diode_pumped", "Изменение картинки отображения ЛАЗЕРЫ С ДИОДНОЙ НАКАЧКОЙ", "list_diode_pumped"),
							new SubTypeInformation("fiber_lasers", "Изменение картинки отображения ОПТОВОЛОКОННЫЕ ЛАЗЕРЫ", "list_fiber_lasers"),
							new SubTypeInformation("plasma_lasers", "Изменение картинки отображения ПЛАЗМЕННЫЕ ЛАЗЕРЫ", "list_plasma_lasers")
						)));
			
			put("cutter", new TypeProductInformation("cutterJSON", 
					Arrays.asList(
							new SubTypeInformation("for_wood", "Изменение картинки для отображения ФРЕЗЕРЫ ДЛЯ ОБРАБОТКИ ДЕРЕВА", "list_for_wood"),
							new SubTypeInformation("for_the_treatment_of_metal", "Изменение картинки для отображения ФРЕЗЕРЫ ДЛЯ ОБРАБОТКИ МЕТАЛА", 
									"list_for_the_treatment_of_metal"),
							new SubTypeInformation("stone_processing", "Изменение картинки для отображения ФРЕЗЕРЫ ДЛЯ ОБРАБОТКИ КАМНЯ", 
									"list_stone_processing")
						)));

			put("scanner", new TypeProductInformation("scannerJSON", 
					Arrays.asList(
							new SubTypeInformation("large_format_scanners", "Изменение картинки для отображения ШИРОКОФОРМАТНЫЕ СКАННЕРЫ", 
									"list_large_format_scanners"),
							new SubTypeInformation("3d_scanners", "Изменение картинки для отображения 3D Сканеров", "list_3d_scanners")
						)));
			
			put("previouslyUsed", new TypeProductInformation("previouslyUsedJSON", 
					Arrays.asList(
							new SubTypeInformation("solvent_equipment", "Изменение картинки для отображения СОЛЬВЕНТНОЕ ОБОРУДОВАНИЕ ПРЕДИДУЩЕГО ИСПОЛЬЗОВАНИЯ", 
									"list_solvent_equipment"),
							new SubTypeInformation("ecosolvent_oborudovnie", "Изменение картинки для отображения ЭКОСОЛЬВЕНЬНОЕ ОБОРУДОВАНИЕ"
									+ " ПРЕДИДУЩЕГО ИСПОЛЬЗОВАНИЯ", "list_ecosolvent_oborudovnie")
						)));
			
			put("rip", new TypeProductInformation("ripJSON", 
					Arrays.asList(
							new SubTypeInformation("RIP_system", "Изменение картинки для отображения RIP СИСТЕМЫ", "list_RIP_system")
						)));			
		}
	};
	
    @RequestMapping(value="/admin/pictures/menu/{typeProduct}/{subTypeProduct}", method = RequestMethod.GET)
    public ModelAndView showMenu(Model model, @PathVariable("typeProduct") String typeProduct,
    							 @PathVariable("subTypeProduct") String subTypeProduct){

		String pathToPage = "admin";

		if (picturesLinkerToHoleTypeSection.containsKey(typeProduct)) {

			String nameJsonObject = picturesLinkerToHoleTypeSection.get(typeProduct).getNameJsonObject();
			List<SubTypeInformation> subTypesInfo = picturesLinkerToHoleTypeSection.get(typeProduct).getSubTypesInfo();

			if (subTypesInfo.contains( new SubTypeInformation(subTypeProduct) )) {

				SubTypeInformation subType = subTypesInfo.get(subTypesInfo.indexOf( new SubTypeInformation(subTypeProduct) ));

				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", subType.getHeadOfPage());

				JSONObject holeProduct = (JSONObject) getJsonPicturesLinksContainer().get(nameJsonObject);
				model.addAttribute("listPictures", (JSONArray) holeProduct.get(subType.getNameOfJsonArray()));
				pathToPage = String.format("admin/pictures/menu/%s/%s", typeProduct, subTypeProduct);
			}
		}

		return new ModelAndView(pathToPage);
    }
    
    /**
     * @return JSONObject which contain all links for pictures in horizontal menu on user pages
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
	@RequestMapping(value="/admin/pictures/menu/{typeProduct}/{subTypeProduct}/upload_pictures", method = RequestMethod.POST)
    public @ResponseBody String uploadPicturesMenu(MultipartHttpServletRequest request,
    		@PathVariable("typeProduct") String typeProduct,
    		@PathVariable("subTypeProduct") String subTypeProduct) {

		logger.info("upload new picture to the menu");

		String fileName = componets.uploadPicture(request, DIRECTORY, CONCRETE_FOLDER, typeProduct);

		JSONObject obj = getJsonPicturesLinksContainer();

		if (picturesLinkerToHoleTypeSection.containsKey(typeProduct)) {
			String nameJsonObject = picturesLinkerToHoleTypeSection.get(typeProduct).getNameJsonObject();

			JSONObject productJSON = (obj.get(nameJsonObject) != null) ? (JSONObject) obj.get(nameJsonObject) : new JSONObject();

			List<SubTypeInformation> subTypesInfo = picturesLinkerToHoleTypeSection.get(typeProduct).getSubTypesInfo();

			// add new pictures to the end
			if (subTypesInfo.contains(new SubTypeInformation(subTypeProduct))) {

				SubTypeInformation subTypePictures = subTypesInfo.get(subTypesInfo.indexOf(new SubTypeInformation(subTypeProduct)));
				String nameOfJsonArray = subTypePictures.getNameOfJsonArray();

				// check if these sub-directory has pictures
				JSONArray listSubProductPrictures = (productJSON.get(nameOfJsonArray) != null) ? (JSONArray) productJSON.get(nameOfJsonArray) : new JSONArray();

				listSubProductPrictures.add(fileName);
				productJSON.put(nameOfJsonArray, listSubProductPrictures);

			}
			obj.put(nameJsonObject, productJSON);
		}

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
	@RequestMapping(value="/admin/pictures/menu/{typeProduct}/{subTypeProduct}/change_order_pictures",
					method = RequestMethod.POST,
					consumes="application/json",
					headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesMenu(
    		@RequestBody List<String> selectedIds,
    		@PathVariable("typeProduct") String typeProduct,
    		@PathVariable("subTypeProduct") String subTypeProduct) {
    	
    	logger.info("change order pictures in menu"); 	
    	
    	JSONObject obj = getJsonPicturesLinksContainer();

    	if (picturesLinkerToHoleTypeSection.containsKey(typeProduct)) {
			String nameJsonObject = picturesLinkerToHoleTypeSection.get(typeProduct).getNameJsonObject();

			JSONObject productJSON = (obj.get(nameJsonObject) != null) ? (JSONObject) obj.get(nameJsonObject) : new JSONObject();

			List<SubTypeInformation> subTypesInfo = picturesLinkerToHoleTypeSection.get(typeProduct).getSubTypesInfo();

			if (subTypesInfo.contains(new SubTypeInformation(subTypeProduct))) {

				SubTypeInformation subTypePictures = subTypesInfo.get(subTypesInfo.indexOf(new SubTypeInformation(subTypeProduct)));
				String nameOfJsonArray = subTypePictures.getNameOfJsonArray();

				JSONArray listSubProductPrictures = new JSONArray();

				for(String fileName: selectedIds)
					listSubProductPrictures.add(fileName);
				productJSON.put(nameOfJsonArray, listSubProductPrictures);

			}
			obj.put(nameJsonObject, productJSON);
		}
    	
    	writeResultInLocalFile(obj);
    	
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/admin/pictures/menu/{typeProduct}/{subTypeProduct}/remove_picture/{name_picture}",
					method = RequestMethod.POST,consumes="application/json",
					headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicturesMenu(@PathVariable("name_picture") String name,
    		@PathVariable("typeProduct") String typeProduct,
    		@PathVariable("subTypeProduct") String subTypeProduct) {

    	String namePicture = name.replace(":", ".");
    	logger.info(String.format("delete picture in menu, from: %s , in subType: %s", typeProduct, subTypeProduct)); 	
    	
    	componets.removePicture(namePicture, DIRECTORY, CONCRETE_FOLDER, typeProduct); 
    	
    	JSONObject obj = getJsonPicturesLinksContainer();

    	if (picturesLinkerToHoleTypeSection.containsKey(typeProduct)) {
			String nameJsonObject = picturesLinkerToHoleTypeSection.get(typeProduct).getNameJsonObject();

			JSONObject productJSON = (obj.get(nameJsonObject) != null) ? (JSONObject) obj.get(nameJsonObject) : new JSONObject();

			List<SubTypeInformation> subTypesInfo = picturesLinkerToHoleTypeSection.get(typeProduct).getSubTypesInfo();

			if (subTypesInfo.contains(new SubTypeInformation(subTypeProduct))) {

				SubTypeInformation subTypePictures = subTypesInfo.get(subTypesInfo.indexOf(new SubTypeInformation(subTypeProduct)));
				String nameOfJsonArray = subTypePictures.getNameOfJsonArray();

				JSONArray listSubProductPrictures = (JSONArray) productJSON.get(nameOfJsonArray);

				listSubProductPrictures.remove(namePicture);	
				productJSON.put(nameOfJsonArray, listSubProductPrictures);

			}
			obj.put(nameJsonObject, productJSON);
		}
    	
    	writeResultInLocalFile(obj);
    }
}
