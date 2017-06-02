package com.sqa.jf.helpers;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

public class AutoBasics {

	public static String getProp(String propName, String fileLocation, String fileName, Logger logger) {
		Properties props = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(fileLocation + fileName);
			props.load(input);
		} catch (FileNotFoundException e) {
			logger.warn("Can not load config properties file because it was not found: " + fileName);
		} catch (IOException e) {
			logger.warn("Can not load config properties file can not be read: " + fileName);
		}
		return props.getProperty(propName);
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean takeScreenShot(WebDriver driver, String location, String fileName, Logger logger) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(location + fileName + ".png"));
			return true;
		} catch (IOException e) {
			logger.info("Sorry you had a problem taking the screenshot.");
			return false;
		}
	}

	public static boolean writeProp(String propName, String value, String propTitle, String fileLocation, String fileName, Logger logger) {
		Properties props = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(fileLocation + fileName);
			props.load(input);
		} catch (FileNotFoundException e) {
			logger.warn("Can not load config properties file because it was not found: " + fileName);
			return false;
		} catch (IOException e) {
			logger.warn("Can not load config properties file can not be read: " + fileName);
			return false;
		}
		props.setProperty(propName, value);
		OutputStream output;
		try {
			output = new FileOutputStream(fileLocation + fileName);
			props.store(output, propTitle);
		} catch (FileNotFoundException e) {
			logger.warn("Properties file can not access storage location");
			return false;
		} catch (IOException e) {
			logger.warn("Properties file can not be written");
			return false;
		}
		return true;
	}

	private static String closeAlertAndGetItsText(WebDriver driver, boolean acceptNextAlert) {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	private static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
