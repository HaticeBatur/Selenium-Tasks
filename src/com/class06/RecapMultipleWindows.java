package com.class06;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class RecapMultipleWindows extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/window-popup-modal-demo.html");
		String mainWindow=driver.getWindowHandle();
		System.out.println("Main window"+mainWindow);
		driver.findElement(By.linkText("Follow On Instagram")).click();
		//1 getWindowHandles()
		//identify parent&child
		//switch
		
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> stringIterator=allWindows.iterator();
		String parent=stringIterator.next();
		System.out.println(parent);
		String child=stringIterator.next();
		
		driver.switchTo().window(child);
		System.out.println("Child window"+child);
		String childText=driver.getTitle();
		System.out.println(childText);
		
		driver.switchTo().window(parent);
		String parentText=driver.getTitle();
		System.out.println("Parent window"+parent);
		
		
		
		Thread.sleep(2000);
		driver.close();
	}
}
