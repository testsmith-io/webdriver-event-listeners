package io.testsmith.support.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class SaveScreenshotOnExceptionListener extends AbstractWebDriverEventListener {

    private final String folder;

    public SaveScreenshotOnExceptionListener(String folder) {
        this.folder = folder;
    }

    public SaveScreenshotOnExceptionListener() {
        this.folder = "log/screenshots";
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        String filename = FileUtil.generateRandomFilename(throwable.getMessage()).concat(".png");
        FileUtil.saveFile(folder, filename, screenshot(driver));
    }

    private static byte[] screenshot(WebDriver driver) {
        if (!TakesScreenshot.class.isAssignableFrom(driver.getClass())) {
            return null;
        }
        return TakesScreenshot.class.cast(driver).getScreenshotAs(OutputType.BYTES);
    }
}
