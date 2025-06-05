package screens.ios;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.ListScreen;
import utils.appium.ElementsActions;
import utils.common.LogsUtils;
import utils.appium.Waits;
import java.time.Duration;
import utils.ios.IosActions;


public class IosListScreen extends ListScreen {
   private static final By alertOkBtn = AppiumBy.iOSNsPredicateString("label == 'OK' OR name == 'OK'");
   private static final By list = AppiumBy.iOSClassChain("**/XCUIElementTypeScrollView");



    private By getLearnMoreButtonLocator() {
        String locator= String.format("**/XCUIElementTypeButton[`label == 'Learn more about %s'`]", cloudName);
        return AppiumBy.iOSClassChain(locator);
    }

    private  By getLearnMoreTextLocator() {
        String Locator= String.format(
                "//XCUIElementTypeStaticText[@name='%s']/following-sibling::XCUIElementTypeStaticText",
                cloudName
        );
        return By.xpath(Locator);
    }

    @Override
    @Step("tap Learn More button")
    public void tapLearnMore() {
        if (cloudName != null ) {
            ElementsActions.click( getLearnMoreButtonLocator());
        }else {
            LogsUtils.error("Cloud Alert not Opened. Cannot tap Learn More button.");
        }

    }

    @Override
    @Step("Get Learn More text")
    public String getLearnMoreText() {
        if (cloudName != null ) {
           return ElementsActions.getText(getLearnMoreTextLocator());
        }
        LogsUtils.error("Cloud Alert not Opened. Cannot get Learn More text.");
        return "";
    }


    @Override
    @Step("accept Alert")
    public void acceptAlert() {
        ElementsActions.click(alertOkBtn);
        cloudName= null;
    }

    @Override
    @Step("tap Cloud Name: {cloudName} after Scrolling in direction: {direction}")
    public void scrollAndTapCloudName(String cloudName, String direction) {
        this.cloudName = cloudName;
        String predicateString = String.format("name ==[c] '%s' or label ==[c] '%s'", cloudName, cloudName);
        if (ElementsActions.isDisplayed(AppiumBy.iOSNsPredicateString(predicateString))) {
            ElementsActions.click(AppiumBy.iOSNsPredicateString(predicateString));
        }else{
        IosActions.scrollToElement(ElementsActions.findElement(list),predicateString, direction);
        Waits.waitForScrollToStop(AppiumBy.iOSNsPredicateString(predicateString), Duration.ofSeconds(5));
        ElementsActions.click(AppiumBy.iOSNsPredicateString(predicateString));
        }
        
    }

    @Override
    @Step("tap Error Alert Ok button")
    public void scrollAndTapCloudName(String cloudName) {
        scrollAndTapCloudName(cloudName, "down");
    }


}
