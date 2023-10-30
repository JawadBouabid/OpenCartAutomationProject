package com.opencart.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static final String INVALID_PASSWORD = "12345";
	public static final String VALID_PASSWORD = "moha";
	public static final String VALID_EMAIL = "rachid@gmail.com";
	public static final String INVALID_EMAIL = "qwery@gmail.com";

	public static String generateEmailWithTimeStamp() {
		
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		System.out.println(format.format(new Date()));
		return format.format(new Date()) + "@gmail.com";
	}
	
public static String captureScreenshot(WebDriver driver,String testName) {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		
		try {
			FileHandler.copy(srcScreenshot,new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;
	}

}
