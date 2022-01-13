package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CricinfoPage extends BasePage {

	public CricinfoPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	
	By stats = By.xpath("//a[text()='Stats']");
	By testBatRec = By.xpath("(//a[text()='Batting records '])[1]");
	By odiBatRec = By.xpath("(//a[text()='Batting records '])[]");
	By mostRuns = By.xpath("(//a[text()='Most runs in career'])[1]");
	By firstName = By.xpath("//caption[text()='Most runs']//parent::table//tbody//tr//td[1]");
	By runs = By.xpath("//caption[text()='Most runs']//parent::table//tbody//tr//td[6]");
	
	public void getOdiTopScorer() throws InterruptedException {
		driver.get("https://www.espncricinfo.com/");
		waitforElementVisible(stats);
		doActionsClick(stats);
		waitforElementVisible(odiBatRec);
		doActionsClick(odiBatRec);
		waitforElementVisible(mostRuns);
		doActionsClick(mostRuns);
		Thread.sleep(10000);
		System.out.println("Name of the Cricketer with Most runs is : " +driver.findElement(firstName).getText());
		System.out.println("Total Runs scored is : "+driver.findElement(runs).getText());
		Thread.sleep(10000);
		
		
	}
}
