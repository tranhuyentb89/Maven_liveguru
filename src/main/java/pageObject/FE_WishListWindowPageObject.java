package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.frontend.FE_RegisterPageUI;

import commons.AbstractPages;

public class FE_WishListWindowPageObject extends AbstractPages{
	WebDriver driver;
	public FE_WishListWindowPageObject(WebDriver mappingdriver) {
		driver = mappingdriver;
	}
}
