package screens.base;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public abstract class LoginScreen {
    public static final By USERNAME = AppiumBy.accessibilityId("username");
    public static final By PASSWORD = AppiumBy.accessibilityId("password");
    public static final By LOGIN_BUTTON = AppiumBy.accessibilityId("loginBtn");
}
