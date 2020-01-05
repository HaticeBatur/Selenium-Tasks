package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsCommandDemo1 {
	
	public static final String URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
		public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		WebElement userName=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		userName.sendKeys("admin");
		//it will clear the text box or text area
		userName.clear();
		userName.sendKeys("ad");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ad123");
		//span[@id=‘spanMessage’]
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//storing the error message element
		WebElement errorMessage=driver.findElement(By.xpath("//span[@id='spanMessage']"));
		//will return either true or false
		System.out.println(errorMessage.isDisplayed());
		String errorMsg=errorMessage.getText();
		System.out.println(errorMsg);
		if(errorMessage.isDisplayed()) { //checking if the error message is display
			String message=errorMessage.getText();//get visibale text from error message
			if(message.equals("Invalid credentials")) {//compare the text with expected  
				System.out.println("Correct error Message is Displayed");
			}else {
				System.out.println("Incorect error Message is Displayed");
			}
		} else {
			System.out.println("Error Message is NOT displayed");
		}
		
	}
}