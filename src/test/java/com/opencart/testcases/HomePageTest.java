package com.opencart.testcases;


import static org.testng.Assert.assertTrue;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.opencart.qa.base.Page;
import com.opencart.qa.listeners.MyListeners;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.LoginPage;

@Listeners(MyListeners.class)
public class HomePageTest  extends Page{
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		driver = initializeBrowseAndLoadApplicationUrl();
		homePage = new HomePage(driver);
		//loginPage = new LoginPage(driver);
	}
	

	@Test
	public void goToLoginPageTest() {
		loginPage = homePage.goToLoginPage();
		
		
		assertTrue(loginPage.isLoginButtonPresent());
		
	}
}
