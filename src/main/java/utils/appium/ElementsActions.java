package utils.appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import utils.appium.driverManager.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class ElementsActions {
    public List<WebElement> findElements(AppiumBy... locators ) {
        List<WebElement> allElements = new ArrayList<>();
        for(AppiumBy locator : locators) {
           List <WebElement> elements = DriverManager.getDriver().findElements(locator);
           allElements.addAll(elements);
        }
        return allElements;
    }

    public WebElement findElement(AppiumBy locator) {
        Waits.waitForElementToBeVisible(locator);
        return DriverManager.getDriver().findElement(locator);
    }

    public void setValue(AppiumBy locator, String value) {
        Waits.waitForElementToBeVisible(locator);
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void click(AppiumBy locator) {
        Waits.waitForElementToBeClickable(locator);
        WebElement element = findElement(locator);
        element.click();
    }



}
