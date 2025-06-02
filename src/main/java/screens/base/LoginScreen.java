package screens.base;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import utils.appium.ElementsActions;

public abstract class LoginScreen {
    protected static final By usernameField = AppiumBy.accessibilityId("username");
    protected static final By passwordField = AppiumBy.accessibilityId("password");
    protected static final By loginBtn = AppiumBy.accessibilityId("loginBtn");


    public void setUsername(String username) {
      ElementsActions.setValue(usernameField, username);
    }
    public void setPassword(String password) {
      ElementsActions.setValue(passwordField, password);
    }
    public  boolean isInLoginScreen(){
        return ElementsActions.isDisplayed(usernameField) && ElementsActions.isDisplayed(passwordField);
    }
    public SecretScreen login(String username, String password) {
        setUsername(username);
        setPassword(password);
        return tapLoginButton();
    }

    public abstract SecretScreen tapLoginButton();
    public abstract String getErrorMessage();
    public abstract void tapErrorOkButton();
}
