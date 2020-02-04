package SeleniumTasksPDF6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW1DeleteEmpl extends CommonMethods{
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
	 Constants.logInHMRS();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Employee")));
		driver.findElement(By.linkText("Add Employee")).click();
		
		String firstName="Test";
		driver.findElement(By.name("firstName")).sendKeys("z");
		String laststName="Saliha";
		driver.findElement(By.name("lastName")).sendKeys(laststName);
		driver.findElement(By.id("btnSave")).click();
		
		//find the added employee in the table and delete from the table
		driver.findElement(By.linkText("Employee List")).click();
		
		boolean is=false;
	
		while(!is) {
			List<WebElement> empList=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			for(int i=1; i<empList.size(); i++) {
				List<WebElement> employeeList=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[3]"));
				for(WebElement employee:employeeList) {	
				String empName=employee.getText();
				if(empName.contains(firstName)) {
					String empInfo=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[3]")).getText()+
								   driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[4]")).getText();
					
					//click the button of the added employee
					List<WebElement> selectBox=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]"));
					for(WebElement select:selectBox) {
						select.click();
					Thread.sleep(1000);
					//delete the employee
						wait.until(ExpectedConditions.elementToBeClickable(By.id("btnDelete")));
						driver.findElement(By.id("btnDelete")).click();
						wait.until(ExpectedConditions.elementToBeClickable(By.id("dialogDeleteBtn")));
						driver.findElement(By.id("dialogDeleteBtn")).click();
						Thread.sleep(1000);
						is=true;	
					}	
				}
				}	
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Next")));
			WebElement nextPage=driver.findElement((By.linkText("Next")));
			
		}
		driver.quit();
	}
}
