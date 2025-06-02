package screens.android;


import screens.base.EchoBoxScreen;
import screens.base.HomeScreen;
import screens.base.ListScreen;
import screens.base.LoginScreen;
import utils.appium.ElementsActions;

public class AndroidHomeScreen extends HomeScreen {
    @Override
    public EchoBoxScreen navToEchoBox() {
        ElementsActions.click(echoBoxBtn);
        return new AndroidEchoBoxScreen();
    }

    @Override
    public LoginScreen navToLogin() {
        ElementsActions.click(loginBtn);
        return new AndroidLoginScreen();
    }

    @Override
    public ListScreen navToListDemo() {
        ElementsActions.click(listDemoBtn);
        return new AndroidListScreen();
    }
}
