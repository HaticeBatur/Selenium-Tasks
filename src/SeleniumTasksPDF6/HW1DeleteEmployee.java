package SeleniumTasksPDF6;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW1DeleteEmployee extends CommonMethods{
/*
 * TC 1: Delete Employee
Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
Login into the application
Add Employee
Verify Employee has been added
Go to Employee List
Delete added Employee
Quit the browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HMRS_URL);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Syntax");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Syntax123!");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Employee")));
//		driver.findElement(By.linkText("Add Employee")).click();
//		
//		//First Name
//		driver.findElement(By.name("firstName")).sendKeys("Zuleyha");
//		//Last Name
//		driver.findElement(By.name("lastName")).sendKeys("z");
//
//		driver.findElement(By.id("btnSave")).click();
//		
//		//check if the name is added in the table
		driver.findElement(By.linkText("Employee List")).click();
		Thread.sleep(2000);
		
		boolean name=false;
		while(!name) {
			List<WebElement> employeeTable=driver.findElements(By.xpath("//table[@id='resultTable']//tbody/tr"));
		for(int i=1; i<employeeTable.size(); i++) {
			List<WebElement> employee=driver.findElements(By.xpath("//table[@id='resultTable']//tbody/tr["+i+"]/td[3]"));
			WebElement selectEmp=driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+i+"]/td[1]"));
			for(WebElement element:employee) {
				String empName=element.getText();
				if(empName.equals("Test01")) {
				selectEmp.click();
				Thread.sleep(1000);
					driver.findElement(By.id("btnDelete")).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.id("dialogDeleteBtn")));
					driver.findElement(By.id("dialogDeleteBtn")).click();
				
				Thread.sleep(2000);
				name=true;
				}
			
			}
			
			}
			Thread.sleep(2000);
			driver.findElement(By.linkText("Next")).click();
				Thread.sleep(2000);
			}
		
		
		
	}
}
