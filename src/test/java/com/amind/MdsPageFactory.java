package com.amind;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MdsPageFactory {
	WebDriver driver;
	
	@FindBy(id="soa-search-account")
	WebElement createNewMDS;
	
	@FindBy(id="soa-current-solutions")
	WebElement currentMDSSol;
	
	@FindBy(id="account-input")
	WebElement accountTextBox;
	
	@FindBy(xpath="//span[@class='unchecked']")
	WebElement accountCheckBox;
	
	@FindBy(xpath="//div[@class='application-btn lg-btn orange-btn select-account']")
	WebElement continueBtnAccountPage;
	
	
	public void clickCreateNewMDS(){
		createNewMDS.click();
	}
	
	public void clickCurrentMDS(){
		currentMDSSol.click();
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
	
	public void enterAccountID(String accountID) throws InterruptedException{
		Thread.sleep(2000);
		accountTextBox.click();
		accountTextBox.sendKeys(accountID);
		Thread.sleep(2000);
		WebElement accSearch = driver.findElement(By.xpath(".//*[@id='account-search']/div[2]/div/a[2]"));
		accSearch.click();
	}
	
	public void selectSearchedAccount() throws InterruptedException{
		Thread.sleep(2000);
		accountCheckBox.click();
	}
	
	public void continueBtnAccountPage() throws InterruptedException{
		Thread.sleep(2000);
		continueBtnAccountPage.click();
	}
	
	public MdsPageFactory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
