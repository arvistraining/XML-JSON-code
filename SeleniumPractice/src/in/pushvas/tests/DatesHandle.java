package in.pushvas.tests;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DatesHandle {

	 private static final String DATE_FORMAT = "dd/mm/yyyy";
	 private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	 private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
	    
	 public static void addNoOfdaysToDateMMddyy(int noOfdays){
		 SimpleDateFormat sdf = new SimpleDateFormat("MMddyy");
		 Calendar c = Calendar.getInstance();
		 c.setTime(new Date()); // Now use today date.
		 c.add(Calendar.DATE, noOfdays); // Adding 5 days
		 String output = sdf.format(c.getTime());
		 System.out.println(output);
    }
	 public static void addNoOfdaysToDateMMddyyyy(int noOfdays){
		 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 Calendar c = Calendar.getInstance();
		 c.setTime(new Date()); // Now use today date.
		 c.add(Calendar.DATE, noOfdays); // Adding 5 days
		 String output = sdf.format(c.getTime());
		 System.out.println(output);
    }
	
	public static String getTodayDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todaydate = "";
		todaydate = ""+dateFormat.format(date);
		return todaydate; 
	}
	
	public static boolean isFileExists(String folderPath, String fileName){
		boolean status = false;
		File file = new File(folderPath);
	    File[] files = file.listFiles();
	    for(File f: files){
	    	if(fileName.trim().equalsIgnoreCase(f.getName())){
	    		status = true;
	    		break;
	    	}
	    }
	    return status;
	}
	
	public static void firstdayInNextMonth(String date){
		String month = date.substring(0,2);
		String day = date.substring(2,4);
		String year = date.substring(4,date.length());
		
		System.out.println("month : "+month);
		System.out.println("day : "+day);
		System.out.println("year : "+year);
		
		if(month.equalsIgnoreCase("12")){
			year = ""+(Integer.parseInt(year) + 1);
		}
		month = ""+(Integer.parseInt(month) + 1);
		if(month.length() ==1) month = "0"+month;
		String returndate = month+"01"+year;
		//System.out.println("returndate : "+returndate);
	}
	
	
	public static String isDateGreaterOrLesser(String inputDate){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todaydate = "";
		todaydate = ""+dateFormat.format(date);
		System.out.println("todaydate : "+todaydate);
		
		
		String status = "";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			if(sdf.parse(todaydate).before(sdf.parse(inputDate))){
				status = "Higher";
			}else{
				status = "Lesser";
			}
		} catch (ParseException e) {
		}
		return status;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(isDateGreaterOrLesser("05/22/2018"));
System.exit(0);		
		firstdayInNextMonth("052218");
		
		addNoOfdaysToDateMMddyyyy(15);
		
		System.out.println(isFileExists("C:\\Users\\IBM_ADMIN\\Downloads", "10340151.pdf"));
		
		
		
	}

}
