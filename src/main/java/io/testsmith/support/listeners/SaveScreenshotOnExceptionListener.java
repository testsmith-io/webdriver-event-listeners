package io.testsmith.support.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class SaveScreenshotOnExceptionListener implements WebDriverListener {

    private final String folder;
    private final WebDriver driver;

    public SaveScreenshotOnExceptionListener(WebDriver driver, String folder) {
        this.folder = folder;
        this.driver = driver;
    }

    public SaveScreenshotOnExceptionListener(WebDriver driver) {
        this.driver = driver;
        this.folder = "log/screenshots";
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        String filename = FileUtil.generateRandomFilename(e.getTargetException().getMessage().toLowerCase(Locale.ROOT)).concat(".png");
        FileUtil.saveFile(folder, filename, screenshot(driver));
    }

    private static byte[] screenshot(WebDriver driver) {
        if (!TakesScreenshot.class.isAssignableFrom(driver.getClass())) {
            return null;
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
