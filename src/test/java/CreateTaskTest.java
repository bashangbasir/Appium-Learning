import org.testng.annotations.Test;
import pages.TaskListPage;

public class CreateTaskTest extends BaseTest{

    TaskListPage taskListPage;

    @Test
    public void createOneTaskTest(){

        taskListPage = new TaskListPage(driver);
        String title = "Finish up the painting";
        String desc = "Painting for the new client";

        taskListPage
                .verifyNoTaskAvailable()
                .clickAddTaskButton()
                .enterTaskTitle(title)
                .enterDescriptionNote(desc)
                .clickSaveBtn()
                .verifyTaskAdded(0, title);

    }

    @Test
    public void createMultipleTaskTest(){

        taskListPage = new TaskListPage(driver);
        String firstTaskTitle = "Finish up the painting";
        String firstDesc = "Painting for the new client";
        String secondTaskTitle = "Start exercise";
        String secondDesc = "target to achieve 80kg";

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
                .verifyTaskAdded(1, secondTaskTitle);

    }
}
