package pages.userprofilescreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

import java.util.List;

public class AboutTeamScreen extends AbstractScreen {

    public AboutTeamScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/ivWhite")
    @iOSXCUITFindBy(accessibility = "Назад")
    private WebElement BACK_BUTTON;

    @iOSXCUITFindBy(accessibility = "Человек, который работает за четверых")
    private WebElement BACKEND_DEV;

    @iOSXCUITFindBy(accessibility = "Человек, который за ночь переписывает либы")
    private WebElement ANDROID_DEV;

    @iOSXCUITFindBy(accessibility = "Человек, который любит когда всё идеально")
    private WebElement IOS_DEV;


    //Methods
    private WebElement getTextByIndex(int index){
        List<WebElement> list = appiumUtils.findElementsById("ru.x5.scango:id/tvName");
        return list.get(index);
    }

    public String getBackendDevText(){
        String text = "";
        if(device.executionOS.equals(DeviceManager.OS.ANDROID)) {
            text = getTextByIndex(0).getText();
        }else {
            text = appiumUtils.getText(BACKEND_DEV);
        }
        return text;
    }

    public String getAndroidDevText(){
        String text = "";
        if(device.executionOS.equals(DeviceManager.OS.ANDROID)) {
            text = getTextByIndex(1).getText();
        }else {
            text = appiumUtils.getText(ANDROID_DEV);
        }
        return text;
    }

    public String getIosDevText(){
        String text = "";
        if(device.executionOS.equals(DeviceManager.OS.ANDROID)) {
            text = getTextByIndex(2).getText();
        }else {
            text = appiumUtils.getText(IOS_DEV);
        }
        return text;
    }

    public void tapOnBackButton(){
        appiumUtils.click(BACK_BUTTON);
    }
}