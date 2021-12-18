package pages.shoppingscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

public class StartShoppingScreen extends AbstractScreen {

    public StartShoppingScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/tvManualBarcode")
    @iOSXCUITFindBy(accessibility = "Ввод штрихкода")
    private WebElement MANUAL_BAR_CODE_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnUnderstand")
    //    @iOSXCUITFindBy()
    private WebElement UNDERSTAND_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvProductsCount")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText' and @index='1' and @x='127']")
    private WebElement PRODUCTS_COUNT;

    @AndroidFindBy(id = "ru.x5.scango:id/btnPackages")
    @iOSXCUITFindBy(accessibility = "Пакеты")
    private WebElement PACKAGES_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView' and @resource-id = 'ru.x5.scango:id/ivQuantityIncrease']")
    //    @iOSXCUITFindBy()
    private WebElement ADD_PACKAGE_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView' and @index = '3' and @resource-id = 'ru.x5.scango:id/ivClose']")
    @iOSXCUITFindBy(accessibility = "closeStoreDetailsIcon")
    private WebElement CLOSE_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnPay")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")
    private WebElement PAY_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnPay")
    @iOSXCUITFindBy(accessibility = "Продолжить")
    private WebElement CONTINUE_PAY_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup' and @index='1' and @resource-id = 'ru.x5.scango:id/clContent']")
    //    @iOSXCUITFindBy()
    private WebElement CHOOSE_CARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnFindQr")
    @iOSXCUITFindBy(accessibility = "Где найти QR-код?")
    private WebElement FIND_QR_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/scanHeaderView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Отсканируйте QR-код «Старт»\"]")
    private WebElement SCAN_QR_TEXT;

    @AndroidFindBy(id = "ru.x5.scango:id/tvStart")
    @iOSXCUITFindBy(accessibility = "На главную")
    private WebElement MAIN_SCREEN_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/cameraContainer")
    //    @iOSXCUITFindBy()
    private WebElement QR_FIELD;


    //Methods
    public StartShoppingScreen tapOnManualBarCodeButton(){
        appiumUtils.click(MANUAL_BAR_CODE_BUTTON);
        return this;
    }

    public StartShoppingScreen tapOnUnderstandButton(){
        appiumUtils.click(UNDERSTAND_BUTTON);
        return this;
    }

    public String getProductsCount(){
        return appiumUtils.getText(PRODUCTS_COUNT);
    }

    public StartShoppingScreen tapOnPackagesButton(){
        appiumUtils.click(PACKAGES_BUTTON);
        return this;
    }

    public StartShoppingScreen tapOnAddPackageButton(){
        appiumUtils.click(ADD_PACKAGE_BUTTON).waitForElement(10)
                .click(CLOSE_BUTTON).waitForElement(2);
        return this;
    }

    public StartShoppingScreen payForShopping(){
        appiumUtils.click(PAY_BUTTON).click(CONTINUE_PAY_BUTTON).waitForElement(10);
        return this;
    }

    public StartShoppingScreen tapOnChooseCardButton(){
        appiumUtils.click(CHOOSE_CARD_BUTTON);
        return this;
    }

    public StartShoppingScreen tapOnFindQRButton(){
        appiumUtils.click(FIND_QR_BUTTON);
        return this;
    }

    public String getScanQRText(){
        return appiumUtils.getText(SCAN_QR_TEXT);
    }

    public String scanText(){
        String text;
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            text = "Отсканируйте QR-код «Старт»";
        }else {
            text = "Отсканируйте\n" +
                    "QR-код Старт";
        }
        return text;
    }

    public StartShoppingScreen tapOnGoToMainScreenButton(){
        appiumUtils.click(MAIN_SCREEN_BUTTON);
        return this;
    }

    public StartShoppingScreen setQR(String qrCode){
        appiumUtils.sendTextActions(QR_FIELD, qrCode);
        return this;
    }
}