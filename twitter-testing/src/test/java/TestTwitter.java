import helpers.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import pages.*;


public class TestTwitter {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private Assert assertManager;
    private final String chromeDriverPath = "path to chromedriver.exe";

    @BeforeTest
    public void loadWebDriver(){
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 15);
        assertManager = new Assert(driver);

        driver.get("https://twitter.com");

    }

    @Parameters({"email", "password"})
    @Test
    public void loginTest(String email, String password){

        HomePage homePage = new HomePage(driver, webDriverWait, assertManager);
        LogInPage logInPage = new LogInPage(driver, webDriverWait, assertManager);

        homePage.logInButton_click();
        logInPage.emailField_sendKeys(email);
        logInPage.passwordField_sendKeys(password);
        logInPage.logInButton_click();
        homePage.cookiesCloseButton_click();
    }

    @Test
    public void trendsTest(){
        HomePage homePage = new HomePage(driver, webDriverWait, assertManager);
        TrendsPage trendsPage = new TrendsPage(driver, webDriverWait, assertManager);

        homePage.trends_click();
        trendsPage.settingsButton_click();
        trendsPage.personalizationCheckbox_uncheck();
        trendsPage.locationCheckbox_uncheck();
        trendsPage.locationExploreButton_click();
        trendsPage.locationChoiceButton_click();
        trendsPage.closeButton_click();
    }

    @Parameters({"hashtag"})
    @Test
    public void tweetTest(String hashtag){

        HomePage homePage = new HomePage(driver, webDriverWait, assertManager);
        ProfilePage profilePage = new ProfilePage(driver, webDriverWait, assertManager);

        homePage.homeButton_click();
        homePage.tweetInput_sendKeys(hashtag);
        homePage.tweetButton_click();
        homePage.profileButton_click();
        try {
            if(!profilePage.newestTweet_getText().equals(hashtag))
                assertManager.fail("Post hasn't been added");
        }
        catch(NoSuchElementException e){
            assertManager.fail("There are no posts");
        }
    }

    @Test
    public void deleteTweetsTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver, webDriverWait, assertManager);
        ProfilePage profilePage = new ProfilePage(driver, webDriverWait, assertManager);

        homePage.profileButton_click();

        String newestTweetDate = profilePage.newestTweet_getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        while(newestTweetDate.equals(now.format(formatter))){
            profilePage.newestTweet_click();
            profilePage.tweetOptions_click();
            profilePage.deleteButton_click();
            profilePage.confirmDeleteButton_click();
            newestTweetDate = profilePage.newestTweet_getDate();
        }
    }

}
