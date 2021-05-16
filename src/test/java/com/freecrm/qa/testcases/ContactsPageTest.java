package com.freecrm.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.baseclass.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	Logger log = Logger.getLogger(ContactsPageTest.class);
	
	LoginPage loginpage;
	HomePage  homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public ContactsPageTest()
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
		testutil.switchToFrame();
		contactspage=homepage.contactList();
		
		
	}
	
	
	@Test(priority=1)
	public void verifyContactPageLabel()
	{
		Assert.assertTrue(contactspage.verifyContactLabel());
	}
	
	@Test(priority=2)
	public void createNewContact()
	{
		homepage.clickOnNewContact();
		contactspage.createNewContact("Mr.", "Kom", "Buffet", "NA");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
