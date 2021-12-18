package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mainscreens.MainScreen;
import pages.userprofilescreens.AboutAppScreen;
import pages.userprofilescreens.AboutTeamScreen;
import pages.userprofilescreens.PersonalDatePolicyScreen;
import pages.userprofilescreens.ProfileScreen;
import pages.userprofilescreens.purchasesscreens.EmailScreen;
import pages.userprofilescreens.purchasesscreens.ForPurchasesScreen;
import root.TestDriver;
import steps.LoginSteps;

public class UserProfileTests extends TestDriver {

    LoginSteps loginSteps;
    MainScreen mainScreen;
    ProfileScreen profileScreen;
    SoftAssert softAssert;
    AboutAppScreen aboutAppScreen;
    EmailScreen emailScreen;
    PersonalDatePolicyScreen personalDatePolicyScreen;
    AboutTeamScreen aboutTeamScreen;
    ForPurchasesScreen forPurchasesScreen;

    @BeforeMethod
    public void setupTest() {
        loginSteps = new LoginSteps(driver);
        mainScreen = new MainScreen(driver);
        profileScreen = new ProfileScreen(driver);
        softAssert = new SoftAssert();
        aboutAppScreen = new AboutAppScreen(driver);
        emailScreen = new EmailScreen(driver);
        personalDatePolicyScreen = new PersonalDatePolicyScreen(driver);
        aboutTeamScreen = new AboutTeamScreen(driver);
        forPurchasesScreen = new ForPurchasesScreen(driver);
    }

    @Test
    public void aboutAppTest(){
        String aboutTextAndroid = "Экспресс-скан — новый сервис\n" +
                "от X5 Retail Group, с помощью которого\n" +
                "можно покупать продукты в сетях\n" +
                "Пятёрочка и Перекрёсток, оплачивать\n" +
                "их в приложении и выходить из магазина\n" +
                "без очередей и лишних контактов";
        String aboutTextIOS = "Экспресс-скан — новый сервис от X5 Retail Group, с помощью которого можно покупать продукты в сетях Пятёрочка и Перекрёсток, оплачивать их в приложении и выходить из магазина без очередей и лишних контактов";
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnAboutAppButton();
        softAssert.assertTrue(aboutAppScreen.isAppVersionVisible());
        softAssert.assertTrue(aboutAppScreen.isTeamBoardButtonEnabled());
        if(executionOS.equals(OS.ANDROID)) {
            softAssert.assertTrue(aboutAppScreen.isAppLogoVisible());
            softAssert.assertTrue(aboutAppScreen.isX5LogoVisible());
            softAssert.assertEquals(aboutAppScreen.getAboutAppText(), aboutTextAndroid);
        }else {
            softAssert.assertEquals(aboutAppScreen.getAboutAppText(), aboutTextIOS);
        }
        softAssert.assertTrue(aboutAppScreen.isPersonalDatePolicyButtonEnabled());
        softAssert.assertTrue(aboutAppScreen.isTermsOfUseButtonEnabled());
        softAssert.assertAll();
    }

    @Test
    public void changeEmailTest(){
        String userEmail = "newuser@gmail.com";
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnEmailButton();
        emailScreen.setNewEmail(userEmail)
                .tapOnSaveEmailButton();
        Assert.assertEquals(forPurchasesScreen.getUserEmail(), userEmail);
    }

    @Test
    public void personalDataPolicyTest(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnAboutAppButton();
        aboutAppScreen.tapOnPersonalDatePolicyButton();
        softAssert.assertTrue(personalDatePolicyScreen.isProjectorToolbarVisible());
        personalDatePolicyScreen.tapOnBackButton();
        softAssert.assertTrue(aboutAppScreen.isPersonalDatePolicyButtonEnabled());
        softAssert.assertTrue(aboutAppScreen.isTermsOfUseButtonEnabled());
        softAssert.assertAll();
    }

    @Test
    public void aboutTeamTest(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnAboutAppButton();
        aboutAppScreen.tapOnTeamBoardButton();
        String backendDevText = "Человек, который работает за четверых";
        softAssert.assertEquals(aboutTeamScreen.getBackendDevText(), backendDevText);
        String androidDevText = "Человек, который за ночь переписывает либы";
        softAssert.assertEquals(aboutTeamScreen.getAndroidDevText(), androidDevText);
        String iOSDevText = "Человек, который любит когда всё идеально";
        softAssert.assertEquals(aboutTeamScreen.getIosDevText(), iOSDevText);
        aboutTeamScreen.tapOnBackButton();
        softAssert.assertTrue(aboutAppScreen.isPersonalDatePolicyButtonEnabled());
        softAssert.assertTrue(aboutAppScreen.isTermsOfUseButtonEnabled());
        softAssert.assertAll();
    }

    @Test
    public void termsOfUseTest(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnAboutAppButton();
        aboutAppScreen.tapOnTermsOfUseButton();
        softAssert.assertTrue(personalDatePolicyScreen.isProjectorToolbarVisible());
        personalDatePolicyScreen.tapOnBackButton();
        softAssert.assertTrue(aboutAppScreen.isPersonalDatePolicyButtonEnabled());
        softAssert.assertTrue(aboutAppScreen.isTermsOfUseButtonEnabled());
        softAssert.assertAll();
    }
}