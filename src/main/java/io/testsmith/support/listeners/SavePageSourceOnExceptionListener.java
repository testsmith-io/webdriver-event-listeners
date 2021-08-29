package io.testsmith.support.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class SavePageSourceOnExceptionListener extends AbstractWebDriverEventListener {

    private final String folder;

    public SavePageSourceOnExceptionListener(String folder) {
        this.folder = folder;
    }

    public SavePageSourceOnExceptionListener() {
        this.folder = "log/pagesources";
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        String filename = FileUtil.generateRandomFilename(throwable.getMessage()).concat(".html");
        FileUtil.saveFile(folder, filename, driver.getPageSource().getBytes());
    }
}
