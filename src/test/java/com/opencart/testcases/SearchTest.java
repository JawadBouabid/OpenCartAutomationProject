package com.opencart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.opencart.qa.base.Page;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.SearchPage;

public class SearchTest extends Page{
	public WebDriver driver;
	HomePage homePage;
	
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowseAndLoadApplicationUrl();
		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void verifySearchWithValidProduct() {
		SearchPage searchPage =homePage.searchForAProduct(dataTest.getProperty("validProduct"));
		assertTrue(searchPage.displayStatusOfHPValidProduct());
	}
	
	@Test 
	public void verifySearchWithinvalidProduct() {
		SearchPage searchPage = homePage.searchForAProduct(dataTest.getProperty("invalidProduct"));
		assertEquals(searchPage.retrieveNoProductThatMatchesText(), dataTest.getProperty("NoProductThatMatchesSearch"));
	}
	
	@Test
	public void verifySearchWithoutTypingAnyProduct() {
		SearchPage searchPage = homePage.clickOnSearchButton();
		assertEquals(searchPage.retrieveNoProductThatMatchesText(), dataTest.getProperty("NoProductThatMatchesSearch"));
	}
	
}
