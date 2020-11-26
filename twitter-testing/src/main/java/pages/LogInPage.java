package pages;

import helpers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends AppHelper {

    private final String EMAIL_xPath = "//*[@name='session[username_or_email]' and @type='text']";
    private final String EMAIL_NAME = "EMAIL FIELD";

    private final String PASSWORD_xPath = "//*[@name='session[password]' and @type='password']";
    private final String PASSWORD_NAME = "PASSWORD FIELD";

    private final String LOG_IN_xPath = "//*[@data-testid='LoginForm_Login_Button']";
    private final String LOG_IN_NAME = "LOG IN BUTTON";

    private Assert assertManager;

    public LogInPage(WebDriver webDriver, WebDriverWait webDriverWait, Assert assertManager) {
        super(webDriver, webDriverWait);
        this.assertManager = assertManager;
    }

    public void emailField_sendKeys(String email){
        ElementWeb element = new ElementWeb(EMAIL_NAME, EMAIL_xPath, webDriver, assertManager);
        element.sendKeys(email);
    }

    public void passwordField_sendKeys(String password){
        ElementWeb element = new ElementWeb(PASSWORD_NAME, PASSWORD_xPath, webDriver, assertManager);
        element.sendKeys(password);
    }

    public void logInButton_click(){
        ElementWeb element = new ElementWeb(LOG_IN_NAME, LOG_IN_xPath, webDriver, assertManager);
        element.click();
    }

}