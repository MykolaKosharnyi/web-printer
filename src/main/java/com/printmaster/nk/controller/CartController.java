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

@Controller
public class CartController {

	private static final Logger logger = Logger.getLogger(CartController.class);
	
	@Autowired
	Cart cart;
	
	@RequestMapping(value = "/cart/add/{typeProduct}/{productId}/{productName}/{productPrice}/{pathToPicture}", 
			method = RequestMethod.POST,consumes="application/json",
			headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody void addToCart(
			@PathVariable("typeProduct") String typeProduct,
			@PathVariable("productId") long productId,
			@PathVariable("productName") String productName,
			@PathVariable("productPrice") String productPrice,
			@PathVariable("pathToPicture") String pathToPicture){
		
		double price = Double.parseDouble(productPrice.replace(',', '.'));
		String picture = pathToPicture.replace(',', '.');
		
		ProductCart productCart = new ProductCart();
		productCart.setTypeProduct(typeProduct);
		productCart.setIdProduct(productId);
		productCart.setName(productName);
		productCart.setPrice(price);
		productCart.setPicturePath("images/" + typeProduct + "s/" + productId + "/" + picture);
		
		cart.addProduct(productCart , 1);
		logger.debug("Adding product to cart " + productCart );
		//return "redirect:" + referedForm;
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
