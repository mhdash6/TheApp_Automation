package listeners;


import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;
import utils.appium.TerminalLogsCapture;
import utils.appium.driverManager.DriverManager;
import utils.common.LogsUtils;
import utils.common.assertions.AssertionManager;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;

import static utils.common.AllureUtils.attachLogs;

public class MethodInvocationListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()) {
            LogsUtils.clearCapturedLogs();
            DriverManager.initDriver();
            LogsUtils.info("Starting test: " + method.getTestMethod().getMethodName());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()){
            LogsUtils.info("Finished test: " + method.getTestMethod().getMethodName());
            AssertionManager.assertAll(testResult);
            attachLogs(testResult);
            DriverManager.quitDriver();
        }
    }
}
