package com.sqa.jf.helpers.po;

import com.sqa.jf.helpers.*;

public class BasicPage extends Core {

	private BasicTest curTest;

	public BasicPage(BasicTest test) {
		super(test.getBaseUrl(), test.getDriver());
		this.curTest = test;
	}

	public BasicTest getCurTest() {
		return this.curTest;
	}

	public void setCurTest(BasicTest curTest) {
		this.curTest = curTest;
	}
}
