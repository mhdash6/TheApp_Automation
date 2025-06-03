package screens.android;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.ListScreen;
import utils.android.AndroidActions;
import utils.appium.ElementsActions;
import utils.common.LogsUtils;


public class AndroidListScreen extends ListScreen {

    private static final By alertOkBtn = AppiumBy.id("android:id/button1");
    private static final By learnMoreBtn = AppiumBy.id("android:id/button3");
    private static final By alertMsgLocator = AppiumBy.id("android:id/message");


    @Override
    @Step("tap Learn More button")
    public void tapLearnMore() {
        if(cloudName != null) {
            ElementsActions.click(learnMoreBtn);
        } else {
            LogsUtils.error("Cloud Alert not Opened. Cannot tap Learn More button.");
        }
    }

    @Override
    @Step("Get Learn More text")
    public String getLearnMoreText() {
        if(cloudName != null) {
         return ElementsActions.getText(alertMsgLocator);
        }
        LogsUtils.error("Cloud Alert not Opened. Cannot get Learn More text.");
        return "";
    }

    @Override
    @Step("accept Alert")
    public void acceptAlert() {
        ElementsActions.click(alertOkBtn);
        cloudName = null;
    }


    @Override
    @Step("tap Cloud Name: {cloudName} after Scrolling in direction: {direction}")
    public void scrollAndTapCloudName(String cloudName, String direction) {
        scrollAndTapCloudName(cloudName);
    }


    @Override
    @Step("tap Cloud Name: {cloudName}")
    public void scrollAndTapCloudName(String cloudName) {
        this.cloudName = cloudName;
        String UiSelector =  String.format("new UiSelector().text(\"%s\")", cloudName);
        AndroidActions.scrollToElement(UiSelector);
        ElementsActions.click(AppiumBy.androidUIAutomator(UiSelector));
    }

}
