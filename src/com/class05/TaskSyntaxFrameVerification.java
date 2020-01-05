package com.class05;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TaskSyntaxFrameVerification extends CommonMethods {
/*
 * TC 1: Syntax Frame verification
Open chrome browser
Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
Click on “Others” link
Click on “Iframe” link
Click on the “Home” link inside the 1 frame
Verify “Syntax logo” is displayed in another frame
Quit browser
 */
	public static final String URL="http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome",URL);
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Iframe")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("FrameOne");
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("FrameTwo");
		Thread.sleep(2000);
		boolean isDisplayed=driver.findElement(By.cssSelector("img.custom-logo")).isDisplayed();
		System.out.println("Logo is displayed-->"+isDisplayed);
		driver.close();
	}
}
