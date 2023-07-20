package pageObject;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class FE_ReviewPageObject extends AbstractPages {
    WebDriver driver;

     public  FE_ReviewPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }
}
