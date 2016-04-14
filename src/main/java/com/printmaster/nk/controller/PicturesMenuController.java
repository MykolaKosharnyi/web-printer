package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

@Controller
public class PicturesMenuController {
	
	private Logger logger = Logger.getLogger(PicturesMenuController.class);
	
	private String directory = "/var/www/localhost/images";
//	private String directory = "D:/images";
	
	private JSONObject obj = null;
	private String path = "/var/www/localhost" + File.separator + "pictures_head_menu.json";
    
    @RequestMapping(value="/admin/pictures/menu/{typeProduct}/{subTypeProduct}", method = RequestMethod.GET)
    public ModelAndView showMenu(Model model, @PathVariable("typeProduct") String typeProduct,
    							 @PathVariable("subTypeProduct") String subTypeProduct){
    	
    	String pathToPage = "admin";
    	
    	JSONParser parser = new JSONParser();
    	try {
			obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		
    	if(typeProduct.equals("printers")){
    		JSONObject printers = (JSONObject) obj.get("printersJSON");
    		
			if(subTypeProduct.equals("dissolving")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения СОЛЬВЕНТНЫХ ПРИНТЕРОВ");
				model.addAttribute("listPictures", (JSONArray) printers.get("listPicturesDissolvingPrinters"));
				pathToPage = "admin/pictures/menu/printers/dissolving";
				
        	} else if(subTypeProduct.equals("ecosolvent")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ЭКОСОЛЬВЕНТНЫХ ПРИНТЕРОВ");
        		model.addAttribute("listPictures", (JSONArray) printers.get("listPicturesEcosolventPrinters"));
        		pathToPage = "admin/pictures/menu/printers/ecosolvent";
        		
        	} else if(subTypeProduct.equals("UV_roll")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения UV РУЛОННИХ ПРИНТЕРОВ");
        		model.addAttribute("listPictures", (JSONArray) printers.get("listPicturesUvRollPrinters"));
        		pathToPage = "admin/pictures/menu/printers/UV_roll";
        		
        	} else if(subTypeProduct.equals("UV_flatbed")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения UV ПЛОСКОПЕЧАТНЫХ ПРИНТЕРОВ");
        		model.addAttribute("listPictures", (JSONArray) printers.get("listPicturesUvFlatbedPrinters"));
        		pathToPage = "admin/pictures/menu/printers/UV_flatbed";
        		
        	} else if(subTypeProduct.equals("sublimation")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения СУБЛИМАЦИОННЫХ ПРИНТЕРОВ");
        		model.addAttribute("listPictures", (JSONArray) printers.get("listPicturesSublimationPrinters"));
        		pathToPage = "admin/pictures/menu/printers/sublimation";
        		
        	} else if(subTypeProduct.equals("textile")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ТЕКСТИЛЬНЫХ ПРИНТЕРОВ");
        		model.addAttribute("listPictures", (JSONArray) printers.get("listPicturesTextilePrinters"));
        		pathToPage = "admin/pictures/menu/printers/textile";
        		
        	} else if(subTypeProduct.equals("water_pigment")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ВОДНЫХ/ПИГМЕНТНЫХ ПРИНТЕРОВ");
        		model.addAttribute("listPictures", (JSONArray) printers.get("listPicturesWaterPigmentPrinters"));
        		pathToPage = "admin/pictures/menu/printers/water_pigment";
        		
        	} else if(subTypeProduct.equals("digital")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ЦИФРОВЫХ ПРИНТЕРОВ");
        		model.addAttribute("listPictures", (JSONArray) printers.get("listPicturesDigitalPrinters"));
        		pathToPage = "admin/pictures/menu/printers/digital";
        		
        	} else if(subTypeProduct.equals("SAPR-GIS")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения САПР/ГИС ПРИНТЕРОВ");
        		model.addAttribute("listPictures", (JSONArray) printers.get("listPictures_SAPR_GIS_Printers"));
        		pathToPage = "admin/pictures/menu/printers/SAPR-GIS";
        	}
		
		} else if(typeProduct.equals("printers3d")){
			JSONObject printers3d = (JSONObject) obj.get("printers3dJSON");
			
			if(subTypeProduct.equals("FDM-extruder")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ЭКСТРУДНЫХ FDM ПРИНТЕРОВ");
				model.addAttribute("listPictures", (JSONArray) printers3d.get("list_3dPrintersFDM_Extruder"));
				pathToPage = "admin/pictures/menu/printers3d/FDM-extruder";
				
        	} else if(subTypeProduct.equals("photo_printing_polyjet")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ФОТО ПЕЧАТЬ Polyjet");
        		model.addAttribute("listPictures", (JSONArray) printers3d.get("list_3d_printers_photo_printing_polyjet"));
        		pathToPage = "admin/pictures/menu/printers3d/photo_printing_polyjet";
        		
        	} else if(subTypeProduct.equals("laser_sintering_LENS")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения 3D ПРИНТЕРЫ ЛАЗЕРНОГО СПЕКАНИЯ LENS");
        		model.addAttribute("listPictures", (JSONArray) printers3d.get("list_3d_printers_laser_sintering_LENS"));
        		pathToPage = "admin/pictures/menu/printers3d/laser_sintering_LENS";
        		
        	} else if(subTypeProduct.equals("lamination_LOM")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ЛАМИНАЦИИ LOM");
        		model.addAttribute("listPictures", (JSONArray) printers3d.get("list_3d_printers_lamination_LOM"));
        		pathToPage = "admin/pictures/menu/printers3d/lamination_LOM";
        		
        	} else if(subTypeProduct.equals("stereolithography_SL")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения СТЕРЕОЛИТОГРАФИЯ SL");
        		model.addAttribute("listPictures", (JSONArray) printers3d.get("list_3d_printers_stereolithography_SL"));
        		pathToPage = "admin/pictures/menu/printers3d/stereolithography_SL";
        		
        	} else if(subTypeProduct.equals("laser_sintering_LS")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ЛАЗЕРНОЕ СПЕКАНИЕ LS");
        		model.addAttribute("listPictures", (JSONArray) printers3d.get("list_3d_printers_laser_sintering_LS"));
        		pathToPage = "admin/pictures/menu/printers3d/laser_sintering_LS";
        		
        	} else if(subTypeProduct.equals("powder_bonding_3DP")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ПОРОШКОВОГО СКЛЕИВАНИЯ 3DP");
        		model.addAttribute("listPictures", (JSONArray) printers3d.get("list_3d_printers_powder_bonding_3DP"));
        		pathToPage = "admin/pictures/menu/printers3d/powder_bonding_3DP";
        		
        	}
			
		} else if(typeProduct.equals("digital_printers")){
			JSONObject digitalPrinters = (JSONObject) obj.get("digital_printersJSON");
			
			if(subTypeProduct.equals("full_color_laser_printers")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения 'Полноцветные лазерные принтеры'");
				model.addAttribute("listPictures", (JSONArray) digitalPrinters.get("list_full_color_laser_printers"));
				pathToPage = "admin/pictures/menu/digital_printers/FDM-full_color_laser_printers";
				
        	} else if(subTypeProduct.equals("monochrome_laser_printers")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения 'Монохромные лазерные принтеры'");
        		model.addAttribute("listPictures", (JSONArray) digitalPrinters.get("list_monochrome_laser_printers"));
        		pathToPage = "admin/pictures/menu/digital_printers/monochrome_laser_printers";
        		
        	} else if(subTypeProduct.equals("full-color_inkjet_printers")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения 'Полноцветные струйные принтеры'");
        		model.addAttribute("listPictures", (JSONArray) digitalPrinters.get("list_full_color_inkjet_printers"));
        		pathToPage = "admin/pictures/menu/digital_printers/full_color_inkjet_printers";
        		
        	} 
			
		} else if(typeProduct.equals("laminator")){
			JSONObject laminator = (JSONObject) obj.get("laminatorJSON");
			
			if(subTypeProduct.equals("hot_lamination")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ГОРЯЧЕГО ЛАМИНИРОВАНИЯ");
				model.addAttribute("listPictures", (JSONArray) laminator.get("list_hot_lamination"));
				pathToPage = "admin/pictures/menu/laminator/hot_lamination";
				
        	} else if(subTypeProduct.equals("cold_laminating")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ХОЛОДНОГО ЛАМИНИРОВАНИЯ");
        		model.addAttribute("listPictures", (JSONArray) laminator.get("list_cold_laminating"));
        		pathToPage = "admin/pictures/menu/laminator/cold_laminating";
        		
        	} else if(subTypeProduct.equals("liquid")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ЖИДКОГО ЛАМИНИРОВАНИЯ");
        		model.addAttribute("listPictures", (JSONArray) laminator.get("list_liquid"));
        		pathToPage = "admin/pictures/menu/laminator/liquid";
        		
        	} else if(subTypeProduct.equals("flatbed_laminating_machine")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ПЛАНШЕТНЫЙ ЛАМИНАТОР");
        		model.addAttribute("listPictures", (JSONArray) laminator.get("list_flatbed_laminating_machine"));
        		pathToPage = "admin/pictures/menu/laminator/flatbed_laminating_machine";
        	}
			
		} else if(typeProduct.equals("laser")){
			JSONObject laser = (JSONObject) obj.get("laserJSON");
			
			if(subTypeProduct.equals("CO2_gas_lasers")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ГАЗОВЫЕ ЛАЗЕРЫ СО2");
				model.addAttribute("listPictures", (JSONArray) laser.get("list_CO2_gas_lasers"));
				pathToPage = "admin/pictures/menu/laser/CO2_gas_lasers";
				
        	} else if(subTypeProduct.equals("solid_state_lasers")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ТВЕРДОТЕЛЬНЫЕ ЛАЗЕРЫ");
        		model.addAttribute("listPictures", (JSONArray) laser.get("list_solid_state_lasers"));
        		pathToPage = "admin/pictures/menu/laser/solid_state_laser";
        		
        	} else if(subTypeProduct.equals("for_the_treatment_of_metal")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ЛАЗЕРА ДЛЯ ОБРАБОТКИ МЕТАЛА");
        		model.addAttribute("listPictures", (JSONArray) laser.get("list_for_the_treatment_of_metal"));
        		pathToPage = "admin/pictures/menu/laser/for_the_treatment_of_metal";
        		
        	} else if(subTypeProduct.equals("diode_pumped")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ЛАЗЕРЫ С ДИОДНОЙ НАКАЧКОЙ");
        		model.addAttribute("listPictures", (JSONArray) laser.get("list_diode_pumped"));
        		pathToPage = "admin/pictures/menu/laser/diode_pumped";
        		
        	} else if(subTypeProduct.equals("fiber_lasers")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ОПТОВОЛОКОННЫЕ ЛАЗЕРЫ");
        		model.addAttribute("listPictures", (JSONArray) laser.get("list_fiber_lasers"));
        		pathToPage = "admin/pictures/menu/laser/fiber_lasers";
        		
        	} else if(subTypeProduct.equals("plasma_lasers")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки отображения ПЛАЗМЕННЫЕ ЛАЗЕРЫ");
        		model.addAttribute("listPictures", (JSONArray) laser.get("list_plasma_lasers"));
        		pathToPage = "admin/pictures/menu/laser/plasma_lasers";
        	}
			
		} else if(typeProduct.equals("cutter")){
			JSONObject cutter = (JSONObject) obj.get("cutterJSON");
			
			if(subTypeProduct.equals("for_wood")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки для отображения ФРЕЗЕРЫ ДЛЯ ОБРАБОТКИ ДЕРЕВА");
				model.addAttribute("listPictures", (JSONArray) cutter.get("list_for_wood"));
				pathToPage = "admin/pictures/menu/cutter/for_wood";
				
        	} else if(subTypeProduct.equals("for_the_treatment_of_metal")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки для отображения ФРЕЗЕРЫ ДЛЯ ОБРАБОТКИ МЕТАЛА");
        		model.addAttribute("listPictures", (JSONArray) cutter.get("list_for_the_treatment_of_metal"));
        		pathToPage = "admin/pictures/menu/cutter/for_the_treatment_of_metal";
        		
        	} else if(subTypeProduct.equals("stone_processing")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки для отображения ФРЕЗЕРЫ ДЛЯ ОБРАБОТКИ КАМНЯ");
        		model.addAttribute("listPictures", (JSONArray) cutter.get("list_stone_processing"));
        		pathToPage = "admin/pictures/menu/cutter/stone_processing";
        	} 
			
		} else if(typeProduct.equals("scanner")){
			JSONObject scanner = (JSONObject) obj.get("scannerJSON");
			
			if(subTypeProduct.equals("large_format_scanners")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки для отображения ШИРОКОФОРМАТНЫЕ СКАННЕРЫ");
				model.addAttribute("listPictures", (JSONArray) scanner.get("list_large_format_scanners"));
				pathToPage = "admin/pictures/menu/scanner/large_format_scanners";
				
        	} else if(subTypeProduct.equals("3d_scanners")){
        		model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки для отображения 3D Сканеров");
				model.addAttribute("listPictures", (JSONArray) scanner.get("list_3d_scanners"));
				pathToPage = "admin/pictures/menu/scanner/3d_scanners";
				
        	}
			
		} else if(typeProduct.equals("previouslyUsed")){
			JSONObject previouslyUsed = (JSONObject) obj.get("previouslyUsedJSON");
			
			if(subTypeProduct.equals("solvent_equipment")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки для отображения СОЛЬВЕНТНОЕ ОБОРУДОВАНИЕ"
						+ " ПРЕДИДУЩЕГО ИСПОЛЬЗОВАНИЯ");
				model.addAttribute("listPictures", (JSONArray) previouslyUsed.get("list_solvent_equipment"));
				pathToPage = "admin/pictures/menu/previouslyUsed/solvent_equipment";
				
        	} else if(subTypeProduct.equals("ecosolvent_oborudovnie")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки для отображения ЭКОСОЛЬВЕНЬНОЕ ОБОРУДОВАНИЕ"
						+ " ПРЕДИДУЩЕГО ИСПОЛЬЗОВАНИЯ");
				model.addAttribute("listPictures", (JSONArray) previouslyUsed.get("list_ecosolvent_oborudovnie"));
				pathToPage = "admin/pictures/menu/previouslyUsed/ecosolvent_oborudovnie";
				
        	}
		} else if(typeProduct.equals("rip")){
			JSONObject rip = (JSONObject) obj.get("ripJSON");
			
			if(subTypeProduct.equals("RIP_system")){
				model.addAttribute("directory", typeProduct);
				model.addAttribute("subDirectory", subTypeProduct);
				model.addAttribute("headOfPage", "Изменение картинки для отображения RIP СИСТЕМЫ");
				model.addAttribute("listPictures", (JSONArray) rip.get("list_RIP_system"));
				pathToPage = "admin/pictures/menu/rip/RIP_system";
				
        	} 
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
	@RequestMapping(value="/admin/pictures/menu/{typeProduct}/{subTypeProduct}/upload_pictures",
    		method = RequestMethod.POST)
    public @ResponseBody String uploadPicturesMenu(MultipartHttpServletRequest request,
    		@PathVariable("typeProduct") String typeProduct,
    		@PathVariable("subTypeProduct") String subTypeProduct) {
    	
    	logger.info("upload new picture to the menu"); 	
    
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
        String fileName = null;

        while(itr.hasNext()){
            mpf = request.getFile(itr.next()); 
    		fileName = new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 

			try {
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(directory + File.separator + "menu" + 
			File.separator + typeProduct + File.separator + fileName));

			} catch (IOException e) {
				logger.error("Don't write picture to the folder", e);
			} 
          	
		JSONParser parser = new JSONParser();
		
		try {
			obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			
			if(typeProduct.equals("printers")){
				
				JSONObject printersJSON = null;
				if( obj.get("printersJSON") != null ){
					printersJSON = (JSONObject) obj.get("printersJSON");
					} else {
						printersJSON = new JSONObject();
					}

				//add new pictures to the and
				if(subTypeProduct.equals("dissolving")){
					
					JSONArray listPicturesDissolvingPrinters = null;
					//check if these subdirectories has pictures
					if(printersJSON.get("listPicturesDissolvingPrinters") != null){
						listPicturesDissolvingPrinters = (JSONArray) printersJSON.get("listPicturesDissolvingPrinters");
						printersJSON.remove("listPicturesDissolvingPrinters");
					} else {
						listPicturesDissolvingPrinters = new JSONArray();
					}
					
					listPicturesDissolvingPrinters.add(fileName);			
					printersJSON.put("listPicturesDissolvingPrinters", listPicturesDissolvingPrinters);
					
	        	} else if(subTypeProduct.equals("ecosolvent")){
	        		
	        		JSONArray listPicturesEcosolventPrinters = null;
					if(printersJSON.get("listPicturesEcosolventPrinters") != null){
						listPicturesEcosolventPrinters = (JSONArray) printersJSON.get("listPicturesEcosolventPrinters");
						printersJSON.remove("listPicturesEcosolventPrinters");
					} else {
						listPicturesEcosolventPrinters = new JSONArray();
					}
	        		
	        		listPicturesEcosolventPrinters.add(fileName);
					printersJSON.put("listPicturesEcosolventPrinters", listPicturesEcosolventPrinters);
					
	        	} else if(subTypeProduct.equals("UV_roll")){
	        		
	        		JSONArray listPicturesUvRollPrinters = null;
	        		if(printersJSON.get("listPicturesUvRollPrinters") != null){
						listPicturesUvRollPrinters = (JSONArray) printersJSON.get("listPicturesUvRollPrinters");
						printersJSON.remove("listPicturesUvRollPrinters");
					} else {
						listPicturesUvRollPrinters = new JSONArray();
					}
	        		
	        		listPicturesUvRollPrinters.add(fileName);
					printersJSON.put("listPicturesUvRollPrinters", listPicturesUvRollPrinters);
					
	        	} else if(subTypeProduct.equals("UV_flatbed")){
	        		
	        		JSONArray listPicturesUvFlatbedPrinters = null;
	        		if(printersJSON.get("listPicturesUvFlatbedPrinters") != null){
						listPicturesUvFlatbedPrinters = (JSONArray) printersJSON.get("listPicturesUvFlatbedPrinters");
						printersJSON.remove("listPicturesUvFlatbedPrinters");
					} else {
						listPicturesUvFlatbedPrinters = new JSONArray();
					}
	        		
	        		listPicturesUvFlatbedPrinters.add(fileName);	
					printersJSON.put("listPicturesUvFlatbedPrinters", listPicturesUvFlatbedPrinters);
					
	        	} else if(subTypeProduct.equals("sublimation")){
	        		
	        		JSONArray listPicturesSublimationPrinters = null;
	        		if(printersJSON.get("listPicturesSublimationPrinters") != null){
						listPicturesSublimationPrinters = (JSONArray) printersJSON.get("listPicturesSublimationPrinters");
						printersJSON.remove("listPicturesSublimationPrinters");
					} else {
						listPicturesSublimationPrinters = new JSONArray();
					}
	        		listPicturesSublimationPrinters.add(fileName);
	        		printersJSON.put("listPicturesSublimationPrinters", listPicturesSublimationPrinters);
					
	        	} else if(subTypeProduct.equals("textile")){
	        		
	        		JSONArray listPicturesTextilePrinters = null;
	        		if(printersJSON.get("listPicturesTextilePrinters") != null){
						listPicturesTextilePrinters = (JSONArray) printersJSON.get("listPicturesTextilePrinters");
						printersJSON.remove("listPicturesTextilePrinters");
					} else {
						listPicturesTextilePrinters = new JSONArray();
					}
	        		listPicturesTextilePrinters.add(fileName);
					printersJSON.put("listPicturesTextilePrinters", listPicturesTextilePrinters);
					
	        	} else if(subTypeProduct.equals("water_pigment")){
	        		
	        		JSONArray listPicturesWaterPigmentPrinters = null;
	        		if(printersJSON.get("listPicturesWaterPigmentPrinters") != null){
						listPicturesWaterPigmentPrinters = (JSONArray) printersJSON.get("listPicturesWaterPigmentPrinters");
						printersJSON.remove("listPicturesWaterPigmentPrinters");
					} else {
						listPicturesWaterPigmentPrinters = new JSONArray();
					}
	        		listPicturesWaterPigmentPrinters.add(fileName);		
					printersJSON.put("listPicturesWaterPigmentPrinters", listPicturesWaterPigmentPrinters);
					
	        	} else if(subTypeProduct.equals("digital")){
	        		
	        		JSONArray listPicturesDigitalPrinters = null;
	        		if(printersJSON.get("listPicturesDigitalPrinters") != null){
	        			listPicturesDigitalPrinters = (JSONArray) printersJSON.get("listPicturesDigitalPrinters");
						printersJSON.remove("listPicturesDigitalPrinters");
					} else {
						listPicturesDigitalPrinters = new JSONArray();
					}
	        		listPicturesDigitalPrinters.add(fileName);		
					printersJSON.put("listPicturesDigitalPrinters", listPicturesDigitalPrinters);
					
	        	} else if(subTypeProduct.equals("SAPR-GIS")){
	        		
	        		JSONArray listPictures_SAPR_GIS_Printers = null;
	        		if(printersJSON.get("listPictures_SAPR_GIS_Printers") != null){
	        			listPictures_SAPR_GIS_Printers = (JSONArray) printersJSON.get("listPictures_SAPR_GIS_Printers");
						printersJSON.remove("listPictures_SAPR_GIS_Printers");
					} else {
						listPictures_SAPR_GIS_Printers = new JSONArray();
					}
	        		listPictures_SAPR_GIS_Printers.add(fileName);		
					printersJSON.put("listPictures_SAPR_GIS_Printers", listPictures_SAPR_GIS_Printers);
					
	        	}

				if( obj.get("printersJSON") != null )
					obj.remove("printersJSON");
				
			obj.put("printersJSON", printersJSON);
			
			} else if(typeProduct.equals("printers3d")){
				
				JSONObject printers3dJSON = null;
				if( obj.get("printers3dJSON") != null ){
					printers3dJSON = (JSONObject) obj.get("printers3dJSON");
					} else {
						printers3dJSON = new JSONObject();
					}

				if(subTypeProduct.equals("FDM-extruder")){
					
					JSONArray list_3dPrintersFDM_Extruder = null;
					if(printers3dJSON.get("list_3dPrintersFDM_Extruder") != null){
						list_3dPrintersFDM_Extruder = (JSONArray) printers3dJSON.get("list_3dPrintersFDM_Extruder");
						printers3dJSON.remove("list_3dPrintersFDM_Extruder");
					} else {
						list_3dPrintersFDM_Extruder = new JSONArray();
					}
					list_3dPrintersFDM_Extruder.add(fileName);
					printers3dJSON.put("list_3dPrintersFDM_Extruder", list_3dPrintersFDM_Extruder);
					
	        	} else if(subTypeProduct.equals("photo_printing_polyjet")){
	        		
	        		JSONArray list_3d_printers_photo_printing_polyjet = null;
	        		if(printers3dJSON.get("list_3d_printers_photo_printing_polyjet") != null){
						list_3d_printers_photo_printing_polyjet = (JSONArray) printers3dJSON.get("list_3d_printers_photo_printing_polyjet");
						printers3dJSON.remove("list_3d_printers_photo_printing_polyjet");
					} else {
						list_3d_printers_photo_printing_polyjet = new JSONArray();
					}
	        		list_3d_printers_photo_printing_polyjet.add(fileName);
	        		printers3dJSON.put("list_3d_printers_photo_printing_polyjet", list_3d_printers_photo_printing_polyjet);
					
	        	} else if(subTypeProduct.equals("laser_sintering_LENS")){
	        		
	        		JSONArray list_3d_printers_laser_sintering_LENS = null;
	        		if(printers3dJSON.get("list_3d_printers_laser_sintering_LENS") != null){
						list_3d_printers_laser_sintering_LENS = (JSONArray) printers3dJSON.get("list_3d_printers_laser_sintering_LENS");
						printers3dJSON.remove("list_3d_printers_laser_sintering_LENS");
					} else {
						list_3d_printers_laser_sintering_LENS = new JSONArray();
					}
	        		list_3d_printers_laser_sintering_LENS.add(fileName);
	        		printers3dJSON.put("list_3d_printers_laser_sintering_LENS", list_3d_printers_laser_sintering_LENS);
					
	        	} else if(subTypeProduct.equals("lamination_LOM")){
	        		
	        		JSONArray list_3d_printers_lamination_LOM = null;
	        		if(printers3dJSON.get("list_3d_printers_lamination_LOM") != null){
						list_3d_printers_lamination_LOM = (JSONArray) printers3dJSON.get("list_3d_printers_lamination_LOM");
						printers3dJSON.remove("list_3d_printers_lamination_LOM");
					} else {
						list_3d_printers_lamination_LOM = new JSONArray();
					}
	        		list_3d_printers_lamination_LOM.add(fileName);
	        		printers3dJSON.put("list_3d_printers_lamination_LOM", list_3d_printers_lamination_LOM);
					
	        	} else if(subTypeProduct.equals("stereolithography_SL")){
	        		
	        		JSONArray list_3d_printers_stereolithography_SL = null;
	        		if(printers3dJSON.get("list_3d_printers_stereolithography_SL") != null){
						list_3d_printers_stereolithography_SL = (JSONArray) printers3dJSON.get("list_3d_printers_stereolithography_SL");
						printers3dJSON.remove("list_3d_printers_stereolithography_SL");
					} else {
						list_3d_printers_stereolithography_SL = new JSONArray();
					}
	        		list_3d_printers_stereolithography_SL.add(fileName);
	        		printers3dJSON.put("list_3d_printers_stereolithography_SL", list_3d_printers_stereolithography_SL);
					
	        	} else if(subTypeProduct.equals("laser_sintering_LS")){
	        		
	        		JSONArray list_3d_printers_laser_sintering_LS = null;
	        		if(printers3dJSON.get("list_3d_printers_laser_sintering_LS") != null){
						list_3d_printers_laser_sintering_LS = (JSONArray) printers3dJSON.get("list_3d_printers_laser_sintering_LS");
						printers3dJSON.remove("list_3d_printers_laser_sintering_LS");
					} else {
						list_3d_printers_laser_sintering_LS = new JSONArray();
					}
	        		list_3d_printers_laser_sintering_LS.add(fileName);
	        		printers3dJSON.put("list_3d_printers_laser_sintering_LS", list_3d_printers_laser_sintering_LS);
					
	        	} else if(subTypeProduct.equals("powder_bonding_3DP")){
	        		
	        		JSONArray list_3d_printers_powder_bonding_3DP = null;
	        		if(printers3dJSON.get("list_3d_printers_powder_bonding_3DP") != null){
						list_3d_printers_powder_bonding_3DP = (JSONArray) printers3dJSON.get("list_3d_printers_powder_bonding_3DP");
						printers3dJSON.remove("list_3d_printers_powder_bonding_3DP");
					} else {
						list_3d_printers_powder_bonding_3DP = new JSONArray();
					}
	        		list_3d_printers_powder_bonding_3DP.add(fileName);
	        		printers3dJSON.put("list_3d_printers_powder_bonding_3DP", list_3d_printers_powder_bonding_3DP);
	        	}

				if( obj.get("printers3dJSON") != null )
					obj.remove("printers3dJSON");
	
			obj.put("printers3dJSON", printers3dJSON);
			
			} else if(typeProduct.equals("digital_printers")){

				JSONObject digital_printersJSON = null;
				if( obj.get("digital_printersJSON") != null ){
					digital_printersJSON = (JSONObject) obj.get("digital_printersJSON");
					} else {
						digital_printersJSON = new JSONObject();
					}

				if(subTypeProduct.equals("full_color_laser_printers")){
					
					JSONArray list_full_color_laser_printers = null;
					if(digital_printersJSON.get("list_full_color_laser_printers") != null){
						list_full_color_laser_printers = (JSONArray) digital_printersJSON.get("list_full_color_laser_printers");
						digital_printersJSON.remove("list_full_color_laser_printers");
					} else {
						list_full_color_laser_printers = new JSONArray();
					}
					list_full_color_laser_printers.add(fileName);
					digital_printersJSON.put("list_full_color_laser_printers", list_full_color_laser_printers);
					
	        	} else if(subTypeProduct.equals("monochrome_laser_printers")){
	        		
	        		JSONArray list_monochrome_laser_printers = null;
	        		if(digital_printersJSON.get("list_monochrome_laser_printers") != null){
						list_monochrome_laser_printers = (JSONArray) digital_printersJSON.get("list_monochrome_laser_printers");
						digital_printersJSON.remove("list_monochrome_laser_printers");
					} else {
						list_monochrome_laser_printers = new JSONArray();
					}
	        		list_monochrome_laser_printers.add(fileName);
	        		digital_printersJSON.put("list_monochrome_laser_printers", list_monochrome_laser_printers);
					
	        	} else if(subTypeProduct.equals("full-color_inkjet_printers")){
	        		
	        		JSONArray list_full_color_inkjet_printers = null;
	        		if(digital_printersJSON.get("list_full_color_inkjet_printers") != null){
						list_full_color_inkjet_printers = (JSONArray) digital_printersJSON.get("list_full_color_inkjet_printers");
						digital_printersJSON.remove("list_full_color_inkjet_printers");
					} else {
						list_full_color_inkjet_printers = new JSONArray();
					}
	        		list_full_color_inkjet_printers.add(fileName);
	        		digital_printersJSON.put("list_full_color_inkjet_printers", list_full_color_inkjet_printers);
					
	        	}

				if( obj.get("digital_printersJSON") != null )
					obj.remove("digital_printersJSON");
	
			obj.put("digital_printersJSON", digital_printersJSON);
			
			} else if(typeProduct.equals("laminator")){

				JSONObject laminatorJSON = null;
				if( obj.get("laminatorJSON") != null ){
					laminatorJSON = (JSONObject) obj.get("laminatorJSON");
					} else {
						laminatorJSON = new JSONObject();
					}

				if(subTypeProduct.equals("hot_lamination")){
					
					JSONArray list_hot_lamination = null;
					if(laminatorJSON.get("list_hot_lamination") != null){
						list_hot_lamination = (JSONArray) laminatorJSON.get("list_hot_lamination");
						laminatorJSON.remove("list_hot_lamination");
					} else {
						list_hot_lamination = new JSONArray();
					}
					list_hot_lamination.add(fileName);
					laminatorJSON.put("list_hot_lamination", list_hot_lamination);
					
	        	} else if(subTypeProduct.equals("cold_laminating")){
	        		
	        		JSONArray list_cold_laminating = null;
	        		if(laminatorJSON.get("list_cold_laminating") != null){
						list_cold_laminating = (JSONArray) laminatorJSON.get("list_cold_laminating");
						laminatorJSON.remove("list_cold_laminating");
					} else {
						list_cold_laminating = new JSONArray();
					}
	        		list_cold_laminating.add(fileName);
	        		laminatorJSON.put("list_cold_laminating", list_cold_laminating);
					
	        	} else if(subTypeProduct.equals("liquid")){
	        		
	        		JSONArray list_liquid = null;
	        		if(laminatorJSON.get("list_liquid") != null){
						list_liquid = (JSONArray) laminatorJSON.get("list_liquid");
						laminatorJSON.remove("list_liquid");
					} else {
						list_liquid = new JSONArray();
					}
	        		list_liquid.add(fileName);
	        		laminatorJSON.put("list_liquid", list_liquid);
					
	        	} else if(subTypeProduct.equals("flatbed_laminating_machine")){
	        		
	        		JSONArray list_flatbed_laminating_machine = null;
	        		if(laminatorJSON.get("list_flatbed_laminating_machine") != null){
						list_flatbed_laminating_machine = (JSONArray) laminatorJSON.get("list_flatbed_laminating_machine");
						laminatorJSON.remove("list_flatbed_laminating_machine");
					} else {
						list_flatbed_laminating_machine = new JSONArray();
					}
	        		list_flatbed_laminating_machine.add(fileName);
	        		laminatorJSON.put("list_flatbed_laminating_machine", list_flatbed_laminating_machine);
					
	        	}

				if( obj.get("laminatorJSON") != null )
					obj.remove("laminatorJSON");
	
			obj.put("laminatorJSON", laminatorJSON);
			
			} else if(typeProduct.equals("laser")){

				JSONObject laserJSON = null;
				if( obj.get("laserJSON") != null ){
					laserJSON = (JSONObject) obj.get("laserJSON");
					} else {
						laserJSON = new JSONObject();
					}

				if(subTypeProduct.equals("CO2_gas_lasers")){
					
					JSONArray list_CO2_gas_lasers = null;
					if(laserJSON.get("list_CO2_gas_lasers") != null){
						list_CO2_gas_lasers = (JSONArray) laserJSON.get("list_CO2_gas_lasers");
						laserJSON.remove("list_CO2_gas_lasers");
					} else {
						list_CO2_gas_lasers = new JSONArray();
					}
					list_CO2_gas_lasers.add(fileName);
					laserJSON.put("list_CO2_gas_lasers", list_CO2_gas_lasers);
					
	        	} else if(subTypeProduct.equals("solid_state_lasers")){
	        		
	        		JSONArray list_solid_state_lasers = null;
	        		if(laserJSON.get("list_solid_state_lasers") != null){
						list_solid_state_lasers = (JSONArray) laserJSON.get("list_solid_state_lasers");
						laserJSON.remove("list_solid_state_lasers");
					} else {
						list_solid_state_lasers = new JSONArray();
					}
	        		list_solid_state_lasers.add(fileName);
	        		laserJSON.put("list_solid_state_lasers", list_solid_state_lasers);
					
	        	} else if(subTypeProduct.equals("for_the_treatment_of_metal")){
	        		
	        		JSONArray list_for_the_treatment_of_metal = null;
	        		if(laserJSON.get("list_for_the_treatment_of_metal") != null){
						list_for_the_treatment_of_metal = (JSONArray) laserJSON.get("list_for_the_treatment_of_metal");
						laserJSON.remove("list_for_the_treatment_of_metal");
					} else {
						list_for_the_treatment_of_metal = new JSONArray();
					}
	        		list_for_the_treatment_of_metal.add(fileName);
	        		laserJSON.put("list_for_the_treatment_of_metal", list_for_the_treatment_of_metal);
					
	        	} else if(subTypeProduct.equals("diode_pumped")){
	        		
	        		JSONArray list_diode_pumped = null;
	        		if(laserJSON.get("list_diode_pumped") != null){
						list_diode_pumped = (JSONArray) laserJSON.get("list_diode_pumped");
						laserJSON.remove("list_diode_pumped");
					} else {
						list_diode_pumped = new JSONArray();
					}
	        		list_diode_pumped.add(fileName);
	        		laserJSON.put("list_diode_pumped", list_diode_pumped);
					
	        	} else if(subTypeProduct.equals("fiber_lasers")){
	        		
	        		JSONArray list_fiber_lasers = null;
	        		if(laserJSON.get("list_fiber_lasers") != null){
						list_fiber_lasers = (JSONArray) laserJSON.get("list_fiber_lasers");
						laserJSON.remove("list_fiber_lasers");
					} else {
						list_fiber_lasers = new JSONArray();
					}
	        		list_fiber_lasers.add(fileName);
	        		laserJSON.put("list_fiber_lasers", list_fiber_lasers);
					
	        	} else if(subTypeProduct.equals("plasma_lasers")){
	        		
	        		JSONArray list_plasma_lasers = null;
	        		if(laserJSON.get("list_plasma_lasers") != null){
						list_plasma_lasers = (JSONArray) laserJSON.get("list_plasma_lasers");
						laserJSON.remove("list_plasma_lasers");
					} else {
						list_plasma_lasers = new JSONArray();
					}
	        		list_plasma_lasers.add(fileName);
	        		laserJSON.put("list_plasma_lasers", list_plasma_lasers);
					
	        	}

				if( obj.get("laserJSON") != null )
					obj.remove("laserJSON");
	
			obj.put("laserJSON", laserJSON);
			
			} else if(typeProduct.equals("cutter")){

				JSONObject cutterJSON = null;
				if( obj.get("cutterJSON") != null ){
					cutterJSON = (JSONObject) obj.get("cutterJSON");
					} else {
						cutterJSON = new JSONObject();
					}

				if(subTypeProduct.equals("for_wood")){
					
					JSONArray list_for_wood = null;
					if(cutterJSON.get("list_for_wood") != null){
						list_for_wood = (JSONArray) cutterJSON.get("list_for_wood");
						cutterJSON.remove("list_for_wood");
					} else {
						list_for_wood = new JSONArray();
					}
					list_for_wood.add(fileName);
					cutterJSON.put("list_for_wood", list_for_wood);
					
	        	} else if(subTypeProduct.equals("for_the_treatment_of_metal")){
	        		
	        		JSONArray list_for_the_treatment_of_metal = null;
	        		if(cutterJSON.get("list_for_the_treatment_of_metal") != null){
						list_for_the_treatment_of_metal = (JSONArray) cutterJSON.get("list_for_the_treatment_of_metal");
						cutterJSON.remove("list_for_the_treatment_of_metal");
					} else {
						list_for_the_treatment_of_metal = new JSONArray();
					}
	        		list_for_the_treatment_of_metal.add(fileName);
	        		cutterJSON.put("list_for_the_treatment_of_metal", list_for_the_treatment_of_metal);
					
	        	} else if(subTypeProduct.equals("stone_processing")){
	        		
	        		JSONArray list_stone_processing = null;
	        		if(cutterJSON.get("list_stone_processing") != null){
						list_stone_processing = (JSONArray) cutterJSON.get("list_stone_processing");
						cutterJSON.remove("list_stone_processing");
					} else {
						list_stone_processing = new JSONArray();
					}
	        		list_stone_processing.add(fileName);
	        		cutterJSON.put("list_stone_processing", list_stone_processing);
					
	        	}

				if( obj.get("cutterJSON") != null )
					obj.remove("cutterJSON");
	
			obj.put("cutterJSON", cutterJSON);
			
			} else if(typeProduct.equals("scanner")){

				JSONObject scannerJSON = null;
				if( obj.get("scannerJSON") != null ){
					scannerJSON = (JSONObject) obj.get("scannerJSON");
					} else {
						scannerJSON = new JSONObject();
					}

				if(subTypeProduct.equals("large_format_scanners")){
					
					JSONArray list_large_format_scanners = null;
					if(scannerJSON.get("list_large_format_scanners") != null){
						list_large_format_scanners = (JSONArray) scannerJSON.get("list_large_format_scanners");
						scannerJSON.remove("list_large_format_scanners");
					} else {
						list_large_format_scanners = new JSONArray();
					}
					list_large_format_scanners.add(fileName);
					scannerJSON.put("list_large_format_scanners", list_large_format_scanners);
					
	        	} else if(subTypeProduct.equals("3d_scanners")){
					
					JSONArray list_3d_scanners = null;
					if(scannerJSON.get("list_3d_scanners") != null){
						list_3d_scanners = (JSONArray) scannerJSON.get("list_3d_scanners");
						scannerJSON.remove("list_3d_scanners");
					} else {
						list_3d_scanners = new JSONArray();
					}
					list_3d_scanners.add(fileName);
					scannerJSON.put("list_3d_scanners", list_3d_scanners);
					
	        	}

				if( obj.get("scannerJSON") != null )
					obj.remove("scannerJSON");
	
			obj.put("scannerJSON", scannerJSON);
			
			} else if(typeProduct.equals("previouslyUsed")){

				JSONObject previouslyUsedJSON = null;
				if( obj.get("previouslyUsedJSON") != null ){
					previouslyUsedJSON = (JSONObject) obj.get("previouslyUsedJSON");
					} else {
						previouslyUsedJSON = new JSONObject();
					}

				if(subTypeProduct.equals("solvent_equipment")){
					
					JSONArray list_solvent_equipment = null;
					if(previouslyUsedJSON.get("list_solvent_equipment") != null){
						list_solvent_equipment = (JSONArray) previouslyUsedJSON.get("list_solvent_equipment");
						previouslyUsedJSON.remove("list_solvent_equipment");
					} else {
						list_solvent_equipment = new JSONArray();
					}
					list_solvent_equipment.add(fileName);
					previouslyUsedJSON.put("list_solvent_equipment", list_solvent_equipment);
					
	        	} else if(subTypeProduct.equals("ecosolvent_oborudovnie")){
					
					JSONArray list_ecosolvent_oborudovnie = null;
					if(previouslyUsedJSON.get("list_ecosolvent_oborudovnie") != null){
						list_ecosolvent_oborudovnie = (JSONArray) previouslyUsedJSON.get("list_ecosolvent_oborudovnie");
						previouslyUsedJSON.remove("list_ecosolvent_oborudovnie");
					} else {
						list_ecosolvent_oborudovnie = new JSONArray();
					}
					list_ecosolvent_oborudovnie.add(fileName);
					previouslyUsedJSON.put("list_ecosolvent_oborudovnie", list_ecosolvent_oborudovnie);
					
	        	}

				if( obj.get("previouslyUsedJSON") != null )
					obj.remove("previouslyUsedJSON");
	
			obj.put("previouslyUsedJSON", previouslyUsedJSON);
			
			} else if(typeProduct.equals("rip")){

				JSONObject ripJSON = null;
				if( obj.get("ripJSON") != null ){
					ripJSON = (JSONObject) obj.get("ripJSON");
					} else {
						ripJSON = new JSONObject();
					}

				if(subTypeProduct.equals("RIP_system")){
					
					JSONArray list_RIP_system = null;
					if(ripJSON.get("list_RIP_system") != null){
						list_RIP_system = (JSONArray) ripJSON.get("list_RIP_system");
						ripJSON.remove("list_RIP_system");
					} else {
						list_RIP_system = new JSONArray();
					}
					list_RIP_system.add(fileName);
					ripJSON.put("list_RIP_system", list_RIP_system);
					
	        	} 

				if( obj.get("ripJSON") != null )
					obj.remove("ripJSON");
	
			obj.put("ripJSON", ripJSON);
			
			}
			
			Writer out = new PrintWriter(path, "UTF-8");
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
	@RequestMapping(value="/admin/pictures/menu/{typeProduct}/{subTypeProduct}/change_order_pictures",
					method = RequestMethod.POST,
					consumes="application/json",
					headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesMenu(
    		@RequestBody List<String> selectedIds,
    		@PathVariable("typeProduct") String typeProduct,
    		@PathVariable("subTypeProduct") String subTypeProduct) {
    	
    	logger.info("change order pictures in menu"); 	

		JSONParser parser = new JSONParser();
		
		try {
			obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			
			if(typeProduct.equals("printers")){
				
				JSONObject printersJSON = (JSONObject) obj.get("printersJSON");		

				if(subTypeProduct.equals("dissolving")){
					
					JSONArray listPicturesDissolvingPrinters = null;
					//check if these subdirectories has pictures
					if(printersJSON.get("listPicturesDissolvingPrinters") != null){
						printersJSON.remove("listPicturesDissolvingPrinters");
					} 
						listPicturesDissolvingPrinters = new JSONArray();
					
					for(String fileName: selectedIds)
						listPicturesDissolvingPrinters.add(fileName);
					printersJSON.put("listPicturesDissolvingPrinters", listPicturesDissolvingPrinters);
					
	        	} else if(subTypeProduct.equals("ecosolvent")){
	        		
	        		JSONArray listPicturesEcosolventPrinters = null;
					if(printersJSON.get("listPicturesEcosolventPrinters") != null){
						printersJSON.remove("listPicturesEcosolventPrinters");
					} 
						listPicturesEcosolventPrinters = new JSONArray();

					for(String fileName: selectedIds)
	        		listPicturesEcosolventPrinters.add(fileName);
					printersJSON.put("listPicturesEcosolventPrinters", listPicturesEcosolventPrinters);
					
	        	} else if(subTypeProduct.equals("UV_roll")){
	        		
	        		JSONArray listPicturesUvRollPrinters = null;
	        		if(printersJSON.get("listPicturesUvRollPrinters") != null){
						printersJSON.remove("listPicturesUvRollPrinters");
					} 
						listPicturesUvRollPrinters = new JSONArray();
						
					for(String fileName: selectedIds)
	        		listPicturesUvRollPrinters.add(fileName);
					printersJSON.put("listPicturesUvRollPrinters", listPicturesUvRollPrinters);
					
	        	} else if(subTypeProduct.equals("UV_flatbed")){
	        		
	        		JSONArray listPicturesUvFlatbedPrinters = null;
	        		if(printersJSON.get("listPicturesUvFlatbedPrinters") != null){
						printersJSON.remove("listPicturesUvFlatbedPrinters");
					} 
						listPicturesUvFlatbedPrinters = new JSONArray();

					for(String fileName: selectedIds)
	        		listPicturesUvFlatbedPrinters.add(fileName);	
					printersJSON.put("listPicturesUvFlatbedPrinters", listPicturesUvFlatbedPrinters);
					
	        	} else if(subTypeProduct.equals("sublimation")){
	        		
	        		JSONArray listPicturesSublimationPrinters = null;
	        		if(printersJSON.get("listPicturesSublimationPrinters") != null){
						printersJSON.remove("listPicturesSublimationPrinters");
					} 
						listPicturesSublimationPrinters = new JSONArray();

					for(String fileName: selectedIds)
	        		listPicturesSublimationPrinters.add(fileName);
	        		printersJSON.put("listPicturesSublimationPrinters", listPicturesSublimationPrinters);
					
	        	} else if(subTypeProduct.equals("textile")){
	        		
	        		JSONArray listPicturesTextilePrinters = null;
	        		if(printersJSON.get("listPicturesTextilePrinters") != null){
						printersJSON.remove("listPicturesTextilePrinters");
					} 
						listPicturesTextilePrinters = new JSONArray();

					for(String fileName: selectedIds)
	        		listPicturesTextilePrinters.add(fileName);
					printersJSON.put("listPicturesTextilePrinters", listPicturesTextilePrinters);
					
	        	} else if(subTypeProduct.equals("water_pigment")){
	        		
	        		JSONArray listPicturesWaterPigmentPrinters = null;
	        		if(printersJSON.get("listPicturesWaterPigmentPrinters") != null){
						printersJSON.remove("listPicturesWaterPigmentPrinters");
					} 
						listPicturesWaterPigmentPrinters = new JSONArray();

					for(String fileName: selectedIds)
	        		listPicturesWaterPigmentPrinters.add(fileName);		
					printersJSON.put("listPicturesWaterPigmentPrinters", listPicturesWaterPigmentPrinters);
					
	        	} else if(subTypeProduct.equals("digital")){
	        		
	        		JSONArray listPicturesDigitalPrinters = null;
	        		if(printersJSON.get("listPicturesDigitalPrinters") != null){
						printersJSON.remove("listPicturesDigitalPrinters");
					} 
	        		listPicturesDigitalPrinters = new JSONArray();

					for(String fileName: selectedIds)
						listPicturesDigitalPrinters.add(fileName);		
					printersJSON.put("listPicturesDigitalPrinters", listPicturesDigitalPrinters);
					
	        	} else if(subTypeProduct.equals("SAPR-GIS")){
	        		
	        		JSONArray listPictures_SAPR_GIS_Printers = null;
	        		if(printersJSON.get("listPictures_SAPR_GIS_Printers") != null){
						printersJSON.remove("listPictures_SAPR_GIS_Printers");
					} 
	        		listPictures_SAPR_GIS_Printers = new JSONArray();

					for(String fileName: selectedIds)
						listPictures_SAPR_GIS_Printers.add(fileName);		
					printersJSON.put("listPictures_SAPR_GIS_Printers", listPictures_SAPR_GIS_Printers);
					
	        	}

				if( obj.get("printersJSON") != null )
					obj.remove("printersJSON");
				
			obj.put("printersJSON", printersJSON);
			
			} else if(typeProduct.equals("printers3d")){
				
				JSONObject printers3dJSON = (JSONObject) obj.get("printers3dJSON");

				if(subTypeProduct.equals("FDM-extruder")){
					
					JSONArray list_3dPrintersFDM_Extruder = null;
					if(printers3dJSON.get("list_3dPrintersFDM_Extruder") != null){
						printers3dJSON.remove("list_3dPrintersFDM_Extruder");
					} 
					
					list_3dPrintersFDM_Extruder = new JSONArray();
						
					for(String fileName: selectedIds)
					list_3dPrintersFDM_Extruder.add(fileName);
					printers3dJSON.put("list_3dPrintersFDM_Extruder", list_3dPrintersFDM_Extruder);
					
	        	} else if(subTypeProduct.equals("photo_printing_polyjet")){
	        		
	        		JSONArray list_3d_printers_photo_printing_polyjet = null;
	        		if(printers3dJSON.get("list_3d_printers_photo_printing_polyjet") != null){
						printers3dJSON.remove("list_3d_printers_photo_printing_polyjet");
					} 
						list_3d_printers_photo_printing_polyjet = new JSONArray();

					for(String fileName: selectedIds)
	        		list_3d_printers_photo_printing_polyjet.add(fileName);
	        		printers3dJSON.put("list_3d_printers_photo_printing_polyjet", list_3d_printers_photo_printing_polyjet);
					
	        	} else if(subTypeProduct.equals("laser_sintering_LENS")){
	        		
	        		JSONArray list_3d_printers_laser_sintering_LENS = null;
	        		if(printers3dJSON.get("list_3d_printers_laser_sintering_LENS") != null){
						printers3dJSON.remove("list_3d_printers_laser_sintering_LENS");
					} 
						list_3d_printers_laser_sintering_LENS = new JSONArray();

					for(String fileName: selectedIds)
	        		list_3d_printers_laser_sintering_LENS.add(fileName);
	        		printers3dJSON.put("list_3d_printers_laser_sintering_LENS", list_3d_printers_laser_sintering_LENS);
					
	        	} else if(subTypeProduct.equals("lamination_LOM")){
	        		
	        		JSONArray list_3d_printers_lamination_LOM = null;
	        		if(printers3dJSON.get("list_3d_printers_lamination_LOM") != null){
						printers3dJSON.remove("list_3d_printers_lamination_LOM");
					} 
						list_3d_printers_lamination_LOM = new JSONArray();

					for(String fileName: selectedIds)
	        		list_3d_printers_lamination_LOM.add(fileName);
	        		printers3dJSON.put("list_3d_printers_lamination_LOM", list_3d_printers_lamination_LOM);
					
	        	} else if(subTypeProduct.equals("stereolithography_SL")){
	        		
	        		JSONArray list_3d_printers_stereolithography_SL = null;
	        		if(printers3dJSON.get("list_3d_printers_stereolithography_SL") != null){
						printers3dJSON.remove("list_3d_printers_stereolithography_SL");
					} 
						list_3d_printers_stereolithography_SL = new JSONArray();

					for(String fileName: selectedIds)
	        		list_3d_printers_stereolithography_SL.add(fileName);
	        		printers3dJSON.put("list_3d_printers_stereolithography_SL", list_3d_printers_stereolithography_SL);
					
	        	} else if(subTypeProduct.equals("laser_sintering_LS")){
	        		
	        		JSONArray list_3d_printers_laser_sintering_LS = null;
	        		if(printers3dJSON.get("list_3d_printers_laser_sintering_LS") != null){
						printers3dJSON.remove("list_3d_printers_laser_sintering_LS");
					} 
						list_3d_printers_laser_sintering_LS = new JSONArray();

					for(String fileName: selectedIds)
	        		list_3d_printers_laser_sintering_LS.add(fileName);
	        		printers3dJSON.put("list_3d_printers_laser_sintering_LS", list_3d_printers_laser_sintering_LS);
					
	        	} else if(subTypeProduct.equals("powder_bonding_3DP")){
	        		
	        		JSONArray list_3d_printers_powder_bonding_3DP = null;
	        		if(printers3dJSON.get("list_3d_printers_powder_bonding_3DP") != null){
						printers3dJSON.remove("list_3d_printers_powder_bonding_3DP");
					} 
						list_3d_printers_powder_bonding_3DP = new JSONArray();

					for(String fileName: selectedIds)
	        		list_3d_printers_powder_bonding_3DP.add(fileName);
	        		printers3dJSON.put("list_3d_printers_powder_bonding_3DP", list_3d_printers_powder_bonding_3DP);
	        	}

				if( obj.get("printers3dJSON") != null )
					obj.remove("printers3dJSON");
	
			obj.put("printers3dJSON", printers3dJSON);
			
			} else if(typeProduct.equals("digital_printers")){

				JSONObject digital_printersJSON = (JSONObject) obj.get("digital_printersJSON");

				if(subTypeProduct.equals("full_color_laser_printers")){
					
					JSONArray list_full_color_laser_printers = null;
					if(digital_printersJSON.get("list_full_color_laser_printers") != null){
						digital_printersJSON.remove("list_full_color_laser_printers");
					} 
					
					list_full_color_laser_printers = new JSONArray();
						
					for(String fileName: selectedIds)
					list_full_color_laser_printers.add(fileName);
					digital_printersJSON.put("list_full_color_laser_printers", list_full_color_laser_printers);
					
	        	} else if(subTypeProduct.equals("monochrome_laser_printers")){
	        		
	        		JSONArray list_monochrome_laser_printers = null;
	        		if(digital_printersJSON.get("list_monochrome_laser_printers") != null){
						digital_printersJSON.remove("list_monochrome_laser_printers");
					} 
						list_monochrome_laser_printers = new JSONArray();

					for(String fileName: selectedIds)
	        		list_monochrome_laser_printers.add(fileName);
	        		digital_printersJSON.put("list_monochrome_laser_printers", list_monochrome_laser_printers);
					
	        	} else if(subTypeProduct.equals("full-color_inkjet_printers")){
	        		
	        		JSONArray list_full_color_inkjet_printers = null;
	        		if(digital_printersJSON.get("list_full_color_inkjet_printers") != null){
						digital_printersJSON.remove("list_full_color_inkjet_printers");
					} 
						list_full_color_inkjet_printers = new JSONArray();

					for(String fileName: selectedIds)
	        		list_full_color_inkjet_printers.add(fileName);
	        		digital_printersJSON.put("list_full_color_inkjet_printers", list_full_color_inkjet_printers);
					
	        	}

				if( obj.get("digital_printersJSON") != null )
					obj.remove("digital_printersJSON");
	
			obj.put("digital_printersJSON", digital_printersJSON);
			
			} else if(typeProduct.equals("laminator")){
			
				JSONObject laminatorJSON = (JSONObject) obj.get("laminatorJSON");

				if(subTypeProduct.equals("hot_lamination")){
					
					JSONArray list_hot_lamination = null;
					if(laminatorJSON.get("list_hot_lamination") != null){
						laminatorJSON.remove("list_hot_lamination");
					} 
					
					list_hot_lamination = new JSONArray();
						
					for(String fileName: selectedIds)
					list_hot_lamination.add(fileName);
					laminatorJSON.put("list_hot_lamination", list_hot_lamination);
					
	        	} else if(subTypeProduct.equals("cold_laminating")){
	        		
	        		JSONArray list_cold_laminating = null;
	        		if(laminatorJSON.get("list_cold_laminating") != null){
						laminatorJSON.remove("list_cold_laminating");
					} 
						list_cold_laminating = new JSONArray();

					for(String fileName: selectedIds)
	        		list_cold_laminating.add(fileName);
	        		laminatorJSON.put("list_cold_laminating", list_cold_laminating);
					
	        	} else if(subTypeProduct.equals("liquid")){
	        		
	        		JSONArray list_liquid = null;
	        		if(laminatorJSON.get("list_liquid") != null){
						laminatorJSON.remove("list_liquid");
					} 
						list_liquid = new JSONArray();

					for(String fileName: selectedIds)
	        		list_liquid.add(fileName);
	        		laminatorJSON.put("list_liquid", list_liquid);
					
	        	} else if(subTypeProduct.equals("flatbed_laminating_machine")){
	        		
	        		JSONArray list_flatbed_laminating_machine = null;
	        		if(laminatorJSON.get("list_flatbed_laminating_machine") != null){
						laminatorJSON.remove("list_flatbed_laminating_machine");
					} 
						list_flatbed_laminating_machine = new JSONArray();

					for(String fileName: selectedIds)
	        		list_flatbed_laminating_machine.add(fileName);
	        		laminatorJSON.put("list_flatbed_laminating_machine", list_flatbed_laminating_machine);
					
	        	}  

				if( obj.get("laminatorJSON") != null )
					obj.remove("laminatorJSON");
	
			obj.put("laminatorJSON", laminatorJSON);
			
			} else if(typeProduct.equals("laser")){
			
				JSONObject laserJSON = (JSONObject) obj.get("laserJSON");

				if(subTypeProduct.equals("CO2_gas_lasers")){
					
					JSONArray list_CO2_gas_lasers = null;
					if(laserJSON.get("list_CO2_gas_lasers") != null){
						laserJSON.remove("list_CO2_gas_lasers");
					} 
					
					list_CO2_gas_lasers = new JSONArray();
						
					for(String fileName: selectedIds)
					list_CO2_gas_lasers.add(fileName);
					laserJSON.put("list_CO2_gas_lasers", list_CO2_gas_lasers);
					
	        	} else if(subTypeProduct.equals("solid_state_lasers")){
	        		
	        		JSONArray list_solid_state_lasers = null;
	        		if(laserJSON.get("list_solid_state_lasers") != null){
						laserJSON.remove("list_solid_state_lasers");
					} 
						list_solid_state_lasers = new JSONArray();

					for(String fileName: selectedIds)
	        		list_solid_state_lasers.add(fileName);
	        		laserJSON.put("list_solid_state_lasers", list_solid_state_lasers);
					
	        	} else if(subTypeProduct.equals("for_the_treatment_of_metal")){
	        		
	        		JSONArray list_for_the_treatment_of_metal = null;
	        		if(laserJSON.get("list_for_the_treatment_of_metal") != null){
						laserJSON.remove("list_for_the_treatment_of_metal");
					} 
						list_for_the_treatment_of_metal = new JSONArray();

					for(String fileName: selectedIds)
	        		list_for_the_treatment_of_metal.add(fileName);
	        		laserJSON.put("list_for_the_treatment_of_metal", list_for_the_treatment_of_metal);
					
	        	} else if(subTypeProduct.equals("diode_pumped")){
	        		
	        		JSONArray list_diode_pumped = null;
	        		if(laserJSON.get("list_diode_pumped") != null){
						laserJSON.remove("list_diode_pumped");
					} 
						list_diode_pumped = new JSONArray();

					for(String fileName: selectedIds)
	        		list_diode_pumped.add(fileName);
	        		laserJSON.put("list_diode_pumped", list_diode_pumped);
					
	        	} else if(subTypeProduct.equals("fiber_lasers")){
	        		
	        		JSONArray list_fiber_lasers = null;
	        		if(laserJSON.get("list_fiber_lasers") != null){
						laserJSON.remove("list_fiber_lasers");
					} 
						list_fiber_lasers = new JSONArray();

					for(String fileName: selectedIds)
	        		list_fiber_lasers.add(fileName);
	        		laserJSON.put("list_fiber_lasers", list_fiber_lasers);
					
	        	} else if(subTypeProduct.equals("plasma_lasers")){
	        		
	        		JSONArray list_plasma_lasers = null;
	        		if(laserJSON.get("list_plasma_lasers") != null){
						laserJSON.remove("list_plasma_lasers");
					} 
						list_plasma_lasers = new JSONArray();

					for(String fileName: selectedIds)
	        		list_plasma_lasers.add(fileName);
	        		laserJSON.put("list_plasma_lasers", list_plasma_lasers);
					
	        	} 

				if( obj.get("laserJSON") != null )
					obj.remove("laserJSON");
	
			obj.put("laserJSON", laserJSON);
			
			} else if(typeProduct.equals("cutter")){

				JSONObject cutterJSON = (JSONObject) obj.get("cutterJSON");

				if(subTypeProduct.equals("for_wood")){
					
					JSONArray list_for_wood = null;
					if(cutterJSON.get("list_for_wood") != null){
						cutterJSON.remove("list_for_wood");
					} 
					
					list_for_wood = new JSONArray();
						
					for(String fileName: selectedIds)
					list_for_wood.add(fileName);
					cutterJSON.put("list_for_wood", list_for_wood);
					
	        	} else if(subTypeProduct.equals("for_the_treatment_of_metal")){
	        		
	        		JSONArray list_for_the_treatment_of_metal = null;
	        		if(cutterJSON.get("list_for_the_treatment_of_metal") != null){
						cutterJSON.remove("list_for_the_treatment_of_metal");
					} 
						list_for_the_treatment_of_metal = new JSONArray();

					for(String fileName: selectedIds)
	        		list_for_the_treatment_of_metal.add(fileName);
	        		cutterJSON.put("list_for_the_treatment_of_metal", list_for_the_treatment_of_metal);
					
	        	} else if(subTypeProduct.equals("stone_processing")){
	        		
	        		JSONArray list_stone_processing = null;
	        		if(cutterJSON.get("list_stone_processing") != null){
						cutterJSON.remove("list_stone_processing");
					} 
						list_stone_processing = new JSONArray();

					for(String fileName: selectedIds)
	        		list_stone_processing.add(fileName);
	        		cutterJSON.put("list_stone_processing", list_stone_processing);
					
	        	}

				if( obj.get("cutterJSON") != null )
					obj.remove("cutterJSON");
	
			obj.put("cutterJSON", cutterJSON);
			
			} else if(typeProduct.equals("scanner")){

				JSONObject scannerJSON = (JSONObject) obj.get("scannerJSON");

				if(subTypeProduct.equals("large_format_scanners")){
					
					JSONArray list_large_format_scanners = null;
					if(scannerJSON.get("list_large_format_scanners") != null){
						scannerJSON.remove("list_large_format_scanners");
					} 
					
					list_large_format_scanners = new JSONArray();
						
					for(String fileName: selectedIds)
					list_large_format_scanners.add(fileName);
					scannerJSON.put("list_large_format_scanners", list_large_format_scanners);
					
	        	} else if(subTypeProduct.equals("3d_scanners")){
					
					JSONArray list_3d_scanners = null;
					if(scannerJSON.get("list_3d_scanners") != null){
						scannerJSON.remove("list_3d_scanners");
					} 
					
					list_3d_scanners = new JSONArray();
						
					for(String fileName: selectedIds)
					list_3d_scanners.add(fileName);
					scannerJSON.put("list_3d_scanners", list_3d_scanners);
					
	        	}

				if( obj.get("scannerJSON") != null )
					obj.remove("scannerJSON");
	
			obj.put("scannerJSON", scannerJSON);
			
			} else if(typeProduct.equals("previouslyUsed")){
	
				JSONObject previouslyUsedJSON = (JSONObject) obj.get("previouslyUsedJSON");

				if(subTypeProduct.equals("solvent_equipment")){
					
					JSONArray list_solvent_equipment = null;
					if(previouslyUsedJSON.get("list_solvent_equipment") != null){
						previouslyUsedJSON.remove("list_solvent_equipment");
					} 
					
					list_solvent_equipment = new JSONArray();
						
					for(String fileName: selectedIds)
					list_solvent_equipment.add(fileName);
					previouslyUsedJSON.put("list_solvent_equipment", list_solvent_equipment);
					
	        	} else if(subTypeProduct.equals("ecosolvent_oborudovnie")){
					
					JSONArray list_ecosolvent_oborudovnie = null;
					if(previouslyUsedJSON.get("list_ecosolvent_oborudovnie") != null){
						previouslyUsedJSON.remove("list_ecosolvent_oborudovnie");
					} 
					
					list_ecosolvent_oborudovnie = new JSONArray();
						
					for(String fileName: selectedIds)
					list_ecosolvent_oborudovnie.add(fileName);
					previouslyUsedJSON.put("list_ecosolvent_oborudovnie", list_ecosolvent_oborudovnie);
					
	        	}

				if( obj.get("previouslyUsedJSON") != null )
					obj.remove("previouslyUsedJSON");
	
			obj.put("previouslyUsedJSON", previouslyUsedJSON);
			
			} else if(typeProduct.equals("rip")){
	
				JSONObject ripJSON = (JSONObject) obj.get("ripJSON");

				if(subTypeProduct.equals("RIP_system")){
					
					JSONArray list_RIP_system = null;
					if(ripJSON.get("list_RIP_system") != null){
						ripJSON.remove("list_RIP_system");
					} 
					
					list_RIP_system = new JSONArray();
						
					for(String fileName: selectedIds)
					list_RIP_system.add(fileName);
					ripJSON.put("list_RIP_system", list_RIP_system);
					
	        	} 

				if( obj.get("ripJSON") != null )
					obj.remove("ripJSON");
	
			obj.put("ripJSON", ripJSON);
			
			}
			
			Writer out = new PrintWriter(path, "UTF-8");
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
	@RequestMapping(value="/admin/pictures/menu/{typeProduct}/{subTypeProduct}/remove_picture/{name_picture}",
					method = RequestMethod.POST,consumes="application/json",
					headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicturesMenu(@PathVariable("name_picture") String name,
    		@PathVariable("typeProduct") String typeProduct,
    		@PathVariable("subTypeProduct") String subTypeProduct) {

    	String namePicture = name.replace(":", ".");
    	logger.info("delete picture in menu, from: " + typeProduct + " , in subType: " + subTypeProduct); 	

    	try {
    		FileUtils.forceDelete(new File(directory + File.separator + "menu" + 
    	File.separator + typeProduct + File.separator + namePicture));
    		
		} catch (IOException e) {
			logger.error("Can't delete picture from the folder", e);
		} 
    	
		JSONParser parser = new JSONParser();
		
		try {
			obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			
			if(typeProduct.equals("printers")){
				
				JSONObject printersJSON = (JSONObject) obj.get("printersJSON");

				if(subTypeProduct.equals("dissolving")){
					
					JSONArray listPicturesDissolvingPrinters = (JSONArray) printersJSON.get("listPicturesDissolvingPrinters");
					printersJSON.remove("listPicturesDissolvingPrinters");

					listPicturesDissolvingPrinters.remove(namePicture);	
					printersJSON.put("listPicturesDissolvingPrinters", listPicturesDissolvingPrinters);
					
	        	} else if(subTypeProduct.equals("ecosolvent")){
	        		
					JSONArray listPicturesEcosolventPrinters = (JSONArray) printersJSON.get("listPicturesEcosolventPrinters");
					printersJSON.remove("listPicturesEcosolventPrinters");

					listPicturesEcosolventPrinters.remove(namePicture);	
					printersJSON.put("listPicturesEcosolventPrinters", listPicturesEcosolventPrinters);
					
	        	} else if(subTypeProduct.equals("UV_roll")){
	        		
	        		JSONArray listPicturesUvRollPrinters = (JSONArray) printersJSON.get("listPicturesUvRollPrinters");
					printersJSON.remove("listPicturesUvRollPrinters");

					listPicturesUvRollPrinters.remove(namePicture);	
					printersJSON.put("listPicturesUvRollPrinters", listPicturesUvRollPrinters);
					
	        	} else if(subTypeProduct.equals("UV_flatbed")){
	        		
	        		JSONArray listPicturesUvFlatbedPrinters = (JSONArray) printersJSON.get("listPicturesUvFlatbedPrinters");
					printersJSON.remove("listPicturesUvFlatbedPrinters");

					listPicturesUvFlatbedPrinters.remove(namePicture);	
					printersJSON.put("listPicturesUvFlatbedPrinters", listPicturesUvFlatbedPrinters);
					
	        	} else if(subTypeProduct.equals("sublimation")){
	        		
	        		JSONArray listPicturesSublimationPrinters = (JSONArray) printersJSON.get("listPicturesSublimationPrinters");
					printersJSON.remove("listPicturesSublimationPrinters");

					listPicturesSublimationPrinters.remove(namePicture);	
					printersJSON.put("listPicturesSublimationPrinters", listPicturesSublimationPrinters);
					
	        	} else if(subTypeProduct.equals("textile")){
	        		
	        		JSONArray listPicturesTextilePrinters = (JSONArray) printersJSON.get("listPicturesTextilePrinters");
					printersJSON.remove("listPicturesTextilePrinters");

					listPicturesTextilePrinters.remove(namePicture);	
					printersJSON.put("listPicturesTextilePrinters", listPicturesTextilePrinters);
					
	        	} else if(subTypeProduct.equals("water_pigment")){
	        		
	        		JSONArray listPicturesWaterPigmentPrinters = (JSONArray) printersJSON.get("listPicturesWaterPigmentPrinters");
					printersJSON.remove("listPicturesWaterPigmentPrinters");

					listPicturesWaterPigmentPrinters.remove(namePicture);	
					printersJSON.put("listPicturesWaterPigmentPrinters", listPicturesWaterPigmentPrinters);

	        	} else if(subTypeProduct.equals("digital")){
	        		
	        		JSONArray listPicturesDigitalPrinters = (JSONArray) printersJSON.get("listPicturesDigitalPrinters");
					printersJSON.remove("listPicturesDigitalPrinters");

					listPicturesDigitalPrinters.remove(namePicture);	
					printersJSON.put("listPicturesDigitalPrinters", listPicturesDigitalPrinters);

	        	} else if(subTypeProduct.equals("SAPR-GIS")){
	        		
	        		JSONArray listPictures_SAPR_GIS_Printers = (JSONArray) printersJSON.get("listPictures_SAPR_GIS_Printers");
					printersJSON.remove("listPictures_SAPR_GIS_Printers");

					listPictures_SAPR_GIS_Printers.remove(namePicture);	
					printersJSON.put("listPictures_SAPR_GIS_Printers", listPictures_SAPR_GIS_Printers);

	        	}

				if( obj.get("printersJSON") != null )
					obj.remove("printersJSON");
				
				obj.put("printersJSON", printersJSON);
			
			} else if(typeProduct.equals("printers3d")){
				
				JSONObject printers3dJSON = (JSONObject) obj.get("printers3dJSON");	 

				if(subTypeProduct.equals("FDM-extruder")){
					
					JSONArray list_3dPrintersFDM_Extruder = (JSONArray) printers3dJSON.get("list_3dPrintersFDM_Extruder");
					printers3dJSON.remove("list_3dPrintersFDM_Extruder");

					list_3dPrintersFDM_Extruder.remove(namePicture);	
					printers3dJSON.put("list_3dPrintersFDM_Extruder", list_3dPrintersFDM_Extruder);
					
	        	} else if(subTypeProduct.equals("photo_printing_polyjet")){
	        		
	        		JSONArray list_3d_printers_photo_printing_polyjet = (JSONArray) printers3dJSON.get("list_3d_printers_photo_printing_polyjet");
					printers3dJSON.remove("list_3d_printers_photo_printing_polyjet");

					list_3d_printers_photo_printing_polyjet.remove(namePicture);	
					printers3dJSON.put("list_3d_printers_photo_printing_polyjet", list_3d_printers_photo_printing_polyjet);
					
	        	} else if(subTypeProduct.equals("laser_sintering_LENS")){
	        		
	        		JSONArray list_3d_printers_laser_sintering_LENS = (JSONArray) printers3dJSON.get("list_3d_printers_laser_sintering_LENS");
					printers3dJSON.remove("list_3d_printers_laser_sintering_LENS");

					list_3d_printers_laser_sintering_LENS.remove(namePicture);	
					printers3dJSON.put("list_3d_printers_laser_sintering_LENS", list_3d_printers_laser_sintering_LENS);
					
	        	} else if(subTypeProduct.equals("lamination_LOM")){
	        		
	        		JSONArray list_3d_printers_lamination_LOM = (JSONArray) printers3dJSON.get("list_3d_printers_lamination_LOM");
					printers3dJSON.remove("list_3d_printers_lamination_LOM");

					list_3d_printers_lamination_LOM.remove(namePicture);	
					printers3dJSON.put("list_3d_printers_lamination_LOM", list_3d_printers_lamination_LOM);
					
	        	} else if(subTypeProduct.equals("stereolithography_SL")){
	        		
	        		JSONArray list_3d_printers_stereolithography_SL = (JSONArray) printers3dJSON.get("list_3d_printers_stereolithography_SL");
					printers3dJSON.remove("list_3d_printers_stereolithography_SL");

					list_3d_printers_stereolithography_SL.remove(namePicture);	
					printers3dJSON.put("list_3d_printers_stereolithography_SL", list_3d_printers_stereolithography_SL);
					
	        	} else if(subTypeProduct.equals("laser_sintering_LS")){
	        		
	        		JSONArray list_3d_printers_laser_sintering_LS = (JSONArray) printers3dJSON.get("list_3d_printers_laser_sintering_LS");
					printers3dJSON.remove("list_3d_printers_laser_sintering_LS");

					list_3d_printers_laser_sintering_LS.remove(namePicture);	
					printers3dJSON.put("list_3d_printers_laser_sintering_LS", list_3d_printers_laser_sintering_LS);
					
	        	} else if(subTypeProduct.equals("powder_bonding_3DP")){
	        		
	        		JSONArray list_3d_printers_powder_bonding_3DP = (JSONArray) printers3dJSON.get("list_3d_printers_powder_bonding_3DP");
					printers3dJSON.remove("list_3d_printers_powder_bonding_3DP");

					list_3d_printers_powder_bonding_3DP.remove(namePicture);	
					printers3dJSON.put("list_3d_printers_powder_bonding_3DP", list_3d_printers_powder_bonding_3DP);

	        	}

				if( obj.get("printers3dJSON") != null )
					obj.remove("printers3dJSON");
	
				obj.put("printers3dJSON", printers3dJSON);
			
			} else if(typeProduct.equals("digital_printers")){
				
				JSONObject digital_printersJSON = (JSONObject) obj.get("digital_printersJSON");	 

				if(subTypeProduct.equals("full_color_laser_printers")){
					
					JSONArray list_full_color_laser_printers = (JSONArray) digital_printersJSON.get("list_full_color_laser_printers");
					digital_printersJSON.remove("list_full_color_laser_printers");

					list_full_color_laser_printers.remove(namePicture);	
					digital_printersJSON.put("list_full_color_laser_printers", list_full_color_laser_printers);
					
	        	} else if(subTypeProduct.equals("monochrome_laser_printers")){
	        		
	        		JSONArray list_monochrome_laser_printers = (JSONArray) digital_printersJSON.get("list_monochrome_laser_printers");
					digital_printersJSON.remove("list_monochrome_laser_printers");

					list_monochrome_laser_printers.remove(namePicture);	
					digital_printersJSON.put("list_monochrome_laser_printers", list_monochrome_laser_printers);
					
	        	} else if(subTypeProduct.equals("full-color_inkjet_printers")){
	        		
	        		JSONArray list_full_color_inkjet_printers = (JSONArray) digital_printersJSON.get("list_full_color_inkjet_printers");
					digital_printersJSON.remove("list_full_color_inkjet_printers");

					list_full_color_inkjet_printers.remove(namePicture);	
					digital_printersJSON.put("list_full_color_inkjet_printers", list_full_color_inkjet_printers);
					
	        	} 
				
				if( obj.get("digital_printersJSON") != null )
					obj.remove("digital_printersJSON");
	
				obj.put("digital_printersJSON", digital_printersJSON);
			
			} else if(typeProduct.equals("laminator")){
				
				JSONObject laminatorJSON = (JSONObject) obj.get("laminatorJSON");	 

				if(subTypeProduct.equals("hot_lamination")){
					
					JSONArray list_hot_lamination = (JSONArray) laminatorJSON.get("list_hot_lamination");
					laminatorJSON.remove("list_hot_lamination");

					list_hot_lamination.remove(namePicture);	
					laminatorJSON.put("list_hot_lamination", list_hot_lamination);
					
	        	} else if(subTypeProduct.equals("cold_laminating")){
	        		
	        		JSONArray list_cold_laminating = (JSONArray) laminatorJSON.get("list_cold_laminating");
					laminatorJSON.remove("list_cold_laminating");

					list_cold_laminating.remove(namePicture);	
					laminatorJSON.put("list_cold_laminating", list_cold_laminating);
					
	        	} else if(subTypeProduct.equals("liquid")){
	        		
	        		JSONArray list_liquid = (JSONArray) laminatorJSON.get("list_liquid");
					laminatorJSON.remove("list_liquid");

					list_liquid.remove(namePicture);	
					laminatorJSON.put("list_liquid", list_liquid);
					
	        	} else if(subTypeProduct.equals("flatbed_laminating_machine")){
	        		
	        		JSONArray list_flatbed_laminating_machine = (JSONArray) laminatorJSON.get("list_flatbed_laminating_machine");
					laminatorJSON.remove("list_flatbed_laminating_machine");

					list_flatbed_laminating_machine.remove(namePicture);	
					laminatorJSON.put("list_flatbed_laminating_machine", list_flatbed_laminating_machine);
					
	        	}

				if( obj.get("laminatorJSON") != null )
					obj.remove("laminatorJSON");
	
				obj.put("laminatorJSON", laminatorJSON);
			
			} else if(typeProduct.equals("laser")){
				
				JSONObject laserJSON = (JSONObject) obj.get("laserJSON");	 

				if(subTypeProduct.equals("CO2_gas_lasers")){
					
					JSONArray list_CO2_gas_lasers = (JSONArray) laserJSON.get("list_CO2_gas_lasers");
					laserJSON.remove("list_CO2_gas_lasers");

					list_CO2_gas_lasers.remove(namePicture);	
					laserJSON.put("list_CO2_gas_lasers", list_CO2_gas_lasers);
					
	        	} else if(subTypeProduct.equals("solid_state_lasers")){
	        		
	        		JSONArray list_solid_state_lasers = (JSONArray) laserJSON.get("list_solid_state_lasers");
					laserJSON.remove("list_solid_state_lasers");

					list_solid_state_lasers.remove(namePicture);	
					laserJSON.put("list_solid_state_lasers", list_solid_state_lasers);
					
	        	} else if(subTypeProduct.equals("for_the_treatment_of_metal")){
	        		
	        		JSONArray list_for_the_treatment_of_metal = (JSONArray) laserJSON.get("list_for_the_treatment_of_metal");
					laserJSON.remove("list_for_the_treatment_of_metal");

					list_for_the_treatment_of_metal.remove(namePicture);	
					laserJSON.put("list_for_the_treatment_of_metal", list_for_the_treatment_of_metal);
					
	        	} else if(subTypeProduct.equals("diode_pumped")){
	        		
	        		JSONArray list_diode_pumped = (JSONArray) laserJSON.get("list_diode_pumped");
					laserJSON.remove("list_diode_pumped");

					list_diode_pumped.remove(namePicture);	
					laserJSON.put("list_diode_pumped", list_diode_pumped);
					
	        	} else if(subTypeProduct.equals("fiber_lasers")){
	        		
	        		JSONArray list_fiber_lasers = (JSONArray) laserJSON.get("list_fiber_lasers");
					laserJSON.remove("list_fiber_lasers");

					list_fiber_lasers.remove(namePicture);	
					laserJSON.put("list_fiber_lasers", list_fiber_lasers);
					
	        	} else if(subTypeProduct.equals("plasma_lasers")){
	        		
	        		JSONArray list_plasma_lasers = (JSONArray) laserJSON.get("list_plasma_lasers");
					laserJSON.remove("list_plasma_lasers");

					list_plasma_lasers.remove(namePicture);	
					laserJSON.put("list_plasma_lasers", list_plasma_lasers);
					
	        	}


				if( obj.get("laserJSON") != null )
					obj.remove("laserJSON");
	
				obj.put("laserJSON", laserJSON);
			
			} else if(typeProduct.equals("cutter")){

				JSONObject cutterJSON = (JSONObject) obj.get("cutterJSON");	 

				if(subTypeProduct.equals("for_wood")){
					
					JSONArray list_for_wood = (JSONArray) cutterJSON.get("list_for_wood");
					cutterJSON.remove("list_for_wood");

					list_for_wood.remove(namePicture);	
					cutterJSON.put("list_for_wood", list_for_wood);
					
	        	} else if(subTypeProduct.equals("for_the_treatment_of_metal")){
	        		
	        		JSONArray list_for_the_treatment_of_metal = (JSONArray) cutterJSON.get("list_for_the_treatment_of_metal");
					cutterJSON.remove("list_for_the_treatment_of_metal");

					list_for_the_treatment_of_metal.remove(namePicture);	
					cutterJSON.put("list_for_the_treatment_of_metal", list_for_the_treatment_of_metal);
					
	        	} else if(subTypeProduct.equals("stone_processing")){
	        		
	        		JSONArray list_stone_processing = (JSONArray) cutterJSON.get("list_stone_processing");
					cutterJSON.remove("list_stone_processing");

					list_stone_processing.remove(namePicture);	
					cutterJSON.put("list_stone_processing", list_stone_processing);
					
	        	}

				if( obj.get("cutterJSON") != null )
					obj.remove("cutterJSON");
	
				obj.put("cutterJSON", cutterJSON);
			
			} else if(typeProduct.equals("scanner")){
		
				JSONObject scannerJSON = (JSONObject) obj.get("scannerJSON");	 

				if(subTypeProduct.equals("large_format_scanners")){
					
					JSONArray list_large_format_scanners = (JSONArray) scannerJSON.get("list_large_format_scanners");
					scannerJSON.remove("list_large_format_scanners");

					list_large_format_scanners.remove(namePicture);	
					scannerJSON.put("list_large_format_scanners", list_large_format_scanners);
					
	        	} else if(subTypeProduct.equals("3d_scanners")){
					
					JSONArray list_3d_scanners = (JSONArray) scannerJSON.get("list_3d_scanners");
					scannerJSON.remove("list_3d_scanners");

					list_3d_scanners.remove(namePicture);	
					scannerJSON.put("list_3d_scanners", list_3d_scanners);
					
	        	}

				if( obj.get("scannerJSON") != null )
					obj.remove("scannerJSON");
	
				obj.put("scannerJSON", scannerJSON);
			
			} else if(typeProduct.equals("previouslyUsed")){

				JSONObject previouslyUsedJSON = (JSONObject) obj.get("previouslyUsedJSON");	 

				if(subTypeProduct.equals("solvent_equipment")){
					
					JSONArray list_solvent_equipment = (JSONArray) previouslyUsedJSON.get("list_solvent_equipment");
					previouslyUsedJSON.remove("list_solvent_equipment");

					list_solvent_equipment.remove(namePicture);	
					previouslyUsedJSON.put("list_solvent_equipment", list_solvent_equipment);
					
	        	} else if(subTypeProduct.equals("ecosolvent_oborudovnie")){
					
					JSONArray list_ecosolvent_oborudovnie = (JSONArray) previouslyUsedJSON.get("list_ecosolvent_oborudovnie");
					previouslyUsedJSON.remove("list_ecosolvent_oborudovnie");

					list_ecosolvent_oborudovnie.remove(namePicture);	
					previouslyUsedJSON.put("list_ecosolvent_oborudovnie", list_ecosolvent_oborudovnie);
					
	        	}

				if( obj.get("previouslyUsedJSON") != null )
					obj.remove("previouslyUsedJSON");
	
				obj.put("previouslyUsedJSON", previouslyUsedJSON);
			
			} else if(typeProduct.equals("rip")){

				JSONObject ripJSON = (JSONObject) obj.get("ripJSON");	 

				if(subTypeProduct.equals("RIP_system")){
					
					JSONArray list_RIP_system = (JSONArray) ripJSON.get("list_RIP_system");
					ripJSON.remove("list_RIP_system");

					list_RIP_system.remove(namePicture);	
					ripJSON.put("list_RIP_system", list_RIP_system);
					
	        	} 

				if( obj.get("ripJSON") != null )
					obj.remove("ripJSON");
	
				obj.put("ripJSON", ripJSON);
			
			}
			
			Writer out = new PrintWriter(path, "UTF-8");
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
