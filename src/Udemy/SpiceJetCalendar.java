package Udemy;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class SpiceJetCalendar extends CommonMethods{
	public static void main(String[] args) throws InterruptedException  {
		setUp("chrome", "http://spicejet.com");
		driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
		String cities[]= {"Dehradun (DED)","Jaipur (JAI)"}, months[]= {"May", "December"}, days[]= {"15", "23"};
		
		for(int i=0; i<cities.length; i++) {
			List<WebElement> citySet=driver.findElements(By.xpath("//div[@id='dropdownGroup1']/div//li"));
			for(WebElement city:citySet) {
			if(city.getText().equals(cities[i])) {
				city.click();
				break;
			}	}  }
	
				for(int i=0; i<months.length; i++ ) {
			boolean flag=false;
		while(!flag) {
			String calendar1="//div[@class='ui-datepicker-group ui-datepicker-group-first']";
			String calendar2="//div[@class='ui-datepicker-group ui-datepicker-group-last']";
			String table="//table[@class='ui-datepicker-calendar']/tbody/tr/td";
			String left=driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']")).getText();
			String right=driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']")).getText();
			String calendar;
			if(left.contains(months[i])||right.contains(months[i])) {
				 calendar=calendar1;
					if(right.contains(months[i])) {
						calendar=calendar2;
					}
		List<WebElement> rows=driver.findElements(By.xpath(calendar+table));
				for(WebElement dayElement:rows) {
				String day=dayElement.getText();
					if(day.equals(days[i])) {
				dayElement.click();
				break;
					}	
				}
				flag=true;
				break;
			}
			else {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		if(i==0) {
		driver.findElement(By.xpath("//div[@class='picker-second']//button")).click();
		}
	}
				driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		Thread.sleep(2000);
			WebElement link=driver.findElement(By.id("highlight-book"));
			if(link.isDisplayed()) {
				System.out.println("Test passed");
				TakesScreenshot ts=(TakesScreenshot)driver;
				File screen=ts.getScreenshotAs(OutputType.FILE);
				try {
				FileUtils.copyFile(screen, new File("screenshots/SpiceJet/ChooseFlight.png"));
				}catch(IOException e){
					e.printStackTrace();
			}
			}else {
				System.out.println("Test failed");
			}
		driver.quit();
	}
}
