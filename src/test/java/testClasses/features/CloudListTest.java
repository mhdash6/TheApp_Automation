package testClasses.features;


import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.base.HomeScreen;
import screens.base.ListScreen;
import screens.screenFactory.ScreenFactory;
import utils.common.assertions.AssertionManager;
import utils.model.CloudListTestData;

@Listeners(DynamicAllureListener.class)
@Feature("Cloud List Feature")
public class CloudListTest
{
    private final CloudListTestData cloudListTestData;
    public final String story;
    public final String description;
    public CloudListTest(CloudListTestData cloudListTestData) {
        this.story = cloudListTestData.story();
        this.description = cloudListTestData.description();
        this.cloudListTestData = cloudListTestData;
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testCloudList() {
        HomeScreen homeScreen = ScreenFactory.getHomeScreen();
        ListScreen listScreen = homeScreen.navToListDemo();
        listScreen.scrollAndTapCloudName(cloudListTestData.firstCloudName());
        listScreen.tapLearnMore();
        AssertionManager.assertEquals(listScreen.getLearnMoreText(),
                cloudListTestData.firstCloudLearnMore(),
                "Learn more text should match the expected text: " + cloudListTestData.firstCloudLearnMore());
        listScreen.acceptAlert();

        if (cloudListTestData.hasSecondCloud()) {
            listScreen.scrollAndTapCloudName(cloudListTestData.secondCloudName(), cloudListTestData.secondCloudDirection());
            listScreen.tapLearnMore();
            AssertionManager.assertEquals(listScreen.getLearnMoreText(),
                    cloudListTestData.secondCloudLearnMore(),
                    "Learn more text should match the expected text: " + cloudListTestData.secondCloudLearnMore());
        }
    }




}
