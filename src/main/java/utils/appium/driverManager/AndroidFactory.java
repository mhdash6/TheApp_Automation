package utils.appium.driverManager;

import com.browserstack.v2.utils.BrowserStack;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.appium.ServerManager;
import utils.common.LogsUtils;
import utils.common.PropertiesUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidFactory implements DriverFactory{
    @Override
    public  AppiumDriver createDriver() {
            UiAutomator2Options options = (UiAutomator2Options) setCapabilities();
            return new AppiumDriver(ServerManager.getServiceUrl(), options);
    }

    @Override
    public   Capabilities setCapabilities() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName(PropertiesUtils.getProperty("deviceName", "Android Device"));
        options.setApp(PropertiesUtils.getProperty("appPath"));
        options.setAutomationName("UiAutomator2");
        if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
            options.headless();
        }
        options.headless();
        return options;
    }
}
