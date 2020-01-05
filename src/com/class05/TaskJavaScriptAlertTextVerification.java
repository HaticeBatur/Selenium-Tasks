package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TaskJavaScriptAlertTextVerification extends CommonMethods{
/*
 * C 1: JavaScript alert text verification
 Open chrome browser
Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
Click on “Alerts & Modals” links
Click on “Javascript Alerts” links
Click on button in “Java Script Alert Box” section
Verify alert box with text “I am an alert box!” is present
Click on button in “Java Script Confirm Box” section
Verify alert box with text “Press a button!” is present
Click on button in “Java Script Alert Box” section
Enter text in the alert box
Quit browser
*/
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		
		Alert alert1=driver.switchTo().alert();
		
		if(alert1.getText().equals("I am an alert box!")) {
			System.out.println("Alert-->"+alert1.getText()+" is verified");
		}else {
			System.out.println("Alert is not verified");
		}
		Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		
		Alert alert2=driver.switchTo().alert();
		
		if(alert2.getText().equals("I am an alert box!")) {
			System.out.println("Alert-->"+alert2.getText()+" is verified");
		}else {
			System.out.println("Alert is not verified");
		}
		Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		
		Alert alert3=driver.switchTo().alert();
		System.out.println("Third alers is "+alert3.getText());
		driver.close();
	}
}
