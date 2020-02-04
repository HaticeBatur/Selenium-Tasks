package SeleniumTasksPDF9;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class TableHeadrsRowsVerificationScreenshot extends CommonMethods {
/*TC 1: Table headers and rows verification
Open chrome browser
Go to “https://www.aa.com/homePage.do”
Enter From and To
Select departure as May 14 of 2020
Select arrival as November 8 of 2020
Verify “Choose flights” text is displayed
Take s screenshot of the results
Close browser
 */
	public static void main(String[] args) {
	 setUp("chrome", "https://www.aa.com/homePage.do");
	 String destination="JAX";
	 String[]  calendarId= {"aa-leavingOn","aa-returningFrom"},
			   month={"January","December"},  day= {"15","2"},  issue= {"departure", "arrival  "};
	 String firstMonthXp="//div[contains(@class,'ui-corner-left')]/div";
	 String secondMonthXp="//div[contains(@class,'ui-corner-right')]/div";
	 driver.findElement(By.name("destinationAirport")).sendKeys(destination);
	 
	 for(int i=0; i<calendarId.length; i++) {
		 WebElement date=driver.findElement(By.id(calendarId[i]));
	 				date.click();
	 	boolean flag=false;
	 	while(!flag) {
	 		WebElement firstMonth=driver.findElement(By.xpath(firstMonthXp));
	 		WebElement secondMonth=driver.findElement(By.xpath(secondMonthXp));
	 		if(firstMonth.getText().contains(month[i])||secondMonth.getText().contains(month[i])) {
	 			WebElement monthEl = firstMonth;
				String monthXp = firstMonthXp;
				if(secondMonth.getText().equals(month[i])) {
					monthEl = secondMonth;
					monthXp = secondMonthXp;
				}
	 			List<WebElement> dayTable=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
	 			for(WebElement dayE:dayTable) {
					if(dayE.getText().equals(day[i])) {
						dayE.click();
						flag=true;
						break;
					} }	
	 			break;
	 		}	
	 		driver.findElement(By.xpath("//a[@title='Next']")).click();
	 	} 
	 	System.out.println("Date of " +issue[i]+" --> "+date.getAttribute("value"));
	 	 if(date.isDisplayed()){
			 System.out.println("Test Passed");
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 File screen=ts.getScreenshotAs(OutputType.FILE); 
		 try {
				FileUtils.copyFile(screen, new File("screenshots/AmericanAirport/displayChooseFlight.png")); 
			 }catch(IOException e) {
				 System.out.println(e.getMessage());
			 }
		 }else {
			 System.out.println("Tes Failed");
		 }
	 }	
	 driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
	 driver.quit();	 
	}
}
