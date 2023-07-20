package commons;

import static org.testng.Assert.fail;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.bankguru.frontend.FE_HomePageUI;
import com.bankguru.frontend.FE_LandingPageUI;

public class AbstractPages {

    WebElement element;
    List<WebElement> elements;
    JavascriptExecutor jsExecuter;
    WebDriverWait waitExplicit;
    Actions action;
    By byLocator;

    public void openAnyUrl(WebDriver driver, String Url) {
        driver.get(Url);
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public String getTextOfElement(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        return element.getText();
    }

    public String getTextOfElement(WebDriver driver, String locatorXpath, String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        element = driver.findElement(By.xpath(locatorXpath));
        System.out.println("aaasdfsdfdsfds");
        return element.getText();
    }

    public void backToPreviousPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPreviousPage(WebDriver driver) {
        driver.navigate().forward();
        ;
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getTextInAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    // WebElement
    public void clickToElement(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        highlightElement(driver, locatorXpath);
        element.click();
    }

    public void clickToElement(WebDriver driver, String locatorXpath, String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        element = driver.findElement(By.xpath(locatorXpath));
        highlightElement(driver, locatorXpath);
        element.click();
    }

    public void sendKeyToElement(WebDriver driver, String locatorXpath, String valueToInput) {
        element = driver.findElement(By.xpath(locatorXpath));
        highlightElement(driver, locatorXpath);
        element.sendKeys(valueToInput);
    }

    public void sendKeyToElement(WebDriver driver, String locatorXpath, String valueToInput,
                                 String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        highlightElement(driver, locatorXpath);
        element = driver.findElement(By.xpath(locatorXpath));
        element.sendKeys(valueToInput);
    }

    public void selectItemInDropdown(WebDriver driver, String locatorXpath, String value) {
        element = driver.findElement(By.xpath(locatorXpath));
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectItemInDropdown(WebDriver driver, String locatorXpath, String valueSelect,
                                     String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        element = driver.findElement(By.xpath(locatorXpath));
        Select select = new Select(element);
        select.selectByVisibleText(valueSelect);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locatorXpath, String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        element = driver.findElement(By.xpath(locatorXpath));
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath,
                                           String expectedValue) {
        WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));
        jsExecuter = (JavascriptExecutor) driver;

        jsExecuter.executeScript("arguments[0].click();", parentDropdown);

        waitExplicit = new WebDriverWait(driver, 30);
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

        List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
        for (WebElement childElement : allItems) {
            if (childElement.getText().contains(expectedValue)) {
                jsExecuter.executeScript("arguments[0].scrollIntoView(true);", childElement);
                if (childElement.isDisplayed()) {
                    childElement.click();
                } else {
                    jsExecuter.executeScript("arguments[0].click();", childElement);

                }
                break;
            }
        }
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath,
                                           String expectedValue, String... values) {
        parentXpath = String.format(parentXpath, (Object[]) values);
        allItemXpath = String.format(allItemXpath, (Object[]) values);

        WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));
        jsExecuter = (JavascriptExecutor) driver;
        jsExecuter.executeScript("arguments[0].click();", parentDropdown);

        waitExplicit = new WebDriverWait(driver, 30);
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

        List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
        for (WebElement childElement : allItems) {
            if (childElement.getText().contains(expectedValue)) {
                jsExecuter.executeScript("arguments[0].scrollIntoView(true);", childElement);
                if (childElement.isDisplayed()) {
                    childElement.click();
                } else {
                    jsExecuter.executeScript("arguments[0].click();", childElement);

                }
                break;
            }
        }
    }

    public String getAtributeValue(WebDriver driver, String locatorXpath, String atributeName) {
        element = driver.findElement(By.xpath(locatorXpath));
        return element.getAttribute(atributeName);
    }

    public String getAtributeValue(WebDriver driver, String locatorXpath, String atributeName,
                                   String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        element = driver.findElement(By.xpath(locatorXpath));
        return element.getAttribute(atributeName);
    }

    public int countElementNumber(WebDriver driver, String locatorXpath) {
        elements = driver.findElements(By.xpath(locatorXpath));
        return elements.size();
    }

    public void checkTheCheckbox(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void unCheckTheCheckbox(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        return element.isDisplayed();
    }

    public boolean isControlDisplayed(WebDriver driver, String locatorXpath, String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        element = driver.findElement(By.xpath(locatorXpath));
        return element.isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        return element.isSelected();
    }

    public boolean isControlEnable(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        return element.isEnabled();
    }

    // Switch if have only 2 window
    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    // Switch if have > 2 window
    public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(expectedTitle)) {
                break;
            }
        }
    }

    public boolean closeAllWindowWithoutParentWindows(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
        if (driver.getWindowHandles().size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void switchToIframe(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        driver.switchTo().frame(element);
    }

    public void backToTopWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // User Actions

    public void hoverMouseToElement(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void hoverMouseToElement(WebDriver driver, String locatorXpath, String... dynamicValue) {
        locatorXpath = String.format(locatorXpath, (Object[]) dynamicValue);
        element = driver.findElement(By.xpath(locatorXpath));
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locatorXpath, Keys key) {
        element = driver.findElement(By.xpath(locatorXpath));
        action = new Actions(driver);
        action.sendKeys(element, key).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, Keys key, String locatorXpath,
                                      String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        element = driver.findElement(By.xpath(locatorXpath));
        action = new Actions(driver);
        action.sendKeys(element, key).perform();
    }

    public void clearTextInElement(WebDriver driver, String locatorXpath) {
        element = driver.findElement(By.xpath(locatorXpath));
        element.clear();
    }

    public void clearTextInElement(WebDriver driver, String locatorXpath, String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        element = driver.findElement(By.xpath(locatorXpath));
        element.clear();
    }

    public void highlightElement(WebDriver driver, String locatorXpath) {
        jsExecuter = (JavascriptExecutor) driver;
        element = driver.findElement(By.xpath(locatorXpath));
        jsExecuter.executeScript("arguments[0].style.border='2px solid red'", element);
    }

    public void highlightElement(WebDriver driver, String locatorXpath, String... dynamicValue) {
        jsExecuter = (JavascriptExecutor) driver;
        locatorXpath = String.format(locatorXpath, (Object[]) dynamicValue);
        element = driver.findElement(By.xpath(locatorXpath));
        jsExecuter.executeScript("arguments[0].style.border='2px solid red'", element);
    }

    public Object executeForBrowser(WebDriver driver, String javaSript) {
        jsExecuter = (JavascriptExecutor) driver;
        return jsExecuter.executeScript(javaSript);
    }

    public Object clickToElementByJS(WebDriver driver, String xpathName) {
        element = driver.findElement(By.xpath(xpathName));
        jsExecuter = (JavascriptExecutor) driver;
        return jsExecuter.executeScript("arguments[0].click();", element);
    }

    public Object clickToElementByJS(WebDriver driver, String xpathName, String... values) {
        xpathName = String.format(xpathName, (Object[]) values);
        element = driver.findElement(By.xpath(xpathName));
        jsExecuter = (JavascriptExecutor) driver;
        return jsExecuter.executeScript("arguments[0].click();", element);
    }

    public Object srollToElementByJS(WebDriver driver, String xpathName) {
        element = driver.findElement(By.xpath(xpathName));
        jsExecuter = (JavascriptExecutor) driver;
        return jsExecuter.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public Object srollToElementByJS(WebDriver driver, String xpathName, String... values) {
        xpathName = String.format(xpathName, (Object[]) values);
        element = driver.findElement(By.xpath(xpathName));
        jsExecuter = (JavascriptExecutor) driver;
        return jsExecuter.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public Object sendkeyToElementByJS(WebDriver driver, String xpathName, String value) {
        element = driver.findElement(By.xpath(xpathName));
        jsExecuter = (JavascriptExecutor) driver;
        return jsExecuter.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    public Object removeAttributeInDOM(WebDriver driver, String xpathName, String attribute) {
        element = driver.findElement(By.xpath(xpathName));
        jsExecuter = (JavascriptExecutor) driver;
        return jsExecuter.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
    }

    public Object scrollToBottomPage(WebDriver driver) {
        jsExecuter = (JavascriptExecutor) driver;
        return jsExecuter.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public Object navigateToUrlByJS(WebDriver driver, String url) {
        jsExecuter = (JavascriptExecutor) driver;
        return jsExecuter.executeScript("window.location = '" + url + "'");
    }

    public void waitForElementPresence(WebDriver driver, String locatorXpath) {
        waitExplicit = new WebDriverWait(driver, Contants.LONG_TIMEOUT);
        byLocator = By.xpath(locatorXpath);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    public void waitForElementPresence(WebDriver driver, String locatorXpath, String... values) {
        waitExplicit = new WebDriverWait(driver, Contants.LONG_TIMEOUT);
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        byLocator = By.xpath(locatorXpath);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }


    public void waitForElementVisible(WebDriver driver, String locatorXpath) {
        waitExplicit = new WebDriverWait(driver, Contants.LONG_TIMEOUT);
        byLocator = By.xpath(locatorXpath);
        waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
    }

    public void waitForElementVisible(WebDriver driver, String locatorXpath, String... values) {
        waitExplicit = new WebDriverWait(driver, Contants.LONG_TIMEOUT);
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        byLocator = By.xpath(locatorXpath);
        waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
    }

    public void waitForElementClickAble(WebDriver driver, String locatorXpath) {
        waitExplicit = new WebDriverWait(driver, Contants.LONG_TIMEOUT);
        byLocator = By.xpath(locatorXpath);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
    }

    public void waitForElementClickAble(WebDriver driver, String locatorXpath, String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        waitExplicit = new WebDriverWait(driver, Contants.LONG_TIMEOUT);
        byLocator = By.xpath(locatorXpath);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
    }


    public void waitForElementInvisible(WebDriver driver, String locatorXpath) {
        waitExplicit = new WebDriverWait(driver, Contants.LONG_TIMEOUT);
        byLocator = By.xpath(locatorXpath);
        waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
    }

    public void waitForAlertPresent(WebDriver driver) {
        waitExplicit = new WebDriverWait(driver, Contants.LONG_TIMEOUT);
        waitExplicit.until(ExpectedConditions.alertIsPresent());
    }

    public void inputToDynamicTextbox(WebDriver driver, String valueInput, String dynamicValue) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_CHECKBOX, dynamicValue);
        sendKeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_CHECKBOX, valueInput, dynamicValue);
    }

    public void clickToDynamicCheckbox(WebDriver driver, String dynamicValue) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_CHECKBOX, dynamicValue);
        clickToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_CHECKBOX, dynamicValue);
    }

    public void clickToDynamicMenu_ProductName(WebDriver driver, String dynamicMenuLink) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_NAVMENU_PRODUCT_NAME, dynamicMenuLink);
        clickToElement(driver, AbstractPageUI.DYNAMIC_NAVMENU_PRODUCT_NAME, dynamicMenuLink);
    }

    public String getCostOfProduct(WebDriver driver, String dynamicProductName) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_PRODUCT_PRICE, dynamicProductName);
        return getTextOfElement(driver, AbstractPageUI.DYNAMIC_PRODUCT_PRICE, dynamicProductName);
    }

    public void clickAddToCardButton(WebDriver driver, String dynamicAddToCardBtn) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_ADDCARD_BUTTON, dynamicAddToCardBtn);
        clickToElement(driver, AbstractPageUI.DYNAMIC_ADDCARD_BUTTON, dynamicAddToCardBtn);
    }

    public String getAmountInCard(WebDriver driver, String dynamicAmount) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_AMOUNT_IN_CARD, dynamicAmount);
        return getTextOfElement(driver, AbstractPageUI.DYNAMIC_AMOUNT_IN_CARD, dynamicAmount);
    }

    public void clickToDynamicLinkButton(WebDriver driver, String dynamicLinkButton) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_LINK_BUTTON, dynamicLinkButton);
        clickToElement(driver, AbstractPageUI.DYNAMIC_LINK_BUTTON, dynamicLinkButton);
    }

    public String getErrorMsgOnProductInCard(WebDriver driver, String dynamicProduct) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_ERROR_MSG_ON_PRODUCT_IN_CARD, dynamicProduct);
        return getTextOfElement(driver, AbstractPageUI.DYNAMIC_ERROR_MSG_ON_PRODUCT_IN_CARD,
                dynamicProduct);

    }

    public boolean isControlUndisplayed(WebDriver driver, String locator) {
        overwriteTimeout(driver, Contants.SHORT_TIMEOUT);
        elements = driver.findElements(By.xpath(locator));
        if (elements.size() == 0) {
            System.out.println("ELEMENT NOT IN DOM");
            overwriteTimeout(driver, Contants.LONG_TIMEOUT);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("ELEMENT IN DOM BUT NOT VISIBLE");
            overwriteTimeout(driver, Contants.LONG_TIMEOUT);
            return true;
        } else {
            System.out.println("ELEMENT IN DOM");
            overwriteTimeout(driver, Contants.LONG_TIMEOUT);
            return false;
        }
    }

    public boolean isControlUndisplayed(WebDriver driver, String locatorXpath, String... values) {
        locatorXpath = String.format(locatorXpath, (Object[]) values);
        overwriteTimeout(driver, Contants.SHORT_TIMEOUT);
        elements = driver.findElements(By.xpath(locatorXpath));
        if (elements.size() == 0) {
            System.out.println("ELEMENT NOT IN DOM");
            overwriteTimeout(driver, Contants.LONG_TIMEOUT);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("ELEMENT IN DOM BUT NOT VISIBLE");
            overwriteTimeout(driver, Contants.LONG_TIMEOUT);
            return true;
        } else {
            System.out.println("ELEMENT IN DOM");
            overwriteTimeout(driver, Contants.LONG_TIMEOUT);
            return false;
        }
    }

    public void overwriteTimeout(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public void clickToDynamicAddToCard_CompareLink(WebDriver driver, String value01,
                                                    String value02) {
        clickToElement(driver, AbstractPageUI.DYNAMIC_ADDTOCOMPARE_ADDTOWISHLIST, value01, value02);
    }

    public String getDynamicNavBarProductName(WebDriver driver, String dynamicProductName) {
        return getTextOfElement(driver, AbstractPageUI.DYNAMIC_NAVMENU_PRODUCT_NAME,
                dynamicProductName);
    }

    public void inputToDynamicTextArea(WebDriver driver, String valueToInput, String LocatorBox) {
        sendKeyToElement(driver, AbstractPageUI.DYNAMIC_AREABOX, valueToInput, LocatorBox);
    }

    public int NumberRowOfTable(WebDriver driver) {
        elements = driver.findElements(By.xpath(FE_LandingPageUI.WISHLIST_TABLE));
        return elements.size();
    }

    public void clearTextInTextBox(WebDriver driver, String dynamicValue) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_CHECKBOX, dynamicValue);
        clearTextInElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_CHECKBOX, dynamicValue);
    }

    public void clearTextInAreaBox(WebDriver driver, String dynamicValue) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_AREABOX, dynamicValue);
        clearTextInElement(driver, AbstractPageUI.DYNAMIC_AREABOX, dynamicValue);

    }

    public Object getErrMsgFromTextbox(WebDriver driver, String dynamicValue) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_ERR_TEXTBOX_CHECKBOX_MSG, dynamicValue);
        return getTextOfElement(driver, AbstractPageUI.DYNAMIC_ERR_TEXTBOX_CHECKBOX_MSG, dynamicValue);
    }

    public Object getErrMsgFromTextArea(WebDriver driver, String dynamicValue) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_ERR_AREA_MSG, dynamicValue);
        return getTextOfElement(driver, AbstractPageUI.DYNAMIC_ERR_AREA_MSG, dynamicValue);
    }

    public void clickToHeaderMenuLinkButton(WebDriver driver, String dynamicMenuLinkButton) {
        clickToElement(driver, AbstractPageUI.DYNAMIC_HEADER_MENU_LINK_BUTTON, dynamicMenuLinkButton);
    }

    public void clickToDynamicAddUpdateBtnInWishList_ForOneProduct(WebDriver driver,
                                                                   String productItem,
                                                                   String productButton) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_BUTTON_ADD_UPDATE_IN_WIISHLIST_ONE_PRODUCT,
                productItem,
                productButton);
        clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON_ADD_UPDATE_IN_WIISHLIST_ONE_PRODUCT,
                productItem,
                productButton);
    }

    public String getSelectedItemInDynamicDropdown(WebDriver driver, String parent) {
        return getSelectedItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN_PARENT, parent);
    }

    public void inputToDynamicTextbox_InCart(WebDriver driver, String valueInput, String fieldName) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_INPUT, fieldName);
        clearTextInElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_INPUT, fieldName);
        sendKeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_INPUT, valueInput, fieldName);
    }

    public boolean isFlateRateFixDisplayed(WebDriver driver, String value) {
        return isControlUndisplayed(driver, AbstractPageUI.DYNAMIC_AMOUNT_IN_CARD, value);
    }

    public void clickToDynamicContinueButtonInCheckout(WebDriver driver, String value) {
        srollToElementByJS(driver, AbstractPageUI.DYNAMIC_BUTTON_IN_CHECKOUT, value);
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_BUTTON_IN_CHECKOUT, value);
        clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON_IN_CHECKOUT, value);
    }

    public void clickToCheckoutStep(WebDriver driver, String value) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHECKOUT_STEP, value);
        clickToElement(driver, AbstractPageUI.DYNAMIC_CHECKOUT_STEP, value);
    }

    public boolean isLoadingNextStepDisplayed(WebDriver driver, String value) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHECKOUT_LOADING_IMG, value);
        return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_CHECKOUT_LOADING_IMG, value);
    }

    public void clickToMagentoImg(WebDriver driver) {
        highlightElement(driver, FE_HomePageUI.MAGENTO_IMAGE);
        clickToElement(driver, FE_HomePageUI.MAGENTO_IMAGE);
    }

    public String getProductName(WebDriver driver, String value) {
        return getTextOfElement(driver, AbstractPageUI.DYNAMIC_PRODUCT_NAME_IN_ADVANCE_SEARCH, value);
    }

    public void clickToDynamicCheckboxBE(WebDriver driver, String value) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_CHECKBOX_CUSTOMER_MANAGE, value);
        clickToElement(driver, AbstractPageUI.DYNAMIC_CHECKBOX_CUSTOMER_MANAGE, value);
    }

    public void selectDynamicDropdown_BE(WebDriver driver, String valueExpected,
                                         String parent) {
        selectItemInCustomDropdown(driver,
                AbstractPageUI.DYNAMIC_ACTION_DDROPDOWN_CUSTOMER_MANAGE_PARENT,
                AbstractPageUI.DYNAMIC_ACTION_DDROPDOWN_CUSTOMER_MANAGE_CHILD, valueExpected, parent);
    }

    public void selectItemInDynamicDropdown(WebDriver driver, String valueExpected, String parent) {
        selectItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN_PARENT,
                AbstractPageUI.DYNAMIC_DROPDOWN_CHILD,
                valueExpected, parent);
    }

    public Object getDynamicRowOfTable(WebDriver driver, String values) {
        highlightElement(driver, AbstractPageUI.DYNAMIC_COLUMN_ON_TABLE, values);
        return getTextOfElement(driver, AbstractPageUI.DYNAMIC_COLUMN_ON_TABLE, values);
    }

    public void hoverMouseToMenuItem(WebDriver driver, String dynamicValues) {
        hoverMouseToElement(driver, AbstractPageUI.DYNAMIC_LINK_BUTTON, dynamicValues);
    }

    public void clickToDynamicRowInReviewTable(WebDriver driver, String value01, String value02) {
        clickToElement(driver, AbstractPageUI.DYNAMIC_CHECKBOX_IN_REVIEW_TABLE, value01, value02);
    }

    public void clickToDynamicEditButtonInReviewTable(WebDriver driver, String detailReview){
        clickToElement(driver, AbstractPageUI.DYNAMIC_EDIT_BUTTON_IN_REVIEW_TABLE, detailReview);
    }

    public boolean sortOrNot(ArrayList<String> valueInTable) {
        System.out.println("Number of row " + valueInTable.size());
        for (int i = 0; i < valueInTable.size() - 1; i++) {
            int temp = valueInTable.get(i).compareTo(valueInTable.get(i + 1));
            if (temp > 0) {
                return true;
            }
        }
        return false;

    }

    public void columnIsSortOrNot(WebDriver driver, String colNumber, String... dynamicColNumber) {
        colNumber = String.format(colNumber, (Object[]) dynamicColNumber);
        List<WebElement> listValInCol = driver.findElements(By.xpath(colNumber));
        ArrayList<String> listValue = new ArrayList<>();
        for (WebElement value : listValInCol) {
            listValue.add(value.getText());
        }
        boolean sorted = sortOrNot(listValue);
        Assert.assertEquals(sorted, true);

    }

    public void checkSortIsWorking(WebDriver driver, String numberOfcolumn) {
        columnIsSortOrNot(driver, AbstractPageUI.INVOICE_NUMBER_COLUMN, numberOfcolumn);
    }

    public void waitElementCanClicked(WebDriver driver, String colName) {
        waitForElementClickAble(driver, AbstractPageUI.DYNAMIC_LINK_BUTTON, colName);
    }

    public void fileDownloadedOrNot(WebDriver driver, String fileDirectory) {
        jsExecuter = (JavascriptExecutor) driver;
        String fileName = (String) jsExecuter.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
        System.out.println("File vua download " + fileName);
        File folder = new File(fileDirectory);
        File[] allFiles = new File(folder.getPath()).listFiles();
        for (File file : allFiles) {
            String eachFile = file.getName();
            if (eachFile.contains(fileName)) {
                System.out.println("--Verified: File : " + fileName + " Has Been Download.");
            } else continue;
        }
    }


    public String getReviewSummary(WebDriver driver, String reviewID) {
        return getTextOfElement(driver, AbstractPageUI.DYNAMIC_REVIEW_SUMMARY, reviewID);
    }
}
