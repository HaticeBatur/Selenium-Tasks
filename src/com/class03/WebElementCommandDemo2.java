package com.class03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommandDemo2 {
	public static final String URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("VanEarl");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("VanEarl@&12");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
//		List<String> list=new ArrayList<>();
//		list.add(e);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Size of all links "+links.size());
		for(WebElement link:links) {
			String allLink=link.getText();
			if(!allLink.isEmpty()) {
				System.out.println(allLink);
			}
		}
		
	}
}
