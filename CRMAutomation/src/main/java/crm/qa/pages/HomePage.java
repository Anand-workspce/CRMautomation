package crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.qa.base.Base;

public class HomePage extends Base {
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")	
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@href='https://classic.freecrm.com/system/index.cfm?action=contact']")	
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Companies')]")
	WebElement CompaniesLink;
	
	//Initialization
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage ClickonContactsLink() {
		 ContactsLink.click();
		 return new ContactsPage();
	}
	public Companies ClickonCompaniesLink() {
		CompaniesLink.click();
		return new Companies();
	}
}
