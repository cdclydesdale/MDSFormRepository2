package com.amind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFactory {
	
	WebDriver driver;
	WebElement element;
	
	public LoginFactory(WebDriver driver){
		this.driver = driver;
	}

	public WebElement userIDTextBox(){
		return driver.findElement(By.xpath("//input[@name='userid']"));
	}
	
	public WebElement userIDPassword(){
		return driver.findElement(By.xpath("//input[@name='password']"));
	}
	
	public WebElement okBtn(){
		return driver.findElement(By.xpath("//input[@name='btnSubmit']"));
	}
	
	public WebElement remindBtn(){
		return driver.findElement(By.xpath("//input[@name='successOK']"));
	}
	
}
