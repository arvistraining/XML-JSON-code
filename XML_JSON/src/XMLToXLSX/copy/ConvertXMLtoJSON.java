package XMLToXLSX.copy;

import org.json.JSONObject;
import org.json.JSONException;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class ConvertXMLtoJSON{  
     public static void main(String[] args) throws Exception {  
       String fileName = "LTD_Request.xml";
       String st = "";
       
       ArrayList<String> farword = new ArrayList<String>();
       String reverse = "";
       BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				sCurrentLine = sCurrentLine.trim();
				while(true){
					if(sCurrentLine.startsWith("-")){
						sCurrentLine = sCurrentLine.substring(1, sCurrentLine.length());
					}else break;
				}
				
				
				if(sCurrentLine.trim().startsWith("<") && (!sCurrentLine.contains("</"))){
					sCurrentLine = "\""+sCurrentLine.replaceAll("<", "").replaceAll(">", "")+"\" : { ";
					//System.out.println(sCurrentLine);
				}
				
				
				else if(sCurrentLine.startsWith("</")){
					sCurrentLine = "\""+sCurrentLine.replaceAll("</", "").replaceAll(">", "") +"\" } ";
				}
				else if(sCurrentLine.trim().startsWith("<") && sCurrentLine.contains("</")){
					int start = sCurrentLine.indexOf("<");
					int end = sCurrentLine.indexOf(">");
					//System.out.println("start : "+start+"   end : "+end);
					
					String tagName = sCurrentLine.substring(start+1, end);
					sCurrentLine = sCurrentLine.replaceAll("<", "").replaceAll(">", "");
					String value = sCurrentLine.replaceAll(tagName, "");
					//System.out.println("value : "+value);
					value = value.substring(0, value.length()-1);
					value = value.replaceAll("@", "");
					try  
					  {  
					    Double.parseDouble(value);  
					  }  
					  catch(NumberFormatException nfe)  
					  {  
						  value = "\""+value+"\"";
					  }  
				
					sCurrentLine = "\""+tagName+"\""+":  "+value;
				}
				
				
				//System.out.println(sCurrentLine);
				farword.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
       
		//Comma  set for values.
		for (int i = 0; i < farword.size(); i++) {
			String line1 = farword.get(i);
			String line2 = "";
			if((i+1) != farword.size()) line2 = farword.get(i+1);
			if(line1.contains("\":  ") && line2.contains("\":  ")) farword.set(i, line1+",");
			if(line1.contains("\":  ") && line2.contains("\" : {")) farword.set(i, line1+",");
		}
		
		System.out.println("{");
		for (int i = 0; i < farword.size(); i++) {
			System.out.println(farword.get(i));
		}
		System.out.println("}");		
   }  
}