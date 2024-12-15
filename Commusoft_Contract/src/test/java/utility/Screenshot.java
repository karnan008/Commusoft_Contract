	package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.microsoft.playwright.Page;

import action.Baseclass;

public class Screenshot extends Baseclass {


	public static String errflpath;
	
	public static String capture(Object driverOrPage, String testName) {
        // Create a timestamp for unique filenames
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = "ScreenShot/" + testName + "_" + timestamp + ".png";

        try {
            if (driverOrPage instanceof WebDriver) {
                // For Selenium WebDriver
                 driver = (WebDriver) driverOrPage;
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFile = new File(screenshotPath);
                FileUtils.copyFile(screenshotFile, destFile);
            } else if (driverOrPage instanceof Page) {
                // For Playwright Page
                page =  (Page) driverOrPage;
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
            } else {
                throw new IllegalArgumentException("Unsupported object type for screenshot capture.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any IO errors
            return null;
        } catch (Exception e) {
            e.printStackTrace(); // Handle any other errors
            return null;
        }

        return screenshotPath;
    }
	
	
	public static String currentdate()
	{
		DateFormat customformat = new SimpleDateFormat("MM/dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
	return	customformat.format(currentDate);
	}
}
