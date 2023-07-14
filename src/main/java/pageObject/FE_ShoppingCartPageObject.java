package pageObject;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;

public class FE_ShoppingCartPageObject extends AbstractPages {
	WebDriver driver;

	public FE_ShoppingCartPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
