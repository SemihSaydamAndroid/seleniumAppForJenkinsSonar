package com.trendyol.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.Random;

import static com.trendyol.constants.constantsLoginPage.LIST_OF_IMAGES;

/**
 * @author  Semih Saydam
 * @since 08.08.2020
 */
public class BasePage {
    WebDriver driver = null;
    WebDriverWait wait = null;

    public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,60);
    }

    /**
     * Element var olana kadar bekler,
     * Element'i By type locator ile bulur.
     * @param by : Elementin By type locator'ını parametre olarak input alır.
     */
    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    /**
     * Elementler var olana kadar bekler,
     * Elementleri bulur.
     * @param by : Elementin By type locator'ını parametre olarak input alır.
     */
    public List<WebElement> findElements(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return  driver.findElements(by);
    }

    /**
     * Element'e verilen text'i yazar.
     * @param by : Elementin By type locator'ını parametre olarak input alır.
     */
    public void sendKeys(By by,String text){
        findElement(by).sendKeys(text);
    }

    /**
     * Elementin tıklanabilir olmasını bekler ve click işlemini gerçekleştirir.
     * @param by : Elementin By type locator'ını parametre olarak input alır.
     */
    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();

    }

    /**
     * Element var olana kadar bekler,
     * Bulunan elementin text bilgisini alır.
     * @param by : Elementin By type locator'ını parametre olarak input alır.
     */
    public String getText(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public void navigateToUrl(String url){
        driver.navigate().to(url);
    }

    /**
     * Element'in üstüne mouse ile gider.
     * @param by : Elementin By type locator'ını parametre olarak input alır.
     */
    public void hoverElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }


}
