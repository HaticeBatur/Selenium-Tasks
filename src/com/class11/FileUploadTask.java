package com.class11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.CommonMethods;

/*
 * TC 1: Upload file and Take Screenshot
1. Navigate to 
“http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload”
2. Upload file
3. Verify file got successfully uploaded and take screenshot
 */
public class FileUploadTask extends CommonMethods {
	public static void main(String[] args) {
		setUp("chrome","http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload");
		driver.findElement(By.cssSelector("input#gwt-debug-cwFileUpload")).sendKeys("C:\\Users\\Owner\\eclipse-workspace\\Sample\\screenshots\\dragDrop\\dragDropVerify.png");
		driver.findElement(By.xpath("//button[text()='Upload File']")).click();
		acceptAlert();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screen=ts.getScreenshotAs(OutputType.FILE);
	
		try {
			FileUtils.copyFile(screen, new File("screenshots/fileUploadTask/fileUpload.png"));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}
}
