package pages;

import helpers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends AppHelper {

    private final String TWEET_OPTIONS_xPath = "//*[@aria-label='More' and @aria-haspopup='true']";
    private final String TWEET_OPTIONS_NAME = "TWEET OPTIONS";

    private final String DELETE_xPath = "//*[@id='react-root']/div/div/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div/div/div[1]";
    private final String DELETE_NAME = "DELETE BUTTON";

    private final String CONFIRM_DELETE_xPath = "//*[@data-testid='confirmationSheetConfirm']";
    private final String CONFIRM_DELETE_NAME = "CONFIRM DELETE BUTTON";

    private final String NEWEST_TWEET_TEXT_xPath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[2]/section/div/div/div[1]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]/div/span/a";
    private final String NEWEST_TWEET_TEXT_NAME = "NEWEST TWEET TEXT";

    private final String NEWEST_TWEET_DATE_xPath = "(//time)[1]";
    private final String NEWEST_TWEET_DATE_NAME = "NEWEST TWEET DATE";

    private final String NEWEST_TWEET_xPath = "(//*[@role='article'])[1]";
    private final String NEWEST_TWEET_NAME = "NEWEST TWEET";

    private Assert assertManager;

    public ProfilePage(WebDriver webDriver, WebDriverWait webDriverWait, Assert assertManager) {
        super(webDriver, webDriverWait);
        this.assertManager = assertManager;
    }

    public void tweetOptions_click(){
        ElementWeb element = new ElementWeb(TWEET_OPTIONS_NAME, TWEET_OPTIONS_xPath, webDriver, assertManager);
        element.click();
    }

    public void deleteButton_click(){
        ElementWeb element = new ElementWeb(DELETE_NAME, DELETE_xPath, webDriver, assertManager);
        element.click();
    }

    public String newestTweet_getText(){
        ElementWeb element = new ElementWeb(NEWEST_TWEET_TEXT_NAME, NEWEST_TWEET_TEXT_xPath, webDriver, assertManager);
        return element.getText();
    }

    public String newestTweet_getDate(){
        ElementWeb element = new ElementWeb(NEWEST_TWEET_DATE_NAME, NEWEST_TWEET_DATE_xPath, webDriver, assertManager);
        String datetime = element.getWebElement().getAttribute("datetime");
        return datetime.substring(0, 10);
    }

    public void confirmDeleteButton_click(){
        ElementWeb element = new ElementWeb(CONFIRM_DELETE_NAME, CONFIRM_DELETE_xPath, webDriver, assertManager);
        element.click();
    }

    public void newestTweet_click(){
        ElementWeb element = new ElementWeb(NEWEST_TWEET_NAME, NEWEST_TWEET_xPath, webDriver, assertManager);
        element.click();
    }

}
