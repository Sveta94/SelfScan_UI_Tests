package pages.shoppingscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class FindQRScreen extends AbstractScreen {

    public FindQRScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/titleView")
    @iOSXCUITFindBy(accessibility = "Где найти QR-код?")
    private WebElement TITLE_TEXT;

    @AndroidFindBy(id = "ru.x5.scango:id/btnBackToScanQR")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeOther' and @index='3']")
    private WebElement BACK_TO_SCAN_QR_BUTTON;


    //Methods
    public String getFindQrScreenTitle(){
        return appiumUtils.getText(TITLE_TEXT);
    }

    public FindQRScreen tapOnBackToScanQRButton(){
        appiumUtils.click(BACK_TO_SCAN_QR_BUTTON);
        return this;
    }
}