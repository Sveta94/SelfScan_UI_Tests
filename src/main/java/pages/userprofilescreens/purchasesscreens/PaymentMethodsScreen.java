package pages.userprofilescreens.purchasesscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

import java.util.List;

public class PaymentMethodsScreen extends AbstractScreen {

    public PaymentMethodsScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @resource-id = 'ru.x5.scango:id/titleView' and @text='Добавить новую карту']")
    @iOSXCUITFindBy(accessibility = "Добавить новую карту")
    private WebElement ADD_NEW_CARD_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @index='1' and @resource-id = 'ru.x5.scango:id/titleView' and @text = '• • • • 5599']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    private WebElement ADDED_CARD;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @index='1' and @resource-id = 'ru.x5.scango:id/titleView' and @text = '• • • • 0000']")
    //    @iOSXCUITFindBy()
    private WebElement ADDED_CARD2;

    @AndroidFindBy(id = "ru.x5.scango:id/ivBack")
    @iOSXCUITFindBy(accessibility = "Назад")
    private WebElement BACK_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/changeText")
    @iOSXCUITFindBy(accessibility = "Изменить")
    private WebElement EDIT_BUTTON;

    @iOSXCUITFindBy(accessibility = "Оплатить другой картой")
    private WebElement PAY_WITH_OTHER_CARD;


    //Methods
    public PaymentMethodsScreen tapOnAddNewCardButton(){
        appiumUtils.click(ADD_NEW_CARD_BUTTON);
        return this;
    }

    public boolean isAddedCardDisplayed(){
        appiumUtils.waitForElement(15);
        return appiumUtils.isDisplayed(ADDED_CARD);
    }

    public PaymentMethodsScreen tapOnAddedCardOption(){
        try {
            appiumUtils.click(ADDED_CARD2);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            appiumUtils.waitForElement(20);
        }
        return this;
    }

    public PaymentMethodsScreen tapOnBackButton(){
        appiumUtils.click(BACK_BUTTON);
        return this;
    }

    public PaymentMethodsScreen tapOnEditButton(){
        appiumUtils.click(EDIT_BUTTON);
        return this;
    }

    public PaymentMethodsScreen tapOnPayWithOtherCardButton(){
        appiumUtils.click(PAY_WITH_OTHER_CARD);
        return this;
    }

    public int getCardOptionsCount(){
        List<WebElement> cards;
        if(device.executionOS.equals(DeviceManager.OS.ANDROID)) {
            cards = appiumUtils.findElementsByXpath("//*[@class='android.view.ViewGroup' and @resource-id = 'ru.x5.scango:id/clContent']");
        }else {
            cards = appiumUtils.findElementsByXpath("//*[@type='XCUIElementTypeCell']");
        }
        return cards.size();
    }
}