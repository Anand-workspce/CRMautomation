package crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.qa.base.Base;

public class LoginPage extends Base {

	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div/div/div[1]/a/img")
	WebElement crmLogo;
	
	//Initializing the page objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
		
	}
	public HomePage login(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new HomePage();
		
	}
}
