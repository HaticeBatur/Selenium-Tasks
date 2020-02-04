package Udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class ClearTrip extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.cleartrip.com/");
		driver.findElement(By.id("RoundTrip")).click();
		WebElement origin=driver.findElement(By.id("FromTag"));
		origin.sendKeys("new");
		Thread.sleep(3000);
		origin.sendKeys(Keys.ARROW_DOWN);
		origin.sendKeys(Keys.ENTER);
		//select depart city and arrival city
		WebElement destiny=driver.findElement(By.id("ToTag"));
		Thread.sleep(3000);
		destiny.sendKeys("new");
		Thread.sleep(3000);
		destiny.sendKeys(Keys.ARROW_DOWN); destiny.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		destiny.sendKeys(Keys.ENTER);
		//select depart date and return date
		driver.findElement(By.xpath("//input[@id='DepartDate']//..//a//i")).click();
		String[] month= {"June 2020", "January 2022"}; 
		String[] day= {"21", "14"};
		String first="//div[@class='monthBlock first']";
		String last="//div[@class='monthBlock last']";
		String title="//div[@class='title']";
		String tableXpath="//table[@class='calendar']//tbody/tr/td";
		for(int i=0; i<month.length; i++) {
			Thread.sleep(2000);
			boolean flag=false;
		while(!flag) {
			WebElement firstCalendar=driver.findElement(By.xpath(first+title));
			WebElement lastCalendar=driver.findElement(By.xpath(last+title));
			List<WebElement> dayTable;
		if(month[i].equals(firstCalendar.getText()) || month[i].equals(lastCalendar.getText())) {
				dayTable=driver.findElements(By.xpath(first+tableXpath));
			if(month[i].equals(lastCalendar.getText())) {
				dayTable=driver.findElements(By.xpath(last+tableXpath));
			}
			for(WebElement dayElement:dayTable) {
				if(dayElement.getText().equals(day[i])) {
					dayElement.click();
					flag=true;
					break;
				}
			}	
		}
		else {
			driver.findElement(By.xpath("//a[@class='nextMonth ']")).click();
		}
	 }
   }
		WebElement adult=driver.findElement(By.id("Adults"));
		Select select=new Select(adult);
		select.selectByValue("2");
		
		WebElement child=driver.findElement(By.id("Childrens"));
		select=new Select(child);
		select.selectByValue("3");
		driver.findElement(By.id("SearchBtn")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.className("searchSummary")).isDisplayed()) {
			System.out.println("Search summary is displayed");
		}else {
			System.out.println("Search summary is not displayed");
		}
		driver.close();
		}
}
