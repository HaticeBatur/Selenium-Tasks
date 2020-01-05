package SeleniumTasksPDF4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class FacebookDropdownVerification extends CommonMethods{
/*
 * TC 1: Facebook dropdown verification
1. Open chrome browser
2. Go to “https://www.facebook.com”
3. Verify:
● month dd has 12 month options
● day dd has 31 day options
● year dd has 115 year options
4. Select your date of birth
5. Quit browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.facebook.com");
		WebElement month=driver.findElement(By.id("month"));
		Select selectMonth=new Select(month);
		List<WebElement> monthList=selectMonth.getOptions();
		System.out.println("------List The Months By Using Iterator------");
		Iterator<WebElement> monthIt=monthList.iterator();
		while(monthIt.hasNext()) {
			String monthText=monthIt.next().getText();
			System.out.print(monthText+", ");
		}
		System.out.println();
		System.out.println("------List The Days By Enhanced For Loop------");
		WebElement day=driver.findElement(By.id("day"));
		Select selectDay=new Select(day);
		List<WebElement> dayList=selectDay.getOptions();
		for(WebElement day1:dayList) {
			System.out.print(day1.getText()+", ");
		}
		System.out.println();
		System.out.println("------List The Years By Enhanced For Loop------");
		WebElement year=driver.findElement(By.id("year"));
		Select selectYear=new Select(year);
		List<WebElement> yearList=selectYear.getOptions();
		for(WebElement year1:yearList) {
			System.out.print(year1.getText()+", ");
		}
		System.out.println();
		selectMonth.selectByIndex(9); selectDay.selectByIndex(8);  selectYear.selectByVisibleText("1990");
		Thread.sleep(2000);
		
		System.out.println();
		WebElement myMont=driver.findElement(By.xpath("//select[@id='month']//following::option[6]"));
		WebElement myDay=driver.findElement( By.xpath("//select[@id='day']//following::option[18]"));
		WebElement myYear=driver.findElement( By.xpath("//option[@value='1980']"));
		List<WebElement> myDate=new ArrayList<WebElement>();
		myDate.add(myMont);
		myDate.add(myDay);
		myDate.add(myYear);
		for(WebElement date:myDate) {
			System.out.print(date.getText()+"/");
		}
		driver.close();
	}
}
