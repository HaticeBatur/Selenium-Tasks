package SeleniumTasksPDF3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class AmazonLinkCount extends CommonMethods {
/*
 * TC 1: Amazon link count: 
1. Open chrome browser
2. Go to “https://www.amazon.com/”
3. Get all links
4. Get number of links that has text
5. Print to console only the links that has text
 */
	public static void main(String[] args) {
		CommonMethods.setUp("chrome", "https://www.amazon.com/");
		List<WebElement> linkList=driver.findElements(By.xpath("//a[@href]"));
		int count=0;
		for(WebElement element:linkList) {
			String link=element.getText();
			if(!link.isEmpty()) {
				System.out.println(link);
				count++;
			}
		}
		System.out.println("Number of total links-->"+linkList.size());
		System.out.println("Number of links which are not empty-->"+count);
		driver.close();
	}
}
