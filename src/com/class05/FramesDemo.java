package com.class05;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class FramesDemo extends CommonMethods{
	public static final String SYNTAX_PRACTICE_URL="http://166.62.36.207/syntaxpractice/index.html";
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", SYNTAX_PRACTICE_URL);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Others")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Iframe")).click();
		Thread.sleep(2000);
		
		/*
		 * Opening the webpage, the of webdriver will be in the main window by default
		 * 2. some action in the main window. I am getting some text from main window
		 * 
		 * Now I want to do some action inside frame
		 * 
		 * 3. I switch to that frame
		 * Now here inside the frame 
		 */
		String mainText=driver.findElement(By.xpath("//h2[text()='IFrame practice']")).getText();
		//main window text
		System.out.println("This text is from main window --> "+mainText);
		Thread.sleep(2000);
		//switch to Frame so you can perform action
		//can switch by name or Id, index by webelement/path
		driver.switchTo().frame("FrameOne");
		String insideFText=driver.findElement(By.xpath("//h4[text()='Practice Selenium Automation Testing Online']")).getText();
		//Text is inside the frame, I find the element by getting the text
		System.out.println("This text is from frame window --> "+insideFText);
		
		driver.switchTo().defaultContent();
		
		//in main wwindow see if below text is displayed
		boolean textDisplayed=driver.findElement(By.xpath("//h2[text()='IFrame practice']")).isDisplayed();
		System.out.println("Is text in main window displayed?-->"+textDisplayed);
		driver.close();
	}	
}
