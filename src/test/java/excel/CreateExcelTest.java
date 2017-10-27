package excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.printmaster.nk.beans.Cart;
import com.printmaster.nk.beans.ExcelCartOrder;
import com.printmaster.nk.beans.Paint;
import com.printmaster.nk.beans.ProductCart;
import com.printmaster.nk.model.entity.Option;
import com.printmaster.nk.beans.Cart.StatusOfOrdering;
import com.printmaster.nk.beans.Delivery;

public class CreateExcelTest {
	
	private static Cart generateFullCart(){
		Cart cart = new Cart();
		cart.setId(1l);
		cart.setIdUser(5);
		cart.setBuyOnline(true);
		cart.setDateCreation(new Date());
		cart.setStatus(StatusOfOrdering.CREATED);
		cart.setContents(generateContent());
		return cart;
	}
	
	private static Map<ProductCart, Integer> generateContent(){
		Map<ProductCart, Integer> contents = new LinkedHashMap<ProductCart, Integer>();
		for(int i = 0; i < generateInteger(10) ;i++){
			contents.put(generateProductCart(), generateInteger(10));
		}		
		return contents;
	}
	
	private static ProductCart generateProductCart(){
		ProductCart product = new ProductCart();
		product.setId((long)generateInteger(100));
		product.setTypeProduct("printer" + generateInteger(100));
		product.setName("Epson" + generateInteger(1000));
		product.setPrice(1000*generateInteger(10));
		product.setBuyOnlineCoefficient(0.95);
		product.setPriceWithOptionAndDeivery(1793);
		product.setPicturePath(null);
		product.setOptions(generateOptions());
		product.setDeliveries(generateDeliveries());
		product.setPaints(generatePaints());		
		return product;
	}
	
	private static List<Option> generateOptions(){
		List<Option> result = new ArrayList<>();
		for(int i = 0; i < generateInteger(5) ;i++){
			Option option = new Option();
			option.setChecked(true);
			option.setDescription("AAA" + i);
			option.setName("Option" + i);
			option.setPrice((double)(1+generateInteger(10) * i));
			result.add(option);
		}	
		return result;
	}
	
	private static List<Delivery> generateDeliveries(){
		List<Delivery> result = new ArrayList<>();
		for(int i = 0; i < generateInteger(5) ;i++){
			Delivery delivery = new Delivery();
			delivery.setChecked(true);
			delivery.setDescription("AAA" + i);
			delivery.setName("Option" + i);
			delivery.setPriceSize((double)(1+generateInteger(10) * i));
			delivery.setPriceWeight((double)(1+generateInteger(10) * i));
			result.add(delivery);
		}	
		return result;
	}
	
	private static List<Paint> generatePaints(){
		List<Paint> result = new ArrayList<>();
		for(int i = 0; i < generateInteger(5) ;i++){
			Paint paint = new Paint();
			paint.setChecked(true);
			paint.setName("Option" + i);
			paint.setPrice((double)(1+generateInteger(10) * i));
			paint.setQuantity(generateInteger(5));

			result.add(paint);
		}
		return result;
	}
	
	private static Integer generateInteger(int i){
		return 1 + (int)(Math.random()*i);
	}
	
	public static void main(String args[]){
		try {
			ExcelCartOrder.createExcelFile(generateFullCart());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
