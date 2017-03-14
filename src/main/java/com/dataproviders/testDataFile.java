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
		
		return obj;
	}
	
	@DataProvider(name = "invalidFirstName")
	public static Object[][] invalidFirstName(){
		Object[][] obj = new Object[1][1];
		
		obj[0][0] = "michelle@google.com";
		
		return obj;
	}
	
	@DataProvider(name = "enterAllFields")
	public static Object[][] enterAllFields(){
		Object[][] obj = new Object[1][19];
		
		obj[0][0] = "Manuel8@test.com";
		obj[0][1] = "m";
		obj[0][2] = "Carlos";
		obj[0][3] = "cornor";
		obj[0][4] = "98765";
		obj[0][5] = "18";
		obj[0][6] = 06;
		obj[0][7] = "1984";
		obj[0][8] = "Emp01";
		obj[0][9] = "St. leonards street";
		obj[0][10] = "Apartment";
		obj[0][11] = "NYC";
		obj[0][12] = "Arizona"; 
		obj[0][13] = "87601";
		obj[0][14] = "United States";
		obj[0][15] = "Information 01";
		obj[0][16] = "009578423";
		obj[0][17] = "234525622";
		obj[0][18] = "SuperNatural";
		
		return obj;
	}

}
