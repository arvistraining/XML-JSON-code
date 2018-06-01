package in.pushvas.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserLaunch {
	
	static WebDriver driver = null;
	
	static String basePath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib";
	
	static String geckoDriverPath = basePath+"\\geckodriver.exe";
	static String chromeDriverPath = basePath+"\\chromedriver.exe";
	static String ieDriverPath = basePath+"\\3.1.0\\IEDriverServer_Win32_3.1.0\\IEDriverServer.exe";
	
	static String url = "https://www.google.co.in/";
	static String url2 = "http://jsonschema2pojo.org";
	
	static String aletURL = "http://toolsqa.com/handling-alerts-using-selenium-webdriver/";
	static String aletURL1 = "file:///C:/Users/IBM_ADMIN/Desktop/Selenium%20App/app.html";
	
	static String aletURL2 = "http://jqueryui.com/droppable/";
	
	public static void launchFireFox() {
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		System.out.println(geckoDriverPath);
		driver = new FirefoxDriver();
		driver.navigate().to(aletURL2);
	}
	
	public static void launchChrome() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.navigate().to(url2);
		driver.manage().window().maximize();
	}
	
	public static void launchIE() {
		System.setProperty("webdriver.ie.driver", ieDriverPath);
		driver = new InternetExplorerDriver();
		driver.navigate().to(url);
	}
	
	
	public static void enterSourceJSON() throws AWTException, InterruptedException{
		driver.findElement(By.xpath("//form[@id='form']/div/div/div/div[3]")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		
		//driver.findElement(By.xpath("//form[@id='form']/div/div/div/div/textarea")).sendKeys("123");
		
		driver.findElement(By.xpath("//input[@value='java']")).click(); //Java
		driver.findElement(By.xpath("//input[@value='json']")).click(); //JSON
		driver.findElement(By.xpath("//input[@value='none']")).click(); //None
		
		WebElement usePrimitiveTypes = driver.findElement(By.xpath("//input[@name='useprimitives']"));
		if(!usePrimitiveTypes.isSelected())
			usePrimitiveTypes.click();
		
		WebElement uselongintegers = driver.findElement(By.xpath("//input[@name='uselongintegers']"));
		if(!uselongintegers.isSelected())
			uselongintegers.click();
		
		WebElement includeaccessors = driver.findElement(By.xpath("//input[@name='includeaccessors']"));
		if(!includeaccessors.isSelected())
			includeaccessors.click();
		
		WebElement includeconstructors = driver.findElement(By.xpath("//input[@name='includeconstructors']"));
		if(!includeconstructors.isSelected())
			includeconstructors.click();
		
		WebElement includeadditionalproperties = driver.findElement(By.xpath("//input[@name='includeadditionalproperties']"));
		if(includeadditionalproperties.isSelected())
			includeadditionalproperties.click();
		
		WebElement submit = driver.findElement(By.xpath("//button[@class='btn submit']"));
		submit.click();
		Thread.sleep(1500);
		
		WebElement copyBtn = driver.findElement(By.xpath("//button[@id='copy-button']"));
		copyBtn.click();
		Thread.sleep(500);
		/*WebElement close = driver.findElement(By.xpath("//button[@class='close']"));
		close.click();
		Thread.sleep(1500);*/
		
		driver.navigate().to("https://www.rapidtables.com/tools/notepad.html");
		Thread.sleep(700);
		driver.findElement(By.xpath("//textarea[@id='area']")).click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1500);
		String value = driver.findElement(By.xpath("//textarea[@id='area']")).getAttribute("value");
		System.out.println("Value : "+value);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		//launchFireFox();
		launchChrome();
		enterSourceJSON();
		//launchIE();
	}

}
