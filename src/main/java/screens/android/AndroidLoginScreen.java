package screens.android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import screens.base.LoginScreen;

public class AndroidLoginScreen extends LoginScreen {
    private final By androidAlertMsg = AppiumBy.id("android:id/message");
    private final By androidAlertBtn = AppiumBy.id("android:id/button1");
}
