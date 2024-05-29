package utility;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.testproject.sdk.drivers.ReportType;
//import io.testproject.sdk.drivers.web.ChromeDriver;
//import io.testproject.sdk.internal.exceptions.AgentConnectException;
//import io.testproject.sdk.internal.exceptions.InvalidTokenException;
//import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;

public class Browsers {

	
	public static WebEventListener webEventListener;
	public static EventFiringWebDriver eventFiringWebDriver;
	
	public static WebDriver startapplication(WebDriver driver,String browser, String URL) throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException
	{
		if(browser.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();

			ChromeDriverService service = new ChromeDriverService.Builder()
					.usingAnyFreePort().build();
			service.start();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--detach");

			driver = new ChromeDriver(service, options);
			
			
			

		}else
			if(browser.contains("firefox"))
			{
				//	System.setProperty("webdriver.","./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else
				if(browser.contains("Edge"))
				{
					System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
					driver = new EdgeDriver();
				}
		
		webEventListener = new WebEventListener();
	    eventFiringWebDriver = new EventFiringWebDriver(driver);
	    eventFiringWebDriver.register(webEventListener);
	    driver=eventFiringWebDriver;
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		return driver;
	}
	

}
