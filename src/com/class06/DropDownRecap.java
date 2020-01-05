package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class DropDownRecap extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.ebay.com/");
		WebElement dd=driver.findElement(By.cssSelector("select#gh-cat"));
		Select obj=new Select(dd);
		List<WebElement> options=obj.getOptions();
//		for(WebElement list:options) {
//			list.click();
//			Thread.sleep(1000);
//			if(list.isSelected()) {
//				System.out.println(list.getText()+"-->Link is clickable");
//		}else {
//			System.out.println("Option is not  clickable");
//		}
		//obj.selectByVisibleText("music"); -->gives exception 
		obj.selectByVisibleText("Music");
		Thread.sleep(2000);
		boolean isSelected=false;
		for(WebElement option:options) {
			String text=option.getText();
			if(text.equals("Music")) {
				obj.selectByVisibleText(text);
				isSelected=true;
				break;
			}
		}
		System.out.println(isSelected);
		Thread.sleep(2000);
		driver.close();
		
	}

}
