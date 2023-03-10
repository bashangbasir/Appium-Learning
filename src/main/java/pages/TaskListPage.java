package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import java.util.List;

import static pages.CreateTaskPage.getCreateTaskPage;

public class TaskListPage extends BasePage{

    private TaskListPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    public static TaskListPage getTaskListPage(AppiumDriver appiumDriver){
        return new TaskListPage(appiumDriver);
    }

    //MOBILE ELEMENTS

    @AndroidFindBy(id = "fab")
    @iOSXCUITFindBy(accessibility = "plus.circle")
    MobileElement addTaskBtn;

    @AndroidFindBy(accessibility = "More options")
    MobileElement moreBtn;

    @AndroidFindBy(id = "textViewNothing")
    MobileElement noTaskLabel;

    @AndroidFindBy(xpath = "//android.widget.ListView[@resource-id=\"com.jeffprod.todo:id/lv\"]/android.widget.RelativeLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[./*[@name='circle']]")
    List<MobileElement> tasks;

    @iOSXCUITFindBy(accessibility = "Edit")
    MobileElement editBtn;

    @iOSXCUITFindBy(accessibility = "Delete")
    MobileElement deleteBtn;

    //METHODS

    public TaskListPage verifyNoTaskAvailable(){
        if(System.getProperty("testPlatform").equalsIgnoreCase("iOS")){
            int actualTaskNumber = tasks.size();
            int expectedTaskNumber = 0;
            Assert.assertEquals(actualTaskNumber, expectedTaskNumber , "Task is expected to be " + expectedTaskNumber);
        }else{
            String actual = getText(noTaskLabel);
            String expected = "Nothing here";
            Assert.assertEquals(actual, expected, "label should " + expected +" instead " + actual );
        }
        return this;
    }

    public TaskListPage verifyTaskAdded(int index, String expectedTaskTitle){
        String actualTaskTitle;
        if(System.getProperty("testPlatform").equalsIgnoreCase("iOS")){
            MobileElement task = tasks.get(index);
            waitForVisibility(task);
            actualTaskTitle = task.findElement(MobileBy.id(expectedTaskTitle)).getText();
        }else{
            MobileElement task = tasks.get(index);
            waitForVisibility(task);
            actualTaskTitle = task.findElement(MobileBy.id("textViewListView")).getText();
        }
        Assert.assertEquals(actualTaskTitle, expectedTaskTitle,
                "actual title : " + actualTaskTitle + " |" + " expected title : " + expectedTaskTitle);
        return this;
    }

    public CreateTaskPage clickAddTaskButton(){
        clickElement(addTaskBtn);
        return getCreateTaskPage(driver);
    }

    public TaskListPage clearAllTasks(){
        if(System.getProperty("testPlatform").equalsIgnoreCase("iOS")){
            clickElement(editBtn);
            for(int i = tasks.size()-1; i >= 0; i--){
                MobileElement minusBtn = tasks.get(i).findElement(MobileBy.xpath("//XCUIElementTypeButton[starts-with(@name, 'Delete')]"));
                clickElement(minusBtn);
                clickElement(deleteBtn);
            }
        }else{
            //TODO need to update for Android
        }
        return this;
    }
}
