package com.myProject.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.myProject.GenericLib.WebDriverCommonLib;
import com.myProject.PageObjectRepo.LoginPage;
import com.myProject.PageObjectRepo.Orders;
import com.myProject.GenericLib.Log;

public class MyPageTestCases extends LoginPage {
	
	LoginPage loginPage ;
	Orders orders;
	//WebDriver driver;
	
	@BeforeClass
	 public void setUp() throws FileNotFoundException, InterruptedException {
		getBrowser("Chrome");
		wait(1000);
		//Log.configure();
		Log.info("Browser Launched");
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		orders = PageFactory.initElements(driver, Orders.class);
		
		loadURL("URL");;
		wait(1000);
		Log.info("Application Launched");
		
		}
	@Test(priority=0)
     public void newUserCreation() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
		//Log.configure();
	//	Log.startTestCase("Create a new user Account");
		loginPage.newuserAccount();
		Log.info("Logged in Successfully");
	//	Log.startTestCase("Create your contact");
		loginPage.createYourContact();
		Log.info("Created an account successfully...");
		}
	@Test(priority = 1)
	public void WomenApearralSelection() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
		//Log.configure();
		try {
		//	Log.startTestCase("Go to Women Section");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		orders.womenAppearalOrder();
		Log.info("Choose from Dresses");
	}
  @AfterClass
     public void tearDown() {
	//  Log.configure();
	  driver.quit();
	  
	  Log.info("Browser Closed");
	//  Log.endTestCase("MyPageTestCases");
  }
  }
