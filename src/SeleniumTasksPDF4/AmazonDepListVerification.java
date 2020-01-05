package SeleniumTasksPDF4;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;


public class AmazonDepListVerification extends CommonMethods{
/*
 * TC 1: Amazon Department List Verification
1. Open chrome browser
2. Go to “http://amazon.com/”
3. Verify how many department options available.
● Print each department 
● Select Computers
4. Quit browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://amazon.com/");
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		WebElement  departments=driver.findElement(By.id("searchDropdownBox"));
		Select departSelect=new Select(departments);
		List<WebElement> departList=departSelect.getOptions();
		System.out.println("Total number of main departments -->"+departList.size());
		Iterator<WebElement> departIt=departList.iterator();
		while(departIt.hasNext()) {
			String element=departIt.next().getText();
			if(!element.equals("All Departments")) {
			System.out.println(element);
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='nav-sprite hmenu-arrow-next']//following::i[11]")).click();
		Thread.sleep(2000);
		driver.close();
		
	}
}
