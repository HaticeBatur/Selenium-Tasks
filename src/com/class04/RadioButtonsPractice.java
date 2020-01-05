package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
public class RadioButtonsPractice extends CommonMethods{
/*
 * TC 2: Radio Buttons Practice  Open chrome browser Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
 * Click on “Input Forms” linksClick on “Radio Buttons Demo” links
 * Click on any radio button in “Radio Button Demo” section.
 * Verify correct checkbox is clicked Click on any radio button in “Group Radio Buttons Demo” section.
 * Verify correct checkbox is clicked Quit browser
 */
	public static final String JIRAVM="http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("chrome", JIRAVM);
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		Thread.sleep(1000);
		WebElement maleRadioB=driver.findElement(By.xpath("//input[@value='Male']"));
		
		boolean isSelected=maleRadioB.isEnabled();
		
		if(isSelected) {
			System.out.println("Male checkbox is enabled");
		}else {
			System.out.println("Male checkbox is not enabled");
		}
		WebElement femaleRadioB=driver.findElement(By.xpath("//input[@value='Female']"));
		
		boolean isSelected1=femaleRadioB.isEnabled();
		
		if(isSelected1) {
			System.out.println("Female checkbox is enabled");
		}else {
			System.out.println("Female checkbox is not enabled");
		}
		driver.close();
	}
}
