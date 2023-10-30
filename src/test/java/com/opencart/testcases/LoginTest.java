package com.opencart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.qa.base.Page;
import com.opencart.qa.pages.AccountPage;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.LoginPage;
import com.opencart.utils.Utilities;

public class LoginTest extends Page {

	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowseAndLoadApplicationUrl();
		homePage = new HomePage(driver);
		loginPage = homePage.goToLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

	@Test
	public void verifyLoginInWithValidCredentialsTest() {
		AccountPage accountPage = loginPage.loginIn(Utilities.VALID_EMAIL, Utilities.VALID_PASSWORD);
		assertTrue(accountPage.getDisplayStatusOfMyAccountHeading(), "Element Not displayed");
	}

	@Test
	public void verifyLoginInWithInvalidcredentialsTest() {

		loginPage.loginIn(Utilities.generateEmailWithTimeStamp(), Utilities.INVALID_PASSWORD);
		assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
				.contains("Warning: No match for E-Mail Address and/or Password."),"Expected Warning Message Is not Displayed");
	}
	
	@Test
	public void verifyLoginInWithValidEmailAndInvalidPassword() {
		loginPage.loginIn(Utilities.VALID_EMAIL, Utilities.INVALID_PASSWORD);
		assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
				.contains("Warning: No match for E-Mail Address and/or Password."),"Expected Warning Message Is not Displayed");
		
	}
	
	@Test
	public void verifyLoginInWithInvalidEmailAndValidPassword() {
		loginPage.loginIn(Utilities.generateEmailWithTimeStamp(), Utilities.VALID_PASSWORD);
		assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
				.contains("Warning: No match for E-Mail Address and/or Password."),"Expected Warning Message Is not Displayed");
	}
	
	@Test
	public void verifyLoginInWithoutProvidingCredentials() {
		loginPage.clickOnLoginButton();
		assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
				.contains("Warning: No match for E-Mail Address and/or Password."),"Expected Warning Message Is not Displayed");
	}
	

}
