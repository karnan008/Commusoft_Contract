package action;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import io.testproject.sdk.internal.exceptions.AgentConnectException;
//import io.testproject.sdk.internal.exceptions.InvalidTokenException;
//import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import pages.LoginPage;
import utility.Browsers;
import utility.Config;
import utility.Excelsheetdata;
import utility.Screenshot;

public class Baseclass extends Wrapper {
	
	public Excelsheetdata sheet;
	public XSSFSheet sh;
	public Config config;
	public ExtentReports report;
	public ExtentTest logger;
	public String homepage;
	
	public String Name="Customer";//Cutomer
	public String Surname="ForWebAutomation";	
	public String Email="commusoftweb@yopmail.com";
	public String Additionalinvoice="Additional invoice";
	public String Interiminvoice="Interim invoice";
	public String PreFinalinvoice="Pre-final invoice";
	public String Finalinvoice="Final invoice";
	public String InvoiceDes="InvoiceDes";
	public String RanjitCategory="Ranjit Category";
	public String AravindCategory="Aravind Category";
	public String RACategory="RA category";
	public String Subtotal100="100";
	public String Subtotal200="200";
	public String Vat20="20.00";
	public String Vat5="5.00";
	public String Vat0="0.00";
	public String Vat15="15.00";
	public String SalesNominalCode="Sales";
	public String OthersNominalCode="others";
	public String RentNominalCode="rent";
	public String Part="parts";
	public String UnitPrice="122";
	public String UnitPrice2="785";
	public String UnitPrice3="258";
	public String Part2="parts2";
	public String Part3="parts3";
	public String Quantity="1";
	public String EditQuantity="2";
	public String CreditNominalCode="CIS sales";
	
	
//	public static ExtentHtmlReporter htmlReporter;
//	public static ExtentReports extent;
//	public static ExtentTest logger;

	
	//test by jarba
	
	@BeforeSuite(alwaysRun = true)
	public void initial() throws IOException
	{
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/Live_SmokeTest_Result " +System.currentTimeMillis()+  ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		logger = report.createTest("Smoke Test");
		sheet = new Excelsheetdata();
		config = new Config();
		
		
	
	}
	//change ccu
	
	@BeforeTest(alwaysRun = true)
	public void setup() throws IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException, InterruptedException
	{
		
	    driver = Browsers.startapplication(driver, config.Browser(), config.URl());
		//driver = Browsers.startapplication(driver, config.Browser(), config.URL2());
		//driver = Browsers.startapplication(driver, config.Browser(), config.URL3());
		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
       String date = DATE_FORMAT.format(today);
		String SystemName=InetAddress.getLocalHost().getHostName();
		Sysout("Commusoft Web-Automation Started in :   "+SystemName +""+"Date:"+""+ date );
		Systemout("Commusoft Web-Automation Started in :   "+SystemName +""+"Date:"+""+ date );
//		SlackCommusoft();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(sheet.sheetIN("Login",0, 1),sheet.sheetIN("Login",1, 1),sheet.sheetIN("Login", 2, 1));
		Thread.sleep(1000);
		driver.navigate().refresh();
		homepage = driver.getCurrentUrl();
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, "Method Been Executed Sucessfully:-" +result.getName());
			System.out.println( "Method Been Executed Sucessfully:-" +result.getName());
			Sysout("Method Been Executed Sucessfully:-" +result.getName());
			Systemout("Method Been Executed Sucessfully:-" +result.getName());
//			SlackCommusoftstatus("Method Been Executed Sucessfully:-" +result.getName());
		}else 
			if(ITestResult.FAILURE==result.getStatus())
		{
				logger.log(Status.FAIL, "Method Been Failed:-" +result.getName());
		//		logger.log(Status.FAIL,logger.addScreenCaptureFromPath(Screenshot.capture(driver))+result.getName());
				logger.fail("Test Failed :- " +result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(driver)).build());
				System.out.println( "Method Been Failed:-" +result.getName());
				Sysout("Method Been Failed:-" +result.getName());
				Systemout("Method Been Failed:-" +result.getName());
//				SlackCommusoftstatus("Method Been Failed:-" +result.getName());
			//	logger.log(Status.FAIL,logger.addScreenCaptureFromPath( capture(driver)) +"  Method Name:- " + result.getName());
		}else
		{
			logger.log(Status.SKIP, "Method been Skiped");
			logger.skip(result.getThrowable());
		}
		
	}
	@AfterSuite
	public void tearDown() throws IOException{
		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
       String date = DATE_FORMAT.format(today);
		Sysout("Commusoft Web-Automation Completed in :   "+InetAddress.getLocalHost().getHostName()+""+"Date:"+""+ date);
		Systemout("Commusoft Web-Automation Completed in :   "+InetAddress.getLocalHost().getHostName()+""+"Date:"+""+ date);
		SlackCommusoftdone(InetAddress.getLocalHost().getHostName());
		
		report.flush();
//		System.out.println("Script completed, Closing the browser...");
//		driver.close();
	   }

}
