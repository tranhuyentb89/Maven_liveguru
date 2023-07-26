package com.liveguru.backend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class javaClassForTest {
    public  static WebDriver driver;

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");
        driver.manage().window().maximize();
        compareDispalyedRowCountToActualRowCount();
    }
    public static void compareDispalyedRowCountToActualRowCount() throws Exception {
        //Lay element cua tat ca cac dong cua cot dau tien
        List<WebElement> firstCol = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
        System.out.println("So dong cua Page 01 la : " + firstCol.size());

        List<String> colName = new ArrayList<>();
        //Adding column1 element to arrayList
        for (WebElement nameEl : firstCol){
            colName.add(nameEl.getText());
            System.out.println("Cac dong cua cot 1: "+ nameEl.getText());
        }
        //locating next button
        String nextButton = driver.findElement(By.xpath("//a[contains(@class,'paginate_button next')]")).getAttribute("class");
        System.out.println(nextButton+ " - is next button");
        //duyet qua tat ca cac page cua table cho den nextButton cuoi cung va add name to list
        while (!nextButton.contains("disable")){
            driver.findElement(By.xpath("//a[contains(@class,'paginate_button next')]")).click();
            Thread.sleep(2000);
            firstCol = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
            for (WebElement nameEl: firstCol){
                colName.add(nameEl.getText());
            }
            nextButton = driver.findElement(By.xpath("//a[contains(@class,'paginate_button next')]")).getAttribute("class");
            System.out.println("Nexxt button disable or not --" + nextButton);
        }

        for (String name: colName){
            System.out.println("Day la : "+ name);
        }

        //counting size of the list
        int actualCount = colName.size();
        System.out.println("total number of names : "+ actualCount);

        String displayedCountString = driver.findElement(By.id("example_info")).getText().split(" ")[5];
        int displayedCount = Integer.parseInt(displayedCountString);
        System.out.println("Total Number of Displayed Names count:" + displayedCount);

        Thread.sleep(1000);
        // Actual count calculated Vs Dispalyed Count
        if (actualCount == displayedCount) {
            System.out.println("Actual row count = Displayed row Count");
        } else {
            System.out.println("Actual row count !=  Displayed row Count");
            throw new Exception("Actual row count !=  Displayed row Count");
        }

    }
}
