package constants;

import org.openqa.selenium.By;

public class HomePageConstants {
    public static final By MY_ACCOUNT = By.cssSelector("a[title='Hesabım']");
    public static final String HOME_PAGE_TITLE = "n11 - 10 Üzerinden 11'lik Alışveriş Deneyimi";
    public static final By SEARCH_FIELD = By.id("searchData");
    public static final By SEARCH_ICON = By.cssSelector("a[class='searchBtn']");
    public static final String HOME_PAGE_URL = "https://www.n11.com/";

    public static final By HOME_PAGE_URL_TEST =By.xpath("//*[@automation='submitButton']");
}
