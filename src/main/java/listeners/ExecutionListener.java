package listeners;

import org.apache.logging.log4j.ThreadContext;
import org.testng.IExecutionListener;

import utils.appium.ServerManager;
import utils.common.AllureUtils;
import utils.common.FilesUtils;
import utils.common.SystemProperties;

import static utils.common.AllureUtils.*;

public class ExecutionListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        FilesUtils.deleteFileContent(AllureUtils.Allure_Results_Path,"executor.json");
        SystemProperties.load();
        AllureUtils.setEnvironmentVariables();
    }

    @Override
    public void onExecutionFinish() {
        if ("local".equalsIgnoreCase(System.getProperty("executionType"))) {
            createReport();
            openReport(renameReport());
            ServerManager.stopService();
        }
    }
}
