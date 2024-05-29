package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import action.Baseclass;

public class Screenshotstestcases extends Baseclass {
	
	public void takeScreenshot(WebDriver ldriver, String testName) throws IOException {
		
		File folder = new File("Allscreenshots");
		if (!folder.exists()) {
		    folder.mkdir();
		}
		  // Take screenshot	
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// Get the current local time
		LocalDateTime now = LocalDateTime.now();

		// Datetimeformat
		String formattedDateTime = now.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy-HH-mm-ss"));

		String screenshotName = testName + "-" + formattedDateTime + ".png";
      
		Files.copy(screenshot.toPath(), new File(folder, screenshotName).toPath());
	}	

	}