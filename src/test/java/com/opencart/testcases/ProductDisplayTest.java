package com.opencart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.Page;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.ProductDisplayPage;
import com.opencart.qa.pages.SearchPage;

public class ProductDisplayTest extends Page{
	public WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowseAndLoadApplicationUrl();
		homePage = new HomePage(driver);
	}
	
	@Test
	public void verifyProductThumbnailDisplayedInTheProductDisplayPageTest() {
		SearchPage searchPage = homePage.searchForAProduct("iMac");
		ProductDisplayPage productDisplayPage = searchPage.clickOnIMacProductDisplayedinSearchResult();
		productDisplayPage.clickOnMainBiggestSizedThumbnail();
		productDisplayPage.clickOnRightArrowKeyNextThumbnail();
		productDisplayPage.clickOnRightArrowKeyNextThumbnail();
		productDisplayPage.clickOnLeftArrowKeyPreviousThumbnail();
		assertTrue(productDisplayPage.getDisplayStatusOfThumbnailXOptionElement());
		assertTrue(productDisplayPage.getDisplayStatusOfRightArrowKeyNextThumbnailElement());
		assertTrue(productDisplayPage.getDisplayStatusOfLeftArrowKeyPreviousThumnailElement());
		productDisplayPage.clickOnCloseXOption();
		
	}
	
	@Test
	public void verifyThatProductNameAndBrandAndCodeAreDisplayedInProductDisplayPageTest() {
		SearchPage searchPage = homePage.searchForAProduct("IMac");
		ProductDisplayPage productDisplayPage = searchPage.clickOnIMacProductDisplayedinSearchResult();
		String productName = productDisplayPage.retrieveProductNameText();
		String productBrand = productDisplayPage.retrieveProductBrandElementText();
		String productCode = productDisplayPage.retrieveProductCodeElementText();
		assertEquals(productName, "iMac");
		assertEquals(productBrand, "Brand: Apple");
		assertEquals(productCode, "Product Code: Product 14");
		
	}
	
	@Test
	public void verifyProductAvailibilityStatusTest() {
		SearchPage searchPage = homePage.searchForAProduct("IMac");
		ProductDisplayPage productDisplayPage = searchPage.clickOnIMacProductDisplayedinSearchResult();
		String statusAvailability = productDisplayPage.retrieveProductAvailabilityText();
		assertEquals(statusAvailability, "Availability: In Stock");
	}
	
   

}
