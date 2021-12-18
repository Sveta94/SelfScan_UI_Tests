package pages.userprofilescreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class PurchasesScreen extends AbstractScreen {

    public PurchasesScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @index='0' and @resource-id = 'ru.x5.scango:id/itemsCountText']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeCell' and @index='1']")
    private WebElement LAST_PURCHASE;

    @AndroidFindBy(id = "ru.x5.scango:id/tvPaidDate")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText' and @index='0' and @x='101']")
    private WebElement PURCHASE_STATUS;

    //Methods
    public PurchasesScreen tapOnLastPurchase(){
        appiumUtils.click(LAST_PURCHASE);
        return this;
    }

    public boolean isPurchasePaidDateDisplayed(){
        return appiumUtils.isDisplayed(PURCHASE_STATUS);
    }
}