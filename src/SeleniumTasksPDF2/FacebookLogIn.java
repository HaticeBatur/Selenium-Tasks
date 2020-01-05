package SeleniumTasksPDF2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class FacebookLogIn extends CommonMethods {
	/*
	 * Using Xpath ONLY TC 1: Facebook login:  1. Open chrome browser
	 * 2. Go to “https://www.facebook.com/” 
	 * 3. Enter valid username and valid password and click login  
	 * 4. User successfully logged in
	 */
	public static final String URL="https://www.facebook.com/";
	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("chrome", URL);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("biolog_altun@hotmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("198335");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement element=driver.findElement(By.xpath("//a[@accesskey='2']"));
		if(element.isDisplayed()) {
			System.out.println("Acces is verified");
		}else {
			System.out.println("Access is denied");
		}
		driver.close();
	}
}
