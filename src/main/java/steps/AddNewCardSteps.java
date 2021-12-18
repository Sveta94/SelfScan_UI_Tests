package steps;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import pages.AbstractScreen;
import pages.userprofilescreens.purchasesscreens.AddNewCardScreen;
import pages.userprofilescreens.purchasesscreens.PaymentMethodsScreen;
import root.DeviceManager;

public class AddNewCardSteps extends AbstractScreen {

    PaymentMethodsScreen paymentMethodsScreen;
    AddNewCardScreen addNewCardScreen;
    public AddNewCardSteps(AppiumDriver driver) {
        super(driver);
        paymentMethodsScreen = new PaymentMethodsScreen(driver);
        addNewCardScreen = new AddNewCardScreen(driver);
    }

    public void addNewCard(String cardNumber, String cardDate, String cardCVV){
        try{
            paymentMethodsScreen.tapOnAddNewCardButton();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            paymentMethodsScreen.tapOnPayWithOtherCardButton()
                    .tapOnAddNewCardButton();
        }
        appiumUtils.waitForElement(8);
        addNewCardScreen.setNewCardNumber(cardNumber)
                .setNewCardDate(cardDate)
                .setNewCardCVV(cardCVV);
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            addNewCardScreen.tapOnReadyButton();
        }else {
            appiumUtils.hideKeyboard();
        }
        addNewCardScreen.tapOnPayButton();
    }
}