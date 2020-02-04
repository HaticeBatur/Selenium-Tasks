package com.WelcomeToTheInternet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HRMS extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HMRS_URL);
		Constants.logInHMRS();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id = 'menu_recruitment_viewRecruitmentModule']")).click();
		 driver.findElement(By.linkText("Candidates")).click();
		 List<WebElement> rows=driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));
		 String firstPart="//table[@id = 'resultTable']/tbody/tr[";
		 String secondPart="]/td[2]";
		 String thirdPart="]/td[1]";
		 int numberOfRows=rows.size();
		 System.out.println(numberOfRows);
		 for(int i=1; i<=numberOfRows; i++) {
			 String namePresent=driver.findElement(By.xpath(firstPart+i+secondPart)).getText();
			 System.out.println(namePresent);
			 List<WebElement> nameList=driver.findElements(By.xpath(firstPart+i+thirdPart));
			 if(namePresent.equals("")) {
				for(WebElement element:nameList) {
					element.click();
				}
				 //break;
			 }else {
				 System.out.println("Text not present");
			 }
		 }
		 //driver.quit();
		 
	}

}
