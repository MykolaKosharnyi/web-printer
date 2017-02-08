package com.printmaster.nk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.model.service.CutterService;
import com.printmaster.nk.model.service.DigitalPrinterService;
import com.printmaster.nk.model.service.LaminatorService;
import com.printmaster.nk.model.service.LaserService;
import com.printmaster.nk.model.service.PreviousUsedEqvipmentService;
import com.printmaster.nk.model.service.Printer3DService;
import com.printmaster.nk.model.service.PrinterService;
import com.printmaster.nk.model.service.RipService;
import com.printmaster.nk.model.service.ScannerService;
import com.printmaster.nk.model.service.UseWithProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private PrinterService printerService;
	
	@Autowired
	private Printer3DService printer3DService;
	
	@Autowired
	private DigitalPrinterService digitalPrinterService;
	
	@Autowired
	private LaserService laserService;
	
	@Autowired
	private CutterService cutterService;
	
	@Autowired
	private LaminatorService laminatorService;
	
	@Autowired
	private ScannerService scannerService;
	
	@Autowired
	private PreviousUsedEqvipmentService pueService;
	
	@Autowired
	private RipService ripService;
	
	@Autowired
	private UseWithProductService useWithProductService;
	
	@Autowired
    ComponentsForControllers componets;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject homeJSON = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/home.json"), "UTF-8"));
			model.addAttribute("homeJSON", (JSONObject) homeJSON.get("homeJSON"));
			model.addAttribute("listVideo", (JSONArray) homeJSON.get("listVideo"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("printers", componets.makeLightWeightCollectionOfProduct(printerService.listShowOnHomePage()));
		model.addAttribute("printers3D", componets.makeLightWeightCollectionOfProduct(printer3DService.listShowOnHomePage()));  
		model.addAttribute("digitalPrinters", componets.makeLightWeightCollectionOfProduct(digitalPrinterService.listShowOnHomePage()));
		model.addAttribute("lasers", componets.makeLightWeightCollectionOfProduct(laserService.listShowOnHomePage()));
		model.addAttribute("cutters", componets.makeLightWeightCollectionOfProduct(cutterService.listShowOnHomePage()));
		model.addAttribute("laminators", componets.makeLightWeightCollectionOfProduct(laminatorService.listShowOnHomePage()));
		model.addAttribute("scanners", componets.makeLightWeightCollectionOfProduct(scannerService.listShowOnHomePage()));
		model.addAttribute("pue", pueService.listProductForHomePage());
		model.addAttribute("rips", ripService.listShowOnHomePage());
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search_by_phrase", method = RequestMethod.GET)
	public String searchByPhraseGet(Model model, @RequestParam String type, @RequestParam String phrase){
		JSONArray result = new JSONArray();	
		
		boolean ifAll = false;
		if(type.equals("all"))
			ifAll = true;
		
		if(ifAll || type.equals("printer")){
			result.addAll(componets.makeLightWeightCollectionOfProduct(printerService.listSearchByPhrase(phrase)));
		}
		
		if(ifAll || type.equals("3d_printer")){
			result.addAll(componets.makeLightWeightCollectionOfProduct(printer3DService.listSearchByPhrase(phrase)));
		}
		
		if(ifAll || type.equals("digital_printer")){
			result.addAll(componets.makeLightWeightCollectionOfProduct(digitalPrinterService.listSearchByPhrase(phrase)));
		}
		
		if(ifAll ||type.equals("laser")){
			result.addAll(componets.makeLightWeightCollectionOfProduct(laserService.listSearchByPhrase(phrase)));
		}
		
		if(ifAll || type.equals("cutter")){
			result.addAll(componets.makeLightWeightCollectionOfProduct(cutterService.listSearchByPhrase(phrase)));
		}
		
		if(ifAll || type.equals("laminator")){
			result.addAll(componets.makeLightWeightCollectionOfProduct(laminatorService.listSearchByPhrase(phrase)));
		}
		
		if(ifAll ||type.equals("scanner")){
			result.addAll(componets.makeLightWeightCollectionOfProduct(scannerService.listSearchByPhrase(phrase)));
		}
		
		if(ifAll || type.equals("rip")){
			result.addAll(componets.makeLightWeightCollectionOfProduct(ripService.listSearchByPhrase(phrase)));
		}
		
		if(ifAll || type.equals("use_with_product")){
			result.addAll(componets.makeLightWeightCollectionOfProduct(useWithProductService.listSearchByPhrase(phrase)));
		}	
		
		model.addAttribute("listProducts", result);
		model.addAttribute("phrase", phrase);
		
		logger.debug("Searching by phase done successful!");
		return "search_by_phrase";
	}
}
