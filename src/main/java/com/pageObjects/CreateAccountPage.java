package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAccountPage extends AbstractPage{
	private static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
	
	//button "Submit Create"
	By submitCreateBtn = By.id("submitAccount");
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		logger.trace("Constructor: {}", this.getClass());
	}
	
	public boolean isPresent(){
		return isElementPresent(submitCreateBtn);
	}
	
	
	public By getCreateBtn(){
		return submitCreateBtn;
	}

}
