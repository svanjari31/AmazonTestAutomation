package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CartPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.WishListPage;
import com.amazon.qa.util.TestUtil;

public class CartPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	TestUtil testUtil;
	
	public CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		cartPage = new CartPage();
		testUtil = new TestUtil();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login();
		
	}
	
	
	@Test(priority = 1)
	public void searchItemTest()
	{
		cartPage.searchItem();
	}
	
//    @Test(priority = 2)
//	public void addItemToCartTest()
//	{
//		cartPage.addItemToCart();
//	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
