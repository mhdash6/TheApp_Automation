package testClasses.features;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.base.EchoBoxScreen;
import screens.base.HomeScreen;
import screens.screenFactory.ScreenFactory;
import utils.common.assertions.AssertionManager;
import utils.model.EchoBoxTestData;

@Listeners(DynamicAllureListener.class)
@Feature("Echo Box Feature")
public class EchoBoxTests {

    private final EchoBoxTestData echoBoxTestData;
    public final String story ;
    public final String description ;

    public EchoBoxTests(EchoBoxTestData testData) {
        this.echoBoxTestData = testData;
        this.story = testData.story();
        this.description = testData.description();
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testEchoBox() {
       HomeScreen homeScreen = ScreenFactory.getHomeScreen();
       EchoBoxScreen echoBoxScreen= homeScreen.navToEchoBox();
       echoBoxScreen.setEchoBox(echoBoxTestData.firstInput());
       AssertionManager.assertEquals(echoBoxScreen.getEchoBoxText()
               , echoBoxTestData.firstInput()
               ,"echoBox text should match the first input: " + echoBoxTestData.firstInput());

       if (echoBoxTestData.shouldChangeText()){
           echoBoxScreen.setEchoBox(echoBoxTestData.secondInput());
       }

         AssertionManager.assertEquals(echoBoxScreen.getEchoBoxText()
                , echoBoxTestData.getExpectedFinalText()
                ,"echoBox text should match the expected final text: " + echoBoxTestData.getExpectedFinalText());
    }
}
