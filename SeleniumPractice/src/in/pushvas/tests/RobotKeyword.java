package in.pushvas.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotKeyword {

	static WebDriver driver = null;
	
	static String geckoDriverPath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib\\geckodriver.exe";
	static String chromeDriverPath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib\\chromedriver.exe";
	static String ieDriverPath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib\\3.1.0\\IEDriverServer_Win32_3.1.0\\IEDriverServer.exe";
	
	static String url = "https://www.google.co.in/";
	
	static String aletURL = "http://toolsqa.com/handling-alerts-using-selenium-webdriver/";
	static String aletURL1 = "http://selenium-webapp.pushvastech.in";
	static String aletURL3 ="file:///C:/Users/IBM_ADMIN/Desktop/Selenium%20App/index.html";
	
	static String aletURL2 = "http://jqueryui.com/droppable/";
	
	public static void launchChrome() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.navigate().to(aletURL1);
	}
	
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		launchChrome();
		Thread.sleep(3500);
		
		Robot robObj = new Robot();
		robObj.keyPress(KeyEvent.VK_PAGE_DOWN);
		robObj.keyPress(KeyEvent.VK_PAGE_DOWN);
	}

}
