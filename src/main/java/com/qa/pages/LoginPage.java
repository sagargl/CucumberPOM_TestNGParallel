package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	//ByLocator, constructor, page actions, Encapsulation
	
	private WebDriver driver;
	
//1. By Locators
	private By signIn=By.xpath("//a[contains(@title,'Log in to your customer account')]");
	private By emailId=By.id("email");
	private By password=By.id("passwd");
	private By LoginIn=By.id("SubmitLogin");
	private By ForgotPwdLink=By.linkText("Forgot your password?111");
	
	
	//2. Constructor of Page Class
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//3.Page actions(behaviour) of the page form methods
	
	public void ClickOnSignIn()
	{
		driver.findElement(signIn).click();
	}
	public String getLoginPageTitle()
	{
		 return driver.getTitle();
	}
	
	public boolean isForgotPassword()
	{
		return driver.findElement(ForgotPwdLink).isDisplayed();

	}
	
	public void enterUsername(String username)
	{
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
			
	public void ClickOnLogin()
	{
		driver.findElement(LoginIn).click();
	}
	
	public AccountsPage doLogin(String un, String pwd)
	{
		driver.findElement(signIn).click();
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(LoginIn).click();
		return new AccountsPage(driver);

	}
}
