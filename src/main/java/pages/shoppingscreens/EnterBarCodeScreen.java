package pages.shoppingscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class EnterBarCodeScreen extends AbstractScreen {

    public EnterBarCodeScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/edBarcode")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement BAR_CODE_FIELD;

    @AndroidFindBy(id = "ru.x5.scango:id/searchItemButton")
    @iOSXCUITFindBy(accessibility = "Найти товар")
    private WebElement SEARCH_ITEM_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/ivBack")
    //    @iOSXCUITFindBy()
    private WebElement BACK_BUTTON;


    //Methods
    public EnterBarCodeScreen setBarCode(String barCode){
        appiumUtils.sendText(BAR_CODE_FIELD, barCode);
        return this;
    }

    public EnterBarCodeScreen tapOnSearchItemButton(){
        appiumUtils.click(SEARCH_ITEM_BUTTON);
        return this;
    }

    public EnterBarCodeScreen tapOnBackButton(){
        appiumUtils.click(BACK_BUTTON);
        return this;
    }
}