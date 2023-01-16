import org.testng.annotations.Test;
import pages.TaskListPage;

public class CreateTaskTest extends BaseTest{

    TaskListPage taskListPage;

    @Test
    public void createTaskTest(){

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
}
