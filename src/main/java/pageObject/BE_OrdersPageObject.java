package pageObject;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class BE_OrdersPageObject extends AbstractPages {
    WebDriver driver;
    public BE_OrdersPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
