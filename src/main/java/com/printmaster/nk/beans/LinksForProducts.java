package com.printmaster.nk.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.printmaster.nk.model.entity.Cutter;
import com.printmaster.nk.model.entity.DigitalPrinter;
import com.printmaster.nk.model.entity.Laminator;
import com.printmaster.nk.model.entity.Laser;
import com.printmaster.nk.model.entity.Printer;
import com.printmaster.nk.model.entity.Printer3D;
import com.printmaster.nk.model.entity.Product;
import com.printmaster.nk.model.entity.Rip;
import com.printmaster.nk.model.entity.Scanner;
import com.printmaster.nk.model.entity.UseWithProduct;

@Component
public class LinksForProducts {

	private JSONObject obj = null;
	
	private String path = "/var/www/localhost" + File.separator + "links.json";
	
	private Map<String, Map<String, String>> mapLinks = new HashMap<String, Map<String, String>>(){
		private static final long serialVersionUID = 1L;
	{
		//for Printer product
		put("printersJSON", new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{
				put("Сольвентный", "listDissolvingPrinters");
				put("Экосольвентный", "listEcosolventPrinters");
				put("UV рулонный","listUvRollPrinters");
				put("UV плоскопечатный","listUvFlatbedPrinters");
				put("Сублимационный","listSublimationPrinters");
				put("Текстильный","listTextilePrinters");
				put("Водный/Пигментный","listWaterPigmentPrinters");
				put("Цифровый","listDigitalPrinters");
				put("САПР/ГИС","listSAPRGISPrinters");
			}
		});
		
		//for 3D Printer product
		put("printers3dJSON", new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{
				put("Экструдные FDM", "list_3dPrintersFDM_Extruder");
				put("Фото печать Polyjet", "list_3d_printers_photo_printing_polyjet");
				put("Лазерного спекания LENS", "list_3d_printers_laser_sintering_LENS");
				put("Ламинация LOM", "list_3d_printers_lamination_LOM");
				put("Стереолитография SL", "list_3d_printers_stereolithography_SL");
				put("Лазерное спекание LS", "list_3d_printers_laser_sintering_LS");
				put("Порошкового склеивания 3DP", "list_3d_printers_powder_bonding_3DP");
			}
		});
		
		//for Digital Printer product
		put("digital_printersJSON", new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{
				put("Полноцветное лазерное оборудование", "listFullColorLaserPrinters");
				put("Монохромное лазерное оборудование", "listMonochromeLaserPrinters");
				put("Полноцветное струйное оборудование", "listFullColorInkjetPrinters");
			}
		});
		
		//for Laser product
		put("laserJSON", new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{
				put("Газовые лазеры СО2", "list_CO2_gas_lasers");
				put("Твердотельные лазеры", "list_solid_state_lasers");
				put("Для обработки метала", "list_for_the_treatment_of_metal");
				put("С диодной накачкой", "list_diode_pumped");
				put("Оптоволоконные лазеры", "list_fiber_lasers");
				put("Плазменные лазеры", "list_plasma_lasers");
			}
		});
		
		//for Cutter product
		put("cuttersJSON", new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{
				put("Для обработки дерева", "list_for_wood");
				put("Для обработки металла", "list_for_the_treatment_of_metal");
				put("Для обработки камня", "list_stone_processing");
			}
		});
		
		//for Laminator product
		put("laminatorsJSON", new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{
				put("Горячего ламинирования", "list_hot_lamination");
				put("Холодного ламинирования", "list_cold_laminating");
				put("Жидкостные", "list_liquid");
				put("Планшетный ламинатор", "list_flatbed_laminating_machine");
			}
		});
		
		//for Scanner product
		put("scannersJSON", new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{
				put("Широкоформатные сканеры", "list_large_format_scanners");
				put("3D Сканеры", "list_3d_scanners");
			}
		});
		
		//for Rip product
		put("ripsJSON", new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{
				put("Печатное оборудование", "list_rip_printing_equipment");
				put("3D Принтеры", "list_rip_3D_printers");
				put("Лазерно-Фрезеровальное оборудование", "list_rip_laser_milling_equipment");
				put("3D Сканеры", "list_rip_3D_scanners");
				put("Сканеры", "list_rip_scanners");
			}
		});
		
		//for Use with product
		put("useWithProductsJSON", new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{
				put("Чернила для струйной печати", "list_ink_for_inkjet");
				put("Расходные материалы для цифрового оборудования", "list_consumables_for_digital_equipment");
				put("Расходные материалы для 3D оборудования", "list_consumables_for_3D_equipment");
				put("Товары для обслуживания", "list_products_for_maintenance");
				put("Запчасти и комплектующие", "list_parts_and_accessories");	
			}
		});
	}};
    
	/**
	 * Create links for concrete group product.
	 * 
	 * @param products from which we create links for product.
	 */
	public void createLinks(Set<? extends Product> products){
		
		String typeJsonProduct = getTypeJsonProduct(products);

		Map<String, String> keyToJsonArray = new HashMap<>(mapLinks.get(typeJsonProduct));
		Map<String, JSONArray> subTypesProductWithLinks = generateSubTypesProductWithLinks(keyToJsonArray);

		Iterator<? extends Product> it = products.iterator();
		while (it.hasNext()) 
			moveProductToConctereSubType(subTypesProductWithLinks, it.next());

		saveChanges(typeJsonProduct, createJSONObjectWithLinksForThisProduct(keyToJsonArray, subTypesProductWithLinks));		
	}
	
	/**
	 * Getting type of product from set collection.
	 * 
	 * @param products
	 * @return
	 */
	private String getTypeJsonProduct(Set<? extends Product> products){
		String result = null;
		
		if(products.size() > 0){
			Object type = products.iterator().next();
	
			if (type instanceof Printer) {
				result = "printersJSON";
			} else if (type instanceof Printer3D) {
				result = "printers3dJSON";
			} else if (type instanceof DigitalPrinter) {
				result = "digital_printersJSON";
			} else if (type instanceof Cutter) {
				result = "cuttersJSON";
			} else if (type instanceof Laminator) {
				result = "laminatorsJSON";
			} else if (type instanceof Laser) {
				result = "laserJSON";
			} else if (type instanceof Scanner) {
				result = "scannersJSON";
			} else if (type instanceof Rip) {
				result = "ripsJSON";
			} else if (type instanceof UseWithProduct) {
				result = "useWithProductsJSON";
			}
		}
		return result;
	}
	
	/**
	 * Moving product to concrete type of product.
	 * 
	 * @param subTypesProduct
	 * @param product
	 */
	private <T> void moveProductToConctereSubType(Map<String, JSONArray> subTypesProduct, Product product) {

		if(product instanceof Printer){
			
			Printer currentProduct = (Printer)product;
			setNameAndIdToJsonObject(subTypesProduct, currentProduct, currentProduct.getTypePrinter());
			
		} else if(product instanceof Printer3D){
			
			Printer3D currentProduct = (Printer3D)product;
			setNameAndIdToJsonObject(subTypesProduct, currentProduct, currentProduct.getTypePrinter3D());
			
		} else if(product instanceof DigitalPrinter){
			
			DigitalPrinter currentProduct = (DigitalPrinter)product;
			setNameAndIdToJsonObject(subTypesProduct, currentProduct, currentProduct.getTypePrinter());
			
		} else if(product instanceof Laser){
			
			Laser currentProduct = (Laser)product;
			setNameAndIdToJsonObject(subTypesProduct, currentProduct, currentProduct.getTypeLaser());
			
		} else if(product instanceof Cutter){
			
			Cutter currentProduct = (Cutter)product;
			setNameAndIdToJsonObject(subTypesProduct, currentProduct, currentProduct.getTypeCutter());
			
		} else if(product instanceof Laminator){
			
			Laminator currentProduct = (Laminator)product;
			setNameAndIdToJsonObject(subTypesProduct, currentProduct, currentProduct.getTypeProduct());
			
		} else if(product instanceof Scanner){
			
			Scanner currentProduct = (Scanner)product;
			setNameAndIdToJsonObject(subTypesProduct, currentProduct, currentProduct.getTypeProduct());
			
		} else if(product instanceof Rip){
			
			Rip currentProduct = (Rip)product;
			setNameAndIdToJsonObject(subTypesProduct, currentProduct, currentProduct.getTypeEquipment());
			
		} else if(product instanceof UseWithProduct){
			
			UseWithProduct currentProduct = (UseWithProduct)product;
			setNameAndIdToJsonObject(subTypesProduct, currentProduct, currentProduct.getTypeProduct());
			
		}				
	}

	/**
	 * Set name and id of product in JSON object.
	 * 
	 * @param subTypesProduct
	 * @param currentProduct
	 * @param type
	 */
	
	@SuppressWarnings("unchecked")
	private void setNameAndIdToJsonObject(Map<String, JSONArray> subTypesProduct, Product currentProduct, String type) {
		JSONObject variable;
		if(subTypesProduct.containsKey(type)){
			variable = new JSONObject();
			variable.put("name", currentProduct.getName());
			variable.put("id", currentProduct.getId());
			subTypesProduct.get(type).add(variable);
		}
	}

	/**
	 * Get all links of concrete type product in one JSON object
	 * before writing these links into the file.
	 * 
	 * @param keyToJsonArray
	 * @param subTypesProductWithLinks
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JSONObject createJSONObjectWithLinksForThisProduct(Map<String, String> keyToJsonArray,
			Map<String, JSONArray> subTypesProductWithLinks) {
		JSONObject productsJSON = new JSONObject();
		for (String key : keyToJsonArray.keySet()) {
			productsJSON.put(keyToJsonArray.get(key), subTypesProductWithLinks.get(key));
		}
		return productsJSON;
	}
	
	/**
	 * Generate Map with string sub type of concrete product in key. 
	 * Values are array of concrete product.
	 * 
	 * @param keyToJsonArray
	 * @return
	 */
	private Map<String, JSONArray> generateSubTypesProductWithLinks(Map<String, String> keyToJsonArray) {
		Map<String, JSONArray> subTypesProductWithLinks = new HashMap<>();
		for (String key : keyToJsonArray.keySet()) {
			subTypesProductWithLinks.put(key, new JSONArray());
		}
		return subTypesProductWithLinks;
	}

	/**
	 * Method save changes(new links in JSON file) of this type products.
	 * 
	 * @param typeJsonObject
	 * @param productsJSON
	 */
	@SuppressWarnings("unchecked")
	private void saveChanges(String typeJsonObject, JSONObject productsJSON) {
		getFileWithLinks();
		obj.put(typeJsonObject, productsJSON);
		writeToJSONFile();
	}
	
	/**
	 * Write JSON object with links to JSON file on server.
	 * 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	private void writeToJSONFile(){
		try {
			Writer out = new PrintWriter(path, "UTF-8");
			out.write(obj.toJSONString());
			out.flush();
			out.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method get links with all links on products on the site (which user can see).
	 * 
	 * @throws IOException
	 * @throws ParseException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	private void getFileWithLinks() {
		try {
			obj = (JSONObject)new JSONParser().parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
}
