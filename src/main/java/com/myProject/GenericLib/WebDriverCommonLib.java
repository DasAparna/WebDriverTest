package com.myProject.GenericLib;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.w3c.css.sac.Locator;

public class WebDriverCommonLib extends Log {
	public static WebDriver driver;
	public static WebDriverWait wait;
	WebElement ele;
	
	public void logReporter(String msg){
		Reporter.log(msg);
	}
<<<<<<< HEAD
	//new changes to check branch
	//No changes made test java
=======
	
	//No changes made test java --java
>>>>>>> e95b33c8c18a2a5a117262167ef9c3231eaa0cb1
	
	public String getValuesFromPropertiesFile(String data) throws FileNotFoundException {
		String value = null;
		String loc = "C:\\Users\\bijay\\WebDriverTest\\git\\WebDriverTest\\src\\main\\java\\com\\myProject\\GenericLib\\GlobalData.properties";
		FileInputStream fis = new FileInputStream(loc);
		Properties prop = new Properties();
		try {
		prop.load(fis);
		value = prop.getProperty(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value; 
	}
	
	public String getValuesFromExcel(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException {
		String value = null;
		String loc;
		try {
		loc = getValuesFromPropertiesFile("TESTDATALOC");
		FileInputStream fis = new FileInputStream(loc);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		value = rw.getCell(colNum).getStringCellValue();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public void setValuesFromExcel(String sheetName, int rowNum,int colNum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException {
		String loc = getValuesFromPropertiesFile("TESTDATALOC");
		FileInputStream fis = new FileInputStream(loc);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.getRow(rowNum).createCell(colNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(loc);
		wb.write(fos);
		((FileInputStream) wb).close();
		fos.close();
		fis.close();
	}
	public enum Locators{
		XPATH,CSSSelector,ID;
	}
	
	public By by(Locator Locators,String control){
		By by = null;
		switch (control){
		case "XPATH":
			by = By.xpath(control);
			break;
		case "ID":
			by = By.id(control);
			break;
		case "CSSSelector":
			by = By.cssSelector(control);
			break;
		}
		return by;
	}
	
	public void wait(int time) throws InterruptedException {
		Thread.sleep(time);
	}
	
	public WebDriver getBrowser(String browser) throws FileNotFoundException {
		switch(browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", getValuesFromPropertiesFile("CHROMEDRIVER_PATH"));
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.setProperty("webdrivder.gecko.driver", getValuesFromPropertiesFile("FIREFOX_PATH"));
			driver = new FirefoxDriver();
			break;
		default:
				driver = new ChromeDriver();
			
		}
		return driver;
	}
	
	public void takescreenshot() throws IOException{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\bijay\\workspace\\MyProject\\screenshot1.png"));
	}
	
	public void scrolldown(){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0, 1000)");
	}
	
	/*public void handleDropDown(){
		WebElement ddl = driver.findElement(By.xpath(Constants.ddl2));
		Select sl = new Select(ddl);
		sl.selectByValue("");
	}*/
	
	public void loadURL(String URL) throws FileNotFoundException {
		driver.get(getValuesFromPropertiesFile("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
}
