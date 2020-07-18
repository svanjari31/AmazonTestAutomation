package com.amazon.qa.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class CartPage extends TestBase{
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchtab;

	
	@FindBy(id = "add-to-cart-button")
	WebElement addCartBtn;
	
	@FindBy(id = "nav-your-amazon-text")
	WebElement acclink;
	
	@FindBy(xpath = "//span[contains(text(),'Your Browsing History')]")
	WebElement browselink;
	
	@FindBy(xpath = "//img[contains(@src,'https://images-eu.ssl-images-amazon.com/images/I/71zTRY2n3aL._AC_UL400_SR300,400_.jpg')]")
	WebElement dress;
	
	List<WebElement> iframeElement = driver.findElements(By.tagName("iframe"));
	
	public void searchItem() {
		
		acclink.click();
		browselink.click();
		dress.click();
			
	}
	
	
	

}
