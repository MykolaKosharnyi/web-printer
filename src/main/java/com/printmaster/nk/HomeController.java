package com.printmaster.nk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

import com.printmaster.nk.beans.ComponetsForController;
import com.printmaster.nk.service.CutterService;
import com.printmaster.nk.service.DigitalPrinterService;
import com.printmaster.nk.service.LaminatorService;
import com.printmaster.nk.service.LaserService;
import com.printmaster.nk.service.PreviousUsedEqvipmentService;
import com.printmaster.nk.service.Printer3DService;
import com.printmaster.nk.service.PrinterService;
import com.printmaster.nk.service.RipService;
import com.printmaster.nk.service.ScannerService;

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
    ComponetsForController componets;
	
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
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("printers", componets.showSimplestArrayOfPrinter(printerService.listShowOnHomePage()));
		model.addAttribute("printers3D", printer3DService.listShowOnHomePage());
		model.addAttribute("digitalPrinters", componets.showSimplestArrayOfDigitalPrinter(digitalPrinterService.listShowOnHomePage()));
		model.addAttribute("lasers", componets.showSimplestArrayOfLaser(laserService.listShowOnHomePage()));
		model.addAttribute("cutters", componets.showSimplestArrayOfCutter(cutterService.listShowOnHomePage()));
		model.addAttribute("laminators", componets.showSimplestArrayOfLaminator(laminatorService.listShowOnHomePage()));
		model.addAttribute("scanners", componets.showSimplestArrayOfScanner(scannerService.listShowOnHomePage()));
		model.addAttribute("pue", pueService.listProductForHomePage());
		model.addAttribute("rips", ripService.listShowOnHomePage());
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
}
