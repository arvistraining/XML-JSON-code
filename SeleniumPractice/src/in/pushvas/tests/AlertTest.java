package in.pushvas.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AlertTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		BrowserLaunch.launchFireFox();
		Thread.sleep(1500);
		BrowserLaunch.driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		
		Alert alertObj = BrowserLaunch.driver.switchTo().alert();
		
		String text = alertObj.getText();
		
		System.out.println("text : "+text);
		
		Thread.sleep(200);
		alertObj.accept();
			
			
		
	}

}
