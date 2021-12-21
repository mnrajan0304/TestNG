package RetryLogicDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RetryTest {
	WebDriver driver;
	
 @BeforeMethod
	void browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
	 driver= new ChromeDriver();
	}

 @Test
	void applicationFormName1() {
			driver.get("https://demoqa.com/text-box");
			driver.findElement(By.id("userName")).sendKeys("Manirajan1");
			driver.findElement(By.id("userEmail")).sendKeys("manirajann93@gmail.com");
			driver.findElement(By.id("currentAddress")).sendKeys("Address of the destination111111");
			System.out.println("applicationFormName1");
		}
 
 @Test (retryAnalyzer= RetryLogicDemo.RetryAnalyse.class)
	void applicationFormName2() {
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.id("userName")).sendKeys("Manirajan2");
		driver.findElement(By.id("userEmailsssss")).sendKeys("manirajann93@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Address of the destination2222222");
		System.out.println("applicationFormName2");
	}
 
 @Test
	void applicationFormName3() {
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.id("userName")).sendKeys("Manirajan3");
		driver.findElement(By.id("userEmail")).sendKeys("manirajann93@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Address of the destination3333333");
		System.out.println("applicationFormName3");
	}
	
 @AfterMethod
	void closeProgram() {
		driver.quit();
	} 
}

