package pages.userprofilescreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

public class ProfileScreen extends AbstractScreen {

    public ProfileScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements

    @AndroidFindBy(id = "ru.x5.scango:id/tvUserName")
    @iOSXCUITFindBy(accessibility = "Аь defaultsurname")
    private WebElement USER_NAME;

    @AndroidFindBy(id = "ru.x5.scango:id/tvUserPhone")
    @iOSXCUITFindBy(accessibility = "+7 915 293 26 55")
    private WebElement USER_PHONE_NUMBER;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @resource-id = 'ru.x5.scango:id/title' and @index = '0']")
    @iOSXCUITFindBy(accessibility = "Для покупок")
    private WebElement FOR_PURCHASES;

    @AndroidFindBy(id = "ru.x5.scango:id/orders")
    @iOSXCUITFindBy(accessibility = "Мои чеки")
    private WebElement ORDERS_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/appInfo")
    @iOSXCUITFindBy(accessibility = "О приложении")
    private WebElement ABOUT_APP_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnExit")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private WebElement LOG_OUT_BUTTON;

    @iOSXCUITFindBy(accessibility = "Not Now")
    private WebElement NOT_NOW_RATE;


    //Methods

    public String getUserNAme(){
        return appiumUtils.getText(USER_NAME);
    }

    public String getUserPhoneNumber(){
        return appiumUtils.getText(USER_PHONE_NUMBER);
    }

    public String phoneNumber(){
        String phoneNumber;
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            phoneNumber = "+7 915 293 26 55";
        }else {
            phoneNumber = "+7 (915) 293-26-55";
        }
        return phoneNumber;
    }

    public ProfileScreen tapOnForPurchasesButton(){
        appiumUtils.waitForElement(5).click(FOR_PURCHASES);
        return this;
    }

    public ProfileScreen tapOnOrdersButton(){
        appiumUtils.click(ORDERS_BUTTON);
        return this;
    }

    public ProfileScreen tapOnAboutAppButton(){
        appiumUtils.click(ABOUT_APP_BUTTON);
        return this;
    }

    public ProfileScreen tapOnLogOutButton(){
        appiumUtils.click(LOG_OUT_BUTTON);
        return this;
    }

    public ProfileScreen tapOnRateNotNowButton(){
        appiumUtils.click(NOT_NOW_RATE);
        return this;
    }
}