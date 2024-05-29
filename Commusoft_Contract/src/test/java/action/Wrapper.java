package action;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Wrapper {

	 public static WebDriver driver; 
	 public JavascriptExecutor js;
	 
	 
	 public String contractwebcustomerno;
		public String ContractName;
	 public long totalTime;
	 public static String Location;
	 public String formattedDate;
	 public String customerpage;
	 public String contractcustomerpage;
	 public String WA;
	 public String WAName;
	 public String WAAccountNumber;
	 public String CustomerName;
	 public String AccountNumber;
	 public final Logger log4j = LogManager.getLogger(Baseclass.class);
	 
	 public static String invoicenumber2;
	 public static String subtotalvalue;
	 public static String totalprice;
	 public static String vat;
	 public static String grandtotal;
	 public static String invoicetype;
	 public static String additionalinvoice="Additional invoice";
	 public static String[] splitadditionalinvoice=additionalinvoice.split(" invoice");
	 public static String interiminvoice="Interim invoice";
	 public static String[] splitinteriminvoice=interiminvoice.split(" invoice");
	 public static String prefinalinvoice="Pre-final invoice";
	 public static String[] splitprefinalinvoice=prefinalinvoice.split(" invoice");
	 public static String[] SplitPrefinalInvoice=splitprefinalinvoice[0].split("-");
	 public static String finalinvoice="Final invoice";
	 public static String[] splitfinalinvoice=finalinvoice.split(" invoice");
	 public static String unit;
	 public static String vatpercentageforbreakdown;
	 public static String totalforbreakdown;
	 public static String vatforbeakdown;
	 public static String grandtotalforbreakdown;
	 public static String quan;
	 public static String customernumber;
	 public String creatcus="//span[text()='New Private customer']";
	 public String CUSTOMERNUMBER="3529";
	 public String EditUnitPrice="200";
	 public static String invoicenumber1;
	 public static String jobcosttabpage;
	public void type(String xpath, String value)
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).sendKeys(value);
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).sendKeys(value); 
			 }
			 else if(xpath.contains("~"))
			 {
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).sendKeys(value);
			 }
			 else
			 {
				 driver.findElement(By.xpath(xpath)).sendKeys(value);
			 }
		}
	}
	
	public  boolean clickElementIfClickable(WebDriver driver, By locator) {
        try {
            // Wait for the element to be clickable
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            // Click the element using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            return true;
        } catch (Exception e) {
            // Handle the case where the element is not clickable
            return false;
        }}
	
	public void Enterkey()
	{
		Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);
	}
		public void type(String xpath, CharSequence[] value)
		{
			{
				 if(xpath.contains("$"))
				 {
					 xpath = xpath.replace("$", "");
					 driver.findElement(By.name(xpath)).sendKeys(value);
					 
				 }
				 else if(xpath.contains("#"))
				 {
					 xpath = xpath.replace("#", "");
					driver.findElement(By.id(xpath)).sendKeys(value); 
				 }
				 else if(xpath.contains("~"))
				 {
					 xpath = xpath.replace("~", "");
					 driver.findElement(By.className(xpath)).sendKeys(value);
				 }
				 else
				 {
					 driver.findElement(By.xpath(xpath)).sendKeys(value);
				 }
		}
	}
	
	
	public void click(String option)
	{
		{
			 if(option.contains("$"))
			 {
				 option = option.replace("$", "");
				 driver.findElement(By.name(option)).click();
				 
			 }
			 else if(option.contains("#"))
			 {
				 option = option.replace("#", "");
				driver.findElement(By.id(option)).click(); 
			 }
			 else if(option.contains("~"))
			 {
				  option = option.replace("~", "");
				 driver.findElement(By.className(option)).click();
			 }
			 else
			 {
				 //option = option.replace("//", "");
				 driver.findElement(By.xpath(option)).click();
			 }
	}
		
		
		
	}
	public void mainclick(String option)
	{
		int attempt = 1;
        String message = null;
        do {
        	
        	
            try {
                WebElement button = driver.findElement(By.xpath(option));
                try {
                Thread.sleep(1000);
                }catch(Exception e)
                {
                	
                }
                button.click();
            } catch (Exception e) {
            	System.out.println("Click Catch");
                System.out.println("Attempt " + attempt + ": Exception caught - " + e.getMessage());
//                System.out.println("ATTEMPT "+attempt+ " FAILED. RETRYING....");
                message = e.getMessage();
                attempt++;
            }
        } while (message !=null && message.contains("no such element"));






	}
	
	
	public void Sysout(String text)
	{
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
		String apiToken = "896751198:AAE9Xnl-I9yRLETN_l_p1zr06_Fr_SEWXEU";
		String chatId = "-760145184";
		urlString = String.format(urlString, apiToken, chatId, text);
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			InputStream is = new BufferedInputStream(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Systemout(String text)
	{
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
		String apiToken = "896751198:AAE9Xnl-I9yRLETN_l_p1zr06_Fr_SEWXEU";
		String chatId = "-697914350";
		urlString = String.format(urlString, apiToken, chatId, text);
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			InputStream is = new BufferedInputStream(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void clear(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).clear();
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).clear(); 
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).clear();
			 }
			 else
			 {
				 iwait();
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).clear();
			 }
	}
	}
	
	
	public void selectdropdown(String xpath, String value)
	{
		if(xpath.contains("#"))
		{
			xpath = xpath.replace("#", "");
			Select sc = new Select(driver.findElement(By.id(xpath)));
			sc.selectByVisibleText(value);
		}else
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				Select sc = new Select(driver.findElement(By.name(xpath)));
				sc.selectByVisibleText(value);
			}else
			{
				Select fcc = new Select(driver.findElement(By.xpath(xpath)));
				fcc.selectByVisibleText(value);
			}
		
	}
	public void selectdropdownvalue(String xpath, String value)
	{
		if(xpath.contains("#"))
		{
			xpath = xpath.replace("#", "");
			Select sc = new Select(driver.findElement(By.id(xpath)));
			sc.selectByValue(value);
		}else
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				Select sc = new Select(driver.findElement(By.name(xpath)));
				sc.selectByValue(value);
			}else
			{
				Select fcc = new Select(driver.findElement(By.xpath(xpath)));
				fcc.selectByValue(value);
			}
			
		iwait();
	}
	public void selectdropdownindex(String xpath, int value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.selectByIndex(value);
	
		iwait();
	}
	
	public String gettext(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public void deselectdropdown(String xpath, String value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.deselectByVisibleText(value);
		iwait();
	}
	
	public void isdisplayed(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).isDisplayed();
				
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isDisplayed(); 
				
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).isDisplayed();
				
			 }
			 else
			 {
				 iwait();
				// xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isDisplayed();
				
			 }
         }
	}
	public void isenabled(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).isEnabled();
				
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isEnabled(); 
		
			 }
			 else if(xpath.contains("."))
			 {
				  xpath = xpath.replace(".", "");
				 driver.findElement(By.className(xpath)).isEnabled();
				
			 }
			 else
			 {
				// xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isEnabled();
				
			 }
         }
	}
	public void isselected(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).isSelected();
			
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isSelected(); 
		
			 }
			 else if(xpath.contains("~"))
			 {
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).isSelected();
				
			 }
			 else
			 {
				// xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isSelected();
			
			 }
         }
	}
	public void getattribute(String xpath , String attributename, String value )
	
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 String temp;
				 temp = driver.findElement(By.name(xpath)).getAttribute(attributename);
				 			 
				 if(temp.equals(value))
				 {
					 System.out.println("Value is Fine");
				 }else
				 {
					 System.out.println("Need to check the validation");
				 }
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				 String temp;
				 temp = driver.findElement(By.id(xpath)).getAttribute(attributename);
				 			 
				 if(temp.equals(value))
				 {
					 System.out.println("Value is Fine");
				 }else
				 {
					 System.out.println("Need to check the validation");
				 }
			 }else if(xpath.contains("~"))
			 {
				 xpath = xpath.replace("~", "");
				 String temp;
				 temp = driver.findElement(By.className(xpath)).getAttribute(attributename);
				 			 
				 if(temp.equals(value))
				 {
					 System.out.println("Value is Fine");
				 }else
				 {
					 System.out.println("Need to check the validation");
				 }
			 }else
			 {
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isDisplayed();
				
			 }
        }
	}
	public void framein(String value)
	{
		iwait();
		driver.switchTo().frame(value);
		iwait();
	}
	public void frameout()
	{
		iwait();
		driver.switchTo().defaultContent();
		iwait();
	}
	
	


	public void typeenter(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).sendKeys(Keys.ENTER);
				 iwait();
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).sendKeys(Keys.ENTER); 
				iwait();
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).sendKeys(Keys.ENTER);
				 iwait();
			 }
			 else
			 {
				 iwait();
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
			 }
	}
	}
	
	public void iwait()
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	public void dclick(String xpath)
	{
		iwait();
		if(xpath.contains("$"))
		 {
			 xpath = xpath.replace("$", "");
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.name(xpath));
		actions.doubleClick(elementLocator).perform();
		iwait();
		 }
		else if(xpath.contains("#"))
		 {
			iwait();
			 xpath = xpath.replace("#", "");
			 Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.id(xpath));
				actions.doubleClick(elementLocator).perform(); 
		 }
		 else if(xpath.contains("~"))
		 {
			 xpath = xpath.replace("~", "");
			 Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.className(xpath));
				actions.doubleClick(elementLocator).perform();
		 }
		 else
		 {
			 //xpath = xpath.replace("//", "");
			 Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.xpath(xpath));
				actions.doubleClick(elementLocator).perform();
		 }
	}
	
	
		public String geturl(String value)
		{
			value = driver.getCurrentUrl();
		
		return geturl(value);
		}

		
		public void dd(String one, String two )
		{
			WebElement from = driver.findElement(By.xpath("+one+"));
			WebElement	To = driver.findElement(By.xpath("+two+"));
			
			Actions drag = new Actions(driver);
			drag.dragAndDrop(from,To).build().perform();
		}
		public void scrolltoWebElement(String name)
		{
			WebElement Element = driver.findElement(By.xpath(name));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		public void tab(String windowHandle1)
		{
			windowHandle1 = driver.getWindowHandle();
			driver.switchTo().window(windowHandle1);
			
		}

	public void Eewait(String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		 if(xpath.contains("$"))
		 {
			 iwait();
			 xpath = xpath.replace("$", "");
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.name(xpath)));
			// driver.findElement(By.name(xpath)).sendKeys(Keys.ENTER);
			 iwait();
		 }
		 else if(xpath.contains("#"))
		 {
			 iwait();
			 xpath = xpath.replace("#", "");
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(xpath)));
		//	driver.findElement(By.id(xpath)).sendKeys(Keys.ENTER); 
			iwait();
		 }
		 else if(xpath.contains("~"))
		 {
			 iwait();
			 xpath = xpath.replace("~", "");
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.className(xpath)));
		//	 driver.findElement(By.className(xpath)).sendKeys(Keys.ENTER);
			 iwait();
		 }
		 else
		 {
			 iwait();
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		//	 driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
		 }
		
	}
	
	public void perform(String xpath , String ypath)
	{
		long start = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, 20);
					
		click(xpath);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ypath)));
		
		long finish = System.currentTimeMillis();
		totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime); 
		
		
	} 
	public void ExplicitWait_PresenceOfEle(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	public void ExplicitWait_VisibilityOfEle(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

	}

	public void ExplicitWait_ElementToBeClickable(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public void getCurrentTimeUsingDate() {
	    Date date = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    formattedDate= dateFormat.format(date);
	    System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
	}
	public void Assertion(String ER , String AR, String R)
	{
		Assert.assertEquals(AR, ER,R);
	}
	public void SlackCommusoft() throws IOException
	{
		String SystemName=InetAddress.getLocalHost().getHostName();
		URL url = new URL("https://hooks.slack.com/services/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");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-type", "application/json");
		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
       String date = DATE_FORMAT.format(today);
		String data = "{\r\n"
				+ "	\"attachments\": [\r\n"
				+ "		{\r\n"
				+ "			\"color\": \"#f2c744\",\r\n"
				+ "			\"blocks\": [\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"header\",\r\n"
				+ "					\"text\": {\r\n"
				+ "						\"type\": \"plain_text\",\r\n"
				+ "						\"text\": \"Commusoft Automation\",\r\n"
				+ "						\"emoji\": true\r\n"
				+ "					}\r\n"
				+ "				},\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"fields\": [\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Platform:*\\nWeb-Chrome\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Created in:*\\n"+SystemName+"\"\r\n"
				+ "						}\r\n"
				+ "					]\r\n"
				+ "				},\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"fields\": [\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Date:*\\n"+date+"\"\r\n"
				+ "						}\r\n"
				+ "					]\r\n"
				+ "				}\r\n"
				+ "			]\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();

	}
	public void SlackCommusoftstatus(String text) throws IOException
	{
		String SystemName=InetAddress.getLocalHost().getHostName();
		URL url = new URL("https://hooks.slack.com/services/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");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-type", "application/json");
		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
       String date = DATE_FORMAT.format(today);
		String data = "{\r\n"
				+ "	\"attachments\": [\r\n"
				+ "		{\r\n"
				+ "			\"color\": \"#f2c744\",\r\n"
				+ "			\"blocks\": [\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"fields\": [\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Case:*\\n"+text+"\"\r\n"
				+ "						}\r\n"
				+ "					]\r\n"
				+ "				}\r\n"
				+ "			]\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();


	}
	
	public void SlackCommusoftdone(String text) throws IOException
	{
		String SystemName=InetAddress.getLocalHost().getHostName();
		URL url = new URL("https://hooks.slack.com/services/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");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-type", "application/json");
		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
       String date = DATE_FORMAT.format(today);
		String data = "{\r\n"
				+ "	\"attachments\": [\r\n"
				+ "		{\r\n"
				+ "			\"color\": \"#F2C744\",\r\n"
				+ "			\"blocks\": [\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"header\",\r\n"
				+ "					\"text\": {\r\n"
				+ "						\"type\": \"plain_text\",\r\n"
				+ "						\"text\": \"Automation Completed\",\r\n"
				+ "						\"emoji\": true\r\n"
				+ "					}\r\n"
				+ "				},\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"fields\": [\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Platform:*\\nWeb-Chrome\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Created in:*\\n"+SystemName+"\"\r\n"
				+ "						}\r\n"
				+ "					]\r\n"
				+ "				},\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"fields\": [\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Date:*\\n"+date+"\"\r\n"
				+ "						}\r\n"
				+ "					]\r\n"
				+ "				}\r\n"
				+ "			]\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();


	}
	
	public void user_name()
	{
		HashMap<String,String> usermap = new HashMap<String,String>();
		usermap.put("Ranjit", "ranjit_welcome123");
		usermap.put("Karna", "karna_demo123");
		usermap.put("Bala", "bala_bala@123");
		usermap.put("Ezhil", "ezhil_ezhil123");
		
		
	}
	
	public void FiveSec() 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ThreeSec() 
	{

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void TwoSec() 
	{

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void EightSec() 
	{

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void ExplicitWait_ForElementToBeClickable(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	public void ExplicitWait_ForPresenceOfElement(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	public void ExplicitWait_ForVisibilityOfElement(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	public void ExplicitWait_ForTextToBePresent(String xpath, String text) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
	}

	public void Hit_Enter() 
	{
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void ActionClick(String xpath) 
	{
		Actions actions = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath(xpath));
		actions.moveToElement(findElement).click(findElement).build().perform();
	}
	public void JavaClick(String xpath) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement findElement = driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].scrollIntoView()", findElement);
		js.executeScript("arguments[0].click()", findElement);
	}
	public void ActionDoubleClick(String xpath) 
	{
		Actions actions = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath(xpath));
		actions.moveToElement(findElement).doubleClick(findElement).build().perform();
	}

}
