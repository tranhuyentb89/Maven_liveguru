package com.liveguru.backend;

import commons.AbstractTest;
import commons.PageFactoryManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.BE_LoginPageObject;
import pageObject.BE_ManageCustomerPageObject;

import java.util.Random;

public class BE_CustomerManage extends AbstractTest {
    BE_LoginPageObject BE_loginPage;
    BE_ManageCustomerPageObject BE_ManageCustomerPage;
    WebDriver driver;
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
    @Test
    public void TC_01_CustomerShownInCustomerManage() {
        log.info("Buoc 1: Verrify Email dang ky ton tai trong bang customer");
        verifyEquals(BE_ManageCustomerPage.getDynamicRowOfTable(driver, CommonClass.email),
                CommonClass.email);

        log.info("Buoc 2: Click on checkbox customer vua tao");
        BE_ManageCustomerPage.clickToDynamicCheckboxBE(driver, CommonClass.email);
        System.out.println(CommonClass.email);
        String time = BE_ManageCustomerPage.getTextOfColumnInTable(driver, "customerGrid_table", CommonClass.email, "6");
        System.out.println("Time is : " + time);
        log.info("Verify time are corrected");
        verifyEquals(time, CommonClass.timeCreatedCustomer.toString());
        log.info("Buoc 2: Click on checkbox customer vua tao");
        BE_ManageCustomerPage.clickToDynamicCheckboxBE(driver, CommonClass.email);
        System.out.println(CommonClass.email);
        BE_ManageCustomerPage.selectDynamicDropdown_BE(driver, "Delete",
                "customerGrid_massaction-select");
        BE_ManageCustomerPage.clickToDynamicLinkButton(driver, "Submit");
        BE_ManageCustomerPage.clickOKToAcceptDelete();

    }
    @Test
    public void TC_02_CountCustomerNumber(){
        //phan nay để lấy ra đoạn "Total 23484 records found"
            String numberOfItems = BE_ManageCustomerPage.textTotalRecords(driver);
            String numberHidden = BE_ManageCustomerPage.totalItemsOfTable(driver, "class", "customerGrid-total-count");
            verifyEquals("Total "+ numberHidden +" records found", numberOfItems);
            System.out.println("SO record la : " + numberHidden);
    }

    @Test
    public void TC_03_SelectedAllItem() throws InterruptedException {
        log.info("TC_03_Step 01: click to select all");
        BE_ManageCustomerPage.clickToDynamicMenu_ProductName(driver, "Select All");
        String numberOfItemSelect = BE_ManageCustomerPage.getNumberOfItemSelected(driver).toString();
        String numberOfItems = BE_ManageCustomerPage.textTotalRecords(driver);
        System.out.println("numberOfItemSelect: "+ numberOfItemSelect );
        System.out.println("numberOfItems: "+ numberOfItems);

        log.info("TC_03_Step 02: Verify number selected is corrected");
        verifyEquals(CommonClass.spilitString(numberOfItems, 1), numberOfItemSelect);

        log.info("Step 03: Click to unSelected button");
        BE_ManageCustomerPage.clickToDynamicMenu_ProductName(driver, "Unselect All");

        log.info("Step 04: Select number of values is 200");
        BE_ManageCustomerPage.selectDropdownToShowNumberOfRowInTable(driver, "200");
        Thread.sleep(3000);
        System.out.println(BE_ManageCustomerPage.getNumberRowOfTable(driver,"customerGrid_table"));

        log.info("Verify number row of page is equal 200");
        verifyEquals(BE_ManageCustomerPage.getNumberRowOfTable(driver,"customerGrid_table"), "200");
    }

    @Test
    public void TC_04_VerifyWhenSearchWithID(){

    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(999999);
    }

    @AfterClass
    public void afterTest() {
        closeBrowserDriver();
    }

}
