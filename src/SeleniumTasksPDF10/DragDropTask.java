package SeleniumTasksPDF10;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;
/*
 * TC 1: Drag and Drop verification
1. Open chrome browser
2. Go to “https://jqueryui.com/”
3. Click on “Droppable” link
4. Using mouse drag “Drag me to my target” to the “Drop Here”
5. Close the browser
 */
public class DragDropTask extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://jqueryui.com/");
		WebElement target=driver.findElement(By.linkText("Droppable"));
		 
		Actions act=new Actions(driver);
				act.moveToElement(target).click().perform();
		switchToFrame(0);
		WebElement source=driver.findElement(By.cssSelector("div[id='draggable'] p"));
				   target=driver.findElement(By.cssSelector("div[id='droppable'] p"));
			    act.dragAndDrop(source, target).perform();
	
		if(target.getText().contains("Dropped!")) {
			System.out.println("Test Passed");
			TakesScreenshot ts=(TakesScreenshot) driver;
			File screen=ts.getScreenshotAs(OutputType.FILE);
			try{
				FileUtils.copyFile(screen, new File("screenshots/dragDrop/dragDropVerify.png") );
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Test Failed");
		}
		driver.close();
	}
}
