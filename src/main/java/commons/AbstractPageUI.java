package commons;

public class AbstractPageUI {
	public static final String DYNAMIC_PAGE_TITLE = "//h1[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_CHECKBOX ="//input[@id='%s']";
	public static final String DYNAMIC_ERR_TEXTBOX_CHECKBOX_MSG ="//input[@id='%s']//following-sibling::div";
	public static final String DYNAMIC_NAVMENU_PRODUCT_NAME ="//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_PRICE ="//a[text()='%s']//ancestor::h2//following-sibling::div//span[contains(@id,'product-price')]";
	public static final String DYNAMIC_ADDCARD_BUTTON ="//a[text()='%s']//ancestor::h2//following-sibling::div//span[text()='Add to Cart']";
	public static final String DYNAMIC_ADDTOCOMPARE_ADDTOWISHLIST ="//a[text()='%s']//ancestor::h2//following-sibling::div//a[text()='%s']";
	
	public static final String DYNAMIC_TEXTBOX_INPUT ="//input[@id='%s']";
	
	////a[contains(text(),'LG LCD')]//ancestor::td//following-sibling::td//span[text()='Add to Cart']
	public static final String DYNAMIC_BUTTON_ADD_UPDATE_IN_WIISHLIST_ONE_PRODUCT ="//a[contains(text(),'%s')]//ancestor::td//following-sibling::td//span[text()='%s']";
	public static final String DYNAMIC_EDIT_REMOVE_IN_WISHLIST ="//a[contains(text(),'%s')]//ancestor::td//following-sibling::td//a[text()='%s']";
	
	//DYNAMIC LOCATOR IN SHOPPING CART
	public static final String DYNAMIC_DROPDOWN_PARENT ="//select[@name='%s']";
	public static final String DYNAMIC_DROPDOWN_CHILD ="//select[@name='%s']//option";
	
	public static final String DYNAMIC_AMOUNT_IN_CARD ="//td[contains(text(),'%s')]//following-sibling::td//span";
	public static final String DYNAMIC_LINK_BUTTON ="//span[text()='%s']";
	public static final String DYNAMIC_ERROR_MSG_ON_PRODUCT_IN_CARD ="//a[text()='%s']//parent::h2//following-sibling::p";
	public static final String DYNAMIC_AREABOX ="//textarea[@id='%s']";
	public static final String DYNAMIC_ERR_AREA_MSG ="//textarea[@id='%s']//following-sibling::div";
	public static final String DYNAMIC_HEADER_MENU_LINK_BUTTON ="//div[@id='header-account']//a[contains(text(),'%s')]";
	
	public static final String DYNAMIC_BUTTON_IN_CHECKOUT ="//div[@id='%s']//button//span[text()='Continue']";
	public static final String DYNAMIC_CHECKOUT_STEP ="//h2[text()='%s']";
	public static final String DYNAMIC_CHECKOUT_LOADING_IMG="//div[@id='%s']//span[@class='please-wait']";
	
	public static final String DYNAMIC_PRODUCT_NAME_IN_ADVANCE_SEARCH ="//h2[@class='product-name']//a[@title='%s']";
	public static final String DYNAMIC_REVIEW_SUMMARY ="//a[contains(@href,'%s')]";
	
	
	//BACKEND
	public static final String DYNAMIC_CHECKBOX_CUSTOMER_MANAGE ="//td[contains(text(),'%s')]//preceding-sibling::td//input[@type='checkbox']";
	public static final String DYNAMIC_ACTION_DDROPDOWN_CUSTOMER_MANAGE_PARENT ="//select[@id='%s']";
	public static final String DYNAMIC_ACTION_DDROPDOWN_CUSTOMER_MANAGE_CHILD ="//select[@id='%s']//option";

	public static final String DYNAMIC_COLUMN_ON_TABLE ="//td[contains(text(),'%s')]";
	
	public static final String DYNAMIC_CHECKBOX_IN_REVIEW_TABLE ="//td[contains(text(),'%s')]//following-sibling::td[contains(text(),'%s')]//preceding-sibling::td//input[@name='reviews']";
	public static final String DYNAMIC_EDIT_BUTTON_IN_REVIEW_TABLE ="//td[contains(text(),'%s')]//following-sibling::td//a[text()='Edit']";
	public static final String DYNAMIC_STATUS_IN_REVIEW_TABLE ="//td[contains(text(),'%s')]//following-sibling::td[contains(text(),'%s')]//preceding-sibling::td[contains(text(),'Approved')]";
	
	public static final String INVOICE_NUMBER_COLUMN = "//table[@id='sales_invoice_grid_table']//td[%s]";
	public  static final String DYNAMIC_TABLE_BACKEND ="//table[@id='%s']//tbody//tr";
	public static final String NUMBER_OF_ROW_IN_TABLE_DROPDOWN_PARENT ="//select[@name='limit']";
	public static final String NUMBER_OF_ROW_IN_TABLE_DROPDOWN_CHILD ="//select[@name='limit']//option";
	public static final String NUMBER_OF_ITEM_SELECTED = "//strong[contains(@id,'massaction-count')]";

	public static final String DYNAMIC_COLUMN_IN_DYNAMIC_TABLE ="//table[@id='%s']//td[contains(text(),'%s')]//following-sibling::td[%s]";
	public static final String DYNAMIC_TOTAL_ITEMS ="//span[@id='%s']";
	public static final String TOTAL_RECORD_FOUND ="//td[@class='pager']";
}
