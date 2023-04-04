package com.exploration.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDrop extends BasePageObject {

	private String pageUrl = "https://jqueryui.com/droppable/";

	public DragAndDrop(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	public void switchFrame(By locator) {
		switchToFrame(locator);
	}

}
