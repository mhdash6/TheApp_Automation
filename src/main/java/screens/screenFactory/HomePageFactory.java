package screens.screenFactory;

import screens.android.AndroidHomeScreen;
import screens.base.HomeScreen;
import screens.ios.IosHomeScreen;

public class HomePageFactory {

    public static HomeScreen getHomePage() {
        return switch (platform.toLowerCase()) {
            case "android" -> new AndroidHomeScreen();
            case "ios" -> new IosHomeScreen();
            default -> throw new IllegalArgumentException("Unsupported platform: " + platform);
        };
    }
}
