package com.opencart.qa.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.Page;

public class ProductDisplayPage extends Page {
	
	public WebDriver driver;
	
	@FindBy(xpath = "(//img[@title='iMac'])[1]") WebElement iMacMainBiggestSizedThumbnail;
	@FindBy(xpath ="//button[@title='Close (Esc)']")WebElement thumbnailXOptionElement;
	@FindBy(xpath ="//button[@title='Next (Right arrow key)']")WebElement rightArrowKeyNextThumbnailElement;
	@FindBy(xpath = "//button[@title='Previous (Left arrow key)']")WebElement leftArrowKeyPreviousThumnailElement;
	@FindBy(xpath ="//div[@class='col-sm-4']//h1")WebElement productName;
	@FindBy(xpath = "//div[@class='col-sm-4']//ul[1]//li[1]")WebElement productBrandElement;
	@FindBy(xpath = "//div[@class='col-sm-4']//ul[1]//li[2]")WebElement productCodeElement;
	@FindBy(xpath = "//div[@class='col-sm-4']//ul[1]//li[3]")WebElement productAvailabilityElement;
	@FindBy(xpath = "//a[text()='shopping cart']")WebElement shopingCartLinkElement;
	@FindBy(xpath = "//button[@id='button-cart']")WebElement addToCartButtonElement;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement addToShoppingCartSuccessMessage;
	@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")WebElement blackShopppingCartButton;
	@FindBy( xpath = "//a//strong//i[@class='fa fa-shopping-cart']")WebElement viewCartElement;
	
	
	public ProductDisplayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMainBiggestSizedThumbnail() {
		click(iMacMainBiggestSizedThumbnail);
		
	}
	
	public void clickOnCloseXOption() {
		click(thumbnailXOptionElement);
	}
	
	public void clickOnRightArrowKeyNextThumbnail() {
		click(rightArrowKeyNextThumbnailElement);
	}
	public void clickOnLeftArrowKeyPreviousThumbnail() {
		click(leftArrowKeyPreviousThumnailElement);
	}
	
	public Boolean getDisplayStatusOfThumbnailXOptionElement() {
		return isElementDisplayed(thumbnailXOptionElement);
	}
	public Boolean getDisplayStatusOfRightArrowKeyNextThumbnailElement() {
		return isElementDisplayed(rightArrowKeyNextThumbnailElement);
	}
	public Boolean getDisplayStatusOfLeftArrowKeyPreviousThumnailElement() {
		return isElementDisplayed(leftArrowKeyPreviousThumnailElement);
	}
	
	public String retrieveProductNameText() {
		return productName.getText();
	}
	
	public String retrieveProductBrandElementText() {
		return productBrandElement.getText();
	}
	
	public String retrieveProductCodeElementText() {
		return productCodeElement.getText();
	}
	
	public String retrieveProductAvailabilityText() {
		return productAvailabilityElement.getText();
	}
	
	public void clickOnAddToCartButton() {
		click(addToCartButtonElement);
	}

	
	
	public ShoppingCartPage goToShoppingCartThroughBlackButton() {
		click(blackShopppingCartButton);
		click(viewCartElement);
		return new ShoppingCartPage(driver);
	}
	
	public ShoppingCartPage goToShoppingCartThroughShoppingcartLinkElementInShoppingCartSuccessMessage() {
		click(shopingCartLinkElement);
		return new ShoppingCartPage(driver);
	}
	
	public String retrieveAddToShoppingCartSuccessMessageText() {
		return addToShoppingCartSuccessMessage.getText();
	}
	
	
	

}
