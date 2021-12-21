package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterDemo {
WebDriver driver;
	
	@BeforeMethod
	void browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
	 driver= new ChromeDriver();
	}
	
	
	
	@Test
	@Parameters({"url", "name", "mail", "address"})
	void applicationFormName(String url, String name, String mail, String address) {
		driver.get(url);
		driver.findElement(By.id("userName")).sendKeys(name);
		driver.findElement(By.id("userEmail")).sendKeys(mail);
		driver.findElement(By.id("currentAddress")).sendKeys(address);
	}
	
	
	@AfterMethod
	void applicationFormSubmit() {
		boolean b = driver.findElement(By.id("submit")).isDisplayed();
		System.out.println(b + "Displayed");
		boolean b1 = driver.findElement(By.id("submit")).isEnabled();
		System.out.println(b1 + "Enabled");
		boolean b2 = driver.findElement(By.id("submit")).isSelected();
		System.out.println(b2 + "Selected");
		System.out.println("@Test5");
	}
  
  
  @AfterClass
  void close() {
	  driver.quit();
  }
}
