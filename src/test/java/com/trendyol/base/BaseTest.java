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
import java.net.URI;
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
        options.addArguments("--enable-gpu");
        options.merge(desiredCapabilities);

        // For Jenkins-Selenium Hub ["4445:4444"] Jenkins 4444
         WebDriver webDriver = new RemoteWebDriver(URI.create("http://172.18.0.2:4444/wd/hub").toURL(), options);

        // For Local-Selenium Hub  ["4445:4444"] Local 4445 --> local için localhost veya 0.0.0.0 yazılabilir. 
//        WebDriver webDriver = new RemoteWebDriver(URI.create("http://0.0.0.0:4445/wd/hub").toURL(), options);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        setWebDriver(webDriver);
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
