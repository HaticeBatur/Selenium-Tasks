package com.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class RecapAlert extends CommonMethods{
 public static void main(String[] args) {
	 setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/javascript-alert-box-demo.html");
	 driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
	 Alert alert=driver.switchTo().alert();
	 alert.accept();
	 driver.close();
 }
}
