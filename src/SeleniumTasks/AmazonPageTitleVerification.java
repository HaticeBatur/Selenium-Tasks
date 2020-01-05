package SeleniumTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPageTitleVerification {
	/*
	 * 1. Open chrome browser 2. Go to “https://www.amazon.com/” 
	 * 3. Verify Title “Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more” is displayed
	 */
	public static final String URL="https://www.amazon.com/";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		String actualTitle=driver.getTitle();
		String expectedTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title is verified");
		}else {
			System.out.println("Title is not verified");
		}
		
		
	}
}
