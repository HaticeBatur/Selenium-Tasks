package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageCommands {
	public static void main(String[] args) {
		System.setProperty("webdriver.chromedriver", "/c/Users/Owner/eclipse-workspace/SeleniumBatchV/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		driver.get("http://google.com");
		
		final String expectedTitle="Google";
		String acttualTitle=driver.getTitle();
		
		if(expectedTitle.equals(acttualTitle)) {
			System.out.println("The actual title and expected title matched");
		}else {
			System.out.println("The actual title and expected title did not match");
		}
		System.out.println("***********");
		
		String expectedUrl="https://www.gole.com/?gws_rd=ssl";
		String actualUrl=driver.getCurrentUrl();
		
		if(expectedUrl.equals(actualUrl)) {
			System.out.println("Both URL matched");
		}else {
			System.out.println("Actual and Expected URL did not match");
		}
		driver.close();
	}
}
