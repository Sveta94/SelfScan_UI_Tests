package pages.mainscreens;

import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

public class MapScreen extends AbstractScreen {

    public MapScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/ivMinus")
    @iOSXCUITFindBy(accessibility = "minusIcon")
    private WebElement ZOOM_MINUS;

    @AndroidFindBy(id = "ru.x5.scango:id/btnRetry")
//    @iOSXCUITFindBy()
    private WebElement RETRY_MAP_BUTTON;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @index='3']")
    @iOSXCUITFindBy(accessibility = "Москва")
    private WebElement CITY_TITLE;

    @AndroidFindBy(id = "ru.x5.scango:id/ivTCX")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    private WebElement TCX_NUMBER;

    @AndroidFindBy(id = "ru.x5.scango:id/ivTC5")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    private WebElement TC5_NUMBER;

    @AndroidFindBy(id = "ru.x5.scango:id/etSearch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement STORE_SEARCH_FIELD;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private WebElement STORE_SEARCH_FIELD2;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView' and @index='0' and @resource-id = 'ru.x5.scango:id/ivLogo']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]")
    private WebElement STORE_LOGO;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeImage")
    private WebElement SWIPE_BUTTON;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement MAP_ITEM;


    //Methods
    public MapScreen zoomOutMap(int zoomCount){
        for (int i = 0; i <= zoomCount; i++) {
            appiumUtils.click(ZOOM_MINUS);
        }
        return this;
    }

    public MapScreen tapOnRetryButton(){
        appiumUtils.waitForElement(5);
        appiumUtils.click(RETRY_MAP_BUTTON);
        return this;
    }

    public boolean isCityTitleVisible(){
        return appiumUtils.isDisplayed(CITY_TITLE);
    }

    public MapScreen tapOnCityListButton(){
        appiumUtils.waitForElement(20);
        appiumUtils.click(CITY_TITLE);
        return this;
    }

    public MapScreen swipeMapRightLeft(){
//        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
//            appiumUtils.swipeElementIOS(MAP_ITEM, Direction.LEFT);
//            appiumUtils.swipeElementIOS(MAP_ITEM, Direction.RIGHT);
//            appiumUtils.swipeElementIOS(MAP_ITEM, Direction.LEFT);
//            appiumUtils.swipeElementIOS(MAP_ITEM, Direction.LEFT);
//        }else {
//        }
            appiumUtils.swipeMapLeft().swipeMapRight()
                    .swipeLeft().swipeLeft();
        return this;
    }

    public boolean isTCXNumberButtonDisplayed(){
        return appiumUtils.isDisplayed(TCX_NUMBER);
    }

    public boolean isTC5NumberButtonDisplayed(){
        return appiumUtils.isDisplayed(TC5_NUMBER);
    }

    public boolean isTCXNumberButtonSelected(){
        return appiumUtils.isSelected(TCX_NUMBER);
    }

    public boolean isTC5NumberButtonSelected(){
        return appiumUtils.isSelected(TC5_NUMBER);
    }

    public String getStoreName(){
        return appiumUtils.getText(CITY_TITLE);
    }

    public MapScreen findStore(String storeName){
        try {
            appiumUtils.sendText(STORE_SEARCH_FIELD, storeName).waitForElement(5);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            appiumUtils.sendText(STORE_SEARCH_FIELD2, storeName).waitForElement(5);
        }
        return this;
    }

    public boolean isStoreLogoVisible(){
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            appiumUtils.hideKeyboard().swipeElementIOS(SWIPE_BUTTON, Direction.UP);
        }
        return appiumUtils.isDisplayed(STORE_LOGO);
    }

    public void filterTC5(){
        appiumUtils.click(TC5_NUMBER);
    }

    public void filterTCX(){
        appiumUtils.click(TCX_NUMBER);
    }
}