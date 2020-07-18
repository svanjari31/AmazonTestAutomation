package com.amazon.qa.testcases;

import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.WishListPage;
import com.amazon.qa.util.TestUtil;

public class WishListPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	HomePageTest homePageTest;
	WishListPage wishList;
	TestUtil testUtil;
	
	String sheetName = "createAccountSheet";
	
	public WishListPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePageTest = new HomePageTest();
		testUtil = new TestUtil();
		wishList = new WishListPage();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		testUtil.moveToElement();
//		wishList = homePage.clickOnWishListLink();
	}
	
	
//	@Test(priority = 1)
//	public void verifyWishListLabelTest()
//	{
//		Boolean flag = wishList.verifyWishListLabel();
//		Assert.assertTrue(flag);
//	}
//	
//	@Test(priority = 2)
//	public void addCommentToListItemTest()
//	{
//		wishList.getAddCommentLink().click();
//		wishList.addCommentToListItem(prop.getProperty("comment"));
//	}
//	
//	@Test(priority = 3)
//	public void createWishListTest()
//	{
//		wishList.createWishList().click();
////		testUtil.switchToFrame();
//		wishList.setNewList(wishList.createWishList());
//	}
//	
//	@Test(priority = 4)
//	public void selectCategoryTest()
//	{
//		wishList.selectCategory("Deals");
//	}
	
	@DataProvider
	public Object[][] getTestDataTest()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority = 5, dataProvider = "getTestDataTest")
	public void createAccountTest(String name, String phno, String email)
	{
	    actions.moveToElement(loginPage.getAccount()).build().perform();
		wishList.createAccount(name, phno, email);

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
