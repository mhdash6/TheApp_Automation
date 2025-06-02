package screens.android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import screens.base.LoginScreen;
import screens.base.SecretScreen;
import utils.appium.ElementsActions;

public class AndroidSecretScreen extends SecretScreen {
    private final By title = AppiumBy.androidUIAutomator("new UiSelector().text(\"Secret Area\")");
    private final By loginMsg = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"You are logged in as\")");
    private final By logoutBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Logout\")");

    @Override
    public boolean isSecretScreenVisible() {
        return ElementsActions.isDisplayed(title);
    }

    @Override
    public String getLoginMessage() {
        return ElementsActions.getText(loginMsg);
    }

    @Override
    public LoginScreen clickLogoutButton() {
        ElementsActions.click(logoutBtn);
        return new AndroidLoginScreen();
    }
}

