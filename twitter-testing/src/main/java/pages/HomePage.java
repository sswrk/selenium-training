package pages;

import helpers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AppHelper{

    private final String LOG_IN_xPath = "//*[@href='/login']";
    private final String LOG_IN_NAME = "LOG IN BUTTON";

    private final String COOKIES_CLOSE_xPath = "//span[text()='Close']//parent::span//parent::div//parent::div";
    private final String COOKIES_CLOSE_NAME = "COOKIES CLOSE BUTTON";

    private final String TRENDS_xPath = "//*[@href='/i/trends']";
    private final String TRENDS_NAME = "TRENDS";

    private final String HOME_xPath = "//*[@href='/home']";
    private final String HOME_NAME = "HOME BUTTON";

    private final String TWEET_xPath = "//*[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']";
    private final String TWEET_NAME = "TWEET INPUT";

    private final String TWEET_BUTTON_xPath = "//*[@data-testid='tweetButtonInline']";
    private final String TWEET_BUTTON_NAME = "TWEET BUTTON";

    private final String PROFILE_xPath = "//a[@aria-label='Profile' and @role='link']";
    private final String PROFILE_NAME = "PROFILE BUTTON";

    private Assert assertManager;

    public HomePage(WebDriver webDriver, WebDriverWait webDriverWait, Assert assertManager) {
        super(webDriver, webDriverWait);
        this.assertManager = assertManager;
    }

    public void logInButton_click(){
        ElementWeb element = new ElementWeb(LOG_IN_NAME, LOG_IN_xPath, webDriver, assertManager);
        element.click();
    }

    public void cookiesCloseButton_click(){
        ElementWeb element = new ElementWeb(COOKIES_CLOSE_NAME, COOKIES_CLOSE_xPath, webDriver, assertManager);
        element.click();
    }

    public void trends_click(){
        ElementWeb element = new ElementWeb(TRENDS_NAME, TRENDS_xPath, webDriver, assertManager);
        element.click();
    }

    public void homeButton_click(){
        ElementWeb element = new ElementWeb(HOME_NAME, HOME_xPath, webDriver, assertManager);
        element.click();
    }

    public void tweetInput_sendKeys(String text){
        ElementWeb element = new ElementWeb(TWEET_NAME, TWEET_xPath, webDriver, assertManager);
        element.sendKeys(text);
    }

    public void tweetButton_click(){
        ElementWeb element = new ElementWeb(TWEET_BUTTON_NAME, TWEET_BUTTON_xPath, webDriver, assertManager);
        element.click();
    }

    public void profileButton_click(){
        ElementWeb element = new ElementWeb(PROFILE_NAME, PROFILE_xPath, webDriver, assertManager);
        element.click();
    }

}
