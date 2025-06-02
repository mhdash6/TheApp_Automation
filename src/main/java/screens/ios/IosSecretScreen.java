package screens.ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import screens.base.LoginScreen;
import screens.base.SecretScreen;
import utils.appium.ElementsActions;

public class IosSecretScreen extends SecretScreen {
    private final By title = AppiumBy.iOSClassChain("**/*[`name==\"Secret Area\"`]");
    private final By loginMsg= AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name CONTAINS \"You are logged in as\"`]");
    private final By logoutBtn = AppiumBy.iOSNsPredicateString("name == \"Logout\"");


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
        return new IosLoginScreen();
    }
}
