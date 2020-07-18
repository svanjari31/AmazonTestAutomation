package com.amazon.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {
	
	LoginPage loginPage = new LoginPage();
	
	@FindBy(xpath = "//span[contains(text(),'Hello, sayali')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[contains(text(),\"sayali's Wish List\")]")
	WebElement wishListLink;
	
	@FindBy(id = "nav-cart")
	WebElement cartLink;
	
	@FindBy(xpath = "//a[contains(@role,'button')]")
	private
	WebElement hamburgerMenu;
	
	@FindBy(xpath = "//a[contains(@data-ref-tag,'nav_em_1_1_1_2')]")
	private
	WebElement echoAndAlexaOption;
	
	@FindBy(id = "nav-your-amazon-text")
	WebElement acclink;
	
	@FindBy(xpath = "//span[contains(text(),'Your Browsing History')]")
	WebElement browselink;
	
	@FindBy(xpath = "//img[contains(@src,'https://m.media-amazon.com/images/I/61LLaoqUwFL._AC_UL320_.jpg')]")
	WebElement dress;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchtab;
	
	@FindBy(xpath = "//input[contains(@type,'submit') and (@value='Go')]")
	WebElement searchBtn;

	@FindBy(id = "add-to-cart-button")
	WebElement addCartBtn;
	
	//Initializing the Page Object:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
		
	}
	
	public WishListPage clickOnWishListLink() {
		actions.moveToElement(loginPage.getAccount()).build().perform();
		wishListLink.click();
		return new WishListPage();
		
	}
	
	public CartPage clickOnCartLink() {
		
		cartLink.click();
		return new CartPage();
		
	}
	
	public ShopByCategory clickOnShopByCategory() {
		
		echoAndAlexaOption.click();
		return new ShopByCategory();
		
	}
	
	public void searchItem() {

		acclink.click();
		browselink.click();
		dress.click();
		log.info(driver.getWindowHandle());

	}
	
	public void addToCart()
	{
		searchtab.sendKeys("dress");
		searchBtn.click();
		dress.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Set<String> handles = driver.getWindowHandles();
		log.info(handles.size());
		Iterator<String> it = handles.iterator();
		if(it.hasNext())
		{
			it.next();
			String childWindow = it.next();
			log.info(childWindow);
			driver.switchTo().window(childWindow);
			addCartBtn.click();
			
		}
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		log.info(frames);
		log.info(frames.toString());
		log.info(frames.size());
		driver.switchTo().frame(1);
		driver.switchTo().defaultContent();
		
		
		
	}

	
	public WebElement getHamburgerMenu() {
		return hamburgerMenu;
	}

	public void setHamburgerMenu(WebElement hamburgerMenu) {
		this.hamburgerMenu = hamburgerMenu;
	}

	public WebElement getEchoAndAlexaOption() {
		return echoAndAlexaOption;
	}

	public void setEchoAndAlexaOption(WebElement echoAndAlexaOption) {
		this.echoAndAlexaOption = echoAndAlexaOption;
	}

}
