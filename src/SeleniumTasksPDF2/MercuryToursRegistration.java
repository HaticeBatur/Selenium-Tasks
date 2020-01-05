package SeleniumTasksPDF2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryToursRegistration {
	/*           USE XPATH ONLY
	 * Go to “http://newtours.demoaut.com/” 3. Click on Register Link 4. Fill out all required info 5. Click Submit 6. User successfully registered
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//a[contains(@href,'mercuryregister')]")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("anna");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Maria");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("3451234567");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("hb@gmail.com");
		driver.findElement(By.xpath("//input[@name='register']")).click();
		WebElement image=driver.findElement(By.xpath("//img[contains(@src,'images/masts')]"));
		if(image.isDisplayed()) {
			System.out.println("User successfully registered");
		}else {
			System.out.println("User could not registered");
		}
		driver.close();		
	}
}
