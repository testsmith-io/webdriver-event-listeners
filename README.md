# WebDriver Event Listeners

[![Maven Central](https://img.shields.io/maven-central/v/io.testsmith/webdriver-event-listeners.svg?maxAge=86400)](https://mvnrepository.com/artifact/io.testsmith/webdriver-event-listeners)

# How does it work?

```java
EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());
driver.register(new WebDriverLoggingListener());
driver.register(new HighlightElementsListener());
driver.register(new SavePageSourceOnExceptionListener());
driver.register(new SaveScreenshotOnExceptionListener());
```

By default files are stored in `log/screenshots` and `log/pagesources`

You can override this location by specifying it in the constructor, like this:

```java
EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());
driver.register(new SavePageSourceOnExceptionListener("target/log/pagesources"));
driver.register(new SaveScreenshotOnExceptionListener("target/log/screenshots"));
```

## Roadmap
- Chrome browser console log on failure

## Disclaimer
- For now, `beforeChangeValueOf` and `afterChangeValueOf` are not included in the log due to security reasons.
