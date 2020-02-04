package com.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TaskTableHeadAndRows extends CommonMethods{
/*
 * TC 1: Table headers and rows verification
Open chrome browser
Go to “http://166.62.36.207/syntaxpractice/”
Click on “Table” link
Click on “ITable Data Search” link
Verify second table consist of 4 rows and 5 columns
Print name of all column headers 
Print data of all rows
Quit Browser
 */
	public static void main(String[] args) {
		setUp("chrome", Constants.SYNTAX_PRACTICE_URL);
		
		//navigate to table we need
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		//number of columns
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th"));
		System.out.println("Number of columns in the second header of the table is="+cols.size());
				
		System.out.println("Printing columns of the second header----------------------------");
		for(WebElement col:cols) {
		String header=col.getText();
		System.out.println(header);
		}
		/*
		 * xpath("//table[@class='table']/thead[2]/tr/th")
		 * 1.table[@class='table'] -- table element
		 * 2. / tbody - from table going inside the tbody
		 * 3. tr/ from tbody into rows (not specific row)
		 * 4. /td -going into the  table data -->cell
		 */
		
		//number of rows
		List<WebElement> cells=driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		System.out.println("Number of rows in the table is="+cells.size());
		System.out.println("Printing rows data----------");
		Iterator<WebElement> cellsIt=cells.iterator();
		while(cellsIt.hasNext()) {
			String cellsData=cellsIt.next().getText();
			System.out.println(cellsData);
		}
		System.out.println("Printing cell by cell by using for loop--------");
		for(int i=1; i<=cells.size(); i++) {
			for(int y=1; y<=cols.size(); y++) {
				String cellText=driver.
					findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td["+y+"]")).getText();
			System.out.print(cellText+"--");
			}
			System.out.println();
		}
		driver.close();
	}
}
