package screens.ios;


import io.qameta.allure.Step;
import screens.base.EchoBoxScreen;
import screens.base.HomeScreen;
import screens.base.ListScreen;
import screens.base.LoginScreen;
import utils.appium.ElementsActions;

public class IosHomeScreen extends HomeScreen {
    @Override
    @Step("Navigate to Echo Box")
    public EchoBoxScreen navToEchoBox() {
        ElementsActions.click( echoBoxBtn);
        return new IosEchoBoxScreen();
    }

    @Override
    @Step("Navigate to Login Screen")
    public LoginScreen navToLogin() {
        ElementsActions.click(loginBtn);
        return new IosLoginScreen();
    }

    @Override
    @Step("Navigate to List Demo")
    public ListScreen navToListDemo() {
        ElementsActions.click(listDemoBtn);
        return new IosListScreen();
    }
}
