package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.enterappscreens.LoginScreen;
import pages.enterappscreens.OnboardingScreen;
import root.DeviceManager;
import root.TestDriver;

public class OnboardingTests extends TestDriver {

    OnboardingScreen onboardingScreen;
    LoginScreen loginScreen;

    @BeforeMethod
    public void setupTest() {
        onboardingScreen = new OnboardingScreen(driver);
        loginScreen = new LoginScreen(driver);
    }

    @Test
    public void pressDotsOnboardingTest(){
        if(executionOS.equals(DeviceManager.OS.IOS)) {
            onboardingScreen.tapOnNextButtonToReachLoginPage();
        }else {
            onboardingScreen.tapOnAllDots()
                    .tapOnNextButton();
        }
        Assert.assertEquals(loginScreen.getLoginScreenTitle(), "Вход с помощью X5ID");
    }

    @Test
    public void pressNextButtonToReachLoginPageTest(){
        onboardingScreen.tapOnNextButtonToReachLoginPage();
        Assert.assertEquals(loginScreen.getLoginScreenTitle(), "Вход с помощью X5ID");
    }

    @Test
    public void skipOnboardingTest(){
        onboardingScreen.tapOnSkipOnboardingButton();
        Assert.assertEquals(loginScreen.getLoginScreenTitle(), "Вход с помощью X5ID");
    }

    @Test
    public void swipeOnboardingTest(){
        onboardingScreen.swipeOnboarding()
                .tapOnNextButton();
        Assert.assertEquals(loginScreen.getLoginScreenTitle(), "Вход с помощью X5ID");
    }
}