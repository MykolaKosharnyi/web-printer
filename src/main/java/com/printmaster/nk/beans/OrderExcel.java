package com.printmaster.nk.beans;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;

import com.printmaster.nk.model.entity.Option;

@Slf4j
public class OrderExcel {
	
	private static final String PATH_ROOT_PICTURES = "/var/www/localhost";
	public static final String PATH_EXCEL_ORDERS = "/var/www/localhost/products/excel_reports";
	private static double priceForOneDollar;
	
	public static double getPriceForOneDollar() {
		return priceForOneDollar;
	}

	public static void setPriceForOneDollar(double priceForOneDollarOut) {
		priceForOneDollar = priceForOneDollarOut;
	}

	public static File createExcelFile(Cart cartOrder) throws FileNotFoundException, IOException {
		
		log.info("Start create excel file for user: id = " + cartOrder.getIdUser() + ", time creation = " + cartOrder.getDateCreation() );

		Workbook workbook = new SXSSFWorkbook(100); 

		String fileName = "Order_{id_order}_{time_ordering}";
		
		if ( fileName.contains("{id_order}") ){
			//TODO need to take from database
			fileName = fileName.replaceAll("\\{id_order\\}", String.valueOf(cartOrder.getId()) + ":");
		}
			
		
		if ( fileName.contains("{time_ordering}") )
			fileName = fileName.replaceAll("\\{time_ordering\\}", new SimpleDateFormat("HH:mm_dd:MM:yyyy").format(cartOrder.getDateCreation()));			
		
		createInfoSheet(workbook, cartOrder);
		
		createSheetForProducts(workbook, cartOrder);

		
		File fileFolder = new File(PATH_EXCEL_ORDERS + File.separator + cartOrder.getIdUser());
		
		if ( !fileFolder.exists() )
			fileFolder.mkdirs();
		
		File file = new File(fileFolder + File.separator + fileName + ".xlsx");
		
		try (FileOutputStream out = new FileOutputStream(file)) {
			try {
				write(out, "1111", workbook);
				log.info("File " + fileName + " created in folder " + fileFolder.getName());
			} catch (IOException e) {
				log.warn("File " + fileName + " didn't create in folder " + fileFolder.getName(), e);
			}
		} catch (FileNotFoundException e) {
			log.warn("Document " + file.getAbsolutePath() + "doesn't found.", e);
		}

		((SXSSFWorkbook)workbook).dispose();

		log.info(fileFolder + File.separator+fileName+".xlsx written successfully");

		return file;
	}

	private static void createInfoSheet(Workbook workbook, Cart cartOrder) {
		Sheet sheet = workbook.createSheet("Общая информация");
		
		int rowNameIndex = 4;
		int cellIndex = 0;
		Row rowname = createRow(sheet, rowNameIndex);

		CellStyle aligmentCellStyle = aligmentStyle(workbook);
		CellStyle borderAndWrapStyle = borderAndWrapStyle(sheet);
		
		rowname = createRow(sheet, rowNameIndex++);
		createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Номер заказа:");
		createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(cartOrder.getId());
		
		cellIndex = 0;
		rowname = createRow(sheet, rowNameIndex++);
		createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Id пользователя:");
		createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(cartOrder.getIdUser());
		
		cellIndex = 0;
		rowname = createRow(sheet, rowNameIndex++);
		createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Время заказа:");
		createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(new SimpleDateFormat("HH:mm dd.MM.yyyy").format(cartOrder.getDateCreation()));
		
		cellIndex = 0;
		rowname = createRow(sheet, rowNameIndex++);
		createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Статус заказа:");
		createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(cartOrder.getStatus().toString());
		
		cellIndex = 0;
		rowname = createRow(sheet, rowNameIndex++);
		createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Оформлена как онлайн:");
		createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(cartOrder.isBuyOnline()? "Да":"Нет");
		
		cellIndex = 0;
		rowname = createRow(sheet, rowNameIndex++);
		createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Цена за 1 доллар:");
		createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(priceForOneDollar + " грн.");
		
		cellIndex = 0;
		rowname = createRow(sheet, rowNameIndex++);
		createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Общая сумма заказа:");
		createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(priceFormatter(cartOrder.getTotalCost()));
		
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);

	}
	
	private static void createSheetForProducts(Workbook workbook, Cart cartOrder) {
		int productSheetIndex = 1;
		for (Map.Entry<ProductCart, Integer> entry : cartOrder.getContents().entrySet()) {
			ProductCart product = entry.getKey();
			Sheet sheet = workbook.createSheet(productSheetIndex++ + ". " + product.getName());
			
			//create part of product information
			int rowNameIndex = 0;
			int cellIndex = 0;
			Row rowname = createRow(sheet, rowNameIndex);

			CellStyle aligmentCellStyle = aligmentStyle(workbook);
			
			createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Изображение");
			createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Название товара");
			createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Количество");
			createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Цена за единицу без опций");
			createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Цена за единицу с опциями");
			createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Цена за единицу с опциями умноженная на количество");
			
			for( int ii = 0; ii < cellIndex; ii++ )
				sheet.autoSizeColumn(ii);
			
			CellStyle borderAndWrapStyle = borderAndWrapStyle(sheet);
			
			cellIndex = 1;
			rowname = createRow(sheet, ++rowNameIndex);
			//insertImage(sheet, "/home/nikolay/Pictures/star.png");
			
			String pathToPicture = PATH_ROOT_PICTURES + File.separator + product.getPicturePath();
			log.info("Full pass to picture of product: " + pathToPicture);
			insertImage(sheet, pathToPicture);
			createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(product.getName());
			createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(entry.getValue());
			createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(priceFormatter(product.getPrice()));
			createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(priceFormatter(product.getPriceWithOptionAndDeivery()));
			createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(priceFormatter(product.getPriceWithOptionAndDeivery() * entry.getValue()));
			
			CellStyle descriptionTableCellStyle = descriptionTableCellStyle(workbook);
			
			//little info block
			log.info("Option size: " + product.getOptions().size() + " items.");
			for(Option option : product.getOptions()){
				log.info("Option: " + option);
			}
			
			if(checkOption(product.getOptions())){
				//for OPTION table
				rowNameIndex+=4;
				cellIndex = 0;
				rowname = createRow(sheet, rowNameIndex);
				createCell(rowname, cellIndex++, descriptionTableCellStyle).setCellValue("Опции");
				
				cellIndex = 0;			
				rowname = createRow(sheet, ++rowNameIndex);
				createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Название");
				createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Цена");			
							
				for(Option option : product.getOptions()){
					if(option.isChecked()){
						cellIndex = 0;
						rowname = createRow(sheet, ++rowNameIndex);
						createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(option.getName());
						createCell(rowname, cellIndex++, borderAndWrapStyle)
							.setCellValue("НДС".equals(option.getName()) ? String.valueOf(option.getPrice()):priceFormatter(option.getPrice()));
					}	
				}
			}			

			//for DELIVERY table
			if(checkDelivery(product.getDeliveries())){
				rowNameIndex+=4;
				cellIndex = 0;
				rowname = createRow(sheet, rowNameIndex);
				createCell(rowname, cellIndex++, descriptionTableCellStyle).setCellValue("Доставка");
				
				cellIndex = 0;			
				rowname = createRow(sheet, ++rowNameIndex);
				createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Название");
				createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Цена");			
							
				for(Delivery delivery : product.getDeliveries()){
					if(delivery.isChecked()){
						cellIndex = 0;
						rowname = createRow(sheet, ++rowNameIndex);
						createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(delivery.getName());
						createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(priceFormatter(delivery.getPriceSize() + delivery.getPriceWeight()));
					}
				}
			}
			
			//for Paint table
			if(checkPaint(product.getPaints())){
				rowNameIndex+=4;
				cellIndex = 0;
				rowname = createRow(sheet, rowNameIndex);
				createCell(rowname, cellIndex++, descriptionTableCellStyle).setCellValue("Краска");
				
				cellIndex = 0;			
				rowname = createRow(sheet, ++rowNameIndex);
				createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Название");
				createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Количество");	
				createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Цена за 1л");			
				createCell(rowname, cellIndex++, aligmentCellStyle).setCellValue("Всего");	
							
				for(Paint paint : product.getPaints()){
					if(paint.isChecked()){
						cellIndex = 0;
						rowname = createRow(sheet, ++rowNameIndex);
						createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(paint.getName());
						createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(paint.getQuantity());
						createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(priceFormatter(paint.getPrice()));
						createCell(rowname, cellIndex++, borderAndWrapStyle).setCellValue(priceFormatter(paint.getQuantity() * paint.getPrice()));	
					}					
				}
			}

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
		}
	}
	
	private static boolean checkOption(List<Option> options){
		if(options!=null && options.size()>0){
			for(Option option :options){
				if(option.isChecked()){
					return true;
				}	
			}
		}		
		return false;
	}
	
	private static boolean checkDelivery(List<Delivery> deliveries){
		if(deliveries!=null && deliveries.size()>0){
			for(Delivery delivery :deliveries){
				if(delivery.isChecked()){
					return true;
				}	
			}
		}		
		return false;
	}
	
	private static boolean checkPaint(List<Paint> paints){
		if(paints!=null && paints.size()>0){
			for(Paint paint :paints){
				if(paint.isChecked()){
					return true;
				}	
			}
		}		
		return false;
	}
	
	private static String priceFormatter(double price){
		StringBuilder result = new StringBuilder();
		result
		.append("$")
		.append(price)
		.append(" / ")
		.append(price * priceForOneDollar)
		.append(" грн.");
		return result.toString();
	}

	private static CellStyle aligmentStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();

		allCellBorder(style);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setWrapText(true);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
        
        XSSFFont font= (XSSFFont) workbook.createFont();
        font.setFontHeightInPoints((short)10);
        font.setFontName("Arial");
        font.setColor(IndexedColors.DARK_BLUE.getIndex());
        font.setBold(true);
        font.setItalic(false);
        
        style.setFont(font);
		return style;
	}

	private static CellStyle borderAndWrapStyle(Sheet sheet) {
		CellStyle style = getNewCellStyle(sheet);

		allCellBorder(style);
		style.setWrapText(true);
		//((XSSFCellStyle)style).setVerticalAlignment(VerticalAlignment.TOP);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		
		return style;
	}
	
	private static CellStyle descriptionTableCellStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		
		style.setWrapText(true);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		
		XSSFFont font= (XSSFFont) workbook.createFont();
        font.setFontHeightInPoints((short)14);
        font.setFontName("Arial");
        font.setColor(IndexedColors.BRIGHT_GREEN.getIndex());
        font.setBold(true);
        font.setItalic(true);
        style.setFont(font);
		
		return style;
	}

	private static CellStyle getNewCellStyle(Sheet sheet) {
		return sheet.getWorkbook().createCellStyle();
	}

	private static CellStyle allCellBorder(CellStyle style) {
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);

		return style;
	}

	public static void write(OutputStream out, String password, Workbook workbook) throws IOException { 
		if (StringUtils.isBlank(password)) { 
			workbook.write(out); 
		} 
		else { 
			POIFSFileSystem fs = new POIFSFileSystem(); 

			EncryptionInfo info = new EncryptionInfo(fs);
			Encryptor enc = info.getEncryptor(); 
			enc.confirmPassword(password); 

			ByteArrayOutputStream baos = null; 
			ByteArrayInputStream bais = null; 

			try { 
				baos = new ByteArrayOutputStream(); 
				workbook.write(baos); 
				bais = new ByteArrayInputStream(baos.toByteArray()); 

				OPCPackage opc = OPCPackage.open(bais); 
				OutputStream os = enc.getDataStream(fs);
				opc.save(os);
				
				opc.close(); 
				//os.close();
			} 
			catch (Exception e) { 
				log.warn("Error writing encrypted Excel document", ExceptionUtils.getStackTrace(e));
			} 
			finally { 
				IOUtils.closeQuietly(baos); 
				IOUtils.closeQuietly(bais); 
			} 

			fs.writeFilesystem(out); 
		} 
	} 

	private static Row createRow(Sheet sheet, int index) {
		return sheet.createRow(index);
	}

	private static Cell createCell(Row row, int index, CellStyle style) {
		if ( style == null )
			style = row.getSheet().getWorkbook().createCellStyle();

		Cell cell = row.createCell(index);
		cell.setCellStyle(style);

		return cell;
	}
	
	private static void insertImage(Sheet sheet, String pathToImage) {
		try {
			new AddDimensionedImage().addImageToSheet("A2", sheet, sheet.createDrawingPatriarch(),
			        new File(pathToImage).toURI().toURL(), 
			        30,
			        30,
			        AddDimensionedImage.EXPAND_ROW_AND_COLUMN);

		} catch(FileNotFoundException fnfEx) {
            log.warn("Caught an: " + fnfEx.getClass().getName());
            log.warn("Message: " + fnfEx.getMessage());
            log.warn("Stacktrace follows...........");
            log.warn(ExceptionUtils.getStackTrace(fnfEx));

        } catch(IOException ioEx) {
        	log.warn("Caught an: " + ioEx.getClass().getName());
        	log.warn("Message: " + ioEx.getMessage());
        	log.warn("Stacktrace follows...........");
        	log.warn(ExceptionUtils.getStackTrace(ioEx));
        }
	}
}
