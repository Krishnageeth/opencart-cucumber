package com.automation.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects extends BasePage {

	public HomePageObjects(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement ddMyAccount;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement txtLogin;

	@FindBy(name = "email")
	private WebElement txtEmailAddress;

	@FindBy(name = "password")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;

	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement txtMyAccount;

	@FindBy(xpath = "//span[text()='My Account']//following::a[text()='Register'][1]")
	private WebElement btnRegister;

	public void clickOnMyAccountDropdown() {
		ddMyAccount.click();
	}

	public void enterEmailAddress(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickOnLoginButton() {
		btnLogin.click();
	}

	public void clickOnLogin() {
		txtLogin.click();
	}

	public String getTxtMyAccount() {
		return txtMyAccount.getText();
	}

	public void clickOnRegister() {
		btnRegister.click();
	}
}
