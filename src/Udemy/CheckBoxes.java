package Udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

/*
 * Go to "https://rahulshettyacademy.com/AutomationPractice/"
 * Check the first  Checkbox and verify if it is successfully checked 
 * and Uncheck it again to verify if it is successfully Unchecked
How to get the Count of number of check boxes present in the page
 */
public class CheckBoxes extends CommonMethods{
	public static void main(String[] args) {
		setUp("chrome", "https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkBox1=driver.findElement(By.cssSelector("#checkBoxOption1"));
		checkBox1.click();
		System.out.println(checkBox1.isSelected());
		checkBox1.click();
		System.out.println(checkBox1.isSelected());
		
		List<WebElement> checkboxList=driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Number of checkboxes --> "+checkboxList.size());
		driver.quit();
	}
}