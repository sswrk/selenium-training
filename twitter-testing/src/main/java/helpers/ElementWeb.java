package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ElementWeb {
    private final String NAME;
    private String xpath;
    private WebElement webElement;
    private final WebDriver webDriver;
    private final Assert assertManager;


    public ElementWeb(String name, String xpath, WebDriver webDriver, Assert assertManager) {
        this.NAME = name;
        this.xpath = xpath;
        this.webDriver = webDriver;
        this.assertManager = assertManager;
    }

    public ElementWeb(String name, WebElement webElement, WebDriver webDriver, Assert assertManager) {
        this.NAME = name;
        this.webElement = webElement;
        this.webDriver = webDriver;
        this.assertManager = assertManager;
    }

    public void click() {
        try {
            waitToBecomeClickable(120);
            getWebElement().click();
        } catch (NoSuchElementException e) {
            assertManager.fail("WebElement '" + NAME + "' not found", e);
        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);
        } catch(ElementClickInterceptedException e2){
            AppHelper.delay(2000);
            clickByJavaScript();
        } catch (Exception e2) {
            AppHelper.delay(2000);
            clickAgain();
        }
    }


    public void clickAgain() {
        try {
            getWebElement().click();
        } catch (NoSuchElementException e) {
            assertManager.fail("WebElement '" + NAME + "' not found", e);
        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);
        } catch (Exception e2) {
            assertManager.fail("Clicking '" + NAME + "' failed", e2);
        }
    }


    public WebElement getWebElement() throws NoSuchElementException, StaleElementReferenceException{
        if (webElement == null) {
            webElement = webDriver.findElement(By.xpath(xpath));
        }
        return webElement;
    }

    public void waitToBecomeClickable(long timeSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeSeconds);
        try {
            if(xpath!=null) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            else wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            assertManager.fail("WebElement '" + NAME + "' didn't become clickable in " + timeSeconds + " seconds", e);

        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);

        } catch (NoSuchElementException e2) {
            assertManager.fail("WebElement '" + NAME + "' couldn't be located", e2);
        }
        catch (Exception e3) {
            assertManager.fail("Waiting for WebElement '" + NAME + "' to become clickable failed", e3);
        }
    }

    public void sendKeys(String text) {
        try {
            waitToBecomeVisible(30);
            getWebElement().sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
        } catch (NoSuchElementException e) {
            assertManager.fail("WebElement '" + NAME + "' not found", e);
        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);
        } catch (Exception e2) {
            assertManager.fail("Sending keys to '" + NAME + "' failed", e2);
        }
    }

    public void sendKeys(Keys key) {
        try {
            waitToBecomeVisible(30);
            getWebElement().sendKeys(key);
        } catch (NoSuchElementException e) {
            assertManager.fail("WebElement '" + NAME + "' not found", e);
        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);
        } catch (Exception e2) {
            assertManager.fail("Sending keys to '" + NAME + "' failed", e2);
        }
    }

    public void sendKeys(Keys key, String text) {
        try {
            waitToBecomeVisible(30);
            getWebElement().sendKeys(key, text);
        } catch (NoSuchElementException e) {
            assertManager.fail("WebElement '" + NAME + "' not found", e);
        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);
        } catch (Exception e2) {
            assertManager.fail("Sending keys to '" + NAME + "' failed", e2);
        }
    }

    public void waitToBecomeVisible(long timeSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeSeconds);
        try {
            if(xpath!=null) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            else wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            assertManager.fail("WebElement '" + NAME + "' didn't become visible in " + timeSeconds + " seconds", e);
        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);
        } catch (NoSuchElementException e2) {
            assertManager.fail("WebElement '" + NAME + "' couldn't be located", e2);
        }
        catch (Exception e3) {
            assertManager.fail("Waiting for WebElement '" + NAME + "' to become visible failed", e3);
        }
    }

    public void waitToBecomePresent(long timeSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeSeconds);
        try {
            if(xpath!=null) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (TimeoutException e) {
            assertManager.fail("WebElement '" + NAME + "' didn't become present in " + timeSeconds + " seconds", e);
        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);
        } catch (NoSuchElementException e2) {
            assertManager.fail("WebElement '" + NAME + "' couldn't be located", e2);
        } catch (Exception e3) {
            assertManager.fail("Waiting for WebElement '" + NAME + "' to become present failed", e3);
        }
    }

    public void waitToBecomeInvisible(long timeSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeSeconds);
        try {
            if(xpath!=null)  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            else wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (TimeoutException e) {
            assertManager.fail("WebElement '" + NAME + "' didn't become invisible in " + timeSeconds + " seconds", e);
        } catch (NoSuchElementException e1) {
            assertManager.fail("WebElement '" + NAME + "' couldn't be located", e1);
        }
        catch (Exception e2) {
            assertManager.fail("Waiting for WebElement '" + NAME + "' to be invisible failed", e2);
        }
    }


    public void clear() {
        try {
            waitToBecomeVisible(30);
            getWebElement().clear();
        } catch (NoSuchElementException e) {
            assertManager.fail("WebElement '" + NAME + "' not found", e);
        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);

        } catch (Exception e2) {
            assertManager.fail("Clearing WebElement '" + NAME + "' failed", e2);
        }
    }

    public boolean isElementExists(int time) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, time);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementNotExists(int time) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, time);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getText() {
        String result = null;
        try {
            waitToBecomeVisible(30);
            result = getWebElement().getText();
            return result;
        } catch (NoSuchElementException e) {
            assertManager.fail("WebElement '" + NAME + "' not found", e);
            return null;
        } catch (StaleElementReferenceException e1) {
            assertManager.fail("WebElement '" + NAME + "' no longer exists as initially defined", e1);

            return null;
        } catch (Exception e2) {
            assertManager.fail("Getting text from '" + NAME + "' failed", e2);
        }
        return result;
    }

    public void clickByJavaScript(){
        try {
            waitToBecomeClickable(30);
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", getWebElement());
        }catch(Exception e){
            assertManager.fail("Clicking '" + NAME + "' failed", e);
        }
    }

    public static List<ElementWeb> findElements(ElementWeb element, By by, WebDriver webDriver, String name, Assert assertManager){
        element.waitToBecomePresent(30);
        List<ElementWeb> elements = new ArrayList<>();
        List<WebElement> webElements = element.getWebElement().findElements(by);
        int i = 0;
        for (WebElement webElement : webElements) {
            elements.add(new ElementWeb(name + " - " + (++i), webElement, webDriver, assertManager));
        }
        return elements;
    }

    public static List<ElementWeb> findElements(By by, WebDriver webDriver, String name, Assert assertManager){
        List<ElementWeb> elements = new ArrayList<>();
        List<WebElement> webElements = webDriver.findElements(by);
        int i = 0;
        for (WebElement webElement : webElements) {
            elements.add(new ElementWeb(name + " - " + (++i), webElement, webDriver, assertManager));
        }
        return elements;
    }

}
