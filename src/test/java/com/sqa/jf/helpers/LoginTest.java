package com.sqa.jf.helpers;

import org.testng.annotations.*;

import com.sqa.jf.helpers.*;

public abstract class LoginTest extends BasicTest {

	public LoginTest(String baseUrl) {
		super(baseUrl);
	}

	public abstract void login();

	public abstract void logout();

	@Override
	@BeforeClass(enabled = true)
	public void setUpFirefox() throws Exception {
		super.setUpFirefox();
		login();
	}

	@Override
	@AfterClass
	public void tearDown() throws Exception {
		logout();
		getDriver().quit();
	}
}
