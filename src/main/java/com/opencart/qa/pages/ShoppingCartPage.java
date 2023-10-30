package com.opencart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.Page;

public class ShoppingCartPage extends Page {

	public WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tbody/tr/td[@class='text-left'][2]")WebElement iMacProductLinkShoppingCartElement;
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]")WebElement macBookProducrLinkShoppingCartElement;

	public Boolean isImacProductPresentInShoppingCart() {
		return isElementDisplayed(iMacProductLinkShoppingCartElement);
	}
	
	public Boolean isMacBookProductpresentInShoppingCart() {
		return isElementDisplayed(macBookProducrLinkShoppingCartElement);
	}

}
