package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.baseclass.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage  homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		loginpage=new LoginPage();
		homepage =	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
	String homepagetitle=homepage.verifyHomePageTitle();
	Assert.assertEquals(homepagetitle, "CRMPRO","Homepage title are not matched");
	}
	
	
	@Test(priority=2)
	public void verifyUserName()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyUserName());
	}
	
	@Test(priority=3)
	public void verifyContactLink()
	{
		testutil.switchToFrame();
		contactspage=homepage.contactList();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
