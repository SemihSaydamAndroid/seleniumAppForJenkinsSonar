package com.trendyol.page;

import com.trendyol.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import static com.trendyol.constants.constantsLoginPage.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;

/**
 * @author  Semih Saydam
 * @since 08.08.2020
 */

public class Scenario_1_PAGE extends BasePage {
    public Scenario_1_PAGE(WebDriver driver) {
        super(driver);
    }
    private static Logger log = LogManager.getLogger(Scenario_1_PAGE.class);


    public Scenario_1_PAGE click_All_Tabs(){

        click(TAB_KADIN);
        click(TAB_ERKEK);
        click(TAB_COCUK);
        click(TAB_EV_YASAM);
        click(TAB_SUPERMARKET);
        click(TAB_KOZMETIK);
        click(TAB_AYAKKABI_CANTA);
        click(TAB_SAAT_AKSESUAR);
        click(TAB_ELEKTRONIK);
        return this;
    }

    public Scenario_1_PAGE clickTab_COCUK(){

        click(TAB_COCUK);
        List<WebElement> listOfWebElement = findElements(LIST_OF_IMAGES);
        if (listOfWebElement.size()>0){
            log.info("ÇOCUK SEKMESİ İÇİN BUTIK GÖRSELLERİ YÜKLENDİ");
        }else {
            log.fatal("ÇOCUK SEKMESİ İÇİN BUTİK GÖRSELLERİ YÜKLENEMEDİ");
        }
        return this;
    }


    public Scenario_1_PAGE clickRandomly(By by){
        List<WebElement> listOfWebElement = findElements(by);

        // 0 ile LİSTE BÜYÜKLÜĞÜ arasında random sayı üret
        Random random = new Random();
        int myRandomClickElement =random.nextInt(listOfWebElement.size());
        System.out.println(myRandomClickElement);

        //listeden random bir WebElement seçip tıkla.
        listOfWebElement.get(myRandomClickElement).click();
        return this;
    }

    public Scenario_1_PAGE click_Random_Product(){

        List<WebElement> listOfWebElement = findElements(LIST_OF_PRODUCTS);
        log.info(listOfWebElement.size());

        return this;
    }



    public Scenario_1_PAGE clickRandom_Boutique(){

        List<WebElement> listOfWebElement = findElements(LIST_OF_IMAGES);
        Random random = new Random();
        int myRandomClickElement =random.nextInt(10);


        return this;
    }







    public Scenario_1_PAGE closePop(){
        click(POP);
        return this;
    }

    public Scenario_1_PAGE clickLogInButton(){
        click(LOG_IN_BUTTON);
        return this;
    }

    public Scenario_1_PAGE writeEmailAndPassword(){
        sendKeys(EMAIL,ACCOUNT_EMAIL);
        sendKeys(PASSWORD,ACCOUNT_PASSWORD);
        return this;
    }
    public Scenario_1_PAGE clickSubmitButton(){
        click(LOGIN_SUBMIT_BUTTON);
        return this;
    }




}
