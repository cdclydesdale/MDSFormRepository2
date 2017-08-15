package com.amind;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHandoffPageFactory {
	WebDriver driver;
	
	@FindBy(id="products-0-productInfo-0-categories-0-files-1-uploadViewFiles")
	WebElement uploadBtn;
	
	@FindBy(id="AttachFile")
	WebElement attachFile;
	
	@FindBy(id="attachmentType")
	WebElement attchmentDropDown;
	
	@FindBy(id="attachmentSubType")
	WebElement attachmentSubType;
	
	@FindBy(id="upload")
	WebElement popUpUploadBtn;
	
	@FindBy(xpath="//a[@id='cancelDocs']/span")
	WebElement popUpCloseBtn;
	
	@FindBy(id="products-0-productInfo-0-categories-0-files-1-supportRequest")
	WebElement createRelease;
	
	@FindBy(id="supportRequestReason")
	WebElement supportRequestReasonField;
	
	@FindBy(id="supportRequestType")
	WebElement supportRequestTypeField; 
	
	@FindBy(id="support-date")
	WebElement requestCompletionDate;
	
	@FindBy(id="ui-datepicker-div")
	WebElement datePicker;
	
	@FindBy(id="position-input")
	WebElement pickPosition; 
	
	@FindBy(id="selfRoutSelectId")
	WebElement selfRouteField;
	
	@FindBy(id="saveSupportRequst")
	WebElement submitBtn;
	
	@FindBy(id="saveSubmitSupportRequst")
	WebElement confirmBtn;
	
	@FindBy(xpath=".//*[@id='orders']/div[76]/div/div[2]/a/span/span")
	WebElement okBtn;
	
	public void clickUploadBtn(){
		uploadBtn.click();
	}
	
	public void clickAttachFile(){
		attachFile.click();
	}
	
	public void clickCreateReleaseBtn(){
		createRelease.click();
	}
	
	public void clickAttachmentType(){
		List<WebElement> myList = attchmentDropDown.findElements(By.tagName("option"));
		for(WebElement val:myList){
			if(val.getText().equals("MDS Form")){
				val.click();
				break;
			}
		}
	}
	
	public void clickAttachmentSubType(){
		List<WebElement> myList = attachmentSubType.findElements(By.tagName("option"));
		for(WebElement val:myList){
			if(val.getText().equals("Other")){
				val.click();
				break;
			}
		}
	}
	
	public void clickPopUpUploadBtn(){
		popUpUploadBtn.click();
	}
	
	public void clickPopUpCloseBtn(){
		Actions actions = new Actions(driver);
		actions.moveToElement(popUpCloseBtn).click().perform();
	}
	
	public void selectRequestReason(String myRequestReason){
		List<WebElement> myList = supportRequestReasonField.findElements(By.tagName("option"));
		for(WebElement val:myList){
			if(val.getText().equals(myRequestReason)){
				val.click();
				break;
			}
		}	
	}
	
	public void selectRequestType(String myRequestType){
		List<WebElement> myList = supportRequestTypeField.findElements(By.tagName("option"));
		for(WebElement val:myList){
			if(val.getText().equals(myRequestType)){
				val.click();
				break;
			}
		}	
	}
	
	public void selectRequestedCompletionDate(){
		requestCompletionDate.click();
		String dateSelected = "28";
		List<WebElement> myList = datePicker.findElements(By.tagName("td"));
		for(WebElement val: myList){
			if(val.getText().equals(dateSelected)){
				val.click();
				break;
			}
		}
	}
	
	public void enterPickPosition(String userID) throws InterruptedException{
		pickPosition.click();
		pickPosition.sendKeys(userID);
		Thread.sleep(2000);
		WebElement userIdDropdownSelection = driver.findElement(By.xpath(".//*[@id='supportForm']/div/div[3]/table/tbody/tr[2]/td[1]/div[3]/div/a[2]"));
		userIdDropdownSelection.click();
	}
	
	public void selectSelfRouteValue(){
		List<WebElement> myList = selfRouteField.findElements(By.tagName("option"));
		for(WebElement val:myList){
			if(val.getText().equals("CD119M | CLYDE | DSOUZA | A-S-PC-0000-0-00000-0-0-AE177")){
				val.click();
				break;
			}
		}
	}
	
	public void clickSubmitBtn(){
		submitBtn.click();
	}
	
	public void clickConfirmBtn(){
		confirmBtn.click();
	}
	
	public OrderHandoffPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
