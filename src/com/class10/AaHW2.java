package com.class10;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.utils.CommonMethods;
/*
 * Table headers and rows verification
Open chrome browser
Go to “https://www.aa.com/homePage.do”
Enter From and To
Select departure as May 14 of 2020
Select arrival as November 8 of 2020
Verify “Choose flights” text is displayed
Take a screenshot of the results
Close browser
American Airline will block you as soon as you click on search.
Just try to take a screenshot of selected dates from the calendar and take a picture of that
 */
public class AaHW2 extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.aa.com/homePage.do");
		driver.findElement(By.name("originAirport")).clear();
		driver.findElement(By.name("originAirport")).sendKeys("New York");
		driver.findElement(By.linkText("JFK - New York John F Kennedy Intl, NY")).click();
		driver.findElement(By.name("destinationAirport")).sendKeys("Los Angeles");
		driver.findElement(By.linkText("LAX - Los Angeles International, CA")).click();
		//String monthXp = "//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']/span[@class = 'ui-datepicker-month']";
		String firstMonthXp = "//div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class = 'ui-datepicker-month']";
		String lastMonthXp = "//div[@class='ui-datepicker-group ui-datepicker-group-last']//span[@class = 'ui-datepicker-month']";
		String rowXp = "//following::table[@class='ui-datepicker-calendar']/tbody/tr";
		String[] m = { "May", "December" };
		String[] d = { "14", "3" };
		String[] buttonxP = { "aa-leavingOn", "aa-returningFrom" };
		for (int j = 0; j < 2; j++) {
			driver.findElement(By.xpath("//label[@for='"+ buttonxP[j] +"']/button")).click();
			boolean flag = false;
			while (!flag) {
				WebElement fMonth = driver.findElement(By.xpath(firstMonthXp));
				WebElement lMonth = driver.findElement(By.xpath(lastMonthXp));
				if (fMonth.getText().equals(m[j]) || lMonth.getText().equals(m[j])) {
					WebElement month = fMonth;
					String monthXp = firstMonthXp;
					if(lMonth.getText().equals(m[j])) {
						month = lMonth;
						monthXp = lastMonthXp;
					}
					List<WebElement> rows = driver.findElements(By.xpath(monthXp + rowXp));
					for (int i = 0; i < rows.size(); i++) {
						if (rows.get(i).getText().contains(d[j])) {
							List<WebElement> cells = driver.findElements(By.xpath(monthXp + rowXp + "[" + (i + 1) + "]/td"));
							for (WebElement cell : cells) {
								if (cell.getText().equals(d[j])) {
									cell.click();
									break;
								}
							}
							break;
						}
					}
					flag = true;
				}
				else {
					driver.findElement(By.xpath("//a[@data-handler ='next']")).click();
				}
			}
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(ss, new File("screenshots/AA/DateSelection2.png"));
		}catch(IOException e) {
			e.getMessage();
		}
		//driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
		//Thread.sleep(2000);
		driver.quit();
	}
}