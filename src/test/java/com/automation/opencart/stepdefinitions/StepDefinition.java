package com.automation.opencart.stepdefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.opencart.pageobjects.BasePage;
import com.automation.opencart.pageobjects.HomePageObjects;
import com.automation.opencart.pageobjects.RegisterPageObjects;
import com.automation.opencart.utilities.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinition {
	private static WebDriver driver;
	protected Utilities utilities = null;
	private BasePage basePage = null;
	private HomePageObjects homePageObjects = null;
	private static Scenario scenario;
	private RegisterPageObjects registerPageObjects = null;

	@Before
	public void setup(Scenario scenario) throws IOException {
		utilities = new Utilities();
		StepDefinition.scenario = scenario;
		String browserName = Utilities.getProperty("browserName");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		basePage = new BasePage(driver);
		driver.get(Utilities.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void tearDown() {
		if (scenario.isFailed()) {
			scenario.attach(basePage.getScreenshot(), "image/png", scenario.getName());
		}
		driver.quit();
		driver = null;
	}

	@Given("user should have access to opencart application")
	public void user_should_have_access_to_opencart_application() throws IOException {
		String expectedUrl = basePage.getExpectedUrl();
		Assert.assertEquals(expectedUrl, Utilities.getProperty("url"));
		scenario.attach(basePage.getScreenshot(), "image/png", "user have access to opencart application");
	}

	@When("user enters the username and password")
	public void user_enters_the_username_and_password() throws IOException {
		homePageObjects = new HomePageObjects(driver);
		homePageObjects.clickOnMyAccountDropdown();
		homePageObjects.clickOnLogin();
		homePageObjects.enterEmailAddress(Utilities.getProperty("email"));
		homePageObjects.enterPassword(Utilities.getProperty("password"));
		scenario.attach(basePage.getScreenshot(), "image/png", "user entered the username and password");
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		homePageObjects.clickOnLoginButton();
		scenario.attach(basePage.getScreenshot(), "image/png", "user clicked on the login button");
	}

	@Then("user redirects to the opencart homepage")
	public void user_redirects_to_the_opencart_homepage() {
		String expectedText = homePageObjects.getTxtMyAccount();
		Assert.assertEquals(expectedText, "My Account");
		scenario.attach(basePage.getScreenshot(), "image/png", "user redirected to the homepage");
	}

	@When("user enters the {string}, {string}, {string} ,and {string}")
	public void user_enters_the_firstname_and_lastname(String firstname, String lastname, String email,
			String password) {
		homePageObjects = new HomePageObjects(driver);
		homePageObjects.clickOnMyAccountDropdown();
		homePageObjects.clickOnRegister();
		registerPageObjects = new RegisterPageObjects(driver);
		registerPageObjects.enterFirstname(firstname);
		registerPageObjects.enterLastname(lastname);
		registerPageObjects.enterEmail(email);
		registerPageObjects.enterPassword(password);
		scenario.attach(basePage.getScreenshot(), "image/png",
				"user entered the " + firstname + "," + lastname + "," + email + " and " + password + "");
	}

	@When("user agrees the privacy policy")
	public void user_agrees_the_privacy_policy() {
		registerPageObjects.agreePrivacyPolicy();
		scenario.attach(basePage.getScreenshot(), "image/png", "user agreed the privacy policy");
	}

	@When("user clicks on contine button")
	public void user_clicks_on_contine_button() {
		registerPageObjects.clickOnContinueButton();
		scenario.attach(basePage.getScreenshot(), "image/png", "user clicks on continue button");
	}

	@Then("user verifies the registered account")
	public void user_verifies_the_registered_account() {
		String expectedOutCome = registerPageObjects.getTxtRegisteredAccount();
		Assert.assertEquals(expectedOutCome, "Your Account Has Been Created!");
		scenario.attach(basePage.getScreenshot(), "image/png", "user registered account successfully");
	}
}
