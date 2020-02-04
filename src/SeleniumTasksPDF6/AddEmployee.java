package SeleniumTasksPDF6;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AddEmployee extends CommonMethods{
/*
 * TC 1: Add Employee
Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
Login into the application
Add Employee
Log out 
Quit the browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HMRS_URL);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Syntax");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Syntax123!");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Employee")));
//		driver.findElement(By.linkText("Add Employee")).click();
//		
//		//First Name
//		driver.findElement(By.name("firstName")).sendKeys("x");
//		//Last Name
//		driver.findElement(By.name("lastName")).sendKeys("y");
//
//		driver.findElement(By.xpath("//input[@value='Save']")).click();
//		
//		//check if the name is added in the table
//		driver.findElement(By.linkText("Employee List")).click();
		
		List<WebElement> employeeTable=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
		Iterator<WebElement> employeeIt=employeeTable.iterator();
		while(employeeIt.hasNext()) {
			WebElement empl=employeeIt.next();
			if(empl.getText().contains("Hatice")) {
				System.out.println(empl.getText()+" is added");
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Welcome Syntax")));
		driver.findElement(By.linkText("Welcome Syntax")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();	
	}
}
