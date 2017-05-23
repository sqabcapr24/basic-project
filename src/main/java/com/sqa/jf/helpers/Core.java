package com.sqa.jf.helpers;

import org.apache.log4j.*;
import org.openqa.selenium.*;

public class Core {

	private String baseUrl;

	private int curItem = 1;

	private WebDriver driver;

	private Logger log = Logger.getLogger(this.getClass());

	public Core(String baseUrl, WebDriver driver) {
		super();
		this.baseUrl = baseUrl;
		this.driver = driver;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLog() {
		return this.log;
	}

	public boolean present(By by) {
		return AutoBasics.isElementPresent(getDriver(), by);
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public boolean takeScreenshot() {
		boolean takes = AutoBasics.takeScreenShot(getDriver(), "screenshots\\", "Auto Test " + this.curItem, getLog());
		this.curItem++;
		return takes;
	}

	public boolean takeScreenshot(String fileName) {
		return AutoBasics.takeScreenShot(getDriver(), "screenshots\\", fileName, getLog());
	}
}
