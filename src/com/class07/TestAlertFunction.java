package com.class07;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TestAlertFunction extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/javascript-alert-box-demo.html");
		//driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		
		String alertText=getAlertText();
		System.out.println(alertText);
		
		acceptAlert();
		Thread.sleep(2000);
		driver.quit();
	}
}
