package com.amind;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Google {
	WebDriver driver;
  
  @BeforeClass
  public void setup(){
	  String baseURL = "http://www.google.com";
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium Automation\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(baseURL);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }
	
  @Test
  public void f() {
	  MyWaitClass mwc = new MyWaitClass(driver);
	  mwc.MyExplicitWait(By.id(".//*[@id='gbw']/div/div/div[1]/div[2]/a"), 3);
	  //System.out.println(element1.getText());
	  //myImage.click();
	  /*WebElement images = driver.findElement(By.xpath(".//*[@id='gbw']/div/div/div[1]/div[2]/a"));*/
	  /*WebDriverWait wait = new WebDriverWait(driver, 3);
	  WebElement images = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='gbw']/div/div/div[1]/div[2]/a")));*/
	  //images.click();
  }
}
