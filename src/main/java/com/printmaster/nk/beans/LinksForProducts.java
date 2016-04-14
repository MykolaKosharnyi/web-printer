package com.printmaster.nk.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.Scanner;

@Component
public class LinksForProducts {

	private JSONObject obj = null;
	
	private String path = "/var/www/localhost" + File.separator + "links.json";
    
	@SuppressWarnings("unchecked")
	public void createLinksForPrinters(Set<Printer> printers){
		JSONParser parser = new JSONParser();
			try {
				obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				
				if( obj.get("printersJSON") != null )
					obj.remove("printersJSON");
				
				JSONObject variable = null;
				JSONObject printersJSON = new JSONObject();
				
				JSONArray listDissolvingPrinters = new JSONArray();
				JSONArray listEcosolventPrinters = new JSONArray();
				JSONArray listUvRollPrinters = new JSONArray();
				JSONArray listUvFlatbedPrinters = new JSONArray();
				JSONArray listSublimationPrinters = new JSONArray();
				JSONArray listTextilePrinters = new JSONArray();
				JSONArray listWaterPigmentPrinters = new JSONArray();
				JSONArray listDigitalPrinters = new JSONArray();
				JSONArray listSAPRGISPrinters = new JSONArray();
				
				Iterator<Printer> it = printers.iterator();
				
				while(it.hasNext()){				
					Printer currentPrinter = it.next();
					String type = currentPrinter.getTypePrinter();
					
					if(type.equals("Сольвентный")){
						variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listDissolvingPrinters.add(variable);
		        	} else if(type.equals("Экосольвентный")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listEcosolventPrinters.add(variable);
		        	} else if(type.equals("UV рулонный")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listUvRollPrinters.add(variable);
		        	} else if(type.equals("UV плоскопечатный")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listUvFlatbedPrinters.add(variable);
		        	} else if(type.equals("Сублимационный")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listSublimationPrinters.add(variable);
		        	} else if(type.equals("Текстильный")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listTextilePrinters.add(variable);
		        	} else if(type.equals("Водный/Пигментный")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listWaterPigmentPrinters.add(variable);
		        	} else if(type.equals("Цифровый")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listDigitalPrinters.add(variable);
		        	} else if(type.equals("САПР/ГИС")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listSAPRGISPrinters.add(variable);
		        	}
			}
				
				printersJSON.put("listDissolvingPrinters", listDissolvingPrinters);
				printersJSON.put("listEcosolventPrinters", listEcosolventPrinters);
				printersJSON.put("listUvRollPrinters", listUvRollPrinters);
				printersJSON.put("listUvFlatbedPrinters", listUvFlatbedPrinters);
				printersJSON.put("listSublimationPrinters", listSublimationPrinters);
				printersJSON.put("listTextilePrinters", listTextilePrinters);
				printersJSON.put("listWaterPigmentPrinters", listWaterPigmentPrinters);
				printersJSON.put("listDigitalPrinters", listDigitalPrinters);
				printersJSON.put("listSAPRGISPrinters", listSAPRGISPrinters);
				
				obj.put("printersJSON", printersJSON);
				
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
	public void createLinksFor3DPrinters(Set<Printer3D> printers3D){
		JSONParser parser = new JSONParser();
		try {
			obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			
			if( obj.get("printers3dJSON") != null )
				obj.remove("printers3dJSON");
			
			JSONObject variable = null;
			JSONObject printers3dJSON = new JSONObject();
			
			JSONArray list_3dPrintersFDM_Extruder = new JSONArray();
			JSONArray list_3d_printers_photo_printing_polyjet = new JSONArray();
			JSONArray list_3d_printers_laser_sintering_LENS = new JSONArray();
			JSONArray list_3d_printers_lamination_LOM = new JSONArray();
			JSONArray list_3d_printers_stereolithography_SL = new JSONArray();
			JSONArray list_3d_printers_laser_sintering_LS = new JSONArray();
			JSONArray list_3d_printers_powder_bonding_3DP = new JSONArray();
			
			Iterator<Printer3D> it = printers3D.iterator();
			
			while(it.hasNext()){				
				Printer3D currentPrinter = it.next();
					String type = currentPrinter.getTypePrinter3D();
					
					if(type.equals("Экструдные FDM")){
						variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_3dPrintersFDM_Extruder.add(variable);
		        	} else if(type.equals("Фото печать Polyjet")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_3d_printers_photo_printing_polyjet.add(variable);
		        	} else if(type.equals("Лазерного спекания LENS")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_3d_printers_laser_sintering_LENS.add(variable);
		        	} else if(type.equals("Ламинация LOM")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_3d_printers_lamination_LOM.add(variable);
		        	} else if(type.equals("Стереолитография SL")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_3d_printers_stereolithography_SL.add(variable);
		        	} else if(type.equals("Лазерное спекание LS")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_3d_printers_laser_sintering_LS.add(variable);
		        	} else if(type.equals("Порошкового склеивания 3DP")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_3d_printers_powder_bonding_3DP.add(variable);
		        	}
			}
			
			printers3dJSON.put("list_3dPrintersFDM_Extruder", list_3dPrintersFDM_Extruder);
			printers3dJSON.put("list_3d_printers_photo_printing_polyjet", list_3d_printers_photo_printing_polyjet);
			printers3dJSON.put("list_3d_printers_laser_sintering_LENS", list_3d_printers_laser_sintering_LENS);
			printers3dJSON.put("list_3d_printers_lamination_LOM", list_3d_printers_lamination_LOM);
			printers3dJSON.put("list_3d_printers_stereolithography_SL", list_3d_printers_stereolithography_SL);
			printers3dJSON.put("list_3d_printers_laser_sintering_LS", list_3d_printers_laser_sintering_LS);
			printers3dJSON.put("list_3d_printers_powder_bonding_3DP", list_3d_printers_powder_bonding_3DP);
			
			obj.put("printers3dJSON", printers3dJSON);
			
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
	public void createLinksForDigitalPrinters(Set<DigitalPrinter> printers){
		JSONParser parser = new JSONParser();
			try {
				obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				
				if( obj.get("digital_printersJSON") != null )
					obj.remove("digital_printersJSON");
				
				JSONObject variable = null;
				JSONObject digitalPrintersJSON = new JSONObject();
				
				JSONArray listFullColorLaserPrinters = new JSONArray();
				JSONArray listMonochromeLaserPrinters = new JSONArray();
				JSONArray listFullColorInkjetPrinters = new JSONArray();
				
				Iterator<DigitalPrinter> it = printers.iterator();
				
				while(it.hasNext()){				
					DigitalPrinter currentPrinter = it.next();
					String type = currentPrinter.getTypePrinter();
					
					if(type.equals("Полноцветное лазерное оборудование")){
						variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listFullColorLaserPrinters.add(variable);
		        	} else if(type.equals("Монохромное лазерное оборудование")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listMonochromeLaserPrinters.add(variable);
		        	} else if(type.equals("Полноцветное струйное оборудование")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						listFullColorInkjetPrinters.add(variable);
		        	}
			}
				
				digitalPrintersJSON.put("listFullColorLaserPrinters", listFullColorLaserPrinters);
				digitalPrintersJSON.put("listMonochromeLaserPrinters", listMonochromeLaserPrinters);
				digitalPrintersJSON.put("listFullColorInkjetPrinters", listFullColorInkjetPrinters);
				
				obj.put("digital_printersJSON", digitalPrintersJSON);
				
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
	public void createLinksForLasers(Set<Laser> lasers){
		JSONParser parser = new JSONParser();
			try {
				obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				
				if( obj.get("laserJSON") != null )
					obj.remove("laserJSON");
				
				JSONObject variable = null;
				JSONObject laserJSON = new JSONObject();
				
				JSONArray list_CO2_gas_lasers = new JSONArray();
				JSONArray list_solid_state_lasers = new JSONArray();
				JSONArray list_for_the_treatment_of_metal = new JSONArray();
				JSONArray list_diode_pumped = new JSONArray();
				JSONArray list_fiber_lasers = new JSONArray();
				JSONArray list_plasma_lasers = new JSONArray();
				
				Iterator<Laser> it = lasers.iterator();
				
				while(it.hasNext()){				
					Laser currentPrinter = it.next();
					String type = currentPrinter.getTypeLaser();
					
					if(type.equals("Газовые лазеры СО2")){
						variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_CO2_gas_lasers.add(variable);
		        	} else if(type.equals("Твердотельные лазеры")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_solid_state_lasers.add(variable);
		        	} else if(type.equals("Для обработки метала")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_for_the_treatment_of_metal.add(variable);
		        	} else if(type.equals("С диодной накачкой")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_diode_pumped.add(variable);
		        	} else if(type.equals("Оптоволоконные лазеры")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_fiber_lasers.add(variable);
		        	} else if(type.equals("Плазменные лазеры")){
		        		variable = new JSONObject();
						variable.put("name", currentPrinter.getName());
						variable.put("id", currentPrinter.getId());
						list_plasma_lasers.add(variable);
		        	}
			}
				
				laserJSON.put("list_CO2_gas_lasers", list_CO2_gas_lasers);
				laserJSON.put("list_solid_state_lasers", list_solid_state_lasers);
				laserJSON.put("list_for_the_treatment_of_metal", list_for_the_treatment_of_metal);
				laserJSON.put("list_diode_pumped", list_diode_pumped);
				laserJSON.put("list_fiber_lasers", list_fiber_lasers);
				laserJSON.put("list_plasma_lasers", list_plasma_lasers);
				
				obj.put("laserJSON", laserJSON);
				
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
	public void createLinksForCutters(Set<Cutter> cutters){
		JSONParser parser = new JSONParser();
			try {
				obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				
				if( obj.get("cuttersJSON") != null )
					obj.remove("cuttersJSON");
				
				JSONObject variable = null;
				JSONObject cuttersJSON = new JSONObject();
				
				JSONArray list_for_wood = new JSONArray();
				JSONArray list_for_the_treatment_of_metal = new JSONArray();
				JSONArray list_stone_processing = new JSONArray();
				
				Iterator<Cutter> it = cutters.iterator();
				
				while(it.hasNext()){				
					Cutter currentCutter = it.next();
					String type = currentCutter.getTypeCutter();
					
					if(type.equals("Для обработки дерева")){
						variable = new JSONObject();
						variable.put("name", currentCutter.getName());
						variable.put("id", currentCutter.getId());
						list_for_wood.add(variable);
		        	} else if(type.equals("Для обработки металла")){
		        		variable = new JSONObject();
						variable.put("name", currentCutter.getName());
						variable.put("id", currentCutter.getId());
						list_for_the_treatment_of_metal.add(variable);
		        	} else if(type.equals("Для обработки камня")){
		        		variable = new JSONObject();
						variable.put("name", currentCutter.getName());
						variable.put("id", currentCutter.getId());
						list_stone_processing.add(variable);
		        	}
			}
				
				cuttersJSON.put("list_for_wood", list_for_wood);
				cuttersJSON.put("list_for_the_treatment_of_metal", list_for_the_treatment_of_metal);
				cuttersJSON.put("list_stone_processing", list_stone_processing);
				
				obj.put("cuttersJSON", cuttersJSON);
				
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
	public void createLinksForLaminators(Set<Laminator> laminators){
		JSONParser parser = new JSONParser();
			try {
				obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				
				if( obj.get("laminatorsJSON") != null )
					obj.remove("laminatorsJSON");
				
				JSONObject variable = null;
				JSONObject laminatorsJSON = new JSONObject();
				
				JSONArray list_hot_lamination = new JSONArray();
				JSONArray list_cold_laminating = new JSONArray();
				JSONArray list_liquid = new JSONArray();
				JSONArray list_flatbed_laminating_machine = new JSONArray();
				
				Iterator<Laminator> it = laminators.iterator();
				
				while(it.hasNext()){				
					Laminator currentLaminator = it.next();
					String type = currentLaminator.getTypeProduct();
					
					if(type.equals("Горячего ламинирования")){
						variable = new JSONObject();
						variable.put("name", currentLaminator.getName());
						variable.put("id", currentLaminator.getId());
						list_hot_lamination.add(variable);
		        	} else if(type.equals("Холодного ламинирования")){
		        		variable = new JSONObject();
						variable.put("name", currentLaminator.getName());
						variable.put("id", currentLaminator.getId());
						list_cold_laminating.add(variable);
		        	} else if(type.equals("Жидкостные")){
		        		variable = new JSONObject();
						variable.put("name", currentLaminator.getName());
						variable.put("id", currentLaminator.getId());
						list_liquid.add(variable);
		        	} else if(type.equals("Планшетный ламинатор")){
		        		variable = new JSONObject();
						variable.put("name", currentLaminator.getName());
						variable.put("id", currentLaminator.getId());
						list_flatbed_laminating_machine.add(variable);
		        	}
			}
				
				laminatorsJSON.put("list_hot_lamination", list_hot_lamination);
				laminatorsJSON.put("list_cold_laminating", list_cold_laminating);
				laminatorsJSON.put("list_liquid", list_liquid);
				laminatorsJSON.put("list_flatbed_laminating_machine", list_flatbed_laminating_machine);
				
				obj.put("laminatorsJSON", laminatorsJSON);
				
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
	public void createLinksForScanners(Set<Scanner> scanners){
		JSONParser parser = new JSONParser();
			try {
				obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				
				if( obj.get("scannersJSON") != null )
					obj.remove("scannersJSON");
				
				JSONObject variable = null;
				JSONObject scannersJSON = new JSONObject();
				
				JSONArray list_large_format_scanners = new JSONArray();
				JSONArray list_3d_scanners = new JSONArray();
				
				Iterator<Scanner> it = scanners.iterator();
				
				while(it.hasNext()){				
					Scanner currentScanner = it.next();
					String type = currentScanner.getTypeProduct();
					
					if(type.equals("Широкоформатные сканеры")){
						variable = new JSONObject();
						variable.put("name", currentScanner.getName());
						variable.put("id", currentScanner.getId());
						list_large_format_scanners.add(variable);
						
		        	} else if(type.equals("3D Сканеры")){
						variable = new JSONObject();
						variable.put("name", currentScanner.getName());
						variable.put("id", currentScanner.getId());
						list_3d_scanners.add(variable);
		        	} 
			}
		
				scannersJSON.put("list_large_format_scanners", list_large_format_scanners);
				scannersJSON.put("list_3d_scanners", list_3d_scanners);
				
				obj.put("scannersJSON", scannersJSON);
				
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
