package com.printmaster.nk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.printmaster.nk.beans.Cart;
import com.printmaster.nk.beans.ConstantService;
import com.printmaster.nk.beans.Constants;
import com.printmaster.nk.beans.Delivery;
import com.printmaster.nk.beans.Paint;
import com.printmaster.nk.beans.ProductCart;
import com.printmaster.nk.model.entity.HeadProduct;
import com.printmaster.nk.model.entity.Option;
import com.printmaster.nk.model.entity.Rip;
import com.printmaster.nk.model.entity.UseWithProduct;
import com.printmaster.nk.model.service.CutterService;
import com.printmaster.nk.model.service.DigitalPrinterService;
import com.printmaster.nk.model.service.LaminatorService;
import com.printmaster.nk.model.service.LaserService;
import com.printmaster.nk.model.service.Printer3DService;
import com.printmaster.nk.model.service.PrinterService;
import com.printmaster.nk.model.service.RipService;
import com.printmaster.nk.model.service.ScannerService;
import com.printmaster.nk.model.service.UseWithProductService;

@Controller
public class CartController {

	private static final Logger logger = Logger.getLogger(CartController.class);
	
	@Autowired
	Cart cart;
	
	@Autowired
	private ConstantService constants;
	
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
	private RipService ripService;
	
	@Autowired
	private UseWithProductService useWithProductService;
	
	private Constants currentConstants;
	
	@RequestMapping(value = "/cart/add/{typeProduct}/{productId}/{productName}", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductCart addToCart(
			@PathVariable("typeProduct") String typeProduct,
			@PathVariable("productId") long productId,
			@PathVariable("productName") String productName,
			@RequestBody Shopping checkedOption){

		//get current version of constants
		currentConstants = constants.getConstants();
		
		ProductCart productCart = new ProductCart();
		productCart.setTypeProduct(typeProduct);
		productCart.setIdProduct(productId);
		productCart.setName(productName);
		productCart.setPrice(checkedOption.getPrice());
		productCart.setPicturePath("images/" + typeProduct + "s/" + productId + "/" + checkedOption.getPathToPicture());
		//add option with price
		productCart.setOptions(addOption(typeProduct, productId, checkedOption.getArrayOfCheckedOption()));
		productCart.setDeliveries(addDelivery(typeProduct, productId, checkedOption.getCheckedDelivery()));
		productCart.setPaints(addPaint(typeProduct, productId, checkedOption.getMapOfPaint()));
		
		cart.addProduct(productCart , 1);
		logger.debug("Adding product to cart " + productCart );
		//return "redirect:" + referedForm;
		return productCart;
	}
	
	private ArrayList<Option> addOption(String productType, long productId, List<String> checkedOption){
		
		if(productType.equals("printer")){
			return getOption( printerService.getProductById(productId), checkedOption );
			
		} else if(productType.equals("3d_printer")){
			return getOption( printer3DService.getProductById(productId), checkedOption );
			
		} else if(productType.equals("digital_printer")){
			return getOption( digitalPrinterService.getProductById(productId), checkedOption );
			
		} else if(productType.equals("laminator")){
			return getOption( laminatorService.getProductById(productId), checkedOption );
			
		} else if(productType.equals("laser")){
			return getOption( laserService.getProductById(productId), checkedOption );
			
		} else if(productType.equals("cutter")){
			return getOption( cutterService.getProductById(productId), checkedOption );
			
		} else if(productType.equals("scanner")){
			return getOption( scannerService.getProductById(productId), checkedOption );
			
		} else if(productType.equals("use_with_product")){
			return getOption( useWithProductService.getProductById(productId), checkedOption );
			
		} else if(productType.equals("rip")){
			return getOption( ripService.getProductById(productId), checkedOption );
			
		} else {
			return new ArrayList<Option>();
		}

	}
	
	private ArrayList<Option> getOption(HeadProduct product, List<String> checkedOption){
		ArrayList<Option> result = new ArrayList<Option>();
		
		if(product.getOptionRIP() > 0.01){
			result.add(returnOption("Програмное обеспечение", product.getOptionRIP(), product.getDescriptionOptionRIP(), checkedOption));
		}
		
		if(product.getOptionSNCP() > 0.01){
			result.add(returnOption("СНЧП", product.getOptionSNCP(), product.getDescriptionOptionSNCP(), checkedOption));
		}
		
		if(product.getOptionGuarantee() > 0.01){
			result.add(returnOption("Гарантия", product.getOptionGuarantee(), product.getDescriptionOptionGuarantee(), checkedOption));
		}
		
		if(product.getOptionInstallation() > 0.01){
			result.add(returnOption("Инсталяция", product.getOptionInstallation(), product.getDescriptionOptionInstallation(), checkedOption));
		}
		
		if(product.getPriceAddedOption() > 0.01){
			result.add(returnOption(product.getNameAddedOption(), product.getPriceAddedOption(), product.getDescriptionOptionAddedOption(), checkedOption));
		}
		
		if(product.getPriceAddedOption2() > 0.01){
			result.add(returnOption(product.getNameAddedOption2(), product.getPriceAddedOption2(), product.getDescriptionOptionAddedOption2(), checkedOption));
		}
		
		if(product.getPriceAddedOption3() > 0.01){
			result.add(returnOption(product.getNameAddedOption3(), product.getPriceAddedOption3(), product.getDescriptionOptionAddedOption3(), checkedOption));
		}
		
		if(product.getOptionVAT() > 0.01){
			result.add(returnOption("НДС", product.getOptionVAT(), product.getDescriptionOptionVAT(), checkedOption));
		}
		
		if( product.isInsuranceInternationalTransport() ){
			result.add(returnOption("Страхование груза международная перевозка", currentConstants.getPercentInsuranceInternational()/100 * product.getPrise(), 
					product.getDescriptionInsuranceInternationalTransport(), checkedOption));
		}
		
		if( product.isInsuranceUkraineTransport() ){
			result.add(returnOption("Страхование груза по Украине", currentConstants.getPercentInsuranceUkraine()/100 * product.getPrise(), 
					product.getDescriptionInsuranceUkraineTransport(), checkedOption));
		}
		
		return result;
	}
	
	private ArrayList<Option> getOption(UseWithProduct product, List<String> checkedOption){
		ArrayList<Option> result = new ArrayList<Option>();
		
		if(product.getOptionInstallation() > 0.01){
			result.add(returnOption("Инсталяция", product.getOptionInstallation(), product.getDescriptionOptionInstallation(), checkedOption));
		}
		
		if(product.getPriceAddedOption() > 0.01){
			result.add(returnOption(product.getNameAddedOption(), product.getPriceAddedOption(), product.getDescriptionOptionAddedOption(), checkedOption));
		}
		
		if(product.getPriceAddedOption2() > 0.01){
			result.add(returnOption(product.getNameAddedOption2(), product.getPriceAddedOption2(), product.getDescriptionOptionAddedOption2(), checkedOption));
		}
		
		if(product.getPriceAddedOption3() > 0.01){
			result.add(returnOption(product.getNameAddedOption3(), product.getPriceAddedOption3(), product.getDescriptionOptionAddedOption3(), checkedOption));
		}
		
		if(product.getOptionVAT() > 0.01){
			result.add(returnOption("НДС", product.getOptionVAT(), product.getDescriptionOptionVAT(), checkedOption));
		}
		
		if( product.isInsuranceInternationalTransport() ){
			result.add(returnOption("Страхование груза международная перевозка", currentConstants.getPercentInsuranceInternational()/100 * product.getPrise(), 
					product.getDescriptionInsuranceInternationalTransport(), checkedOption));
		}
		
		if( product.isInsuranceUkraineTransport() ){
			result.add(returnOption("Страхование груза по Украине", currentConstants.getPercentInsuranceUkraine()/100 * product.getPrise(), 
					product.getDescriptionInsuranceUkraineTransport(), checkedOption));
		}
		
		return result;
	}
	
	private ArrayList<Option> getOption(Rip product, List<String> checkedOption){
		ArrayList<Option> result = new ArrayList<Option>();
		
		if(product.getOptionInstallation() > 0.01){
			result.add(returnOption("Инсталяция", product.getOptionInstallation(), product.getDescriptionOptionInstallation(), checkedOption));
		}
		
		if(product.getPriceAddedOption() > 0.01){
			result.add(returnOption(product.getNameAddedOption(), product.getPriceAddedOption(), product.getDescriptionOptionAddedOption(), checkedOption));
		}
		
		if(product.getPriceAddedOption2() > 0.01){
			result.add(returnOption(product.getNameAddedOption2(), product.getPriceAddedOption2(), product.getDescriptionOptionAddedOption2(), checkedOption));
		}
		
		if(product.getPriceAddedOption3() > 0.01){
			result.add(returnOption(product.getNameAddedOption3(), product.getPriceAddedOption3(), product.getDescriptionOptionAddedOption3(), checkedOption));
		}
		
		if(product.getOptionVAT() > 0.01){
			result.add(returnOption("НДС", product.getOptionVAT(), product.getDescriptionOptionVAT(), checkedOption));
		}
		
		return result;
	}
	
	private Option returnOption(String name, double price, String description, List<String> checkedOption){
		Option result = new Option();
		result.setName(name);
		result.setPrice(price);
		result.setDescription(description);
		
		boolean boolResult = checkedOption.contains(name) ? true : false;
		result.setChecked(boolResult);

		return result;
	}
	
	private ArrayList<Paint> addPaint(String productType, long productId, Map<String, Integer> checkedPaint){
		
		if(productType.equals("use_with_product")){
			return getPaint( useWithProductService.getProductById(productId), checkedPaint );
		} else {
			return new ArrayList<Paint>();
		}

	}
	
	private ArrayList<Paint> getPaint(UseWithProduct product, Map<String, Integer> checkedPaint){
		ArrayList<Paint> result = new ArrayList<Paint>();
		
		if(product.getTypeProduct().equals("Чернила для струйной печати")){
			if(product.getCyanPaint() > 0){
				result.add(returnPaint("Cyan", product.getCyanPaint(), checkedPaint));
			}
			
			if(product.getMagentaPaint() > 0){
				result.add(returnPaint("Magenta", product.getMagentaPaint(), checkedPaint));
			}
			
			if(product.getYellowPaint() > 0){
				result.add(returnPaint("Yellow", product.getYellowPaint(), checkedPaint));
			}
			
			if(product.getBlackPaint() > 0){
				result.add(returnPaint("Black", product.getBlackPaint(), checkedPaint));
			}
			
			if(product.getLightCyanPaint() > 0){
				result.add(returnPaint("Light Cyan", product.getLightCyanPaint(), checkedPaint));
			}
			
			if(product.getLightMagentaPaint() > 0){
				result.add(returnPaint("Light Magenta", product.getLightMagentaPaint(), checkedPaint));
			}
			
			if(product.getSolventPaint() > 0){
				result.add(returnPaint("Solvent", product.getSolventPaint(), checkedPaint));
			}
			
			if(product.getMatteBlackPaint() > 0){
				result.add(returnPaint("Matte black", product.getMatteBlackPaint(), checkedPaint));
			}
			
			if(product.getGrayPaint() > 0){
				result.add(returnPaint("Gray", product.getGrayPaint(), checkedPaint));
			}
			
			if(product.getOrangePaint() > 0){
				result.add(returnPaint("Orange", product.getOrangePaint(), checkedPaint));
			}
			
			if(product.getGreenPaint() > 0){
				result.add(returnPaint("Green", product.getGreenPaint(), checkedPaint));
			}

			if((product.getVariant1Paint() > 0) && (product.getVariant1NamePaint() != null) && (product.getVariant1NamePaint() != "") ){
				result.add(returnPaint( product.getVariant1NamePaint(), product.getVariant1Paint(), checkedPaint ));
			}
			
			if((product.getVariant2Paint() > 0) && (product.getVariant2NamePaint() != null) && (product.getVariant2NamePaint() != "") ){
				result.add(returnPaint( product.getVariant2NamePaint(), product.getVariant2Paint(), checkedPaint ));
			}
			
			if((product.getVariant3Paint() > 0) && (product.getVariant3NamePaint() != null) && (product.getVariant3NamePaint() != "") ){
				result.add(returnPaint( product.getVariant3NamePaint(), product.getVariant3Paint(), checkedPaint ));
			}
		}

		return result;
	}
	
	private Paint returnPaint(String name, double price, Map<String, Integer> checkedPaint){
		Paint result = new Paint();
		result.setName(name);
		result.setPrice(price);
		
		result.setQuantity(checkedPaint.get(name)==null ? 1 :checkedPaint.get(name));

		boolean boolResult = checkedPaint.keySet().contains(name) ? true : false;
		result.setChecked(boolResult);

		return result;
	}
	
	private ArrayList<Delivery> addDelivery(String productType, long productId, String checkedDelivery){
		
		if(productType.equals("printer")){
			return getDelivery( printerService.getProductById(productId), checkedDelivery );
			
		} else if(productType.equals("3d_printer")){
			return getDelivery( printer3DService.getProductById(productId), checkedDelivery );
			
		} else if(productType.equals("digital_printer")){
			return getDelivery( digitalPrinterService.getProductById(productId), checkedDelivery );
			
		} else if(productType.equals("laminator")){
			return getDelivery( laminatorService.getProductById(productId), checkedDelivery );
			
		} else if(productType.equals("laser")){
			return getDelivery( laserService.getProductById(productId), checkedDelivery );
			
		} else if(productType.equals("cutter")){
			return getDelivery( cutterService.getProductById(productId), checkedDelivery );
			
		} else if(productType.equals("scanner")){
			return getDelivery( scannerService.getProductById(productId), checkedDelivery );
			
		} else if(productType.equals("use_with_product")){
			return getDelivery( useWithProductService.getProductById(productId), checkedDelivery );
			
		} else if(productType.equals("rip")){
			return getDelivery( ripService.getProductById(productId), checkedDelivery );
			
		} else {
			return new ArrayList<Delivery>();
		}
	}
	
	private ArrayList<Delivery> getDelivery(HeadProduct product, String checkedDelivery){
		ArrayList<Delivery> result = new ArrayList<Delivery>();
		
		double size = product.getDeliveryWidth() * product.getDeliveryHeight() * product.getDeliveryDepth();
		double weigth = product.getDeliveryWeight();
		
		if(product.isAirDeliveryPriceSize() || product.isAirDeliveryPriceWeight()){
			result.add(returnDelivery("Авиа",
					(product.isAirDeliveryPriceSize()) ? size * currentConstants.getPriceAviaSize():0,
					(product.isAirDeliveryPriceWeight()) ? weigth * currentConstants.getPriceAviaWeight():0,
					product.getAirDeliveryDescription(),
					checkedDelivery));
		}
		
		if(product.isSeaDeliveryPriceSize() || product.isSeaDeliveryPriceWeight()){
			result.add(returnDelivery("Морем", 
					(product.isSeaDeliveryPriceSize()) ? size * currentConstants.getPriceSeaSize():0,					
					(product.isSeaDeliveryPriceWeight()) ? weigth * currentConstants.getPriceSeaWeight():0, 
					product.getSeaDeliveryDescription(),
					checkedDelivery));
		}
		
		if(product.isUkraineDeliveryPriceSize() || product.isUkraineDeliveryPriceWeight()){
			result.add(returnDelivery("По Украине", 
					(product.isUkraineDeliveryPriceSize()) ? size * currentConstants.getPriceUkraineSize():0,
					(product.isUkraineDeliveryPriceWeight()) ? weigth * currentConstants.getPriceUkraineWeight():0, 
					product.getUkraineDeliveryDescription(), 
					checkedDelivery));
		}
		
		if(product.isKyivDeliveryPriceSize() || product.isKyivDeliveryPriceWeight()){
			result.add(returnDelivery("По Киеву", 
					(product.isKyivDeliveryPriceSize()) ? size * currentConstants.getPriceKyivSize():0,
					(product.isKyivDeliveryPriceWeight()) ? weigth * currentConstants.getPriceKyivWeight():0, 
					product.getKyivDeliveryDescription(),
					checkedDelivery));
		}
		
		if((size * product.getVariant1DeliveryPriceSize() > 0) || (weigth * product.getVariant1DeliveryPriceWeight() > 0)){
			result.add(returnDelivery(product.getVariant1DeliveryName(), size * product.getVariant1DeliveryPriceSize(), 
					weigth * product.getVariant1DeliveryPriceWeight(), product.getVariant1DeliveryDescription(), checkedDelivery));
		}
		
		if((size * product.getVariant2DeliveryPriceSize() > 0) || (weigth * product.getVariant2DeliveryPriceWeight() > 0)){
			result.add(returnDelivery(product.getVariant2DeliveryName(), size * product.getVariant2DeliveryPriceSize(), 
					weigth * product.getVariant2DeliveryPriceWeight(), product.getVariant2DeliveryDescription(), checkedDelivery));
		}
		
		if((size * product.getVariant3DeliveryPriceSize() > 0) || (weigth * product.getVariant3DeliveryPriceWeight() > 0)){
			result.add(returnDelivery(product.getVariant3DeliveryName(), size * product.getVariant3DeliveryPriceSize(), 
					weigth * product.getVariant3DeliveryPriceWeight(), product.getVariant3DeliveryDescription()
					, checkedDelivery));
		}
		
		return result;
	}
	
	private ArrayList<Delivery> getDelivery(Rip product, String checkedDelivery){
		ArrayList<Delivery> result = new ArrayList<Delivery>();
		
		double size = product.getDeliveryWidth() * product.getDeliveryHeight() * product.getDeliveryDepth();
		double weigth = product.getDeliveryWeight();
		
		if(product.isUkraineDeliveryPriceSize() || product.isUkraineDeliveryPriceWeight()){
			result.add(returnDelivery("По Украине", 
					(product.isUkraineDeliveryPriceSize()) ? size * currentConstants.getPriceUkraineSize():0,
					(product.isUkraineDeliveryPriceWeight()) ? weigth * currentConstants.getPriceUkraineWeight():0, 
					product.getUkraineDeliveryDescription(), 
					checkedDelivery));
		}
		
		if(product.isKyivDeliveryPriceSize() || product.isKyivDeliveryPriceWeight()){
			result.add(returnDelivery("По Киеву", 
					(product.isKyivDeliveryPriceSize()) ? size * currentConstants.getPriceKyivSize():0,
					(product.isKyivDeliveryPriceWeight()) ? weigth * currentConstants.getPriceKyivWeight():0, 
					product.getKyivDeliveryDescription(), 
					checkedDelivery));
		}
		
		return result;
	}
	
	private ArrayList<Delivery> getDelivery(UseWithProduct product, String checkedDelivery){
		ArrayList<Delivery> result = new ArrayList<Delivery>();
		
		double size = product.getDeliveryWidth() * product.getDeliveryHeight() * product.getDeliveryDepth();
		double weigth = product.getDeliveryWeight();
		
		if(product.isUkraineDeliveryPriceSize() || product.isUkraineDeliveryPriceWeight()){
			result.add(returnDelivery("По Украине", 
					(product.isUkraineDeliveryPriceSize()) ? size * currentConstants.getPriceUkraineSize():0,
					(product.isUkraineDeliveryPriceWeight()) ? weigth * currentConstants.getPriceUkraineWeight():0, 
					product.getUkraineDeliveryDescription(),
					checkedDelivery));
		}
		
		if(product.isKyivDeliveryPriceSize() || product.isKyivDeliveryPriceWeight()){
			result.add(returnDelivery("По Киеву", 
					(product.isKyivDeliveryPriceSize()) ? size * currentConstants.getPriceKyivSize():0,
					(product.isKyivDeliveryPriceWeight()) ? weigth * currentConstants.getPriceKyivWeight():0, 
					product.getKyivDeliveryDescription(),
					checkedDelivery));
		}
		
		return result;
	}
	
	private Delivery returnDelivery(String name, double priceSize, double priceWeight, String description, String checkedDelivery){
		Delivery result = new Delivery();
		result.setName(name);
		result.setPriceSize(priceSize);
		result.setPriceWeight(priceWeight);
		result.setDescription(description);
		
		boolean boolResult = name.equals(checkedDelivery) ? true : false;
		result.setChecked(boolResult);

		return result;
	}
	
	@RequestMapping(value = "cart/delete/{typeProduct}/{productId}", method = RequestMethod.POST,
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void removeFromCart(Model model, @PathVariable("typeProduct") String typeProduct,
			@PathVariable("productId") long productId){
		
		for (Map.Entry<ProductCart, Integer> entry : cart.getContents().entrySet()) {
			ProductCart key = entry.getKey();
			if (key.getTypeProduct().equals(typeProduct) && key.getIdProduct()==productId){
				cart.removeProduct(key);
				logger.debug("Remove product from cart " + key );
				break;
			}
		}
		/*return "redirect:/cart";*/
	}
	
	@RequestMapping(value = "cart/change_quantity/{typeProduct}/{productId}/{quantity}", method = RequestMethod.POST,
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void changeQuantityProductInCart(Model model, 
			@PathVariable("typeProduct") String typeProduct,
			@PathVariable("productId") long productId,
			@PathVariable("quantity") int quantity){
		
		for (Map.Entry<ProductCart, Integer> entry : cart.getContents().entrySet()) {
			ProductCart key = entry.getKey();
			if (key.getTypeProduct().equals(typeProduct) && key.getIdProduct()==productId){
				cart.changeQuantityProduct(key , quantity);
				logger.debug("Change quantity product in cart " + key );
				break;
			}
		}
	}
	
	@RequestMapping(value = "cart/change_quantity_paint/{typeProduct}/{productId}/{typePaint}/{quantity}", method = RequestMethod.POST,
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void changeQuantityPaintProductInCart(Model model, 
			@PathVariable("typeProduct") String typeProduct,
			@PathVariable("productId") long productId,
			@PathVariable("typePaint") String typePaint,
			@PathVariable("quantity") int quantity){
		
		for (Map.Entry<ProductCart, Integer> entry : cart.getContents().entrySet()) {
			ProductCart key = entry.getKey();
			if (key.getTypeProduct().equals(typeProduct) && key.getIdProduct()==productId){
				cart.changeQuantityPaintProduct(key, typePaint, quantity);
				logger.debug("Change quantity paint product in cart " + key );
				break;
			}
		}
	}
	
	@RequestMapping(value = "cart/change_option/{typeProduct}/{productId}/{optionName}/{stateOption}", method = RequestMethod.POST,
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void changeOptionProductInCart(Model model, 
			@PathVariable("typeProduct") String typeProduct,
			@PathVariable("productId") long productId,
			@PathVariable("optionName") String optionName,
			@PathVariable("stateOption") boolean stateOption){
		
		for (Map.Entry<ProductCart, Integer> entry : cart.getContents().entrySet()) {
			ProductCart key = entry.getKey();
			if (key.getTypeProduct().equals(typeProduct) && key.getIdProduct()==productId){
				cart.changeOptionProduct(key, optionName, stateOption);
				logger.debug("Change option product in cart " + key );
				break;
			}
		}
	}
	
	@RequestMapping(value = "cart/change_delivery/{typeProduct}/{productId}/{deliveryName}/{stateOption}", method = RequestMethod.POST,
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void changeDeliveryProductInCart(Model model, 
			@PathVariable("typeProduct") String typeProduct,
			@PathVariable("productId") long productId,
			@PathVariable("deliveryName") String deliveryName,
			@PathVariable("stateOption") boolean stateOption){
		
		for (Map.Entry<ProductCart, Integer> entry : cart.getContents().entrySet()) {
			ProductCart key = entry.getKey();
			if (key.getTypeProduct().equals(typeProduct) && key.getIdProduct()==productId){
				cart.changeDeliveryProduct(key, deliveryName, stateOption);
				logger.debug("Change delivery product in cart " + key );
				break;
			}
		}
	}
	
	@RequestMapping(value = "cart/change_paint/{typeProduct}/{productId}/{paintName}/{stateOption}", method = RequestMethod.POST,
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void changePaintProductInCart(Model model, 
			@PathVariable("typeProduct") String typeProduct,
			@PathVariable("productId") long productId,
			@PathVariable("paintName") String paintName,
			@PathVariable("stateOption") boolean stateOption){
		
		for (Map.Entry<ProductCart, Integer> entry : cart.getContents().entrySet()) {
			ProductCart key = entry.getKey();
			if (key.getTypeProduct().equals(typeProduct) && key.getIdProduct()==productId){
				cart.changePaintProduct(key, paintName, stateOption);
				logger.debug("Change paint product in cart " + key );
				break;
			}
		}
	}
	
//	@RequestMapping(value = "/cart", method = RequestMethod.GET)
//	public String showCart(Model model){
//		model.addAttribute("cart",cart);
//		return "cart";
//	}
	
	@RequestMapping(value = "/cart/placeOrder", method = RequestMethod.POST)
	public String placeOrder(/*HttpSession session*/RedirectAttributes redirectAttributes){
		if (cart.getContents().isEmpty()){
			redirectAttributes.addFlashAttribute("cartMessage", "Cart empty. Please add products to the cart.");
			return "redirect:/cart";
		} else {
			//Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
			//purchaseService.savePurchase(cart.getContents(), loggedInUser);
			redirectAttributes.addFlashAttribute("cartMessage", "Order placed. Total cost: " + cart.getTotalCost());
			cart.clearCart();
		}
		
		return "redirect:/cart";
	}
}
