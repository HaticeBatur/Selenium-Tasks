package SeleniumTasksPDF4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class SelectDeselectValues extends CommonMethods{
/*
 * TC 2: Select and Deselect values
5. Open chrome browser
6. Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
7. Click on “Input Forms” links
8. Click on “Select Dropdown List” links
9. Select value from “Select List Demo” section
10. Verify value has been selected
11. Select 4 options from “Multi Select List Demo”
12. Deselect 1 of the option from the dd
13. Quit browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Select Dropdown List")).click();
		WebElement dd=driver.findElement(By.id("select-demo"));
		Select selectDD=new Select(dd);
		selectDD.selectByIndex(5);
		Thread.sleep(2000);
		WebElement text=driver.findElement(By.cssSelector("p.selected-value"));
		System.out.println(text.getText()+" ---> is selected");
		
		WebElement multiDD=driver.findElement(By.id("multi-select"));
		Select selectMultiDD=new Select(multiDD);
		List<WebElement> multiDDList=selectMultiDD.getOptions();
		for(int i=0; i<4; i++) {
			selectMultiDD.selectByIndex(i);
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			WebElement textt=driver.findElement(By.xpath("//p[@class='getall-selected']"));
			System.out.println(textt.getText());
			Thread.sleep(2000);
		}
		
		
		selectMultiDD.deselectByValue("California");
		Thread.sleep(2000);
		driver.close();
	}
}
