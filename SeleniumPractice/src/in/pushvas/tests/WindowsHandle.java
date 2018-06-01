package in.pushvas.tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandle {

	
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
	
	
	public static void main(String[] args) throws InterruptedException {
		launchChrome();
		Thread.sleep(3500);
		
		String windowHandle = driver.getWindowHandle();
		System.out.println("windowHandle : "+windowHandle);
		
		WebElement windowLink = driver.findElement(By.xpath("//a[@href='demo_iframe.html']"));
		windowLink.click();
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		String window2 = (String) windowHandles.toArray()[1];
		
		Iterator iter = windowHandles.iterator();
		int count = 0;
		while (iter.hasNext()) {
			String str = ""+iter.next();
		    System.out.println(count+" : "+str);
		    count = count + 1;
		}
		
		driver.switchTo().window(window2);
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		
		firstName.sendKeys("Suresh");
		lastName.sendKeys("Chirra");
		
		WebElement window2Link = driver.findElement(By.xpath("//a[@href='http://pushvastech.in/']"));
		window2Link.click();
		
		Set<String> windowHandles_1 = driver.getWindowHandles();
		
		
		System.out.println("Windows : "+windowHandles_1);
	}

}
