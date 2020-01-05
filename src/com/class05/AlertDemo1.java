package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class AlertDemo1 extends CommonMethods{
	public static final String SYNTAX_PRACTICE_URL="http://166.62.36.207/syntaxpractice/index.html";
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", SYNTAX_PRACTICE_URL);
		Thread.sleep(2000);
		//find elements Alerts and Modals and click on it
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		//find Javascript Alerts and click on it
		driver.findElement(By.linkText("Javascript Alerts")).click();
		//find the first alert button and click on it
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Thread.sleep(2000);
		
		Alert alert=driver.switchTo().alert();
		System.out.println("Text of First Alert: " +alert.getText());
		//get the text from the UI or main window
		String text=driver.findElement(By.xpath("//p[text()='Click the button to display an alert box: ']")).getText();
		System.out.println(text);
		
	}
}
