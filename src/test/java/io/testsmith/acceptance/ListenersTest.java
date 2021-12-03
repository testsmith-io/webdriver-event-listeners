package io.testsmith.acceptance;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.testsmith.support.listeners.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListenersTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver originalDriver = new ChromeDriver();
        driver = new EventFiringDecorator(
                new WebDriverLoggingListener(),
                new SavePageSourceOnExceptionListener(originalDriver, "target/log/pagesources"),
                new SaveScreenshotOnExceptionListener(originalDriver, "target/log/screenshots"),
                new WebDriverLoggingListener(),
                new HighlightElementsListener(),
                new WebDriverWaitListener(originalDriver)
        ).decorate(originalDriver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test(expectedExceptions = {org.openqa.selenium.NoSuchElementException.class})
    public void useListeners() {
        driver.get("http://example.com/");
        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText());

        driver.findElement(By.tagName("h")); // This should fail
    }
}
