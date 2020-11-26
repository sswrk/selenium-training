import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YouTubeTest {

    WebDriver driver;
    private final String login = "your google email";
    private final String password = "your google password";
    private final String chromeDriverPath = "chromedriver.exe path";

    private void login(){
        try {
            driver.get("https://youtube.com");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer")).click();
            driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(login);
            driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div")).click();
            driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div")).click();
        }
        catch (org.openqa.selenium.NoSuchElementException ignored){
        }
    }

    @BeforeTest
    public void loadWebDriver(){
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void likeTest(){
        String searchText = "accenture";

        login();

        driver.findElement(By.xpath("//*[@name=\"search_query\"]")).sendKeys(searchText);
        driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-level-buttons\"]/ytd-toggle-button-renderer[1]")).click();
        String likedVideo = driver.findElement(By.xpath("//*[@id=\"container\"]/h1/yt-formatted-string")).getText();
        driver.findElement(By.xpath("//*[@id=\"guide-button\"]/button")).click();
        driver.findElement(By.xpath("//*[@title=\"Liked videos\"]//parent::ytd-guide-entry-renderer")).click();

        boolean likedSuccessfully = true;

        try{
            driver.findElement(By.xpath("//*[@id=\"video-title\" and @class=\"style-scope ytd-playlist-video-renderer\" and @title=\""+likedVideo+"\"]"));
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            likedSuccessfully = false;
        }

        Assert.assertTrue(likedSuccessfully);
    }

    @Test
    public void subscriptionTest(){
        String searchText = "accenture";

        login();

        driver.findElement(By.xpath("//*[@name=\"search_query\"]")).sendKeys(searchText);
        driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/ytd-toggle-button-renderer")).click();
        driver.findElement(By.xpath("//*[@class=\"style-scope ytd-search-filter-renderer\" and text()=\"Channel\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"subscribe-button\"][1]/ytd-subscribe-button-renderer")).click();
        boolean subscribedSuccessfully = true;
        driver.findElement(By.xpath("//*[@aria-label=\"Guide\"]")).click();
        String subscribedChannel = driver.findElement(By.xpath("//*[@id=\"channel-title\"]/div/div/yt-formatted-string")).getText();
        try{
            driver.findElement(By.xpath("//*[@class='style-scope ytd-guide-entry-renderer']//*[text()='"+subscribedChannel+"']"));
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            subscribedSuccessfully = false;
        }

        Assert.assertTrue(subscribedSuccessfully);
    }

    @Test
    public void uploadTest(){
        String videoPath = "C:\\Users\\szymon.swierk\\IdeaProjects\\youtube-testing\\src\\main\\resources\\small.mp4";

        login();

        driver.findElement(By.xpath("//*[@aria-label=\"Create\"]")).click();
        driver.findElement(By.xpath("//*[@href=\"/upload\"]")).click();

        //TODO: upload, check if uploaded successfully
        driver.findElement(By.xpath("//*[@id=\"select-files-button\"]")).sendKeys(videoPath);
    }
}
