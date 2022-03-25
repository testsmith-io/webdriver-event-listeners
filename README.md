# WebDriver Event Listeners

[![Maven Central](https://img.shields.io/maven-central/v/io.testsmith/webdriver-event-listeners.svg?maxAge=86400)](https://mvnrepository.com/artifact/io.testsmith/webdriver-event-listeners)

# How does it work?

```java
WebDriver originalDriver = new ChromeDriver();
driver = new EventFiringDecorator(
        new WebDriverLoggingListener(),
        new SavePageSourceOnExceptionListener(originalDriver),
        new WebDriverLoggingListener(),
        new HighlightElementsListener(),
        new SaveScreenshotOnExceptionListener(originalDriver),
        new WebDriverWaitListener(originalDriver)
).decorate(originalDriver);
```

By default, files are stored in `log/screenshots` and `log/pagesources`

You can override this location by specifying it in the constructor, like this:

```java
WebDriver originalDriver = new ChromeDriver();
driver = new EventFiringDecorator(new WebDriverLoggingListener(),
        new SavePageSourceOnExceptionListener(originalDriver, "target/log/pagesources"),
        new SaveScreenshotOnExceptionListener(originalDriver, "target/log/screenshots"),
).decorate(originalDriver);
```

## Roadmap
- Chrome browser console log on failure

## Disclaimer
- For now, `beforeSendKeys` and `afterSendKeys` are not included in the log due to security reasons.
