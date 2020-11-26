package helpers;

import org.openqa.selenium.WebDriver;

public class Assert {
    private WebDriver webDriver;

    public Assert(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fail(String message, Throwable e){
        org.testng.Assert.fail(message, e);
    }

    public void fail(String message){
        org.testng.Assert.fail(message);
    }

}
