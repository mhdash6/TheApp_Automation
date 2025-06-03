package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.appium.DriverActions;
import utils.appium.ElementsActions;

public abstract class EchoBoxScreen {
    protected static final By inputField = AppiumBy.accessibilityId("messageInput");
    protected static final By saveBtn = AppiumBy.accessibilityId("messageSaveBtn");

    @Step("type in Input Field with text: {text}")
    public void setInputField(String text) {
        ElementsActions.setValue(inputField, text);
    }


    @Step("Click Save Button")
    public void clickSaveButton() {
        ElementsActions.click(saveBtn);
    }

    @Step("Set Echo Box with text: {text}")
    public void setEchoBox(String text) {
        setInputField(text);
        clickSaveButton();
    }

    @Step("Get Input Field Value")
    public String getInputFieldValue() {
        return ElementsActions.getAttribute(inputField, "value");
    }

    @Step("Navigate back to previous screen")
    public void navigateBack() {
        DriverActions.back();
    }

    public abstract String getEchoBoxText();
}
