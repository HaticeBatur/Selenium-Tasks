package Udemy;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TCforGreenSky {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.greensky.com/");
		//Get the title of parent window
		System.out.println("Title of the main Window: "+driver.getTitle());
		//Go to ‘make a payment’ 
		WebElement makePaym=driver.findElement(By.xpath("//*[@id='menu-gscp-secondary']/li/a/span"));
		if(makePaym.isDisplayed()) {
			System.out.println("The text ‘Make a payment’ displayed on the window");
		}else {
			System.out.println("Text NOT displayed on the window");
		}
		makePaym.click();
		Set<String> windowsID= driver.getWindowHandles();
		Iterator<String> it=windowsID.iterator();
		String parentW=it.next();
		String childW=it.next();
		driver.switchTo().window(childW);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("user_id")).sendKeys("Anna");
		driver.findElement(By.id("password1")).sendKeys("Anna@123");
		driver.findElement(By.xpath("//*[@id='submit_button']")).click();
		
		//finding alert box
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

		driver.findElement(By.xpath("//*[@id='portal']/div[7]/div/div/div[3]/button")).click();
		TakesScreenshot ts=(TakesScreenshot)driver;
		//call method getScreenshotAs and specify output type
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try {
			//copy file to the specified destination and give name and extension
			FileUtils.copyFile(screen, new File("screenshots/GreenSky/PRAValidation.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
