package screens.base;

import io.qameta.allure.Step;

public abstract class SecretScreen {


    public abstract boolean isSecretScreenVisible();
    public abstract String getLoginMessage();
    public abstract LoginScreen clickLogoutButton();
}
