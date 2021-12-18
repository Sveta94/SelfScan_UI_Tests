package pages.enterappscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;

public class AuthorizationScreen extends AbstractScreen {

    public AuthorizationScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/tvDialogTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Авторизуйтесь, чтобы продолжить\"]")
    private WebElement AUTHORIZATION_PAGE_TITLE;

    @AndroidFindBy(id = "ru.x5.scango:id/btnMainAction")
    @iOSXCUITFindBy(accessibility = "Авторизоваться")
    private WebElement AUTHORIZE_BUTTON;

    @AndroidFindBy(id = "ru.x5.scango:id/tvClose")
    private WebElement AUTHORIZE_LATTER_BUTTON;

    //Methods
    public String getAuthorizationPageTitle(){

        return appiumUtils.getText(AUTHORIZATION_PAGE_TITLE);
    }

    public AuthorizationScreen tapOnAuthorizeButton(){
        appiumUtils.click(AUTHORIZE_BUTTON);
        return this;
    }

    public AuthorizationScreen tapOnAuthorizeLatterButton(){
        appiumUtils.click(AUTHORIZE_LATTER_BUTTON);
        return this;
    }
}