package screens.base;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import utils.appium.DriverActions;
import utils.appium.ElementsActions;

public abstract class EchoBoxScreen {
    protected static final By inputField = AppiumBy.accessibilityId("messageInput");
    protected static final By saveBtn = AppiumBy.accessibilityId("messageSaveBtn");

    public void setInputField(String text) {
        ElementsActions.setValue(inputField, text);
    }

    public void clickSaveButton() {
        ElementsActions.click(saveBtn);
    }
    public void setEchoBox(String text) {
        setInputField(text);
        clickSaveButton();
    }

    public String getInputFieldValue() {
        return ElementsActions.getAttribute(inputField, "value");
    }

    public void navigateBack() {
        DriverActions.back();
    }

    public abstract String getEchoBoxText();
}
