package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommand {
	public static void main(String[] args) throws InterruptedException {
		//key value
		
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		//http-->hypertext transfer protocol
		driver.get("http://google.com");
		Thread.sleep(2000);
		//browsers navigation commands
		//it will navigate to a given url
		driver.navigate().to("http://facebook.com");
		//it will navigate back
		driver.navigate().back();
		//it will navigate one step forward
		driver.navigate().forward();
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		//
		driver.close();
		
	}
}
