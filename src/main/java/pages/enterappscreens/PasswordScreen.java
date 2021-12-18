package pages.enterappscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class PasswordScreen extends AbstractScreen {

    public PasswordScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @text = 'Пароль']")
//    @iOSXCUITFindBy()
    private WebElement NEW_PASSWORD_FIELD;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @text = 'Повторите пароль']")
//    @iOSXCUITFindBy()
    private WebElement REPEAT_PASSWORD_FIELD;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @index='0' and @resource-id= 'fake_submit_button']")
//    @iOSXCUITFindBy()
    private WebElement SUBMIT_PASSWORD_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='0']")
//    @iOSXCUITFindBy()
    private WebElement PASSWORD_FIELD;


    //Methods
    public PasswordScreen setNewPassword(String password){
        appiumUtils.sendText(NEW_PASSWORD_FIELD, password);
        return this;
    }

    public PasswordScreen repeatNewPassword(String password){
        appiumUtils.sendText(REPEAT_PASSWORD_FIELD, password);
        return this;
    }

    public PasswordScreen tapOnSubmitPasswordButton(){
        appiumUtils.click(SUBMIT_PASSWORD_BUTTON);
        return this;
    }

    public PasswordScreen setPassword(String password){
        appiumUtils.sendText(PASSWORD_FIELD, password);
        return this;
    }

    public PasswordScreen tapOnEnterApp(){
        appiumUtils.enterApp();
        return this;
    }
}