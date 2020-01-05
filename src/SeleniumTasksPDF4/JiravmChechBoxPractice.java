package SeleniumTasksPDF4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class JiravmChechBoxPractice extends CommonMethods{
/*
 * TC 1: Checkbox Practice 
1. Open chrome browser
2. Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
3. Click on “Input Forms” links
4. Click on “Checkbox Demo” links
5. Click on checkbox inside a single demo section
6. Verify checkbox has been clicked successfully
7. Click on all checkboxes 1 by 1 in Multiple Checkbox Demo section.
8. Quit browser
 */
	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Checkbox Demo")).click();
		driver.findElement(By.id("isAgeSelected")).click();
		WebElement checkbox=driver.findElement(By.id("txtAge"));
		if(checkbox.isDisplayed()) {
			System.out.println("Check box is checked");
		}else {
			System.out.println("Check box is not active");
		}
		
		List <WebElement> options=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement opt:options) {
			opt.click();
			boolean isSelected=opt.isSelected();
				if(isSelected) {
					System.out.println("Option is selected -->"+isSelected);
				}else {
					System.out.println("Option is selected -->"+isSelected);
				}
			}
		
		driver.close();
	}
}
