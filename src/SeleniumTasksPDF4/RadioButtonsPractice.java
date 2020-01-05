package SeleniumTasksPDF4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RadioButtonsPractice extends CommonMethods{
/*
 * TC 2: Radio Buttons Practice 
1. Open chrome browser
2. Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
3. Click on “Input Forms” links
4. Click on “Radio Buttons Demo” links
5. Click on any radio button in “Radio Button Demo” section.
6. Verify correct radio is clicked
7. Click on any radio button in “Group Radio Buttons Demo” section.
8. Verify correct checkbox is clicked
9. Quit browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		System.out.println("---------Radio Button Demo-----");
		List<WebElement> buttons=driver.findElements(By.name("optradio"));
		Thread.sleep(2000);
		for(WebElement button:buttons) {
			button.click();
		driver.findElement(By.id("buttoncheck")).click();
		WebElement message=driver.findElement(By.cssSelector("p.radiobutton"));
		System.out.println(message.getText());
		Thread.sleep(2000);
		}
		System.out.println("---------Group Radio Button Demo-----");
		
		List<WebElement> sexList=driver.findElements(By.name("gender"));
		List<WebElement> ageGroupList=driver.findElements(By.name("ageGroup"));
		for(WebElement sex:sexList) {
			sex.click();
			for(WebElement ageGroup:ageGroupList ) {
				ageGroup.click();
				driver.findElement(By.xpath("//button[@onclick='getValues();']")).click();
				Thread.sleep(2000);
				WebElement message=driver.findElement(By.cssSelector("p.groupradiobutton"));
				System.out.println(message.getText());
			}
			driver.close();
		}
	}
}
