package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import testClasses.features.CloudListTest;
import testClasses.features.EchoBoxTests;
import testClasses.features.LoginTests;
import utils.common.JsonUtils;
import utils.model.CloudListTestData;
import utils.model.EchoBoxTestData;
import utils.model.LoginTestData;


public class TestFactory {

     LoginTestData [] loginTestDataList = JsonUtils.readJson("src/test/resources/loginTestData.json"
             ,  LoginTestData[].class);


    @DataProvider(name = "loginData")
    public  Object[][] loginData() {
        Object[][] data = new Object[loginTestDataList.length][1];
        for (int i = 0; i < loginTestDataList.length; i++) {
            data[i][0] = loginTestDataList[i];
        }
        return data;
    }

    @Factory(dataProvider = "loginData")
    public Object[] createInstances(LoginTestData loginTestData) {
        return new Object[]{
                new LoginTests(loginTestData)
        };
    }


     EchoBoxTestData[] echoBoxTestDataArray=  JsonUtils.readJson("src/test/resources/echoBoxTestData.json"
             ,EchoBoxTestData[].class);

    @DataProvider(name = "echoBoxData")
    public Object[][] echoBoxData() {
        Object[][] data = new Object[echoBoxTestDataArray.length][1];
        for (int i = 0; i < echoBoxTestDataArray.length; i++) {
            data[i][0] = echoBoxTestDataArray[i];
        }
        return data;
    }



    @Factory(dataProvider = "echoBoxData")
    public Object [] createEchoBoxTestInstances(EchoBoxTestData echoBoxTestData) {
        return new Object[] {new EchoBoxTests(echoBoxTestData)};
    }


    CloudListTestData[] cloudListTestDataArray = JsonUtils.readJson("src/test/resources/cloudListTestData.json",
            CloudListTestData[].class);
    @DataProvider(name = "cloudListData")
    public Object[][] cloudListData() {
        Object[][] data = new Object[cloudListTestDataArray.length][1];
        for (int i = 0; i < cloudListTestDataArray.length; i++) {
            data[i][0] = cloudListTestDataArray[i];
        }
        return data;
    }
    @Factory(dataProvider = "cloudListData")
    public Object[] createCloudListTestInstances(CloudListTestData cloudListTestData) {
        return new Object[]{new CloudListTest(cloudListTestData)};
    }


}
