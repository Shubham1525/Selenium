package com.exploration;

import org.testng.annotations.Test;

import com.exploration.base.TestUtilities;
import com.exploration.page.DragAndDrop;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;

public class Exploration2 extends TestUtilities {
	@Test
	public void DragAndDrop() {
		DragAndDrop welcomePage = new DragAndDrop(driver,log);
		welcomePage.openPage();
		String expected = "https://jqueryui.com/droppable/";

		String actual = welcomePage.getCurrentUrl();

		AssertJUnit.assertEquals("Actual page url is not the same as expected", expected,actual );
		
		welcomePage.switchFrame(By.xpath("//iframe[@class='demo-frame']"));
	
		welcomePage.performDragAndDrop(By.xpath("//div[@id='draggable']"), By.xpath("//div[@id='droppable']"));
		
	}
}
