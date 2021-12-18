package pages.userprofilescreens.purchasesscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import pages.enterappscreens.LoginScreen;
import root.DeviceManager;

public class AddNewCardScreen extends AbstractScreen {

    public AddNewCardScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='0' and @resource-id = 'pan']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeOther' and @index='10']")
    private WebElement CARD_NUMBER_FIELD;

    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeOther' and @index='11']")
    private WebElement CARD_DATE_CLICKER;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='0' and @resource-id = 'expiry']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeOther' and @index='12']")
    private WebElement CARD_DATE_FIELD;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='0' and @resource-id = 'cvc']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeOther' and @index='13']")
    private WebElement CARD_CVV_FIELD;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @index='6']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeButton' and @index='14']")
    private WebElement PAY_BUTTON;

    @iOSXCUITFindBy(accessibility = "Готово")
    private WebElement READY_BUTTON;

    //Methods
    public AddNewCardScreen setNewCardNumber(String cardNumber){
        appiumUtils.sendText(CARD_NUMBER_FIELD, cardNumber);
        return this;
    }

    public AddNewCardScreen setNewCardDate(String cardDate){
        if(device.executionOS.equals(DeviceManager.OS.ANDROID)) {
            appiumUtils.sendText(CARD_DATE_FIELD, cardDate);
        }else {
            appiumUtils.click(CARD_DATE_CLICKER)
                    .sendText(CARD_DATE_FIELD, cardDate);
        }
        return this;
    }

    public AddNewCardScreen setNewCardCVV(String cardCVV){
        appiumUtils.sendText(CARD_CVV_FIELD, cardCVV);
        return this;
    }

    public AddNewCardScreen tapOnPayButton(){
        appiumUtils.click(PAY_BUTTON);
        return this;
    }

    public AddNewCardScreen tapOnReadyButton(){
        appiumUtils.click(READY_BUTTON);
        return this;
    }
}