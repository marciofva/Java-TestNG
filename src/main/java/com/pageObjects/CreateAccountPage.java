package com.pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAccountPage extends AbstractPage {

	private static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
	WebElement element;

	// **********************************************//
	// * YOUR PERSONAL INFORMATION *//
	// **********************************************//
	// Group of Gender
	// By genderRadio = By.cssSelector(".radio-inline");
	By genderRadio = By.name("id_gender");

	// Radio "Title" - Ms.
	By genderRadioMr = By.id("id_gender1");

	// Radio "Title" - Mrs.
	By genderRadioMrs = By.id("id_gender2");

	// Lable "First name"
	By firstnameFld = By.id("customer_firstname");

	// Lable "Last name"
	By lastnameFld = By.id("customer_lastname");

	// Lable "Email"
	By emailFld = By.id("email");

	// Lable "Password"
	By passwdFld = By.id("passwd");

	// DropBox [Date of Birth] - "days" range from 1 to 31
	By daysCmbBox = By.id("days");

	// DropBox [Date of Birth] - "months" range from January to December
	By monthsCmbBox = By.id("months");

	// DropBox [Date of Birth] - "years" range from 1900 to 2017
	By yearsCmbBox = By.id("years");

	// CheckBox "Sign up for our newsletter!"
	By newsletterChk = By.id("newsletter");

	// CheckBox "Receive special offers from our partners!"
	By optinChk = By.id("optin");

	// **********************************************//
	// * YOUR ADDRESS *//
	// **********************************************//

	// button "Submit Create"
	By submitCreateBtn = By.id("submitAccount");

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		logger.trace("Constructor: {}", this.getClass());
	}

	public boolean isPresent() {
		return isElementPresent(submitCreateBtn);
	}

	public By getCreateBtn() {
		return submitCreateBtn;
	}

	public void selectGender(String gender) {

		switch (gender.toLowerCase()) {
		case "m":
			driver.findElement(genderRadioMrs).click();
			break;
		case "f":
			driver.findElement(genderRadioMr).click();
			break;
		default:
			assertTrue("Gender '" + gender + "' is invalid to select the field'" + genderRadio.toString() + "\' in "
					+ this.getClass().getSimpleName(), false);
		}
	}

	public boolean isSelectGender(String gender) {

		switch (gender.toLowerCase()) {
		case "m":
			element = driver.findElement(genderRadioMrs);
			break;
		case "f":
			element = driver.findElement(genderRadioMr);
			break;
		}
		return element.isSelected();
	}

	public int getSizeGender() {
		return driver.findElements(genderRadio).size();
	}

	public By getGenderRadioMr() {
		return genderRadioMr;
	}

	public By getGenderRadioMrs() {
		return genderRadioMrs;
	}

}
