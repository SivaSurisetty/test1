package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.page.PageParent;

public class BaseTest {
	
	public WebDriver driver;
	public  WebDriverWait wait;
	public PageParent pageParent;
	
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Tools\\96\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	

}
