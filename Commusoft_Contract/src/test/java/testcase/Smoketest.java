package testcase;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import action.Baseclass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.CreateJob;
import pages.Customer;
import pages.Diary;
import pages.Editcustomer_workaddress;
import pages.Invoice;
import pages.searchengine;
import utility.Screenshotstestcases;


public class Smoketest extends Baseclass {
	

	// Arrays of adjectives and nouns
    private static final String[] ADJECTIVES = {
        "Agile", "Brave", "Calm", "Delightful", "Eager",
        "Fancy", "Graceful", "Humble", "Innovative", "Jovial"
    };

    private static final String[] NOUNS = {
        "Agreement", "Alliance", "Charter", "Covenant", "Deal",
        "Pact", "Treaty", "Understanding", "Accord", "Contract"
    };

//manually edited
	@Test(priority = 0 )
	public void New_Contract_Template_Creation() throws InterruptedException, IOException
	{
		driver.get("https://app.commusoft.co.uk/customers/customer/7694/view_v2/property/view");
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//a[@id=\"drop5\"]");
		click("//a[@id=\"drop5\"]");

		ExplicitWait_ElementToBeClickable("//a[@href=\"/settings\"]");
		click("//a[@href=\"/settings\"]");

		ExplicitWait_ElementToBeClickable("(//span[contains(text(),'Contracts')])[1]");
		click("(//span[contains(text(),'Contracts')])[1]");

		ExplicitWait_ElementToBeClickable("//a[@href=\"system_settings/contract_templates\"]");
		click("//a[@href=\"system_settings/contract_templates\"]");

		ExplicitWait_ElementToBeClickable("//a[@href=\"/system_settings/contract_templates/add_new\"]");
		click("//a[@href=\"/system_settings/contract_templates/add_new\"]");

		//random name
		// Create an instance of Random
		Random random = new Random();

		// Select a random adjective and noun
		String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
		String noun = NOUNS[random.nextInt(NOUNS.length)];

		// Combine them to create the contract name
		String contractName = adjective + " " + noun;
		ContractName=contractName;

		// Print the contract name
		System.out.println("Random Contract Name: " + contractName);

		ExplicitWait_ElementToBeClickable("//input[@formcontrolname=\"contractName\"]");
		type("//input[@formcontrolname=\"contractName\"]", ContractName);


		ExplicitWait_ElementToBeClickable("//textarea[@formcontrolname=\"contractDescription\"]");
		type("//textarea[@formcontrolname=\"contractDescription\"]", ContractName);

		selectdropdownindex("//select[@formcontrolname=\"contractCategory\"]", 1);

		selectdropdownindex("//select[@formcontrolname=\"contractType\"]", 1);

		ExplicitWait_ElementToBeClickable("//input[@formcontrolname=\"contractPeriod\"]");
		type("//input[@formcontrolname=\"contractPeriod\"]", "12");

		ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
		click("//span[contains(text(),'Next')]");

		ExplicitWait_ElementToBeClickable("(//label[@class=\"radio\"])[1]");
		click("(//label[@class=\"radio\"])[1]");

		ExplicitWait_ElementToBeClickable("//span[text()='Yes']");
		mainclick("//span[text()='Yes']"); Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-default\"]");
		click("//input[@class=\"select2-input select2-default\"]");

		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "System");
		typeenter("//input[@class=\"select2-input select2-focused\"]");

		ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
		click("//span[contains(text(),'Next')]");

		Thread.sleep(3000);
		ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
		click("//span[contains(text(),'Next')]");

		ExplicitWait_ElementToBeClickable("//span[text()='Yes']");
		mainclick("//span[text()='Yes']"); Thread.sleep(4000);//ppm yes


		//PPm first - PPM
		dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[1]");
		Thread.sleep(2000);
		type("//input[contains(@class,'select2-input select')]", "PPM");
		Thread.sleep(1000);
		typeenter("//input[contains(@class,'select2-input select')]");
		Thread.sleep(1000);
		click("(//td[contains(@class,'overflow_handsontable select_icon')])[1]");

		//PPm second - type
		dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[2]");
		Thread.sleep(2000);
		type("//input[contains(@class,'select2-input select')]", "Asset");
		Thread.sleep(1000);
		typeenter("//input[contains(@class,'select2-input select')]");
		Thread.sleep(1000);
		click("(//td[contains(@class,'overflow_handsontable select_icon')])[2]");

		//PPm third - JD 
		dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[3]");
		Thread.sleep(2000);
		type("//input[contains(@class,'select2-input select')]", "Auto");
		Thread.sleep(1000);
		typeenter("//input[contains(@class,'select2-input select')]");
		Thread.sleep(1000);
		click("(//td[contains(@class,'overflow_handsontable select_icon')])[3]");


		//PPm four - Chargeable 
		dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[4]");
		Thread.sleep(2000);
		type("//input[contains(@class,'select2-input select')]", "Yes");
		Thread.sleep(1000);
		typeenter("//input[contains(@class,'select2-input select')]");
		Thread.sleep(1000);
		click("(//td[contains(@class,'overflow_handsontable select_icon')])[4]");



		dclick("(//td[@class=\"select_icon overflow_handsontable required htPlaceholder\"])[1]");
		Thread.sleep(2000);
		type("//input[@class=\"chosen-search-input default\"]", "Boiler");
		Thread.sleep(1000);
		typeenter("//input[@class=\"chosen-search-input default\"]");
		Thread.sleep(1000);
		click("(//td[contains(@class,'overflow_handsontable select_icon')])[4]"); Thread.sleep(3000);

		ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
		click("//span[contains(text(),'Next')]");

		//service jobs
		Thread.sleep(3000);
		ExplicitWait_ElementToBeClickable("//span[text()='Yes']");
		mainclick("//span[text()='Yes']"); Thread.sleep(4000);


		//PPm first - Serivce type
		dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[1]");
		Thread.sleep(2000);
		type("//input[contains(@class,'select2-input select')]", "Boiler");
		Thread.sleep(1000);
		typeenter("//input[contains(@class,'select2-input select')]");
		Thread.sleep(1000);
		click("(//td[contains(@class,'overflow_handsontable select_icon')])[1]");

		
		//PPm first - reminder/job
		dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[3]");
		Thread.sleep(2000);
		type("//input[contains(@class,'select2-input select')]", "Create");
		Thread.sleep(1000);
		typeenter("//input[contains(@class,'select2-input select')]");
		Thread.sleep(1000);
		click("(//td[contains(@class,'overflow_handsontable select_icon')])[3]");

		//PPm first - chargeable
		dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[4]");
		Thread.sleep(2000);
		type("//input[contains(@class,'select2-input select')]", "Yes");
		Thread.sleep(1000);
		typeenter("//input[contains(@class,'select2-input select')]");
		Thread.sleep(1000);
		click("(//td[contains(@class,'overflow_handsontable select_icon')])[4]");

		ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
		click("//span[contains(text(),'Next')]");
		
		
		//Call breakdowns
		Thread.sleep(3000);
				ExplicitWait_ElementToBeClickable("//span[text()='Yes']");
				mainclick("//span[text()='Yes']"); Thread.sleep(4000);
				
				//PPm first - JD
				dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[1]");
				Thread.sleep(2000);
				type("//input[contains(@class,'select2-input select')]", "Auto");
				Thread.sleep(1000);
				typeenter("//input[contains(@class,'select2-input select')]");
				Thread.sleep(1000);
				click("(//td[contains(@class,'overflow_handsontable select_icon')])[1]");
				
				//PPm second - Chargeable
				dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[2]");
				Thread.sleep(2000);
				type("//input[contains(@class,'select2-input select')]", "Yes");
				Thread.sleep(1000);
				typeenter("//input[contains(@class,'select2-input select')]");
				Thread.sleep(1000);
				click("(//td[contains(@class,'overflow_handsontable select_icon')])[2]");
				
				ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
				click("//span[contains(text(),'Next')]");
				
				
				ExplicitWait_ElementToBeClickable("//a[text()='Add segmentations']");
				click("//a[text()='Add segmentations']");
				
				Thread.sleep(3000);
			//	click("//select[@class=\"full-width-select ng-pristine ng-valid ng-touched\"]");
				selectdropdown("/html/body/sidepanel-modal-container/div/div/form/div[2]/div[2]/div[1]/div/div/select", "Job description");
				

				ExplicitWait_ElementToBeClickable("//button[@class=\"btn btn-primary\"]");
				click("//button[@class=\"btn btn-primary\"]");
				
				Thread.sleep(4000);
				selectdropdown("//select[@formcontrolname=\"applicableDaysValue\"]", "Monday - Friday");
				
				ExplicitWait_ElementToBeClickable("//input[@formcontrolname=\"labourCost\"]");
				type("//input[@formcontrolname=\"labourCost\"]", "10");
				click("//select[@formcontrolname=\"applicableDaysValue\"]");
				
				Thread.sleep(3000);
				ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
				mainclick("//span[contains(text(),'Next')]");
				
				Thread.sleep(3000);
				ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
				click("//span[contains(text(),'Next')]");
				
				ExplicitWait_ElementToBeClickable("(//input[@class=\"form-control\"])[1]");
				type("(//input[@class=\"form-control\"])[1]", "5");
				
				ExplicitWait_ElementToBeClickable("//h3[text()='Parts markup']");
				click("//h3[text()='Parts markup']");
				
				
				
				//part markup
				dclick("(//td[contains(@class,'overflow_handsontable select_icon')])[1]");
				Thread.sleep(2000);
				type("//input[contains(@class,'select2-input select')]", "Part");
				Thread.sleep(3000);
				typeenter("//input[contains(@class,'select2-input select')]");
				Thread.sleep(1000);
				//click("(//td[contains(@class,'overflow_handsontable select_icon')])[1]");
				
				ExplicitWait_ElementToBeClickable("//td[@class=\"overflow_handsontable required current highlight cs-ht-cell-invalid\"]");
				//click("//td[@class=\"overflow_handsontable required current highlight cs-ht-cell-invalid\"]");
				dclick("//td[@class=\"overflow_handsontable required current highlight cs-ht-cell-invalid\"]");
				type("//textarea[@class=\"handsontableInput\"]", "3");
				Thread.sleep(3000);
				click("(//td[contains(@class,'overflow_handsontable select_icon')])[1]");
				
				
				Thread.sleep(3000);
				ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
				mainclick("//span[contains(text(),'Next')]");
				
				Thread.sleep(3000);
				ExplicitWait_ElementToBeClickable("//span[text()='Yes']");
				mainclick("//span[text()='Yes']"); Thread.sleep(4000);
				
				ExplicitWait_ElementToBeClickable("//a[text()=\"Add new invoice option\"]");
				click("//a[text()=\"Add new invoice option\"]");
				
				ExplicitWait_ElementToBeClickable("//input[@formcontrolname=\"descriptionofoption\"]");
				type("//input[@formcontrolname=\"descriptionofoption\"]", "Invoice Description");
				
				ExplicitWait_ElementToBeClickable("//span[text()='Fixed']");
				mainclick("//span[text()='Fixed']");
				
				ExplicitWait_ElementToBeClickable("//span[text()='Fixed price for the contract']");
				mainclick("//span[text()='Fixed price for the contract']");
				
				Thread.sleep(4000);
				selectdropdown("//select[@formcontrolname=\"periodofbilling\"]", "At the beginning of the contract");
				
				ExplicitWait_ElementToBeClickable("//input[@formcontrolname=\"descriptiontoappearinvoice\"]");
				type("//input[@formcontrolname=\"descriptiontoappearinvoice\"]", "Description to appear on invoice");
				
				Thread.sleep(4000);
				selectdropdownindex("//select[@formcontrolname=\"invoicecategory\"]", 1);
				
				
				
				
				WebElement element = driver.findElement(By.xpath("//select[@formcontrolname=\"usergroups\"]"));
	            Actions actions = new Actions(driver);
	            actions.moveToElement(element).perform();
				Thread.sleep(4000);
				selectdropdownindex("//select[@formcontrolname=\"usergroups\"]", 1);
				
				
				
				WebElement element1 = driver.findElement(By.xpath("//select[@formcontrolname=\"nominalCode\"]"));
	           
	            actions.moveToElement(element1).perform();
				Thread.sleep(4000);
				selectdropdownindex("//select[@formcontrolname=\"nominalCode\"]", 1);
				
				
				
				
				
				
				
				
				
				WebElement element2 = driver.findElement(By.xpath("//input[@formcontrolname=\"invoiceprice\"]"));
	            
	            actions.moveToElement(element2).perform();
				ExplicitWait_ElementToBeClickable("//input[@formcontrolname=\"invoiceprice\"]");
				type("//input[@formcontrolname=\"invoiceprice\"]", "100");
				
				
				
				
				
				
				
				Thread.sleep(6000);
				ExplicitWait_ElementToBeClickable("//button[@class=\"btn btn-primary\"]");
				click("//button[@class=\"btn btn-primary\"]");
				
				ExplicitWait_ElementToBeClickable("//button[@action-id=\"edit\"]");
				Thread.sleep(2000);
				ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
				mainclick("//span[contains(text(),'Next')]");
				
				Thread.sleep(3000);
				ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
				mainclick("//span[contains(text(),'Next')]");
				
				Thread.sleep(4000);
				ExplicitWait_ElementToBeClickable("//button[@class=\"btn btn-primary no-margin\"]");
				click("//button[@class=\"btn btn-primary no-margin\"]");
				
				ExplicitWait_ElementToBeClickable("//input[@formcontrolname=\"confirmationText\"]");
				type("//input[@formcontrolname=\"confirmationText\"]", "Activate");
				
				ExplicitWait_ElementToBeClickable("//button[@class=\"btn btn-primary\"]");
				click("//button[@class=\"btn btn-primary\"]");
				Thread.sleep(5000);
				
				
				
	}
	
	@Test(priority = 1 )
	public void Add_new_contract_to_customer() throws InterruptedException, IOException
	{
		
		driver.get("https://app.commusoft.co.uk/customers/customer/7694/view_v2/property/view");
		Thread.sleep(5000);
		
		ExplicitWait_ElementToBeClickable("//a[@class=\"btn dropdown-toggle btn-small quick-links-btn custom-margin\"]");
		click("//a[@class=\"btn dropdown-toggle btn-small quick-links-btn custom-margin\"]");
		ExplicitWait_ElementToBeClickable("//a[contains(text(),\" Contracts \")]");
		click("//a[contains(text(),\" Contracts \")]");
		Thread.sleep(5000);
		ExplicitWait_ElementToBeClickable("//a[contains(text(),\"Add new contract\")]");
		click("//a[contains(text(),\"Add new contract\")]");


		//inside contract
		ExplicitWait_ElementToBeClickable("(//span[@class=\"select2-chosen\"])[2]");
		click("(//span[@class=\"select2-chosen\"])[2]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", ContractName);
		typeenter("//input[@class=\"select2-input select2-focused\"]");

		ExplicitWait_ElementToBeClickable("(//select[@class=\"full-width-select ng-untouched ng-pristine ng-invalid\"])[1]");
		selectdropdownindex("(//select[@class=\"full-width-select ng-untouched ng-pristine ng-invalid\"])[1]", 1);

		ExplicitWait_ElementToBeClickable("//select[@formcontrolname=\"contractChanneladvertising\"]");
		selectdropdownindex("//select[@formcontrolname=\"contractChanneladvertising\"]", 1);

		ExplicitWait_ElementToBeClickable("//select[@formcontrolname=\"salesPerson\"]");
		selectdropdownindex("//select[@formcontrolname=\"salesPerson\"]", 2);

		ExplicitWait_ElementToBeClickable("//button[@class=\"btn btn-primary save_btn\"]");
		click("//button[@class=\"btn btn-primary save_btn\"]");

		//page2
		Thread.sleep(4000);
		ExplicitWait_ElementToBeClickable("(//span[@class=\"select2-chosen\"])[2]");
		click("(//span[@class=\"select2-chosen\"])[2]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "At");
		typeenter("//input[@class=\"select2-input select2-focused\"]");

		ExplicitWait_ElementToBeClickable("(//span[@class=\"select2-chosen\"])[3]");
		click("(//span[@class=\"select2-chosen\"])[3]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "karna");
		typeenter("//input[@class=\"select2-input select2-focused\"]");

		ExplicitWait_ElementToBeClickable("//button[@class=\"btn btn-primary save_btn\"]");
		click("//button[@class=\"btn btn-primary save_btn\"]");

		//page3
		Thread.sleep(4000);
		ExplicitWait_ElementToBeClickable("//button[@class=\"btn btn-primary save_btn\"]");
		click("//button[@class=\"btn btn-primary save_btn\"]");

		//page4
		Thread.sleep(4000);
		ExplicitWait_ForPresenceOfElement("//td[contains(text(),'PPM')]");
		click("(//div[@class=\"text link\"])[1]");//Asset Edit

		ExplicitWait_ElementToBeClickable("//td[@class=\"col-w-2 ng-scope\"]");
		click("//td[@class=\"col-w-2 ng-scope\"]");//checkbox of asset

		ExplicitWait_ElementToBeClickable("//button[contains(text(),'Save')]");
		click("//button[contains(text(),'Save')]");
		Thread.sleep(3000);
		ExplicitWait_ForPresenceOfElement("(//div[contains(text(),'1')])[3]");

		Thread.sleep(4000);
		ExplicitWait_ForPresenceOfElement("//td[contains(text(),'PPM')]");
		click("(//div[@class=\"text link\"])[2]");//PPM Edit











		//page5 - tasks
		Thread.sleep(3000);
		ExplicitWait_ElementToBeClickable("(//div[@class=\"alert-icon\"])[1]");
		click("(//div[@class=\"alert-icon\"])[1]");
		Thread.sleep(8000);

		ExplicitWait_ElementToBeClickable("//div[contains(text(),'Set weeks')]");
		click("//div[contains(text(),'Set weeks')]");
		Thread.sleep(5000);

		ExplicitWait_ElementToBeClickable("(//button[@class=\"btn btn-primary\"])[last()]");
		click("(//button[@class=\"btn btn-primary\"])[last()]");
		Thread.sleep(4000);
		
		ExplicitWait_ElementToBeClickable("//button[contains(text(),' Add asset ')]");
		click("//button[contains(text(),' Add asset ')]");Thread.sleep(3000);

		ExplicitWait_ElementToBeClickable("//div[contains(text(),' Add asset ')]");
		click("//div[contains(text(),' Add asset ')]");
		Thread.sleep(2000);

		ExplicitWait_ElementToBeClickable("//a[@class=\"btn\"]");
		click("//a[@class=\"btn\"]");

		ExplicitWait_ElementToBeClickable("//button[contains(text(),'Save')]");
		click("//button[contains(text(),'Save')]");
		Thread.sleep(5000);

		

		//service job edit3
		Thread.sleep(4000);
		ExplicitWait_ForPresenceOfElement("//td[contains(text(),'PPM')]");
		click("(//div[@class=\"text link\"])[3]");//PPM Edit

		ExplicitWait_ElementToBeClickable("(//a[@id=\"non-service-date-link\"])[1]");
		Thread.sleep(3000);
		click("(//a[@id=\"non-service-date-link\"])[1]");

		//current date
		LocalDate currentDate = LocalDate.now();
		int day = currentDate.getDayOfMonth();
		int month = currentDate.getMonthValue();
		int year = currentDate.getYear();
		YearMonth yearmonth = YearMonth.of(year, month);
		int daysinMonth = yearmonth.lengthOfMonth();
		
		
		int service = day+1;
		System.out.println("Current Date+7: " + service);
		System.out.println("Current Year: "+ year);
		System.out.println("Current Month: " + month);
		System.out.println("Current Month no of days: "+ daysinMonth);
		int actualdate = service-daysinMonth;
		
		
		
		
		
//		 ExplicitWait_ElementToBeClickable("//span[(text()='›')]");
//		 click("//span[(text()='›')]");
		 ExplicitWait_ElementToBeClickable("//span[(text()='"+service+"')]");
			click("//span[(text()='"+service+"')]");
		 
		 if(driver.findElement(By.xpath("//th[text()='Mon ']")).isDisplayed()) {
			 
			
				click("(//span[(text()='"+service+"')])[2]");
			 
		 }
		 
		
		
		
		
		
		
		

//		ExplicitWait_ElementToBeClickable("//span[contains(text(),'"+service+"')]");
//		click("//span[contains(text(),'"+service+"')]");

		//second service
		
		

	 

		ExplicitWait_ElementToBeClickable("(//a[contains(text(),'Select contact')])[1]");
		click("(//a[contains(text(),'Select contact')])[1]");

		ExplicitWait_ElementToBeClickable("(//a[contains(text(),' Mr Karnan Athisivam ')])[1]");
		click("(//a[contains(text(),' Mr Karnan Athisivam ')])[1]");

		

		
		ExplicitWait_ElementToBeClickable("(//button[@class=\"btn btn-primary\"])[1]");
		click("(//button[@class=\"btn btn-primary\"])[1]");

		
		
		ExplicitWait_ElementToBeClickable("//input[@formcontrolname=\"confirmationText\"]");
		type("//input[@formcontrolname=\"confirmationText\"]", "Confirm");

		ExplicitWait_ElementToBeClickable("//button[contains(text(),' Confirm ')]");
		click("//button[contains(text(),' Confirm ')]");Thread.sleep(6000);

		Thread.sleep(4000);
		ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
		click("//span[contains(text(),'Next')]");Thread.sleep(4000);

		//step5
		ExplicitWait_ElementToBeClickable("//span[contains(text(),'Next')]");
		click("//span[contains(text(),'Next')]");Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//input[@formcontrolname=\"confirmationText\"]");
		type("//input[@formcontrolname=\"confirmationText\"]", "Activate");

		ExplicitWait_ElementToBeClickable("//button[contains(text(),' Activate ')]");
		click("//button[contains(text(),' Activate ')]");Thread.sleep(6000);

		isdisplayed("//td[contains(text(),'Active')]");
		System.out.println("Existing Contract added to the customer:"+contractwebcustomerno);
	}


	

}
