package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSselectorDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.cssSelector("//input[@name='textUsername']")).sendKeys("Sohil");
		
		// css=	input[@name='textUsername']
		// input#txtUsername only if you have id attribute
		// input.button Dot (.) use for class. If there is space in class value, then 
		// input[name^='txt'] starts with css Selector
		// ^--> starts with
		// input[name$='name'] $ represents endsWith
		// $ --> endsWith
		//input[id*='nL']  *keyWord represents contains
		
		/* 	CroPath
		 * 
		 */
		
	}
}
