package screens.android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import screens.base.LoginScreen;
import screens.base.SecretScreen;
import utils.appium.ElementsActions;

public class AndroidLoginScreen extends LoginScreen {
    private final By errorAlertMsg = AppiumBy.id("android:id/message");
    private final By errorAlertBtn = AppiumBy.id("android:id/button1");

    @Override
    public SecretScreen tapLoginButton() {
        ElementsActions.click(loginBtn);
        return new AndroidSecretScreen();
    }

    @Override
    public String getErrorMessage() {
        return ElementsActions.getText(errorAlertMsg);
    }

    @Override
    public void tapErrorOkButton() {
        if (ElementsActions.isDisplayed(errorAlertBtn)) {
            ElementsActions.click(errorAlertBtn);
        }
    }
}
