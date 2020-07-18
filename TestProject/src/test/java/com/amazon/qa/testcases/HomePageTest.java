package com.amazon.qa.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CartPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.ShopByCategory;
import com.amazon.qa.pages.WishListPage;
import com.amazon.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	WishListPage wishListPage;
	CartPage cartPage;
	ShopByCategory shopByCategory;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		wishListPage = new WishListPage();
		cartPage = new CartPage();
		shopByCategory = new ShopByCategory();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login();
	}
	
//	@Test(priority = 1)
//	public void verifyHomePageTitleTest()
//	{
//		String title = homePage.verifyHomePageTitle();
//		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", "Home Page title not matched");
//	}
//	
//	@Test(priority = 2)
//	public void verifyCorrectUserNameTest()
//	{
//		Assert.assertTrue(homePage.verifyCorrectUserName());
//	}
//	
//	@Test(priority = 3)
//	public WishListPage clickOnWishListLinkTest()
//	{
////		testUtil.moveToElement();
//		return homePage.clickOnWishListLink();
//	}
//	
//	@Test(priority = 4)
//	public void clickOnCartLinkTest()
//	{
//		cartPage = homePage.clickOnCartLink();
//	}
//	
//	@Test(priority = 5)
//	public void clickOnShopByCategory()
//	{
//		homePage.getHamburgerMenu().click();
//		if(homePage.getEchoAndAlexaOption().isDisplayed())
//		{
//			shopByCategory = homePage.clickOnShopByCategory();
//		}
//	}
	
//	@Test
//	public void searchTest()
//	{
//		homePage.searchItem();
//	}
	
	@Test
	public void addToCartTest()
	{
		homePage.addToCart();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
