package screens.ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import screens.base.LoginScreen;
import screens.base.SecretScreen;
import utils.appium.ElementsActions;

public class IosLoginScreen extends LoginScreen {
    public static final By USERNAME = AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == 'username'`]");
    public static final By errorAlertMsg = AppiumBy.iOSClassChain("**/XCUIElementTypeAlert/**[`name CONTAINS 'Invalid'`]");
    public static final By errorAlertBtn = AppiumBy.accessibilityId("OK");

    @Override
    public SecretScreen tapLoginButton() {
        ElementsActions.click(loginBtn);
        return new IosSecretScreen();
    }

    @Override
    public String getErrorMessage() {
       return ElementsActions.getText(errorAlertMsg);
    }

    @Override
    public void tapErrorOkButton() {
        if (ElementsActions.isDisplayed(errorAlertMsg)) {
            ElementsActions.click(errorAlertBtn);
        }
    }

}
