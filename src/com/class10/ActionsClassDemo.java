package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;
import com.utils.Constants;
/*
 * Navigate to HRMS application
 * enter uid and pwd
 * click on login using mouse
 */

public class ActionsClassDemo extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HMRS_URL);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		
		//to perform mouse or keyboard operation we need to have an object on the Action 
		Actions act=new Actions(driver);
		//identify an element on wich to perform mouse click
		WebElement loginBtn=driver.findElement(By.cssSelector("input#btnLogin"));
		//clicking on the mouse and to complete the action we need to call perform();
		//do right click
		act.moveToElement(loginBtn).contextClick().perform();
		Thread.sleep(5000);
		//clicking on the button
		act.moveToElement(loginBtn).click().perform();
		//to perform double click
		//act.moveToElement(loginBtn).doubleClick().perform();
		//hover-over the element
		WebElement pimLnk=driver.findElement(By.linkText("PIM"));
		act.moveToElement(pimLnk).perform();
		
		//click on the add employee link using action class
		WebElement addEmp=driver.findElement(By.linkText("Reports"));
		act.moveToElement(addEmp).click().perform();
		
//		act.keyUp(Keys.SHIFT).sendKeys("hello") --> if you perform this on txt box
//		it will hold shift and type hello in upper case
		Thread.sleep(10000);
		driver.quit();
	}
}
