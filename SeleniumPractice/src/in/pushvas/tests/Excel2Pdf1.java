package in.pushvas.tests;

import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Excel2Pdf1 {

	
	 public static PdfPCell getNormalCell(String string, String language, float size, String color)
	            throws DocumentException, IOException {
	        if(string != null && "".equals(string)){
	            return new PdfPCell();
	        }
	        Font f  = getFontForThisLanguage(language);
	        if(size < 0) {
	            f.setColor(BaseColor.RED);
	            size = -size;
	        }
	        
	        if(color.equalsIgnoreCase("Red")) {
	        	 f.setColor(BaseColor.RED);
	        }else if(color.equalsIgnoreCase("Green")) {
	        	f.setColor(BaseColor.GREEN);
	        }else if(color.equalsIgnoreCase("Blue")) {
		     	f.setColor(BaseColor.BLUE);
		     }
	        else if(color.equalsIgnoreCase("Orange")) {
		     	f.setColor(BaseColor.ORANGE);
		     }
	        else if(color.equalsIgnoreCase("Pink")) {
		     	f.setColor(BaseColor.PINK);
		     }else {
	        	f.setColor(BaseColor.BLACK);
	        }
	        f.setSize(size);
	        PdfPCell cell = new PdfPCell(new Phrase(string, f));
	        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	        return cell;
	    }
	    public static Font getFontForThisLanguage(String language) {
	        if ("czech".equals(language)) {
	            return FontFactory.getFont("czech", "Cp1250", true);
	        }
	        if ("greek".equals(language)) {
	            return FontFactory.getFont("greek", "Cp1253", true);
	        }
	        return FontFactory.getFont("Times", null, true);
	    }
	
	public static void main(String[] args) throws InterruptedException, AWTException, DocumentException, IOException {

		String basePath = "C:\\Users\\IBM_ADMIN\\Downloads\\Scenario 2 results\\";
		
		String fileName = "LETTER_SRP over 30_Report.xlsx";
		
    //We will create output PDF document objects at this point
    Document iText_xls_2_pdf = new Document();
    PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream(basePath+fileName.replace(".xlsx", "")+System.currentTimeMillis()+".pdf"));
    iText_xls_2_pdf.open();
    //we have two columns in the Excel sheet, so we create a PDF table with two columns
   
    
    new ArrayList<String>();
    new ArrayList<String>();
    new ArrayList<String>();
    
    new HashMap<String, ArrayList<String>>();
    
    ExcelHandle.setExcelFile(basePath+fileName);
    ExcelHandle.setWorkSheet(0);
    
    int rowCount = ExcelHandle.getRowCount();
    int colCount = ExcelHandle.getColumnCountMax();
    System.out.println("rowCount : "+rowCount);
    System.out.println("colCount : "+colCount);
    
    
    //Note: There are ways to make this dynamic in nature, if you want to.
    int noOfCrColumns = 0;
    if(colCount >= 16) noOfCrColumns = 15;
    else noOfCrColumns = colCount+1;
    
    PdfPTable my_table = new PdfPTable(noOfCrColumns);
    
    for (int i = 0; i <= rowCount; i++) {
    	new ArrayList<String>();
    	
    	if(i == 0) my_table.addCell(getNormalCell("Row No.", "greek", 10, "Blue"));
    	else my_table.addCell(getNormalCell(""+i, "greek", 10, "Pink"));
		for (int j = 0; j < colCount; j++) {
		
			String text = ExcelHandle.getCellValue(j, i);
			String color = "black";
			if(i == 0) color = "Blue";
			if(text.equalsIgnoreCase("-0"))text = " ";
			
			if(text.equalsIgnoreCase("Pass")) color = "Green";
			else if(text.equalsIgnoreCase("Fail")) color = "Red";
			else if(i != 0) color = "Black";
			
			my_table.addCell(getNormalCell(text, "greek", 10, color));
		}
		my_table.completeRow();
		//keyVal.put(""+i, rowData_AL);
	}
    
    
    //================
    
    for (int i = 0; i <= 5; i++) {
    	new ArrayList<String>();
    	
    	if(i == 0) my_table.addCell("");
    	else my_table.addCell("");
    	/*if(i == 5)	my_table.addCell(getNormalCell("@author : Suresh Chirra", "greek", 10, "Green"));
    	else my_table.completeRow();*/
		for (int j = 0; j <= colCount; j++) {
			my_table.addCell(" ");
			break;
		}
		if(i == 5 ) {
			my_table.addCell(getNormalCell("@Author : SURESH CHIRRA", "greek", 3, "Orange"));
			my_table.completeRow();
			break;
		}
    	my_table.completeRow();
	}
    //===============
    
    //Finally add the table to PDF document
    iText_xls_2_pdf.add(my_table);                       
    iText_xls_2_pdf.close();                
    
    System.out.println("Dome");
    
	}
}
