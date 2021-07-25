 package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();

	
	//Thread local- Tomorrow if we want to execute in a parallel mode. so thread local we will be used
	//Thread local is a java 8 feature
	/*
	 * This method is used to initiliaze the thread local driver on the basis of given browser
	 * @param browser
	 * @return this will return tldriver
	 * 
	 */
		
	public WebDriver init_driver(String browser)

	{
		System.out.println("browser value is "+browser);
		if(browser.equals("chrome"))
				{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());			}
	
	
	else if(browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		tlDriver.set(new FirefoxDriver());		
		}

	else {
		System.out.println("please pass the correct browser value: "+browser);
	}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}

	/*
	 * This is used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	}

