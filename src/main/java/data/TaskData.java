package data;

import org.testng.annotations.DataProvider;

public class TaskData {

    @DataProvider(name = "Tasks")
    public Object[][] dataTask() {
        return new Object[][]{
                {"Create tutorial fb ads", "tutorial for creating fb ads"},
                {"Create portfolio", "portfolio for personal project"}
        };
    }




}
