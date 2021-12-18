package pages.userprofilescreens.purchasesscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class ForPurchasesScreen extends AbstractScreen {

    public ForPurchasesScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @resource-id = 'ru.x5.scango:id/subtitle']")
    @iOSXCUITFindBy(accessibility = "newuser@gmail.com")
    private WebElement USER_EMAIL;

    @AndroidFindBy(id = "ru.x5.scango:id/paymentMethod")
    @iOSXCUITFindBy(accessibility = "Способ оплаты")
    private WebElement PAYMENT_METHOD_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @index = '1' and @resource-id = 'ru.x5.scango:id/subtitle' and @text = '• • • • 0000']")
//    @iOSXCUITFindBy()
    private WebElement CARD_TEXT;

    @AndroidFindBy(id = "ru.x5.scango:id/loyaltyCards")
    @iOSXCUITFindBy(accessibility = "Мои карты лояльности")
    private WebElement LOYALTY_CARDS_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/ivBack")
    @iOSXCUITFindBy(accessibility = "Назад")
    private WebElement BACK_BUTTON;



    public String getUserEmail(){
        return appiumUtils.getText(USER_EMAIL);
    }

    public ForPurchasesScreen tapOnEmailButton(){
        appiumUtils.click(USER_EMAIL);
        return this;
    }

    public ForPurchasesScreen tapOnPaymentMethodsButton(){
        appiumUtils.waitForElement(8).click(PAYMENT_METHOD_BUTTON);
        return this;
    }

    public String getCardText(){
        return appiumUtils.getText(CARD_TEXT);
    }

    public ForPurchasesScreen tapOnLoyaltyCardsButton(){
        appiumUtils.waitForElement(8).click(LOYALTY_CARDS_BUTTON);
        return this;
    }

    public ForPurchasesScreen tapOnBackButton(){
        appiumUtils.click(BACK_BUTTON);
        return this;
    }
}
