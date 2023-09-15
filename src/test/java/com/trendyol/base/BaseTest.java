package com.trendyol.base;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import  com.trendyol.constants.constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

/**
 * @author  Semih Saydam
 * @since 08.08.2020
 */

public class BaseTest {

    static WebDriver webDriver=null;


    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver", "properties/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(chromeOptions));
        getWebDriver().navigate().to(constants.WEBLINK);
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }

    public void tearDown(){
        getWebDriver().quit();
    }
}
