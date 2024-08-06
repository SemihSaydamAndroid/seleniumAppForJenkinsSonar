package parallel;

import base.BasePage;
import helper.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.HomePageConstants.*;
import static constants.SearchResultPage.*;

public class SearchSteps extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(SearchSteps.class);

    ConfigReader configReader = new ConfigReader("src/test/config.properties");
    String key;


    @Given("Go to n11 home page")
    public void goToN11() {
        logger.info("Navigate to the n11 home page");
        navigateUrl(HOME_PAGE_URL);
        checkPageTitle(HOME_PAGE_TITLE);
    }

    @When("Search the key from config")
    public void searchKey() {
        key = configReader.getProperty("searchTerm");
        logger.info(key + " keyword is searched");
        sendKeys(SEARCH_FIELD, key);
    }

    @When("Search (.*) value")
    public void searchKey(String searchedKey) {
        logger.info(searchedKey + " keyword is searched");
        sendKeys(SEARCH_FIELD, searchedKey);
    }

    @And("Click on the search icon")
    public void clickSearchIcon() {
        logger.info("Clicking on search icon");
        click(SEARCH_ICON);
    }

    @Then("Check that the current url contains the key value")
    public void checkSearchUrl() {
        logger.info("Checking that the current url contains the " + key + " value");
        containsPageUrl(key);
    }

    @Then("Check that the necessary text fields are equal to the key value")
    public void checkSearchTextFields() {
        logger.info("Checking that the necessary text fields are equal to the " + key + " value");
        checkElementTextUpperCase(SEARCHED_RESULT_TEXT,key);
        checkElementTextUpperCase(SEARCHED_BREADCRUMB_TEXT,key);
    }
    @Then("Check that the search not found field is displayed")
    public void checkUnsuccessfulSearch() {
        logger.info("Checking that the search not found field is displayed");
        checkElementDisplayed(SEARCH_RESULT_NOT_FOUND);
    }


}
