package pages.feedbackscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

public class StoresScreen extends AbstractScreen {

    public StoresScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/etLastStore")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    private WebElement STORES_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvTitle")
    private WebElement STORES_BUTTON_MOUNTAIN;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @index='0' and @resource-id = 'ru.x5.scango:id/tvCity']")
    private WebElement MOSCOW_CITY_OPTION;

    @AndroidFindBy(id = "ru.x5.scango:id/btnChoose")
    @iOSXCUITFindBy(accessibility = "Выбрать")
    private WebElement SUBMIT_SELECTED_CITY_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/ivTCX")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    private WebElement TCX_NUMBER;

    @AndroidFindBy(id = "ru.x5.scango:id/ivTC5")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    private WebElement TC5_NUMBER;

    @AndroidFindBy(id = "ru.x5.scango:id/tvTitle")
    @iOSXCUITFindBy(accessibility = "Москва")
    private WebElement IV_LOGO;


    //Methods
    public StoresScreen tapOnStoresButton(){
        appiumUtils.waitForElement(10);
        if (device.executionOS.equals(DeviceManager.OS.IOS)) {
            appiumUtils.click(STORES_BUTTON);
        }else {
            try{
                appiumUtils.click(STORES_BUTTON);
            }catch (Exception e){
                e.printStackTrace();
                appiumUtils.click(STORES_BUTTON_MOUNTAIN);
            }
        }
        return this;
    }

    public StoresScreen selectMoscowCity(){
        appiumUtils.click(MOSCOW_CITY_OPTION);
        return this;
    }

    public StoresScreen selectMoscowCityMap(){
        appiumUtils.click(MOSCOW_CITY_OPTION);
        return this;
    }

    public StoresScreen tapOnSubmitSelectedCity(){
        appiumUtils.click(SUBMIT_SELECTED_CITY_BUTTON);
        return this;
    }

    public boolean isTCXNumberButtonDisplayed(){
        return appiumUtils.isDisplayed(TCX_NUMBER);
    }

    public boolean isTC5NumberButtonDisplayed(){
        return appiumUtils.isDisplayed(TC5_NUMBER);
    }

    public StoresScreen tapOnTCXNumberButton(){
        appiumUtils.click(TCX_NUMBER);
        return this;
    }

    public boolean isIvLogoDisplayed(){
        return appiumUtils.isDisplayed(IV_LOGO);
    }
}