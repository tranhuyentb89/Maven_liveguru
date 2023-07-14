package com.liveguru.frontend;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.frontend.FE_HomePageUI;

import commons.AbstractTest;
import commons.PageFactoryManage;
import pageObject.FE_AdvanceSearchPageObject;
import pageObject.FE_CheckoutCartPageObject;
import pageObject.FE_CompareWindowPageObject;
import pageObject.FE_HomePageObject;
import pageObject.FE_Landing_Cart_ProductPageObject;
import pageObject.FE_OrderPageObject;
import pageObject.FE_RegisterPageObject;
import pageObject.FE_ShoppingCartPageObject;
import pageObject.FE_WishListWindowPageObject;

public class Step01_RegisterToSystem extends AbstractTest {

	WebDriver driver;
	FE_RegisterPageObject FE_RegisterPage;
	FE_Landing_Cart_ProductPageObject FE_Landing_Cart_Product;
	FE_HomePageObject FE_HomePage;
	String firstName, lastName, email, password, confirmPass, middleName;
	String companyShip, addShip, add2Ship, cityShip, zipShip, telephoneShip, faxShip, regionText, countryText;
	String priceInSearchAdvance1, priceInSearchAdvance2, productNameInSearchAdvance1, productNameInSearchAdvanc2;
	String orderCode;
	String creditCartNumber;
	String priceInList, priceInDetail;
	FE_CompareWindowPageObject compareWindow;
	FE_WishListWindowPageObject FE_WishListPage;
	FE_ShoppingCartPageObject FE_ShoppingCardPage;
	FE_CheckoutCartPageObject FE_CheckoutCartPage;
	FE_OrderPageObject FE_OrderPage;
	FE_AdvanceSearchPageObject FE_AdvanceSearch;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = openMultiBrowser(browserName);
		FE_Landing_Cart_Product = PageFactoryManage.getLandingPage(driver);

		firstName = "huyen";
		lastName = "Tran";
		middleName = "Thi";
		password = "123456";
		email = "tranhuyentb" + randomNumber() + "@yopmail.com";

		companyShip = "Cong ty co phan cong nghe Meta";
		addShip = "101 ngo thong nhat";
		add2Ship = "102 ngo thong nhat";
		cityShip = "Ha Noi";
		zipShip = "000000";
		telephoneShip = "0389642633322";
		faxShip = "7328954375";
		creditCartNumber = "4242424242424242";
	}

	@Test
	public void TC_01_registerToSystem() {
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

	@Test
	public void TC_02_VerifyInformationAfterRegisterSuccess() {

		log.info("Verify Register 01: Click Home Page");
		FE_HomePage = PageFactoryManage.getHomePage(driver);

		log.info("Verify Register 02: Verify Welcome message displayed");
		System.out.println(FE_HomePage.getTextOfElement(driver, FE_HomePageUI.WELCOME_MESSAGE));

		log.info("Verify Register 03: Verify Contact Information Correct");
		Assert.assertEquals(firstName + " " + middleName + " " + lastName + "\n" + email + "\n" + "Change Password",
				FE_HomePage.getContactInformation());
	}

	@Test
	public void TC_04_PriceOfProduct() {

		log.info("TC_04_PriceOfProduct 01: Click Home Page");
		FE_HomePage.clickToMagentoImg(driver);
		FE_Landing_Cart_Product = PageFactoryManage.getLandingPage(driver);

		log.info("TC_04_PriceOfProduct 02: Click to Mobile Tab");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Mobile");

		log.info("TC_04_PriceOfProduct 03: get Price of Sony Xperia in List");
		priceInList = FE_Landing_Cart_Product.getCostOfProduct(driver, "Sony Xperia");
		System.out.println("Sony xperia's Price in list : " + priceInList);

		log.info("TC_04_PriceOfProduct 04: Click to Sony Xperia to view Detail");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Sony Xperia");

		log.info("TC_04_PriceOfProduct 05: Verify price in list and detail are equals");
		verifyEquals(priceInList, FE_Landing_Cart_Product.getCostOfProductInDetail());
	}

	@Test
	public void TC_05_VerifyDiscountCuponCorrectly() {

		log.info("TC_05_VerifyDiscountCuponCorrectly 01: Click to Mobile menu");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Mobile");

		log.info("TC_05_VerifyDiscountCuponCorrectly 02: Click Add to Card of Sony Experia");
		FE_Landing_Cart_Product.clickAddToCardButton(driver, "Sony Xperia");

		log.info("TC_05_VerifyDiscountCuponCorrectly 03: Input Cupon");
		FE_Landing_Cart_Product.inputToDynamicTextbox(driver, "GURU50", "coupon_code");

		log.info("TC_05_VerifyDiscountCuponCorrectly 04: Click Apply button");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Apply");
		;

		log.info("TC_05_VerifyDiscountCuponCorrectly 05: Verify Discount Amount Equals to $5");
		verifyEquals(FE_Landing_Cart_Product.getAmountInCard(driver, "Discount"), "-$5.00");
		;
//		verifyEquals(FE_LandingPage.getAmountInCard(driver, "Grand Total"), FE_HomePage);
		log.info("TC_05_VerifyDiscountCuponCorrectly 06: Verify Grand total equals $95");
		verifyEquals(FE_Landing_Cart_Product.getGranTotalAmount(), "$95.00");

		log.info("Step 07: Clear data in cart");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Empty Cart");
		;
	}

	@Test
	public void TC_06_CannotAddMore500Product() {
		log.info("TC_06_CannotAddMore500Product 01: Click to Mobile menu");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Mobile");

		log.info("TC_06_CannotAddMore500Product 02: Click Add to Card of Sony Experia");
		FE_Landing_Cart_Product.clickAddToCardButton(driver, "Sony Xperia");

		log.info("TC_06_CannotAddMore500Product 03: Input to Qty textbox");
		FE_Landing_Cart_Product.inputToQuantityBox("501");

		log.info("TC_06_CannotAddMore500Product 04: Click to Update button");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Update");

		log.info("TC_06_CannotAddMore500Product 05: Verify error msg is displayed");
		verifyEquals("Some of the products cannot be ordered in requested quantity.",
				FE_Landing_Cart_Product.getErrorMsgInCard());

		log.info("TC_06_CannotAddMore500Product 06: Verify not allowed uper 500 of qty");
		verifyEquals("* The maximum quantity allowed for purchase is 500.",
				FE_Landing_Cart_Product.getErrorMsgOnProductInCard(driver, "Sony Xperia"));

		log.info("TC_06_CannotAddMore500Product 07: Click to Empty button");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Empty Cart");

		log.info("TC_06_CannotAddMore500Product 08: Verify shopping card empty msg is displayed");
		verifyEquals("SHOPPING CART IS EMPTY", FE_Landing_Cart_Product.getEmptyMsgFromCart());

		log.info("TC_06_CannotAddMore500Product 09: Verify haven't any product in shopping cart");
		verifyTrue(FE_Landing_Cart_Product.isShopingCartTableUnDisplayed());
	}

	@Test
	public void TC_07_AbleToCompareTwoProduct() {
		log.info("Step 01: Click to Mobile menu");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Mobile");

		log.info("Step 02: Click to Add To Compare with Sony Xperia");
		FE_Landing_Cart_Product.clickToDynamicAddToCard_CompareLink(driver, "Sony Xperia", "Add to Compare");

		log.info("Step 02: Click to Add To Compare with Sony Xperia");
		FE_Landing_Cart_Product.clickToDynamicAddToCard_CompareLink(driver, "IPhone", "Add to Compare");

		log.info("Step 02: Click to Compare button");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Compare");

		// verifyTrue(FE_LandingPage.isChildWindowDisplayed());
		FE_Landing_Cart_Product.switchToCampareWindow("Products Comparison List - Magento Commerce");
		verifyEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
		verifyEquals(FE_Landing_Cart_Product.getDynamicNavBarProductName(driver, "Sony Xperia"), "SONY XPERIA");
		verifyEquals(FE_Landing_Cart_Product.getCostOfProduct(driver, "Sony Xperia"), "$100.00");
		verifyEquals(FE_Landing_Cart_Product.getDynamicNavBarProductName(driver, "IPhone"), "IPHONE");
		FE_Landing_Cart_Product.switchToWindowByTitle(driver, "Mobile");
		FE_Landing_Cart_Product.closeWindow();
	}

	@Test
	public void TC_08_ShareWishList() {

		log.info("Step 01: Click to TV menu");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "TV");

		log.info("Step 02: Click to Add to wishlist");
		FE_Landing_Cart_Product.clickToDynamicAddToCard_CompareLink(driver, "LG LCD", "Add to Wishlist");
		System.out.println(
				"WishList : " + FE_Landing_Cart_Product.getTextOfElement(driver, "//li[@class='success-msg']//span"));
		verifyEquals("LG LCD has been added to your wishlist. Click here to continue shopping.",
				FE_Landing_Cart_Product.getMsgSuccessAfterSubmit());
		verifyEquals(1, FE_Landing_Cart_Product.NumberRowOfTable(driver));

		log.info("Step 03: Click to Share wishlist");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Share Wishlist");

		log.info("Step 04: Enter to email and message");
		FE_Landing_Cart_Product.inputToDynamicTextArea(driver, email, "email_address");
		FE_Landing_Cart_Product.inputToDynamicTextArea(driver, firstName + lastName + middleName, "message");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Share Wishlist");
		verifyEquals("Your Wishlist has been shared.", FE_Landing_Cart_Product.getMsgSuccessAfterSubmit());
	}

	@Test
	public void TC_09_AddYourReview() {
		log.info("Step 01: Click to TV menu");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "TV");

		log.info("Step 02: Click to Samsung LCD");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Samsung LCD");

		log.info("Step 03: Click to Add Your Review");
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Add Your Review");

		log.info("Step 04: Clear text into textbox and areabox");
		FE_Landing_Cart_Product.clearTextInTextBox(driver, "summary_field");
		FE_Landing_Cart_Product.clearTextInTextBox(driver, "nickname_field");
		FE_Landing_Cart_Product.clearTextInAreaBox(driver, "review_field");

		log.info("Step 05: Click to Submit Review");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Submit Review");

		log.info("Step 06: Verify error msg is displayed");
		verifyEquals("THIS IS A REQUIRED FIELD.",
				FE_Landing_Cart_Product.getErrMsgFromTextbox(driver, "summary_field"));
		verifyEquals("THIS IS A REQUIRED FIELD.",
				FE_Landing_Cart_Product.getErrMsgFromTextbox(driver, "nickname_field"));
		verifyEquals("THIS IS A REQUIRED FIELD.",
				FE_Landing_Cart_Product.getErrMsgFromTextArea(driver, "review_field"));

		log.info("Step 06: Input to all field");
		FE_Landing_Cart_Product.clickToDynamicCheckbox(driver, "Quality 1_5");
		FE_Landing_Cart_Product.inputToDynamicTextbox(driver, firstName, "summary_field");
		FE_Landing_Cart_Product.inputToDynamicTextbox(driver, lastName, "nickname_field");
		FE_Landing_Cart_Product.inputToDynamicTextArea(driver, email, "review_field");
		FE_Landing_Cart_Product.clickToDynamicLinkButton(driver, "Submit Review");

		log.info("Step 07: Verify success msg displayed");
		verifyEquals(FE_Landing_Cart_Product.getMsgSuccessAfterSubmit(),
				"Your review has been accepted for moderation.");

		log.info("Step 08: Input to all field");
		verifyFalse(FE_Landing_Cart_Product.isControlUndisplayed(driver, "//li[@class='success-msg']//span"));
	}

	@Test
	public void TC_10_UserAblePurchaseProduct() throws Exception {
		log.info("TC_10_UserAblePurchaseProduct Step 01: Click to Account Link");
		FE_Landing_Cart_Product.clicktoHeaderAccountLink();

		log.info("TC_10_UserAblePurchaseProduct Step 02: Click to My wishlist");
		FE_Landing_Cart_Product.clickToHeaderMenuLinkButton(driver, "My Wishlist");

		log.info("TC_10_UserAblePurchaseProduct Step 03: Open trang shopping card ");
		FE_WishListPage = PageFactoryManage.getWistListPage(driver);

		log.info("TC_10_UserAblePurchaseProduct Step 04: Click to Add to card ");
		FE_WishListPage.clickToDynamicAddUpdateBtnInWishList_ForOneProduct(driver, "LG LCD", "Add to Cart");
		FE_ShoppingCardPage = PageFactoryManage.getShoppingCartPage(driver);
//		FE_ShoppingCardPage.sendKeyToElement(driver, "//input[@id='postcode']", "000000");

		log.info("TC_10_UserAblePurchaseProduct Step 05: Select Country");
		FE_ShoppingCardPage.selectItemInDynamicDropdown(driver, "United States", "country_id");

		log.info("TC_10_UserAblePurchaseProduct Step 06: Select state");
		FE_ShoppingCardPage.selectItemInDynamicDropdown(driver, "New York", "region_id");

		log.info("TC_10_UserAblePurchaseProduct Step 07: Input to zipcode");
		FE_ShoppingCardPage.inputToDynamicTextbox(driver, "000000", "postcode");

		log.info("TC_10_UserAblePurchaseProduct Step 08: Click to estimate button");
		FE_ShoppingCardPage.clickToDynamicLinkButton(driver, "Estimate");

		log.info("TC_10_UserAblePurchaseProduct Step 09: Verify Shipping & handling rate is equals $5");
		verifyFalse(FE_ShoppingCardPage.isFlateRateFixDisplayed(driver, "Shipping & Handling (Flat Rate - Fixed)"));

		log.info("TC_10_UserAblePurchaseProduct Step 10: Check to checkbox flateRate");
		FE_ShoppingCardPage.clickToDynamicCheckbox(driver, "s_method_flatrate_flatrate");
		FE_ShoppingCardPage.clickToDynamicLinkButton(driver, "Update Total");
		verifyFalse(FE_ShoppingCardPage.isFlateRateFixDisplayed(driver, "Shipping & Handling (Flat Rate - Fixed)"));

		log.info("TC_10_UserAblePurchaseProduct Step 11: Click to Proceed to checkout");
		FE_ShoppingCardPage.clickToDynamicLinkButton(driver, "Proceed to Checkout");

		FE_CheckoutCartPage = PageFactoryManage.getCheckoutCartPage(driver);

		log.info("TC_10_UserAblePurchaseProduct Step 12: Input to Billing Information");
		FE_CheckoutCartPage.inputToDynamicTextbox(driver, companyShip, "billing:company");
		FE_CheckoutCartPage.inputToDynamicTextbox(driver, addShip, "billing:street1");
		FE_CheckoutCartPage.inputToDynamicTextbox(driver, add2Ship, "billing:street2");
		FE_CheckoutCartPage.inputToDynamicTextbox(driver, cityShip, "billing:city");
		FE_CheckoutCartPage.inputToDynamicTextbox(driver, zipShip, "billing:postcode");
		FE_CheckoutCartPage.inputToDynamicTextbox(driver, telephoneShip, "billing:telephone");
		FE_CheckoutCartPage.inputToDynamicTextbox(driver, faxShip, "billing:fax");

		FE_CheckoutCartPage.selectItemInDynamicDropdown(driver, "New York", "billing[region_id]");
		FE_CheckoutCartPage.selectItemInDynamicDropdown(driver, "United States", "billing[country_id]");
		regionText = FE_CheckoutCartPage.getSelectedItemInDynamicDropdown(driver, "billing[region_id]");
		countryText = FE_CheckoutCartPage.getSelectedItemInDynamicDropdown(driver, "billing[country_id]");
		System.out.println("region text selected: " + regionText);

		log.info("TC_10_UserAblePurchaseProduct Step 13: Click to Continue button");
		FE_CheckoutCartPage.clickToDynamicContinueButtonInCheckout(driver, "checkout-step-billing");
		verifyTrue(FE_CheckoutCartPage.isLoadingNextStepDisplayed(driver, "checkout-step-billing"));

		Thread.sleep(2000);
		FE_ShoppingCardPage.clickToCheckoutStep(driver, "Shipping Information");
		Thread.sleep(2000);
		FE_CheckoutCartPage.clickToDynamicContinueButtonInCheckout(driver, "checkout-step-shipping");
		verifyTrue(FE_CheckoutCartPage.isLoadingNextStepDisplayed(driver, "checkout-step-shipping"));
		Thread.sleep(1000);

		FE_CheckoutCartPage.clickToCheckoutStep(driver, "Shipping Method");
		Thread.sleep(1000);

		FE_CheckoutCartPage.clickToDynamicContinueButtonInCheckout(driver, "checkout-step-shipping_method");
		verifyTrue(FE_CheckoutCartPage.isLoadingNextStepDisplayed(driver, "checkout-step-shipping_method"));
		Thread.sleep(1000);

		FE_CheckoutCartPage.clickToCheckoutStep(driver, "Payment Information");
		Thread.sleep(1000);
//		FE_CheckoutCartPage.clickToDynamicCheckbox(driver, "p_method_ccsave");
//		FE_CheckoutCartPage.inputToDynamicTextbox(driver, firstName +  " " + middleName + " " + lastName , "ccsave_cc_owner");
//		FE_CheckoutCartPage.selectItemInDynamicDropdown(driver, "Visa", "payment[cc_type]");
//		FE_CheckoutCartPage.inputToDynamicTextbox(driver, creditCartNumber, "ccsave_cc_number");
//		FE_CheckoutCartPage.selectItemInDynamicDropdown(driver, "11 - November", "payment[cc_exp_month]");
//		FE_CheckoutCartPage.selectItemInDynamicDropdown(driver, "2029", "payment[cc_exp_year]");
//		FE_CheckoutCartPage.inputToDynamicTextbox(driver, "123" , "ccsave_cc_cid");

		FE_CheckoutCartPage.clickToDynamicCheckbox(driver, "p_method_checkmo");
		FE_CheckoutCartPage.clickToDynamicContinueButtonInCheckout(driver, "checkout-step-payment");
		verifyTrue(FE_CheckoutCartPage.isLoadingNextStepDisplayed(driver, "checkout-step-payment"));
		FE_CheckoutCartPage.clickToDynamicLinkButton(driver, "Place Order");
		orderCode = FE_CheckoutCartPage.getOrderCode();
		verifyTrue(FE_CheckoutCartPage.isOrderCodeIsDisplayed(orderCode));
		FE_CheckoutCartPage.clickToOrderCode(orderCode);
		FE_OrderPage = PageFactoryManage.getOrderPage(driver);
		String BillingInfo = firstName + " " + middleName + " " + lastName + "\n" + companyShip + "\n" + addShip + "\n"
				+ add2Ship + "\n" + cityShip + ", " + regionText + ", " + zipShip +"\n" + countryText + "\n" + "T: " + telephoneShip + "\n" + "F: " + faxShip;
		verifyEquals(FE_OrderPage.getBillingAddress(), BillingInfo);

	}
	
	@Test
	public void TC_11_VerifySearchFunctionality() {
		FE_OrderPage.clickToMagentoImg(driver);
		FE_Landing_Cart_Product = PageFactoryManage.getLandingPage(driver);
		FE_Landing_Cart_Product.clickToDynamicMenu_ProductName(driver, "Advanced Search");
		FE_AdvanceSearch = PageFactoryManage.getAdvanceSearchPage(driver);
		FE_AdvanceSearch.inputToDynamicTextbox(driver, "0", "price");
		FE_AdvanceSearch.inputToDynamicTextbox(driver, "150", "price_to");
		FE_AdvanceSearch.clicktoSearchButton();
		
		productNameInSearchAdvance1 = FE_AdvanceSearch.getProductName(driver, "Sony Xperia");
		productNameInSearchAdvance1 = FE_AdvanceSearch.getProductName(driver, "Samsung Galaxy");
		priceInSearchAdvance1 = FE_AdvanceSearch.getCostOfProduct(driver, "Sony Xperia");
		priceInSearchAdvance2 = FE_AdvanceSearch.getCostOfProduct(driver, "Samsung Galaxy");
		verifyEquals(priceInList, priceInSearchAdvance1);
		System.out.println("Samsung Galaxy: "+ priceInSearchAdvance2);
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterTest
	public void afterTest() {
		closeBrowserDriver();
	}

}
