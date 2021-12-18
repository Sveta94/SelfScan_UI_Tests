package pages.userprofilescreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class AboutAppScreen extends AbstractScreen {

    public AboutAppScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/ivGlobalScanLogo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeImage")
    private WebElement APP_LOGO;

    @AndroidFindBy(id = "ru.x5.scango:id/ivX5Logo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeImage")
    private WebElement X5_LOGO;

    @AndroidFindBy(id = "ru.x5.scango:id/tvVersion")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText' and @index = '2']")
    private WebElement APP_VERSION;

    @AndroidFindBy(id = "ru.x5.scango:id/btnTeamBoard")
    @iOSXCUITFindBy(accessibility = "Команда Экспресс-скан")
    private WebElement TEAM_BOARD_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvAboutApp")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText' and @index = '4']")
    private WebElement ABOUT_APP_TEXT;

    @AndroidFindBy(id = "ru.x5.scango:id/btnPersonalDataPolicy")
    @iOSXCUITFindBy(accessibility = "Политика обработки перс. данных")
    private WebElement PERSONAL_DATE_POLICY_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/btnTermsOfUse")
    @iOSXCUITFindBy(accessibility = "Пользовательское соглашение")
    private WebElement TERMS_OF_USE_BUTTON;


    //Methods
    public boolean isAppLogoVisible(){
        return appiumUtils.isDisplayed(APP_LOGO);
    }

    public boolean isX5LogoVisible(){
        return appiumUtils.isDisplayed(X5_LOGO);
    }

    public boolean isAppVersionVisible(){
        return appiumUtils.isDisplayed(APP_VERSION);
    }

    public boolean isTeamBoardButtonEnabled(){
        return appiumUtils.isEnabled(X5_LOGO);
    }

    public String getAboutAppText(){
        return appiumUtils.getText(ABOUT_APP_TEXT);
    }

    public boolean isPersonalDatePolicyButtonEnabled(){
        return appiumUtils.isEnabled(PERSONAL_DATE_POLICY_BUTTON);
    }

    public boolean isTermsOfUseButtonEnabled(){
        return appiumUtils.isEnabled(TERMS_OF_USE_BUTTON);
    }

    public void tapOnPersonalDatePolicyButton(){
        appiumUtils.click(PERSONAL_DATE_POLICY_BUTTON);
    }

    public void tapOnTeamBoardButton(){
        appiumUtils.click(TEAM_BOARD_BUTTON);
    }

    public void tapOnTermsOfUseButton(){
        appiumUtils.click(TERMS_OF_USE_BUTTON);
    }
}