package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super(); //to call base class constructor
	}
	
	@BeforeMethod
	public void setUp()
	{
		log.info("launching browser");
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		log.debug("debug message");
		log.warn("just waring message");
		log.error("error message");
		log.fatal("fatal error message");
	}
	
//	@Test(priority = 1)
//	public void loginPageTitleTest()
//	{
//		
//		String title = loginPage.validateLoginPageTitle();
//		log.info("login page title"+title);
//		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
//	}
//	
//	@Test(priority = 2)
//	public void amazonImgTest()
//	{
//		Boolean flag = loginPage.validateAmazonImg();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority = 3)
	public void loginTest()
	{
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login();
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
