package SeleniumTasksPDF4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class SyntaxInputBoxesCount extends CommonMethods{
/*
 * TC 1: Syntax Demo input boxes count: 
1. Open chrome browser
2. Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
3. Click on “Input Forms” links
4. Click on “Simple Form Demo” links
5. Get all input boxes from the page
6. Enter “Hello” to each text box
7. Close browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Simple Form Demo")).click();
		Thread.sleep(2000);
		List<WebElement> inputs=driver.findElements(By.className("form-control"));
		for(WebElement in:inputs) {
			in.sendKeys("Hello");
		}
	}
}
