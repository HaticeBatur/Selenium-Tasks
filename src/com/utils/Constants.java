package com.utils;

import org.openqa.selenium.By;

public class Constants extends CommonMethods{
	public static final String welcomeToTheInternet_URL="https://the-internet.herokuapp.com/";
	public static final String SYNTAX_PRACTICE_URL="http://jiravm.centralus.cloudapp.azure.com:8081/";
	public static final String HMRS_URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth";
	public static final String Smartbears_URL="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	public static final String mvnrepository_URL="https://mvnrepository.com/artifact/commons-io/commons-io";
	public static final String TOOLSQA_URL="https://www.toolsqa.com/";
	
	public static void logInHMRS() {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
	}
	public static void logInSmartBears() {
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	}
	
}
