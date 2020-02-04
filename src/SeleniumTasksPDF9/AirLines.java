package SeleniumTasksPDF9;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class AirLines extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.aa.com/homePage.do");
	    String destination="JAX";
	    String month= "May",  day= "8";
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.findElement(By.name("destinationAirport")).sendKeys(destination);
		 
		driver.findElement(By.id("aa-leavingOn")).click();
			
		 	boolean flag=false;
		 	while(!flag) {
		 		String monthValue=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		 		if(monthValue.equals(month)) {
		 			flag=true;
		 			System.out.println(monthValue);
		 			break;
		 		}	
		 		driver.findElement(By.xpath("//a[@title='Next']")).click();
		 	} 
		 	
		 	List<WebElement> dayTable=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
 			for(WebElement dayE:dayTable) {
				if(dayE.getText().equals(day)) {
					System.out.println(dayE.getText());
					dayE.click();
					break;
				} }	
 			Thread.sleep(2000);
 			String date=driver.findElement(By.xpath("//input[@name='departDate']")).getAttribute("value");
 			System.out.println(date);
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 File screen=ts.getScreenshotAs(OutputType.FILE);
		 driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
		 try {
				FileUtils.copyFile(screen, new File("screenshots/AmericanAirport/displayChooseFlight.png")); 
			 }catch(IOException e) {
				 System.out.println(e.getMessage());
			 }
		driver.quit();	 
		}
}
