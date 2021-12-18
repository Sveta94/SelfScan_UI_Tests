package pages.feedbackscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class PhotoScreen extends AbstractScreen {

    public PhotoScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Shutter\"]")
//    @iOSXCUITFindBy()
    private WebElement TAKE_PHOTO_BUTTON;

    @AndroidFindBy(id = "com.android.camera2:id/done_button")
//    @iOSXCUITFindBy()
    private WebElement SUBMIT_PHOTO_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/image_view")
    @iOSXCUITFindBy(accessibility = "Photo 1")
    private WebElement IMAGE_VIEW;

    @AndroidFindBy(id = "ru.x5.scango:id/menu_done")
    @iOSXCUITFindBy(accessibility = "Done (1)")
    private WebElement IMAGE_VIEW_DONE;


    //Methods
    public PhotoScreen tapOnTakePhotoButton(){
        appiumUtils.waitForElement(5)
                .click(TAKE_PHOTO_BUTTON);
        return this;
    }

    public PhotoScreen tapOnSubmitPhotoButton(){
        appiumUtils.click(SUBMIT_PHOTO_BUTTON);
        return this;
    }

    public PhotoScreen selectImage(){
        appiumUtils.click(IMAGE_VIEW);
        return this;
    }

    public PhotoScreen tapOnDoneButton(){
        appiumUtils.click(IMAGE_VIEW_DONE);
        return this;
    }
}