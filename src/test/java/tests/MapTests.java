package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.feedbackscreens.StoresScreen;
import pages.mainscreens.MainScreen;
import pages.mainscreens.MapScreen;
import pages.userprofilescreens.ProfileScreen;
import root.DeviceManager;
import root.TestDriver;
import steps.LoginSteps;

public class MapTests extends TestDriver {

    LoginSteps loginSteps;
    MainScreen mainScreen;
    ProfileScreen profileScreen;
    MapScreen mapScreen;
    StoresScreen storesScreen;
    SoftAssert softAssert;

    @BeforeMethod
    public void setupTest() {
        loginSteps = new LoginSteps(driver);
        mainScreen = new MainScreen(driver);
        profileScreen = new ProfileScreen(driver);
        mapScreen = new MapScreen(driver);
        storesScreen = new StoresScreen(driver);
        softAssert = new SoftAssert();
    }

    @Ignore
    @Test //deprecated functionality
    public void mapZoomOutTest(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnFullMapButton();
        mapScreen.tapOnRetryButton()
                .zoomOutMap(5);
        Assert.assertTrue(mapScreen.isCityTitleVisible());
    }

    @Test
    public void testSearchStoreOnMap(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnFullMapButton();
        if(executionOS.equals(OS.ANDROID)) {
            mapScreen.tapOnCityListButton();
            storesScreen.selectMoscowCityMap()
                    .tapOnSubmitSelectedCity();
        }
        softAssert.assertTrue(mapScreen.isTC5NumberButtonDisplayed());
        softAssert.assertTrue(mapScreen.isTCXNumberButtonDisplayed());
        mapScreen.findStore(mapScreen.getStoreName());
        softAssert.assertTrue(mapScreen.isStoreLogoVisible());
        mapScreen.findStore("TESTNQ");
        softAssert.assertTrue(mapScreen.isStoreLogoVisible());
        mapScreen.findStore("L615");
        softAssert.assertTrue(mapScreen.isStoreLogoVisible());
        softAssert.assertAll();
    }

    @Test
    public void testStoreFilter(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnFullMapButton();
        if(executionOS.equals(OS.ANDROID)) {
            mapScreen.tapOnCityListButton();
            storesScreen.selectMoscowCityMap()
                    .tapOnSubmitSelectedCity();
        }
        softAssert.assertTrue(mapScreen.isTC5NumberButtonDisplayed());
        softAssert.assertTrue(mapScreen.isTCXNumberButtonDisplayed());
        mapScreen.zoomOutMap(5)
                .filterTCX();
        softAssert.assertTrue(mapScreen.isTCXNumberButtonSelected());
        mapScreen.filterTC5();
        softAssert.assertTrue(mapScreen.isTC5NumberButtonSelected());
        softAssert.assertAll();
    }

    @Test
    public void testSwipeMap(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.swipeScreenRightLeft();
        mapScreen.swipeMapRightLeft();
        if(executionOS.equals(DeviceManager.OS.IOS)) {
            mainScreen.tapOnUserProfile();
        }
        Assert.assertEquals(profileScreen.getUserPhoneNumber(), profileScreen.phoneNumber());
    }
}