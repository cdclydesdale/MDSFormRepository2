package com.amind;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MDSLandingPageFactory {
	
	WebDriver driver;
	
	@FindBy(id="solution-order-select")
	WebElement dropDown;
	
	public void clickMDSDropdown(){
		dropDown.click();
	}
	
	public void selectMDSFormDropdown(){
		List<WebElement> myList = dropDown.findElements(By.tagName("option"));
		for(WebElement val:myList){
			if(val.getText().equals("MDS Forms")){
				System.out.println(val.getText());
				val.click();
				break;
			}
				
		}
	}
	
	public MDSLandingPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
