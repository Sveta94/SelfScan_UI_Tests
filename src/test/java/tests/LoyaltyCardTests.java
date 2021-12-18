package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.enterappscreens.OnboardingScreen;
import pages.mainscreens.MainScreen;
import pages.userprofilescreens.ProfileScreen;
import pages.userprofilescreens.purchasesscreens.ConnectCardScreen;
import pages.userprofilescreens.purchasesscreens.ForPurchasesScreen;
import pages.userprofilescreens.purchasesscreens.LoyaltyCardsScreen;
import root.TestDriver;
import steps.LoginSteps;
import steps.SignUpSteps;

import java.util.Locale;

public class LoyaltyCardTests extends TestDriver {

    LoginSteps loginSteps;
    MainScreen mainScreen;
    ProfileScreen profileScreen;
    SoftAssert softAssert;
    LoyaltyCardsScreen loyaltyCardsScreen;
    ConnectCardScreen connectCardScreen;
    OnboardingScreen onboardingScreen;
    SignUpSteps signUpSteps;
    ForPurchasesScreen forPurchasesScreen;

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
    }

    @Test
    public void testAttachLoyaltyCard(){
        loginSteps.loginStepsWithSMS("9157900305", "1"); //Josef012345678
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnLoyaltyCardsButton();
        loyaltyCardsScreen.tapOnAddCardButton()
                .tapOnReleaseCardButton()
                .tapOnLinkCardButton();
        softAssert.assertEquals(loyaltyCardsScreen.getCardTitle(), "Карта «Перекрёстка»");
        softAssert.assertTrue(loyaltyCardsScreen.isCardViewVisible());
        if(executionOS.equals(OS.ANDROID)) {
            softAssert.assertEquals(loyaltyCardsScreen.getCardDescription(), "Используйте Экспресс-скан, чтобы получать и тратить баллы");
        }
        softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardButtonVisible());
        loyaltyCardsScreen.deleteAttachedCard()
                .tapOnAddNextCardButton()
                .tapOnAddCardButton()
                .tapOnReleaseCardButton()
                .tapOnLinkCardButton();
        softAssert.assertEquals(loyaltyCardsScreen.getCardTitle2(), "Карта «Пятёрочки»");
        softAssert.assertTrue(loyaltyCardsScreen.isCardViewVisible());
        if(executionOS.equals(OS.ANDROID)) {
            softAssert.assertEquals(loyaltyCardsScreen.getCardDescription(), "Используйте Экспресс-скан, чтобы получать и тратить баллы");
        }
        softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardButtonVisible());
        loyaltyCardsScreen.deleteAttachedCard();
        softAssert.assertAll();
    }

    @Test
    public void testFindCardsByPhoneNumber(){
        loginSteps.loginStepsWithSMS("9168787878", "1"); //Qwerty012345678
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnLoyaltyCardsButton();
        loyaltyCardsScreen.tapOnAddCardButton()
                .tapOnBindCardButton();
        connectCardScreen.addPhoneOrCardNumber("9168787878")
                .tapOnFindPhoneNumber()
                .setSmsCode("1");
        softAssert.assertEquals(loyaltyCardsScreen.getCardTitle(), "Карта «Перекрёстка»");
        softAssert.assertTrue(loyaltyCardsScreen.isCardViewVisible());
        if(executionOS.equals(OS.ANDROID)) {
            softAssert.assertEquals(loyaltyCardsScreen.getCardDescription(), "Используйте Экспресс-скан, чтобы получать и тратить баллы");
        }
        softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardButtonVisible());
        loyaltyCardsScreen.deleteAttachedCard()
                .tapOnAddNextCardButton()
                .tapOnAddCardButton()
                .tapOnBindCardButton();
        connectCardScreen.addPhoneOrCardNumber("9168787878")
                .tapOnFindPhoneNumber()
                .setSmsCode("1");
        if(executionOS.equals(OS.ANDROID)) {
            loyaltyCardsScreen.tapOnAddPreviewsCardButton();
            softAssert.assertEquals(loyaltyCardsScreen.getCardDescription(), "Используйте Экспресс-скан, чтобы получать и тратить баллы");
        }
        softAssert.assertEquals(loyaltyCardsScreen.getCardTitle2(), "Карта «Пятёрочки»");
        softAssert.assertTrue(loyaltyCardsScreen.isCardViewVisible());
        softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardButtonVisible());
        loyaltyCardsScreen.deleteAttachedCard();
        softAssert.assertAll();
    }

    @Test
    public void testFindTC5CardByNumber() {
        loginSteps.loginStepsWithSMS("9155025143", "1"); //Qwerty012345678
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnLoyaltyCardsButton();
        loyaltyCardsScreen.tapOnAddNextCardButton()
                .tapOnAddCardButton()
                .tapOnBindCardButton()
                .tapOnByCardNumberButton();
        connectCardScreen.addPhoneOrCardNumber("7789770000386367")
                .tapOnFindPhoneNumber()
                .setSmsCode("1");
        softAssert.assertEquals(loyaltyCardsScreen.getCardTitle2(), "Карта «Пятёрочки»");
        softAssert.assertTrue(loyaltyCardsScreen.isCardViewVisible());
        softAssert.assertEquals(loyaltyCardsScreen.getCardDescription(), loyaltyCardsScreen.cardDescription());
        softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardButtonVisible());
        loyaltyCardsScreen.deleteAttachedCard();
        softAssert.assertAll();
    }

    @Test
    public void testFindTCXCardByNumber() {
        loginSteps.loginStepsWithSMS("9155553333", "1"); //Qwerty012345678
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnLoyaltyCardsButton();
        loyaltyCardsScreen.tapOnAddCardButton()
                .tapOnBindCardButton()
                .tapOnByCardNumberButton();
        connectCardScreen.addPhoneOrCardNumber("7789777018512702")
                .tapOnFindPhoneNumber()
                .setSmsCode("1");
        softAssert.assertEquals(loyaltyCardsScreen.getCardTitle(), "Карта «Перекрёстка»");
        softAssert.assertTrue(loyaltyCardsScreen.isCardViewVisible());
        softAssert.assertEquals(loyaltyCardsScreen.getCardDescription(), loyaltyCardsScreen.cardDescription());
        softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardButtonVisible());
        loyaltyCardsScreen.deleteAttachedCard();
        softAssert.assertAll();
    }

    @Test
    public void testHowToAddFriendsCard() {
        loginSteps.loginStepsWithSMS("9152932655", "1"); //Qwerty012345678
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnLoyaltyCardsButton();
        if(executionOS.equals(OS.IOS)) {
            loyaltyCardsScreen.tapOnAddFriendsCardButton();
        }else {
            loyaltyCardsScreen.tapOnAddCardButton();
            softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardDescriptionVisible());
        }
        softAssert.assertEquals(loyaltyCardsScreen.getAddFriendsCardTitle(), "Как добавить карту?");
        loyaltyCardsScreen.tapOnUnderstandButton();
        try{
            Assert.assertEquals(loyaltyCardsScreen.getCardTitle2(), "Карта «Пятёрочки»");
        }catch (AssertionError | NoSuchElementException e){
            e.printStackTrace();
            Assert.assertEquals(loyaltyCardsScreen.getCardTitle(), "Карта «Перекрёстка»");
        }
        loyaltyCardsScreen.tapOnAddNextCardButton();
        if(executionOS.equals(OS.IOS)) {
            loyaltyCardsScreen.tapOnAddFriendsCardButton();
        }else {
            loyaltyCardsScreen.tapOnAddCardButton();
            softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardDescriptionVisible());
        }
        softAssert.assertEquals(loyaltyCardsScreen.getAddFriendsCardTitle(), "Как добавить карту?");
        loyaltyCardsScreen.tapOnUnderstandButton();
        try{
            Assert.assertEquals(loyaltyCardsScreen.getCardTitle(), "Карта «Перекрёстка»");
        }catch (AssertionError | NoSuchElementException e){
            e.printStackTrace();
            Assert.assertEquals(loyaltyCardsScreen.getCardTitle2(), "Карта «Пятёрочки»");
        }
        softAssert.assertAll();
    }

    @Test
    public void testLoyaltyCardsDelete(){
        loginSteps.loginStepsWithSMS("9157900305", "1"); //Josef012345678
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnLoyaltyCardsButton();
        loyaltyCardsScreen.tapOnAddCardButton()
                .tapOnReleaseCardButton()
                .tapOnLinkCardButton()
                .tapOnDeleteCardButton();
        softAssert.assertTrue(loyaltyCardsScreen.isCancelDeleteButtonVisible());
        loyaltyCardsScreen.tapOnCancelDeleteButton()
                .deleteAttachedCard();
        softAssert.assertTrue(loyaltyCardsScreen.isAddCardButtonVisible());
        loyaltyCardsScreen.tapOnAddNextCardButton()
                .tapOnAddCardButton()
                .tapOnReleaseCardButton()
                .tapOnLinkCardButton()
                .tapOnDeleteCardButton();
        softAssert.assertTrue(loyaltyCardsScreen.isCancelDeleteButtonVisible());
        loyaltyCardsScreen.tapOnCancelDeleteButton()
                .deleteAttachedCard();
        softAssert.assertTrue(loyaltyCardsScreen.isAddCardButtonVisible());
        softAssert.assertAll();
    }

    @Test
    public void testNewLoyaltyCard() {
        Faker fakerRu = new Faker(new Locale("ru"));
        Faker fakerEng = new Faker(new Locale("eng"));
        String userName = fakerRu.name().firstName();
        String emailName = fakerEng.name().firstName();
        String userEmail = emailName.toLowerCase() + "@autotest.com";
        onboardingScreen.tapOnSkipOnboardingButton();
        signUpSteps.createNewUser(userName, "10.12.1994", userEmail);
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnLoyaltyCardsButton();
        loyaltyCardsScreen.tapOnAddCardButton()
                .tapOnReleaseCardButton();
        softAssert.assertEquals(loyaltyCardsScreen.getCardTitle(), "Карта «Перекрёстка»");
        softAssert.assertTrue(loyaltyCardsScreen.isCardViewVisible());
        softAssert.assertEquals(loyaltyCardsScreen.getCardDescription(), loyaltyCardsScreen.cardDescription());
        softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardButtonVisible());
        loyaltyCardsScreen.deleteAttachedCard()
                .tapOnAddNextCardButton()
                .tapOnAddCardButton()
                .tapOnReleaseCardButton();
        softAssert.assertEquals(loyaltyCardsScreen.getCardTitle2(), "Карта «Пятёрочки»");
        softAssert.assertTrue(loyaltyCardsScreen.isCardViewVisible());
        softAssert.assertEquals(loyaltyCardsScreen.getCardDescription(), loyaltyCardsScreen.cardDescription());
        softAssert.assertTrue(loyaltyCardsScreen.isAddFriendsCardButtonVisible());
        loyaltyCardsScreen.deleteAttachedCard();
        softAssert.assertAll();
    }
}