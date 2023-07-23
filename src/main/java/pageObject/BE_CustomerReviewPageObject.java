package pageObject;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class BE_CustomerReviewPageObject extends AbstractPages {
    WebDriver driver;
    public BE_CustomerReviewPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
