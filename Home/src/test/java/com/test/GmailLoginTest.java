package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.GmailLoginPage;

public class GmailLoginTest extends BaseTest {

	@DataProvider
	
	public Iterator<Object[]> getData(){
		
		ArrayList<Object[]> testData = new ArrayList<Object[]>();
		
		String User = "siva.appc@gmail.com";
		String Pwd = "B4itfun@";
		
		Object ob[]= {User,Pwd};
		testData.add(ob);
		return testData.iterator();
	}
	
	
	@Test(dataProvider = "getData")
	public void login(String User, String Pwd) throws InterruptedException {
//		User = "siva.appc@gmail.com";
//		Pwd = "B4itfun@";
		//test
		pageParent.getInstance(GmailLoginPage.class).login(User, Pwd);
	}
}

package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SlotBooking {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//Locators
		By email = By.id("user_email");
		By password = By.id("user_password");
		By checkBox = By.xpath("//label[@for='policy_confirmed']//div");
		By signin = By.name("commit");
		By continueButton = By.xpath("//a[contains(text(),'Continue')]");
		By scheduleAppointment1 = By.xpath("//h5[contains(.,'Schedule Appointment')]");
		By scheduleAppointment2 = By.xpath("//a[contains(text(),'Schedule Appointment')]");	
		By inputDate = By.id("appointments_consulate_appointment_date");
		By firstavailableslotinMonth = By.xpath("((//table[@class='ui-datepicker-calendar'])[1]//td[@class=' undefined']//a)[1]");
		By nextButton = By.xpath("//span[text()='Next']");
		By timeofAppointment = By.id("appointments_consulate_appointment_time");
		By firstTimeSlot = By.xpath("//select[@id='appointments_consulate_appointment_time']//option[2]");
		By scheduleAppointment = By.xpath("//input[@name='commit' and @value ='Schedule Appointment']");
		By close = By.xpath("//a[text()='Close']");
		
		//Actions
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2,  TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ais.usvisa-info.com/en-ca/niv/users/sign_in");
		Thread.sleep(2000);
		driver.findElement(email).sendKeys("dhanwani.ravi@gmail.com");
		Thread.sleep(200);
		driver.findElement(password).sendKeys("+3A6da@Pz#t#LR3");
		Thread.sleep(200);
		driver.findElement(checkBox).click();
		Thread.sleep(200);
		driver.findElement(signin).click();
		Thread.sleep(2000);		
		int slotsBooked = 0;
		while(slotsBooked<2) {
			
			driver.findElement(continueButton).click();
			Thread.sleep(200);
			driver.findElement(scheduleAppointment1).click();
			Thread.sleep(200);
			driver.findElement(scheduleAppointment2).click();
			Thread.sleep(200);
			driver.findElement(inputDate).click();
			int months =3;
			Boolean dateSelected = false;
			while(months>0) {
				Boolean slotAvailable = false;
				try {
					slotAvailable = driver.findElement(firstavailableslotinMonth).isDisplayed();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Slot not available");
				}
				if(slotAvailable) {
					driver.findElement(firstavailableslotinMonth).click();
					months=0;
					dateSelected = true;
				}else {
					driver.findElement(nextButton).click();
					Thread.sleep(200);
				}
				months--;
			}
			Thread.sleep(200);
			if(dateSelected) {
				driver.findElement(timeofAppointment).click();
				Thread.sleep(2000);
				driver.findElement(firstTimeSlot).click();
				Thread.sleep(200);
				//schedule
				driver.findElement(scheduleAppointment).click();
				slotsBooked++;
			}else {
				Thread.sleep(1200);
				driver.findElement(close).click();
				Thread.sleep(10000);
			}
			Thread.sleep(5000);
		}
		
	}
}

