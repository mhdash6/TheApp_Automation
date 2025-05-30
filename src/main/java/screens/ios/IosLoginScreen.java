package screens.ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import screens.base.LoginScreen;

public class IosLoginScreen extends LoginScreen {
    public static final By USERNAME = AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == 'username'`]");
    public static final By IOS_ALERT_MSG = AppiumBy.iOSClassChain("**/XCUIElementTypeAlert/**[`name CONTAINS 'Invalid'`]");
    public static final By IOS_ALERT_BTN = AppiumBy.accessibilityId("OK");

}
