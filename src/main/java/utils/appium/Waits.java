package utils.appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.appium.driverManager.DriverManager;

import java.time.Duration;

public class Waits {


    public static void waitForElementToBeVisible(AppiumBy locator, Duration duration) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(AppiumBy locator, Duration duration) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), duration);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementToBeInvisible(AppiumBy locator, Duration duration) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), duration);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waiForElementToBeStale(WebElement element, Duration duration) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), duration);
        wait.until(ExpectedConditions.stalenessOf(element));
    }


    public static void waitForElementToBeVisible(AppiumBy locator) {
        waitForElementToBeVisible(locator, Duration.ofSeconds(Long.parseLong(System.getProperty("DefaultWaitTime", "5"))));
    }
    public static void waitForElementToBeClickable(AppiumBy locator) {
        waitForElementToBeClickable(locator, Duration.ofSeconds(Long.parseLong(System.getProperty("DefaultWaitTime", "5"))));
    }
    public static void waitForElementToBeInvisible(AppiumBy locator) {
        waitForElementToBeInvisible(locator, Duration.ofSeconds(Long.parseLong(System.getProperty("DefaultWaitTime", "5"))));
    }
    public static void waiForElementToBeStale(WebElement element) {
        waiForElementToBeStale(element, Duration.ofSeconds(Long.parseLong(System.getProperty("DefaultWaitTime", "5"))));
    }
}
