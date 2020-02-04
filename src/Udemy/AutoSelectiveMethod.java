package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class AutoSelectiveMethod extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.makemytrip.com/");
		WebDriverWait wait=new WebDriverWait(driver, 30);
	
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']//i")));
		driver.findElement(By.id("second-img")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Ban", Keys.ENTER);
		
	}
}
