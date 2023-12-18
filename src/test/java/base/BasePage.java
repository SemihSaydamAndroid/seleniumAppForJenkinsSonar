package base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver webDriver = base.BaseTest.getWebDriver();
    WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    public void navigateUrl(String url){
        webDriver.get(url);
    }
    public WebElement findElement(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElement(by);
    }
    public void click(By by){
        scrollUntilVisible(by);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(findElement(by)));
        findElement(by).click();
    }

    public void sendKeys(By by, String text){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        findElement(by).sendKeys(text);
    }
    public void containsPageUrl(String containsUrl){
        webDriverWait.until(ExpectedConditions.urlContains(containsUrl));
        Assert.assertTrue("Url does not contain "+ containsUrl,webDriver.getCurrentUrl().contains(containsUrl));
    }

    public void checkElementDisplayed(By by){
        Assert.assertTrue(findElement(by).isDisplayed());
    }

    public void checkPageTitle(String expectedTitle){
        webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(expectedTitle + " is not equal the current page title",expectedTitle, webDriver.getTitle());
    }
    public void checkElementText(By by, String elementText){
        webDriverWait.until(ExpectedConditions.textToBe(by,elementText));
        Assert.assertEquals(elementText + " is not equal the element text",elementText, findElement(by).getText());
    }
    public void checkElementTextUpperCase(By by, String elementText){
        Assert.assertEquals(elementText + " is not equal the element text",elementText.toUpperCase(), findElement(by).getText().toUpperCase());
    }
    public void scrollUntilVisible(By by){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript ("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", findElement(by));
    }

}
