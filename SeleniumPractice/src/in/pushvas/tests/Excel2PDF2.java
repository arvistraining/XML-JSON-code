package in.pushvas.tests;

import java.awt.AWTException;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.qoppa.office.ExcelConvertOptions;
import com.qoppa.office.ExcelDocument;
import com.qoppa.office.OfficeException;
import com.qoppa.pdf.PDFException;

public class Excel2PDF2 {

	public static void main(String[] args) throws InterruptedException, AWTException, DocumentException, IOException, OfficeException, PDFException {
		
		
	
	
	// Load the document
	ExcelDocument excelDoc = new ExcelDocument("C:\\Users\\IBM_ADMIN\\Desktop\\MF_Datasheet.xlsx", new ExcelConvertOptions());
	 
	// Save the document as a PDF file
	excelDoc.saveAsPDF("output.pdf");
	System.out.println("Done");
	
	}
}
