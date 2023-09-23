package com.trendyol.test;

import com.trendyol.base.BaseTest;
import com.trendyol.page.Scenario_1_PAGE;

import org.junit.*;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static com.trendyol.constants.constantsLoginPage.*;

/**
 * @author  Semih Saydam
 * @since 08.08.2020
 */

public class Scenario1PAGETest extends BaseTest {
    Scenario_1_PAGE scenario1PAGE;

    private static Logger log = LogManager.getLogger(Scenario1PAGETest.class);
    @BeforeClass
    public static void beforeClass() throws Exception {
        log.info("**************** Test started ****************");
    }

    @Before
    public void before() {
        scenario1PAGE = new Scenario_1_PAGE(getWebDriver());
       log.info("**************** Driver activated ***************");
  
    }


    @Test
    public void testLogin() throws InterruptedException {
       log.info("**************** Trendyol test Started ***************");
       log.info("30 SANİYE BEKLENİYOR");
       Thread.sleep(6000);
       getWebDriver().findElement(By.className("modal-close")).click();
       WebElement element = getWebDriver().findElement(By.cssSelector("input[data-testid='suggestion']"));
       element.sendKeys("Bilgisayar");
       element.sendKeys(Keys.ENTER);

       Thread.sleep(1000);
       log.info("30 SANİYE BİTTİ");

    }


    @After
    public void after() throws InterruptedException {
        getWebDriver().quit();
        log.info("**************** Test Finished ****************");
    }
}
