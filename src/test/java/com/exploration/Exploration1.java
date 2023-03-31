package com.exploration;

import org.testng.annotations.Test;
import com.exploration.base.TestUtilities;
import com.exploration.page.SelectWelcomePage;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;


public class Exploration1 extends TestUtilities  {
	
	@Test
	public void selectTesting() {

		SelectWelcomePage welcomePage = new SelectWelcomePage(driver,log);
		welcomePage.openPage();
		
		String expected = "https://demo.guru99.com/test/newtours/register.php";
		String actual = driver.getCurrentUrl();
		
		AssertJUnit.assertEquals("Actual page url is not the same as expected",expected, actual );
		welcomePage.selectIndex(By.name("country"), 2);
		

		
	    sleep(1000);
	    welcomePage.selectValue(By.name("country"), "ALBANIA");
	   
//	    System.out.println(objSelect.getFirstSelectedOption().getText());
	    sleep(1000);
	    welcomePage.selectVisibleText(By.name("country"),"ANTARCTICA"); 
//	    System.out.println(objSelect.getFirstSelectedOption().getText());
	}
	
}
