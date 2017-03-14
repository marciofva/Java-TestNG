package com.pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected WebElement element;
	protected Select mySelect;

	private static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.wait = (new WebDriverWait(driver, 15));
		logger.trace("Constructor: {}", this.getClass());
	}

	
	public void clickEvent(By locator){
		
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			assertTrue("Element '" + locator.toString() + "\' not found for " + this.getClass().getSimpleName(),false);
		}
	}
	
	public void sendKeys(By locator, String txt){
		
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(txt);
		} catch (NoSuchElementException e) {
			assertTrue("Element '" + locator.toString() + "\' not found for " + this.getClass().getSimpleName(),false);
		}
	}
	
	
	public WebElement getUniqueElement(By selector) {
		
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (NoSuchElementException e) {
			logger.error("getUniqueElement: {} " + e, this.getClass());
		}

		List<WebElement> elements = driver.findElements(selector);
		assertTrue("Unique Element \'" + selector.toString() + "\' not found for " + this.getClass().getSimpleName(),
				(elements.size() == 1));
		return elements.get(0);
	}

	public boolean isElementClickable(By locator) {
		logger.trace("Check whether Element '" + locator + "' is clickable - {}.", this.getClass());
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	

	public boolean isElementPresent(By locator) {
		logger.trace("Check whether Element '" + locator + "' is present in the page - {}.", this.getClass());
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (NoSuchElementException e) {
		} catch(TimeoutException r){
			logger.error("Timeout: '" + r.getMessage()+"' {}.", this.getClass());
			assertTrue("Timeout: '" + r.getMessage()+"  - Element '" + locator.toString() + "\' not found for " + this.getClass().getSimpleName(),false);
		}		
		return false;
	}
	
	public void SelectByValue_DropDown(By locator, String txt){
		
		try {
			element = driver.findElement(locator); 
		} catch (NoSuchElementException e) {
			assertTrue("Element '" + locator.toString() + "\' not found for " + this.getClass().getSimpleName(),false);
		}
		
		try {
			mySelect = new Select(element);
			mySelect.selectByValue(txt);
		} catch (NoSuchElementException e) {
			assertTrue("Value '" + txt + "\' not found in the Element '" + locator.toString() + "'  for" + this.getClass().getSimpleName(),false);
		}
	}
	
	public void selectByVisibleText_DropDown(By locator, String txt){
		
		try {
			element = driver.findElement(locator); 
		} catch (NoSuchElementException e) {
			assertTrue("Element '" + locator.toString() + "\' not found for " + this.getClass().getSimpleName(),false);
		}
		
		
		try {
			mySelect = new Select(element);
			mySelect.selectByVisibleText(txt);
		} catch (NoSuchElementException e) {
			assertTrue("Value '" + txt + "\' not found in the Element '" + locator.toString() + "'  for" + this.getClass().getSimpleName(),false);
		}
	}
	
	public void SelectByIndex_DropDown(By locator, int index){
		
		try {
			element = driver.findElement(locator); 
		} catch (NoSuchElementException e) {
			assertTrue("Element '" + locator.toString() + "\' not found for " + this.getClass().getSimpleName(),false);
		}
		
		
		try {
			Select mySelect= new Select(element);
			mySelect.selectByIndex(index);
		} catch (NoSuchElementException e) {
			assertTrue("Element '" + locator.toString() + "\' not found for " + this.getClass().getSimpleName(),false);
		}
		

	}
}
