package com.WelcomeToTheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethodsss;
import com.utils.Constants;

public class VerifyCheckBoxClick extends CommonMethodsss{
/*
 * On your own, you will do exactly what I did As an analyst, 
 * I want to be able to verify that when clicking on checkboxes, 
 * the first link is clickable and the second checkbox is already checked by default
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.welcomeToTheInternetUrl);
		driver.findElement(By.linkText("Checkboxes")).click();
		Thread.sleep(2000);
		WebElement chkBox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		if(chkBox2.isSelected()) {
			System.out.println("Check box 2 is already selected");
		}else {
			System.out.println("Check box 2 is NOT selected");
		}
		WebElement chkBox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		chkBox1.click();
		Thread.sleep(2000);
		if(chkBox1.isSelected()) {
			System.out.println("Check box 1 is succesfully selected");
		}else {
			System.out.println("Check box 1 is NOT selected");
		}
		driver.close();
		
				
	}
}
