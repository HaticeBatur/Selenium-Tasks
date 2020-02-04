package SeleniumTasksPDF6;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW2TableHeadersRowsFuntion extends CommonMethods{
/*
 * TC 1: Table headers and rows verification
Open chrome browser
Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
Login to the application
Verify customer “Susan McLaren” is present in the table
Click on customer details
Update customers last name and credit card info
Verify updated customers name and credit card number is displayed in table
Close browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.Smartbears_URL);
		Constants.logInSmartBears();
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		
		//Verify customer “Susan McLaren” is present in the table
		String expectedName="ABC McLaren";
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		for(int i=1; i<rows.size(); i++) {
			String rowText=rows.get(i-1).getText();
			
				if(rowText.contains(expectedName)) {
						System.out.println(expectedName+" is found in the table");
					
					driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+i+"]/td[13]")).click();
					//update last name and credit card info
					WebElement nameBox=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
					String updateInfo="Susan Fernandez";
					nameBox.clear();
					nameBox.sendKeys(updateInfo);
					WebElement creditCardBox=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
					updateInfo="966888744855";
					creditCardBox.clear();
					creditCardBox.sendKeys(updateInfo);	
					//Verify info update
					System.out.println("Name updated-->" +nameBox.getAttribute("value"));
					System.out.println("Credit card number updated-->" +creditCardBox.getAttribute("value"));
					break;
					}
					
		}
		
		driver.findElement(By.id("ctl00_logout")).click();
		driver.close();
	
		
	}
}
