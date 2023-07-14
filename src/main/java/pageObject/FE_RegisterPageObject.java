package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.frontend.FE_RegisterPageUI;

import commons.AbstractPages;

public class FE_RegisterPageObject extends AbstractPages{
	WebDriver driver;
	public FE_RegisterPageObject(WebDriver mappingdriver) {
		driver = mappingdriver;
	}
	public boolean isRegisterPageDisplayed() {
//		waitForElementVisible(driver, FE_RegisterPageUI.REGISTER_PAGE_TITLE);
		return isControlDisplayed(driver, FE_RegisterPageUI.REGISTER_PAGE_TITLE);
	}
	public void clickToRegisterButton() {
		highlightElement(driver, FE_RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, FE_RegisterPageUI.REGISTER_BUTTON);
	}

}
