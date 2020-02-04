package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class DynamicTableDemo extends CommonMethods{
/*
 * Navigate to WebOrders, "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
 * login into WebOrders
 * click checkbox next to Bob Feather
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.Smartbears_URL);
		//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		//find the names column
		String expectedValue="Bob Feather";
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
		for(int i=1; i<rows.size(); i++) {
			String rowText=rows.get(i-1).getText();
				if(rowText.contains(expectedValue)) {
					driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr["+i+"]/td[1]")).click();
			
					System.out.println(expectedValue+" is clicked");
					break;
			}else {
				System.out.println(expectedValue+" is not found");
			}
		}
		//driver.close();
	}

}
