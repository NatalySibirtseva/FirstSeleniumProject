package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class SecondSeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
    }

    @Test
    public void OpenSiteTest() {
        System.out.println("Site is opened");
    }

    @Test
    public void findElementByTagName() {
        List<WebElement> elements = driver.findElements(By.tagName("img"));
        System.out.println("Count img: " + elements.size());

        List<WebElement> elements1 = driver.findElements(By.tagName("h2"));
        System.out.println("All list of h2: ");
        elements1.forEach(el -> System.out.println(el.getText()));

        List<WebElement> elements2 = driver.findElements(By.tagName("form"));
        System.out.println("Count of form: " + elements2.size());

        WebElement element = driver.findElement(By.tagName("li"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("strong"));
        System.out.println(element1.getText());

    }

    @Test
    public void findElementById() {
        driver.findElement(By.id("newsletter-subscribe-block"));
        System.out.println(driver.findElement(By.id("newsletter-subscribe-block")).getTagName());
        System.out.println(driver.findElement(By.id("newsletter-subscribe-block")).getText());

        driver.findElement(By.id("topcartlink"));
        System.out.println(driver.findElement(By.id("topcartlink")).getTagName());
        System.out.println(driver.findElement(By.id("topcartlink")).getText());

        driver.findElement(By.id("newsletter-subscribe-block"));
        System.out.println(driver.findElement(By.id("newsletter-subscribe-block")).getTagName());
        System.out.println(driver.findElement(By.id("newsletter-subscribe-block")).getText());

        driver.findElement(By.id("subscribe-loading-progress"));
        System.out.println(driver.findElement(By.id("subscribe-loading-progress")).getTagName());

    }

    @Test
    public void findElementByClassName() {
        driver.findElement(By.className("ico-register"));
        System.out.println(driver.findElement(By.className("ico-register")).getTagName());
        driver.findElement(By.className("ico-login"));
        System.out.println(driver.findElement(By.className("ico-login")).getTagName());
        driver.findElement(By.className("ico-cart"));
        System.out.println(driver.findElement(By.className("ico-cart")).getTagName());
        driver.findElement(By.className("cart-label"));
        System.out.println(driver.findElement(By.className("cart-label")).getTagName());
        driver.findElement(By.className("cart-qty"));
        System.out.println(driver.findElement(By.className("cart-qty")).getTagName());
    }

    @Test
    public void findElementBySimpleLocators() {
        //by linkText
        driver.findElement(By.linkText("Tricentis"));
        //by partialLinkText
        driver.findElement(By.partialLinkText("all"));
    }

    @Test
    public void findElementByCssSelector(){
        //tagName == css
        driver.findElement(By.cssSelector("li"));
        System.out.println(driver.findElement(By.cssSelector("li")).getText());

        List<WebElement> elements = driver.findElements(By.cssSelector("form"));
        System.out.println("Count of form: " + elements.size());

        //id == css(#)
        driver.findElement(By.cssSelector("#newsletter-subscribe-block"));
        System.out.println(driver.findElement(By.cssSelector("#newsletter-subscribe-block")).getText());

        driver.findElement(By.cssSelector("#topcartlink"));
        System.out.println(driver.findElement(By.cssSelector("#topcartlink")).getText());

        //className -> css(.)
        driver.findElement(By.cssSelector(".ico-register"));
        System.out.println(driver.findElement(By.cssSelector(".ico-register")).getTagName());

        driver.findElement(By.cssSelector(".ico-login"));
        System.out.println(driver.findElement(By.cssSelector(".ico-login")).getTagName());

        //[attr='value']
        driver.findElement(By.cssSelector("[alt='Tricentis Demo Web Shop']"));
        System.out.println(driver.findElement(By.cssSelector("[alt='Tricentis Demo Web Shop']")).getTagName());

        driver.findElement(By.cssSelector("[type='text/javascript']"));
        System.out.println(driver.findElement(By.cssSelector("[type='text/javascript']")).getTagName());

        //contains -> *
        driver.findElement(By.cssSelector("[type*='xt/jav']"));
        System.out.println(driver.findElement(By.cssSelector("[type*='xt/jav']")).getTagName());

        //start -> ^
        driver.findElement(By.cssSelector("[type^='text/j']"));
        System.out.println(driver.findElement(By.cssSelector("[type^='text/j']")).getTagName());

        //end on -> $
        driver.findElement(By.cssSelector("[type$='script']"));
        System.out.println(driver.findElement(By.cssSelector("[type$='script']")).getTagName());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
