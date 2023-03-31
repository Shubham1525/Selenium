package com.exploration;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.exploration.base.TestUtilities;
import com.exploration.page.Flipkart;

import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class Exploration3 extends TestUtilities {
	private By usernameLocator = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	private By passwordLocator = By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']");
	private By loginButtonLocator = By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	private By searchBarLocator = By.xpath("//input[@class='_3704LK']");
	private By searchButtonLocator = By.xpath("//button[@class='L0Z3Pu']");
	private By afterSearchResult = By.xpath("//div[@class='_3ywSr_']");
	private By addtoCartLocator = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	private By mediumSize = By.xpath("//li[@id='swatch-1-size']");

	@Test
	@Parameters({ "username","password" })
	public void ecommTesting(String username,String password) throws Exception {

		Flipkart welcomePage = new Flipkart(driver, log);
		welcomePage.openPage();
		String expected = "https://www.flipkart.com/";
		sleep(3000);
		String actual = welcomePage.getCurrentUrl();

		AssertJUnit.assertEquals("Actual page url is not the same as expected", expected, actual);

		welcomePage.LogIn(username, password, usernameLocator, passwordLocator, loginButtonLocator);
		sleep(4000);
		String afterLoginValidationExpected = "Shubham";
		String afterLoginValidationActual = driver.findElement(By.xpath("//div[@class='exehdJ']")).getText();
		AssertJUnit.assertEquals("Login is not successfull", afterLoginValidationExpected, afterLoginValidationActual);

		// searching in search bar
		welcomePage.type("Shirts", searchBarLocator);
		welcomePage.findAndClick(searchButtonLocator);

		// Get product click
		welcomePage.getProductByIndex(afterSearchResult, 4);
		sleep(3000);
		
		// new tab will open
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		// size selection
		welcomePage.findAndClick(mediumSize);
		sleep(2000);
		// add to cart
		welcomePage.addToCart(addtoCartLocator);
		sleep(4000);
		driver.navigate().back();
		sleep(3000);
		// new tab close
		driver.close();
		// switch to previous tab
		driver.switchTo().window(tabs2.get(0));

		List<WebElement> list = welcomePage.findAll(By.xpath("//span[@class='_2I9KP_']"));

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals("Men")) {
				welcomePage.hoverOverElement(list.get(i));
				break;

			}
		}
		sleep(3000);
		welcomePage.findClickAndWait(By.xpath("//a[@title='Jeans']"));
		sleep(3000);

		welcomePage.getProductByIndex(By.xpath("//div[@class='_3ywSr_']"), 4);

		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		String expectedName = welcomePage.getText(By.xpath("//span[@class='G6XhRU']")) + welcomePage.getText(By.xpath("//span[@class='B_NuCI']"));
		
		welcomePage.findAndClick(mediumSize);
		sleep(2000);

		// add to cart
		welcomePage.addToCart(addtoCartLocator);
		sleep(3000);
		List<WebElement> productsAtCart = welcomePage.findAll(By.xpath("//a[@class='_2Kn22P gBNbID']"));
		boolean productStatus = false;
		for (WebElement product : productsAtCart) {
			String actual1 = product.getText();
			if (actual1.equals(expectedName)) {
				productStatus = true;
			}
		}
		if (!productStatus)
			throw new Exception("Added product is not valid");
		sleep(4000);
		welcomePage.chooseButton(By.className("_23FHuj"),1);
	}

}
