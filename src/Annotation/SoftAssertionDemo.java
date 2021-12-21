package Annotation;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionDemo {
	WebDriver driver;
	
	@BeforeClass
	void browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
	 driver= new ChromeDriver();
	}
	
	@BeforeMethod
	void launch() {
		driver.get("https://demoqa.com/text-box");
	}
	
  @Test
  public void simple() {
	  WebElement e =driver.findElement(By.id("userName"));
	 System.out.println(e.getAttribute("placeholder"));
	 Assert.assertEquals(e.getAttribute("placeholder"), "Full Name");
	 
	WebElement e1=  driver.findElement(By.id("userEmail"));
	System.out.println(e1.getAttribute("placeholder"));
	SoftAssert s= new SoftAssert();
	s.assertNotEquals(e1.getAttribute("placeholder"), "name@example.com");
	
	
	WebElement e2 = driver.findElement(By.id("currentAddress"));
	System.out.println(e2.getAttribute("placeholder"));
	
	
	
	
	s.assertAll();
  }
  

  @AfterMethod(dependsOnGroups = "Assert")
  void close() {
	  driver.quit();
  }
}
