package SeleniumTasksPDF2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class FacebookloginCSS extends CommonMethods{
	/*
	* Using Css ONLY
	TC 1: Facebook login: 
	1. Open chrome browser
	2. Go to “https://www.facebook.com/”
	3. Enter valid username and valid password and click login 
	4. User successfully logged in
	*/
	public static final String URL="https://www.facebook.com/";
	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("chrome", URL);
		driver.findElement(By.cssSelector("input#email")).sendKeys("biolog_altun@hotmail.com");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("198335");
		driver.findElement(By.cssSelector("input#u_0_2")).click();
		
		WebElement element=driver.findElement(By.cssSelector("span._1vp5"));
		if(element.isDisplayed()) {
			System.out.println("Access is verified");
		}else {
			System.out.println("Access is not verified");
		}
		Thread.sleep(2000);
		driver.close();
	}
}
