package SeleniumTasksPDF6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class VerifyElementisEnabled extends CommonMethods{
/*
 * TC 3: Verify element is enabled
Open chrome browser
Go to “https://the-internet.herokuapp.com/”
Click on “Click on the “Dynamic Controls” link
Click on enable button
Enter “Hello” and verify text is entered successfully
Close the browser
 */
	public static void main(String[] args) {
		setUp("chrome", Constants.welcomeToTheInternet_URL);
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		//add wait webdriver 
		WebDriverWait wait=new WebDriverWait(driver, 30);
		//initialize
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
		//check button (enabled or disabled)
		WebElement message=driver.findElement(By.xpath("//p[@id='message']"));
		//web element text button
		WebElement text=driver.findElement(By.xpath("//input[@type='text']"));
		
		String value="";
		if(message.getText().equals("It's enabled!")) {
			 text.sendKeys("Hello");
			 value=text.getAttribute("value");
			 
		}else {
			driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
			text=driver.findElement(By.xpath("//input[@type='text']"));
			text.sendKeys("Hello");
			value=text.getAttribute("value");
		}
		System.out.println("Text entered--> "+value);
		driver.quit();
	}

}
