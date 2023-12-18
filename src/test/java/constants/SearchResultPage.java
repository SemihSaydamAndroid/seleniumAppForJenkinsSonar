package constants;

import org.openqa.selenium.By;

public class SearchResultPage {
    public static final By SEARCHED_RESULT_TEXT = By.cssSelector("div[class='resultText ']>h1");
    public static final By SEARCH_RESULT_NOT_FOUND = By.id("searchResultNotFound");
    public static final By SEARCHED_BREADCRUMB_TEXT = By.cssSelector("div[id='breadCrumb']>ul>li>a>span");

}
