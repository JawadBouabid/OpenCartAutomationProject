package com.opencart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.opencart.qa.base.Page;
import com.opencart.qa.pages.AccountSuccessPage;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.RegisterPage;
import com.opencart.utils.Utilities;

public class RegisterTest extends Page {

	public WebDriver driver;
	Faker faker;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowseAndLoadApplicationUrl();
		homePage = new HomePage(driver);
		registerPage = homePage.goToRegisterPage();
		faker = new Faker();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		AccountSuccessPage accountSuccessPage = registerPage.registerWithMandatoryFields(faker.name().firstName(),
				faker.name().lastName(), faker.internet().safeEmailAddress(), faker.phoneNumber().cellPhone(),
				faker.internet().password());
		assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),
				dataTest.getProperty("accountSuccessfullyCreatedHeading"), "Your Account Has Not Been Created");

	}

	@Test
	public void RegisteringaccountwithAllFields() {
		AccountSuccessPage accountSuccessPage = registerPage.registerWithAllFields(faker.name().firstName(), faker.name().lastName(),
				faker.internet().safeEmailAddress(), faker.phoneNumber().cellPhone(), faker.internet().password());
		assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),
				dataTest.getProperty("accountSuccessfullyCreatedHeading"), "Your Account Has Not Been Created");
	}
	
	@Test
	public void verifyRegisteringAnAccountWithExistingEmailAddress() {
		registerPage.registerWithAllFields(faker.name().firstName(), faker.name().lastName(),
				Utilities.VALID_EMAIL, faker.phoneNumber().cellPhone(), faker.internet().password());
		assertEquals(registerPage.retrieveDuplicateEmailAddressWarning(), dataTest.getProperty("duplicateEmailWarning"));
	}
	
	@Test
	public void verifyRegisteringAnAccountWithoutfillingAnyDetails() {
		registerPage.clickOnContinueButton();
		assertTrue(registerPage.displayStatusOfWarningMessages(dataTest.getProperty("privacyPolicyWarning"), 
				dataTest.getProperty("firstNameWarning"),dataTest.getProperty("lastNameWarning"), dataTest.getProperty("emailWarning"),
				dataTest.getProperty("telephoneWarning"), dataTest.getProperty("passwordWarning")));
	}

}
