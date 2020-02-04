package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class DinamicTableDemo2 extends CommonMethods{
/*
 * TC 1: Table headers and rows verification
Open chrome browser
Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
Login to the application
Verify customer “Susan McLaren” is present in the table
Click on customer details
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.Smartbears_URL);
		//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		
		//find the names column
		String expectedValue="Susan McLaren";
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		for(int i=1; i<rows.size(); i++) {
			String rowText=rows.get(i-1).getText();
				if(rowText.contains(expectedValue)) {
					driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+i+"]/td[13]")).click();	
					break;
			}
		}
		WebElement element=driver.findElement(By.xpath("//h3[text()='Product Information']"));
		if(element.isDisplayed()) {
			System.out.println("Costumer details is clicked");
		}else {
			System.out.println("Costumer details is not clicked");			
		}
		driver.close();
	}
}
