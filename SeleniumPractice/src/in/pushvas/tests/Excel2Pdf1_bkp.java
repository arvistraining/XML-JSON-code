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

public class Excel2Pdf1_bkp {

	
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

    //We will create output PDF document objects at this point
    Document iText_xls_2_pdf = new Document();
    PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("Excel2PDF_Output_"+System.currentTimeMillis()+".pdf"));
    iText_xls_2_pdf.open();
    //we have two columns in the Excel sheet, so we create a PDF table with two columns
   
    
    new ArrayList<String>();
    new ArrayList<String>();
    new ArrayList<String>();
    
    new HashMap<String, ArrayList<String>>();
    
    ExcelHandle.setExcelFile("C:\\Users\\IBM_ADMIN\\Downloads\\MCR_Filling 4QD_Report.xlsx");
    ExcelHandle.setWorkSheet(0);
    
    int rowCount = ExcelHandle.getRowCount();
    int colCount = ExcelHandle.getColumnCountMax();
    System.out.println("rowCount : "+rowCount);
    System.out.println("colCount : "+colCount);
    
   /* for (int i = 0; i < rowCount; i++) {
    	rowData_AL = new ArrayList<String>();
		for (int j = 0; j < colCount; j++) {
			rowData_AL.add(ExcelHandle.getCellValue(j, i));
		}
		keyVal.put(""+i, rowData_AL);
	}*/
    
    //Note: There are ways to make this dynamic in nature, if you want to.
    PdfPTable my_table = new PdfPTable(20);
    
    for (int i = 0; i <= rowCount; i++) {
    	new ArrayList<String>();
    	
    	if(i == 0) my_table.addCell(getNormalCell("Row", "greek", 10, "Blue"));
    	else my_table.addCell(getNormalCell(""+i, "greek", 10, "Red"));
		for (int j = 0; j <= colCount; j++) {
		
			String text = ExcelHandle.getCellValue(j, i);
			String color = "black";
			if(i == 0) color = "Blue";
			if(text.equalsIgnoreCase("-0"))text = " ";
			my_table.addCell(getNormalCell(text, "greek", 10, color));
		}
		my_table.completeRow();
		//keyVal.put(""+i, rowData_AL);
	}
    
  
  /*  
    for (int i = 0; i < rowCount; i++) {
    	ArrayList<String> data = new ArrayList<String>();
    	data = keyVal.get(""+i);
    	
    	for (int j = 0; j < data.size(); j++) {
    		//table_cell=new PdfPCell(new Phrase(data.get(j)));
    		String color = "green";
    		if(j%2 == 0) color = "red";
    		 my_table.addCell(getNormalCell(data.get(j), "greek", 10, color));
    		 
		}
    	
	}*/
    
    //Loop through rows.
   /* while(rowIterator.hasNext()) {
            Row row = rowIterator.next(); 
            Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()) {
                            Cell cell = cellIterator.next(); //Fetch CELL
                            switch(cell.getCellType()) { //Identify CELL type
                                    //you need to add more code here based on
                                    //your requirement / transformations
                            case Cell.CELL_TYPE_STRING:
                                    //Push the data from Excel to PDF Cell
                                     table_cell=new PdfPCell(new Phrase(cell.getStringCellValue()));
                                     //feel free to move the code below to suit to your needs
                                     my_table.addCell(table_cell);
                                    break;
                            }
                            //next line
                    }
    
    }*/
    //Finally add the table to PDF document
    iText_xls_2_pdf.add(my_table);                       
    iText_xls_2_pdf.close();                
    
    System.out.println("Dome");
    
	}
}
