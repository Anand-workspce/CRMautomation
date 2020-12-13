package crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import crm.qa.base.Base;
import crm.qa.pages.LoginPage;

public class LoginPageTest extends Base {
	LoginPage loginpage;
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
		
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void crmLogoTest() {
		boolean flag=loginpage.validateCRMImage();
		Assert.assertEquals(flag, true, "test failed");
	}
	@Test(priority=3)
	public void loginTest() {
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
				
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
