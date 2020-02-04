package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;
/*
 * upload the file
 * verify file is uploaded
 */
public class FileUpload extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.welcomeToTheInternet_URL);
		//to upload file we can use sendKeys method and provide full path to the file
		Thread.sleep(3000);
		scroll(-150);
		Thread.sleep(3000);
		scroll(250);
		Thread.sleep(3000);
		driver.findElement(By.linkText("File Upload")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Owner\\eclipse-workspace\\Sample\\screenshots\\dragDrop\\dragDropVerify.png");
		driver.findElement(By.id("file-submit")).click();
		//verify element File Upload is displayed
		WebElement uploaded=driver.findElement(By.xpath("//div[@id='uploaded-files']/preceding-sibling::h3"));
		if(uploaded.isDisplayed()) {
			System.out.println("File is successfully uploaded");
		}else {
			System.out.println("File is not uploaded");
		}
		
	}
}
