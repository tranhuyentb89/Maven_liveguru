package com.liveguru.backend;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManage;
import pageObject.FE_HomePageObject;
import pageObject.FE_Landing_Cart_ProductPageObject;
import pageObject.FE_RegisterPageObject;

public class CommonClass extends AbstractTest {

	WebDriver driver;
	public static String CustomerID;
	String emailInput, loginPageUrl;
	FE_Landing_Cart_ProductPageObject FE_Landing_Cart_Product;
	FE_RegisterPageObject FE_RegisterPage;
	FE_HomePageObject FE_HomePage;
	public static String firstName, lastName, confirmPass, middleName, email, password;
	public static String detailReview, summaryReview, nicknameReview;

	public CommonClass(WebDriver driver) {
		this.driver = driver;
	}

	public void CreateNewCustomer1() {
		firstName = "huyen";
		lastName = "Tran";
		middleName = "Thi";
		password = "123456";
		email = "tranhuyentb" + randomNumber() + "@yopmail.com";
		detailReview ="HUYEN TRAN THI DETAIL REVIEW" + randomNumber();
		summaryReview ="HUYEN TRAN THI SUMMARY REVIEW" + randomNumber();
		nicknameReview = "HUYEN REVIEW" + randomNumber();
		log.info("Register 01: Open Landing Page");
		FE_Landing_Cart_Product = PageFactoryManage.getLandingPage(driver);

		log.info("Register 02: Click to Register Button");
		FE_Landing_Cart_Product.clicktoHeaderAccountLink();
		FE_Landing_Cart_Product.clickToHeaderMenuLinkButton(driver, "Register");
		FE_RegisterPage = PageFactoryManage.getRegisterPage(driver);

		log.info("Register 03: Verify register form displayed");
		verifyTrue(FE_RegisterPage.isRegisterPageDisplayed());

		log.info("Register 04: Input to textbox");
		FE_RegisterPage.inputToDynamicTextbox(driver, firstName, "firstname");
		FE_RegisterPage.inputToDynamicTextbox(driver, middleName, "middlename");
		FE_RegisterPage.inputToDynamicTextbox(driver, lastName, "lastname");
		FE_RegisterPage.inputToDynamicTextbox(driver, email, "email_address");
		FE_RegisterPage.inputToDynamicTextbox(driver, password, "password");
		FE_RegisterPage.inputToDynamicTextbox(driver, password, "confirmation");

		log.info("Register 05: Checked on checkbox");
		FE_RegisterPage.clickToDynamicCheckbox(driver, "is_subscribed");

		log.info("Register 06: Click to Register Button");
		FE_RegisterPage.clickToRegisterButton();

	}
	
	public void AddReview() {
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "TV");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Samsung LCD");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Add Your Review");
		FE_Landing_Cart_Product.clearTextInTextBox(driver, "summary_field");
		FE_Landing_Cart_Product.clearTextInTextBox(driver, "nickname_field");
		FE_Landing_Cart_Product.clearTextInAreaBox(driver, "review_field");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Submit Review");
		FE_Landing_Cart_Product.clickToDynamicCheckbox(driver, "Quality 1_5");
		FE_Landing_Cart_Product.inputToDynamicTextbox(driver, summaryReview, "summary_field");
		FE_Landing_Cart_Product.inputToDynamicTextbox(driver, nicknameReview, "nickname_field");
		FE_Landing_Cart_Product.inputToDynamicTextArea(driver, detailReview, "review_field");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Submit Review");
	}
	
	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}


}
