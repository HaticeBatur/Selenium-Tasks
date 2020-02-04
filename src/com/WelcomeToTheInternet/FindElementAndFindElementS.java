package com.WelcomeToTheInternet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class FindElementAndFindElementS extends CommonMethods{
	public static void main(String[] args) {
		setUp("chrome", Constants.welcomeToTheInternet_URL);
		//driver.findElement(By.linkText("Checkboxes")).click();
		driver.findElements(By.linkText("Checkboxe"));
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		int numberOfAllLinks=allLinks.size();
		if(numberOfAllLinks==45) {
			System.out.println("Expected number of links is provided-->"+numberOfAllLinks);	
		}else {
			System.out.println("Number of links in the page and expected number does not mathc");
		}
		
		//Get the text and hyperlinks of all links in the web page
		for(WebElement links:allLinks) {
			System.out.println(links.getText()+" = "+links.getAttribute("href"));
		}
		driver.quit();
	}
}
