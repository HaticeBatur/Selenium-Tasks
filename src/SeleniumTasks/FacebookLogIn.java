package SeleniumTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogIn {
	/*
	 * Steps to Log In to Facebook application: 1. Browse www.facebook.com in any browser 2. On 'Facebook' login page, enter your email id into the Username text box.
	 * 3. Enter your Facebook password into the Password text box.  4. Click on 'Log In' button.
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("haticebatur_@hotmail.com");
		driver.findElement(By.id("pass")).sendKeys("hatchem83");
		driver.findElement(By.id("u_0_2")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
