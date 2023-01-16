package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.List;

public class TaskListPage extends BasePage{

    public TaskListPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    //MOBILE ELEMENTS

    @AndroidFindBy(id = "fab")
    MobileElement addTaskBtn;

    @AndroidFindBy(accessibility = "More options")
    MobileElement moreBtn;

    @AndroidFindBy(id = "textViewNothing")
    MobileElement noTaskLabel;

    @AndroidFindBy(xpath = "//android.widget.ListView[@resource-id=\"com.jeffprod.todo:id/lv\"]/android.widget.RelativeLayout")
    List<MobileElement> tasks;


    //METHODS

    public TaskListPage verifyNoTaskAvailable(){
        String actual = getText(noTaskLabel);
        String expected = "Nothing here";
        Assert.assertEquals(actual, expected, "label should " + expected +" instead " + actual );
        return this;
    }

    public TaskListPage verifyTaskAdded(int index, String expectedTaskTitle){
        MobileElement task = tasks.get(index);
        waitForVisibility(task);
        String actualTaskTittle = task.findElement(MobileBy.id("textViewListView")).getText();
        Assert.assertEquals(actualTaskTittle, expectedTaskTitle,
                "actual title : " + actualTaskTittle + " |" + " expected title : " + expectedTaskTitle);
        return this;
    }

    public CreateTaskPage clickAddTaskButton(){
        clickElement(addTaskBtn);
        return new CreateTaskPage(driver);
    }
}
