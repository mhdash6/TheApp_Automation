package screens.android;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.LoginScreen;
import screens.base.SecretScreen;
import utils.appium.ElementsActions;

public class AndroidLoginScreen extends LoginScreen {
    private final By errorAlertMsg = AppiumBy.id("android:id/message");
    private final By errorAlertBtn = AppiumBy.id("android:id/button1");

    @Override
    @Step("tap Login button")
    public SecretScreen tapLoginButton() {
        ElementsActions.click(loginBtn);
        return new AndroidSecretScreen();
    }

    @Override
    @Step("Get error message from alert")
    public String getErrorMessage() {
        return ElementsActions.getText(errorAlertMsg);
    }


    @Override
    @Step("tap Error Alert Ok button")
    public void tapErrorOkButton() {
        if (ElementsActions.isDisplayed(errorAlertBtn)) {
            ElementsActions.click(errorAlertBtn);
        }
    }
}
