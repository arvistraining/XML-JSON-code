package in.csr.excel;

import java.util.ArrayList;
import java.util.HashMap;

public class Script {

	static int rowCount = 0;
	static int columnCount = 0;
	
	static HashMap<String, HashMap<String, String>> layoutData = null;
	static ArrayList<String> fieldNames = null;
	public static void getLayout(){
		fieldNames = new ArrayList<String>();
		HashMap<String, HashMap<String, String>> layoutData = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> rowData = new HashMap<String, String>();
		for (int i = 0; i < rowCount; i++) {
			String columnName = "";
			String columnValue = "";
			for (int j = 0; j < columnCount; j++) {
				columnName = ExcelHandle.getCellValue(j, 0);
				columnValue = ExcelHandle.getCellValue(j, (i+1));
				rowData.put(columnName.trim(), columnValue.trim());
				if(columnName.equalsIgnoreCase("Field Name")) fieldNames.add(columnValue);
			}
			layoutData.put(""+i, rowData);
			rowData = new HashMap<String, String>();
		}
		System.out.println(layoutData);
		System.out.println(fieldNames);
	}
	
	
	
	public static void main(String[] args) {
		ExcelHandle.setExcelFile("C:\\Users\\IBM_ADMIN\\Desktop\\TestData1.xlsx");
		ExcelHandle.setWorkSheet("Sheet1");
		
		rowCount = ExcelHandle.getRowCount();
		columnCount = ExcelHandle.getColumnCount();
		System.out.println("Column Count : "+rowCount);
		System.out.println("Row Count : "+columnCount);
		
		getLayout();
	}

}
