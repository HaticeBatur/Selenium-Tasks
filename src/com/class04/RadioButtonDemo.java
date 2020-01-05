package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RadioButtonDemo extends CommonMethods {
	public static final String SYNTAX_PRACTICE_URL="http://166.62.36.207/syntaxpractice/index.html";
	
	public static void main(String[] args) throws InterruptedException {
		
		//opening browser with URL
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Input Forms']/following::a[3]"));
		
		WebElement maleRadioB=driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));
		System.out.println(maleRadioB.isSelected());
		maleRadioB.click();
		System.out.println(maleRadioB.isSelected());
		System.out.println("*********************");
		List<WebElement> radioButtons=driver.findElements(By.name("optradio"));
		for(int i=0; i<radioButtons.size(); i++) {
			boolean isSelected=radioButtons.get(i).isEnabled();
			if(!isSelected) {
				radioButtons.get(i).click();
				//System.out.println(isSelected);
				System.out.println(radioButtons.get(i).isSelected());
				Thread.sleep(1000);	
			}
		}
		driver.close();
	}
}
