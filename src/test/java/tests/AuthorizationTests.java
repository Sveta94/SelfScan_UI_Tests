package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.enterappscreens.AuthorizationScreen;
import pages.enterappscreens.LoginScreen;
import pages.enterappscreens.OnboardingScreen;
import pages.enterappscreens.PasswordScreen;
import pages.mainscreens.MainScreen;
import pages.userprofilescreens.ProfileScreen;
import pages.userprofilescreens.purchasesscreens.ForPurchasesScreen;
import root.TestDriver;
import steps.LoginSteps;
import steps.SignUpSteps;
import utils.AppiumUtils;

import java.util.Locale;

public class AuthorizationTests extends TestDriver {
    
    LoginSteps loginSteps;
    MainScreen mainScreen;
    ProfileScreen profileScreen;
    LoginScreen loginScreen;
    OnboardingScreen onboardingScreen;
    AppiumUtils appiumUtils;
    PasswordScreen passwordScreen;
    SignUpSteps signUpSteps;
    AuthorizationScreen authorizationScreen;
    SoftAssert softAssert;
    ForPurchasesScreen forPurchasesScreen;

    @BeforeMethod
    public void setupTest() {
        loginSteps = new LoginSteps(driver);
        mainScreen = new MainScreen(driver);
        profileScreen = new ProfileScreen(driver);
        loginScreen = new LoginScreen(driver);
        onboardingScreen = new OnboardingScreen(driver);
        appiumUtils = new AppiumUtils(driver);
        passwordScreen = new PasswordScreen(driver);
        signUpSteps = new SignUpSteps(driver);
        authorizationScreen = new AuthorizationScreen(driver);
        softAssert = new SoftAssert();
        forPurchasesScreen = new ForPurchasesScreen(driver);
    }

    @Ignore
    @Test
    public void testAuthorization(){
        loginSteps.loginSteps("9152932655", "Qwerty012345678");
        mainScreen.tapOnUserProfile();
        Assert.assertEquals(profileScreen.getUserPhoneNumber(), profileScreen.phoneNumber());
    }

    @Test
    public void testAuthorizationWithSMS(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        Assert.assertEquals(profileScreen.getUserPhoneNumber(), profileScreen.phoneNumber());
    }

    @Ignore
    @Test //deprecated functionality
    public void testForgetPassword(){
        onboardingScreen.tapOnSkipOnboardingButton();
        loginScreen.setPhoneNumber("9152932655");
        appiumUtils.hideKeyboard();
        loginScreen.tapOnSubmitButton()
                .tapOnWithPasswordButton()
                .tapOnForgetPasswordButton()
                .setSmsCode("1");
        passwordScreen.setNewPassword("Qwerty012345678")
                .repeatNewPassword("Qwerty012345678")
                .tapOnSubmitPasswordButton();
        mainScreen.tapOnUserProfile();
        Assert.assertEquals(profileScreen.getUserPhoneNumber(), profileScreen.phoneNumber());
    }

    @Test
    public void testGoBackFromAuthorization()  {
        onboardingScreen.tapOnSkipOnboardingButton();
        loginScreen.setPhoneNumber("9152932655");
        loginScreen.tapOnSubmitButton()
                .tapOnBackButton();
        try{
            Assert.assertEquals(loginScreen.getLoginScreenTitle(), "Вход с помощью X5ID");
        }catch (NoSuchElementException e){
            e.printStackTrace();
            loginScreen.tapOnTryAgainButton();
            Assert.assertEquals(loginScreen.getLoginScreenTitle(), "Вход с помощью X5ID");
        }
    }

    @Test
    public void testLogout(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnLogOutButton();
        Assert.assertEquals(loginScreen.getLoginScreenTitle(), "Вход с помощью X5ID");
    }

    @Test
    public void testNewUser() {
        Faker fakerRu = new Faker(new Locale("ru"));
        Faker fakerEng = new Faker(new Locale("eng"));
        String userName = fakerRu.name().firstName();
        String emailName = fakerEng.name().firstName();
        String userEmail = emailName.toLowerCase() + "@autotest.com";
        onboardingScreen.tapOnSkipOnboardingButton();
        signUpSteps.createNewUser(userName, "10.12.1994", userEmail);
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        if(executionOS.equals(OS.IOS)) {
            Assert.assertEquals(appiumUtils.getText(appiumUtils.findElementByXpath("//XCUIElementTypeStaticText[@name=\"" +userEmail+"\"]")), userEmail);
        }else {
            Assert.assertEquals(forPurchasesScreen.getUserEmail(), userEmail);
        }
    }

    @Test
    public void testSkipAuthorization(){
        onboardingScreen.tapOnSkipOnboardingButton();
        loginScreen.tapOnSkipAuthorizationButton();
        try{
            mainScreen.tapOnUserProfile();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            loginScreen.tapOnSkipAuthorizationButton();
            mainScreen.tapOnUserProfile();
        }
        if(executionOS.equals(OS.ANDROID)) {
            softAssert.assertEquals(authorizationScreen.getAuthorizationPageTitle(), "Авторизуйтесь,\n" + "чтобы продолжить");
        }else {
            softAssert.assertEquals(authorizationScreen.getAuthorizationPageTitle(), "Авторизуйтесь, чтобы продолжить");
        }
        authorizationScreen.tapOnAuthorizeButton();
        softAssert.assertEquals(loginScreen.getLoginScreenTitle(), "Вход с помощью X5ID");
        if(executionOS.equals(OS.ANDROID)) {
            loginScreen.tapOnSkipAuthorizationButton();
            mainScreen.tapOnUserProfile();
            authorizationScreen.tapOnAuthorizeLatterButton();
            softAssert.assertTrue(mainScreen.isStartShoppingButtonDisplayed());
        }
        softAssert.assertAll();
    }
}