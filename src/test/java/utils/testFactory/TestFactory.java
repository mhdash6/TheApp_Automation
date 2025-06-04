package utils.testFactory;


import org.testng.annotations.Factory;
import testClasses.features.CloudListTest;
import testClasses.features.EchoBoxTests;
import testClasses.features.LoginTests;
import utils.model.CloudListTestData;
import utils.model.EchoBoxTestData;
import utils.model.LoginTestData;


public class TestFactory {


    @Factory(dataProvider = "cloudListData", dataProviderClass = DataProviders.class)
    public Object[] createCloudListTestInstances(CloudListTestData cloudListTestData) {
        return new Object[]{new CloudListTest(cloudListTestData)};
    }

    @Factory(dataProvider = "echoBoxData", dataProviderClass = DataProviders.class)
    public Object [] createEchoBoxTestInstances(EchoBoxTestData echoBoxTestData) {
        return new Object[] {new EchoBoxTests(echoBoxTestData)};
    }

    @Factory(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public Object[] createInstances(LoginTestData loginTestData) {
        return new Object[]{
                new LoginTests(loginTestData)
        };
    }

}
