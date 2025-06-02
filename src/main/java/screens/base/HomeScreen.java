package screens.base;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public abstract class HomeScreen {
    protected By echoBoxBtn = AppiumBy.accessibilityId("Echo Box");
    protected By  loginBtn = AppiumBy.accessibilityId("Login Screen");
    protected By listDemoBtn = AppiumBy.accessibilityId("List Demo");

    public abstract EchoBoxScreen navToEchoBox();

    public abstract LoginScreen navToLogin();

    public abstract ListScreen navToListDemo();
}
