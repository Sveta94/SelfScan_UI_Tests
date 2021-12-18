package pages.userprofilescreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class PersonalDatePolicyScreen extends AbstractScreen {

    public PersonalDatePolicyScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "com.google.android.apps.docs:id/projector_toolbar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"URL\"]")
    private WebElement PROJECTOR_TOOLBAR;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    private WebElement BACK_BUTTON;


    //Methods
    public boolean isProjectorToolbarVisible(){
        return appiumUtils.switchTo().isDisplayed(PROJECTOR_TOOLBAR);
    }

    public void tapOnBackButton(){
        appiumUtils.click(BACK_BUTTON);
    }
}