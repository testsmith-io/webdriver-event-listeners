# WebDriver Event Listeners

[![Maven Central](https://img.shields.io/maven-central/v/io.testsmith/webdriver-event-listeners.svg?maxAge=86400)](https://mvnrepository.com/artifact/io.testsmith/webdriver-event-listeners)

# How does it work?

```java
EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());
driver.register(new HighlightElements());
```

## Roadmap

- WebDriver logger
- Screenshot on failure logger
- Chrome browser console log on failure
