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

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByTagName() {
        //find element by tag name
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find list of elements by tag name
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
        //elements.forEach(el -> System.out.println("Текст ссылки: " + el.getText()));
    }

    @Test
    public void findElementBySimpleLocators() {
        //by id
        driver.findElement(By.id("city"));
        System.out.println(driver.findElement(By.id("city")).getTagName());

        //by className
        driver.findElements(By.className("header"));
        System.out.println(driver.findElement(By.className("header")).getTagName());
        System.out.println(driver.findElement(By.className("header")).getText());

        //by linkText
        driver.findElement(By.linkText("Let the car work"));
        System.out.println(driver.findElement(By.linkText("Let the car work")));

        //by partialLinkText
        driver.findElement(By.partialLinkText("car"));
        System.out.println(driver.findElement(By.partialLinkText("car")).getTagName());
    }

    @Test
    public void findElementByCssSelector() {
        //tagName == css
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));
        System.out.println(driver.findElement(By.cssSelector("h1")).getText());

        //id -> css(#) //как делать селектор
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));
        System.out.println(driver.findElement(By.cssSelector("#city")).getTagName());

        //by className -> css(.)
        //driver.findElements(By.className("header"));
        driver.findElements(By.cssSelector(".header"));
        System.out.println(driver.findElement(By.cssSelector(".header")).getTagName());

        //[attr='value'] //обязательно в одинарных ковычках
        driver.findElement(By.cssSelector("[href='/registration?url=%2Fsearch']"));
        System.out.println(driver.findElement(By.cssSelector("[href='/registration?url=%2Fsearch']")).getText());
        //contains -> * //по частичному совпадению
        driver.findElement(By.cssSelector("[href*='/registration']"));
        System.out.println(driver.findElement(By.cssSelector("[href*='registration']")).getText());
        //start -> ^ //по началу
        driver.findElement(By.cssSelector("[href^='/reg']"));
        System.out.println(driver.findElement(By.cssSelector("[href^='/reg']")).getText());
        //end on -> $ //по окончанию
        driver.findElement(By.cssSelector("[href$='search']"));
        System.out.println(driver.findElement(By.cssSelector("[href$='search']")).getText());

        //tag + id
        driver.findElement(By.cssSelector("input#city"));
        //tag + class
        driver.findElement(By.cssSelector("div.mobile-header"));
        driver.findElement(By.cssSelector("div.search-card"));
        //tag + id + [attr='value']
        driver.findElement(By.cssSelector("input#city[type='text']"));
        //tag + class + class + class //если несколько классов в рамках одного тега
        driver.findElement(By.cssSelector("input.ng-pristine.ng-invalid.pac-target-input"));
    }

    //Xpath
    //*[@attr='value']
    @Test
    public void findElementByXpath(){
        //tag -> xpath -> //tag
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));

        //id -> xpath - //*[@id='value']
        //* это любой тег
        //driver.findElement(By.id("city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        //className -> xpath - //*[@class='value']
        //driver.findElements(By.className("header"));
        driver.findElements(By.xpath("//div[@class='header']"));

        //contains -> //*[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(text(),'Yalla')]"));
        //или проще
        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));
        //equal-> //*[text()='Text'] //полное совапдение
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        //или проще
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));

        //start-with -> //*[starts-with(@attr,'StartText')]
        driver.findElement(By.xpath("//label[starts-with(@for,'ci')]"));

        //move up
        driver.findElement(By.xpath("//a[@class='navigation-link']/.."));

        //parent
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));
        //зависисомть child будет искать всех детей
        //ancestor - находит всех предков //предок
        driver.findElement(By.xpath("//h1/ancestor::*"));//all
        driver.findElement(By.xpath("//h1/ancestor::div"));//two options
        driver.findElement(By.xpath("//h1/ancestor::div[2]"));//one option

        //following-sibling - послежующий брат/сестра
        driver.findElement(By.xpath("//h1/following-sibling::form"));
        //preceding-sibling - предшествующий брат/сестра
        driver.findElement(By.xpath("//h2/preceding-sibling::*"));

    }

}
