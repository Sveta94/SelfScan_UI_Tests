package pages.mainscreens;

import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

public class MainScreen extends AbstractScreen {

    public MainScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/ivProfile")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]")
    private WebElement USER_PROFILE_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnStart")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeOther' and @index='3']")
    private WebElement START_SHOPPING_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/ivFeedback")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    private WebElement FEEDBACK_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvTitle")
    @iOSXCUITFindBy(accessibility = "Как работает Экспресс-скан?")
    private WebElement MAIN_SCREEN_TITLE;

    @AndroidFindBy(id = "ru.x5.scango:id/ivFullMap")
    @iOSXCUITFindBy(accessibility = "openFullMapIcon")
    private WebElement FULL_MAP_BUTTON;

    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    private WebElement ALLOW_WHILE_USING_APP;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement MAIN_SCREEN_ITEM;


    //Methods
    public MainScreen tapOnUserProfile(){
        appiumUtils.click(USER_PROFILE_BUTTON);
        return this;
    }

    public boolean isStartShoppingButtonDisplayed(){
        return appiumUtils.isDisplayed(START_SHOPPING_BUTTON);
    }

    public MainScreen tapOnFeedBackButton(){
        try{
            if(device.executionOS.equals(DeviceManager.OS.IOS)) {
                tapOnAllowWhileUsingAppButton();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        appiumUtils.click(FEEDBACK_BUTTON);
        return this;
    }

    public MainScreen tapOnStartShoppingButton(){
        appiumUtils.click(START_SHOPPING_BUTTON);
        return this;
    }

    public String getMainScreenTitle(){
        return appiumUtils.getText(MAIN_SCREEN_TITLE);
    }

    public MainScreen tapOnFullMapButton(){
        appiumUtils.click(FULL_MAP_BUTTON);
        return this;
    }

    public MainScreen swipeScreenRightLeft(){
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            appiumUtils.swipeElementIOS(MAIN_SCREEN_ITEM, Direction.LEFT);
            appiumUtils.swipeElementIOS(MAIN_SCREEN_ITEM, Direction.RIGHT);
        }else {
            appiumUtils.swipeLeft().swipeRight();
        }
        return this;
    }

    public MainScreen tapOnAllowWhileUsingAppButton(){
        appiumUtils.click(ALLOW_WHILE_USING_APP);
        return this;
    }
}