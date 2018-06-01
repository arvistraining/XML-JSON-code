package in.pushvas.tests;

import java.io.File;

public class FileListFromFolder {

	 public static void main(String a[]){
	        File file = new File("C:\\Users\\IBM_ADMIN\\Downloads\\Scenario 2 results\\");
	        String[] fileList = file.list();
	        for(String name:fileList){
	            System.out.println(name.replace(".xlsx", ""));
	        }
	    }

}
