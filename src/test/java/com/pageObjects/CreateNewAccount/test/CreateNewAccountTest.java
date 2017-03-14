package com.pageObjects.CreateNewAccount.test;

import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.configuration.test.ConfigTest;
import com.dataproviders.testDataFile;
import com.pageObjects.SignUp.test.SignUpTest;

public class CreateNewAccountTest extends ConfigTest {

	private static final Logger logger = LoggerFactory.getLogger(SignUpTest.class);

	public static final int SIZE = 2;
	public static final String GENDER_MALE = "M";
	public static final String GENDER_FEMALE = "F";

	@Test(enabled = false, priority = 1, dataProviderClass = testDataFile.class, dataProvider = "ValidateGender")
	public void validateGender(String emailAddress) throws Throwable {

		logger.trace("Test Case: validateGender {}", this.getClass());

		accessAccountPage(emailAddress);

		Assert.assertEquals("Size of genders is NOT valid", SIZE, accountObj.getSizeGender());
		Assert.assertFalse("Gender 'Mr.' should NOT be selected", accountObj.isSelectGender(GENDER_MALE));
		Assert.assertFalse("Gender 'Mrs.' should NOT be selected", accountObj.isSelectGender(GENDER_FEMALE));
	}

	@Test(enabled = false, priority = 2, dataProviderClass = testDataFile.class, dataProvider = "selectGender")
	public void selectGender(String emailAddress, String gender) throws Throwable {

		logger.trace("Test Case: selectGender {}", this.getClass());

		accessAccountPage(emailAddress);
		accountObj.selectGender(gender);
		assertTrue("Gender not selected", accountObj.isSelectGender(gender));
	}

	@Test(enabled = false, priority = 3, dataProviderClass = testDataFile.class, dataProvider = "invalidFirstName")
	public void validateFistName(String emailAddress) throws Throwable {

		logger.trace("Test Case: validateFistName {}", this.getClass());

		accessAccountPage(emailAddress);

		accountObj.clickOn();
		accountObj.getAllAlerts();

		boolean found = false;
		
		for (int i = 0; i < accountObj.getAllAlerts().size(); i++) {
			if ((accountObj.getAllAlerts().get(i).getText()).equals("firstname is required.")) {
				found = true;
				break;
			}
		}
		 
		assertTrue("Alert Message 'firstname is required.' is not displayed", found);
	}
	
	@Test(enabled = true, priority = 4, dataProviderClass = testDataFile.class, dataProvider = "enterAllFields")
	public void enterAllValidFields(String emailAddress, 
									String gender, 
									String firstName, 
									String lastName, 
									String password,
									String day, 
									int month, 
									String year, 
									String company, 
									String address, 
									String address2, 
									String city, 
									String state,
									String zipCode, 
									String country, 
									String information, 
									String phone, 
									String mobile, 
									String alias) {
		logger.trace("Test Case: enterAllValidFields {}", this.getClass());

		accessAccountPage(emailAddress);
		
		accountObj.selectGender(gender);
		accountObj.enterFirstName(firstName);
		accountObj.enterLastName(lastName);
		accountObj.enterPassword(password);
		accountObj.enterDayBirth(day);
		accountObj.enterMonthBirth(month);
		accountObj.enterYearBirth(year);
		accountObj.selectNewsLetter();
		accountObj.selectSpecialOffers();
		accountObj.enterCompany(company);
		accountObj.enterAddress(address);
		accountObj.enterAddress2(address2);
		accountObj.enterCity(city);
		accountObj.enterState(state);
		accountObj.enterPostCode(zipCode);
		accountObj.enterCountry(country);
		accountObj.enterAdditionInformation(information);
		accountObj.enterPhone(phone);
		accountObj.enterMobile(mobile);
		accountObj.enterAddressAlias(alias);
		
		accountObj.clickOn();
		
		Assert.assertEquals("Sign out", accountObj.getLogoutMenuBy().getText());
	}

	public void accessAccountPage(String emailAddress) {
		signUpObj.enterEmailToCreateAccount(emailAddress);
		accountObj = signUpObj.toCreateAccount();
		assertTrue("Element \'" + accountObj.getCreateBtn().toString() + "\' not found for "
				+ accountObj.getClass().getSimpleName(), accountObj.isPresent_RegisterBtn());
	}
}
