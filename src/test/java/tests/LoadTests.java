package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.enterappscreens.LoginScreen;
import pages.enterappscreens.OnboardingScreen;
import pages.mainscreens.MainScreen;
import pages.userprofilescreens.ProfileScreen;
import pages.userprofilescreens.purchasesscreens.ConnectCardScreen;
import pages.userprofilescreens.purchasesscreens.ForPurchasesScreen;
import pages.userprofilescreens.purchasesscreens.LoyaltyCardsScreen;
import root.TestDriver;
import steps.LoginSteps;
import steps.SignUpSteps;
import utils.AppiumUtils;
import utils.ReadFile;

import java.util.ArrayList;

public class LoadTests extends TestDriver {

    LoginSteps loginSteps;
    MainScreen mainScreen;
    ProfileScreen profileScreen;
    SoftAssert softAssert;
    LoyaltyCardsScreen loyaltyCardsScreen;
    ConnectCardScreen connectCardScreen;
    OnboardingScreen onboardingScreen;
    SignUpSteps signUpSteps;
    ForPurchasesScreen forPurchasesScreen;
    AppiumUtils appiumUtils;
    LoginScreen loginScreen;

    @BeforeMethod
    public void setupTest() {
        loginSteps = new LoginSteps(driver);
        mainScreen = new MainScreen(driver);
        profileScreen = new ProfileScreen(driver);
        softAssert = new SoftAssert();
        loyaltyCardsScreen = new LoyaltyCardsScreen(driver);
        connectCardScreen = new ConnectCardScreen(driver);
        onboardingScreen = new OnboardingScreen(driver);
        signUpSteps = new SignUpSteps(driver);
        forPurchasesScreen = new ForPurchasesScreen(driver);
        appiumUtils = new AppiumUtils(driver);
        loginScreen = new LoginScreen(driver);
    }
    @Ignore
    @Test
    public void testAttachLoyaltyCardLoad(){
        ReadFile readFile = new ReadFile();
        String sms = "1";
        for(int index=0; index<readFile.listSize; index++){
            ArrayList phones = readFile.getPhone();
            String phoneNumber = String.valueOf(phones.get(index));
            if(index==0){
                loginSteps.loginStepsWithSMS(phoneNumber, sms);
            }else {
                appiumUtils.waitForElement(8);
                loginScreen.setPhoneNumber(phoneNumber);
                loginScreen.tapOnSubmitButton()
                        .setSmsCode(sms);
                appiumUtils.waitForElement(3);
            }
            mainScreen.tapOnUserProfile();
            try{
                profileScreen.tapOnForPurchasesButton();
            }catch (Exception e){
                e.printStackTrace();
                profileScreen.tapOnRateNotNowButton()
                        .tapOnForPurchasesButton();
            }
            forPurchasesScreen.tapOnLoyaltyCardsButton();
            loyaltyCardsScreen.tapOnAddNextCardButton()
                    .tapOnAddCardButton()
                    .tapOnReleaseCardButton()
                    .tapOnLinkCardButton();
            softAssert.assertEquals(loyaltyCardsScreen.getCardTitle(), "Карта «Пятёрочки»");
            softAssert.assertTrue(loyaltyCardsScreen.isCardViewVisible());
            softAssert.assertEquals(loyaltyCardsScreen.getCardDescription(), "Используйте Экспресс-скан, чтобы получать и тратить баллы");
            softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardButtonVisible());
            loyaltyCardsScreen.deleteAttachedCard()
                    .tapOnBackFromCardsButton();
            forPurchasesScreen.tapOnBackButton();
            profileScreen.tapOnLogOutButton();
            softAssert.assertAll();
        }
    }
}
