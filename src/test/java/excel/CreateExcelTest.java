package excel;

import java.io.IOException;

import com.printmaster.nk.beans.OrderExcel;

import resources.CartOrderGenerator;

public class CreateExcelTest {
	
	public static void main(String args[]){
		try {
			OrderExcel.createExcelFile(CartOrderGenerator.generate());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
