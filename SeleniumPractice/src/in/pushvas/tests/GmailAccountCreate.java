package in.pushvas.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GmailAccountCreate {

	public static void main(String[] args) {
		
		try {
			String url = "https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default";
			String basePath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib";
			
			String geckoDriverPath = basePath+"\\geckodriver.exe";
			String chromeDriverPath = basePath+"\\chromedriver.exe";
			String ieDriverPath = basePath+"\\3.1.0\\IEDriverServer_Win32_3.1.0\\IEDriverServer.exe";
			
					
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			WebDriver driver = new ChromeDriver();
			
						
		
			driver.manage().deleteAllCookies();
			driver.navigate().to(url);
			driver.manage().window().maximize();
		    
		    driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Suresh");//First name
		    driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Reddy");//Last name
		    driver.findElement(By.xpath("//input[@id='GmailAddress']")).sendKeys("sleniumsuiteCSR1900");// gmail
		    driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("SleniumSuiteCSR_1900");//Password
		    driver.findElement(By.xpath("//input[@id='PasswdAgain']")).sendKeys("SleniumSuiteCSR_1900");//confirm your pwd
		    
		    
		    driver.findElement(By.xpath("//div[@role='listbox']")).click();//Month
		    driver.findElement(By.xpath("//div[@id=':1']")).click();//Month
		    
		    driver.findElement(By.xpath("//input[@id='BirthDay']")).sendKeys("07");//Day
		    driver.findElement(By.xpath("//input[@id='BirthYear']")).sendKeys("1987");//Day
		    
		    driver.findElement(By.xpath("//div[@title='Gender']")).click();//Gender
		    driver.findElement(By.xpath("//div[@id=':e']")).click();//Gender
		    
		   
		 System.exit(0);   
		    WebElement element = driver.findElement(By.xpath("//input[@id='submitbutton' and @value='Next step']"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		    Thread.sleep(500); 
		    
		    driver.findElement(By.xpath("//input[@id='submitbutton' and @value='Next step']")).click();//Next step
		    System.out.println("Next step clicked");
		    
		    for (int i = 0; i < 5; i++) {
		    	driver.findElement(By.xpath("//img[@class='tos-scroll-button-icon']")).click();//To click down arrow on pop up
			}
		    Thread.sleep(3000);
		    
		    driver.findElement(By.id("iagreebutton")).click();//I agree
		    
		    driver.findElement(By.xpath("//input[@value='Continue to Gmail']")).click();//Continue to gmail
		    System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
