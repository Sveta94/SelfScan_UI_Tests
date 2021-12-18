package steps;

import io.appium.java_client.AppiumDriver;
import pages.AbstractScreen;
import pages.shoppingscreens.EnterBarCodeScreen;
import pages.shoppingscreens.StartShoppingScreen;

public class FindBarCodeSteps extends AbstractScreen {

    StartShoppingScreen startShoppingScreen;
    EnterBarCodeScreen enterBarCodeScreen;
    public FindBarCodeSteps(AppiumDriver driver) {
        super(driver);
        startShoppingScreen = new StartShoppingScreen(driver);
        enterBarCodeScreen = new EnterBarCodeScreen(driver);
    }

    public void findWithBarCode(String barCode){
        startShoppingScreen.tapOnManualBarCodeButton();
        enterBarCodeScreen.setBarCode(barCode)
                .tapOnSearchItemButton();
    }
}