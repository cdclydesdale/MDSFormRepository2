package com.amind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWaitClass {
	public static WebElement element= null;
	public WebDriver driver;
	
	public WebElement MyExplicitWait(By var1, int myTime){
		try{
		WebDriverWait wait = new WebDriverWait(driver, myTime);
		element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(var1));
		}catch(Exception e){
			System.out.println("Element not visible on Screen ");
		}
		return element;
	}
	
	public MyWaitClass(WebDriver driver){
		this.driver = driver;
	}
	
}
