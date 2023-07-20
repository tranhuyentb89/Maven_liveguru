package com.liveguru.backend;

import commons.AbstractTest;
import commons.Contants;
import commons.PageFactoryManage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.BE_LoginPageObject;
import pageObject.BE_ManageCustomerPageObject;
import pageObject.FE_ReviewPageObject;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;

public class BACKEND_TESTCASE extends AbstractTest {

    WebDriver driver;
    String adminUser, adminPass;

    BE_LoginPageObject BE_loginPage;
    BE_ManageCustomerPageObject BE_ManageCustomerPage;
    CommonClass newCustomer;
    JavascriptExecutor js;
    FE_ReviewPageObject FE_ReviewPage;
    String fileDirectory = System.getProperty("user.dir") + "\\downloadFile";


    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browserName) {
        driver = openMultiBrowser(browserName);
        driver.get("http://live.techpanda.org/index.php/backendlogin");
        BE_loginPage = PageFactoryManage.getBE_LoginPage(driver);
        BE_loginPage.inputToDynamicTextbox(driver, "user01", "username");
        BE_loginPage.inputToDynamicTextbox(driver, "guru99com", "login");
        BE_loginPage.clickToLoginButton();
        BE_ManageCustomerPage = PageFactoryManage.getManageCustomerPage(driver);
        if (BE_ManageCustomerPage.isIncomeMessageDisplayed()) {
            BE_ManageCustomerPage.clickToCloseIncomMessage();
        }
    }

//    @Test
    public void TC_01_DeleteAccount() {
        log.info("Buoc 1: Verrify Email dang ky ton tai trong bang customer");
        verifyEquals(BE_ManageCustomerPage.getDynamicRowOfTable(driver, CommonClass.email),
                CommonClass.email);

        log.info("Buoc 2: Click on checkbox customer vua tao");
        BE_ManageCustomerPage.clickToDynamicCheckboxBE(driver, CommonClass.email);
        System.out.println(CommonClass.email);
        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Delete",
                "customerGrid_massaction-select");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Submit");
        BE_ManageCustomerPage.clickOKToAcceptDelete();
        BE_ManageCustomerPage.inputToDynamicTextbox(driver, CommonClass.email,
                "customerGrid_filter_email");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Search");
        verifyTrue(BE_ManageCustomerPage.isNoRecordFoundMsgDisplayed());
        BE_ManageCustomerPage.clickToDynamicMenu_ProductName(driver, "Log Out");

    }

//    @Test
    public void TC_02_DeleteAccount_DeleteReview() {
        driver.get(Contants.FRONTEND_URL);
        newCustomer = new CommonClass(driver);
        newCustomer.CreateNewCustomer1();
        newCustomer.AddReview();
        driver.get(Contants.BACKEND_URL);
        BE_loginPage = PageFactoryManage.getBE_LoginPage(driver);
        BE_loginPage.inputToDynamicTextbox(driver, "user01", "username");
        BE_loginPage.inputToDynamicTextbox(driver, "guru99com", "login");
        BE_loginPage.clickToLoginButton();
        BE_ManageCustomerPage = PageFactoryManage.getManageCustomerPage(driver);
        BE_ManageCustomerPage.clickToCloseIncomMessage();
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Catalog");
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Reviews and Ratings");
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Customer Reviews");
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "All Reviews");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "All Reviews");
        verifyTrue(BE_ManageCustomerPage.isReviewColumnDisplayed(CommonClass.summaryReview));
        verifyTrue(BE_ManageCustomerPage.isReviewColumnDisplayed(CommonClass.detailReview));
        verifyTrue(BE_ManageCustomerPage.isReviewColumnDisplayed(CommonClass.nicknameReview));
        BE_ManageCustomerPage.clickToDynamicRowInReviewTable(driver, CommonClass.summaryReview,
                CommonClass.detailReview);
        String ReviewID = BE_ManageCustomerPage.getReviewIDSelected("value", CommonClass.summaryReview,
                CommonClass.detailReview);
        System.out.println("ReviewID: " + ReviewID);
        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Update Status",
                "reviwGrid_massaction-select");

        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Approved", "status");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Submit");
        verifyTrue(BE_ManageCustomerPage.isApprovedStatusDisplayed(CommonClass.summaryReview,
                CommonClass.detailReview));
        BE_ManageCustomerPage.clickToDynamicRowInReviewTable(driver, CommonClass.summaryReview,
                CommonClass.detailReview);
        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Delete",
                "reviwGrid_massaction-select");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Submit");
        BE_ManageCustomerPage.clickOKToAcceptDelete();
        BE_ManageCustomerPage.clickToDynamicMenu_ProductName(driver, "Log Out");
    }

//    @Test
    public void TC_03_InvoiceCanBePrint() throws InterruptedException, MalformedURLException {
//        driver.get(Contants.BACKEND_URL);
//		BE_loginPage = PageFactoryManage.getBE_LoginPage(driver);
//		BE_loginPage.inputToDynamicTextbox(driver, "user01", "username");
//		BE_loginPage.inputToDynamicTextbox(driver, "guru99com", "login");
//		BE_loginPage.clickToLoginButton();
//		BE_ManageCustomerPage = PageFactoryManage.getManageCustomerPage(driver);
//		BE_ManageCustomerPage.clickToCloseIncomMessage();
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Sales");
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Orders");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Orders");
        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Canceled", "sales_order_grid_filter_status");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Search");
        Thread.sleep(1000);
        BE_ManageCustomerPage.selectFirstItemInTable();
        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Print Invoices", "sales_order_grid_massaction-select");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Submit");
        verifyEquals(BE_ManageCustomerPage.getTextOfErrorMesg(), "There are no printable documents related to selected orders.");

        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Complete", "sales_order_grid_filter_status");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Search");
        Thread.sleep(1000);
        BE_ManageCustomerPage.selectFirstItemInTable();
        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Print Invoices", "sales_order_grid_massaction-select");

        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Submit");
        BE_ManageCustomerPage.clickToDynamicMenu_ProductName(driver, "Log Out");
        driver.get("chrome://downloads/");
        BE_ManageCustomerPage.fileDownloadedOrNot(driver, fileDirectory);
    }

    @Test
    public void TC_04_ProductReviewMerchanism(){
        driver.get(Contants.REVIEW_PRODUCT_URL);
//        newCustomer = new CommonClass(driver);
//        newCustomer.AddReview();
        FE_ReviewPage = PageFactoryManage.getReviewPage(driver);
        FE_ReviewPage.clearTextInTextBox(driver, "summary_field");
        FE_ReviewPage.clearTextInTextBox(driver, "nickname_field");
        FE_ReviewPage.clearTextInAreaBox(driver, "review_field");
        FE_ReviewPage.clickToDynamicLinkButton(driver, "Submit Review");
        FE_ReviewPage.clickToDynamicCheckbox(driver, "Quality 1_5");
        FE_ReviewPage.inputToDynamicTextbox(driver, CommonClass.summaryReview, "summary_field");
        FE_ReviewPage.inputToDynamicTextbox(driver, CommonClass.nicknameReview, "nickname_field");
        FE_ReviewPage.inputToDynamicTextArea(driver, CommonClass.detailReview, "review_field");
        FE_ReviewPage.clickToDynamicLinkButton(driver, "Submit Review");

        driver.get(Contants.BACKEND_URL);
        BE_ManageCustomerPage = PageFactoryManage.getManageCustomerPage(driver);
//        BE_loginPage = PageFactoryManage.getBE_LoginPage(driver);
//        BE_loginPage.inputToDynamicTextbox(driver, "user01", "username");
//        BE_loginPage.inputToDynamicTextbox(driver, "guru99com", "login");
//        BE_loginPage.clickToLoginButton();
//        BE_ManageCustomerPage = PageFactoryManage.getManageCustomerPage(driver);
//        if (BE_ManageCustomerPage.isIncomeMessageDisplayed()) {
//            BE_ManageCustomerPage.clickToCloseIncomMessage();
//        }
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Catalog");
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Reviews and Ratings");
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Customer Reviews");
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Pending Reviews");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Pending Reviews");
        verifyTrue(BE_ManageCustomerPage.isReviewColumnDisplayed(CommonClass.summaryReview));
        verifyTrue(BE_ManageCustomerPage.isReviewColumnDisplayed(CommonClass.detailReview));
        verifyTrue(BE_ManageCustomerPage.isReviewColumnDisplayed(CommonClass.nicknameReview));
        String ReviewID = BE_ManageCustomerPage.getReviewIDSelected("value", CommonClass.summaryReview, CommonClass.detailReview);
        System.out.println("Review ID is : " + ReviewID);
        BE_ManageCustomerPage.clickToDynamicEditButtonInReviewTable(driver, CommonClass.detailReview);
        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Approved", "status_id");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Save Review");

        driver.get(Contants.REVIEW_PRODUCT_URL);
        FE_ReviewPage = PageFactoryManage.getReviewPage(driver);
        String reviewSummary = FE_ReviewPage.getReviewSummary(driver, ReviewID);
        System.out.println("summary 1 : " + reviewSummary );
        System.out.println("Summary 2 : " + CommonClass.summaryReview);
        verifyEquals(reviewSummary, CommonClass.summaryReview);
    }

//    @Test
    public void TC_06_VerifySortIsWorkingCorrectly() throws InterruptedException {
		driver.get(Contants.BACKEND_URL);
//		BE_loginPage = PageFactoryManage.getBE_LoginPage(driver);
//		BE_loginPage.inputToDynamicTextbox(driver, "user01", "username");
//		BE_loginPage.inputToDynamicTextbox(driver, "guru99com", "login");
//		BE_loginPage.clickToLoginButton();
		BE_ManageCustomerPage = PageFactoryManage.getManageCustomerPage(driver);
		BE_ManageCustomerPage.clickToCloseIncomMessage();
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Sales");
        BE_ManageCustomerPage.hoverMouseToMenuItem(driver, "Invoices");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Invoices");

        Thread.sleep(1000);
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Invoice #");
        BE_ManageCustomerPage.checkSortIsWorking(driver, "2");

//		BE_ManageCustomerPage.waitElementCanClicked(driver, "Invoice Date");
        Thread.sleep(1000);
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Invoice Date");
        BE_ManageCustomerPage.checkSortIsWorking(driver, "3");

//		BE_ManageCustomerPage.waitElementCanClicked(driver, "Order #");
        Thread.sleep(1000);
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Order #");
        BE_ManageCustomerPage.checkSortIsWorking(driver, "4");

//		BE_ManageCustomerPage.waitElementCanClicked(driver, "Order Date");
        Thread.sleep(1000);
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Order Date");
        BE_ManageCustomerPage.checkSortIsWorking(driver, "5");
        Thread.sleep(3000);

    }

    @Test
    public void TC_07_SearchFunctionWorking() throws InterruptedException {
        driver.get(Contants.BACKEND_URL);
        BE_ManageCustomerPage = PageFactoryManage.getManageCustomerPage(driver);
        String valueSearch = CommonClass.firstName + " " + CommonClass.lastName + " " + CommonClass.middleName;
        BE_ManageCustomerPage.inputToDynamicTextbox(driver, valueSearch, "customerGrid_filter_name");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Search");
        Thread.sleep(3000);
        BE_ManageCustomerPage.checkSearchTableByColumn(driver,3 ,valueSearch,"customerGrid_table");
        BE_ManageCustomerPage.clearTextInTexbox_Backend(driver, "customerGrid_filter_name");
        BE_ManageCustomerPage.inputToDynamicTextbox(driver, CommonClass.email, "customerGrid_filter_email");
        BE_ManageCustomerPage.clickToDynamicLinkButtonJS(driver, "Search");
        Thread.sleep(3000);
        BE_ManageCustomerPage.checkSearchTableByColumn(driver,4, CommonClass.email, "customerGrid_table");

        BE_ManageCustomerPage.clearTextInTexbox_Backend(driver, "customerGrid_filter_email");
        BE_ManageCustomerPage.inputToDynamicTextbox(driver, CommonClass.randomNumber() +"", "customerGrid_filter_Telephone");
        BE_ManageCustomerPage.clickToDynamicLinkButtonJS(driver, "Search");
        Thread.sleep(3000);
        BE_ManageCustomerPage.checkSearchTableByColumn(driver,6, CommonClass.randomNumber() +"", "customerGrid_table");


        BE_ManageCustomerPage.clearTextInTexbox_Backend(driver, "customerGrid_filter_Telephone");
        BE_ManageCustomerPage.inputToDynamicTextbox(driver, CommonClass.ZipToSearch, "customerGrid_filter_billing_postcode");
        BE_ManageCustomerPage.clickToDynamicLinkButtonJS(driver, "Search");
        Thread.sleep(3000);
        BE_ManageCustomerPage.checkSearchTableByColumn(driver,6, CommonClass.ZipToSearch, "customerGrid_table");

    }

    //	public void checkSearchTableByColumn(int column, String value) {
//
//		List<WebElement> row = driver.findElements(By.xpath("//table[@id='reviwGrid_table']//tbody//tr"));
//        int rowTotal = row.size();
//
//        System.out.println("Số dòng tìm thấy: " + rowTotal);
//
//        for (int i = 1; i <= rowTotal; i++) 
//        {
//            WebElement elementCheck = driver.findElement(By.xpath("//table[@id='reviwGrid_table']//tbody//tr["+ i +"]//td["+ column +"]"));
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);
//            System.out.print(value + " - ");
//            System.out.println(elementCheck.getText());
//            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
//        }
//
//    }​
    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(999999);
    }

    @AfterClass
    public void afterTest() {
        closeBrowserDriver();
    }

}
