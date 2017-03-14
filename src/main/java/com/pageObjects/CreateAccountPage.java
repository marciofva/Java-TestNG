package com.pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
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
	By customer_firstnameFld = By.id("customer_firstname");

	// Lable "Last name"
	By customer_lastnameFld = By.id("customer_lastname");

	// Lable "Email"
	By emailFld = By.id("email");

	// Lable "Password"
	By passwdFld = By.id("passwd");

	// DropDown [Date of Birth] - "days" range from 1 to 31
	By daysCmbBox = By.id("days");

	// DropDown [Date of Birth] - "months" range from January to December
	By monthsCmbBox = By.id("months");

	// DropDown [Date of Birth] - "years" range from 1900 to 2017
	By yearsCmbBox = By.id("years");

	// CheckBox "Sign up for our newsletter!"
	By newsletterChk = By.id("newsletter");

	// CheckBox "Receive special offers from our partners!"
	By optinChk = By.id("optin");

	// **********************************************//
	// * YOUR ADDRESS 								*//
	// **********************************************//
	// Lable "First name"
	By firstnameFld = By.id("firstname");
	
	// Lable "Last name"
	By lastnameFld = By.id("lastname");
	
	// Lable "company's name"
	By companyFld = By.id("company");
	
	// Lable "Address" - Main address
	By addressFld = By.id("address1");
	
	// Lable "Address (line 2)" - Complement
	By address2Fld = By.id("address2");
	
	// Lable "city"
	By cityFld = By.id("city");
	
	// DropBox "State"
	By stateDropBox = By.id("id_state");
	
	// Lable "Postcode"
	By postcodeFld = By.id("postcode");
	
	// DropBox "State"
	By countryDropBox = By.id("id_country");
	
	// TxtArea "Additional information"
	By informationTxtArea = By.id("other");
	
	// Lable "Phone"
	By phoneFld = By.id("phone");

	// Lable "Phone"
	By mobileFld = By.id("phone_mobile");
	
	// Lable "Address Alias"
	By addressAliasFld = By.id("alias");
	


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
	
	// **********************************************//
	// * REGISTER									*//
	// **********************************************//
	// Button "Register"
	By submitCreateBtn = By.id("submitAccount");
	
	// **********************************************//
	// * SUCCESS SIGN IN							*//
	// **********************************************//
	// link "Sign out"
	By logoutMenuBy = By.cssSelector("a.logout");
	

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		logger.trace("Constructor: {}", this.getClass());
	}

	public boolean isPresent_RegisterBtn() {
		return isElementPresent(submitCreateBtn);
	}

	public void clickOn() {

		if (isElementClickable(submitCreateBtn)) {
			clickEvent(submitCreateBtn);
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
			clickEvent(genderRadioMrs);
			break;
		case "f":
			clickEvent(genderRadioMr);
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

	public List<WebElement> getAllAlerts() {
		isElementPresent(alertMessage);
		List<WebElement> elements = driver.findElements(alertMessage);
		return elements;
	}
	
	public void enterFirstName(String txt) {
		sendKeys(customer_firstnameFld, txt);
	}
	
	public void enterLastName(String txt) {
		sendKeys(customer_lastnameFld, txt);
	}
	
	public void enterPassword(String txt) {
		driver.findElement(passwdFld).sendKeys(txt);
	}
	
	public void enterDayBirth(String txt){
		SelectByValue_DropDown(daysCmbBox, txt);
	}
	
	public void enterMonthBirth(int month){	
		SelectByIndex_DropDown(monthsCmbBox, month);
	}
	
	public void enterYearBirth(String txt){	
		SelectByValue_DropDown(yearsCmbBox, txt);
	}
	
	public void selectNewsLetter(){
		clickEvent(newsletterChk);
	}
	
	public void selectSpecialOffers(){
		clickEvent(optinChk);
	}
	
	//--------------------------------------------------//
	// 					ADDRESS DATA					//
	//--------------------------------------------------//
	
	public void enterCompany(String txt) {
		sendKeys(companyFld, txt);
	}
	
	public void enterAddress(String txt) {
		sendKeys(addressFld, txt);
	}
	
	
	public void enterAddress2(String txt) {
		sendKeys(address2Fld, txt);
	}
	

	public void enterCity(String txt) {
		sendKeys(cityFld, txt);
	}
	
	public void enterState(String txt){		
		selectByVisibleText_DropDown(stateDropBox, txt);
	}
	
	public void enterPostCode(String txt) {
		sendKeys(postcodeFld, txt);
	}
	
	public void enterCountry(String txt) {
		selectByVisibleText_DropDown(countryDropBox, txt);
	}
	
	public void enterAdditionInformation(String txt) {
		sendKeys(informationTxtArea, txt);
	}
	
	public void enterPhone(String txt) {
		sendKeys(phoneFld, txt);
	}
	
	public void enterMobile(String txt) {
		sendKeys(mobileFld, txt);
	}
	
	public void enterAddressAlias(String txt) {
		sendKeys(addressAliasFld, txt);
	}
	
	public WebElement getLogoutMenuBy(){
		return getUniqueElement(logoutMenuBy);
		
	}
}
