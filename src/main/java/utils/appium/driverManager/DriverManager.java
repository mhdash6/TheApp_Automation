package utils.appium.driverManager;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
   static  ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        if(driver.get() == null) {
            if("Android".equalsIgnoreCase(System.getProperty("Os"))){
               driver.set(new AndroidFactory().createDriver());
            } else if("iOS".equalsIgnoreCase(System.getProperty("Os"))) {
              driver.set(new IosDriverFactory().createDriver());
            } else {
                throw new IllegalArgumentException("Unsupported OS: " + System.getProperty("Os"));
            }
        }
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }



}
