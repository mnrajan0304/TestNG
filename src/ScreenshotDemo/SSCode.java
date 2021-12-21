package ScreenshotDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SSCode {
	public static void main(String[] args) {
		
	}
	WebDriver driver = new ChromeDriver();
	void ssMethod() {
		TakesScreenshot tk= (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File ("C:\\Users\\mnrajan\\eclipse-workspace\\FirstTestNG\\src\\ScreenshotDemo\\Screenshotnew.jpg");
		
		try {
			FileUtils.copyFile(src, des);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
	}
	


