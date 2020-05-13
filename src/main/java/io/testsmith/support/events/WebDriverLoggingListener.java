package io.testsmith.support.events;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverLoggingListener extends AbstractWebDriverEventListener {

    private static Logger logger = LogManager.getLogger(WebDriverLoggingListener.class);

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        logger.info("URL before navigating to {}", driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info("Navigated to {}", url);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Clicking element {}", element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("Clicked element {}", element);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Try to locate element using {}", by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Located element using {}", by);
    }
}
