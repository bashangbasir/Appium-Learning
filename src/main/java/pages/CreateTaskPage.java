package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static pages.TaskListPage.getTaskListPage;

public class CreateTaskPage extends BasePage{

    private CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public static CreateTaskPage getCreateTaskPage(AppiumDriver appiumDriver){
        return new CreateTaskPage(appiumDriver);
    }

    //MOBILE ELEMENTS

    @AndroidFindBy(id = "editTextTitre")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Title\"`]")
    MobileElement titleTextBox;

    @AndroidFindBy(id = "editTextNote")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Description\"`]")
    MobileElement noteTextBox;

    @AndroidFindBy(id = "editTextTag")
    MobileElement tagTextBox;

    @AndroidFindBy(id = "action_save")
    @iOSXCUITFindBy(accessibility = "Save")
    MobileElement saveBtn;

    //METHODS

    public CreateTaskPage enterTaskTitle(String taskName){
        clear(titleTextBox);
        sendText(titleTextBox, taskName);
        return this;
    }

    public CreateTaskPage enterDescriptionNote(String taskDescription){
        clear(noteTextBox);
        sendText(noteTextBox, taskDescription);
        return this;
    }

    public TaskListPage clickSaveBtn(){
        clickElement(saveBtn);
        return getTaskListPage(driver);
    }

}
