package com.automation.opencart.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver;
	private JavascriptExecutor jsExecutor = null;
	private TakesScreenshot takesScreenshot = null;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public byte[] getScreenshot() {
		takesScreenshot = (TakesScreenshot) driver;
		return takesScreenshot.getScreenshotAs(OutputType.BYTES);
	}

	public String getExpectedUrl() {
		return driver.getCurrentUrl();
	}

	public void clickUsingJsExecutor(WebElement element) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}
}
