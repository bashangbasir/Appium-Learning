import data.TaskData;
import org.testng.annotations.Test;
import pages.TaskListPage;

import java.util.List;

public class CreateTaskTest extends BaseTest{

    TaskListPage taskListPage;

    @Test(dataProvider = "dataFromJson", dataProviderClass = TaskData.class)
    public void createOneTaskTest(String title,  String desc){

        taskListPage = new TaskListPage(driver);

        taskListPage
                .verifyNoTaskAvailable()
                .clickAddTaskButton()
                .enterTaskTitle(title)
                .enterDescriptionNote(desc)
                .clickSaveBtn()
                .verifyTaskAdded(0, title);

    }

    @Test(dataProvider = "multipleTasks", dataProviderClass = TaskData.class)
    public void createMultipleTaskTest(List<String> taskNames, List<String> taskDescs){

        String firstTaskTitle = taskNames.get(0);
        String firstDesc = taskDescs.get(0);
        String secondTaskTitle = taskNames.get(1);;
        String secondDesc = taskDescs.get(1);
        String thirdTaskTitle = taskNames.get(2);;
        String thirdDesc = taskDescs.get(2);

        taskListPage = new TaskListPage(driver);

        taskListPage
                .verifyNoTaskAvailable()
                .clickAddTaskButton()
                .enterTaskTitle(firstTaskTitle)
                .enterDescriptionNote(firstDesc)
                .clickSaveBtn()
                .verifyTaskAdded(0, firstTaskTitle)
                .clickAddTaskButton()
                .enterTaskTitle(secondTaskTitle)
                .enterDescriptionNote(secondDesc)
                .clickSaveBtn()
                .verifyTaskAdded(1, secondTaskTitle)
                .clickAddTaskButton()
                .enterTaskTitle(thirdTaskTitle)
                .enterDescriptionNote(thirdDesc)
                .clickSaveBtn()
                .verifyTaskAdded(2, thirdTaskTitle);

    }
}
