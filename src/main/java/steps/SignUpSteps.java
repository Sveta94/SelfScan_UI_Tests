package steps;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import pages.AbstractScreen;
import pages.enterappscreens.LoginScreen;
import pages.enterappscreens.PasswordScreen;
import pages.enterappscreens.SignUpScreen;
import pages.mainscreens.MainScreen;
import root.DeviceManager;
import utils.AppiumUtils;

public class SignUpSteps extends AbstractScreen {

    LoginScreen loginScreen;
    AppiumUtils appiumUtils;
    SignUpScreen signUpScreen;
    PasswordScreen passwordScreen;
    MainScreen mainScreen;

    public SignUpSteps(AppiumDriver driver) {
        super(driver);
        loginScreen = new LoginScreen(driver);
        appiumUtils = new AppiumUtils(driver);
        signUpScreen = new SignUpScreen(driver);
        passwordScreen = new PasswordScreen(driver);
        mainScreen = new MainScreen(driver);
    }

    int phoneNumber = (int) ((Math.random() * 9000000) + 1000000);

    public void createNewUser(String userName, String birthDate, String email){
        loginScreen.setPhoneNumber("915" + phoneNumber);
        loginScreen.tapOnSubmitButton()
                .setSmsCode("1");
        appiumUtils.waitForElement(3);
        signUpScreen.setUserName(userName)
                .setUserBirthDate(birthDate)
                .setUserEmail(email);
        hideKeyboard();
        signUpScreen.enableCheckBoxes()
                .tapOnCreateUserButton();
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            try {
                mainScreen.tapOnAllowWhileUsingAppButton();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
    }
}