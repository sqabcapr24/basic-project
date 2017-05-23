package com.sqa.jf.helpers;

import java.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.testng.annotations.*;

public abstract class BasicTest extends Core {

	public BasicTest(String baseUrl) {
		super(baseUrl, null);
	}

	@BeforeClass(enabled = false)
	public void setUpChrome() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		setDriver(new ChromeDriver());
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(getBaseUrl());
	}

	@BeforeClass(enabled = true)
	public void setUpFirefox() throws Exception {
		setDriver(new FirefoxDriver());
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(getBaseUrl());
	}

	@BeforeClass(enabled = false)
	public void setUpIE() throws Exception {
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		setDriver(new InternetExplorerDriver());
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(getBaseUrl());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		getDriver().quit();
	}
}
