package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends BasePage {
	
	public GmailLoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	By userId = By.xpath("//input[@type='email']");
	By pwd = By.xpath("//input[@type='password']");
	By next = By.xpath("//span[text()='Next']");
	
	public void login(String User, String Pwd) {
		
		driver.get("https://gmail.com/");
		waitforElementVisible(userId);
		doSendKeys(userId, User);
		doClick(next);
		doSendKeys(pwd, Pwd);
		doClick(next);
		
		
		
	}

}
