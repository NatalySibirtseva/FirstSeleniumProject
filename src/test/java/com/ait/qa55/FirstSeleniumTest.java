package com.ait.qa55;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        //driver.get("https://www.google.com"); //without history, как новый/чистый пользователь пришел

        //maximize browser to window, растянуть на все окно
        driver.manage().window().maximize();

        driver.navigate().to("https://seferisrael.co.il"); //with history
        //wait for all elements on the site to load before starting test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicitlyWait - неявное ожидание

        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        driver.navigate().refresh(); //перезагрузка страницы

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
        //driver.quit(); //all tabs and brauser - закрывает все вкладки и сам браузер,если они были открыты в процессе теста
        driver.close(); // only one tab - закрывает только текущую вкладку, если она одна - закроет и браузер
    }


}
