package SeleniumTasksPDF6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.utils.CommonMethods;

public class YouTubeCemalTest extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "https://google.com");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("youtube", Keys.ENTER);
		driver.findElement(By.xpath("//h3[@class='LC20lb']")).click();
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Denis Happy New Year", Keys.ENTER);
		driver.findElement(By.linkText("HAPPY NEW YEAR!")).click();
		driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
