package com.freecrm.qa.pages;

import com.freecrm.qa.baseclass.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class LoginPage extends TestBase {
	//pageFactory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement clickLogin;
	
	@FindBy(className="img-responsive")
	WebElement crmlogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateLogo()
	{
		return crmlogo.isDisplayed();
		 
	}
    public HomePage login(String un,String pwd)
   {
	username.sendKeys(un);
	password.sendKeys(pwd);
	clickLogin.click();
	return new HomePage();
    }
	
}
