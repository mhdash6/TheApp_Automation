package screens.android;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.EchoBoxScreen;
import utils.appium.ElementsActions;

public class AndroidEchoBoxScreen extends EchoBoxScreen {

    private static final By savedMessage = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"savedMessage\")");


    @Override
    @Step("get Echo Box Text")
    public String getEchoBoxText() {
        return ElementsActions.getText(savedMessage);
    }
}
