package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.frontend.FE_RegisterPageUI;

import commons.AbstractPages;

public class FE_CompareWindowPageObject extends AbstractPages{
	WebDriver driver;
	public FE_CompareWindowPageObject(WebDriver mappingdriver) {
		driver = mappingdriver;
	}
}
