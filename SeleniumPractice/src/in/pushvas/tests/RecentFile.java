package in.pushvas.tests;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class RecentFile {

	public static String getLastModifiedFile(String path) {
		File fi = new File(path);
	    File[] files = fi.listFiles();
	   if (files.length == 0) return null;
	    Arrays.sort(files, new Comparator<File>() {
	        public int compare(File o1, File o2) {
	            return new Long(o2.lastModified()).compareTo(o1.lastModified()); 
	        }});
	    return files[0].getName();
	}
	
	
	public static void main(String[] args) {
		String str = getLastModifiedFile("C:\\Users\\IBM_ADMIN\\Downloads");
		System.out.println(str);
		
		
	}

}
