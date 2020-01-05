package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRMSApplNegativeLogin {
public static final String URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("VanEarl");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement errorMessage=driver.findElement(By.xpath("//span[@id='spanMessage']"));
		System.out.println(errorMessage.isDisplayed());
		
		
		if(errorMessage.isDisplayed()) { //checking if the error message is display
			String message=errorMessage.getText();//get visibale text from error message
			if(message.equals("Password cannot be empty")) {//compare the text with expected  
				System.out.println("Correct error Message is Displayed");
			}else {
				System.out.println("Incorect error Message is Displayed");
			}
		} else {
			System.out.println("Error Message is NOT displayed");
		}
	}
}
