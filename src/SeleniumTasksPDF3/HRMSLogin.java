package SeleniumTasksPDF3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class HRMSLogin extends CommonMethods{
/*
 * TC 1: HRMS Application Login: 
1. Open chrome browser
2. Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
3. Enter valid username and password
4. Click on login button
5. Then verify Syntax Logo is displayed.
 */
	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("VanEarl");
		driver.findElement(By.xpath("//input[@id='txtPassword'] ")).sendKeys("VanEarl@&12");
		driver.findElement(By.xpath("//input[@id='btnLogin'] ")).click();
		WebElement syntaxLogo=driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));
		Thread.sleep(2000);
		if(syntaxLogo.isDisplayed()) {
			System.out.println("Succesfully logged in");
		}else {
			System.out.println("Can not be logged in");
		}
		driver.close();
	}
}
