package constants;

import org.openqa.selenium.By;

public class LoginPageConstants {
    public static final String LOGIN_URL = "https://www.n11.com/giris-yap";
    public static final By EMAIL_FIELD = By.id("email");
    public static final By LOGIN_BUTTON = By.id("loginButton");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By PASSWORD_ERROR_LOCATOR = By.cssSelector("div[data-errormessagefor='password']>div[class='errorText']");
    public static final By EMAIL_ERROR_LOCATOR = By.cssSelector("div[data-errormessagefor='email']>div[class='errorText']");
    public static final String EMPTY_PASSWORD_ERROR_TEXT = "Bu alanın doldurulması zorunludur.";
    public static final String EMPTY_EMAIL_ERROR_TEXT = "Lütfen e-posta adresinizi girin.";
    public static final String INVALID_EMAIL_ERROR_TEXT = "Lütfen geçerli bir e-posta adresi girin.";
    public static final String MAX_CHARACTER_PASSWORD_ERROR_TEXT = "Girilen değer en fazla 15 karakter olmalıdır.";
    public static final String MIN_CHARACTER_PASSWORD_ERROR_TEXT = "Girilen değer en az 6 karakter olmalıdır.";
    public static final String WRONG_PASSWORD_EMAIL_ERROR_TEXT = "E-posta adresiniz veya şifreniz hatalı";
    public static final String LOGIN_PAGE_TITLE = "Giriş Yap - n11.com";

}
