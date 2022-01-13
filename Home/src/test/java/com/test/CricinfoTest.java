package com.test;

import org.testng.annotations.Test;

import com.page.CricinfoPage;
import com.page.PageParent;

public class CricinfoTest extends BaseTest {
	@Test
	public void test() throws InterruptedException {
		pageParent.getInstance(CricinfoPage.class).getOdiTopScorer();
	}
}
