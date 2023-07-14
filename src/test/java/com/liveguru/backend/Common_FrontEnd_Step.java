package com.liveguru.backend;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.frontend.FE_HomePageUI;

import commons.AbstractTest;
import commons.PageFactoryManage;
import pageObject.FE_HomePageObject;
import pageObject.FE_Landing_Cart_ProductPageObject;
import pageObject.FE_RegisterPageObject;

public class Common_FrontEnd_Step extends AbstractTest {
	WebDriver driver;
	public static String CustomerID;
	String emailInput, loginPageUrl;
	FE_Landing_Cart_ProductPageObject FE_Landing_Cart_Product;
	FE_RegisterPageObject FE_RegisterPage;
	FE_HomePageObject FE_HomePage;
	public static String firstName, lastName, confirmPass, middleName, email, password;
	CommonClass newCus;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = openMultiBrowser(browserName);
		newCus = new CommonClass(driver);
		newCus.CreateNewCustomer1();
		driver.quit();
	}


	@AfterTest(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
