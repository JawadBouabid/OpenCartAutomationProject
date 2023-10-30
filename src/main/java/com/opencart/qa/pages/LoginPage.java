package com.opencart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.Page;

public class LoginPage extends Page{
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='input-email']")WebElement emailFieldElement;
	@FindBy(xpath="//input[@id='input-password']")WebElement passwordFieldElement;
	@FindBy(xpath = "//input[@value='Login']")WebElement loginButtonElement;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")WebElement emailPasswordNotMatchingMessageElement;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AccountPage loginIn(String email, String password) {
		type(emailFieldElement, email);
		type(passwordFieldElement, password);
		click(loginButtonElement);
		return new AccountPage(driver);
	}
	
	public AccountPage clickOnLoginButton() {
		click(loginButtonElement);
		return new AccountPage(driver);
	}
	
	public Boolean isLoginButtonPresent() {
		return isElementDisplayed(loginButtonElement);
	}
	
	public String retrieveEmailPasswordNotMatchingWarningMessageText() {
		return emailPasswordNotMatchingMessageElement.getText();
	}

}
