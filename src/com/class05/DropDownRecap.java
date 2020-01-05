package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class DropDownRecap extends CommonMethods{
	public static final String SYNTAX_PRACTICE_URL="http://166.62.36.207/syntaxpractice/index.html";
	public static void main(String[] args) throws InterruptedException {
		//The method is opening syntax Practice website using chrome browser
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		
		//find the element input form and click on it
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(2000);
		//find the element dropdown list and click on it
		driver.findElement(By.linkText("Select Dropdown List")).click();
		
		//find the element with id select-demo and store it into a variable
		WebElement dd=driver.findElement(By.id("select-demo"));
		//Select s=new Select(driver.findElement(By.id("select-demo")));
		
		//to work with dd, if the tagname starts with select, we can create an object of select class
		Select select=new Select(dd);
		
		//select 3 index
		select.selectByIndex(0);
		//select value by visible text
		select.selectByVisibleText("Friday");
		//select by value attribute
		select.selectByValue("Sunday");
		
		//find the count of dropdown items
		List<WebElement> options=select.getOptions();
		System.out.println("Total number of options -->"+options.size());
		//storing the list of options in iterator to loop through
		Iterator<WebElement> it=options.iterator();
		while(it.hasNext()) {
		WebElement e=it.next();
		System.out.println(e.getText());
		e.click();
			Thread.sleep(1000);
		}
		System.out.println("Does this support multi select-->"+select.isMultiple());
	}
}
