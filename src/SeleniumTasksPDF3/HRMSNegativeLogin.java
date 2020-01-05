package SeleniumTasksPDF3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class HRMSNegativeLogin extends CommonMethods{
	/*
	 * TC 2: HRMS Application Negative Login: 
1. Open chrome browser
2. Go to  “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
3. Enter valid username
4. Leave password field empty
5. Verify error message with text “Password cannot be empty” is 
displayed.
	 */
		public static void main(String[] args) throws InterruptedException {
			CommonMethods.setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("VanEarl");
			driver.findElement(By.xpath("//input[@id='txtPassword'] ")).sendKeys("");
			driver.findElement(By.xpath("//input[@id='btnLogin'] ")).click();
			WebElement message=driver.findElement(By.id("spanMessage"));
			Thread.sleep(2000);
			if(message.isDisplayed()) {
				System.out.println("Can not be logged in");
			}else {
				System.out.println("Succesfully logged in");
			}
			driver.close();
		}
}
