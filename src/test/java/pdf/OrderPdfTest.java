package pdf;

import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.printmaster.nk.beans.OrderPdf;

import resources.CartOrderGenerator;

public class OrderPdfTest {
	
	public static void main(String args[]){
		try {
			OrderPdf.createPdfFile(CartOrderGenerator.generate());
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
