package testcase;

import static org.testng.Assert.expectThrows;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import action.Baseclass;
import pages.CreateJob;
import pages.Customer;
import pages.Diary;
import pages.Estimate;
import pages.Invoice;
import pages.NotesandCommunication;
import pages.Settings;
import utility.Screenshotstestcases;

public class KSmoke extends Baseclass{


	// Arrays of adjectives and nouns
	private static final String[] ADJECTIVES = {
			"Agile", "Brave", "Calm", "Delightful", "Eager",
			"Fancy", "Graceful", "Humble", "Innovative", "Jovial"
	};

	private static final String[] NOUNS = {
			"Agreement", "Alliance", "Charter", "Covenant", "Deal",
			"Pact", "Treaty", "Understanding", "Accord", "Contract"
	};

	@Test(priority = 1 )
	public void Add_Customer() throws InterruptedException, IOException
	{
		Customer customer = new Customer(driver);
		customer.Customer_create();
		customer.Customer_title();
		customer.Customer_Name();
		customer.Customer_SurName();
		customer.Customer_Mobile();
		customer.Customer_email();
		customer.Customer_AddressLine1();
		Screenshotstestcases SS=new Screenshotstestcases ();
		SS.takeScreenshot(driver,"Add_customer");
		customer.Customer_Save();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='header-detail text-bold mb-0'])[1]")));
		SS.takeScreenshot(driver,"view_customer");
		Thread.sleep(3000);
		contractwebcustomerno = gettext("//*[@id=\"side-contain\"]/app-sidebar/div[4]/ul[2]/li[2]");
		Thread.sleep(3000);
		contractcustomerpage = driver.getCurrentUrl();
		Thread.sleep(3000);
	}
	@Test(priority=2)
	public void Asset() throws InterruptedException
	{
		driver.get(contractcustomerpage);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("(//span[@class=\"padr5\"])[5]");
		click("(//span[@class=\"padr5\"])[5]");
		ExplicitWait_ElementToBeClickable("//a[contains(text(),'Add new asset')]");
		click("//a[contains(text(),'Add new asset')]");



		ExplicitWait_ElementToBeClickable("(//span[@class=\"select2-chosen\"])[1]");
		click("(//span[@class=\"select2-chosen\"])[1]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "System boiler");
		typeenter("//input[@class=\"select2-input select2-focused\"]");


		ExplicitWait_ElementToBeClickable("(//input[@type=\"text\"])[2]");
		type("(//input[@type=\"text\"])[2]", "Sample");

		ExplicitWait_ElementToBeClickable("//button[@ng-click=\"handleSave()\"]");
		click("//button[@ng-click=\"handleSave()\"]"); Thread.sleep(4000);


	}

	@Test(priority = 3)
	public void Contract_Creation_for_Customer() throws InterruptedException, IOException
	{
		driver.get(contractcustomerpage);
		Thread.sleep(4000);
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
		type("//input[@class=\"select2-input select2-focused\"]", "Existing contract template");
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

		ExplicitWait_ElementToBeClickable("//button[contains(text(),'Save')]");
		click("//button[contains(text(),'Save')]");
		Thread.sleep(5000);

		//page5.1 - tasks

		Thread.sleep(3000);
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
		Thread.sleep(5000);
		ExplicitWait_ElementToBeClickable("(//a[@id=\"non-service-date-link\"])[2]");
		click("(//a[@id=\"non-service-date-link\"])[2]");Thread.sleep(3000);








		//		ExplicitWait_ElementToBeClickable("//span[(text()='›')]");
		//		 click("//span[(text()='›')]");
		ExplicitWait_ElementToBeClickable("//span[(text()='"+service+"')]");
		click("//span[(text()='"+service+"')]");

		if(driver.findElement(By.xpath("//th[text()='Mon ']")).isDisplayed()) {


			click("(//span[(text()='"+service+"')])[2]");

		}




		ExplicitWait_ElementToBeClickable("(//a[contains(text(),'Select contact')])[1]");
		click("(//a[contains(text(),'Select contact')])[1]");

		ExplicitWait_ElementToBeClickable("(//a[contains(text(),' Mr Karnan Athisivam ')])[1]");
		click("(//a[contains(text(),' Mr Karnan Athisivam ')])[1]");

		ExplicitWait_ElementToBeClickable("(//a[contains(text(),'Select contact')])[1]");
		click("(//a[contains(text(),'Select contact')])[1]");

		ExplicitWait_ElementToBeClickable("(//a[contains(text(),' Mr Karnan Athisivam ')])[2]");
		click("(//a[contains(text(),' Mr Karnan Athisivam ')])[2]");


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
	@Test(priority = 4)
	public void Add_job_Prefinal() throws InterruptedException, IOException
	{
		driver.get("https://app.commusoft.co.uk/");Thread.sleep(6000);
		Customer customer = new Customer(driver);
		customer.Customer_create();
		customer.Customer_title();
		customer.Customer_Name();
		customer.Customer_SurName();
		customer.Customer_Mobile();
		customer.Customer_email();
		customer.Customer_AddressLine1();
		Screenshotstestcases SS=new Screenshotstestcases ();
		SS.takeScreenshot(driver,"Add_customer");
		customer.Customer_Save();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='header-detail text-bold mb-0'])[1]")));
		SS.takeScreenshot(driver,"view_customer");
		Thread.sleep(3000);
		customerpage = driver.getCurrentUrl();


		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescriptionprefinal("PreFinal");
		Invoice assertinv=new Invoice(driver);
		assertinv.InvoiceTab();
		assertinv.assertprefinal();

	}
	@Test(priority=5)
	public void Asset_to_new_customer() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("(//span[@class=\"padr5\"])[5]");
		click("(//span[@class=\"padr5\"])[5]");
		ExplicitWait_ElementToBeClickable("//a[contains(text(),'Add new asset')]");
		click("//a[contains(text(),'Add new asset')]");



		ExplicitWait_ElementToBeClickable("(//span[@class=\"select2-chosen\"])[1]");
		click("(//span[@class=\"select2-chosen\"])[1]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "System boiler");
		typeenter("//input[@class=\"select2-input select2-focused\"]");


		ExplicitWait_ElementToBeClickable("(//input[@type=\"text\"])[2]");
		type("(//input[@type=\"text\"])[2]", "Sample");

		ExplicitWait_ElementToBeClickable("//button[@ng-click=\"handleSave()\"]");
		click("//button[@ng-click=\"handleSave()\"]"); Thread.sleep(4000);


	}
	@Test(priority = 6)
	public void Add_job_Final_Complete() throws InterruptedException, IOException
	{
		driver.get(customerpage);Thread.sleep(6000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescriptionautofinal("AutoFinal");
		job.edit_job();
		job.complete_job();
		Invoice clickinvoicetab=new Invoice(driver);
		clickinvoicetab.InvoiceTab();
		clickinvoicetab.assertFinal();

	}
	@Test(priority = 7)
	public void Addjob_NoRules() throws InterruptedException
	{
		driver.get(customerpage);Thread.sleep(6000);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("No Rules");
		//job.createjob();
		Thread.sleep(3000);
		Invoice invoice = new Invoice(driver);
		invoice.InvoiceTab();
		invoice.addinvoice();
		invoice.Final_invoice();
		invoice.invoice_description();
		invoice.invoice_UserGroup();
		invoice.invoice_Category();
		invoice.sub_total("500");
		invoice.save_invoice();
	}
	@Test(priority = 8)
	public void Addjob_NoRules_Adddtional() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("No Rules");
		//job.createjob();
		Thread.sleep(3000);
		Invoice invoice = new Invoice(driver);
		invoice.InvoiceTab();
		invoice.addinvoice();
		invoice.Additional_invoice();
		invoice.invoice_UserGroup();
		invoice.invoice_Category();
		invoice.Invoice_Breakdown_Full_breakdown_by_category();
		invoice.invoice_description();
		invoice.Full_Breakdown_ByCategory_Labour_Description("Labour");
		invoice.unitprice_FullBreakdown_ByCategory_Labour("300");
		invoice.Full_Breakdown_ByCategory_Parts_Description("Price one");
		invoice.save_invoice();
	}
	@Test(priority = 9)
	public void Estimate_Accept() throws InterruptedException, IOException
	{
		driver.get(customerpage);
		Thread.sleep(5000);
		Estimate estimate = new Estimate(driver);
		estimate.Estimate_AddNew();
		estimate.choose_description();
		estimate.Estimate_Notes();
		estimate.Estimate_CustomerReference();
		estimate.Estimate_user_group();
		estimate.Estimate_AddEstimate();
		Screenshotstestcases SS=new Screenshotstestcases ();
		SS.takeScreenshot(driver,"Add_Estimate_screen");
		//Thread.sleep(3000);
		estimate.Estimate_Price_tab();
		//Thread.sleep(3000);
		estimate.Estimate_Price_NoBreakdown();
		//Thread.sleep(3000);
		estimate.Estimate_Price_NoBreakdown_PartsTotal();
		//Thread.sleep(3000);
		estimate.Estimate_InvoiceSchedule();
		//Thread.sleep(3000);
		estimate.Estimate_InvoiceSchedule_Deposite();
		//Thread.sleep(3000);
		estimate.Estimate_InvoiceSchedule_Completion();
		//Thread.sleep(3000);
		estimate.Estimate_InvoiceSchedule_Retention();
		//Thread.sleep(3000);
		estimate.Estimate_SendtoCustomer();
		estimate.Estimate_Accept();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='This job is from an estimate']")));
		SS.takeScreenshot(driver,"Estimate_accept converts to job");
	}

	@Test(priority = 10)
	public void Estimate_Reject() throws InterruptedException, IOException
	{
		driver.get(customerpage);
		Thread.sleep(5000);
		Estimate estimate = new Estimate(driver);
		estimate.Estimate_AddNew();
		estimate.choose_description();
		estimate.Estimate_Notes();
		estimate.Estimate_CustomerReference();
		estimate.Estimate_user_group();
		estimate.Estimate_AddEstimate();
		estimate.Estimate_Price_tab();
		estimate.Estimate_Price_NoBreakdown();
		estimate.Estimate_Price_NoBreakdown_PartsTotal();
		estimate.Estimate_InvoiceSchedule();
		estimate.Estimate_InvoiceSchedule_Deposite();
		estimate.Estimate_InvoiceSchedule_Completion();
		estimate.Estimate_InvoiceSchedule_Retention();
		estimate.Estimate_SendtoCustomer();
		estimate.Estimate_Reject();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='label ng-binding label-important']")));
		Screenshotstestcases SS=new Screenshotstestcases ();
		SS.takeScreenshot(driver,"Estimate_reject");
	}
	@Test(priority = 11)
	public void Addjob_NoRules_DiaryEvent() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("No Rules");
		//job.createjob();
		Thread.sleep(4000);
		job.Add_new_diaryEvent();
		Diary diary = new Diary(driver);
		diary.Diary_Daily();
		diary.Diary_Today();
		diary.Diary_Timing3();
		diary.Diary_EventFromJob();
	}

	@Test(priority = 12)
	public void Addpayment_job() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("No Rules");
		//job.createjob();
		Thread.sleep(4000);
		Invoice invoice = new Invoice(driver);
		invoice.InvoiceTab();
		invoice.addinvoice();
		invoice.Pre_Final_invoice();
		invoice.Invoice_Breakdown_Full_breakdown();
		invoice.invoice_description();
		invoice.Full_Breakdown_des("Price one");
		invoice.invoice_UserGroup();
		invoice.invoice_Category();
		invoice.save_invoice();
		NotesandCommunication communication = new NotesandCommunication(driver);
		invoice.invoice_AddnewPayment();
		invoice.invoice_payment_AddDescription("Job payments");
		invoice.invoice_payment_method();
		invoice.invoice_payment_nominalcode();
		invoice.invoice_payment_amount("180");
		invoice.invoice_paymeny_save();
	}
	@Test(priority = 13)
	public void Workaddress_Add() throws InterruptedException, IOException
	{
		driver.get(customerpage);
		//driver.get("https://app.commusoft.co.uk/customers/customer_list/3458/view/property/view");
		Thread.sleep(5000);
		Customer customer = new Customer(driver);
		customer.workaddress_tab();
		customer.workaddress_addnewWorkaddress();
		customer.Workaddress_create();
		Screenshotstestcases SS=new Screenshotstestcases ();
		SS.takeScreenshot(driver,"Workaddress_add");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='header-detail text-bold mb-0'])[1]")));
		SS.takeScreenshot(driver,"Workaddress_view");
		Thread.sleep(10000);
		WA = driver.getCurrentUrl();

	}
	@Test(priority=14)
	public void Asset_to_WA() throws InterruptedException
	{
		driver.get(WA);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("(//span[@class=\"padr5\"])[3]");
		click("(//span[@class=\"padr5\"])[3]");
		ExplicitWait_ElementToBeClickable("//a[contains(text(),'Add new asset')]");
		click("//a[contains(text(),'Add new asset')]");



		ExplicitWait_ElementToBeClickable("(//span[@class=\"select2-chosen\"])[1]");
		click("(//span[@class=\"select2-chosen\"])[1]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "System boiler");
		typeenter("//input[@class=\"select2-input select2-focused\"]");


		ExplicitWait_ElementToBeClickable("(//input[@type=\"text\"])[2]");
		type("(//input[@type=\"text\"])[2]", "Sample");

		ExplicitWait_ElementToBeClickable("//button[@ng-click=\"handleSave()\"]");
		click("//button[@ng-click=\"handleSave()\"]"); Thread.sleep(4000);


	}








	@Test(priority=15)
	public void New_Contract_Template_Creation() throws InterruptedException
	{
		driver.get(contractcustomerpage);
		//		driver.get("https://app.commusoft.co.uk/customers/customer/7694/view_v2/property/view");
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


	}

	@Test(priority = 16)
	public void Add_new_contract_to_customer() throws InterruptedException, IOException
	{
		driver.get(customerpage);
		//		driver.get("https://app.commusoft.co.uk/customers/customer/7702/view_v2/property/view");
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

		ExplicitWait_ElementToBeClickable("//div[@class=\"check-box all\"]");
		click("//div[@class=\"check-box all\"]");

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

		//need to include asset
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


		//including

		ExplicitWait_ElementToBeClickable("(//div[@class=\"text link\"])[5]");
		click("(//div[@class=\"text link\"])[5]");//click on WA Asset
		ExplicitWait_ElementToBeClickable("//td[@class=\"col-w-2 ng-scope\"]");
		click("//td[@class=\"col-w-2 ng-scope\"]");//checkbox of asset

		ExplicitWait_ElementToBeClickable("//button[contains(text(),'Save')]");
		click("//button[contains(text(),'Save')]");
		Thread.sleep(3000);
		ExplicitWait_ForPresenceOfElement("(//div[contains(text(),'1')])[6]");


		ExplicitWait_ElementToBeClickable("(//div[@class=\"text link\"])[6]");
		click("(//div[@class=\"text link\"])[6]");
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

		//need to include asset
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


		ExplicitWait_ElementToBeClickable("(//div[@class=\"text link\"])[7]");
		click("(//div[@class=\"text link\"])[7]");
		ExplicitWait_ElementToBeClickable("(//a[@id=\"non-service-date-link\"])[1]");
		Thread.sleep(3000);
		click("(//a[@id=\"non-service-date-link\"])[1]");
		ExplicitWait_ElementToBeClickable("//span[(text()='"+service+"')]");
		click("//span[(text()='"+service+"')]");

		if(driver.findElement(By.xpath("//th[text()='Mon ']")).isDisplayed()) {


			click("(//span[(text()='"+service+"')])[2]");

		}
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







		//included


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
	@Test(priority=17)
	public void Verification_on_Contract_creation() throws InterruptedException
	{
		driver.get(contractcustomerpage);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//a[text()='View']");
		click("//a[text()='View']");Thread.sleep(5000);

		ExplicitWait_ElementToBeClickable("//button[text()=\" View \"]");
		click("//button[text()=\" View \"]");Thread.sleep(13000);

		isdisplayed("//strong[text()='Contract created']");

	}
	@Test(priority=18)
	public void Verification_on_Contract_Activation() throws InterruptedException
	{
		driver.get(contractcustomerpage);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//a[text()='View']");
		click("//a[text()='View']");Thread.sleep(5000);

		ExplicitWait_ElementToBeClickable("//button[text()=\" View \"]");
		click("//button[text()=\" View \"]");Thread.sleep(13000);

		isdisplayed("//strong[text()='Contract activated']");

	}
	@Test(priority=19)
	public void Verification_on_Contract_Communication() throws InterruptedException
	{
		driver.get(contractcustomerpage);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//a[text()='View']");
		click("//a[text()='View']");Thread.sleep(5000);

		ExplicitWait_ElementToBeClickable("//button[text()=\" View \"]");
		click("//button[text()=\" View \"]");Thread.sleep(13000);

		isdisplayed("//span[text()='Contract Communication template']");

	}
	@Test(priority=20)
	public void Verification_on_Contract_Invoice() throws InterruptedException
	{
		driver.get(contractcustomerpage);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//a[text()='View']");
		click("//a[text()='View']");Thread.sleep(5000);

		ExplicitWait_ElementToBeClickable("//button[text()=\" View \"]");
		click("//button[text()=\" View \"]");Thread.sleep(13000);

		isdisplayed("//strong[text()='Invoice created']");

	}
	@Test(priority=21)
	public void Verification_on_Contract_Invoice_Email() throws InterruptedException
	{
		driver.get(contractcustomerpage);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//a[text()='View']");
		click("//a[text()='View']");Thread.sleep(5000);

		ExplicitWait_ElementToBeClickable("//button[text()=\" View \"]");
		click("//button[text()=\" View \"]");Thread.sleep(13000);

		isdisplayed("//span[contains(text(),'ContractInvoice')]");

	}
	@Test(priority=22)
	public void Verification_on_Contract_Reminder_Email() throws InterruptedException
	{
		driver.get(contractcustomerpage);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//a[text()='View']");
		click("//a[text()='View']");Thread.sleep(5000);

		ExplicitWait_ElementToBeClickable("//button[text()=\" View \"]");
		click("//button[text()=\" View \"]");Thread.sleep(13000);

		isdisplayed("//span[contains(text(),'Service Reminder Email from Contract')]");

	}
	@Test(priority=23)
	public void Verification_on_Contract_Jobs_created() throws InterruptedException
	{
		driver.get(contractcustomerpage);
		Thread.sleep(4000);

		ExplicitWait_ElementToBeClickable("//a[text()='View']");
		click("//a[text()='View']");Thread.sleep(5000);

		ExplicitWait_ElementToBeClickable("//button[text()=\" View \"]");
		click("//button[text()=\" View \"]");Thread.sleep(13000);

		isdisplayed("(//strong[text()='Job created'])[1]");

		isdisplayed("(//strong[text()='Job created'])[2]");

	}









	




}