package screens.screenFactory;

import screens.android.AndroidHomeScreen;
import screens.base.HomeScreen;
import screens.ios.IosHomeScreen;
import utils.common.PropertiesUtils;

public class ScreenFactory {
    public static HomeScreen getHomeScreen() {
        if("Android".equalsIgnoreCase( PropertiesUtils.getProperty("platformName"))) {
            return new AndroidHomeScreen();
        } else {
            return new IosHomeScreen();
        }
    }
}
