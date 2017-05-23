package com.sqa.jf.helpers;

import java.io.*;

import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;

public class AutoBasics {

	public static String getProp(String propName, String fileLocation, String fileName, Logger logger) {
		return "";
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
