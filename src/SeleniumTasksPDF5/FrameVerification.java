package SeleniumTasksPDF5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class FrameVerification extends CommonMethods{
/*
 * TC 1: Syntax Frame verification
1. Open chrome browser
2. Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
3. Click on “Others” link
4. Click on “Iframe” link
5. Click on the “Home” link inside the one frame
6. Verify “Syntax logo” is displayed in another frame
7. Quit browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Iframe")).click();
		Thread.sleep(2000);
		WebElement frame1=driver.findElement(By.name("FrameOne"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//a[@href='./index.html']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement frame2=driver.findElement(By.name("FrameTwo"));
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		WebElement logo=driver.findElement(By.cssSelector("img.custom-logo"));
		System.out.println("Inside the frame 2-->"+logo.isDisplayed());
		driver.close();
	}
}
