package com.bankguru.frontend;

public class FE_LandingPageUI {
	public static final String HEADER_ACCOUNT_LINK ="//div[@class='page-header-container']//span[text()='Account']";
	
	public static final String PRICE_IN_DETAIL ="//div[@class='product-shop']//span[@class='price']";
	public static final String APPLY_BUTTON ="//span[text()='Apply']";
	public static final String GRAND_TOTAL_AMOUNT ="//strong[text()='Grand Total']//ancestor::td//following-sibling::td//span[@class='price']";
	public static final String ERROR_MSG_ON_CARD ="//li[@class='error-msg']//span";
	public static final String EMPTY_CART_MSG ="//div[@class='page-title']//h1";
	public static final String SHOPING_CART_TABLE ="//table[@id='shopping-cart-table']";
	public static final String MSG_SUCCESS_AFTER_SUBMIT ="//li[@class='success-msg']//span";
	public static final String WISHLIST_TABLE ="//table[@id='wishlist-table']//tbody//tr";
}
