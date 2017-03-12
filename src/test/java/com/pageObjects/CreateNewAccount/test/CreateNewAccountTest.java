package com.pageObjects.CreateNewAccount.test;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.configuration.test.ConfigTest;
import com.dataproviders.testDataFile;
import com.pageObjects.SignUp.test.SignUpTest;

import junit.framework.Assert;

public class CreateNewAccountTest extends ConfigTest {

	private static final Logger logger = LoggerFactory.getLogger(SignUpTest.class);
	
	public static final int SIZE = 2;
	public static final String GENDER_MALE = "M";
	public static final String GENDER_FEMALE = "F";

	@Test(enabled = true,priority = 1, dataProviderClass = testDataFile.class, dataProvider = "ValidateGender")
	public void validateGender(String emailAddress) throws Throwable {
		
		logger.trace("Test Case: validateGender {}", this.getClass());
		
		accessAccountPage(emailAddress);

		Assert.assertEquals("Size of genders is NOT valid", SIZE, accountObj.getSizeGender());
		Assert.assertFalse("Gender 'Mr.' should NOT be selected", accountObj.isSelectGender(GENDER_MALE));
		Assert.assertFalse("Gender 'Mrs.' should NOT be selected", accountObj.isSelectGender(GENDER_FEMALE));
	}

	@Test(enabled = true, priority = 2, dataProviderClass = testDataFile.class, dataProvider = "selectGender")
	public void selectGender(String emailAddress, String gender) throws Throwable {
		
		logger.trace("Test Case: selectGender {}", this.getClass());

		accessAccountPage(emailAddress);
		accountObj.selectGender(gender);
		assertTrue("Gender not selected", accountObj.isSelectGender(gender));
	}

	public void accessAccountPage(String emailAddress) {
		signUpObj.enterEmailToCreateAccount(emailAddress);
		accountObj = signUpObj.toCreateAccount();
		assertTrue("Element \'" + accountObj.getCreateBtn().toString() + "\' not found for "
				+ accountObj.getClass().getSimpleName(), accountObj.isPresent());
	}
}