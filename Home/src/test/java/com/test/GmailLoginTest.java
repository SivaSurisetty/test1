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
