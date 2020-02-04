package com.WelcomeToTheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethodsss;
import com.utils.Constants;

public class Locating extends CommonMethodsss{
	public static void main(String[] args) {
		setUp("chrome", Constants.welcomeToTheInternet_URL);
//		WebElement partialLinkText=driver.findElement(By.partialLinkText("Check"));
//		partialLinkText.click();
//		driver.findElement(By.linkText("Dropdown")).click();
		driver.findElement(By.linkText("Checkboxes")).click();
		//driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
		WebElement chkBox1=driver.findElement(By.xpath("//div[@class='example']/form/input[1]"));
		chkBox1.click();
		if(chkBox1.isSelected()) {
			System.out.println("Check box 1 was selected");
		}else {
			System.out.println("Check box 1 was NOT selected");
		}
		driver.close();
	}
}
