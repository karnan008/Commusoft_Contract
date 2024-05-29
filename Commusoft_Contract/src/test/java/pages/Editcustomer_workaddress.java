package pages;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import action.Wrapper;

public class Editcustomer_workaddress extends Wrapper {




	public Editcustomer_workaddress (WebDriver ldriver)
	{
		this.driver = ldriver;
	}

	public HashMap<String,String> customername()
	{
		HashMap<String,String> customer = new HashMap<String,String>();
		customer.put("Karna", "Karnan_Athisivam_karnan@commusoft.com_8248724397_Chennai");
		customer.put("WA", "Work_Address_WA@commusoft.com_8248724397_Madras");
		
		return customer;
		
	}
		String a = customername().get("Karna");
		String Karna[] = a.split("_");


		public void View_customer()
		{
			click("//a [@id='Name']");
		}

		public void Editcustomer_link() throws InterruptedException
		{

			click("//a[@class='pointer-curser text-color float-right']");
			Thread.sleep(3000);
		}
		public void Editcustomer_title() throws InterruptedException


		{
			click ("(//select[@class='full-width-select ng-untouched ng-pristine ng-valid'])[1]");
			Thread.sleep(3000);
			click("//option [text() = 'Dr']");
		}
		public void Editcustomer_Name() throws InterruptedException
		{
			clear("(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[1]");
			Thread.sleep(3000);
			type("(//input[@class='form-control ng-pristine ng-valid ng-touched'])[1]", "Ezhil ");
		}
		public void Unique_Editcustomer_Name()
		{
			String name = Karna[0] + new Random().nextInt(1000);
			clear("//input [@id='name']");
			type("//input [@id='name']", name);
		}

		public void Editcustomer_SurName() throws InterruptedException
		{
			clear("(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[1]");
			Thread.sleep(3000);
			type("(//input[@class='form-control ng-pristine ng-valid ng-touched'])[1]", "Raja");
		}
		public void Unique_Editcustomer_SurName()
		{
			String name = Karna[1] + new Random().nextInt(1000);
			clear("//input [@name='customerDetails.surname']");
			type("//input [@name='customerDetails.surname']", name);
		}
		public void Editcustomer_Mobile() throws InterruptedException
		{
			clear("//input[@formcontrolname='mobile']"); 
			Thread.sleep(3000);
			type("//input[@formcontrolname='mobile']", "97899599678");
		}
		public void Unique_Editcustomer_Mobile()
		{
			String name = Karna[3] + new Random().nextInt(1000);
			clear("//input [@name='customerMobileNumber']");
			type("//input [@name='customerMobileNumber']", name);
		}
		public void Editcustomer_email() throws InterruptedException
		{
			clear("(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[1]");
			Thread.sleep(3000);
			type("(//input[@class='form-control ng-pristine ng-valid ng-touched'])[1]", "eezhilraja@commusoft.com");
		}
		public void Unique_Editcustomer_email()
		{
			Random randomGenerator = new Random();  
			int name = randomGenerator.nextInt(1000);
			clear("//input [@name='customerEmail']");
			type("//input [@name='customerEmail']", "karna"+name+"@commusoft.com");
		}
		public void Editcustomer_AddressLine1() throws InterruptedException
		{
			click("(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[1]");
			Thread.sleep(3000);
			type("//input[@formcontrolname='addressline1']","Thirumazhisai");
			
		}
		public void Unique_Editcustomer_AddressLine1()
		{
			String name = Karna[4] + new Random().nextInt(1000);
			type("//input [@name='addressline1']", name);
		}
		public void Editcustomer_Save() throws InterruptedException
		{
			Thread.sleep(1000);
			click("//button [@class='btn btn-primary loading_btn save_btn']");
		}


	public void EditWorkaddress_view()
	{
		click ("//span [text() = 'View']");
	}

	public void Edit_workaddress()
	{
		click("(//a[@class='pointer-curser text-color float-right'])[2]");

	}

	public void Edit_WAtitle()
	{
		//click("#title");
		//click("//select[@formcontrolname='settingsTitlesid']");
		Select value = new Select(driver.findElement(By.xpath("//select[@formcontrolname='settingsTitlesid']")));
		value.selectByValue("3");

	}

	public void Edit_waname()
	{
		click("//input[@formcontrolname='name']");
		type("//input[@formcontrolname='name']", "WA ezhilraja");

	}
	public void Unique_Edit_waname()
	{
		String name = Karna[0] + new Random().nextInt(1000);
		click("#name");
		clear("#name");
		type("#name", name);

	}
	public void Edit_wasurname()
	{
		clear ("//input[@formcontrolname='surname']");
		type("//input[@formcontrolname='surname']","elango");

	}
	public void Unique_Edit_wasurname()
	{
		String name = Karna[1] + new Random().nextInt(1000);
		clear ("$customerDetails.surname");
		type("$customerDetails.surname",name);

	}

	public void Edit_walandline()
	{

		clear("//input[@formcontrolname='landline']");
		type("//input[@formcontrolname='landline']","04426120526");

	}
	public void Unique_Edit_walandline()
	{

		clear("$customerLandlineNumber");
		type("$customerLandlineNumber","04426120526");

	}

	public void Edit_wamobile()

	{
		clear("//input[@formcontrolname='mobile']");	
		type("//input[@formcontrolname='mobile']","9789929937");

	}
	public void Unique_Edit_wamobile()

	{
		clear("$customerMobileNumber");	
		type("$customerMobileNumber","8888888888");

	}

	public void Edit_waemail()

	{
		clear ("//input[@formcontrolname='email']");
		type  ("//input[@formcontrolname='email']","eezhilraja@commusoft.com");

	}
	public void Unique_Edit_waemail()

	{
		Random randomGenerator = new Random();  
		int name = randomGenerator.nextInt(1000);
		clear ("$customerEmail");
		type  ("$customerEmail","karnan"+name+"@commusoft.com");

	}

	public void Edit_waaddress1()
	{
		clear("//input[@formcontrolname='addressline1']");
		type("//input[@formcontrolname='addressline1']","Demo1");
	}
	public void Unique_Edit_waaddress1()
	{
		Random randomGenerator = new Random();  
		int name = randomGenerator.nextInt(1000);
		clear("$addressline1");
		type("$addressline1","Chenani"+name);
	}

	public void Edit_wasavebutton()
	{
		click("//button [@class='btn btn-primary loading_btn save_btn']");

	}


}





