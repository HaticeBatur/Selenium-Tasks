package SeleniumTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogInCheck {
	/*
	 * Open chrome browser 2. Go to “https://www.facebook.com/” 3. Enter valid username and valid password and click login  4. User successfully logged in
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("biolog_altun@hotmail.com");
		driver.findElement(By.id("pass")).sendKeys("198335");
		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(2000);
		WebElement userImage=driver.findElement(By.xpath("//img[@class='_2qgu _54rt img']"));
		if(userImage.isDisplayed()) {
			System.out.println("User succesfully logged in");
		}else {
			System.out.println("User could not succesfully log in");
		}
		driver.close();
	}
}
