package com.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class WebTableDemo extends CommonMethods{
	public static void main(String[] args) {
		setUp("chrome", Constants.SYNTAX_PRACTICE_URL);
		
		//navigate to table we need
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		//number of rows
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("Number of rows in the table is="+rows.size());
		System.out.println("Printing row data----------");
		Iterator<WebElement> rowsIt=rows.iterator();
		while(rowsIt.hasNext()) {
			String rowData=rowsIt.next().getText();
			System.out.println(rowData);
		}
		
		//number of columns
		List<WebElement> cols=driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("Number of rows in the table is="+cols.size());
		
		System.out.println("Printing columns headers----------------------------");
		for(WebElement col:cols) {
			String header=col.getText();
			System.out.println(header);
		}
		System.out.println("Printing All Names------------");
		List<WebElement> nameCol=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td[3]"));
		for(WebElement names:nameCol) {
			String namesData=names.getText();
			System.out.println(namesData);
		}
		driver.close();
	}

}
