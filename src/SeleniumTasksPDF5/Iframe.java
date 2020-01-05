package SeleniumTasksPDF5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class Iframe extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.toolsqa.com/iframe-practice-page/");
		driver.findElement(By.cssSelector("span.menu-text")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		WebElement iframe1=driver.findElement(By.id("IF1"));
		driver.switchTo().frame(iframe1);
//		driver.findElement(By.cssSelector("a.dt-mobile-menu-icon")).click();
//		driver.findElement(By.cssSelector("span.menu-text")).click();
		WebElement img=driver.findElement(By.xpath("//img[@class='ngg-singlepic ngg-none aligncenter lazyloaded'][1]"));
		Thread.sleep(4000);
		if(img.isDisplayed()) {
			System.out.println("Image is displayed");
		}else {
			System.out.println("Image is not displayed");
		}
		Thread.sleep(2000);
	}
}
