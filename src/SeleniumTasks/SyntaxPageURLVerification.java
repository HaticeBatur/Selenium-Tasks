package SeleniumTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SyntaxPageURLVerification {
	/*
	 * 1. Open chrome browser  2. Navigate to “https://www.zillow.com/” 3. Navigate to “https://www.google.com/"
	 * 4. Navigate back to Zillow Page  5. Refresh current page   6. Verify url contains “Zillow”
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.zillow.com/");
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		String currentTitle=driver.getCurrentUrl();
		System.out.println(currentTitle);
		if(currentTitle.contains("zillow")) {
			System.out.println("Current page contains Zillow");
		}else {
			System.out.println("Current page doesnt contain Zillow");
		}
		
	}
}
