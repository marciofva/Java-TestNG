package com.dataproviders;

import org.testng.annotations.DataProvider;

public class testDataFile {

	@DataProvider(name = "invalidEmails")
	public static Object[][] testInvalidEmails_SignIn() {
		Object[][] obj = new Object[4][1];

		obj[0][0] = "llopda";
		obj[1][0] = "jose@uol.com.br";
		obj[2][0] = "@@@";
		obj[3][0] = "mary@.";

		return obj;
	}

	@DataProvider(name = "validEmails")
	public static Object[][] testValidEmails_signIn() {
		Object[][] obj = new Object[5][1];

		obj[0][0] = "jhon@uol.com";
		obj[1][0] = "Michael@outlook.com";
		obj[2][0] = "bruno_soares@test.com";
		obj[3][0] = "vilma12@test.eu";
		obj[4][0] = "cristian88.r@bol.com";

		return obj;
	}

}
