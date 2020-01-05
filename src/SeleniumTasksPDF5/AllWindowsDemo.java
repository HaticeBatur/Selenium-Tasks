package SeleniumTasksPDF5;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class AllWindowsDemo extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS );
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String mainWindowId=driver.getWindowHandle();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='button1']")).click();
		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
		
		Set<String> windowsID=driver.getWindowHandles();
		Iterator<String> it=windowsID.iterator();
		while(it.hasNext()) {
			String newChild=it.next();
			if(!newChild.equals(mainWindowId)) {
				driver.switchTo().window(newChild);
				Thread.sleep(2000);
				System.out.println(newChild);
				driver.close();
				driver.switchTo().window(mainWindowId);
			}	
		}
		driver.quit();
		
	}
}
