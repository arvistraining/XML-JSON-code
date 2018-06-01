package in.pushvas.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTitleGet {

	static String basePath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib";
	static String chromeDriverPath = basePath+"\\chromedriver.exe";
	
	int test1(int a){
		return a;
	}
	
	String test1(int a){
		return "";
	}
	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("title : "+title);
		driver.close();
		
		
		


	}

}
