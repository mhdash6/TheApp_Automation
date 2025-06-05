package screens.ios;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.LoginScreen;
import screens.base.SecretScreen;
import utils.appium.ElementsActions;

public class IosLoginScreen extends LoginScreen {
    public static final By USERNAME = AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == 'username'`]");
    public static final By errorAlertMsg = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name BEGINSWITH 'Invalid'`]");
    public static final By errorAlertBtn = AppiumBy.accessibilityId("OK");

    @Override
    @Step("tap Login button")
    public SecretScreen tapLoginButton() {
        ElementsActions.click(loginBtn);
        return new IosSecretScreen();
    }

    @Override
    @Step("Get error message from alert")
    public String getErrorMessage() {
       return ElementsActions.getText(errorAlertMsg);
    }

    @Override
    @Step("tap Error Alert Ok button")
    public void tapErrorOkButton() {
        if (ElementsActions.isDisplayed(errorAlertMsg)) {
            ElementsActions.click(errorAlertBtn);
        }
    }

}
