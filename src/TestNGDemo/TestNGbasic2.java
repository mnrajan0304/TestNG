package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGbasic2 {
	WebDriver driver;
	
	@BeforeSuite
	 void browserSet() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
		System.out.println("@BeforeSuite");
	}
	
	@BeforeTest
	void browserLaunch(){
		driver = new ChromeDriver();
		System.out.println("@BeforeTest");
	}
	
	@BeforeClass
	void browserMax() {
		driver.manage().window().maximize();
		System.out.println("@BeforeClass");
	}
	
	@BeforeMethod
	void browserLink() {
		driver.get("https://demoqa.com/text-box");
		System.out.println("@BeforeMethod");
	}
	

	@Test (priority = 1, invocationCount=3, timeOut= 3000)
	void getCurrentURLTest() {
		System.out.println(driver.getCurrentUrl());
		System.out.println("@Test1");
	}
	
	@Test (priority = 2 , groups = "Application forms")
	public void applicationFormName() {
		driver.findElement(By.id("userNamesssss")).sendKeys("Mani");
		System.out.println("@Test2");
	}
	
	@Test (priority = 3, groups = "Application forms")
	void applicationFormeMail() {
		driver.findElement(By.id("userEmail")).sendKeys("Manirajan");
		System.out.println("@Test3");
	}
	
	@Test (priority = 4, groups = "Application forms")
	void applicationFormCurrentAddress() {
		driver.findElement(By.id("currentAddress")).sendKeys("Current Address");
		System.out.println("@Test4");
	}
	
	@Test (priority = 5, dependsOnMethods="applicationFormName")
	void applicationFormSubmit() {
		boolean b = driver.findElement(By.id("submit")).isDisplayed();
		System.out.println(b + "Displayed");
		boolean b1 = driver.findElement(By.id("submit")).isEnabled();
		System.out.println(b1 + "Enabled");
		boolean b2 = driver.findElement(By.id("submit")).isSelected();
		System.out.println(b2 + "Selected");
		System.out.println("@Test5");
	}
	
	
	@AfterMethod (enabled = true)
	void pageTitle() {
		System.out.println(driver.getTitle());
		System.out.println("@AfterMethod");
	}
	
	@AfterClass 
	void deleteCookies() {
		driver.manage().deleteAllCookies();
		System.out.println("@AfterClass");
	}
	
	@AfterTest
	void closeBrowser() {
		driver.quit();
		System.out.println("@AfterTest");
	}
	
	@AfterSuite
	void report() {
		System.out.println("@AfterSuite");
	}

}
