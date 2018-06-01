package in.csr.hcm.test;

import java.util.HashMap;

public class ClassStatusSet {

	
	
	private static HashMap<String, String> classFinalResults_HM = new HashMap<String, String>();
	
	public static void setClassResults(String className, String status){
		
		String classStatus = "PASS";
		
		try {
			classStatus = classFinalResults_HM.get(className);
			if(classStatus == null){
				classStatus = "PASS";
				classFinalResults_HM.put(className, status);
			}
		} catch (Exception e) {
		}
	
		if(classFinalResults_HM.get(className).equalsIgnoreCase("PASS")){
			classFinalResults_HM.put(className, status);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		setClassResults("ABC", "FAIL");
		
		setClassResults("ABC123", "PASS");
		
		setClassResults("ABC456", "PASS");
		
		setClassResults("ABC", "PASS");
		
		setClassResults("ABC", "PASS");
		
		
		System.out.println(""+classFinalResults_HM.get("ABC"));

	}

}
