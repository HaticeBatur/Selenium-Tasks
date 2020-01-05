package com.class05;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class MultiWindowsDemo extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome","https://accounts.google.com/signup");
		Thread.sleep(2000);
		System.out.println("The title of main window "+driver.getTitle());
		String pId=driver.getWindowHandle();
		
		driver.findElement(By.linkText("Help")).click();
		
		//to get each ids of each window, we use getWindowHandles();
		Set<String> allwindowsID=driver.getWindowHandles();
		System.out.println("How many windows opened: "+allwindowsID.size());
	
		Iterator<String> it=allwindowsID.iterator();
		String parentW=it.next();
		String childW=it.next();
		
		System.out.println("Parent Id: "+parentW);
		System.out.println("Child Id: "+childW);
		
		driver.switchTo().window(childW);
		System.out.println("Title of the Child Window i"+driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"search-form\"]/input[1]")).sendKeys("WindowPractice");
	}

}
