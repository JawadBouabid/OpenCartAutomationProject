package com.opencart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.qa.base.Page;

public class HomePage extends Page{
	public WebDriver driver;
	
	@FindBy(xpath = "//i[@class='fa fa-user']")WebElement accounDropDownMenuElementt;
	@FindBy(xpath = "//a[text()='Register']")WebElement registerOptionElement;
	@FindBy(xpath = "//a[text()='Login']")WebElement loginOptionElement;
	@FindBy(xpath="//input[@name='search']")WebElement searchBoxFieldElement;
	@FindBy(xpath = "//i[@class='fa fa-search']")WebElement searchButtonElement;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[1]//span[1]")WebElement addToCartButtonForFeaturedMacBookProductElement;
	@FindBy(xpath="//a[text()='shopping cart']")WebElement shoppingCartLinkElement;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement addToShoppingCartSuccessMessage;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage goToLoginPage() {
		click(accounDropDownMenuElementt);
		click(loginOptionElement);
		return new LoginPage(driver);
	}
	
	public RegisterPage goToRegisterPage() {
		click(accounDropDownMenuElementt);
		click(registerOptionElement);
		return new RegisterPage(driver);
	}
	
	public SearchPage searchForAProduct(String textProduct) {
		type(searchBoxFieldElement, textProduct);
		click(searchButtonElement);
		return new SearchPage(driver);
	}
	
	public SearchPage clickOnSearchButton() {
		click(searchButtonElement);
		return new SearchPage(driver);
	}
	
	public void addToCartFeaturedMacBookProduct() {
		click(addToCartButtonForFeaturedMacBookProductElement);
	}
	
	public String retrieveAddToShoppingCartSuccessMessageText() {
		return addToShoppingCartSuccessMessage.getText();
	}
	
	public ShoppingCartPage clickOnShoppingCartLinkElementInAddToShopppingCartSuccessMessage() {
		click(shoppingCartLinkElement);
		return new ShoppingCartPage(driver);
	}
	
}
