package RetryLogicDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingDemo {
	
	@BeforeMethod
	void browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
	 driver= new ChromeDriver();
	}
  
	@Test

		void applicationFormName {
			driver.get("https://demoqa.com/text-box");
			driver.findElement(By.id("userName")).sendKeys("Manirajan");
			driver.findElement(By.id("userEmail")).sendKeys("manirajann93@gmail.com");
			driver.findElement(By.id("currentAddress")).sendKeys("Address of the destination");
			
			
		}
	  
  }
}
