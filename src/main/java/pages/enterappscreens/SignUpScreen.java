package pages.enterappscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class SignUpScreen extends AbstractScreen {

    public SignUpScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='4' and @resource-id= 'firstName']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTextField[1]")
    private WebElement USER_NAME_FIELD;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='5' and @resource-id= 'user.attributes.birth']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTextField[2]")
    private WebElement BIRTH_DATE_FIELD;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='6' and @resource-id= 'email']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTextField[3]")
    private WebElement EMAIL_FIELD;

    @AndroidFindBy(xpath = "//*[@class='android.widget.CheckBox' and @index='0' and @resource-id= 'agreementBox']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[6]/XCUIElementTypeSwitch")
    private WebElement AGREEMENT_CHECKBOX;

    @AndroidFindBy(xpath = "//*[@class='android.widget.CheckBox' and @index='0' and @resource-id= 'permissionMarketingBox']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[8]/XCUIElementTypeSwitch")
    private WebElement MARKETING_CHECKBOX;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @index='0' and @resource-id = 'fake_submit_button']")
    @iOSXCUITFindBy(accessibility = "Создать")
    private WebElement CREATE_USER_BUTTON;


    //Methods
    public SignUpScreen setUserName(String userName){
        appiumUtils.sendText(USER_NAME_FIELD, userName);
        return this;
    }

    public SignUpScreen setUserBirthDate(String birthDate){
        appiumUtils.sendText(BIRTH_DATE_FIELD, birthDate);
        return this;
    }

    public SignUpScreen setUserEmail(String email){
        appiumUtils.sendText(EMAIL_FIELD, email);
        return this;
    }

    public SignUpScreen enableCheckBoxes(){
        appiumUtils.click(AGREEMENT_CHECKBOX)
                .click(MARKETING_CHECKBOX);
        return this;
    }

    public SignUpScreen tapOnCreateUserButton(){
        appiumUtils.click(CREATE_USER_BUTTON);
        return this;
    }
}