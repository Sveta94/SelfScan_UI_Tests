package steps;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import pages.AbstractScreen;
import pages.enterappscreens.LoginScreen;
import pages.enterappscreens.OnboardingScreen;
import pages.enterappscreens.PasswordScreen;
import pages.mainscreens.MainScreen;
import root.DeviceManager;
import utils.ApiUtils;
import utils.AppiumUtils;

public class LoginSteps extends AbstractScreen {

    LoginScreen loginScreen;
    OnboardingScreen onboardingScreen;
    AppiumUtils appiumUtils;
    PasswordScreen passwordScreen;
    ApiUtils apiUtils;
    MainScreen mainScreen;

    public LoginSteps(AppiumDriver driver) {
        super(driver);
        loginScreen = new LoginScreen(driver);
        onboardingScreen = new OnboardingScreen(driver);
        appiumUtils = new AppiumUtils(driver);
        passwordScreen = new PasswordScreen(driver);
        apiUtils = new ApiUtils();
        mainScreen = new MainScreen(driver);
    }

    public void loginSteps(String phoneNumber, String password){
        onboardingScreen.tapOnSkipOnboardingButton();
        appiumUtils.waitForElement(7);
        loginScreen.setPhoneNumber(phoneNumber);
        loginScreen.tapOnSubmitButton()
                .tapOnWithPasswordButton();
        passwordScreen.setPassword(password)
                .tapOnEnterApp();
    }

    private void loginStep(String phoneNumber, String sms){
        try {
            loginScreen.setPhoneNumber(phoneNumber);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            loginScreen.tapOnTryAgain()
                .setPhoneNumber(phoneNumber);
        }
        loginScreen.tapOnSubmitButton()
                .setSmsCode(sms);
        appiumUtils.waitForElement(3);
    }

    public void loginStepsWithSMS(String phoneNumber, String sms){
        try{
            onboardingScreen.tapOnSkipOnboardingButton();
        }catch (Exception e){
            e.printStackTrace();
            loginScreen.tapOnTryAgainButton();
        }
        appiumUtils.waitForElement(8);
        loginStep(phoneNumber, sms);
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            try{
                mainScreen.tapOnAllowWhileUsingAppButton();
            }catch (NoSuchElementException e){
                e.printStackTrace();
                try{
                    loginScreen.tapOnReadyButton()
                            .tapOnTryAgain();
                    appiumUtils.waitForElement(3);
                    loginStep(phoneNumber, sms);
                }catch (NoSuchElementException er){
                    er.printStackTrace();
                    try{
                        mainScreen.tapOnAllowWhileUsingAppButton();
                    }catch (NoSuchElementException exception){
                        exception.printStackTrace();
                    }
                }

            }
        }
    }
}