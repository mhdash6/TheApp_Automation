package screens.ios;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.EchoBoxScreen;
import utils.appium.ElementsActions;
import utils.ios.IosActions;


public class IosEchoBoxScreen  extends EchoBoxScreen {
    protected static final By savedMessage = AppiumBy.accessibilityId("savedMessage");


    @Override
    @Step("get Echo Box Text")
    public String getEchoBoxText() {
            return ElementsActions.getText(savedMessage);
    }

    @Override
    @Step("set Echo Box Text: {text}")
    public void setInputField(String text){
        IosActions.setValue(ElementsActions.findElement(inputField), text);
    }

}
