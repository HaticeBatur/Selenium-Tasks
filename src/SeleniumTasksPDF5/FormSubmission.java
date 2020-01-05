package SeleniumTasksPDF5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class FormSubmission extends CommonMethods {
/*TC 1: Form Submission
1. Open chrome browser
2. Go to “http://166.62.36.207/syntaxpractice/”
3. Click on “Input Forms” link
4. Click on “Input Form Submit” link
5. Using different locator submit the form and click on “Send” 
button
6. Quit the browser
*/
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://166.62.36.207/syntaxpractice/");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.name("first_name")).sendKeys("Anna");
		Thread.sleep(1000);
		driver.findElement(By.name("last_name")).sendKeys("Maria");
		Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("phone")).sendKeys("5609972345");
		Thread.sleep(1000);
		driver.findElement(By.name("address")).sendKeys("456 Lombard Dr.");
		Thread.sleep(1000);
		driver.findElement(By.name("city")).sendKeys("Arlington");
		Thread.sleep(1000);
		WebElement stateOpt=driver.findElement(By.name("state"));
		Thread.sleep(1000);
		Select selectState=new Select(stateOpt);
		selectState.selectByVisibleText("Illinois");
		Thread.sleep(1000);
		driver.findElement(By.name("zip")).sendKeys("67845");
		Thread.sleep(1000);
		driver.findElement(By.name("website")).sendKeys("chrome");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='no']")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("comment")).sendKeys("First webpage practice");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn.btn-default")).click();
		Thread.sleep(1000);
		driver.close();
		
		
		
		
	}
}
