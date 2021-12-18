package pages.userprofilescreens.purchasesscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class EmailScreen extends AbstractScreen {

    public EmailScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/edEmail")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField' and @index = '0']")
    private WebElement EMAIL_FIELD;

    @AndroidFindBy(id = "ru.x5.scango:id/btnSave")
    @iOSXCUITFindBy(accessibility = "Сохранить")
    private WebElement SAVE_EMAIL_BUTTON;


    //Methods
    public EmailScreen setNewEmail(String newEmail){
        appiumUtils.click(EMAIL_FIELD).sendText(EMAIL_FIELD, newEmail);
        return this;
    }

    public EmailScreen tapOnSaveEmailButton(){
        appiumUtils.click(SAVE_EMAIL_BUTTON);
        return this;
    }
}