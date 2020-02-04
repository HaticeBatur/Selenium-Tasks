package SeleniumTasksPDF6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class VerifyElementIsClickable extends CommonMethods{
/*
 * TC 2: Verify element is clickable
Open chrome browser
Go to “https://the-internet.herokuapp.com/”
Click on “Click on the “Dynamic Controls” link
Select checkbox and click Remove
Click on Add button and verify “It’s back!” text is displayed
Close the browser 
 */
	public static void main(String[] args) {
		setUp("chrome", Constants.welcomeToTheInternet_URL);
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@type='button' and text()='Remove']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and text()='Add']")));
		driver.findElement(By.xpath("//button[@type='button' and text()='Add']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and text()='Remove']")));
		WebElement text=driver.findElement(By.id("message"));
		
		String expectedText="It's back!";
		String actualText=text.getText();
		System.out.println(actualText);
			if(actualText.equals(expectedText)) {
				System.out.println("Passed");
			}else {
					System.out.println("Failed");
		}
		driver.quit();
	}
}
