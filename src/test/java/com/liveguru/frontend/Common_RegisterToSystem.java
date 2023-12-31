package com.liveguru.frontend;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.bankguru.frontend.FE_HomePageUI;

import commons.AbstractTest;
import commons.PageFactoryManage;
import pageObject.FE_HomePageObject;
import pageObject.FE_Landing_Cart_ProductPageObject;
import pageObject.FE_RegisterPageObject;

public class Common_RegisterToSystem extends AbstractTest {
	WebDriver driver;
	public static String userInfor, passInfor;
	String emailInput, loginPageUrl;
	FE_Landing_Cart_ProductPageObject FE_LandingPage;
	FE_RegisterPageObject FE_RegisterPage;
	FE_HomePageObject FE_HomePage;
	public static String firstName, lastName, confirmPass, middleName, email, password;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = openMultiBrowser(browserName);
		firstName ="huyen";
		lastName = "Tran";
		middleName="Thi";
		password ="123456";
		email = "tranhuyentb" + randomNumber() + "@yopmail.com";
		
		log.info("Register 01: Open Landing Page");
		FE_LandingPage = PageFactoryManage.getLandingPage(driver);
		
		log.info("Register 02: Click to Register Button");
		FE_LandingPage.clickToHeaderMenuLinkButton(driver, "Register");
		FE_RegisterPage = PageFactoryManage.getRegisterPage(driver);
		
		log.info("Register 03: Verify register form displayed");
		verifyTrue(FE_RegisterPage.isRegisterPageDisplayed());
		
		log.info("Register 04: Input to textbox");
		FE_RegisterPage.inputToDynamicTextbox(driver, firstName, "firstname");
		FE_RegisterPage.inputToDynamicTextbox(driver, middleName , "middlename");
		FE_RegisterPage.inputToDynamicTextbox(driver, lastName, "lastname");
		FE_RegisterPage.inputToDynamicTextbox(driver, email, "email");
		FE_RegisterPage.inputToDynamicTextbox(driver, password, "password");
		FE_RegisterPage.inputToDynamicTextbox(driver, password, "confirmation");
		
		log.info("Register 05: Checked on checkbox");
		FE_RegisterPage.clickToDynamicCheckbox(driver, "is_subscribed");
		
		log.info("Register 06: Click to Register Button");
		FE_RegisterPage.clickToRegisterButton();
		
		FE_HomePage = PageFactoryManage.getHomePage(driver);
		System.out.println(FE_HomePage.getTextOfElement(driver, FE_HomePageUI.WELCOME_MESSAGE));
		
	
}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
	@AfterTest(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
