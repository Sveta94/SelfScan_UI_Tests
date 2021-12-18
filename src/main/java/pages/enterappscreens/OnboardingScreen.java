package pages.enterappscreens;

import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

public class OnboardingScreen extends AbstractScreen {

    public OnboardingScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/tvCloseOnBoarding")
    @iOSXCUITFindBy(accessibility = "Пропустить")
    private WebElement SKIP_ONBOARDING_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/ivNext")
    @iOSXCUITFindBy(accessibility = "arrowWhite")
    private WebElement NEXT_BUTTON;

    @iOSXCUITFindBy(accessibility = "storiesCloseIcon")
    private WebElement CLOSE_NOTIFICATION_SCREEN;

    @iOSXCUITFindBy(accessibility = "Повторить")
    private WebElement TRY_AGAIN_BUTTON;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeImage")
    private WebElement ONBOARDING_SCREEN_IMAGE;


    //Methods
    public OnboardingScreen tapOnSkipOnboardingButton(){
        appiumUtils.waitForElement(10);
        try{
            appiumUtils.click(SKIP_ONBOARDING_BUTTON);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            if(device.executionOS.equals(DeviceManager.OS.IOS)) {
                appiumUtils.click(TRY_AGAIN_BUTTON);
            }
            appiumUtils.waitForElement(2)
                    .click(SKIP_ONBOARDING_BUTTON);
        }
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            appiumUtils.click(CLOSE_NOTIFICATION_SCREEN);
        }
        return this;
    }

    public OnboardingScreen tapOnAllDots(){
        appiumUtils.waitForElement(5);
        for(int i=0; i<8; i++){
            WebElement element = appiumUtils.findElementByXpath("//*[@class='androidx.appcompat.app.ActionBar$b' and @index='" + i + "']");
            appiumUtils.click(element);
        }
        return this;
    }

    public OnboardingScreen tapOnNextButtonToReachLoginPage(){
        appiumUtils.waitForElement(5);
        for(int i=0; i<8; i++){
            tapOnNextButton();
        }
        return this;
    }

    public OnboardingScreen tapOnNextButton(){
        appiumUtils.click(NEXT_BUTTON);
        return this;
    }

    public OnboardingScreen swipeOnboarding(){
        appiumUtils.waitForElement(5);
        for(int i=0; i<8; i++){
            if(device.executionOS.equals(DeviceManager.OS.IOS)) {
                appiumUtils.swipeElementIOS(ONBOARDING_SCREEN_IMAGE, Direction.LEFT);
            }else {
                appiumUtils.swipeLeft();
            }
        }
        return this;
    }
}