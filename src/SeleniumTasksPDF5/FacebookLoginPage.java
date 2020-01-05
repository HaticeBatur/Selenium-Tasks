package SeleniumTasksPDF5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class FacebookLoginPage extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
	
	setUp("chrome","https://facebook.com/");
   
    driver.findElement(By.id("email")).sendKeys("sdk.babadag@gmail.com");
    driver.findElement(By.id("pass")).sendKeys("Laura1286");
    driver.findElement(By.id("u_0_2")).click();
    Thread.sleep(2000);
    Alert alert = driver.switchTo().alert();
    Thread.sleep(2000);
    	alert.accept();
    	
}
}
