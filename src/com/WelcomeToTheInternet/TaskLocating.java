package com.WelcomeToTheInternet;

import org.openqa.selenium.By;
import org.seleniumhq.jetty9.server.ResourceService.WelcomeFactory;

import com.utils.CommonMethodsss;
import com.utils.Constants;

public class TaskLocating extends CommonMethodsss{
/*
 * locate any link Using partialLinkText only then click on the link, 
 * after clicking go back to the home page and locate another element using 
 * PartialLinkText only then click on the link
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.welcomeToTheInternet_URL);
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("A/B")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
