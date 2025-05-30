package utils.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.URL;

public class ServerManager {
    private static AppiumDriverLocalService instance;


    private static AppiumDriverLocalService getInstance() {
        if (instance == null) {
            instance = AppiumDriverLocalService.buildDefaultService();
        }
        return instance;
    }

    public static void startService() {
        getInstance().start();
    }

    public static void stopService() {
        getInstance().stop();
    }

    public static URL getServiceUrl() {
        return getInstance().getUrl();
    }
}
