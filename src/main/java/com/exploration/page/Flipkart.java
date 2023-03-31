package com.exploration.page;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Flipkart extends BasePageObject {

	private String pageUrl = "https://www.flipkart.com/";
	public Flipkart(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void findAndClick(By locator) {
		click(locator);
	}
	
	
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}
	
	public void LogIn(String username, String password,By usernameLocator, By passwordLocator,By logInButtonLocator ) {
		log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
	}
	
	public void findClickAndWait(By locator) {
		waitForVisibilityOf(locator, 30);
		find(locator).click();
	}
	
	public void getProductByIndex(By locator,int i) {
		waitForVisibilityOfAllElements(locator);
		List<WebElement> resultsList =findAll(locator);
		resultsList.get(i).click();
	}
	
	public String getText(By locator) {
		return find(locator).getText();
		
	}
	
	public void addToCart(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(find(locator)).click().perform();
	}
	
	public void chooseButton(By locator,int i) {
		List<WebElement> buttons = findAll(locator);
		buttons.get(i).click();
	}

}
