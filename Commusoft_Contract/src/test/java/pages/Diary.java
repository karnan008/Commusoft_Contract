package pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import action.Wrapper;
import junit.framework.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Diary extends Wrapper {
    public Diary(WebDriver ldriver)
    {
        this.driver = ldriver;
        ldriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
    }
    public void Diary_Module()
    {
        click("//a[text()='Diary']");
    }
    
    public void Diary_Daily()
    {
        try
        {
        click("//button[text()='Daily']");
        }catch(Exception e)
        {
            
        }
        
    }
    public void Diary_Today() throws InterruptedException
    {
        Thread.sleep(3000);
        try {
            click("//a[text()='Today']");
            Thread.sleep(3000);
            click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
            Thread.sleep(3000);
        }catch(Exception e)
        {
            Thread.sleep(3000);
            click("(//a[@class='icon ss-navigateright'])[1]");
            Thread.sleep(3000);
            click("//a[text()='Today']");
            Thread.sleep(3000);
        }
        driver.navigate().refresh();
    }
    public void Diary_PM()  
    {
        click("(//div[@class='fc-row fc-week fc-widget-content'])[2]/div/table/tbody/tr/td[2]");
    }
    
    public void Diary_EventFromJob() throws InterruptedException
    {
        Thread.sleep(3000);
        click("//button[@ng-click='saveDiaryEvent()']");
    }
    
    public void Diary_Timing()
    {
        click("(//td[@class='fc-widget-content'])[21]");
    }
    public void Diary_Timing1()
    {
        click("(//td[@class='fc-widget-content'])[11]");
    }
    public void Diary_Timing2()
    {
        click("(//td[@class=\"fc-widget-content\"])[13]");
    }
    public void Diary_Timing3()
    {
        click("(//td[@class='fc-widget-content'])[34]");
    }
    //------------Customer--> Job--> Select diary check box
    
    public void Customer_job_Diary_Timing()
    {
        click("(//td[@class='fc-widget-content'])[20]");
        
    }
    public void Customer_job_Diary_Timing_2()
    {
        click("(//td[@class='fc-widget-content'])[21]");
        
    }
    public void Customer_job_Diary_Timing_3()
    {
        click("(//td[@class='fc-widget-content'])[22]");
        
    }
//  public void Customer_job_Diary_Timing_Change() throws InterruptedException
//  {
//      click("//span[@class='add-on date-picker-edit']");
//      Thread.sleep(3000);
//      click("(//a[@class='daterange-day ng-binding'])[21]");
//      
//      //click("//select[@name='allDayValue']");
//      Thread.sleep(3000);
//      click("(//select[@class='hour-min ng-pristine ng-valid'])[1]");
//      Thread.sleep(3000);
//      click("(//option[text()='02'])[1]");
//      Thread.sleep(3000);
//      click("(//select[@class='hour-min ng-pristine ng-valid'])[1]");
//      Thread.sleep(3000);
//      click("(//option[text()='15'])[2]");
//      Thread.sleep(3000);
//      click("(//select[@class='diary-time-meridian ng-pristine ng-valid'])[1]");
//      Thread.sleep(3000);
//      click("(//option[text()='AM']");
//      Thread.sleep(3000);
//      click("(//select[@class='hour-min ng-pristine ng-valid'])[1]");
//      Thread.sleep(3000);
//      click("(//option[text()='02'])[1]");
//      Thread.sleep(3000);
//      click("(//select[@class='hour-min ng-pristine ng-valid'])[1]");
//      Thread.sleep(3000);
//      click("(//option[text()='15'])[2]");
//      Thread.sleep(3000);
//      click("(//select[@class='diary-time-meridian ng-pristine ng-valid'])[1]");
//      Thread.sleep(3000);
//      click("(//option[text()='AM']");
//      
//  }
    public void Customer_job_Diary_Timing_savebutton() throws InterruptedException
    {
    	Thread.sleep(2000);
        click("//button[@class='btn btn-primary']");
    }
    //-------------------
    public void Diary_Normal_EvenDescription()
    {
        type("//input[@name='description']", "Normal Event");
    }
    public void Diary_Save()  //used to clik on save button on create diary event side panel
    {
        click("(//span[text()='Save'])[2]");
    }
    public void Diary_Estimate()
    {
        click("(//div//a[@class=\"btn ng-scope\"])[1]");
    }
    public void Diary_job()
    {
        click("//a[text()='Job']");
    }
    public void Diary_propertysearch() throws InterruptedException
    {
        type("//input[@id='top-input-in-event-type']", "Ranjit");
        typeenter("//input[@id='top-input-in-event-type']");
        Thread.sleep(5000);
        click("(//input[@name='selected_property'])[1]");
        Thread.sleep(5000);
    }
    public void Diary_propertysearch(String name) throws InterruptedException
    {
        type("//input[@id='top-input-in-event-type']", name);
        typeenter("//input[@id='top-input-in-event-type']");
        Thread.sleep(5000);
        click("(//input[@name='selected_property'])[1]");
        Thread.sleep(5000);
    }
    public void Diary_Estimate_EventDescription()
    {
        selectdropdownvalue("//select[@ng-change='setEstimateDescription()']", "1");
    }
    public void Diary_Job_EventDescription()
    {
        selectdropdownvalue("//select[@name='description']", "1");
    }
    
    public void Diary_Monthly_view() throws InterruptedException
    {
    click("//button[text()='Monthly']");
    Thread.sleep(4000);
    }
    
    public void Diary_Monthly_Date()
    {
        try
        {
            click("//td[@class='fc-day-top fc-tue fc-today ']");
        }catch(Exception E)
        {
            try
            {
                click("(//td[@rowspan='3'])[6]");
            }
            catch(Exception q)
            {
                try
                {
                    click("(//td[@rowspan='3'])[7]");
                }catch(Exception w)
                {
                    try
                    {
                        click("(//td[@rowspan='3'])[8]");
                    }catch(Exception e)
                    {
                        try
                        {
                            click("(//td[@rowspan='3'])[9]");
                        }catch(Exception r)
                        {
                            try
                            {
                                click("(//td[@rowspan='3'])[10]");
                            }catch(Exception j)
                            {
                                click("(//td[@rowspan='3'])[11]");    
                            }
                        }
                    }
                }}}
                        
    }
    public void Diary_currentdate_datepicker()
    {
        click("//span[@class='ss-calendar']");
        click("//a[@class='daterange-day ng-binding today']");
        
    }
    
    public void Diary_job_AddProperty()
    {
        click("//*[@id=\"page-panel-main\"]/div[2]/div/section[1]/section[2]/div/div/div[2]/a");
        //click("//a[@ng-click='addNewProperty(event_type)']");
    }
    public void Diary_TypesOfProperty()
    {
        selectdropdown("//select[@id='new-property-type-input']","Customer");
    }
    public void Diary_TypesOfCustomer()
    {
        selectdropdownvalue("//select[@ng-change='setCustomerType()']","0");
    }
    public String name(String name)
    {
         DateFormat dateFormat = new SimpleDateFormat("dd-MM");
         Date date = new Date();
         String date1= dateFormat.format(date);
         name = name + date1;
        return name;
    }
    public void Diary_AddProperty_CustomerName()
    {
        type("//input[@ng-model='add_new_customer_inputs.first_name']",name("Ranjit-"));
    }
    public void Diary_AddProperty_CustomerSurName()
    {
        type("//input[@ng-model='add_new_customer_inputs.surname']","Diary");
    }
    public void Diary_AddProperty_CustomerSurName(String Surname)
    {
        type("//input[@ng-model='add_new_customer_inputs.surname']",Surname);
    }
    public void Diary_AddProperty_CustomerEmail()
    {
        type("//input[@ng-model='add_new_customer_inputs.email']","ranjit@commusoft.com");
    }
    public void Diary_AddProperty_CustomerEmail(String Email)
    {
        type("//input[@ng-model='add_new_customer_inputs.email']",Email);
    }
    public void Diary_AddProperty_CustomerAdd1()
    {
        type("//input[@ng-model='add_new_customer_inputs.addrs_1']","Madurai");
    }
    public void Diary_AddProperty_CustomerAdd1(String Email)
    {
        type("//input[@ng-model='add_new_customer_inputs.addrs_1']",Email);
    }
    public void Diary_AddProperty_CustomerSave() throws InterruptedException
    {
        click("//button[@ng-show=\"selected_customer_type == 'new_customer'\"]");
        Thread.sleep(15000);
    }
    public void Diary_PrintJobSheet() throws InterruptedException
    {
        click("//span[text()='Print job sheets']");
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    public void Diary_PrintSummarySheet() throws InterruptedException
    {
        click("//span[text()='Print summary sheets']");
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    
// newly added
    
    public void Diary_recurring()
    {
        click("//input[@ng-model='add_diary_event_form_inputs.is_recurring_event']");
    }
    
    public void Diary_Repeats()
    {
        selectdropdownvalue("(//select[@name='repeats_every'])[1]","Daily");
    }
    
    public void Diary_Repeatsevery()
    {
        selectdropdownvalue("(//select[@name='repeats_every'])[2]","1");
    }
    
    public void Diary_Occurrences()
    {
    	type("//input[@name='occurrences']", "2");
    }
    public void Diary_eventnotes()
    {
        type("//textarea[@ng-model='add_normal_event_inputs.engineer_notes']", "Normal event notes for an engineer");
        
    }
    
    public void Diary_jobeventnotes()
    {
        type("//textarea[@ng-model='add_job_event_inputs.job.engineernotes']", "Normal event notes for an engineer");
        
    }
    
    public void Diary_Notifications()
    {
    	click("//a[contains( text(), 'Notifications')]");
    }
    
    public void Diary_NotifyEng()
    {
    	click("#top-input-in-notifications-step");
    }
    
    public void Diary_Notifymethod() throws InterruptedException
    {
    	
    	click("//select[@name='notification_method']");
    	Thread.sleep(3000);
    	Select s = new Select(driver.findElement(By.xpath("//select[@name='notification_method']")));
    	s.selectByIndex(1);
    
    }
    
    public void Diary_Send_notification() throws InterruptedException
    {
    	click("//select[@name='send_notification']");
    	Thread.sleep(3000);
    	Select s = new Select(driver.findElement(By.xpath("//select[@name='send_notification']")));
    	s.selectByIndex(1);
    	
    }
    
    public void Diary_subject()
    { 
    	driver.switchTo().frame("uiTinymce0_ifr");
    	click("//*[@id='tinymce']");
    	type("//*[@id='tinymce']", "testing");   	
    	//driver.switchTo().defaultContent();
    }
    public void press_tab_key()
    { 
    	   Actions act = new Actions(driver);	   
    	   act.sendKeys(Keys.TAB).build().perform(); 	
    }
    
    public void Diary_message()
    {
    	
    	WebElement iframeElement = driver.findElement(By.id("uiTinymce1_ifr"));
    	//now using the switch command
    	driver.switchTo().frame(iframeElement);
    	type("//*[@id='tinymce']", "testing message"); 
   
    }
    
    public void Quoted_amount()
    {
    type("(//input[@class='input-medium ng-pristine ng-valid'])[1]", "");
    }
    
    public void Customer_reference()
    {
    	type("(//input[@class='input-medium ng-pristine ng-valid'])[2]", "reference text goes here");
    }
    
    public void Diary_Job_Event_Description(String a)
    {
        selectdropdownvalue("//select[@name='description']", a);
    }
    
   public void add_diary_event_button()
   {
	   click ("//a[@class='btn btn-small btn-primary']");
   }
   public void diary_timing11_00pm()
   {
	   click ("(//td[@class='fc-widget-content'])[49]");
   }
   public void diary_weekly()
   {
	   click("//button[text()='Weekly']");
   }
   public void diary_2weekly()
   {
	   click("//button[text()='Two weekly']");
   }
   public void diary_monthly()
   {
	   click("//button[text()='Monthly']");
   }
   public void map() throws InterruptedException
   {
	   click("//button[text()='Map']");
	   WebDriverWait wait=new WebDriverWait(driver,20);
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='leaflet-gl-layer mapboxgl-map']")));
   }
		   public void add_diary_fromjob()
		   {
			   //click("(//a[text()='View'])[5]");
			   click("//a[text()=' View ']");  //(for to make work in new property view)
			   click("(//span[text()='Add new diary event'])");
		   }
		   public void suggested_appointment()
		   {
			   click("//button[text()='Suggested appointment']");
			   
		   }
		   public void select_slot()
		   {
			   click("(//a[@class='btn btn-primary ng-binding'])[1]");  
		   }
		   
		  public void diary_delete()
		  {
			  click("(//a[text()='Edit'])[2]");
			  click("//a[text()='Delete event']");
			  click("//a[text()='Yes']");
		  }
		  
		  
	
}
