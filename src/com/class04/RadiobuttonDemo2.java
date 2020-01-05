package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RadiobuttonDemo2 extends CommonMethods{
	public static final String SYNTAX_PRACTICE_URL="http://166.62.36.207/syntaxpractice/index.html";
	public static void main(String[] args) throws InterruptedException {

	CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Radio ButtonsDemo")).click();
	
	//find gruop of web element of radio button
	List<WebElement> radioButtons=driver.findElements(By.name("optradio"));
	
	String maleRB=radioButtons.get(0).getAttribute("value");
	System.out.println(maleRB);

	for(WebElement element:radioButtons) {
		String text=element.getAttribute("value");
		element.click();
	}
	}
}
