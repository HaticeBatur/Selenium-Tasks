package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethodsss {
	public static WebDriver driver;
	public static void setUp(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.get(url);
			 driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
			 driver=new FirefoxDriver();
			 driver.get(url);
			 driver.manage().window().maximize();
		}
	}
}
