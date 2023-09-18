package com.trendyol.base;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import  com.trendyol.constants.constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * @author  Semih Saydam
 * @since 08.08.2020
 */

public class BaseTest {

    static WebDriver webDriver=null;


    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setBrowserName("chrome");

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.merge(desiredCapabilities);

        WebDriver webDriver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
        webDriver.get("https://www.trendyol.com/");

    }


    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }

    public void tearDown(){
        webDriver.quit();
    }
}
