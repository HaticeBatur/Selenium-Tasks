package SeleniumTasksPDF6;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW3LeaveListSearcValidation extends CommonMethods{
/*
 * TC 1: Leave List Search Validation
Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
Login into the application
Select Leave List
Select from December 1, 2019 until January 31, 2020
Check only Pending approval
Click on Search
Validate “No Records Found” is displayed
Quit the browser
 */
	public static void main(String[] args)  {
		setUp("chrome", Constants.HMRS_URL);
		Constants.logInHMRS();
		String expFromYear="2000", expFromMonth="Dec", expFromDay="1";
		String expToYear="2020", expToMonth="Jan", expToDay="31";
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.linkText("Leave List")).click();
		
		
		//show the "From" Calendar
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calFromDate")));
		WebElement date=driver.findElement(By.id("calFromDate"));
				   date.click();
		//select the expYear from the FROM calendar
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-year']")));
		WebElement element=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select select=new Select(element);
		select.selectByVisibleText(expFromYear);
		//select the expMont from the FROM calendar
				  element=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		          select=new Select(element);
		          select.selectByVisibleText(expFromMonth);	
		//select the expDay from the FROM calendar
		List<WebElement> dayList=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for(WebElement day:dayList) {
			if(day.getText().contentEquals(expFromDay)) {
				day.click();
				break;
			}
		}
		System.out.println("Selected Date of From Calender-->"+date.getAttribute("value"));
		
		//show the TO Calendar
				date=driver.findElement(By.id("calToDate"));
				date.click();
		//select the expToYear from the TO calendar
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-year']")));
				element=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				select=new Select(element);
				select.selectByVisibleText(expToYear);
		//select the expToMont from the TO calendar
				element=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
				select=new Select(element);
				select.selectByVisibleText(expToMonth);
		//select the expToDay from the TO calendar
				dayList=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for(WebElement day:dayList) {
			if(day.getText().contentEquals(expToDay)) {
				day.click();
				break;
			}
		}
		System.out.println("Selected Date of TO Calender-->"+date.getAttribute("value"));
		
		//Check Pending Approval
			element=driver.findElement(By.xpath("//input[@name='leaveList[chkSearchFilter][]'][3]"));
		if(!element.isSelected()) {
			element.click();
		}
		driver.findElement(By.id("btnSearch"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table hover']/tbody/tr")));
			element=driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr"));
		if(element.getText().equals("No Records Found")) {
			System.out.println("Test case is passed "+element.getText());
		}else {
			System.out.println("Test case is not passed "+element.getText());
		}
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(screen, new File("screenshots/HRMS/NoSuchRecord.png"));
		}catch (IOException e) {
			System.out.println(e.getMessage());;
		}
		driver.quit();
	}
}