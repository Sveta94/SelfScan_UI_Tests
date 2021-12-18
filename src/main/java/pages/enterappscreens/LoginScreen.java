package pages.enterappscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

public class LoginScreen extends AbstractScreen {

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='1' and @resource-id = 'phone']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Экспресс скан\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField\n")
    private WebElement PHONE_NUMBER_FIELD;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='7' and @resource-id = 'phone']")
    private WebElement PHONE_NUMBER_FIELD_CLICKED;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @index='0']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Экспресс скан\"]/XCUIElementTypeOther[6]/XCUIElementTypeButton\n")
    private WebElement SUBMIT_BUTTON;

    @iOSXCUITFindBy(accessibility = "Готово")
    private WebElement READY_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.view.View' and @text = 'Войти по паролю']")
//    @iOSXCUITFindBy()
    private WebElement WITH_PASSWORD_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.view.View' and @text = 'Я забыл пароль']")
//    @iOSXCUITFindBy()
    private WebElement FORGET_PASSWORD_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @index ='0' and @resource-id= 'back_button']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeButton")
    private WebElement BACK_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.view.View' and @index='4']")
    @iOSXCUITFindBy(accessibility = "Вход с помощью X5ID")
    private WebElement LOGIN_SCREEN_TITLE;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @index='3']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Arrow right\"]")
    private WebElement SKIP_AUTHORIZATION_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnMainAction")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    private WebElement TRY_AGAIN_BUTTON;

    @iOSXCUITFindBy(accessibility = "Повторить")
    private WebElement TRY_AGAIN;

    @iOSXCUITFindBy(accessibility = "storiesCloseIcon")
    private WebElement CLOSE_NOTIFICATION_SCREEN;


    //Methods
    public LoginScreen setPhoneNumber(String phoneNumber){
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            appiumUtils.sendText(PHONE_NUMBER_FIELD, phoneNumber);
        }else {
            try{
                appiumUtils.sendText(PHONE_NUMBER_FIELD, phoneNumber);
            }catch (NoSuchElementException e){
                e.printStackTrace();
                appiumUtils.sendText(PHONE_NUMBER_FIELD_CLICKED, phoneNumber);
            }
        }
        hideKeyboard();
        return this;
    }

    public LoginScreen tapOnSubmitButton(){
        appiumUtils.click(SUBMIT_BUTTON);
        return this;
    }

    public LoginScreen tapOnReadyButton(){
        appiumUtils.click(READY_BUTTON);
        return this;
    }

    public LoginScreen tapOnWithPasswordButton(){
        appiumUtils.click(WITH_PASSWORD_BUTTON);
        return this;
    }

    public LoginScreen tapOnForgetPasswordButton(){
        appiumUtils.click(FORGET_PASSWORD_BUTTON);
        return this;
    }

    public void setSmsCode(String sms) {
        for(int i=2; i<=5; i++){
            WebElement element;
            if(device.executionOS.equals(DeviceManager.OS.IOS)) {
                element = appiumUtils.findElementByXpath("//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[" + (i-1) +"]");
            }else {
                element = appiumUtils.findElementByXpath("//*[@class='android.widget.EditText' and @index='"+i+"' and @resource-id= 'code"+(i-1)+"']");
            }
            appiumUtils.sendText(element, sms);
        }
    }

    public LoginScreen tapOnBackButton(){
        appiumUtils.click(BACK_BUTTON);
        return this;
    }

    public String getLoginScreenTitle(){
        String loginTitle = "";
        try{
            loginTitle = appiumUtils.getText(LOGIN_SCREEN_TITLE);
        }catch (NoSuchElementException | AssertionError e){
            e.printStackTrace();
            if(device.executionOS.equals(DeviceManager.OS.IOS)) {
                appiumUtils.click(CLOSE_NOTIFICATION_SCREEN);
            }
            appiumUtils.waitForElement(5);
            loginTitle = appiumUtils.getText(LOGIN_SCREEN_TITLE);
        }
        return loginTitle;
    }

    public LoginScreen tapOnTryAgainButton(){
        appiumUtils.click(TRY_AGAIN_BUTTON);
        return this;
    }

    public LoginScreen tapOnTryAgain(){
        appiumUtils.click(TRY_AGAIN);
        return this;
    }

    public LoginScreen tapOnSkipAuthorizationButton(){
        appiumUtils.click(SKIP_AUTHORIZATION_BUTTON);
        return this;
    }
}