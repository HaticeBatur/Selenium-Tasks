package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {
		
		//system is a class. setProperty(); is a static method
		public static void main(String[] args) throws InterruptedException  {
			
			System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
		//http --> hypertext transfer protocol
			driver.get("http://google.com");
			Thread.sleep(2000);
		//browser navigation commands
			
			driver.navigate().to("http://www.syntaxtechs.com");
			String title=driver.getTitle().trim();
			String str="Synt tech";
			if(str.contentEquals(title)){
				System.out.println("Expected and actual title match");
			}else {
				System.out.println("Expected and actual title do not match");
			}
			System.out.println(title);
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().forward();
			Thread.sleep(3000);
			driver.close();
			
		}
}
