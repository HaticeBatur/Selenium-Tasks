package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class CalendarDemo extends CommonMethods{
	
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HMRS_URL);
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.linkText("Leave List")).click();
		
		//step1- Click on calendar
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		
		Thread.sleep(2000);
		//step2- Get All Cells
		List<WebElement> cells=driver.findElements(By.xpath("//img[@class='ui-datepicker-trigger']"));
		for(WebElement cell:cells) {
			//retrieve text and check if it matched the expected value
			if(cell.getText().equals("16")) {
				//once found click and break
				cell.click();
			}
		}
	}

}
