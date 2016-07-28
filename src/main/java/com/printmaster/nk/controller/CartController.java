package com.printmaster.nk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.printmaster.nk.beans.Cart;
import com.printmaster.nk.beans.ProductCart;
import com.printmaster.nk.model.Product;
import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.UseWithProduct;
import com.printmaster.nk.modelwork.Option;
import com.printmaster.nk.service.CutterService;
import com.printmaster.nk.service.DigitalPrinterService;
import com.printmaster.nk.service.LaminatorService;
import com.printmaster.nk.service.LaserService;
import com.printmaster.nk.service.Printer3DService;
import com.printmaster.nk.service.PrinterService;
import com.printmaster.nk.service.RipService;
import com.printmaster.nk.service.ScannerService;
import com.printmaster.nk.service.UseWithProductService;

@Controller
public class CartController {

	private static final Logger logger = Logger.getLogger(CartController.class);
	
	@Autowired
	Cart cart;
	
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
	
	@RequestMapping(value = "/cart/add/{typeProduct}/{productId}/{productName}/{productPrice}/{pathToPicture}", 
			method = RequestMethod.POST,consumes="application/json",
			headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void addToCart(
			@PathVariable("typeProduct") String typeProduct,
			@PathVariable("productId") long productId,
			@PathVariable("productName") String productName,
			@PathVariable("productPrice") String productPrice,
			@PathVariable("pathToPicture") String pathToPicture,
			@RequestBody List<String> checkedOption){
		
		double price = Double.parseDouble(productPrice.replace(',', '.'));
		String picture = pathToPicture.replace(',', '.');
		
		ProductCart productCart = new ProductCart();
		productCart.setTypeProduct(typeProduct);
		productCart.setIdProduct(productId);
		productCart.setName(productName);
		productCart.setPrice(price);
		productCart.setPicturePath("images/" + typeProduct + "s/" + productId + "/" + picture);
		//add option with price
		productCart.setOptions(addOption(typeProduct, productId, checkedOption));
		
		cart.addProduct(productCart , 1);
		logger.debug("Adding product to cart " + productCart );
		//return "redirect:" + referedForm;
	}
	
	private ArrayList<Option> addOption(String productType, long productId, List<String> checkedOption){
		
		if(productType.equals("printer")){
			return getOption( printerService.getPrinterById(productId), checkedOption );
			
		} else if(productType.equals("3d_printer")){
			return getOption( printer3DService.getPrinter3DById(productId), checkedOption );
			
		} else if(productType.equals("digital_printer")){
			return getOption( digitalPrinterService.getPrinterById(productId), checkedOption );
			
		} else if(productType.equals("laminator")){
			return getOption( laminatorService.getLaminatorById(productId), checkedOption );
			
		} else if(productType.equals("laser")){
			return getOption( laserService.getLaserById(productId), checkedOption );
			
		} else if(productType.equals("cutter")){
			return getOption( cutterService.getCutterById(productId), checkedOption );
			
		} else if(productType.equals("scanner")){
			return getOption( scannerService.getScannerById(productId), checkedOption );
			
		} else if(productType.equals("use_with_product")){
			return getOption( useWithProductService.getUseWithProductById(productId), checkedOption );
			
		} else if(productType.equals("rip")){
			return getOption( ripService.getRipById(productId), checkedOption );
			
		} else {
			return new ArrayList<Option>();
		}

	}
	
	private ArrayList<Option> getOption(Product product, List<String> checkedOption){
		ArrayList<Option> result = new ArrayList<Option>();
		
		if(product.getOptionRIP() > 0.01){
			result.add(returnOption("Програмное обеспечение", product.getOptionRIP(), product.getDescriptionOptionRIP(), checkedOption));
		}
		
		if(product.getOptionSNCP() > 0.01){
			result.add(returnOption("СНЧП", product.getOptionSNCP(), product.getDescriptionOptionSNCP(), checkedOption));
		}
		
		if(product.getOptionDelivery() > 0.01){
			result.add(returnOption("Доставка", product.getOptionDelivery(), product.getDescriptionOptionDelivery(), checkedOption));
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
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String showCart(Model model){
		model.addAttribute("cart",cart);
		return "cart";
	}
	
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
