package com.dataproviders;

import org.testng.annotations.DataProvider;

public class testDataFile {

	@DataProvider(name = "invalidEmails")
	public static Object[][] testInvalidEmails_SignIn() {
		Object[][] obj = new Object[5][1];

		obj[0][0] = "llopda";
		obj[1][0] = "jose@uol.com.br";
		obj[2][0] = "@@@";
		obj[3][0] = "mary@.";
		obj[4][0] = "lurdes@123.com";

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
	
	@DataProvider(name = "ValidateGender")
	public static Object[][] ValidateGender() {
		Object[][] obj = new Object[1][1];

		obj[0][0] = "matheus@microsoft.com";

		return obj;
	}
	
	@DataProvider(name = "selectGender")
	public static Object[][] selectGender() {
		Object[][] obj = new Object[2][2];

		obj[0][0] = "jose@uol.com.br";
		obj[0][1] = "m";
		
		obj[1][0] = "marcio@uol.com";
		obj[1][1] = "f";
		
		//obj[2][0] = "mick@msn.com";
		//obj[2][1] = "";
		
		//obj[1][0] = "F";
		//obj[2][0] = "";
		//obj[3][0] = " ";
		//obj[4][0] = "G";

		return obj;
	}

}
