package pages.feedbackscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

import java.util.List;

public class FeedBackScreen extends AbstractScreen {

    public FeedBackScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/ivCall")
    @iOSXCUITFindBy(accessibility = "callIcon")
    private WebElement CALL_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvTCX")
    @iOSXCUITFindBy(accessibility = "88002009555")
    private WebElement TCX_NUMBER;

    @AndroidFindBy(id = "ru.x5.scango:id/tvTC5")
    @iOSXCUITFindBy(accessibility = "88005555505")
    private WebElement TC5_NUMBER;

    @AndroidFindBy(id = "ru.x5.scango:id/tvFAQ")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Частые вопросы и ответы\"]")
    private WebElement FAQ_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvTitle")
    @iOSXCUITFindBy(accessibility = "Вопросы и ответы")
    private WebElement FAQ_PAGE_TITLE;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView' and @resource-id = 'ru.x5.scango:id/tvQuestion']")
//    @iOSXCUITFindBy()
    private WebElement FAQ_PAGE_CONTENT;

    @AndroidFindBy(id = "ru.x5.scango:id/edUserName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement USER_NAME;

    @AndroidFindBy(id = "ru.x5.scango:id/edUserPhone")
    private WebElement USER_PHONE_NUMBER;

    @AndroidFindBy(id = "ru.x5.scango:id/edUserEmail")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement USER_EMAIL;

    @AndroidFindBy(id = "ru.x5.scango:id/etLastStore")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    private WebElement LAST_VISITED_STORE;

    @AndroidFindBy(id = "ru.x5.scango:id/edFeedback")
    @iOSXCUITFindBy(accessibility = "Текст обращения")
    private WebElement FEEDBACK_FIELD;

    @AndroidFindBy(id = "ru.x5.scango:id/ivPhoto")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[8]/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther")
    private WebElement ATTACH_PHOTO_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvMakePhoto")
    @iOSXCUITFindBy(accessibility = "Сделать фото")
    private WebElement MAKE_PHOTO_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvChoosePhoto")
    @iOSXCUITFindBy(accessibility = "Выбрать из галереи")
    private WebElement CHOOSE_PHOTO_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnSend")
    @iOSXCUITFindBy(accessibility = "Отправить")
    private WebElement SEND_FEEDBACK_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvThanks")
    private WebElement THANKS_FEEDBACK_TEXT;

    @iOSXCUITFindBy(accessibility = "Как покупать через приложение?")
    private WebElement FAQ_INFO_TEXT_1;

    @iOSXCUITFindBy(accessibility = "Как купить весовой товар?")
    private WebElement FAQ_INFO_TEXT_2;

    @iOSXCUITFindBy(accessibility = "Что делать если цена неправильная?")
    private WebElement FAQ_INFO_TEXT_3;

    @iOSXCUITFindBy(accessibility = "Как списывать баллы?")
    private WebElement FAQ_INFO_TEXT_4;

    @iOSXCUITFindBy(accessibility = "Что могу купить?")
    private WebElement FAQ_INFO_TEXT_5;


    //Methods
    public FeedBackScreen tapOnCallButton(){
        appiumUtils.click(CALL_BUTTON);
        return this;
    }

    public String getTCXNumber(){
        return appiumUtils.getText(TCX_NUMBER);
    }

    public String getTC5Number(){
        return appiumUtils.getText(TC5_NUMBER);

    }

    public FeedBackScreen tapOnFAQButton(){
        appiumUtils.click(FAQ_BUTTON);
        return this;
    }

    public String getFAQPageTitle(){
        return appiumUtils.getText(FAQ_PAGE_TITLE);
    }

    public String getFAQPageContentItemByIndex(int index){
        List<WebElement> contentItem = appiumUtils.findElementsById("ru.x5.scango:id/tvQuestion");
        return contentItem.get(index).getText();
    }

    public int isFAQPageContentIsDisplayedByIndex(){
        List<WebElement> contentItem = appiumUtils.findElementsById("ru.x5.scango:id/tvAnswer");
        return contentItem.size();
    }

    public FeedBackScreen tapOnFAQPageContentItemByIndex(int index){
        List<WebElement> contentItem = appiumUtils.findElementsById("ru.x5.scango:id/tvQuestion");
        contentItem.get(index).click();
        return this;
    }

    public String getUserName(){
        return appiumUtils.getText(USER_NAME);
    }

    public String getUserEmail(){
        return appiumUtils.getText(USER_EMAIL);
    }

    public String getUserPhoneNumber(){
        return appiumUtils.getText(USER_PHONE_NUMBER);
    }

    public FeedBackScreen tapOnOpenLastVisitedStore(){
        appiumUtils.click(LAST_VISITED_STORE);
        return this;
    }

    public FeedBackScreen setFeedbackText(String feedbackText){
        appiumUtils.sendText(FEEDBACK_FIELD, feedbackText);
        hideKeyboard();
        return this;
    }

    public FeedBackScreen tapOnAttachPhotoButton(){
        appiumUtils.click(ATTACH_PHOTO_BUTTON);
        return this;
    }

    public FeedBackScreen tapOnMakePhotoButton(){
        appiumUtils.click(MAKE_PHOTO_BUTTON)
                .switchTo();
        return this;
    }

    public FeedBackScreen tapOnChoosePhotoButton(){
        appiumUtils.click(CHOOSE_PHOTO_BUTTON)
                .switchTo();
        return this;
    }

    public int getAttachedPhotosSize(){
        List<WebElement> attach = appiumUtils.findElementsByXpath("//*[@class='android.widget.ImageView' and @resource-id = 'ru.x5.scango:id/ivPhoto' and @index='0']");
        return attach.size();
    }

    public FeedBackScreen tapOnSendFeedbackButton(){
        appiumUtils.click(SEND_FEEDBACK_BUTTON);
        return this;
    }

    public String getThanksForFeedbackText(){
        return appiumUtils.getText(THANKS_FEEDBACK_TEXT);
    }

    public String getFAQInfoText1iOS(){
        return appiumUtils.getText(FAQ_INFO_TEXT_1);
    }

    public String getFAQInfoText2iOS(){
        return appiumUtils.getText(FAQ_INFO_TEXT_1);
    }

    public String getFAQInfoText3iOS(){
        return appiumUtils.getText(FAQ_INFO_TEXT_1);
    }

    public String getFAQInfoText4iOS(){
        return appiumUtils.getText(FAQ_INFO_TEXT_1);
    }

    public String getFAQInfoText5iOS(){
        return appiumUtils.getText(FAQ_INFO_TEXT_1);
    }
}