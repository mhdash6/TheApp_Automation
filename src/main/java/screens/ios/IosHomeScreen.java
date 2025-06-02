package screens.ios;


import screens.base.EchoBoxScreen;
import screens.base.HomeScreen;
import screens.base.ListScreen;
import screens.base.LoginScreen;
import utils.appium.ElementsActions;

public class IosHomeScreen extends HomeScreen {
    @Override
    public EchoBoxScreen navToEchoBox() {
        ElementsActions.click( echoBoxBtn);
        return new IosEchoBoxScreen();
    }

    @Override
    public LoginScreen navToLogin() {
        ElementsActions.click(loginBtn);
        return new IosLoginScreen();
    }

    @Override
    public ListScreen navToListDemo() {
        ElementsActions.click(listDemoBtn);
        return new IosListScreen();
    }
}
