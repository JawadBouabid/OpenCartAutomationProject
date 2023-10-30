package com.opencart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.Page;

public class AccountPage extends Page {
	public WebDriver driver;
	
	@FindBy(xpath="//h2[contains(text(), 'My Account')]")WebElement myAccountHeadingElement;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean getDisplayStatusOfMyAccountHeading() {
		return isElementDisplayed(myAccountHeadingElement);
	}
}
