package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.microsoft.playwright.Page;

import action.Wrapper;

public class PerformanceMetrics {
	// For Selenium WebDriver
    public static long getPageLoadTime(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Number loadTime = (Number) js.executeScript(
            "return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;"
        );
        return loadTime.longValue();
    }

    // For Playwright Page
    public static long getPageLoadTime(Page page) {
        Number loadTime = (Number) page.evaluate("() => { " +
            "const { navigationStart, loadEventEnd } = window.performance.timing; " +
            "return loadEventEnd - navigationStart; " +
            "}");
        return loadTime.longValue();
    }
    
    public void driverPageTime(WebDriver driver, String text)
    {
    	long loadTime = PerformanceMetrics.getPageLoadTime(driver);
		double loadTimeInSeconds = loadTime / 1000.0;  
		System.out.println("Load time for "+text+":"+loadTimeInSeconds);
		writeToFile("Load time for "+text+":"+loadTimeInSeconds + "second");
    }
    public void playPageTime(Page page, String text)
    {
    	
    	long loadTime = PerformanceMetrics.getPageLoadTime(page);
		double loadTimeInSeconds = loadTime / 1000.0;  
		System.out.println("Load time for "+text+":"+loadTimeInSeconds);
		
    }
    
    
    
    public void writeToFile(String logEntry) {
        // Define the directory and file name
        String directoryPath = "performance_logs";
        

        // Ensure the directory exists
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
        String fileName = "load_times_" + timestamp + ".txt";

        
        // Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(directoryPath, fileName), true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    

}
