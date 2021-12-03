package io.testsmith.support.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class WebDriverWaitListener implements WebDriverListener {

    private static final Logger logger = Logger.getLogger(WebDriverWaitListener.class.getName());
    private static final int TIMEOUT_IN_SECONDS = 30;
    private final WebDriverWait wait;

    public WebDriverWaitListener(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
    }

    public void beforeClick(WebElement element) {
        long startTime = System.currentTimeMillis();
        logger.info("beforeClickOn:: start");
        wait.until(ExpectedConditions.elementToBeClickable(element));
        long endTime = System.currentTimeMillis();
        logger.info("beforeClickOn:: end, took " + (endTime - startTime) + " milliseconds");
    }

    public void afterClick(WebElement element) {
        long startTime = System.currentTimeMillis();
        logger.info("beforeGetText:: start");
        wait.until(ExpectedConditions.visibilityOf(element));
        long endTime = System.currentTimeMillis();
        logger.info("beforeGetText:: end, took " + (endTime - startTime) + " milliseconds");
    }

}
