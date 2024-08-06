package base;


import enums.BrowserType;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    private static WebDriver webDriver;
    private final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }
    @Before
    public void setUp() throws MalformedURLException {
        String browser = System.getProperty("BROWSER");
        browser = "CHROME";
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        logger.info("---Test is starting---");
        switch (browserType) {
            case CHROME:

                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName("chrome");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-translate");
                chromeOptions.addArguments("disable-notifications");
                chromeOptions.addArguments("enable-automation");
                chromeOptions.addArguments("--headless");
                chromeOptions.merge(desiredCapabilities);

                // For Jenkins-Selenium Hub ["4445:4444"] Jenkins 4444
                WebDriver webDriver = new RemoteWebDriver(URI.create("http://selenium-hub:4444/wd/hub").toURL(), chromeOptions);

                // For Local-Selenium Hub  ["4445:4444"] Local 4445 --> local için localhost veya 0.0.0.0 yazılabilir.
//                WebDriver webDriver = new RemoteWebDriver(URI.create("http://0.0.0.0:4444/wd/hub").toURL(), chromeOptions);
                webDriver.manage().window().maximize();
                setWebDriver(webDriver);
                //chromeOptions.setBrowserVersion("115");
//                setWebDriver(new ChromeDriver(chromeOptions));
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                setWebDriver(new EdgeDriver(edgeOptions));
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //options.setBrowserVersion("116");
                setWebDriver(new FirefoxDriver(firefoxOptions));
                break;
            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                //options.setBrowserVersion("16.1");
                setWebDriver(new SafariDriver(safariOptions));
                break;
        }
        logger.info(browser + " driver is running");
    }

    @After
    public void tearDown() {
        takeScreenshot(scenario.getName());
        if (webDriver != null) {
            webDriver.quit();
            logger.info("---Test finished---");
        }
    }
    public void takeScreenshot(String scenarioName) {
        try {
            File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            File screenshotsFolder = new File("screenshots");
            if (!screenshotsFolder.exists()) {
                screenshotsFolder.mkdir();
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String timestamp = LocalDateTime.now().format(formatter);
            String screenshotFileName = "screenshots/" + scenarioName + "_" + timestamp + ".png";
            FileHandler.copy(screenshotFile, new File(screenshotFileName));
            logger.info("Screenshot taken and saved as: " + screenshotFileName);
        } catch (IOException e) {
            logger.error("Failed to take screenshot: " + e.getMessage());
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
