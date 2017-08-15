package com.amind;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class NewTest {
	
	WebDriver driver;
	String baseURL;
  
  @BeforeClass
  public void beforeClass() {
	  baseURL = "http://t1c1w546.vci.att.com:10080/mobilefirst";
	  DesiredCapabilities cap = DesiredCapabilities.chrome();
	  cap.setBrowserName("Chrome");
	  cap.setPlatform(Platform.WINDOWS);
	  driver = new ChromeDriver(cap);
	  driver.get(baseURL);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }
  
  public void Login() throws InterruptedException {
	  LoginClass c = new LoginClass(driver);
	  c.enterUserID("cd119m");
	  c.enterUserPass("Complicated$23");
	  c.clickOkBtn();
	  Thread.sleep(2000);
	  c.clickRemindBtn();
	  c.rightArrowClick();
	  Thread.sleep(8000);
	  c.clickOrderTab();
	  Thread.sleep(3000);
	  MDSLandingPageFactory lfact = new MDSLandingPageFactory(driver);
	  lfact.clickMDSDropdown();
	  lfact.selectMDSFormDropdown();
  }
  
  public void MDSFlowStart() throws InterruptedException{
	  MdsPageFactory mpf = new MdsPageFactory(driver);
	  Thread.sleep(1000);
	  mpf.clickCreateNewMDS();
	  Thread.sleep(2000);
	  mpf.selectAllAccountsAcrossOrg();
	  Thread.sleep(2000);
	  mpf.enterAccountID("300097");
	  mpf.selectSearchedAccount();
	  mpf.continueBtnAccountPage();
  }
  
  public void OpptyPageStart() throws InterruptedException{
	  OpportunityPageFactory opf = new OpportunityPageFactory(driver);
	  opf.enterOpptyName();
	  opf.selectOfferType("ABN Express");
	  opf.selectCloseDate();
	  Thread.sleep(2000);
	  opf.clickProductViewBtn();
	  Thread.sleep(3000);
	  opf.selectIpflexReachLd();
	  opf.clickSelectBtn();
	  Thread.sleep(3000);
	  /*WebElement downArrow = driver.findElement(By.xpath("html/body/div[8]/div[3]/div[2]/div/div/div[2]/div/div[12]/section/div/div[1]/span[2]"));
	  downArrow.click();*/
	  driver.findElement(By.cssSelector("#design-solution-summary-section > span.listview-nontouch-nav-down.icon-down")).click();
	  opf.selectContractTerm("18 Months");
	  Thread.sleep(4000);
	  /* downArrow.click(); // Down arrow clicked 2nd time?*/
	  driver.findElement(By.cssSelector("#design-solution-summary-section > span.listview-nontouch-nav-down.icon-down")).click();
	  Thread.sleep(2000);
	  opf.clickSaveContinue();
	  Thread.sleep(4000);
	  opf.clickConfirmBtn();
	  //Thread.sleep(15000);
	  //System.out.println("Oppty ID is: "+ opf.opptyId.getText()); //print Oppty ID Created
	  Thread.sleep(18000);
	  opf.opptyPopUpOkBtn.click();
  }
  
  public void OrderHandOff()throws InterruptedException, AWTException{
	  Thread.sleep(7000);
	  
	  OrderHandoffPageFactory ohFactory = new OrderHandoffPageFactory(driver);
	  ohFactory.clickUploadBtn();
	  Thread.sleep(8000);
	  ohFactory.clickAttachFile();
	  
	  Thread.sleep(2000);
	  StringSelection ss = new StringSelection("C:\\SOA Project\\MDS Forms\\ABN_Express_MDS.xlsm");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// Ctrl + v
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		ohFactory.clickAttachmentType();
		Thread.sleep(2000);
		ohFactory.clickAttachmentSubType();
		Thread.sleep(2000);
		ohFactory.clickPopUpUploadBtn();
		Thread.sleep(10000);
		ohFactory.clickPopUpCloseBtn();
		
		Thread.sleep(2000);
		ohFactory.clickCreateReleaseBtn();
		Thread.sleep(2000);
		ohFactory.selectRequestReason("Order Handoff");
		Thread.sleep(3000);
		ohFactory.selectRequestType("BCS Valued");
		Thread.sleep(3000);
		ohFactory.selectRequestedCompletionDate();
		Thread.sleep(3000);
		ohFactory.enterPickPosition("cd119m");
		Thread.sleep(3000);
		ohFactory.selectSelfRouteValue();
		Thread.sleep(2000);
		ohFactory.clickSubmitBtn();
		Thread.sleep(3000);
		ohFactory.clickConfirmBtn();
		
		Thread.sleep(7000);
		ohFactory.okBtn.click();
		
		MyWaitClass mwc = new MyWaitClass(driver);
		mwc.MyExplicitWait(By.id("abc"), 10);
  }
  
  

}
