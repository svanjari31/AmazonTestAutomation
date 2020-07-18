package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class WishListPage extends TestBase{
	
	@FindBy(xpath = "//span[contains(text(),\"sayali's Wish List\")]")
	WebElement wishListLabel;
	
	@FindBy(id = "createList")
	WebElement createListLink;
	
	@FindBy(xpath = "//input[contains(text(),'Create List')]")
	WebElement createListBtn;
	
	@FindBy(id = "itemEditLabel_I3EKAFNKPZNIW0")
	private
	WebElement addCommentLink;
	
	@FindBy(id = "wl-list-title-WKQ3PLB9OA68")
	private
	WebElement newList;
	
	@FindBy(id = "WLNOTES_Comment")
	WebElement addComment;
	
	@FindBy(id = "WLNOTES_save")
	WebElement saveBtn;
	
	@FindBy(id = "searchDropdownBox")
	WebElement selectCategory;
	
	@FindBy(xpath = "//a[contains(text(),'Start here')]")
	private
	WebElement signInLink;
	
	@FindBy(id = "ap_customer_name")
	WebElement name;
	
	@FindBy(id = "ap_phone_number")
	WebElement phnumber;
	
	@FindBy(id = "ap_email")
	WebElement email;
	
	@FindBy(id = "continue")
	private
	WebElement continueBtn;
	
	
	
	public WishListPage() {
		//initialization of Page Object
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyWishListLabel() {
		
		return wishListLabel.isDisplayed();
		
	}
	
	public void addCommentToListItem(String comment) {
		addComment.sendKeys(comment);
		saveBtn.click();
	}
	
	public WebElement createWishList() {
		createListBtn.click();
		return getNewList();
	}
	
	public void selectCategory(String option) {
		Select select = new Select(selectCategory);
		select.selectByVisibleText(option);
		
	}
	
	public void createAccountSign()
	{
		signInLink.click();
	}
	
	public void createAccount(String fname, String phno, String emailId ) {
		
		signInLink.click();
		name.sendKeys(fname);
		phnumber.sendKeys(phno);
		email.sendKeys(emailId);
		continueBtn.click();
		
	}
	

	public WebElement getNewList() {
		return newList;
	}

	public void setNewList(WebElement newList) {
		this.newList = newList;
	}

	public WebElement getAddCommentLink() {
		return addCommentLink;
	}

	public void setAddCommentLink(WebElement addCommentLink) {
		this.addCommentLink = addCommentLink;
	}

	public WebElement getSignInLink() {
		return signInLink;
	}

	public void setSignInLink(WebElement signInLink) {
		this.signInLink = signInLink;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public void setContinueBtn(WebElement continueBtn) {
		this.continueBtn = continueBtn;
	}
	
	

}
