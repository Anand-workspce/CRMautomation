package crm.qa.testcases;

import java.awt.Dimension;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.qa.base.Base;
import crm.qa.pages.ContactsPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.util.TestUtil;

public class HomePageTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage=new LoginPage();
		testUtil =new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage= new ContactsPage();
	}
	

	public void verifyHomePageTitleTest() {
		
		String homepageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO");
	}
	
	@Test
	public void verifyUserNameTest() {	
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	
		}	
	@Test
	public void verifyContactsLinkTest() throws InterruptedException {		
		testUtil.switchToFrame();
		contactsPage=homePage.ClickonContactsLink();
	}
	
	public void verifyCompanyLinkTest() {
				
		homePage.ClickonCompaniesLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
