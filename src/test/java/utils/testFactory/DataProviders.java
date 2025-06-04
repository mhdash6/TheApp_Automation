package utils.testFactory;

import org.testng.annotations.DataProvider;
import utils.common.JsonUtils;
import utils.model.CloudListTestData;
import utils.model.EchoBoxTestData;
import utils.model.LoginTestData;

public class DataProviders {

    CloudListTestData[] cloudListTestDataArray = JsonUtils.readJson("src/test/resources/cloudListTestData.json",
            CloudListTestData[].class);

    EchoBoxTestData[] echoBoxTestDataArray=  JsonUtils.readJson("src/test/resources/echoBoxTestData.json"
            ,EchoBoxTestData[].class);

    LoginTestData[] loginTestDataList = JsonUtils.readJson("src/test/resources/loginTestData.json"
            ,  LoginTestData[].class);

    @DataProvider(name = "cloudListData")
    public Object[][] cloudListData() {
        Object[][] data = new Object[cloudListTestDataArray.length][1];
        for (int i = 0; i < cloudListTestDataArray.length; i++) {
            data[i][0] = cloudListTestDataArray[i];
        }
        return data;
    }


    @DataProvider(name = "echoBoxData")
    public Object[][] echoBoxData() {
        Object[][] data = new Object[echoBoxTestDataArray.length][1];
        for (int i = 0; i < echoBoxTestDataArray.length; i++) {
            data[i][0] = echoBoxTestDataArray[i];
        }
        return data;
    }



    @DataProvider(name = "loginData")
    public  Object[][] loginData() {
        Object[][] data = new Object[loginTestDataList.length][1];
        for (int i = 0; i < loginTestDataList.length; i++) {
            data[i][0] = loginTestDataList[i];
        }
        return data;
    }
}
