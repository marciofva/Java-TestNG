package com.pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAccountPage extends AbstractPage {

	private static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
	WebElement element;
	List<WebElement> elements;

	// **********************************************//
	// * YOUR PERSONAL INFORMATION 					*//
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
	// * YOUR ADDRESS 								*//
	// **********************************************//

	// Button "Register"
	By submitCreateBtn = By.id("submitAccount");

	// **********************************************//
	// * ALERT MESSAGES 							*//
	// **********************************************//
	// Get all alert messages
	By alertMessage = By.cssSelector("#center_column .alert.alert-danger ol li");

	// Get First Name alert
	By firstNameAlert = By.cssSelector(".form-error #customer_lastname");

	String[] alerts = { 
			"You must register at least one phone number.", 
			"lastname is required.",
			"firstname is required.", 
			"passwd is required.", 
			"address1 is required.", "city is required.",
			"The Zip/Postal code you've entered is invalid. It must follow this format: 00000",
			"This country requires you to choose a State." 
			};

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		logger.trace("Constructor: {}", this.getClass());
	}

	public boolean isPresent() {
		return isElementPresent(submitCreateBtn);
	}

	public void clickOn() {

		// element = driver.findElement(submitCreateBtn);
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", element);

		if (isElementClickable(submitCreateBtn)) {
			driver.findElement(submitCreateBtn).click();
			driver.findElement(submitCreateBtn).click();
			System.out.println("clicou!!!");
		} else {
			assertTrue("Button '" + submitCreateBtn.toString() + "' is not clickable in "
					+ this.getClass().getSimpleName(), false);
		}
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

	public void fillFirstName(String txt) {
		driver.findElement(firstnameFld).sendKeys(txt);
	}

	public List<WebElement> getAllAlerts() {
		isElementPresent(alertMessage);
		List<WebElement> elements = driver.findElements(alertMessage);
		return elements;
	}
}
