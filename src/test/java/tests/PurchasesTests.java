package tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mainscreens.MainScreen;
import pages.shoppingscreens.EnterBarCodeScreen;
import pages.shoppingscreens.FindQRScreen;
import pages.shoppingscreens.StartShoppingScreen;
import pages.userprofilescreens.ProfileScreen;
import pages.userprofilescreens.PurchasesScreen;
import pages.userprofilescreens.purchasesscreens.*;
import root.TestDriver;
import steps.AddNewCardSteps;
import steps.FindBarCodeSteps;
import steps.LoginSteps;
import utils.ApiUtils;

import java.io.IOException;

public class PurchasesTests extends TestDriver {

    LoginSteps loginSteps;
    MainScreen mainScreen;
    ProfileScreen profileScreen;
    SoftAssert softAssert;
    PaymentMethodsScreen paymentMethodsScreen;
    AddNewCardSteps addNewCardSteps;
    CardSecureCodeScreen cardSecureCodeScreen;
    ApiUtils apiUtils;
    StartShoppingScreen startShoppingScreen;
    FindBarCodeSteps findBarCodeSteps;
    EnterBarCodeScreen enterBarCodeScreen;
    EditCardsScreen editCardsScreen;
    PurchasesScreen purchasesScreen;
    FindQRScreen findQRScreen;
    ForPurchasesScreen forPurchasesScreen;
    AddNewCardScreen addNewCardScreen;

    @BeforeMethod
    public void setupTest() {
        loginSteps = new LoginSteps(driver);
        mainScreen = new MainScreen(driver);
        profileScreen = new ProfileScreen(driver);
        softAssert = new SoftAssert();
        paymentMethodsScreen = new PaymentMethodsScreen(driver);
        addNewCardSteps = new AddNewCardSteps(driver);
        cardSecureCodeScreen = new CardSecureCodeScreen(driver);
        apiUtils = new ApiUtils();
        startShoppingScreen = new StartShoppingScreen(driver);
        findBarCodeSteps = new FindBarCodeSteps(driver);
        enterBarCodeScreen = new EnterBarCodeScreen(driver);
        editCardsScreen = new EditCardsScreen(driver);
        purchasesScreen = new PurchasesScreen(driver);
        findQRScreen = new FindQRScreen(driver);
        forPurchasesScreen = new ForPurchasesScreen(driver);
        addNewCardScreen = new AddNewCardScreen(driver);
    }

    @Ignore
    @Test
    public void testAddCreditCard(){
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnPaymentMethodsButton();
        addNewCardSteps.addNewCard("5555555555555599", "12/24", "123");
        softAssert.assertTrue(paymentMethodsScreen.isAddedCardDisplayed());
        addNewCardSteps.addNewCard("3530111333300000", "12/24", "123");
        try{
            cardSecureCodeScreen.setCardSourceCode("12345678");
        }catch (NoSuchElementException e){
            e.printStackTrace();
            addNewCardScreen.tapOnPayButton();
            cardSecureCodeScreen.setCardSourceCode("12345678");
        }
        paymentMethodsScreen.tapOnAddedCardOption()
                .tapOnBackButton();
        softAssert.assertEquals(forPurchasesScreen.getCardText(), "• • • • 0000");
        forPurchasesScreen.tapOnPaymentMethodsButton();
        paymentMethodsScreen.tapOnEditButton();
        editCardsScreen.deleteCard(0).deleteCard(0);
        softAssert.assertAll();
    }

    @Ignore
    @Test
    public void addProductsToCardTest() throws IOException {
        apiUtils.scanEnterQR(apiUtils.authorizationAPI());
        loginSteps.loginStepsWithSMS("9152932655", "1");
        if(executionOS.equals(OS.ANDROID)) {
            mainScreen.tapOnStartShoppingButton();
            startShoppingScreen.tapOnUnderstandButton();
        }
        findBarCodeSteps.findWithBarCode("3850104424069");
        softAssert.assertEquals(startShoppingScreen.getProductsCount(), "1");
//        findBarCodeSteps.findWithBarCode("4607001776420");
//        softAssert.assertEquals(startShoppingScreen.getProductsCount(), "2");
//        findBarCodeSteps.findWithBarCode("4607195850531");
//        softAssert.assertEquals(startShoppingScreen.getProductsCount(), "3");
//        findBarCodeSteps.findWithBarCode("2930841040195");
//        softAssert.assertEquals(enterBarCodeScreen.getItemNotFoundError(), "Это товар с уценкой! Попробуйте купить его на кассе (Код ошибки: 208 )");
//        enterBarCodeScreen.tapOnBackButton();
//        startShoppingScreen.tapOnPackagesButton()
//                .tapOnAddPackageButton()
        startShoppingScreen.payForShopping();
        apiUtils.scanExitQR(apiUtils.authorizationAPI());
//                .setQR("6e71f27f-f65d-48f2-b2c6-9b5ed535c64a")
        startShoppingScreen.tapOnChooseCardButton();
        //...
    }

    @Test
    public void testDeleteCreditCard() {
        loginSteps.loginStepsWithSMS("9155025143", "1");
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnForPurchasesButton();
        forPurchasesScreen.tapOnPaymentMethodsButton();
        addNewCardSteps.addNewCard("5555555555555599", "12/24", "123");
        if(executionOS.equals(OS.IOS)) {
            paymentMethodsScreen.tapOnBackButton();
            forPurchasesScreen.tapOnPaymentMethodsButton();
        }
        Assert.assertTrue(paymentMethodsScreen.isAddedCardDisplayed());
        paymentMethodsScreen.tapOnEditButton();
        editCardsScreen.deleteCard(0);
        Assert.assertEquals(paymentMethodsScreen.getCardOptionsCount(), 4);
    }

    @Test
    public void testMyPurchases() {
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnUserProfile();
        profileScreen.tapOnOrdersButton();
        purchasesScreen.tapOnLastPurchase();
        Assert.assertTrue(purchasesScreen.isPurchasePaidDateDisplayed());
    }

    @Test
    public void testWhereToFindQR() {
        loginSteps.loginStepsWithSMS("9152932655", "1");
        mainScreen.tapOnStartShoppingButton();
        startShoppingScreen.tapOnFindQRButton();
        softAssert.assertEquals(findQRScreen.getFindQrScreenTitle(), "Где найти QR-код?");
        findQRScreen.tapOnBackToScanQRButton();
        softAssert.assertEquals(startShoppingScreen.getScanQRText(), startShoppingScreen.scanText());
        startShoppingScreen.tapOnGoToMainScreenButton();
        softAssert.assertEquals(mainScreen.getMainScreenTitle(), "Как работает Экспресс-скан?");
        softAssert.assertAll();
    }
}