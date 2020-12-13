package crm.qa.util;

import java.util.List;

import org.openqa.selenium.By;

import crm.qa.base.Base;

public class TestUtil extends Base{

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
		
		
		
	}
}
