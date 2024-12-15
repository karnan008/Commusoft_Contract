package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Pattern;

import org.bouncycastle.tsp.TimeStampResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

import action.Wrapper;

public class playWright extends Wrapper {

	// Arrays of adjectives and nouns
			private static final String[] ADJECTIVES = {
					"Agile1", "Brave1", "Calm1", "Delightful1", "Eager1",
					"Fancy1", "Graceful1", "Humble1", "Innovative1", "Jovial1"
			};

			private static final String[] NOUNS = {
					"Agreement2", "Alliance2", "Charter2", "Covenant2", "Deal2",
					"Pact2", "Treaty2", "Understanding2", "Accord2", "Contract2"
			};

	public playWright(Page kpage)
	{
		this.page = kpage;
	}

	public void playLogin()
	{
		//login
		page.getByPlaceholder("ID").click();
		page.getByPlaceholder("ID").fill("18463");
		page.getByPlaceholder("Username").click();
		page.getByPlaceholder("Username").fill("contract");
		page.getByPlaceholder("Password").click();
		page.getByPlaceholder("Password").fill("demo123");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
		page.waitForSelector("role=link[name='New Private customer']");
		playwrighthome = page.url();
	}
	public void createCustomer() throws InterruptedException
	{
		//create_customer
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("New Private customer")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("-").setExact(true)).click();
		page.locator("#select2-drop").getByText(title).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Surname$"))).getByRole(AriaRole.TEXTBOX).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Surname$"))).getByRole(AriaRole.TEXTBOX).fill(surName);
		page.locator(".phone-number-input").first().click();
		page.locator(".phone-number-input").first().fill("12121212");
		page.locator("div:nth-child(5) > .controls > .phone-number-wrapper > .phone-number-input").click();
		page.locator("div:nth-child(5) > .controls > .phone-number-wrapper > .phone-number-input").fill("34343434");
		page.locator("input[type=\"email\"]").click();
		page.locator("input[type=\"email\"]").fill("karnan@commusoft.com");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Address line 1$"))).getByRole(AriaRole.TEXTBOX).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Address line 1$"))).getByRole(AriaRole.TEXTBOX).fill("Chennai");
		Thread.sleep(8000);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Private customer")).click();
		Thread.sleep(10000);
		PlaywrightAssertions.assertThat(page.locator("a").filter(new Locator.FilterOptions().setHasText("Quick links"))).isVisible();
		playwrightcustomer = page.url();

		playwrightcustomerno = page.locator("//*[@id=\"side-contain\"]/app-sidebar/div[4]/ul[2]/li[2]").innerText();
		System.out.println("Customer No: " + playwrightcustomerno);


	}
	public void createContractCustomer() throws InterruptedException
	{
		//create_customer
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("New Private customer")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("-").setExact(true)).click();
		page.locator("#select2-drop").getByText(title).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Surname$"))).getByRole(AriaRole.TEXTBOX).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Surname$"))).getByRole(AriaRole.TEXTBOX).fill(surName);
		page.locator(".phone-number-input").first().click();
		page.locator(".phone-number-input").first().fill("12121212");
		page.locator("div:nth-child(5) > .controls > .phone-number-wrapper > .phone-number-input").click();
		page.locator("div:nth-child(5) > .controls > .phone-number-wrapper > .phone-number-input").fill("34343434");
		page.locator("input[type=\"email\"]").click();
		page.locator("input[type=\"email\"]").fill("karnan@commusoft.com");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Address line 1$"))).getByRole(AriaRole.TEXTBOX).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Address line 1$"))).getByRole(AriaRole.TEXTBOX).fill("Chennai");
		Thread.sleep(8000);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Private customer")).click();
		Thread.sleep(10000);
		PlaywrightAssertions.assertThat(page.locator("a").filter(new Locator.FilterOptions().setHasText("Quick links"))).isVisible();
		playwrightcontractcustomer = page.url();

		playwrightcontractcustomerno = page.locator("//*[@id=\"side-contain\"]/app-sidebar/div[4]/ul[2]/li[2]").innerText();
		System.out.println("Customer No: " + playwrightcontractcustomerno);


	}
	public void addAsset()
	{
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Assets")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new asset")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("-- Please choose --")).click();
		page.locator("#select2-drop").getByText("System boiler").click();
		page.locator("input[name=\"\\33 cace4d9-b404b327\"]").click();
		page.locator("input[name=\"\\33 cace4d9-b404b327\"]").fill("testing");
		page.getByText("Save Saving").click();
		page.waitForLoadState(LoadState.LOAD); 
		PlaywrightAssertions.assertThat(page.getByText("Asset details Edit")).isVisible();
	}
	public void createJob()
	{
		//create job
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new job")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("-- Please choose --")).click();
		page.locator("#select2-drop").getByText("No Rules").click();
		page.locator("input[name=\"ponumber\"]").click();
		page.locator("input[name=\"ponumber\"]").fill("C+100");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add job")).click();
		playwrightjobno = page.locator("//*[@id=\"main\"]/div[2]/div/ng-container/div[2]/span[1]/div/section/div/div/div[1]/section/div[2]/div/div/div[1]/div/div[1]/div[1]/span[2]").innerText();
		System.out.println("Job No: " + playwrightjobno);

	}
	public void createDraftAdditionalinvoice()
	{
		//invoice-draft
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Invoices")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new invoice")).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).fill("Additional Draft");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please chooseRanjit CategoryAravind CategoryRA categoryTest$"))).getByRole(AriaRole.COMBOBOX).selectOption("1");
		page.getByRole(AriaRole.SPINBUTTON).click();
		page.getByRole(AriaRole.SPINBUTTON).fill("0100");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Advanced options⬇")).click();
		page.locator("fieldset").filter(new Locator.FilterOptions().setHasText("Advanced optionsSave as draft")).getByRole(AriaRole.CHECKBOX).check();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save invoice")).click();
	}
	public void createDraftInteriminvoice() throws InterruptedException
	{
		//invoice-draft
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Invoices")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new invoice")).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please chooseAdditional invoiceInterim invoicePre-final invoiceFinal invoice$"))).getByRole(AriaRole.COMBOBOX).selectOption("interim");
		Thread.sleep(5000);		//page.reload();Thread.sleep(5000);
		//page.navigate("https://app.commusoft.co.uk/customers/customer/"+playwrightcustomerno+"/jobs/"+playwrightjobno+"/invoices/new/interim");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).fill("Interim Draft");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please chooseRanjit CategoryAravind CategoryRA categoryTest$"))).getByRole(AriaRole.COMBOBOX).selectOption("1");
		page.getByRole(AriaRole.SPINBUTTON).click();
		page.getByRole(AriaRole.SPINBUTTON).fill("0100");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Advanced options⬇")).click();
		page.locator("fieldset").filter(new Locator.FilterOptions().setHasText("Advanced optionsSave as draft")).getByRole(AriaRole.CHECKBOX).check();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save invoice")).click(); Thread.sleep(2000);
		PlaywrightAssertions.assertThat(page.getByText("This is a draft invoice", new Page.GetByTextOptions().setExact(true))).isVisible();
	}
	public void createDraftPrefinalinvoice() throws InterruptedException
	{
		//invoice-draft
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Invoices")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new invoice")).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please chooseAdditional invoiceInterim invoicePre-final invoiceFinal invoice$"))).getByRole(AriaRole.COMBOBOX).selectOption("preFinal");
		Thread.sleep(5000);		//page.reload();Thread.sleep(5000);
		//page.navigate("https://app.commusoft.co.uk/customers/customer/"+playwrightcustomerno+"/jobs/"+playwrightjobno+"/invoices/new/preFinal");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).fill("Prefinal Draft");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please chooseRanjit CategoryAravind CategoryRA categoryTest$"))).getByRole(AriaRole.COMBOBOX).selectOption("1");
		page.getByRole(AriaRole.SPINBUTTON).click();
		page.getByRole(AriaRole.SPINBUTTON).fill("0100");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Advanced options⬇")).click();
		page.locator("fieldset").filter(new Locator.FilterOptions().setHasText("Advanced optionsSave as draft")).getByRole(AriaRole.CHECKBOX).check();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save invoice")).click();Thread.sleep(2000);
		PlaywrightAssertions.assertThat(page.getByText("This is a draft invoice", new Page.GetByTextOptions().setExact(true))).isVisible();
	}
	public void createDraftFinalinvoice() throws InterruptedException
	{
		//invoice-draft
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Invoices")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new invoice")).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please chooseAdditional invoiceInterim invoicePre-final invoiceFinal invoice$"))).getByRole(AriaRole.COMBOBOX).selectOption("final");
		Thread.sleep(5000);		//page.reload();Thread.sleep(5000);
		//page.navigate("https://app.commusoft.co.uk/customers/customer/"+playwrightcustomerno+"/jobs/"+playwrightjobno+"/invoices/new/final");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).fill("Final Draft");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please chooseRanjit CategoryAravind CategoryRA categoryTest$"))).getByRole(AriaRole.COMBOBOX).selectOption("1");
		page.getByRole(AriaRole.SPINBUTTON).click();
		page.getByRole(AriaRole.SPINBUTTON).fill("0100");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Advanced options⬇")).click();
		page.locator("fieldset").filter(new Locator.FilterOptions().setHasText("Advanced optionsSave as draft")).getByRole(AriaRole.CHECKBOX).check();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save invoice")).click();Thread.sleep(2000);
		PlaywrightAssertions.assertThat(page.getByText("This is a draft invoice", new Page.GetByTextOptions().setExact(true))).isVisible();
	}
	public void convertDraft() throws InterruptedException
	{
		//draft - normal
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Convert draft to invoice")).click();
		page.locator("#confirm_install_input_on_keypress").click();
		page.locator("#confirm_install_input_on_keypress").fill("save");
		page.getByText("Save draft as invoice", new Page.GetByTextOptions().setExact(true)).click();
		Thread.sleep(3000);

	}
	public void verifyConvertedinvoice(String invoiceName) throws InterruptedException
	{
		PlaywrightAssertions.assertThat(page.getByText("This is a draft invoice", new Page.GetByTextOptions().setExact(true)))
		.isHidden();
		System.out.println(""+invoiceName+" Invoice converted successfully...!!!");
		Thread.sleep(3000);

	}
	public void createEstimate()
	{
		//create estimate
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new estimate")).click();
		page.locator("select[name=\"estimate\\[templateid\\]\"]").selectOption("1");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add estimate")).click();
		PlaywrightAssertions.assertThat(page.locator("#estimate-accept-step")).containsText("Accept / reject");
	}
	public void acceptEstimate() throws InterruptedException
	{
		//accept estimate with split
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("✓  Price £0.00")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("No breakdown Only show the")).click();
		page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("0.00").setExact(true)).dblclick();
		page.locator("#no_breakdown").getByRole(AriaRole.TEXTBOX).fill("90");
		page.locator("#no_breakdown").getByRole(AriaRole.TEXTBOX).press("Tab");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("✓      Invoice schedule ⚠")).click();
		page.locator("td:nth-child(3) > .cell-container").first().dblclick();
		page.locator("#time0row0associated_rows01").fill("30");
		page.getByRole(AriaRole.TABLE).locator("span").filter(new Locator.FilterOptions().setHasText("90.00")).first().dblclick();
		page.locator("#time1row0associated_rows01").fill("30");
		page.locator("tbody:nth-child(4) > .associated-row > td:nth-child(3) > .cell-container").dblclick();
		page.locator("#time2row0associated_rows01").fill("30");
		page.getByText("12 months after completion").click();
		Thread.sleep(3000);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("✓  Send to customer")).click();
		Thread.sleep(3000);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("✓  Accept / reject")).click();
		page.getByRole(AriaRole.CHECKBOX).check();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept")).click();
		page.locator("#mainWindow textarea").click();
		page.locator("#mainWindow textarea").fill("accept the estimate");
		page.locator("#confirm_delete_input").click();
		Thread.sleep(3000);
		String text = "accept";
		for (char c : text.toCharArray()) {
			page.locator("#confirm_delete_input").type(String.valueOf(c), new Locator.TypeOptions().setDelay(100));
		}
		page.locator("#delete-button").click();
	}
	public void verifyJobgeneratedfromEstimate()
	{
		page.locator("text=This job is from an estimate").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		PlaywrightAssertions.assertThat(page.getByText("This job is from an estimate")).isVisible();
	}
	public void verifyVatnotappearonFinalinvoice() throws InterruptedException
	{
		//raise final invoice for the job generated from estimate
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Invoices")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new invoice")).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Copy from job$"))).getByRole(AriaRole.TEXTBOX).fill("Final Invoice ");
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please chooseRanjit CategoryAravind CategoryRA categoryTest$"))).getByRole(AriaRole.COMBOBOX).selectOption("1");
		PlaywrightAssertions.assertThat(page.locator("span").filter(new Locator.FilterOptions().setHasText("Amounts are: VAT ExclusiveVAT")).getByRole(AriaRole.COMBOBOX)).isHidden();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save invoice")).click();Thread.sleep(3000);
		PlaywrightAssertions.assertThat(page.getByText("This is a final invoice for estimate")).isVisible();
	}
	public void salesReport1() throws InterruptedException
	{
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reporting")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).click();
		page.waitForLoadState(LoadState.LOAD); 
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sales").setExact(true)).click();
		page.locator("#sortables-secondTier").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Sales")).click();
		page.getByPlaceholder("Click here to add a filter,").click();
		page.getByText("Not Paid/Allocated").click();
		page.getByText("Partially Paid/Allocated").click();
		page.getByText("-30 Days").click();
		Thread.sleep(3000);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Apply filters")).click();
	}
	public void salesReportPDF1()
	{
		Page page1 = page.waitForPopup(() -> {
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("⎙")).click();
		});
		page1.waitForLoadState(LoadState.LOAD);
		String pdfUrl = page1.url();
		if (pdfUrl.contains("printPdf")) {
			System.out.println("PDF page opened successfully: " + pdfUrl);
		} else {
			System.err.println("PDF page did not open as expected. URL: " + pdfUrl);
		}
		page1.close();
	}
	public void salesReportDownload1()
	{
		Download download = page.waitForDownload(() -> {
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).click();
		});
		Path downloadPath = download.path();
		if (downloadPath != null) {
			System.out.println("File downloaded successfully: " + downloadPath);
		} else {
			System.err.println("Download failed or file is not an Excel file.");
		}
		//page.close();
	}
	public void salesReport2() throws InterruptedException
	{
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reporting")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sales").setExact(true)).click();
		page.locator("#sortables-secondTier").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Sales")).click();
		page.getByPlaceholder("Click here to add a filter,").click();
		page.getByText("Not Paid/Allocated").click();
		page.getByText("Partially Paid/Allocated").click();
		page.getByText("Not Emailed/Printed").click(); Thread.sleep(3000);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Apply filters")).click();
	}
	public void invoiceEmail_verifyEmail() throws InterruptedException
	{
		Thread.sleep(5000);
		page.locator(".preview-file-link").first().click();
		Page page5 = page.waitForPopup(() -> {
			page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("View Invoice View Job View property ␡")).locator("a").nth(1).click();
		}); page5.waitForLoadState(LoadState.LOAD); 
		page5.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Email invoice")).click();
		page5.locator("#s2id_autogen3").click();
		page5.locator("#select2-drop li").first().click();
		page5.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
		page5.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Notes")).click();
		page5.locator("(//a[@ng-click=\"previewAttachedFile(attachedFilesDetail)\"])[1]").isVisible();
	}
	public void contractListscreen()
	{
		page.waitForLoadState(LoadState.LOAD);
		page.locator("a").filter(new Locator.FilterOptions().setHasText("Quick links")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contracts")).click();
	}
	public void basicDetails(String contractname)
	{
		//first screen
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new contract")).click();
		page.waitForLoadState(LoadState.LOAD);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("-- Please select --")).click();
		page.locator("#select2-drop").getByRole(AriaRole.TEXTBOX).fill(contractname);
		page.getByText(contractname).click();
		page.waitForLoadState(LoadState.LOAD);	 
		selectdropdownindex("//select[@formcontrolname=\"customerContact\"]", 1);
		page.waitForLoadState(LoadState.LOAD);
		page.getByRole(AriaRole.COMBOBOX).nth(2).selectOption(new SelectOption().setLabel("Google"));
		page.getByRole(AriaRole.COMBOBOX).nth(3).selectOption(new SelectOption().setLabel("Karnan Athisivam"));
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	}
	public void invoicingScreen()
	{
		//second screen
		page.waitForLoadState(LoadState.LOAD);
		page.locator("#s2id_price-plan-select2").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("-- Please select --")).click();
		page.getByText("At the beginning of the").click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("-- Please select --")).click();
		page.locator("#select2-drop").getByText(title+" "+surName).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	}
	public void addressDetails() throws InterruptedException
	{
		//thrid screen
		page.waitForLoadState(LoadState.LOAD);Thread.sleep(3000);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	}
	public void assetScreen()
	{
		//four screen
		page.waitForLoadState(LoadState.LOAD);
		page.getByText("Edit").nth(1).click();
		page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Boilers System boiler Boilers")).locator("label").click();
		page.locator("cs-modal-asset").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Save")).click();
	}
	public void ppmScreen() throws InterruptedException
	{
		//PPM
		page.getByText("Edit").nth(2).click();
		page.locator(".alert-icon").first().click();
		page.getByText("Set weeks").click(); 
		page.waitForLoadState(LoadState.LOAD);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Set weeks")).click();
		page.waitForLoadState(LoadState.LOAD);
		page.locator("#angular-es-container").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Save")).click();Thread.sleep(3000);
		page.locator(".alert-icon").click();
		page.getByText("Set weeks").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Set weeks")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add asset")).click();
		page.locator("app-sp-item-list-widget").getByText("Add asset").click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cancel")).click();
		page.locator("#angular-es-container").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Save")).click();Thread.sleep(3000);
	}
	public void serviceReminder() throws InterruptedException
	{
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
		//service
		page.getByText("Edit").nth(3).click();Thread.sleep(3000);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Enter date")).first().click();Thread.sleep(5000);
		page.getByText(String.valueOf(service),new Page.GetByTextOptions().setExact(true)).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Enter date")).click();
		page.getByText(String.valueOf(service), new Page.GetByTextOptions().setExact(true)).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Select contact")).first().click();
		page.locator(".list-item").first().click();
		page.locator("div:nth-child(3) > div:nth-child(3) > div:nth-child(2)").click();
		page.locator(".open > .dropdown-menu > .filter-container > .flex-display > .scroll-container > .list-item").click();
		page.locator("#angular-es-container").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Save")).click();
		page.locator("cs-modal").filter(new Locator.FilterOptions().setHasText("×Service reminder datesOne or")).getByRole(AriaRole.TEXTBOX).click();
		page.locator("cs-modal").filter(new Locator.FilterOptions().setHasText("×Service reminder datesOne or")).getByRole(AriaRole.TEXTBOX).fill("confirm");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm")).click();
		page.waitForLoadState(LoadState.LOAD);Thread.sleep(3000);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();Thread.sleep(3000);
	}
	public void serviceReminder2() throws InterruptedException
	{
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
		//service
		page.getByText("Edit").nth(3).click();Thread.sleep(3000);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Enter date")).first().click();
		page.getByText(String.valueOf(service),new Page.GetByTextOptions().setExact(true)).click();
//		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Enter date")).click();
//		page.getByText(String.valueOf(service), new Page.GetByTextOptions().setExact(true)).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Select contact")).first().click();
		page.locator(".list-item").first().click();
//		page.locator("div:nth-child(3) > div:nth-child(3) > div:nth-child(2)").click();
//		page.locator(".open > .dropdown-menu > .filter-container > .flex-display > .scroll-container > .list-item").click();
		page.locator("#angular-es-container").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Save")).click();
		page.locator("cs-modal").filter(new Locator.FilterOptions().setHasText("×Service reminder datesOne or")).getByRole(AriaRole.TEXTBOX).click();
		page.locator("cs-modal").filter(new Locator.FilterOptions().setHasText("×Service reminder datesOne or")).getByRole(AriaRole.TEXTBOX).fill("confirm");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm")).click();
		page.waitForLoadState(LoadState.LOAD);Thread.sleep(3000);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();Thread.sleep(3000);
	}
	public void contractActivation()
	{
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		page.locator("cs-modal").filter(new Locator.FilterOptions().setHasText("×Contract activationThe")).getByRole(AriaRole.TEXTBOX).click();
		page.locator("cs-modal").filter(new Locator.FilterOptions().setHasText("×Contract activationThe")).getByRole(AriaRole.TEXTBOX).fill("activate");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Activate")).click();
	}
	public void contractSettingslist()
	{
		page.locator("#drop5").click();
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Settings")).click();
	    page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Contracts$"))).click();
	    page.locator("#contract_templates").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("View")).click();
	}
	public void newbasicDetails()
	{
		//basic details
				page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new contract template")).click();
			    page.locator("#angular-es-container input[type=\"text\"]").click();
			  //random name
			  		// Create an instance of Random
			  		Random random = new Random();

			  		// Select a random adjective and noun
			  		String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
			  		String noun = NOUNS[random.nextInt(NOUNS.length)];

			  		// Combine them to create the contract name
			  		String contractName = adjective + " " + noun;
			  		ContractName=contractName;
			    
			    page.locator("#angular-es-container input[type=\"text\"]").fill(ContractName);
			    page.locator("textarea[type=\"text\"]").click();
			    page.locator("textarea[type=\"text\"]").fill(ContractName);
			    page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^-- Please choose --Service PlansPlanned Preventive Maintenance$"))).getByRole(AriaRole.COMBOBOX).selectOption("1");
			    page.getByRole(AriaRole.COMBOBOX).nth(2).selectOption("1");
			    page.getByRole(AriaRole.SPINBUTTON).click();
			    page.getByRole(AriaRole.SPINBUTTON).fill("12");
			    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	}
	public void newAsset() throws InterruptedException
	{
		//asset
	    Thread.sleep(5000);
	    page.locator("label").filter(new Locator.FilterOptions().setHasText("Yes")).click();
	    page.locator("#s2id_assetType-input").getByRole(AriaRole.LIST).click();
	    page.getByText("System boiler").click(); Thread.sleep(5000);
	    page.locator("fieldset").filter(new Locator.FilterOptions().setHasText("Assets Which asset type are")).getByLabel("Yes").check();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	}
	public void newSLA() throws InterruptedException
	{
		//SLA
	    Thread.sleep(3000);
	    page.locator("label").filter(new Locator.FilterOptions().setHasText("Yes")).click();
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("-- Please choose --")).click();
	    page.getByText("SLA demo").click();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	}
	public void newPPM()
	{
		//PPM
	    page.locator("label").filter(new Locator.FilterOptions().setHasText("Yes")).click();
	    page.locator(".overflow_handsontable").first().dblclick();
	    page.locator("#select2-drop").getByRole(AriaRole.TEXTBOX).fill("pp");
	    page.getByText("PPM 1").click();
	    page.locator("td:nth-child(3)").first().dblclick();
	    page.getByText("Property").click();
	    page.locator("td:nth-child(5)").first().dblclick();
	    page.locator("#select2-drop").getByRole(AriaRole.TEXTBOX).fill("au");
	    page.getByText("AutoFinal").click();
	    page.locator("td:nth-child(6)").first().dblclick();
	    page.getByText("No, FOC on completion").click();
	    page.locator("td:nth-child(7)").first().dblclick();
	    page.getByText("Admin error").click();
	    page.locator("tr:nth-child(2) > td").first().dblclick();
	    page.locator("#select2-drop").getByRole(AriaRole.TEXTBOX).fill("pp");
	    page.locator("#select2-drop").getByText("PPM").click();
	    page.locator("tr:nth-child(2) > td:nth-child(3)").dblclick();
	    page.getByText("Asset", new Page.GetByTextOptions().setExact(true)).click();
	    page.locator("tr:nth-child(2) > td:nth-child(4)").dblclick();
	    page.locator("li").filter(new Locator.FilterOptions().setHasText("System boiler")).click();
	    page.locator("tr:nth-child(2) > td:nth-child(6)").click();
	    page.locator("tr:nth-child(2) > td:nth-child(5)").dblclick();
	    page.locator("#select2-drop").getByRole(AriaRole.TEXTBOX).fill("auto");
	    page.locator("#select2-drop").getByText("AutoFinal").click();
	    page.locator("tr:nth-child(2) > td:nth-child(6)").dblclick();
	    page.locator("#select2-drop").getByText("No, FOC on completion").click();
	    page.locator("tr:nth-child(2) > td:nth-child(7)").dblclick();
	    page.locator("#select2-drop").getByText("Admin error").click();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	}
	public void newServicejob() throws InterruptedException
	{
		//Service jobs
	    Thread.sleep(3000);
	    page.locator("label").filter(new Locator.FilterOptions().setHasText("Yes")).click();Thread.sleep(3000);
	    page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Please select ▼")).first().dblclick();
	    page.locator("#select2-drop").getByRole(AriaRole.TEXTBOX).fill("boil");
	    page.getByText("Boiler service").click();
	    page.locator("td:nth-child(4)").first().dblclick();
	    page.getByText("Create job").click();
	    page.locator("td:nth-child(5)").first().dblclick();
	    page.getByText("Yes, labour and parts").click();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	}
	public void newCallout() throws InterruptedException
	{
		//call out
	    Thread.sleep(3000);
	    page.locator("label").filter(new Locator.FilterOptions().setHasText("Yes")).click();
	    page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Please select ▼")).first().dblclick();
	    page.locator("#select2-drop").getByRole(AriaRole.TEXTBOX).fill("au");
	    page.getByText("AutoFinal").click();
	    page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Please select ▼")).first().dblclick();
	    page.getByText("Yes, labour and parts").click();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();Thread.sleep(3000);
	}
	public void newInvoice() throws InterruptedException
	{
		 //
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();Thread.sleep(3000);
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	    page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Gas%$"))).getByRole(AriaRole.TEXTBOX).click();
	    page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Gas%$"))).getByRole(AriaRole.TEXTBOX).fill("10");
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	    
	    //invoice
	    Thread.sleep(3000);
	    page.locator("label").filter(new Locator.FilterOptions().setHasText("Yes")).click();
	    page.getByText("Add new invoice option").click();
	    page.locator("input[name=\"descriptionofoption\"]").click();
	    page.locator("input[name=\"descriptionofoption\"]").fill("Description");
	    page.locator("label").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Fixed$"))).click();
	    page.locator("label").filter(new Locator.FilterOptions().setHasText("Fixed price for the contract")).click();
	    page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.COMBOBOX).first().selectOption("2");
	    page.locator("input[name=\"descriptiontoappearinvoice\"]").click();
	    page.locator("input[name=\"descriptiontoappearinvoice\"]").fill("Invoice Des");
	    page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^-- Please choose --Ranjit CategoryAravind CategoryRA categoryTest$"))).getByRole(AriaRole.COMBOBOX).selectOption("1");
	    page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^-- Please choose --Ranjit GroupAravind GroupRA Group$"))).getByRole(AriaRole.COMBOBOX).selectOption("1");
	    page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.COMBOBOX).nth(3).selectOption("1");
	    page.locator("input[name=\"invoiceprice\"]").click();
	    page.locator("input[name=\"invoiceprice\"]").fill("100");
	    page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Save")).click();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click(); Thread.sleep(3000);
	}
	public void activateNoPay()
	{
		//No payment & activate
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
	    page.locator("#angular-es-container").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Save")).click();
	    page.locator("cs-modal").filter(new Locator.FilterOptions().setHasText("×Contract template activation")).getByRole(AriaRole.TEXTBOX).click();
	    page.locator("cs-modal").filter(new Locator.FilterOptions().setHasText("×Contract template activation")).getByRole(AriaRole.TEXTBOX).fill("activate");
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Activate")).click();
	}
	public void verifyNewContract() throws InterruptedException
	{
		Thread.sleep(3000);
		page.getByPlaceholder("Search by name, description").click();
	    page.getByPlaceholder("Search by name, description").fill(ContractName);
	    page.getByPlaceholder("Search by name, description").press("Enter");
	    page.waitForLoadState(LoadState.LOAD);
	    PlaywrightAssertions.assertThat(page.getByRole(AriaRole.GRIDCELL, new Page.GetByRoleOptions().setName("Active")).first()).isVisible();
	}











	//wrapper
	public void selectDropdown(String dropdownLocator, String second, String optionText) {

		page.locator(dropdownLocator).click();
		page.locator(second).getByText(optionText).click();

	}
	public void selectdropdownindex(String xpath, int value)
	{
		if(xpath.contains("$"))
		{
			xpath = xpath.replace("$", "");
			page.selectOption("[name='"+xpath+"']", 
					new SelectOption().setIndex(value));

		}
		else if(xpath.contains("#"))
		{
			xpath = xpath.replace("#", "");
			page.selectOption("#"+xpath, 
					new SelectOption().setIndex(value));

		}
		else if(xpath.contains("~"))
		{
			xpath = xpath.replace("~", "");
			page.selectOption("."+xpath, 
					new SelectOption().setIndex(value));
		}
		else
		{
			page.selectOption(xpath, 
					new SelectOption().setIndex(value));
		}
	}
}