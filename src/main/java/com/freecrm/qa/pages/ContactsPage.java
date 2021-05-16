package com.freecrm.qa.pages;

import com.freecrm.qa.baseclass.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(name="first_name")
	WebElement firstNameField;
	
	@FindBy(name="surname")
	WebElement lastNameField;
	
	@FindBy(name="client_lookup")
	WebElement companyNameField;
	
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement clickSave;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
public boolean verifyContactLabel()
{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	return contactLabel.isDisplayed();
}

@Test
public void createNewContact(String title, String ftname , String ltname , String cnname)
{
	Select s=new Select(driver.findElement(By.name("title")));
	s.selectByVisibleText(title);
	firstNameField.sendKeys(ftname);
	lastNameField.sendKeys(ltname);
	companyNameField.sendKeys(cnname);
	clickSave.click();
	
	
	
	
}
}
