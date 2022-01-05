package com.page;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageParent {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public PageParent(WebDriver driver, WebDriverWait wait) {
		PageParent.driver=driver;
		PageParent.wait=wait;
			}
	//Create a method with java generics and return a new page
	
	public <TestPage extends BasePage> TestPage getInstance(Class<TestPage> pageClass) {
		
	
				try {
					return pageClass.getDeclaredConstructor(WebDriver.class,WebDriverWait.class).newInstance(this.driver,this.wait);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} 
			
			
		
	}
}


