package action;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import pages.LoginPage;
import utility.Browsers;
import utility.Config;
import utility.Excelsheetdata;
import utility.PerformanceMetrics;
import utility.Screenshot;

public class Baseclass extends Wrapper {
	
	public Object driverOrPage; 
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
	public void initial() throws IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException, InterruptedException
	{

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/Live_SmokeTest_Result " +System.currentTimeMillis()+  ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		logger = report.createTest("Smoke Test");
		sheet = new Excelsheetdata();
		config = new Config();
		setDriverContext("selenium");
		setDriverContext("karna");

	}
	@BeforeSuite(alwaysRun = true)
	public void initializeDrivers() throws IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException, InterruptedException 
	{
		setDriverContext("selenium");
		setDriverContext("karna");
	}


	@BeforeTest(alwaysRun = true)
	public void setup() throws IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException, InterruptedException
	{
		config = new Config();
		sheet = new Excelsheetdata();
		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
		String SystemName=InetAddress.getLocalHost().getHostName();
		Sysout("Commusoft Web-Automation Started in :   "+SystemName +""+"Date:"+""+ date );
		Systemout("Commusoft Web-Automation Started in :   "+SystemName +""+"Date:"+""+ date );


	}
	public void setDriverContext(String driverType) throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException {
		if (driverType.equalsIgnoreCase("karna")) {
			if (playwright == null) {

				//Windows
								playwright = Playwright.create();
								browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
									    .setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"))
									    .setHeadless(false));

				//Mac
//				playwright = Playwright.create();
//				browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				context = browser.newContext(new Browser.NewContextOptions().setViewportSize(screenSize.width, screenSize.height));
				page = context.newPage();
				
				page.setDefaultNavigationTimeout(90000); 
		        page.setDefaultTimeout(90000); 
				// Add onLoad listener
				page.onLoad((p) -> {
					double loadTime = getPageLoadTime(p);
					PerformanceMetrics perform = new PerformanceMetrics();    		
					perform.writeToFile("(page)Page loaded: " + p.url() + " | Load Time: " + loadTime + " seconds");
				});
				page.onFrameNavigated(frame -> {
					if (frame == page.mainFrame()) {
						double loadTime = getPageLoadTime(page);
						PerformanceMetrics perform = new PerformanceMetrics();    		
						perform.writeToFile("(page)Frame navigated to: " + frame.url() + " | Load Time: " + loadTime + " seconds");
					}
				});
				page.navigate(config.URl());//live
//				page.navigate(config.URL2());//stgae2
//				page.navigate(config.URL3());//stage

			}
			driverOrPage = page; // Set the current context to Playwright
		} else if (driverType.equalsIgnoreCase("selenium")) {
			if (driver == null) {
				driver = Browsers.startapplication(driver, config.Browser(), config.URl());
				PerformanceMetrics perform = new PerformanceMetrics();

					    		//driver = Browsers.startapplication(driver, config.Browser(), config.URL2());
				//	    		driver = Browsers.startapplication(driver, config.Browser(), config.URL3());
				LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
				loginpage.login(sheet.sheetIN("Login",0, 1),sheet.sheetIN("Login",1, 1),sheet.sheetIN("Login", 2, 1));
				Thread.sleep(1000);
				perform.driverPageTime(driver, "(selenium)Home screen");
				driver.navigate().refresh();
				homepage = driver.getCurrentUrl();

			}
			driverOrPage = driver; // Set the current context to Selenium
		} else {
			throw new IllegalArgumentException("Unsupported driver type: " + driverType);
		}
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
		}else 
			if(ITestResult.FAILURE==result.getStatus())
			{
				logger.log(Status.FAIL, "Method Been Failed:-" +result.getName());

				String screenshotPath = Screenshot.capture(driverOrPage, result.getName());
				if (screenshotPath != null) {
					logger.fail("Test Failed: " + result.getName(),
							MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				} else {
					logger.fail("Test Failed: " + result.getName() + " (Screenshot capture failed).");
				}
				System.out.println( "Method Been Failed:-" +result.getName());
				Sysout("Method Been Failed:-" +result.getName());
				Systemout("Method Been Failed:-" +result.getName());
			}else
			{
				logger.log(Status.SKIP, "Method been Skiped");
				//				logger.skip(result.getThrowable());
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
	}
	public void Kick_Stop_Playwright()
	{
		System.out.println("Press Enter to close the browser...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		browser.close(); 
	}
	private double getPageLoadTime(Page p) {
		Number loadTime = (Number) p.evaluate("() => { const { navigationStart, loadEventEnd } = window.performance.timing; return loadEventEnd - navigationStart; }");
		return loadTime.doubleValue() / 1000.0;  // Convert milliseconds to seconds
	}







}
