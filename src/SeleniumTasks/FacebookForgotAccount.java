package SeleniumTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookForgotAccount {
	/*
	 * 1. Open chrome browser 2. Navigate to Facebook 
	 * 3. Validate that the expected Facebook title matches the  actual Facebook title “Facebook - Log in or Sign up”
	 * 4. Click on Forgot account Links 
	 * 5. Validate that the expected Facebook title matches the  actual Facebook title “Forgot Password | Can't Log In |  Facebook”
	 * 6. Navigate Back  7. Refresh the page  
	 * 8. Validate that the expected Facebook title matches the  actual Facebook title “Facebook - Log in or Sign up”
	 * 9. Close the Browser
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://facebook.com/");
		String expectedTitle="Facebook - Log In or Sign Up";
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase(expectedTitle)) {
			System.out.println("Sign-up title is verified");
		}else {
			System.out.println("Sign-up title is not verified");
		}
		driver.findElement(By.linkText("Forgot account?")).click();
		String expectedTitle2="Forgot Password | Can't Log In | Facebook";
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals(expectedTitle2)) {
			System.out.println("Forgot password title is verified");
		}else {
			System.out.println("Forgot password title is not verified");
		}
		driver.navigate().back();
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase(expectedTitle)) {
			System.out.println("Sign-up title is verified");
		}else {
			System.out.println("Sign-up title is not verified");
		}
		driver.close();
		}
}
