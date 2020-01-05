package SeleniumTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenPageChromeBrowser {
	/*
	 * Open Chrome Browser. Navigate to “https://github.com/”
	 * Open Firefox browser. Navigate to “https://www.redfin.com/”
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.get("https://github.com/");
		driver.navigate().to("https://github.com/");
		System.out.println(driver.getTitle());
		
		System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
		WebDriver driverr=new FirefoxDriver();
		driverr.get("https://www.redfin.com/");
		System.out.println(driverr.getTitle());
		//driverr.navigate().to("https://www.redfin.com/");
	}
}
