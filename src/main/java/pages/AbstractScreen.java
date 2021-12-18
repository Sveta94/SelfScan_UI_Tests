package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import root.DeviceManager;
import utils.AppiumUtils;

import java.time.Duration;

public abstract class AbstractScreen {

    protected AppiumUtils appiumUtils;
    protected DeviceManager device;

    public AbstractScreen(AppiumDriver driver){
        appiumUtils = new AppiumUtils(driver);
        device = new DeviceManager();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @iOSXCUITFindBy(accessibility = "Готово")
    private WebElement READY_KEYBOARD;
    public void hideKeyboard(){
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            appiumUtils.click(READY_KEYBOARD);
        }else {
            appiumUtils.hideKeyboard();
        }
    }
}