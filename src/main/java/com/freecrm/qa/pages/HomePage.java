package com.freecrm.qa.pages;

import com.freecrm.qa.baseclass.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactButton;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsButton;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksButton;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public ContactsPage contactList()
	{
		contactButton.click();
		return new ContactsPage();
	}
	public boolean verifyUserName()
	{
		return userNameLabel.isDisplayed();
	}
	public DealsPage deals()
	
	{
		dealsButton.click();
		return new DealsPage();
		
	}
	public TaskPage tasklink()
	{
		tasksButton.click();
		return new TaskPage();
	}
	
	public void clickOnNewContact()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactButton).build().perform();
		newContact.click();
	}

}
