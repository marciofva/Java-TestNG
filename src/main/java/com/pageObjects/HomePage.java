package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends AbstractPage {

	private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

	By loginMenuBy = By.cssSelector("a.login");

	public HomePage(WebDriver driver) {
		super(driver);
		logger.trace("Constructor: {}", this.getClass());
	}

	public SignUpPage toSignUp() {
		System.out.println("toSignUp");
		logger.trace("trace-toSignUp {}.", this.getClass());
		getUniqueElement(loginMenuBy).click();
		return new SignUpPage(driver);
	}

	public By getLoginMenu() {
		return loginMenuBy;
	}

	public boolean isButonClickable() {
		return isElementClickable(loginMenuBy);
	}
}
