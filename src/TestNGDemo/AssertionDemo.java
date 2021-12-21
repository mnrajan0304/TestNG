package TestNGDemo;

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

public class AssertionDemo {
	WebDriver driver;
	
	@BeforeClass
	void browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
	 driver= new ChromeDriver();
	}
	
	@BeforeMethod
	void launch() {
		driver.get("https://demoqa.com/droppable");
	}
	
  @Test
  public void simple() {
	  WebElement src= driver.findElement(By.id("draggable"));
	  WebElement des = driver.findElement(By.id("droppable"));
	  
	  Point p =src.getLocation();
	  int x= p.x;
	  int y= p.y;
	  
	  System.out.println("First position"+"X-axis : "+ x +"  Y-axis "+ y);
	  
	  Actions a = new Actions(driver);
	  a.clickAndHold(src).moveToElement(des).release().perform();
	  
	  WebElement srcNew= driver.findElement(By.id("draggable"));
	  Point pn =srcNew.getLocation();
	  int xn= pn.x;
	  int yn= pn.y;
	  
	  System.out.println("First position"+"X-axis : "+ xn +"  Y-axis "+ yn);
	  
	  Assert.assertNotEquals(x, xn);
	  Assert.assertNotEquals(y, yn);
  }
  
  
  @AfterMethod(dependsOnGroups = "Assert")
  void close() {
	  driver.quit();
  }
}
