package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.liveguru.backend.BE_ManageCustomerPageUI;

import commons.AbstractPageUI;
import commons.AbstractPages;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BE_ManageCustomerPageObject extends AbstractPages {

    public BE_ManageCustomerPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    WebDriver driver;

    public boolean isIncomeMessageDisplayed() {
        return isControlDisplayed(driver, BE_ManageCustomerPageUI.INCOM_MESSAGE);
    }

    public void clickToCloseIncomMessage() {
        highlightElement(driver, BE_ManageCustomerPageUI.CLOSE_INCOM_MESSAGE);
        clickToElement(driver, BE_ManageCustomerPageUI.CLOSE_INCOM_MESSAGE);
    }

    public void clickOKToAcceptDelete() {
        acceptAlert(driver);
    }

    public boolean isNoRecordFoundMsgDisplayed() {
        highlightElement(driver, BE_ManageCustomerPageUI.NO_RECORD_MESSAGE);
        return isControlDisplayed(driver, BE_ManageCustomerPageUI.NO_RECORD_MESSAGE);
    }

    public boolean isReviewColumnDisplayed(String values) {
        return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_COLUMN_ON_TABLE, values);
    }

    public String getReviewIDSelected(String atributeName, String value01, String value02) {
        return getAtributeValue(driver, AbstractPageUI.DYNAMIC_CHECKBOX_IN_REVIEW_TABLE, atributeName, value01, value02);
    }

    public boolean isApprovedStatusDisplayed(String summaryReview, String detailReview) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_STATUS_IN_REVIEW_TABLE, summaryReview, detailReview);
        return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_STATUS_IN_REVIEW_TABLE, summaryReview, detailReview);
    }

    public void selectFirstItemInTable() {
        List<WebElement> listCheckbox = driver.findElements(By.xpath(BE_ManageCustomerPageUI.CHECKBOX_IN_BE_TABLE));
        System.out.println("This is first checkbox" + listCheckbox.get(0).getText());
        listCheckbox.get(0).click();
    }

    public String getTextOfErrorMesg() {
        return getTextOfElement(driver, BE_ManageCustomerPageUI.ERR_MSG);
    }
}
