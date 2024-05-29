package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import action.Wrapper;

public class NotesandCommunication extends Wrapper {
	
	public NotesandCommunication(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	public void emailinvoice() throws InterruptedException
	{
		Thread.sleep(3000);
		click("//a[text()='Email invoice']");
		Thread.sleep(2000);
		selectdropdown("//select[@ng-model='email.selected_recipient_address']","eezhilraja@commusoft.com");
		Thread.sleep(1000);
		click("(//a[@ng-click='sendEmail()'])[2]");
		Thread.sleep(4000);
	}
	public void printinvoice() throws InterruptedException
	{
		Thread.sleep(3000);
		click("//a[@ng-click='showPrintInvoice()']");
		Thread.sleep(2000);
		click("//button[@ng-click='print()']");
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}
	public void click_notes_and_communications_invoice()
	{
		click("//span[text()='Notes & communications']");
		
	}

	public void emailinvoice1() throws InterruptedException
	{
		Thread.sleep(3000);
		click("//a[text()='Email invoice']");
		selectdropdown("//select[@ng-model='email.selected_recipient_address']","estimateemail@yopmail.com");
		Thread.sleep(1000);
		click("(//a[@ng-click='sendEmail()'])[2]");	
		Thread.sleep(4000);
	}
}
