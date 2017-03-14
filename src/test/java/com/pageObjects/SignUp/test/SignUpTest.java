package com.pageObjects.SignUp.test;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.configuration.test.ConfigTest;
import com.dataproviders.testDataFile;

public class SignUpTest extends ConfigTest {

	private static final Logger logger = LoggerFactory.getLogger(SignUpTest.class);

	@Test(dataProviderClass = testDataFile.class, dataProvider = "invalidEmails")
	public void enterInvalidEmail(String emailAddress) {

		logger.trace("Test Case: enterInvalidEmail {}", this.getClass());

		signUpObj.enterEmailToCreateAccount(emailAddress);

		assertTrue("Element \'" + signUpObj.getCreateButton().toString() + "\' not found for "
				+ signUpObj.getClass().getSimpleName(), signUpObj.isButonClickable());

		signUpObj.toCreateAccount();

		Assert.assertEquals(signUpObj.getAlertCreateAccount(), "Invalid email address.");
	}

	@Test(dataProviderClass = testDataFile.class, dataProvider = "validEmails")
	public void enterValidEmail(String emailAddress) {

		logger.trace("Test Case: enterValidEmail {}", this.getClass());

		signUpObj.enterEmailToCreateAccount(emailAddress);

		assertTrue("Element \'" + signUpObj.getCreateButton().toString() + "\' not found for "
				+ signUpObj.getClass().getSimpleName(), signUpObj.isButonClickable());

		accountObj = signUpObj.toCreateAccount();

		assertTrue("Element \'" + accountObj.getCreateBtn().toString() + "\' not found for "
				+ accountObj.getClass().getSimpleName(), accountObj.isPresent_RegisterBtn());
	}

}
