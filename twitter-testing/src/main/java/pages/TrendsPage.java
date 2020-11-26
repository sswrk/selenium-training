package pages;

import helpers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TrendsPage extends AppHelper {

    private final String SETTINGS_xPath = "//*[@href='/settings/trends']";
    private final String SETTINGS_NAME = "SETTINGS BUTTON";

    private final String PERSONALIZATION_CHECKBOX_xPath = "(//input[@type='checkbox'])[2]";
    private final String PERSONALIZATION_CHECKBOX_NAME = "PERSONALIZATION CHECKBOX";

    private final String LOCATION_CHECKBOX_xPath = "(//input[@type='checkbox'])[1]";
    private final String LOCATION_CHECKBOX_NAME = "LOCATION CHECKBOX";

    private final String LOCATION_EXPLORE_xPath = "//a[@href='/settings/trends/location']";
    private final String LOCATION_EXPLORE_NAME = "LOCATION EXPLORE BUTTON";

    private final String LOCATION_CHOICE_xPath = "//*[text()='Angola']//parent::div//parent::div";
    private final String LOCATION_CHOICE_NAME = "LOCATION CHOICE BUTTON";

    private final String CLOSE_xPath = "//*[@aria-label='Close']";
    private final String CLOSE_NAME = "CLOSE BUTTON";

    private Assert assertManager;

    public TrendsPage(WebDriver webDriver, WebDriverWait webDriverWait, Assert assertManager) {
        super(webDriver, webDriverWait);
        this.assertManager = assertManager;
    }

    public void settingsButton_click(){
        ElementWeb element = new ElementWeb(SETTINGS_NAME, SETTINGS_xPath, webDriver, assertManager);
        element.click();
    }

    public void personalizationCheckbox_uncheck(){
        ElementWeb element = new ElementWeb(PERSONALIZATION_CHECKBOX_NAME, PERSONALIZATION_CHECKBOX_xPath, webDriver, assertManager);
        if(element.getWebElement().isSelected())
            element.click();
    }

    public void locationCheckbox_uncheck(){
        ElementWeb element = new ElementWeb(LOCATION_CHECKBOX_NAME, LOCATION_CHECKBOX_xPath, webDriver, assertManager);
        if(element.getWebElement().isSelected())
            element.click();
    }

    public void locationExploreButton_click(){
        ElementWeb element = new ElementWeb(LOCATION_EXPLORE_NAME, LOCATION_EXPLORE_xPath, webDriver, assertManager);
        element.click();
    }

    public void locationChoiceButton_click(){
        ElementWeb element = new ElementWeb(LOCATION_CHOICE_NAME, LOCATION_CHOICE_xPath, webDriver, assertManager);
        element.click();
    }

    public void closeButton_click(){
        ElementWeb element = new ElementWeb(CLOSE_NAME, CLOSE_xPath, webDriver, assertManager);
        element.click();
    }

}
