package utils.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.URL;

public class ServerManager {
    private static AppiumDriverLocalService instance;

    private static AppiumDriverLocalService getInstance() {
        if (instance == null) {
            AppiumServiceBuilder builder = new AppiumServiceBuilder()
                    .withArgument(() -> "--log-no-colors")
                    .withArgument(() -> "--allow-insecure", "get_server_logs");
            instance = builder.build();
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
