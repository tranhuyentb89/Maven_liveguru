package pageObject;

import org.openqa.selenium.WebDriver;

import com.liveguru.backend.BE_LoginPageUI;

import commons.AbstractPages;

public class BE_LoginPageObject extends AbstractPages{
	public BE_LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	WebDriver driver;

	public void clickToLoginButton() {
		highlightElement(driver, BE_LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, BE_LoginPageUI.LOGIN_BUTTON);
	}
}
