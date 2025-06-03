package screens.android;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.LoginScreen;
import screens.base.SecretScreen;
import utils.appium.ElementsActions;

public class AndroidSecretScreen extends SecretScreen {
    private final By title = AppiumBy.androidUIAutomator("new UiSelector().text(\"Secret Area\")");
    private final By loginMsg = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"You are logged in as\")");
    private final By logoutBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Logout\")");

    @Override
    @Step("Check if in Secret Screen")
    public boolean isSecretScreenVisible() {
        return ElementsActions.isDisplayed(title);
    }

    @Override
    @Step("get Login Message")
    public String getLoginMessage() {
        return ElementsActions.getText(loginMsg);
    }

    @Override
    @Step("Click Logout Button")
    public LoginScreen clickLogoutButton() {
        ElementsActions.click(logoutBtn);
        return new AndroidLoginScreen();
    }
}

