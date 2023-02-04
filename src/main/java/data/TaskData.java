package data;

import org.testng.annotations.DataProvider;
import utils.JsonReader;

import java.util.Arrays;


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

    @DataProvider(name = "multipleTasks")
    public Object[][] dataMultipleTask() {
        return new Object[][]{
                {Arrays.asList("Watch anime", "Play game", "Check crypto data"), Arrays.asList("anime Onepiece", "game rush royale", "Ripple portfolio")}
        };
    }

}
