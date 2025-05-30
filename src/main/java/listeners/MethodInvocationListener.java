package listeners;


import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import utils.appium.driverManager.DriverManager;
import utils.common.assertions.AssertionManager;

import static utils.common.AllureUtils.attachLogs;

public class MethodInvocationListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()) {
            DriverManager.initDriver();
        }

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()){
            AssertionManager.clearSoftAssert();
            attachLogs(testResult);
            DriverManager.quitDriver();
        }
    }
}
