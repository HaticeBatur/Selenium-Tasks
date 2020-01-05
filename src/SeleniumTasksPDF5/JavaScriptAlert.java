package SeleniumTasksPDF5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class JavaScriptAlert extends CommonMethods{
/*
 * TC 1: JavaScript alert text verification
1. Open chrome browser
2. Go to  “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
3. Click on “Alerts & Modals” links
4. Click on “Javascript Alerts” links
5. Click on button in “Java Script Alert Box” section
6. Verify alert box with text “I am an alert box!” is present
7. Click on button in “Java Script Confirm Box” section
8. Verify alert box with text “Press a button!” is present
9. Click on button in “Java Script Alert Box” section
10. Enter text in the alert box
11. Quit browser
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Thread.sleep(2000);
		Alert simpleAlert=driver.switchTo().alert();
		System.out.println("Simple alert text "+simpleAlert.getText());
		simpleAlert.accept();
		System.out.println();
		
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Alert confirmboxAlert=driver.switchTo().alert();
		Thread.sleep(2000);
		if(confirmboxAlert.getText().equals("Press a button!")) {
			System.out.println("Text is verified-->"+confirmboxAlert.getText());
		}else {
			System.out.println("Text is not verified--> "+confirmboxAlert.getText());
		}
		confirmboxAlert.dismiss();
		Thread.sleep(3000);
		System.out.println();
		
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Alert promptboxAlert=driver.switchTo().alert();
		promptboxAlert.sendKeys("Hatice");
		Thread.sleep(3000);
		promptboxAlert.dismiss();
		Thread.sleep(3000);
		
		driver.close();
	}
}
