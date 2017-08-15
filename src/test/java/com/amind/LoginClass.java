package com.amind;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginClass {
	public static WebElement element= null;
	public WebDriver driver;

	public LoginClass(WebDriver driver){
		this.driver = driver;
	}
	
	public void enterUserID(String userID){
		element = driver.findElement(By.xpath("//input[@name='userid']"));
		element.sendKeys(userID);
	}
	
	public void enterUserPass(String pass){
		element = driver.findElement(By.xpath("//input[@name='password']"));
		element.sendKeys(pass);
	}
	
	public void clickOkBtn(){
		element = driver.findElement(By.xpath("//input[@name='btnSubmit']"));
		element.click();
	}
	
	public void clickRemindBtn(){
		element = driver.findElement(By.xpath("//input[@name='successOK']"));
		element.click();
	}
	
	public void clickOrderTab(){
		element = driver.findElement(By.xpath("//div/ul//li[@id='navbar-orders']/a"));
		element.click();
	}
	
	public void clickSolutionTab(){
		element = driver.findElement(By.xpath(".//li[@id='navbar-solutions']/a"));
		element.click();
	}
	
	public void rightArrowClick(){
		WebDriverWait wait = new WebDriverWait(driver, 23);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='toolbar-navigation']/div//div[@class='nav-my-profile group']/div[@id='right-scroll-arrow']")));
		element.click();
	}
	
	public void clickOrderAutomation(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("sales-order-automation-link")));
		element.click();
	}
	
	public void clickAccount(){
		element = driver.findElement(By.id("soa-search-account"));
		element.click();
	}
	
	public void selectAllAccountsAcrossOrg(){
		WebElement element = driver.findElement(By.id("account-view-button"));
		element.click();
		
		WebElement scrollBox = driver.findElement(By.id("account-view-menu"));
		
		List<WebElement> myList = scrollBox.findElements(By.tagName("li"));
		for(WebElement userSelect: myList){
			if(userSelect.getText().equals("All Accounts Across Organizations")){
				userSelect.click();
				System.out.println("Clicked on All Accounts across organization");
				break;
			}
		}
		
	}
	
	public void enterAccountID(){
		WebElement element = driver.findElement(By.id("account-input"));
		element.sendKeys("300097");
		
		WebElement optionBox = driver.findElement(By.className("searchOptions"));
		List<WebElement> optionList = optionBox.findElements(By.tagName("a"));
		    for(WebElement we:optionList){

			System.out.println(we.getText());

			if(we.getText().equals("Search for 300097 in SUB ACCOUNT ID")){

			we.click();

			break;
			}
		    }

	}
	
	public void selectSearchedAccount(){
		element = driver.findElement(By.xpath("//span[@class='unchecked']"));
		element.click();
	}
	
	public void continueBtnAccountPage(){
		element = driver.findElement(By.xpath("//div[@class='application-btn lg-btn orange-btn select-account']"));
		element.click();
	}

	public void selectAVPNProduct(){
		element = driver.findElement(By.id("img1"));
		element.click();
	}
	
	public void clickAVPNSearchBtn(){
		element = driver.findElement(By.id("avpn-button"));
		element.click();
	}
	
	public void selectIPFRProduct(){
		element = driver.findElement(By.id("img2"));
		element.click();
	}
	
	public void clickMISButton(){
		element = driver.findElement(By.id("mis-button"));
		element.click();
	}
	
	public void clickBVOIPButton(){
		element = driver.findElement(By.id("bvp-button"));
		element.click();
	}
	
	
}
