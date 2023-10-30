package com.opencart.testcases;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.opencart.qa.base.Page;
import com.opencart.qa.listeners.MyListeners;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.ProductDisplayPage;
import com.opencart.qa.pages.SearchPage;
import com.opencart.qa.pages.ShoppingCartPage;


//@Listeners(MyListeners.class)
public class AddToCartTest extends Page{
	public WebDriver driver;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowseAndLoadApplicationUrl();
		homePage = new HomePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyAddingProductToCartFromSearchResultsPage() {
		SearchPage searchPage = homePage.searchForAProduct("iMac");
		searchPage.clickOnAddToCartButton();
		System.out.println(searchPage.retrieveAddToShoppingCartSuccessMessageText());
		assertTrue(searchPage.retrieveAddToShoppingCartSuccessMessageText()
				.contains("Success: You have added iMac to your shopping cart!"));
		ShoppingCartPage shoppingCartPage = searchPage.goToShoppingCartThroughShoppingcartLinkElementInShoppingCartSuccessMessage();
		assertTrue(shoppingCartPage.isImacProductPresentInShoppingCart());
		
	}
	
	@Test 
	public void verifyAddingProductToCartFromProductDisplayPage() {
		SearchPage searchPage = homePage.searchForAProduct("iMac");
		ProductDisplayPage productDisplayPage = searchPage.clickOnIMacProductDisplayedinSearchResult();
		productDisplayPage.clickOnAddToCartButton();
		assertTrue(productDisplayPage.retrieveAddToShoppingCartSuccessMessageText()
				.contains("Success: You have added iMac to your shopping cart!"));
		ShoppingCartPage shoppingCartPage = productDisplayPage.goToShoppingCartThroughShoppingcartLinkElementInShoppingCartSuccessMessage();
		assertTrue(shoppingCartPage.isImacProductPresentInShoppingCart());
	}
	
	@Test
	public void verifyAddingProductFromFeaturedSectionOfHomePage() {
		homePage.addToCartFeaturedMacBookProduct();
		assertTrue(homePage.retrieveAddToShoppingCartSuccessMessageText()
				.contains("Success: You have added MacBook to your shopping cart!"));
		ShoppingCartPage shoppingCartPage = homePage.clickOnShoppingCartLinkElementInAddToShopppingCartSuccessMessage();
		assertTrue(shoppingCartPage.isMacBookProductpresentInShoppingCart());
	}
}
