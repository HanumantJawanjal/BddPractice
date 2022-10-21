package com.Stepdefination;

import java.io.FileInputStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class StepDefination {
	
	public static WebDriver driver = null;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	@After
	public void crush(){
		//driver.close();
	}
	
	@Given("^user should be on login page$")
	public void user_should_be_on_login_page() throws Throwable {
		driver.get("file:///D:/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	    
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String uname, String password) throws Throwable {
	    driver.findElement(By.id("email")).sendKeys(uname);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.xpath("//button")).click();
	    
	}

	@Then("^user will be on home page$")
	public void user_will_be_on_home_page() throws Throwable {
	 
		Assert.assertEquals("JavaByKiran | Dashboard", driver.getTitle());
	
	}
	
	@When("^user click on new register$")
	public void user_click_on_new_register() throws Throwable {
	    driver.findElement(By.partialLinkText("Register")).click();
	    
	}

	@When("^and user enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void and_user_enter_and_and_and(String name, String mobile, String email, String password) throws Throwable {
	    FileInputStream fis = new FileInputStream("BddExcelReading.xls");
	    
	    Workbook book = Workbook.getWorkbook(fis);
	    Sheet sheet = book.getSheet("Sheet1");
	    
	    int rows = sheet.getRows();
	    int cols = sheet.getColumns();
	    for (int i = 0; i < rows; i++) {
	    		Cell namecell = sheet.getCell(0, i);
	    		Cell mobilecell = sheet.getCell(1, i);
	    		Cell emailcell = sheet.getCell(2, i);
	    		Cell passcell = sheet.getCell(3, i);
	    		driver.findElement(By.id("name")).sendKeys(namecell.getContents());
	    	    driver.findElement(By.id("mobile")).sendKeys(mobilecell.getContents());
	    	    driver.findElement(By.id("email")).sendKeys(emailcell.getContents());
	    	    driver.findElement(By.id("password")).sendKeys(passcell.getContents());	
		}
	    
	}
	
	@When("^user click on submit$")
	public void user_click_on_submit() throws Throwable {
		driver.findElement(By.xpath("//button")).click();
	}

	@Then("^user handle alert$")
	public void user_handle_alert() throws Throwable {
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	
	@Then("^user will on registraion page$")
	public void user_will_on_registraion_page() throws Throwable {
	   Assert.assertEquals("JavaByKiran | Registration Page", driver.getTitle());
	}
	

}
