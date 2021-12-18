package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.feedbackscreens.FeedBackScreen;
import pages.feedbackscreens.PhotoScreen;
import pages.feedbackscreens.StoresScreen;
import pages.mainscreens.MainScreen;
import pages.userprofilescreens.ProfileScreen;
import pages.userprofilescreens.purchasesscreens.ForPurchasesScreen;
import root.TestDriver;
import steps.LoginSteps;

public class FeedBackTests extends TestDriver {

    LoginSteps loginSteps;
    MainScreen mainScreen;
    ProfileScreen profileScreen;
    SoftAssert softAssert;
    FeedBackScreen feedBackScreen;
    StoresScreen storesScreen;
    PhotoScreen photoScreen;
    ForPurchasesScreen forPurchasesScreen;

    @BeforeMethod
    public void setupTest() {
        loginSteps = new LoginSteps(driver);
        mainScreen = new MainScreen(driver);
        profileScreen = new ProfileScreen(driver);
        softAssert = new SoftAssert();
        feedBackScreen = new FeedBackScreen(driver);
        storesScreen = new StoresScreen(driver);
        photoScreen = new PhotoScreen(driver);
        forPurchasesScreen = new ForPurchasesScreen(driver);
    }

    @Test
    public void callTest(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnFeedBackButton();
        feedBackScreen.tapOnCallButton();
        softAssert.assertEquals(feedBackScreen.getTCXNumber(), "88002009555");
        softAssert.assertEquals(feedBackScreen.getTC5Number(), "88005555505");
        softAssert.assertAll();
    }

    @Test
    public void testFAQ(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnFeedBackButton();
        feedBackScreen.tapOnFAQButton();
        softAssert.assertEquals(feedBackScreen.getFAQPageTitle(), "Вопросы и ответы");
        if(executionOS.equals(OS.IOS)) {
            softAssert.assertEquals(feedBackScreen.getFAQInfoText1iOS(), "Как покупать через приложение?");
            softAssert.assertEquals(feedBackScreen.getFAQInfoText2iOS(), "Как купить весовой товар?");
            softAssert.assertEquals(feedBackScreen.getFAQInfoText3iOS(), "Что делать если цена неправильная?");
            softAssert.assertEquals(feedBackScreen.getFAQInfoText4iOS(), "Как списывать баллы?");
            softAssert.assertEquals(feedBackScreen.getFAQInfoText5iOS(), "Что могу купить?");
        } else {
            softAssert.assertEquals(feedBackScreen.getFAQPageContentItemByIndex(0), "Как покупать через приложение?");
            softAssert.assertEquals(feedBackScreen.getFAQPageContentItemByIndex(1), "Как купить весовой товар?");
            softAssert.assertEquals(feedBackScreen.getFAQPageContentItemByIndex(2), "Что делать если цена неправильная?");
            softAssert.assertEquals(feedBackScreen.getFAQPageContentItemByIndex(3), "Как списывать баллы?");
            softAssert.assertEquals(feedBackScreen.getFAQPageContentItemByIndex(4), "Что могу купить?");
            feedBackScreen.tapOnFAQPageContentItemByIndex(0);
            softAssert.assertTrue(feedBackScreen.isFAQPageContentIsDisplayedByIndex()==1);
            feedBackScreen.tapOnFAQPageContentItemByIndex(0);
            feedBackScreen.tapOnFAQPageContentItemByIndex(1);
            softAssert.assertTrue(feedBackScreen.isFAQPageContentIsDisplayedByIndex()==1);
            feedBackScreen.tapOnFAQPageContentItemByIndex(1);
            feedBackScreen.tapOnFAQPageContentItemByIndex(2);
            softAssert.assertTrue(feedBackScreen.isFAQPageContentIsDisplayedByIndex()==1);
            feedBackScreen.tapOnFAQPageContentItemByIndex(2);
            feedBackScreen.tapOnFAQPageContentItemByIndex(3);
            softAssert.assertTrue(feedBackScreen.isFAQPageContentIsDisplayedByIndex()==1);
            feedBackScreen.tapOnFAQPageContentItemByIndex(3);
            feedBackScreen.tapOnFAQPageContentItemByIndex(4);
            softAssert.assertTrue(feedBackScreen.isFAQPageContentIsDisplayedByIndex()==1);
            feedBackScreen.tapOnFAQPageContentItemByIndex(4);
            softAssert.assertAll();
        }
    }

    @Test
    public void testFeedBackProfileValues(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        String userPhoneNumber = profileScreen.getUserPhoneNumber();
        String userName = profileScreen.getUserNAme();
        profileScreen.tapOnForPurchasesButton();
        String userEmail = forPurchasesScreen.getUserEmail();
        forPurchasesScreen.tapOnBackButton();
        try{
            mainScreen.tapOnFeedBackButton();
        }catch (Exception e){
            e.printStackTrace();
            try{
                profileScreen.tapOnRateNotNowButton();
            }catch (Exception ex){
                ex.printStackTrace();
            }
            mainScreen.tapOnFeedBackButton();
        }
        if (!executionOS.equals(OS.IOS)) {
            softAssert.assertEquals(userPhoneNumber, feedBackScreen.getUserPhoneNumber());
        }
        softAssert.assertEquals(userEmail, feedBackScreen.getUserEmail());
        softAssert.assertEquals(userName, feedBackScreen.getUserName());
        softAssert.assertAll();
    }

    @Test
    public void testLastVisitedStore(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnFeedBackButton();
        feedBackScreen.tapOnOpenLastVisitedStore();
        if (executionOS.equals(OS.ANDROID)) {
            storesScreen.tapOnStoresButton()
                    .selectMoscowCity()
                    .tapOnSubmitSelectedCity();
        }else {
            storesScreen.tapOnStoresButton()
                    .tapOnSubmitSelectedCity();
        }
        softAssert.assertTrue(storesScreen.isTCXNumberButtonDisplayed());
        softAssert.assertTrue(storesScreen.isTC5NumberButtonDisplayed());
        storesScreen.tapOnTCXNumberButton();
        softAssert.assertTrue(storesScreen.isIvLogoDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void testSendFeedback(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnFeedBackButton();
        feedBackScreen.setFeedbackText("Bananas are not fresh")
                .tapOnAttachPhotoButton();
        if (executionOS.equals(OS.ANDROID)) {
            feedBackScreen.tapOnMakePhotoButton();
            photoScreen.tapOnTakePhotoButton()
                    .tapOnSubmitPhotoButton();
            feedBackScreen.tapOnAttachPhotoButton()
                    .tapOnChoosePhotoButton();
            photoScreen.selectImage()
                    .tapOnDoneButton();
            softAssert.assertEquals(feedBackScreen.getAttachedPhotosSize(), 3);
            feedBackScreen.tapOnSendFeedbackButton();
            softAssert.assertEquals(feedBackScreen.getThanksForFeedbackText(), "Обращение отправлено!\n" +
                    "Обычно рассмотрение обращения занимает один рабочий день");
        }else {
            feedBackScreen.tapOnChoosePhotoButton();
            photoScreen.selectImage()
                    .tapOnDoneButton();
            feedBackScreen.tapOnSendFeedbackButton();
        }
        softAssert.assertAll();
    }
}