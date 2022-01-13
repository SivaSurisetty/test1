package com.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageParent{

	public BasePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	
	public static void waitforElementVisible(By locator) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void doSendKeys(By locator,String text) {
		driver.findElement(locator).sendKeys(text);
	}
	public  void doClick(By locator) {
		driver.findElement(locator).click();
	}
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(locator)).click().build().perform();
	}
}