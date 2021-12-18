package pages.userprofilescreens.purchasesscreens;

import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

public class LoyaltyCardsScreen extends AbstractScreen {

    public LoyaltyCardsScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/btnAddCard")
    @iOSXCUITFindBy(accessibility = "Подключить карту")
    private WebElement ADD_CARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnAddCard")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]")
    private WebElement ADD_FRIENDS_CARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnRelease")
    @iOSXCUITFindBy(accessibility = "Выпустить")
    private WebElement RELEASE_CARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnBind")
    @iOSXCUITFindBy(accessibility = "Привязать")
    private WebElement BIND_CARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnLink")
    @iOSXCUITFindBy(accessibility = "Привязать")
    private WebElement LINK_CARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvTitle")
    @iOSXCUITFindBy(accessibility = "Карта «Перекрёстка»")
    private WebElement CARD_TITLE;

    @AndroidFindBy(id = "ru.x5.scango:id/tvTitle")
    @iOSXCUITFindBy(accessibility = "Карта «Пятёрочки»")
    private WebElement CARD_TITLE2;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView' and @resource-id = 'ru.x5.scango:id/ivCard' and @index='0']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView")
    private WebElement CARD_VIEW;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @resource-id = 'ru.x5.scango:id/tvDescription' and @index='1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Используйте Экспресс-скан, чтобы получать и тратить баллы.\"]")
    private WebElement CARD_DESCRIPTION;

    @AndroidFindBy(xpath = "//*[@class='androidx.appcompat.app.ActionBar$b' and @index='1']")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypePageIndicator")
    private WebElement NEXT_CARD_BUTTON;

    //XCUIElementTypeApplication[@name="E.S. STAGE"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypePageIndicator


    @AndroidFindBy(xpath = "//*[@class='androidx.appcompat.app.ActionBar$b' and @index='0']")
    //    @iOSXCUITFindBy()
    private WebElement PREVIEWS_CARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnDeleteCard")
    @iOSXCUITFindBy(accessibility = "Удалить")
    private WebElement DELETE_CARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnDelete")
    private WebElement DELETE_CARD_CONFIRM;

    @AndroidFindBy(id = "ru.x5.scango:id/btnChangeLinkType")
    @iOSXCUITFindBy(accessibility = "Найти по номеру карты")
    private WebElement BY_CARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Как добавить карту?\"]")
    private WebElement ADD_FRIENDS_CARD_TITLE;

    @AndroidFindBy(id = "ru.x5.scango:id/tvDescription")
    private WebElement ADD_FRIENDS_CARD_DESCRIPTION;

    @AndroidFindBy(id = "ru.x5.scango:id/btnOk")
    @iOSXCUITFindBy(accessibility = "Мне понятно")
    private WebElement UNDERSTAND_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnCancel")
    @iOSXCUITFindBy(accessibility = "Отмена")
    private WebElement CANCEL_DELETE_BUTTON;

//    @AndroidFindBy()
    @iOSXCUITFindBy(accessibility = "Назад")
    private WebElement BACK_BUTTON;


    //Methods
    public LoyaltyCardsScreen tapOnAddCardButton(){
        appiumUtils.click(ADD_CARD_BUTTON);
        return this;
    }

    public LoyaltyCardsScreen tapOnAddFriendsCardButton(){
        appiumUtils.click(ADD_FRIENDS_CARD_BUTTON);
        return this;
    }

    public LoyaltyCardsScreen tapOnReleaseCardButton(){
        appiumUtils.click(RELEASE_CARD_BUTTON);
        return this;
    }

    public LoyaltyCardsScreen tapOnBindCardButton(){
        appiumUtils.click(BIND_CARD_BUTTON);
        return this;
    }

    public LoyaltyCardsScreen tapOnLinkCardButton(){
        appiumUtils.click(LINK_CARD_BUTTON);
        return this;
    }

    public String getCardTitle(){
        return appiumUtils.getText(CARD_TITLE);
    }

    public String getCardTitle2(){
        return appiumUtils.getText(CARD_TITLE2);
    }

    public boolean isCardViewVisible(){
        return appiumUtils.waitForElement(5).isDisplayed(CARD_VIEW);
    }

    public String getCardDescription(){
        return appiumUtils.getText(CARD_DESCRIPTION);
    }

    public String cardDescription() {
        String text = "";
        if (device.executionOS.equals(DeviceManager.OS.ANDROID)) {
            text = "Используйте Экспресс-скан, чтобы получать и тратить баллы";
        }else {
            text = "Используйте Экспресс-скан, чтобы получать и тратить баллы.";
        }
        return text;
    }

    public boolean isAddFriendsCardButtonVisible(){
        return appiumUtils.isDisplayed(ADD_FRIENDS_CARD_BUTTON);
    }

    public LoyaltyCardsScreen tapOnAddNextCardButton(){
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            appiumUtils.swipeElementIOS(CARD_VIEW, Direction.LEFT);
        }else {
            appiumUtils.click(NEXT_CARD_BUTTON);
        }
        return this;
    }

    public LoyaltyCardsScreen tapOnAddPreviewsCardButton(){
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            appiumUtils.swipeElementIOS(CARD_VIEW, Direction.RIGHT);
        }else {
            appiumUtils.click(PREVIEWS_CARD_BUTTON);
        }
        return this;
    }

    public LoyaltyCardsScreen tapOnByCardNumberButton(){
        appiumUtils.click(BY_CARD_BUTTON);
        return this;
    }

    public LoyaltyCardsScreen deleteAttachedCard(){
        appiumUtils.click(DELETE_CARD_BUTTON);
        if(device.executionOS.equals(DeviceManager.OS.IOS)) {
            appiumUtils.getMultipleElementsWithSameXpathAndTapByIndex(1, "//XCUIElementTypeStaticText[@name=\"Удалить\"]")
                    .waitForElement(3);
        }else {
            appiumUtils.click(DELETE_CARD_CONFIRM)
                    .waitForElement(3);
        }
        appiumUtils.waitForElement(8);
        return this;
    }

    public String getAddFriendsCardTitle(){
        return appiumUtils.getText(ADD_FRIENDS_CARD_TITLE);
    }

    public boolean isAddFriendsCardDescriptionVisible(){
        return appiumUtils.isDisplayed(ADD_FRIENDS_CARD_DESCRIPTION);
    }

    public LoyaltyCardsScreen tapOnUnderstandButton(){
        appiumUtils.click(UNDERSTAND_BUTTON);
        return this;
    }

    public boolean isCancelDeleteButtonVisible(){
        return appiumUtils.isDisplayed(CANCEL_DELETE_BUTTON);
    }

    public LoyaltyCardsScreen tapOnDeleteCardButton(){
        appiumUtils.click(DELETE_CARD_BUTTON);
        return this;
    }

    public LoyaltyCardsScreen tapOnCancelDeleteButton(){
        appiumUtils.click(CANCEL_DELETE_BUTTON);
        return this;
    }

    public boolean isAddCardButtonVisible(){
        return appiumUtils.isDisplayed(ADD_CARD_BUTTON);
    }

    public LoyaltyCardsScreen tapOnBackFromCardsButton(){
        appiumUtils.click(BACK_BUTTON);
        return this;
    }
}