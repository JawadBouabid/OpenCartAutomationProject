package com.opencart.qa.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.Page;

public class SearchPage extends Page {
	public WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")WebElement validHPProduct;
	@FindBy(xpath = "//img[@title='iMac']")WebElement iMacProduct;
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")WebElement noProductThatMatchesTextElement;
	@FindBy(xpath = "//span[text() = 'Add to Cart']")WebElement addToCartButtonElement;
	@FindBy(xpath = "//a[text()='shopping cart']")WebElement shopingCartLinkElement;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement addToShoppingCartSuccessMessage;
	@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")WebElement blackShopppingCartButton;
	@FindBy( xpath = "//a//strong//i[@class='fa fa-shopping-cart']")WebElement viewCartElement;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProductDisplayPage clickOnIMacProductDisplayedinSearchResult() {
		click(iMacProduct);
		return new ProductDisplayPage(driver);
	}
	
	public Boolean displayStatusOfHPValidProduct() {
		return validHPProduct.isDisplayed();
	}
	
	public String retrieveNoProductThatMatchesText() {
		return noProductThatMatchesTextElement.getText();
	}
	
	public  void clickOnAddToCartButton() {
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
