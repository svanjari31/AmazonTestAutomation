package com.amazon.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.hashmap.Data;

public class LoginPage extends TestBase {
	
	//Page Factory or Object Repository
	@FindBy(xpath = "//span[contains(text(),'Account & Lists')]")
	private
	WebElement account;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(id = "continue")
	WebElement continueBtn;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id = "signInSubmit")
	WebElement loginBtn;
	
	@FindBy(id = "createAccountSubmit")
	WebElement signIn;
	
	@FindBy(xpath = "//a[contains(@class,'nav-logo-link')]")
	WebElement amazonLogo;
	
	//Initializing the Page Objects:
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateAmazonImg()
	{
		return amazonLogo.isDisplayed();
	}
	
//	public HomePage login(String un, String pwd)
//	{
//		getAccount().click();
//		username.sendKeys(un);
//		continueBtn.click();
//		password.sendKeys(pwd);
//		loginBtn.click();
//		
//		return new HomePage();
//	}
	
	public HomePage login() {
		String adminCredentials = Data.getUserLoginInfo().get("admin");
		String adminInfo[] = adminCredentials.split("_");
		
		getAccount().click();
		username.sendKeys(adminInfo[0]);
		continueBtn.click();
		password.sendKeys(adminInfo[1]);
//		loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		
		return new HomePage();
		
		
	}

	public WebElement getAccount() {
		return account;
	}

	public void setAccount(WebElement account) {
		this.account = account;
	}
	

}
