package screens.ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import screens.base.EchoBoxScreen;
import utils.appium.ElementsActions;

public class IosEchoBoxScreen  extends EchoBoxScreen {
    protected static final By savedMessage = AppiumBy.accessibilityId("savedMessage");

    @Override
    public String getEchoBoxText() {
            return ElementsActions.getText(savedMessage);
    }

}
