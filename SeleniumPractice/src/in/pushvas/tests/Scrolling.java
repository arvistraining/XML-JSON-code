package in.pushvas.tests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Scrolling {

	static WebDriver driver = null;
	
	static String geckoDriverPath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib\\geckodriver.exe";
	static String chromeDriverPath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib\\chromedriver.exe";
	static String ieDriverPath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib\\3.1.0\\IEDriverServer_Win32_3.1.0\\IEDriverServer.exe";
	
	static String url = "https://www.google.co.in/";
	
	static String aletURL = "http://toolsqa.com/handling-alerts-using-selenium-webdriver/";
	static String aletURL1 = "http://selenium-webapp.pushvastech.in";
	
	static String aletURL2 = "http://jqueryui.com/droppable/";
	
	public static void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
		
	}
	
	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	public static void launchChrome() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.navigate().to(aletURL2);
	}
	
	public static void main(String[] args) throws InterruptedException {
		launchChrome();
		Thread.sleep(1000);
		scrollDown();
		Thread.sleep(2000);
		scrollUp();
	}

}
