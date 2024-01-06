package com.automation.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObjects extends BasePage {

	public RegisterPageObjects(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement inputFirstname;

	@FindBy(id = "input-lastname")
	private WebElement inputLastname;

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(id = "input-password")
	private WebElement inputPassword;

	@FindBy(name = "agree")
	private WebElement cbPrivacyPolicy;

	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement btnContinue;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement txtAccountCreated;

	public void enterFirstname(String firstname) {
		inputFirstname.sendKeys(firstname);
	}

	public void enterLastname(String lastname) {
		inputLastname.sendKeys(lastname);
	}

	public void enterEmail(String email) {
		inputEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}

	public void agreePrivacyPolicy() {
		clickUsingJsExecutor(cbPrivacyPolicy);
	}

	public void clickOnContinueButton() {
		clickUsingJsExecutor(btnContinue);
	}

	public String getTxtRegisteredAccount() {
		return txtAccountCreated.getText();
	}
}
