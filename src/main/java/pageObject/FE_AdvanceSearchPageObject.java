package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.frontend.FE_AdvanceSearchPageUI;
import com.bankguru.frontend.FE_CheckOutCardPageUI;
import com.bankguru.frontend.FE_OrderPageUI;

import commons.AbstractPages;

public class FE_AdvanceSearchPageObject extends AbstractPages {
	WebDriver driver;

	public FE_AdvanceSearchPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void clicktoSearchButton() {
		clickToElement(driver, FE_AdvanceSearchPageUI.SEARCH_BUTTON);
	}
}
