package com.mykoshar.shop.api.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderPdf {
	public static final String PATH_PDF_ORDERS = "/home/nikolay/Documents";
	private static final String HEAD_ATTENTION_TEXT = "Увага! Оплата цього рахунку означає погодження "
			+ "з умовами поставки товарів. Повідомлення про"
			+ " оплату є обов'язковим, в іншому випадку не гарантується наявність товарів на складі. Товар"
			+ "відпускається за фактом надходження коштів на п/р Постачальника, самовивозом, за наявності";
	
	/** The path to the font. */
    public static final String FONT_ARIAL
    = PATH_PDF_ORDERS + "/arial.ttf";
	
	private static double priceForOneDollar;
	
	public static double getPriceForOneDollar() {
		return priceForOneDollar;
	}

	public static void setPriceForOneDollar(double priceForOneDollarOut) {
		priceForOneDollar = priceForOneDollarOut;
	}
	/*
	 * TODO for loading in future properties from bundle
	 *  https://ru.stackoverflow.com/questions/682937/%D0%9F%D1%80%D0%BE%D0%B1%D0%BB%D0%B5%D0%BC%D1%8B-%D1%81-%D0%BA%D0%BE%D0%B4%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%BE%D0%B9-%D0%BF%D1%80%D0%B8-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B8-pdf-%D1%84%D0%B0%D0%B9%D0%BB%D0%B0-%D1%81-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC-itext
	 *
	 * */
	public static Document createPdfFile(Cart cartOrder) throws FileNotFoundException, IOException, DocumentException {
		
		log.info("Start create pdf file for user: id = " + cartOrder.getIdUser() + ", time creation = " + cartOrder.getDateCreation() );

		String fileName = createFileTitle(cartOrder);
		
		Document document = new Document();
		PdfWriter writer =PdfWriter.getInstance(document, 
				new FileOutputStream(PATH_PDF_ORDERS + File.separator + cartOrder.getIdUser() + File.separator + fileName));
		 
		document.open();
		Font headerFont = FontFactory.getFont(FONT_ARIAL, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 8); 

		Paragraph header = new Paragraph(HEAD_ATTENTION_TEXT, headerFont);
		header.setAlignment(Element.ALIGN_MIDDLE);
		document.add(header);
		
		Phrase hello = new Phrase("Hello World");
		PdfContentByte canvas = writer.getDirectContentUnder();
		ColumnText.showTextAligned(
		canvas, Element.ALIGN_CENTER, hello, 36, 788, 0);
		
//		document.add(Chunk.NEWLINE);
		
//		BaseFont helvetica = BaseFont.createFont(FONT_ARIAL, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//		Font font2 = new Font(helvetica, 10, Font.NORMAL);
//		Chunk chunk2 = new Chunk("Привет, бобер", font2);
//		document.add(chunk2);
//		
//		Font f = new Font();
//        f.setStyle(Font.BOLD);
//        f.setSize(8);
//        document.add(new Paragraph("This is my paragraph 3", f));
        
              
        Paragraph p1 = new Paragraph("Заявление", headerFont);  
        document.add(p1);
        
		document.close();
	
		log.info(fileName + " written successfully");

		return document;
	}

	private static String createFileTitle(Cart cartOrder){
		String fileName = "Order_{id_order}_{time_ordering}.pdf";
		
		if ( fileName.contains("{id_order}") ){
			//TODO need to take from database
			fileName = fileName.replaceAll("\\{id_order\\}", String.valueOf(cartOrder.getId()) + ":");
		}		
		
		if ( fileName.contains("{time_ordering}") )
			fileName = fileName.replaceAll("\\{time_ordering\\}", new SimpleDateFormat("dd:MM:yyyy_HH:mm").format(cartOrder.getDateCreation()));
		
		return fileName;
	}
}
