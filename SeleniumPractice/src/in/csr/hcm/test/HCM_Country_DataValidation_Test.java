package in.csr.hcm.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HCM_Country_DataValidation_Test {

	static WebDriver driver = null;
	static String basePath = "C:\\Users\\IBM_ADMIN\\Desktop\\Java_WorkSpace\\lib";
	static String chromeDriverPath = basePath+"\\chromedriver.exe";
	static String url = "https://fs-aufsn4x0epa.oracleoutsourcing.com/";
	
	
	public static void dynamicWaitFoeElement(String elementXpath){
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
	}
	
	public static void browserLaunch(){
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	public static void performLogin(){
		String userIdXpath = "//input[@id='userid']";
		dynamicWaitFoeElement(userIdXpath);
		
		WebElement userId = driver.findElement(By.xpath(userIdXpath));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		
		userId.sendKeys("hcm.user");
		password.sendKeys("Passw0rd3");
		signIn.click();
	}
	
	
	public static void clickOnNavigate(){
		
		String navigateIconXpath = "//img[@title='Navigator']";
		dynamicWaitFoeElement(navigateIconXpath);
		WebElement navigateIcon = driver.findElement(By.xpath(navigateIconXpath));
		
		navigateIcon.click();
	}
	
	public static void clickOnPersonManagement(){
	
		String personManagementXpath ="//a[@id='pt1:nv_itemNode_workforce_management_person_management']";
		dynamicWaitFoeElement(personManagementXpath);
		WebElement personManagement = driver.findElement(By.xpath(personManagementXpath));
		
		personManagement.click();
	
	}
	
	
	public static void clickOnSearChResultsname(){
		String SearChResultsnameXpath =  "(//table[@_afrit='1']//tbody//tr)[2]//td//a";
		dynamicWaitFoeElement(SearChResultsnameXpath);
		WebElement SearChResultsname = driver.findElement(By.xpath(SearChResultsnameXpath));
		
		SearChResultsname.click();
	}
	
	public static void clickOnTask(){
		String taskXpath =  "//img[@title='Tasks']";
		dynamicWaitFoeElement(taskXpath);
		WebElement task = driver.findElement(By.xpath(taskXpath));
		
		task.click();
	}
	
	public static void clickOnManagePerson(){
		String managePersonXpath =  "//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTRaT:0:RAtl15']";
		dynamicWaitFoeElement(managePersonXpath);
		WebElement managePerson = driver.findElement(By.xpath(managePersonXpath));
		
		managePerson.click();
	}
	
	static String line1 = "";
	public static void homeAddressEdit() throws InterruptedException{
		String homeAddress_editXpath = "//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:SP1:region1:0:addIter:0:editAddressDropDown::popEl']";
		dynamicWaitFoeElement(homeAddress_editXpath);
		WebElement homeAddress_edit = driver.findElement(By.xpath(homeAddress_editXpath));
		homeAddress_edit.click();
		
		
		String homeAddress_edit_correctXpath ="//tr[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:SP1:region1:0:addIter:0:correctMenuItem']//td[2]";
		dynamicWaitFoeElement(homeAddress_edit_correctXpath);
		WebElement homeAddress_edit_correct = driver.findElement(By.xpath(homeAddress_edit_correctXpath));
		homeAddress_edit_correct.click();
		
		String homeAddress_correctAddress_line1Xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:SP1:region1:0:Updat1:0:i1:0:inputText17::content']";
		dynamicWaitFoeElement(homeAddress_correctAddress_line1Xpath);
		WebElement homeAddress_correctAddress_line1 = driver.findElement(By.xpath(homeAddress_correctAddress_line1Xpath));
	
		line1 = homeAddress_correctAddress_line1.getAttribute("value");
		System.out.println("line1 : "+line1);
		homeAddress_correctAddress_line1.clear();
		homeAddress_correctAddress_line1.sendKeys("74 Wade Lane");
		
		String okXpath = "//button[@accesskey='K']";
		WebElement ok = driver.findElement(By.xpath(okXpath));
		ok.click();
		Thread.sleep(5000);
		String addressExitsTextXpath = "(//table[@class='xqu x1a'])[3]/tbody/tr/td[2]/span";
		WebElement addressExitsText = driver.findElement(By.xpath(addressExitsTextXpath));
				
		String addressText = addressExitsText.getText();
		System.out.println("addressText : "+addressText);
	}

	public static void selectCountry(String countryName) throws InterruptedException{
		
		String countryEditFieldXpath = "//input[@class='x25' and @size=30]";
		dynamicWaitFoeElement(countryEditFieldXpath);
		Thread.sleep(1000);
		WebElement countryEditField = driver.findElement(By.xpath(countryEditFieldXpath));
		System.out.println("countryName : "+countryName);
		countryEditField.sendKeys(countryName);
		
		String countrySearchXpath = "//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:SP1:region1:0:region1:0:countrylov::_afrLovInternalQueryId::search']";
		dynamicWaitFoeElement(countrySearchXpath);
		WebElement countrySearch = driver.findElement(By.xpath(countrySearchXpath));
		countrySearch.click();
		Thread.sleep(3500);
		
		String selectFilteredCountryXpath = "(//td[@class='xe7']//span[@class='x2jg'])";
		/*dynamicWaitFoeElement("(//td[@class='xe7']//span[@class='x2jg'])[13]");
		WebElement selectFilteredCountry = driver.findElement(By.xpath(selectFilteredCountryXpath));
		selectFilteredCountry.click();*/
		
		List<WebElement> elements = driver.findElements(By.xpath(selectFilteredCountryXpath));
		
		for(WebElement element : elements){
			try {
				String text = element.getText();
				//System.out.println("text : "+text);
				
				if(text.equalsIgnoreCase(countryName))
					element.click();
			} catch (Exception e) {
			}
		}
		
		String searchAndSelectCountryXpath = "//button[@_afrpdo='ok']";
		WebElement searchAndSelectCountry = driver.findElement(By.xpath(searchAndSelectCountryXpath));
		searchAndSelectCountry.click();
		Thread.sleep(1500);
	}
	
	
	public static void countryLabelNamesRead(String country, String fieldName, boolean status) throws InterruptedException{
		
		boolean lableExistsStatus = false;
		Thread.sleep(3500);
		String addressLableXpath ="//tr[contains(@id, '_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:SP1:region1')]//td//label";
		dynamicWaitFoeElement("(//tr[contains(@id, '_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:SP1:region1')]//td//label)[10]");
		List<WebElement> elements = driver.findElements(By.xpath(addressLableXpath));
		
		for(WebElement element : elements){
			String lable = element.getText();
			//System.out.println("lable : "+lable);
			
			if(lable.equalsIgnoreCase(fieldName))	lableExistsStatus = true;
		}
		
		if(lableExistsStatus == status)
			System.out.println("===> Country "+country+" filed "+fieldName+" validation passed.");
		else 
			System.out.println("===> Country "+country+" filed "+fieldName+" validation failed.");
		Thread.sleep(3500);
	}
	
	
	public static void ClickOnAddAddressIcon(){
	
		String homeAddress_plus_iconXpath = "//img[@title='Create Address']";
		dynamicWaitFoeElement(homeAddress_plus_iconXpath);
		WebElement homeAddress_plus_icon = driver.findElement(By.xpath(homeAddress_plus_iconXpath));
		homeAddress_plus_icon.click();
	}
	
	public static void createAddress_cancelClick(){
		String createAddressXpath = "//button[@accesskey='C']";
		WebElement createAddress = driver.findElement(By.xpath(createAddressXpath));
		createAddress.click();
	}
	
	public static void countryValidation(String countryName) throws InterruptedException{
		
		String country_ddl_iconXpath = "//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:SP1:region1:0:region1:0:countrylov::lovIconId']";
		dynamicWaitFoeElement(country_ddl_iconXpath);
		WebElement country_ddl_icon = driver.findElement(By.xpath(country_ddl_iconXpath));
		country_ddl_icon.click();
		
		String searchXpath = "//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:SP1:region1:0:region1:0:countrylov::dropdownPopup::popupsearch']";
		dynamicWaitFoeElement(searchXpath);
		WebElement search = driver.findElement(By.xpath(searchXpath));
		search.click();
		
		selectCountry(countryName);
	}
	
	public static void browserClose(){
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		
		browserLaunch();
		
		performLogin();
		
		clickOnNavigate();
		
		clickOnPersonManagement();
		
		clickOnSearChResultsname();
		
		clickOnTask();
		
		clickOnManagePerson();
		
		//homeAddressEdit();
		
		ClickOnAddAddressIcon();
		
		/*String country = "INDIA";
		countryValidation(country);
		countryLabelNamesRead(country, "City", true);*/
		
		String country = "CHINA";
		countryValidation(country);
		countryLabelNamesRead(country, "City", true);
		countryLabelNamesRead(country, "District", true);
		countryLabelNamesRead(country, "Prefecture", false);
		countryLabelNamesRead(country, "County/District", false);
		
		
		createAddress_cancelClick();
		browserClose();
		
	}

}
