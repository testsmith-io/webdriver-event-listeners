package io.testsmith.support.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class SavePageSourceOnExceptionListener implements WebDriverListener {

    private final String folder;
    private final WebDriver driver;

    public SavePageSourceOnExceptionListener(WebDriver driver, String folder) {
        this.folder = folder;
        this.driver = driver;
    }

    public SavePageSourceOnExceptionListener(WebDriver driver) {
        this.driver = driver;
        this.folder = "log/pagesources";
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        String filename = FileUtil.generateRandomFilename(e.getTargetException().getMessage().toLowerCase(Locale.ROOT)).concat(".html");
        FileUtil.saveFile(folder, filename, driver.getPageSource().getBytes());
    }
}
