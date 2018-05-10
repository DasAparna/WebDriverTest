package com.myProject.PageObjectRepo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.myProject.GenericLib.Log;
import com.myProject.GenericLib.WebDriverCommonLib;

public class Orders extends WebDriverCommonLib{
	
	@FindBy(xpath="(//li/a[contains(text(),'Women')])[1]")
	private WebElement womenSection;
	@FindBy (xpath ="(//ul/li[@class]/a[contains(@title,'Casual Dresses')])[1]")
	private WebElement casualDresses;
	@FindBy(xpath="//select[contains(@id,'selectProductSort')]")
	private WebElement sortByAscOrderDD;
	@FindBy(xpath="(//a/span[contains(text(),'Add to cart')])[1]")
	private WebElement addToCartBeforeSize;
	@FindBy(xpath="(//a/span[contains(text(),'More')])[1]")
	private WebElement moreOptn;
	@FindBy(xpath="//select[contains(@id,'group_1')]")
	private WebElement sizeDD;
	@FindBy(xpath="//li/a[contains(@class,'color_pick selected')]")
	private WebElement chooseClr;
	@FindBy(xpath="//button/span[contains(text(),'Add to cart')]")
	private WebElement addTOCart;
	@FindBy(xpath="//a[contains(@title,'Proceed to checkout')]")
	private WebElement proceedToChkOut;
	@FindBy(xpath="//span[contains(@id,'total_price')]")
	private WebElement totalAmount;
	@FindBy(xpath="(//span[contains(text(),'Proceed to checkout')])[2]")
	private WebElement proceedAfterTotalPrice;
	@FindBy(xpath="//span/input[contains(@type,'checkbox')]")
	private WebElement ChkBox;
	@FindBy(xpath="//tbody/tr/td/strong")
	private WebElement myCarier;
	@FindBy(xpath="//p[contains(@class,'fancybox-error')]")
	private WebElement fancyMsg;
	@FindBy(xpath="//a[contains(@title,'Close')]")
	private WebElement close;
	@FindBy(xpath="//p/a[contains(@class,'bankwire')]")
	private WebElement payByBankWire;
	@FindBy(xpath="//p/a[contains(@class,'cheque')]")
	private WebElement payByBankCheque;
	@FindBy(xpath="//div[contains(@class,'box cheque-box')]")
	private WebElement orderSummary;
	@FindBy(xpath="(//button[contains(@type,'submit')])[2]")
	private WebElement confirmAndChkOut;
	@FindBy(xpath="//p/strong[contains(@class,'dark')]")
	private WebElement confimationMsg;
	@FindBy(xpath="(//a/img[contains(@itemprop,'image')])[1]")
	private WebElement item;
	
	public void womenAppearalOrder () throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException{
		String sort = getValuesFromExcel("Sheet2", 1, 0);
		String size = getValuesFromExcel("Sheet2", 1, 1);
		//Log.configure();
		//Log.startTestCase("Go to Women Section");
		womenSection.click();
		wait(1000);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,500)");
		
		
			WebElement ele = sortByAscOrderDD;
			Select sl = new Select(ele);
			sl.selectByValue(sort);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\bijay\\workspace\\MyProject\\Screenshot\\results2.png"));
		
		WebElement ele2 = item;
		Actions act = new Actions(driver);
		act.moveToElement(ele2).build().perform();
		
		if(moreOptn.isDisplayed()){
			moreOptn.click();
			Log.info("More Optn is Clicked");	
			WebElement ele1 = sizeDD;
			Select sl2 = new Select(ele1);
			sl2.selectByValue(size);
			Log.info("Size selected as" + " " + size);
		chooseClr.click();
		wait(1000);
		addTOCart.click();
		wait(1000);
		proceedToChkOut.click();
		
		if(totalAmount.isDisplayed()){
			String total = totalAmount.getText();
			Log.info("Total Amount is" + " " + total);
		}
		Log.info("Check Out page is dispalyed");
		proceedAfterTotalPrice.click();
		
		if(ChkBox.isSelected()){
			proceedAfterTotalPrice.click();
			String mycarierDay = myCarier.getText();
			Log.info(mycarierDay);
			proceedAfterTotalPrice.click();
		}
		if(fancyMsg.isDisplayed()) {
			String msg = fancyMsg.getText();
			Log.info(msg);
			wait(1000);
			close.click();
			wait(1000);
			ChkBox.click();
			proceedAfterTotalPrice.click();
		}
		
		payByBankWire.click();
		String ordersummary = orderSummary.getText();
		Log.info(ordersummary);
		confirmAndChkOut.click();
		Log.info("Order Palced");
		String confrmMsg = confimationMsg.getText();
		Log.info(confrmMsg);
		//Log.endTestCase("Order successfully placed");
		
		}
	}

}
