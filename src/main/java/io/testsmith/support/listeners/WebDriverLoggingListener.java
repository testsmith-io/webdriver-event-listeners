package io.testsmith.support.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.logging.Logger;

public class WebDriverLoggingListener extends AbstractWebDriverEventListener {

    private static final java.util.logging.Logger logger = Logger.getLogger(WebDriverLoggingListener.class.getName());

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        logger.info(String.format("URL before navigating to {%s}", driver.getCurrentUrl()));
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info(String.format("Navigated to {%s}", url));
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info(String.format("Clicking element {%s}", element));
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info(String.format("Clicked element {%s}", element));
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info(String.format("Try to locate element using {%s}", by));
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info(String.format("Located element using {%s}", by));
    }
}
