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
    public void findElementByCssSelector() {
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

        //tag + id
        driver.findElement(By.cssSelector("li#topcartlink"));
        System.out.println(driver.findElement(By.cssSelector("li#topcartlink")).getText());
        driver.findElement(By.cssSelector("span#poll-voting-progress-1"));
        System.out.println(driver.findElement(By.cssSelector("span#poll-voting-progress-1")).getTagName());

        //tag + class
        driver.findElement(By.cssSelector("span.cart-label"));
        System.out.println(driver.findElement(By.cssSelector("span.cart-label")).getText());
        driver.findElement(By.cssSelector("div.title"));
        System.out.println(driver.findElement(By.cssSelector("div.title")).getText());

        //tag + id + [attr='value']
        driver.findElement(By.cssSelector("div#dialog-notifications-success[title = 'Notification']"));
        System.out.println(driver.findElement(By.cssSelector("div#dialog-notifications-success[title = 'Notification']")).getTagName());
        driver.findElement(By.cssSelector("input#small-searchterms[value = 'Search store']"));
        System.out.println(driver.findElement(By.cssSelector("input#small-searchterms[value = 'Search store']")).getTagName());
    }

    @Test
    public void findElementByXpath() {
        //tag -> xpath -> //tag
        List<WebElement> elementsImg = driver.findElements(By.xpath("//img"));
        System.out.println(elementsImg.size());
        //id -> xpath - //*[@id='value']
        driver.findElement(By.xpath("//li[@id='topcartlink']"));
        System.out.println(driver.findElement(By.xpath("//li[@id='topcartlink']")).getText());
        //className -> xpath - //*[@class='value']
        driver.findElement(By.xpath("//a[@class='ico-login']"));
        System.out.println(driver.findElement(By.xpath("//a[@class='ico-login']")).getText());

        //любой атрибут
        driver.findElement(By.xpath("//form[@action='/search']"));
        driver.findElement(By.xpath("//form[@method='get']"));
        driver.findElement(By.xpath("//form[@novalidate='novalidate']"));
        driver.findElement(By.xpath("//form[@onsubmit='return check_small_search_form()']"));

        //contains -> //*[contains(text(),'Text')] || //*[contains(.,'Text')]
        driver.findElement(By.xpath("//strong[contains(text(),'you like')]"));
        driver.findElement(By.xpath("//strong[contains(.,'you like')]"));

        //equal-> //*[text()='Text'] || //*[.='Text']
        driver.findElement(By.xpath("//strong[text() = 'Do you like nopCommerce?']"));
        driver.findElement(By.xpath("//strong[. = 'Do you like nopCommerce?']"));

        //start-with -> //*[starts-with(@attr,'StartText')]
        driver.findElement(By.xpath("//a[starts-with(@class, 'ico-lo')]"));

        //move up
        driver.findElement(By.xpath("//div[@class='header-logo']/.."));
        driver.findElement(By.xpath("//ul[@class = 'top-menu']/.."));

        //parent
        driver.findElement(By.xpath("//ul[@class = 'top-menu']/parent::*"));
        driver.findElement(By.xpath("//ul[@class = 'top-menu']/parent::div"));
        driver.findElement(By.xpath("//ul[@class = 'top-menu']/.."));
        driver.findElement(By.xpath("//div[@class='header-logo']/parent::*"));
        driver.findElement(By.xpath("//div[@class='header-logo']/parent::div"));
        driver.findElement(By.xpath("//div[@class='header-logo']/.."));

        //child
        driver.findElement(By.xpath("//div[@class='header']/child::*"));
        driver.findElement(By.xpath("//div[@class='header']/child::div[@class='search-box']"));

        //ancestor
        driver.findElement(By.xpath("//div[@class='header-logo']/ancestor::*")); //5 options
        driver.findElement(By.xpath("//div[@class='header-logo']/ancestor::div")); //3 options
        driver.findElement(By.xpath("//div[@class='header-logo']/ancestor::div[1]")); //one option

        //following-sibling
        driver.findElement(By.xpath("//div[@class='header']/following-sibling::*")); //3 options
        driver.findElement(By.xpath("//div[@class='header']/following-sibling::*")); //3 options
        driver.findElement(By.xpath("//div[@class='header']/following-sibling::div[2]")); //one option

        //preceding-sibling
        driver.findElement(By.xpath("//div[@class='header-links-wrapper']/preceding-sibling::*"));


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
