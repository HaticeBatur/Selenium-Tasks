package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RecapRadioAndChecks extends CommonMethods{
	public static void main(String[] args) {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/basic-checkbox-demo.html");
		//handle 1 radio or checkbox
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		//handle group radio or checkbox
		List<WebElement> allChBoxes=driver.findElements(By.xpath("//input[@class='cb1-element']"));
		for(WebElement list:allChBoxes) {
			System.out.println("Text from a checkbox-->"+list.getAttribute("label"));
		}
		driver.close();
	}
	
}
