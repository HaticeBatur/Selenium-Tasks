package com.class11;

import com.utils.CommonMethods;

public class MethodsTest extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://expedia.com");
		Thread.sleep(3000);
		scroll(450);
		Thread.sleep(3000);
		scroll(-300);
		Thread.sleep(3000);
		driver.quit();
	}

}
