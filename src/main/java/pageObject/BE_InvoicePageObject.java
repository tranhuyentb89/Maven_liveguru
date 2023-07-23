package pageObject;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class BE_InvoicePageObject extends AbstractPages {
    WebDriver driver;
    public BE_InvoicePageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
