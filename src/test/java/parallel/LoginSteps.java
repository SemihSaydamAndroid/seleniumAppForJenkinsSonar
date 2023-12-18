package parallel;

import base.BasePage;

import helper.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static constants.HomePageConstants.MY_ACCOUNT;
import static constants.HomePageConstants.HOME_PAGE_TITLE;
import static constants.LoginPageConstants.*;

public class LoginSteps extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

    ConfigReader configReader = new ConfigReader("src/test/config.properties");


    @Given("Go to n11 login page")
    public void goToN11() {
        logger.info("Navigate to the n11 login page");
        navigateUrl(LOGIN_URL);
        checkPageTitle(LOGIN_PAGE_TITLE);
    }

    @When("Username is entered from config")
    public void enterUsername() {
        String email = configReader.getProperty("username");
        logger.info(email + " value is entered in the email field");
        sendKeys(EMAIL_FIELD, email);
    }

    @When("(.*) value is entered in username field")
    public void enterUsername(String email) {
        logger.info(email + " value is entered in the email field");
        sendKeys(EMAIL_FIELD, email);
    }

    @And("Password is entered from config")
    public void enterPassword() {
        String password = configReader.getProperty("password");
        logger.info(password + " value is entered in the email field");
        sendKeys(PASSWORD_FIELD, password);
    }

    @And("(.*) value is entered in password field")
    public void enterPassword(String password) {
        logger.info(password + " value is entered in the email field");
        sendKeys(PASSWORD_FIELD, password);
    }

    @And("Clicking on sign in button")
    public void clickSignIn() {
        logger.info("Clicking on login button");
        click(LOGIN_BUTTON);
    }

    @Then("Check that logged in successfully")
    public void checkSuccessfullyLogin() {
        logger.info("Checking that logged in successfully");
        checkElementDisplayed(MY_ACCOUNT);
        checkPageTitle(HOME_PAGE_TITLE);
    }

    @Then("Check that empty password error")
    public void checkEmptyPasswordError() {
        checkElementDisplayed(PASSWORD_ERROR_LOCATOR);
        checkElementText(PASSWORD_ERROR_LOCATOR, EMPTY_PASSWORD_ERROR_TEXT);
        logger.error(EMPTY_PASSWORD_ERROR_TEXT + " error message has been shown");
    }

    @Then("Check that min character password error")
    public void checkMinPasswordError() {
        checkElementDisplayed(PASSWORD_ERROR_LOCATOR);
        checkElementText(PASSWORD_ERROR_LOCATOR, MIN_CHARACTER_PASSWORD_ERROR_TEXT);
        logger.error(MIN_CHARACTER_PASSWORD_ERROR_TEXT + " error message has been shown");
    }

    @Then("Check that max character password error")
    public void checkMaxPasswordError() {
        checkElementDisplayed(PASSWORD_ERROR_LOCATOR);
        checkElementText(PASSWORD_ERROR_LOCATOR, MAX_CHARACTER_PASSWORD_ERROR_TEXT);
        logger.error(MAX_CHARACTER_PASSWORD_ERROR_TEXT + " error message has been shown");
    }

    @Then("Check that empty email error")
    public void checkEmptyEmailError() {
        checkElementDisplayed(EMAIL_ERROR_LOCATOR);
        checkElementText(EMAIL_ERROR_LOCATOR, EMPTY_EMAIL_ERROR_TEXT);
        logger.error(EMPTY_EMAIL_ERROR_TEXT + " error message has been shown");
    }

    @Then("Check that invalid email error")
    public void checkInvalidEmailError() {
        checkElementDisplayed(EMAIL_ERROR_LOCATOR);
        checkElementText(EMAIL_ERROR_LOCATOR, INVALID_EMAIL_ERROR_TEXT);
        logger.error(INVALID_EMAIL_ERROR_TEXT + " error message has been shown");
    }

    @Then("Check that wrong email or password error")
    public void checkWrongEmailOrPasswordError() {
        checkElementDisplayed(PASSWORD_ERROR_LOCATOR);
        checkElementText(PASSWORD_ERROR_LOCATOR, WRONG_PASSWORD_EMAIL_ERROR_TEXT);
        logger.error(WRONG_PASSWORD_EMAIL_ERROR_TEXT + " error message has been shown");
    }


}
