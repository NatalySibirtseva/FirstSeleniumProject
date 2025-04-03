package com.ait.qa55;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver.get("https://www.google.com"); //without history, как новый/чистый пользователь пришел
        driver.navigate().to("https://seferisrael.co.il"); //with history
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
    }


    //test
    @Test
    public void openGoogleTest() {
        System.out.println("Hello");
    }


    //after - tearDown
    //(enabled = false) - стоит чтобы не закрывался пока браузер, пока мы отладку делаем
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }


}
