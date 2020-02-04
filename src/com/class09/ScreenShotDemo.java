package com.class09;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ScreenShotDemo extends CommonMethods{
	
	public static void main(String[] args) {
		setUp("chrome", Constants.HMRS_URL);
		String userName="Admin";
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
		//validation that admis is logged in
		String welcomeText=driver.findElement(By.id("welcome")).getText();
		
		if(welcomeText.contains("Johns")) {
			System.out.println("Test Pass");
			//How to take screenshot using Selenium?
			//We can use TakesScreenshot interface
			//Strep 1: downcast webdriver to the type of TakesScreenshot
			TakesScreenshot ts=(TakesScreenshot)driver;
			//call method getScreenshotAs and specify output type
			File screen=ts.getScreenshotAs(OutputType.FILE);
			try{
				//copy file to the specific destination and givee name and extension
				FileUtils.copyFile(screen, new File("screenshots/HRMS/AdminLogin.png"));
			}catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Test Fail");
			TakesScreenshot ts=(TakesScreenshot)driver;
			File screen=ts.getScreenshotAs(OutputType.FILE);
			try{
				FileUtils.copyFile(screen, new File("screenshots/HRMS/AdminLogin.png"));
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		
		driver.quit();
	}

}
