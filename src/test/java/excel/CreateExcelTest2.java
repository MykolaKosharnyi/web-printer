package excel;

import java.io.IOException;

import com.mykoshar.shop.api.beans.OrderExcel2;

import resources.CartOrderGenerator;

public class CreateExcelTest2 {
		
	public static void main(String args[]){
		try {
			OrderExcel2.createExcelFile(CartOrderGenerator.generate());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
