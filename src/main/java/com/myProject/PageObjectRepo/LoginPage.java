package com.myProject.PageObjectRepo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.myProject.GenericLib.Log;
//import com.myProject.GenericLib.Constants;
import com.myProject.GenericLib.WebDriverCommonLib;

public class LoginPage extends WebDriverCommonLib {
	
	//WebElement ele;
	 
	 @FindBy(xpath="//div/a[contains(@class,'login')]")
	 private WebElement signin;
	 @FindBy (xpath="//div/form/h3[contains(text(),'Create an account')]")
	 private WebElement createAccText;
	 @FindBy (xpath ="//div/input[contains(@type,'text')]")
	 private WebElement emailAddField;
	 @FindBy (xpath = "//button/span/i[contains(@class,'icon-user left')]")
	 private WebElement createAnAccBtn;
	 @FindBy (xpath = "//div/h3[contains(text(),'Your personal information')]")
	 private WebElement personalInfoTxt;
	 @FindBy (xpath = "//div/label[contains(@for,'id_gender2')]")
	 private WebElement Fgender;
	 @FindBy (xpath = "//div/label[contains(@for,'id_gender1')]")
	 private WebElement Mgender;
	 @FindBy (xpath = "//div/input[contains(@id,'customer_firstname')]")
	 private WebElement firstName;
	 @FindBy (xpath = "//div/input[contains(@id,'customer_lastname')]")
	 private WebElement lastName;
	 @FindBy (xpath = "//div/input[contains(@id,'email')]")
	 private WebElement registeredEmail;
	 @FindBy (xpath = "//div/input[contains(@id,'passwd')]")
	 private WebElement enterPassword;
	 @FindBy (xpath = "//select[contains(@id,'days')]")
	 private WebElement dateDD;
	 @FindBy (xpath = "//select[contains(@id,'months')]")
	 private WebElement monthDD;
	 @FindBy (xpath = "//select[contains(@id,'years')]")
	 private WebElement yearDD;
	 @FindBy (xpath = "//p/input[contains(@id,'firstname')]")
	 private WebElement addressFirstName;
	 @FindBy (xpath = "//p/input[contains(@id,'lastname')]")
	 private WebElement addressLastName; 
	 @FindBy (xpath = "//p/input[contains(@id,'company')]")
	 private WebElement companyName;
	 @FindBy (xpath = "//p/input[contains(@id,'address1')]")
	 private WebElement address1;
	 @FindBy (xpath = "//p/input[contains(@id,'address2')]")
	 private WebElement address2;
	 @FindBy (xpath = "//p/input[contains(@id,'city')]")
	 private WebElement addCity;
	 @FindBy (xpath = "//select[contains(@id,'id_state')]")
	 private WebElement stateDD;
	 @FindBy (xpath = "//p/input[contains(@id,'postcode')]")
	 private WebElement addZip;
	 @FindBy (xpath = "//select[contains(@id,'id_country')]")
	 private WebElement addCountry;
	 @FindBy (xpath = "//p/input[contains(@id,'phone_mobile')]")
	 private WebElement phoneNum;
	 @FindBy (xpath = "//p/input[contains(@id,'alias')]")
	 private WebElement adddressAlias;
	 @FindBy (xpath = "//button[contains(@id,'submitAccount')]")
	 private WebElement registerBtn;
	 @FindBy(xpath="//div/ol/li | //a/span[contains(text(),' Home')]")
	 private WebElement errorMsgOrHomePage;
	 /*@FindBy(xpath="//a/span[contains(text(),' Home')]")
	 private WebElement homeLink;*/
	 
	 public void newuserAccount() {
		 try {
			 String emailID = "test1223." + System.currentTimeMillis()+"@gmail.com";//getValuesFromExcel("Sheet1", 1, 0);
			  
			 signin.click();
			 wait(1000);
			 if(createAccText.isDisplayed()&& emailAddField.isDisplayed()) {
					emailAddField.sendKeys(emailID);
					createAnAccBtn.click();
					wait(1000);
				 } else {
					 System.out.println("fields are not present");
				 }
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public void createYourContact() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		 String title = getValuesFromExcel("Sheet1", 1, 1);
		 String fName = getValuesFromExcel("Sheet1", 1, 2);
		 String lName = getValuesFromExcel("Sheet1", 1, 3);
		 String password = getValuesFromExcel("Sheet1", 1, 4);
		 String date = getValuesFromExcel("Sheet1", 1, 5);
		 String month = getValuesFromExcel("Sheet1", 1, 6);
		 String year = getValuesFromExcel("Sheet1", 1, 7);
		 String company = getValuesFromExcel("Sheet1", 1, 8);
		 String add1 = getValuesFromExcel("Sheet1", 1, 9);
		 String add2 = getValuesFromExcel("Sheet1", 1, 10);
		 String city = getValuesFromExcel("Sheet1", 1, 11);
		 String state = getValuesFromExcel("Sheet1", 1, 12);
		 String zip = getValuesFromExcel("Sheet1", 1, 13);
		 String country = getValuesFromExcel("Sheet1", 1, 14);
		 String mPhone = getValuesFromExcel("Sheet1", 1, 15);
		 String alias = getValuesFromExcel("Sheet1", 1, 16);
		 
		 String emailid = emailAddField.getText();
		 String actualEemail = getValuesFromExcel("Sheet1", 1, 1);
		 
		 if(emailid.contentEquals(actualEemail)){
			 System.out.println(emailid);
			 Log.info("Email id is" +" " + emailid );
		 }
		 
		 
		 if(personalInfoTxt.isDisplayed()&&
			 Fgender.isDisplayed()){
			 Log.info("Prsonal Info Page Dispalyed");
			 Fgender.click();
			 firstName.sendKeys(fName);
			 lastName.sendKeys(lName);
			 enterPassword.sendKeys(password);
			 
			 WebElement ele = dateDD;
			 Select s1 = new Select(ele);
			 s1.selectByValue(date);
			 
			 WebElement ele2 = monthDD;
			 Select s2 = new Select(ele2);
			 s2.selectByValue(month);
			 
			 WebElement ele3 = yearDD;
			 Select s3= new Select(ele3);
			 s3.selectByValue(year);
			 
			 Log.info("Date month year selected as" + " " + date +"/" + month+ "/" + year);
			 
			 addressFirstName.sendKeys(fName);
			 addressLastName.sendKeys(lName);
			 companyName.sendKeys(company);
			 address1.sendKeys(add1);
			 address2.sendKeys(add2);
			 addCity.sendKeys(city);
			 
			 WebElement ele4 = stateDD;
			 Select sl4 = new Select(ele4);
			 sl4.selectByValue(state);
			 Log.info("State selected as" + " " + state);
			 
			 addZip.sendKeys(zip);
			 addCountry.sendKeys(country);
			 phoneNum.sendKeys(mPhone);
			 adddressAlias.clear();
			 adddressAlias.sendKeys(alias);
			 registerBtn.click();
			 wait(1000);
			 
			 String error=errorMsgOrHomePage.getText();
			 
			 errorMsgOrHomePage.click();
				 Log.error(error);
				 /*
				 JavascriptExecutor js = ((JavascriptExecutor)driver);
				 js.executeScript("window.scrollBy(0,1000)");
				 */
				Log.info("HomePage Link displayed");
				// homeLink.click();
				 wait(1000);
			 }
			 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(src, new File("C:\\Users\\bijay\\workspace\\MyProject\\Screenshot\\result.png"));
			 
			 
		 }
		 
		 
	 }
