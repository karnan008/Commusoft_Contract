package testcase;

import java.io.IOException;
import java.util.regex.Pattern;
import org.testng.annotations.Test;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import action.Baseclass;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import pages.playWright;

public class contractPlay extends Baseclass{


	@Test(priority = 1 )
	public void Add_Customer() throws InterruptedException, IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException
	{
		setDriverContext("karna");
		System.out.println(title+" "+surName);
		playWright play = new playWright(page);
		play.playLogin();
		play.createContractCustomer();
		System.out.println("customer link:"+ playwrightcontractcustomer);
	}
	@Test(priority=2)
	public void Asset() throws InterruptedException, InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException
	{
		setDriverContext("karna");
		page.navigate(playwrightcontractcustomer);
		Thread.sleep(4000);
		playWright play = new playWright(page);
		play.addAsset();
	}
	@Test(priority = 3)
	public void Contract_Creation_for_Customer() throws InterruptedException, IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException
	{
		setDriverContext("karna");
		playWright play = new playWright(page);
		page.navigate(playwrightcontractcustomer);
		play.contractListscreen();
		play.basicDetails("Existing contract template");
		play.invoicingScreen();
		play.addressDetails();
		play.assetScreen();
		play.ppmScreen();
		play.serviceReminder();
		play.contractActivation();
	}
	@Test(priority = 4)
	public void Additional_Invoice_Convert() throws InterruptedException, IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException
	{
		setDriverContext("karna"); Thread.sleep(3000);
		page.navigate(playwrighthome);
		playWright play = new playWright(page);
		play.createCustomer();
		play.createJob();
		play.createDraftAdditionalinvoice();
		play.convertDraft();
		play.verifyConvertedinvoice("Additional");
	}
	@Test(priority = 5)
	public void Interim_Invoice_Convert() throws InterruptedException, IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException
	{

		setDriverContext("karna");
		page.navigate(playwrighthome);
		playWright play = new playWright(page);
		play.createCustomer();
		play.createJob();
		play.createDraftInteriminvoice();
		play.convertDraft();
		play.verifyConvertedinvoice("Interim");		
	}
	@Test(priority = 6)
	public void Prefinal_Invoice_Convert() throws InterruptedException, IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException
	{
		setDriverContext("karna");
		page.navigate(playwrighthome);
		playWright play = new playWright(page);
		play.createCustomer();
		play.createJob();
		play.createDraftPrefinalinvoice();
		play.convertDraft();
		play.verifyConvertedinvoice("Prefinal");	
	}
	@Test(priority = 7)
	public void Final_Invoice_Convert() throws InterruptedException, IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException
	{
		setDriverContext("karna");
		page.navigate(playwrighthome);
		playWright play = new playWright(page);
		play.createCustomer();
		play.createJob();
		play.createDraftFinalinvoice();
		play.convertDraft();
		play.verifyConvertedinvoice("Final");		
	}
	@Test(priority = 8)
	public void TRIAG_4027() throws InterruptedException, IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException
	{
		setDriverContext("karna");
		page.navigate(playwrighthome);
		playWright play = new playWright(page);
		play.createCustomer();
		play.createEstimate();
		play.acceptEstimate();
		play.verifyJobgeneratedfromEstimate();
		play.verifyVatnotappearonFinalinvoice();
	}
	@Test(priority = 9)
	public void Reporting_scenarios() throws InterruptedException, IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException
	{
		setDriverContext("karna");
		page.navigate(playwrighthome);
		playWright play = new playWright(page);
		play.salesReport1();
		play.salesReportPDF1();
		play.salesReportDownload1();
		page.navigate(playwrighthome);
		play.salesReport2();
		play.invoiceEmail_verifyEmail();
	}
	@Test(priority = 10)
	public void Settings_Contract_Creation() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException
	{
		setDriverContext("karna");
		playWright play = new playWright(page);
		page.navigate(playwrighthome);
		play.contractSettingslist();
		play.newbasicDetails();
		play.newAsset();
		play.newSLA();
		play.newPPM();
		play.newServicejob();
		play.newCallout();
		play.newInvoice();
		play.activateNoPay();
		play.verifyNewContract();
	}
	@Test(priority = 11)
	public void New_Contract_Creation_for_Customer() throws InterruptedException, IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException
	{
		setDriverContext("karna");
		playWright play = new playWright(page);
		page.navigate(playwrighthome);
		play.createCustomer();
		play.addAsset();
		page.navigate(playwrightcustomer);
		play.contractListscreen();
		play.basicDetails(ContractName);
		play.invoicingScreen();
		play.addressDetails();
		play.assetScreen();
		play.ppmScreen();
		play.serviceReminder2();
		play.contractActivation();
	}
	@Test(priority=12)
	public void Verification_on_Contract_creation() throws InterruptedException, InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException
	{
		setDriverContext("karna");
		playWright play = new playWright(page);
		page.navigate(playwrightcontractcustomer);
		play.contractListscreen();

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View")).click();
		page.waitForLoadState(LoadState.LOAD);
		PlaywrightAssertions.assertThat(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Contract created$")))).isVisible();
	}
	@Test(priority=13)
	public void Verification_on_Contract_Activation() throws InterruptedException, InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException
	{
		setDriverContext("karna");
		playWright play = new playWright(page);
		page.navigate(playwrightcontractcustomer);
		play.contractListscreen();

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View")).click();
		page.waitForLoadState(LoadState.LOAD);
		PlaywrightAssertions.assertThat(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Contract activated$")))).isVisible();
	}
	@Test(priority=14)
	public void Verification_on_Contract_Communication() throws InterruptedException, InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException
	{
		setDriverContext("karna");
		playWright play = new playWright(page);
		page.navigate(playwrightcontractcustomer);
		play.contractListscreen();

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View")).click();
		page.waitForLoadState(LoadState.LOAD);
		PlaywrightAssertions.assertThat(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Subject: Contract Communication template$"))).first()).isVisible();
	}
	@Test(priority=15)
	public void Verification_on_Contract_Invoice() throws InterruptedException, InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException
	{
		setDriverContext("karna");
		playWright play = new playWright(page);
		page.navigate(playwrightcontractcustomer);
		play.contractListscreen();

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View")).click();
		page.waitForLoadState(LoadState.LOAD);
		PlaywrightAssertions.assertThat(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Invoice created$")))).isVisible();
	}
	@Test(priority=16)
	public void Verification_on_Contract_PPM_ServiceJobs_created() throws InterruptedException, InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException
	{
		setDriverContext("karna");
		playWright play = new playWright(page);
		page.navigate(playwrightcontractcustomer);
		play.contractListscreen();

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View")).click();
		page.waitForLoadState(LoadState.LOAD);Thread.sleep(10000); page.reload(); page.waitForLoadState(LoadState.LOAD);
		PlaywrightAssertions.assertThat(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Job created$"))).nth(1)).isVisible();
		PlaywrightAssertions.assertThat(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Job created$"))).first()).isVisible();
	}
	

}
