package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUpPage extends AbstractPage {

	private static final Logger logger = LoggerFactory.getLogger(SignUpPage.class);
	WebElement element;

	// **********************************************//
	// * CREATE AN ACCOUNT 							*//
	// **********************************************//
	// button "Submit Create"
	By submitCreateBtn = By.id("SubmitCreate");

	// field "Email address"
	By emailAccountCreateFld = By.id("email_create");

	// **********************************************//
	// * SIGN IN 									*//
	// **********************************************//
	// field "Email address"
	By emailSignInFld = By.id("email");

	// Alert message
	By alertInvalidEmail = By.id("create_account_error");

	public SignUpPage(WebDriver driver) {
		super(driver);
		logger.trace("Constructor: {}", this.getClass());
	}

	public SignUpPage enterEmailToCreateAccount(String email) {
		sendKeys(emailAccountCreateFld, email);
		return new SignUpPage(driver);
	}

	public By getCreateButton() {
		return submitCreateBtn;
	}

	public CreateAccountPage toCreateAccount() {
		getUniqueElement(submitCreateBtn).click();
		return new CreateAccountPage(driver);
	}

	public boolean isButonClickable() {
		return isElementClickable(submitCreateBtn);
	}

	public boolean isElementPresent() {
		return isElementPresent(alertInvalidEmail);
	}

	public String getAlertCreateAccount() {

		boolean alert = isElementPresent(alertInvalidEmail);

		if (alert) {
			return driver.findElement(alertInvalidEmail).getText();
		} else {
			return " ";
		}
	}
}
