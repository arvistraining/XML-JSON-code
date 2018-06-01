package in.csr.excel;



import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * Description : Functional Test Script
 *
 * 
 * 
 * @author SURESH CHIRRA
 * 
 */

public class ExcelHandle {

	/**
	 * 
	 * Script Name : <b>ExcelHandle</b> Generated : <b>Jan 1, 2018 8:00:26
	 * 
	 * AM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 
	 * 6.1 Build 7601 (S)
	 *
	 * 
	 * 
	 * @since 2018/01/01
	 * 
	 * @author SURESH CHIRRA
	 * 
	 */

	static FileInputStream fis = null;

	static Workbook fis_workbook;

	static Sheet fis_worksheet;

	static String excelFilePath;

	static String excelSheetName;

	public static void setExcelFile(String fileName) {

		try {

			fis = new FileInputStream(new File(fileName));

			excelFilePath = fileName;

		} catch (FileNotFoundException e) {

			System.err.println("Unable to find the Excel file in path : " + fileName);

		}

	}

	public static void setWorkSheet(String sheetName) {

		if (excelFilePath.trim().endsWith(".XLS") || excelFilePath.trim().endsWith(".xls")) {

			try {

				fis_workbook = new HSSFWorkbook(fis);

			} catch (IOException e) {

				// System.err.println("Unable to find the workbook in Excel
				// file. : " + excelFilePath);

			}

		}

		if (excelFilePath.trim().endsWith(".XLSX") || excelFilePath.trim().endsWith(".xlsx")) {

			try {

				fis_workbook = new XSSFWorkbook(fis);

			} catch (IOException e) {

				// System.err.println("Unable to find the workbook in Excel
				// file. : " + excelFilePath);

			}

		}

		try {

			fis_worksheet = fis_workbook.getSheet(sheetName);

			excelSheetName = sheetName;

		} catch (Exception e) {

			System.err.println("Uanble to find the Sheet name '" + sheetName + "'in Excel file : " + excelFilePath);

		}

	}

	public static int getSheetCount() {

		int noOfSheet = 0;

		try {

			fis_workbook = new XSSFWorkbook(fis);

		} catch (IOException e) {

		}

		try {

			noOfSheet = fis_workbook.getNumberOfSheets();

		} catch (Exception e) {

		}

		return noOfSheet;

	}

	public static String getSheetName(int sheetIndex) {

		String sheetName = "";

		try {

			fis_workbook = new XSSFWorkbook(fis);

		} catch (IOException e1) {

		}

		try {

			sheetName = fis_workbook.getSheetName(sheetIndex);

		} catch (Exception e) {

		}

		return sheetName;

	}

	public static void setWorkSheet(int sheetNumber) {

		if (excelFilePath.trim().endsWith(".XLS") || excelFilePath.trim().endsWith(".xls")) {

			try {

				fis_workbook = new HSSFWorkbook(fis);

			} catch (IOException e) {

				// System.err.println("Unable to find the workbook in Excel
				// file. : " + excelFilePath);

			}

		}

		if (excelFilePath.trim().endsWith(".XLSX") || excelFilePath.trim().endsWith(".xlsx")) {

			try {

				fis_workbook = new XSSFWorkbook(fis);

			} catch (IOException e) {

				// System.err.println("Unable to find the workbook in Excel
				// file. : " + excelFilePath);

			}

		}

		try {

			fis_worksheet = fis_workbook.getSheetAt(sheetNumber);

			excelSheetName = fis_workbook.getSheetName(sheetNumber);

		} catch (Exception e) {

			System.err.println(

					"Uanble to find the Sheet at position '" + sheetNumber + "'in Excel file : " + excelFilePath);

		}

	}

	public static int getRowCount() {

		int numberOfRows = -1;

		try {

			numberOfRows = fis_worksheet.getLastRowNum();

		} catch (Exception e) {

		}

		return numberOfRows;

	}

	public static int getColumnCount(int rowNumber) {

		int numberOfColumns = -1;

		try {

			numberOfColumns = fis_worksheet.getRow(rowNumber).getLastCellNum();

		} catch (Exception e) {

		}

		return numberOfColumns;

	}

	public static int getColumnCount() {

		int numberOfColumns = -1;

		try {

			numberOfColumns = fis_worksheet.getRow(0).getLastCellNum();

		} catch (Exception e) {

		}

		return numberOfColumns;

	}

	public static int getColumnCountMax() {

		int numberOfRows = getRowCount();

		int numberOfColumns = 0;

		for (int i = 0; i <= numberOfRows; i++) {

			int columnsCount = getColumnCount(i);

			if (columnsCount >= numberOfColumns)

				numberOfColumns = columnsCount;

		}

		return numberOfColumns;

	}

	public static String getCellValue(int colNumber, int rowNumber) {

		Cell fis_cell = null;

		String fis_cellValue = "-0";

		try {

			fis_cell = fis_worksheet.getRow(rowNumber).getCell(colNumber);
		
			try {

				try {

					fis_cellValue = fis_cell.getStringCellValue();

				} catch (Exception e) {

					if (fis_cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

						switch (fis_cell.getCachedFormulaResultType()) {

						case Cell.CELL_TYPE_NUMERIC:

							fis_cellValue = "" + fis_cell.getNumericCellValue();

							break;

						case Cell.CELL_TYPE_STRING:

							fis_cellValue = "" + fis_cell.getRichStringCellValue();

							break;

						}

					} else if (fis_cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

						fis_cellValue = "" + fis_cell.getNumericCellValue();

					}

				}

			} catch (Exception e) {

				fis_cellValue = "-0";

			}

			if (fis_cellValue.endsWith(".0"))

				fis_cellValue = fis_cellValue.replace(".0", "").trim();

		} catch (Exception e) {

			// System.err.println("Uable to find the data in Column Nmber :

			// "+colNumber+" & Row Number : "+rowNumber);

		}

		return fis_cellValue;

	}

	public static String getCellValue(String colAlphabit, int rowNumber) {

		int colNumber = toNumber(colAlphabit.toUpperCase()) - 1;

		Cell fis_cell = null;

		String fis_cellValue = "-0";

		try {

			fis_cell = fis_worksheet.getRow(rowNumber).getCell(colNumber);

			try {

				try {

					fis_cellValue = fis_cell.getStringCellValue();

				} catch (Exception e) {

					if (fis_cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

						switch (fis_cell.getCachedFormulaResultType()) {

						case Cell.CELL_TYPE_NUMERIC:

							fis_cellValue = "" + fis_cell.getNumericCellValue();

							break;

						case Cell.CELL_TYPE_STRING:

							fis_cellValue = "" + fis_cell.getRichStringCellValue();

							break;

						}

					} else if (fis_cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

						fis_cellValue = "" + fis_cell.getNumericCellValue();

					}

				}

			} catch (Exception e) {

				fis_cellValue = "-0";

			}

			if (fis_cellValue.endsWith(".0"))

				fis_cellValue = fis_cellValue.replace(".0", "").trim();

		} catch (Exception e) {

			// System.err.println("Uable to find the data in Column Nmber :

			// "+colNumber+" & Row Number : "+rowNumber);

		}

		return fis_cellValue;

	}

	public static int getRowNumber(String searchText) {

		searchText = searchText.trim();

		int numberOfRows = getRowCount();

		int numberOfColumns = 0;

		for (int i = 0; i <= numberOfRows; i++) {

			int columnsCount = getColumnCount(i);

			if (columnsCount >= numberOfColumns)

				numberOfColumns = columnsCount;

		}

		String cellText = "";

		for (int i = 0; i <= numberOfRows; i++) {

			for (int j = 0; j < numberOfColumns; j++) {

				cellText = getCellValue(j, i).trim();

				if (cellText.equalsIgnoreCase(searchText)) {

					return i;

				}

			}

		}

		return -0;

	}

	public static int getColumnNumber(String searchText) {

		searchText = searchText.trim();

		int numberOfRows = getRowCount();

		int numberOfColumns = 0;

		for (int i = 0; i <= numberOfRows; i++) {

			int columnsCount = getColumnCount(i);

			if (columnsCount >= numberOfColumns)

				numberOfColumns = columnsCount;

		}

		String cellText = "";

		for (int i = 0; i <= numberOfRows; i++) {

			for (int j = 0; j < numberOfColumns; j++) {

				cellText = getCellValue(j, i).trim();

				// System.out.println("cellText : "+cellText);

				if (cellText.equalsIgnoreCase(searchText)) {

					return j;

				}

			}

		}

		return -0;

	}

	public static boolean isTextExists(String searchText) {

		searchText = searchText.trim();

		int numberOfRows = getRowCount();

		int numberOfColumns = 0;

		for (int i = 0; i <= numberOfRows; i++) {

			int columnsCount = getColumnCount(i);

			if (columnsCount >= numberOfColumns)

				numberOfColumns = columnsCount;

		}

		String cellText = "";

		for (int i = 0; i <= numberOfRows; i++) {

			for (int j = 0; j < numberOfColumns; j++) {

				cellText = getCellValue(j, i).trim();

				// System.out.println("cellText : "+cellText);

				if (cellText.equalsIgnoreCase(searchText)) {

					return true;

				}

			}

		}

		return false;

	}

	public static int toNumber(String name) {

		int number = 0;

		for (int i = 0; i < name.length(); i++) {

			number = number * 26 + (name.charAt(i) - ('A' - 1));

		}

		return number;

	}

	public static void closeExcel() {

		try {

			fis.close();

		} catch (IOException e) {

		}

	}

	public static void setDataIntoExcel(String outputFileName, String sheetName, int columnNumber, int rowNumber,

			String writeText) throws IOException {

		FileInputStream inputStream = null;

		Workbook workbook = null;

		try {

			inputStream = new FileInputStream(new File(outputFileName));

			workbook = WorkbookFactory.create(inputStream);

		} catch (Exception e) {

			System.err.println("Unable to find the Excel file in path : " + outputFileName);

			System.exit(0);

		}

		Sheet sheet = null;

		try {

			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {

			System.err.println("Unable to find the sheet '" + sheetName + "' in Excel file '" + outputFileName + "'");

			System.exit(0);

		}

		int totalRowCount = sheet.getLastRowNum();

		Cell cell = null;

		if (totalRowCount >= rowNumber)

			cell = sheet.getRow(rowNumber).createCell(columnNumber);

		else

			cell = sheet.createRow(rowNumber).createCell(columnNumber);

		cell.setCellValue(writeText); // Actual Value Set

		inputStream.close();

		FileOutputStream output_file = new FileOutputStream(new File(outputFileName));

		workbook.write(output_file);

		output_file.close();

		System.out.println("Done!");

	}

public static void main(String[] args){
	
}


}