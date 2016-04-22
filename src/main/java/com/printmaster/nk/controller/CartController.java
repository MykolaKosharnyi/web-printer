package com.printmaster.nk.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.printmaster.nk.beans.Cart;
import com.printmaster.nk.beans.ProductCart;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.service.Printer3DService;
import com.printmaster.nk.service.PrinterService;

@Controller
public class CartController {

	private static final Logger logger = Logger.getLogger(CartController.class);
	
	@Autowired
	PrinterService printerService;
	
	@Autowired
	Printer3DService printer3DService;
	
	@Autowired
	Cart cart;
	
	@RequestMapping(value = "/cart/add/{typeProduct}/{productId}", method = RequestMethod.POST,consumes="application/json",
			headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void addToCart(@PathVariable("typeProduct") String typeProduct,
							@PathVariable("productId") Long productId/*, @RequestHeader("referer") String referedForm*/){
		
		ProductCart productCart = new ProductCart();
		
		if(typeProduct.equals("printer")){
			Printer product = printerService.getPrinterById(productId);
			productCart.setPicturePath("printers/" + productId + "/" + product.getPathPictures().get(0));
			productCart.setName(product.getName());
			productCart.setTypeProduct(typeProduct);
			productCart.setPartNumber(product.getPartNumber());
			productCart.setPrise(product.getPrise());
			productCart.setIdProduct(product.getId());
			
		} else if(typeProduct.equals("printer3d")){
			Printer3D product = printer3DService.getPrinter3DById(productId);
			productCart.setPicturePath("printers3d/" + productId + "/" + product.getPathPictures().get(0));
			productCart.setName(product.getName());
			productCart.setTypeProduct(typeProduct);
			productCart.setPartNumber(product.getPartNumber());
			productCart.setPrise(product.getPrise());
			productCart.setIdProduct(product.getId());

		}
		
		cart.addProduct(productCart , 1);
		logger.debug("Adding product to cart " + productCart );
		//return "redirect:" + referedForm;
	}
	
	@RequestMapping(value = "cart/delete/{partNumber}")
	public String removeFromCart(Model model, @PathVariable("partNumber") String partNumber){
		
		for (Map.Entry<ProductCart, Integer> entry : cart.getContents().entrySet()) {
			ProductCart key = entry.getKey();
			if (key.getPartNumber().equals(partNumber)){
				cart.removeProduct(key);
				logger.debug("Remove product from cart " + key );
				break;
			}
		}
		return "redirect:/cart";
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