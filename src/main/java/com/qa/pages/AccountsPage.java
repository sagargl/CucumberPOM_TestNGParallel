package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By accountsections=By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getAccountsPageTitle()
	{
		return driver.getTitle();
	}
	public int getAccountsSectionsCount()
	{
		//return driver.findElements(accountsections).size()-1;
		return driver.findElements(accountsections).size();

	}
	
	public List<String> getAccountsSectionList()
	{
		List<String> accountsList= new ArrayList<>();
		List<WebElement> accountsHeaderList=driver.findElements(accountsections);
		for(WebElement e: accountsHeaderList)
		{
			String text=e.getText();
			System.out.println(text);
			accountsList.add(text);
		}
		return accountsList;
	}

}
