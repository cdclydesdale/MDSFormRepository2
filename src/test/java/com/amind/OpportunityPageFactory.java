package com.amind;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpportunityPageFactory {
	WebDriver driver;
	
	@FindBy(id="opptyName")
	WebElement opptyTextBox;
	
	@FindBy(id="offerTypeId")
	WebElement offerTypeField;
	
	@FindBy(xpath=".//*[@id='close-date-id']")
	WebElement closeDate;
	
	@FindBy(id="mds-oppty-product-view")
	WebElement productViewBtn;
	
	@FindBy(xpath=".//*[@id='iPFlexibleReachLDWrapper']/label")
	WebElement ipflexReachLD;
	
	@FindBy(xpath=".//*[@id='prodcutSave']/span")
	WebElement selectBtn;
	
	@FindBy(xpath="html/body/div[6]/div[3]/div[2]/div/div/div[2]/div/div[11]/section/div/form/span[2]")
	WebElement downArrow;
	
	@FindBy(id="contractTermId")
	WebElement contractTerm;
	
	@FindBy(id="saveconfirm")
	WebElement saveContinueBtn;
	
	@FindBy(xpath=".//*[@id='orders']/div[70]/div/div[2]/a[2]/span")
	WebElement confirmBtn;
	
	@FindBy(xpath=".//div[@id='orders']/div[76]/div/div[1]/div/div/div[2]/span[2]/b")
	WebElement opptyId;
	
	@FindBy(xpath=".//*[@id='orders']/div[76]/div/div[2]/a/span")
	WebElement opptyPopUpOkBtn;
	
	public void enterOpptyName() throws InterruptedException{
		Thread.sleep(5000);
		opptyTextBox.click();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		opptyTextBox.sendKeys("MyOppty"+dateFormat.format(date)+"");
	}
	
	public void selectOfferType(String OfferType) throws InterruptedException{
		Thread.sleep(2000);
		List<WebElement> myList = offerTypeField.findElements(By.tagName("option"));
		for(WebElement element:myList){
			if(element.getText().equals(OfferType)){
				element.click();
				break;
			}
		}
	}
	
	public void selectCloseDate() throws InterruptedException{
		Thread.sleep(3000);
		String dateSelected="28";
		closeDate.click();
		WebElement datePicker = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']//table[@class='ui-datepicker-calendar']")); 
		List<WebElement> myCal = datePicker.findElements(By.tagName("td"));
		for(WebElement mydate:myCal){
			if(mydate.getText().equals(dateSelected)){
				mydate.click();
				break;
			}
		}
	}
	
	public void clickProductViewBtn() throws InterruptedException{
		Thread.sleep(3000);
		productViewBtn.click();
	}
	
	public void selectIpflexReachLd() throws InterruptedException{
		Thread.sleep(3000);
		ipflexReachLD.click();
	}
	
	public void clickSelectBtn(){
		selectBtn.click();
	}
	
	public void clickDownArrow(){
		downArrow.click();
	}
	
	public void clickSaveContinue(){
		saveContinueBtn.click();
	}
	
	public void clickConfirmBtn(){
		confirmBtn.click();
	}
	
	public void selectContractTerm(String term) throws InterruptedException{
		Thread.sleep(3000);
		contractTerm.click();
		List<WebElement> contractTrm = contractTerm.findElements(By.tagName("option"));
		for(WebElement myTerm:contractTrm){
			if(myTerm.getText().equals(term)){
				myTerm.click();
				break;
			}
		}
	}
	
	/*public void clickOpptyOkBtn1(WebDriver driver){
		 WebDriverWait wait = new WebDriverWait(driver, 18);
		 WebElement opptyPopUpOkBtn1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='orders']/div[76]/div/div[2]/a/span/span")));
		 opptyPopUpOkBtn1.click();
	}*/
	
	public OpportunityPageFactory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
