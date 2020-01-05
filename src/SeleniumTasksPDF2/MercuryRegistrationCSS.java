package SeleniumTasksPDF2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class MercuryRegistrationCSS extends CommonMethods{
/*
 * TC 2: Mercury Tours Registration: 
1. Open chrome browser
2. Go to “http://newtours.demoaut.com/”
3. Click on Register Link
4. Fill out all required info
5. Click Submit
6. User successfully registered
 */
	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("chrome", "http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.cssSelector("input[name^='fi']")).sendKeys("anna");
		driver.findElement(By.cssSelector("input[name^='la']")).sendKeys("maria");
		driver.findElement(By.cssSelector("input[name^='re']")).click();
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.cssSelector("img[src^='/images/m']"));
		if(element.isDisplayed()) {
			System.out.println("Registration process is completed");
		}else {
			System.out.println("Registration process is completed");
		}
		driver.close();
	}
}
