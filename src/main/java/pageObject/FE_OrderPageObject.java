package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.frontend.FE_CheckOutCardPageUI;
import com.bankguru.frontend.FE_OrderPageUI;

import commons.AbstractPages;

public class FE_OrderPageObject extends AbstractPages {
	WebDriver driver;

	public FE_OrderPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public Object getBillingAddress() {
		return getTextOfElement(driver, FE_OrderPageUI.BILLING_ORDER);
	}

}
