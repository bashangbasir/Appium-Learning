package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    AppiumDriver driver;
    public static final long WAIT = 10;

    public BasePage(AppiumDriver appiumDriver){
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }

    public void waitForVisibility(MobileElement el){
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void clickElement(MobileElement el){
        waitForVisibility(el);
        el.click();
    }

    public void clear(MobileElement el){
        waitForVisibility(el);
        el.clear();
    }

    public void sendText(MobileElement el, String text){
        waitForVisibility(el);
        el.sendKeys(text);
    }

    public String getText(MobileElement el){
        waitForVisibility(el);
        return el.getText();
    }

    public boolean isElementDisplayed(MobileElement el){
        return el.isDisplayed();
    }
}
