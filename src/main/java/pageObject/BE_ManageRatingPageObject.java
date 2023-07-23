package pageObject;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class BE_ManageRatingPageObject extends AbstractPages {
    WebDriver driver;
    public BE_ManageRatingPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
