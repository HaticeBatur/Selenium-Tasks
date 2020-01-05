package SeleniumTasksPDF5;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class WindowHandle extends CommonMethods{
/*
 * TC 1: Windows Handling
1. Open chrome browser
2. Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
3. Click on “Javascript Alerts” link
4. Click on “Window Popup Modal” link
5. Click on the “ Follow On Instagram” button
6. Verify title of the page is “Syntax Technologies (@syntaxtechs) • Instagram photos and videos” 
7. Click on the “Like us On Facebook ” button
8. Verify title of the page is “Go to Facebook Home” 
9. Quit the browser
NOTE: Selenium execution could be too fast, please use 
Thread.sleep
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		System.out.println("Title of the min window is "+driver.getTitle());
		driver.findElement(By.linkText("Alerts & Modals")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Window Popup Modal")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Follow On Instagram")).click();
		Thread.sleep(2000);
		Set<String> allWindowsID=driver.getWindowHandles();
		System.out.println("Number of windows open--> "+allWindowsID.size());
		Iterator<String> windowIt=allWindowsID.iterator();
		String parentWindow=windowIt.next();
		String childWindow=windowIt.next();
		driver.switchTo().window(childWindow);
		System.out.println("Name of the child window is--> "+driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Like us On Facebook")).click();
		Thread.sleep(2000);
		allWindowsID=driver.getWindowHandles();
		windowIt=allWindowsID.iterator();
		 parentWindow=windowIt.next();
		 childWindow=windowIt.next();
		driver.switchTo().window(childWindow);
		System.out.println("Name of the next child window is--> "+driver.getTitle());
		driver.quit();
	}
}
