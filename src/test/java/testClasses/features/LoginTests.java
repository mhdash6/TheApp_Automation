package testClasses.features;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.base.HomeScreen;
import screens.base.LoginScreen;
import screens.base.SecretScreen;
import screens.screenFactory.ScreenFactory;
import utils.common.assertions.AssertionManager;
import utils.model.LoginTestData;


@Listeners(DynamicAllureListener.class)
@Feature("Login Feature")
public class LoginTests  {
    String username;
    String password;
    boolean shouldLogin;
    public String story ;
    public String description ;

    public LoginTests(LoginTestData loginTestData) {
        this.username = loginTestData.userName();
        this.password = loginTestData.password();
        this.shouldLogin = loginTestData.shouldLogin();
        this.story = loginTestData.story();
        this.description = loginTestData.description();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testLogin() {
       HomeScreen homeScreen = ScreenFactory.getHomeScreen();
       LoginScreen loginScreen= homeScreen.navToLogin();
       SecretScreen secretScreen= loginScreen.login(username, password);
       AssertionManager.assertEquals(secretScreen.isSecretScreenVisible(),shouldLogin);
         if(shouldLogin) {
              AssertionManager.assertEquals(secretScreen.getLoginMessage(),
                      "You are logged in as " + username);
              loginScreen= secretScreen.clickLogoutButton();
              AssertionManager.assertTrue(loginScreen.isInLoginScreen(),
                      "User should be redirected to login screen after logout");
         } else {
              AssertionManager.assertEquals(loginScreen.getErrorMessage(),
                      "Invalid login credentials, please try again");
              loginScreen.tapErrorOkButton();
              AssertionManager.assertTrue(loginScreen.isInLoginScreen(),
                      "User should remain on login screen after failed login");
         }
    }


}
