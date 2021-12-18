package pages.userprofilescreens.purchasesscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;
import java.util.List;

public class EditCardsScreen extends AbstractScreen {

    public EditCardsScreen(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "deletePaymentMethodIcon")
    private WebElement DELETE_BUTTON;

    //Methods
    public EditCardsScreen deleteCard(int index){
        if(device.executionOS.equals(DeviceManager.OS.ANDROID)) {
            List<WebElement> cards = appiumUtils.findElementsById("ru.x5.scango:id/methodsView");
            WebElement card = cards.get(index).findElement(By.xpath("//*[@class='android.widget.ImageView' and @index='3' and @resource-id ='ru.x5.scango:id/deleteView']"));
            appiumUtils.click(card).waitForElement(5);
        }else {
            appiumUtils.click(DELETE_BUTTON);
        }
        appiumUtils.waitForElement(10);
        return this;
    }
}