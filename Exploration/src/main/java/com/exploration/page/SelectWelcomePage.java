package com.exploration.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectWelcomePage extends BasePageObject{
	
	private String pageUrl = "https://demo.guru99.com/test/newtours/register.php";

	public SelectWelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	public void selectIndex(By locator,int i) {
		selectByIndex(locator,i);
	}
	
	public void selectValue(By locator,String value) {
		selectByValue(locator,value);
	}
	public void selectVisibleText(By locator,String visibleText) {
		selectByVisibleText(locator,visibleText);
	}
	
	
	
}
