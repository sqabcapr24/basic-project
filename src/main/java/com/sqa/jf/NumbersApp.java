package com.sqa.jf;

import com.sqa.jf.helpers.*;

public class NumbersApp {

	public static void main(String[] args) {
		String name = AppBasics.greetUser("Numbers App");
		addNumbers();
		AppBasics.farewellUser(name);
	}

	private static void addNumbers() {
		int number1 = AppBasics.requestInt("Can I get a number:");
		int number2 = AppBasics.requestInt("Can I get another number:");
		int total = number1 + number2;
		System.out.println("Looks like you have a total of " + total);
	}
}
