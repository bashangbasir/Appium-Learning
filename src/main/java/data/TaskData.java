package data;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import utils.JsonReader;

import java.io.IOException;

public class TaskData {

    @DataProvider(name = "Tasks")
    public Object[][] dataTask() {
        return new Object[][]{
                {"Create tutorial fb ads", "tutorial for creating fb ads"},
                {"Create portfolio", "portfolio for personal project"}
        };
    }

    @DataProvider(name = "dataFromJson")
    public Object[][] dataJSONTask() throws Exception {
        return JsonReader.getJSONData
                (System.getProperty("user.dir") + "/data/TaskData.json"
                        , "Tasks Data", 2);
}

}
