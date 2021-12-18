package pages.userprofilescreens.purchasesscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class CardSecureCodeScreen extends AbstractScreen {

    public CardSecureCodeScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='1' and @resource-id = 'password']")
    //    @iOSXCUITFindBy()
    private WebElement CARD_PASSWORD_FIELD;


    //Methods
    public CardSecureCodeScreen setCardSourceCode(String sourceCode){
        appiumUtils.sendText(CARD_PASSWORD_FIELD, sourceCode);
        appiumUtils.waitForElement(5);
        return this;
    }
}