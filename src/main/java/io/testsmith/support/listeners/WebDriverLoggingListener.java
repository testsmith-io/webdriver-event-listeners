package io.testsmith.support.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.logging.Logger;

public class WebDriverLoggingListener implements WebDriverListener {

    private static final java.util.logging.Logger logger = Logger.getLogger(WebDriverLoggingListener.class.getName());

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        logger.info(String.format("URL before navigating to {%s}", url));
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        logger.info(String.format("Navigated to {%s}", url));
    }

    @Override
    public void beforeClick(WebElement element) {
        logger.info(String.format("Clicking element {%s}", element));
    }

    @Override
    public void afterClick(WebElement element) {
        logger.info(String.format("Clicked element {%s}", element));
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info(String.format("Try to locate element using {%s}", locator));
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info(String.format("Located element using {%s}", locator));
    }
}
