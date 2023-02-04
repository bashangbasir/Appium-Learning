package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import java.util.List;

public class TaskListPage extends BasePage{

    public TaskListPage(AppiumDriver appiumDriver){
        super(appiumDriver);
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
            //TODO need to update for ios
        }else{
            String actual = getText(noTaskLabel);
            String expected = "Nothing here";
            Assert.assertEquals(actual, expected, "label should " + expected +" instead " + actual );
        }
        return this;
    }

    public TaskListPage verifyTaskAdded(int index, String expectedTaskTitle){

        if(System.getProperty("testPlatform").equalsIgnoreCase("iOS")){
            //TODO need to update for ios
        }else{
            MobileElement task = tasks.get(index);
            waitForVisibility(task);
            String actualTaskTittle = task.findElement(MobileBy.id("textViewListView")).getText();
            Assert.assertEquals(actualTaskTittle, expectedTaskTitle,
                    "actual title : " + actualTaskTittle + " |" + " expected title : " + expectedTaskTitle);

        }
        return this;
    }

    public CreateTaskPage clickAddTaskButton(){
        clickElement(addTaskBtn);
        return new CreateTaskPage(driver);
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
