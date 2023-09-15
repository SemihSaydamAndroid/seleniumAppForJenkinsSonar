package com.trendyol.constants;

import org.openqa.selenium.By;

/**
 * @author  Semih Saydam
 * @since 08.08.2020
 */

public class constantsLoginPage {

    //Buttons and TextAreas
    public static final By POP = By.className("fancybox-item");
    public static final By LOG_IN_BUTTON = By.id("accountBtn");
    public static final By EMAIL = By.id("email");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN_SUBMIT_BUTTON = By.id("loginSubmit");
    public static final By ADD_TO_BASKET_BUTTON = By.className("add-to-bs-tx");

    //Account-Information
    //If u want to log-in with another user please change them
    public static final String ACCOUNT_EMAIL = "testForTrendyol@gmail.com";
    public static final String ACCOUNT_PASSWORD = "123qweasd";

    //TABS
    public static final By TAB_KADIN = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(1) > a");
    public static final By TAB_ERKEK = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(2) > a");
    public static final By TAB_COCUK = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(3) > a");
    public static final By TAB_EV_YASAM = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(4) > a");
    public static final By TAB_SUPERMARKET = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(5) > a");
    public static final By TAB_KOZMETIK = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(6) > a");
    public static final By TAB_AYAKKABI_CANTA = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(7) > a");
    public static final By TAB_SAAT_AKSESUAR = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(8) > a");
    public static final By TAB_ELEKTRONIK = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(9) > a");

    //BoutiqueList
    public static final By LIST_OF_IMAGES = By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div[2]/div[1]/div[1]/article");
    //productList
    public static final By LIST_OF_PRODUCTS = By.cssSelector("#boutique-detail-app > div > div:nth-child(2) > div > div");


}

