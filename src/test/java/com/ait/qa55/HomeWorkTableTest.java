package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWorkTableTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementTableWithCssTest() {
        System.out.println("===========================================================");
        List<WebElement> elements = driver.findElements(By.cssSelector("table"));
        System.out.println("Count of Tables: " + elements.size());

        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println("Count of Rows: " + rows.size());
        System.out.println("===========================================================");
        rows.forEach(el-> System.out.println(el.getText()));
        System.out.println("===========================================================");

        WebElement tableCustomersRow2 = driver.findElement(By.cssSelector("table#customers tr:nth-child(2)"));
        WebElement tableCustomersRow2Xpath = driver.findElement(By.xpath("//table[@id='customers']//tr[2]"));
        System.out.println("Row 2 of Customers table(use css): " + tableCustomersRow2.getText());
        System.out.println("Row 2 of Customers table(use xpath): " + tableCustomersRow2Xpath.getText());

        WebElement tableNotranslateRow2 = driver.findElement(By.cssSelector("table.notranslate tr:nth-child(2)"));
        WebElement tableNotranslateRow2Xpath = driver.findElement(By.xpath("//table[contains(@class, 'notranslate')]//tr[2]"));
        System.out.println("Row 2 of Notraslate table(use css): " + tableNotranslateRow2.getText());
        System.out.println("Row 2 of Notraslate table(use xpath): " + tableNotranslateRow2Xpath.getText());

        WebElement tableCustomersRow2item2 = driver.findElement(By.cssSelector("table#customers tr:nth-child(2) td:nth-child(2)"));
        WebElement tableCustomersRow2item2Xpath = driver.findElement(By.xpath("//table[@id='customers']//tr[2]/td[2]"));
        System.out.println("Item 2 of row 2 from Customers table(use css): " + tableCustomersRow2item2.getText());
        System.out.println("Item 2 of row 2 from Customers table(use xpath): " + tableCustomersRow2item2Xpath.getText());

        WebElement tableNotranslateRow2item2 = driver.findElement(By.cssSelector("table.notranslate tr:nth-child(2) td:nth-child(2)"));
        WebElement tableNotranslateRow2item2Xpath = driver.findElement(By.xpath("//table[contains(@class, 'notranslate')]//tr[2]/td[2]"));
        System.out.println("Item 2 of row 2 from Notranslate table(use css): " + tableNotranslateRow2item2.getText());
        System.out.println("Item 2 of row 2 from Notranslate table(use xpath): " + tableNotranslateRow2item2Xpath.getText());

    }
}
