package screens.android;


import io.qameta.allure.Step;
import screens.base.EchoBoxScreen;
import screens.base.HomeScreen;
import screens.base.ListScreen;
import screens.base.LoginScreen;
import utils.appium.ElementsActions;

public class AndroidHomeScreen extends HomeScreen {
    @Override
    @Step("Navigate to Echo Box")
    public EchoBoxScreen navToEchoBox() {
        ElementsActions.click(echoBoxBtn);
        return new AndroidEchoBoxScreen();
    }


    @Override
    @Step("Navigate to Login Screen")
    public LoginScreen navToLogin() {
        ElementsActions.click(loginBtn);
        return new AndroidLoginScreen();
    }


    @Override
    @Step("Navigate to List Demo")
    public ListScreen navToListDemo() {
        ElementsActions.click(listDemoBtn);
        return new AndroidListScreen();
    }
}
