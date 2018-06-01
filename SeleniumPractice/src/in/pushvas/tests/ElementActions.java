package in.pushvas.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {

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
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		
		firstName.sendKeys("Suresh");
		lastName.sendKeys("Chirra");
		
		System.out.println(driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value"));
		
		

		WebElement male = driver.findElement(By.xpath("//input[@value='male']"));
		WebElement female = driver.findElement(By.xpath("//input[@value='female']"));
		
		System.out.println("Is male selected? : "+male.isSelected());
		female.click();
		
		WebElement selenium = driver.findElement(By.xpath("//input[@value='selenium']"));
		WebElement qtp = driver.findElement(By.xpath("//input[@value='qtp']"));
		
		System.out.println("Is selenium selected? : "+selenium.isSelected());
		qtp.click();
		
		WebElement tools = driver.findElement(By.xpath("//select[@name='Tools']"));
		Select selObj = new Select(tools);
		selObj.selectByIndex(1);
		selObj.selectByValue("qtp");
		selObj.selectByVisibleText("IBM - RFT");

	}

}
