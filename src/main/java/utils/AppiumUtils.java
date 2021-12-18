package utils;

import com.google.common.collect.ImmutableMap;
import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class AppiumUtils {

    AppiumDriver driver;
    Actions actions;
    public AppiumUtils(AppiumDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public AppiumUtils click(WebElement element){
        System.out.println("Trying to click on element: " + element);
        waitForElement(3);
        try{
            element.click();
        }catch (Exception e){
            e.printStackTrace();
            element.click();
        }
        System.out.println("Click on element: " + element);
        return this;
    }

    public AppiumUtils sendText(WebElement element, String text){
        System.out.println("Trying to send text to element: " + element);
        waitForElement(3);
        try {
            click(element);
//            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
            click(element);
//            element.clear();
            element.sendKeys(text);
        }
        System.out.println("Text sent to element: " + element);
        return this;
    }

    public AppiumUtils sendTextActions(WebElement element, String text){
        System.out.println("Trying to send text to element: " + element);
        waitForElement(3);
        try {
            click(element);
            actions.sendKeys(text).perform();
        }catch (Exception e){
            e.printStackTrace();
            click(element);
            actions.sendKeys(text).perform();
        }
        System.out.println("Text sent to element: " + element);
        return this;
    }

    public String getText(WebElement element){
        System.out.println("Trying to find element: " + element);
        waitForElement(3);
        return element.getText();
    }

    public boolean isEnabled(WebElement element){
        waitForElement(3);
        return element.isEnabled();
    }

    public boolean isDisplayed(WebElement element){
        waitForElement(3);
        return element.isDisplayed();
    }

    public boolean isSelected(WebElement element){
        waitForElement(3);
        return element.isSelected();
    }

    public AppiumUtils switchTo(){
        driver.switchTo();
        return this;
    }

    public AppiumUtils getMultipleElementsWithSameXpathAndTapByIndex(int index, String xpath){
        List<WebElement> list = findElementsByXpath(xpath);
        list.get(index).click();
        return this;
    }

    public AppiumUtils hideKeyboard(){
        driver.hideKeyboard();
        return this;
    }

    public void enterApp() {
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
    }

    public AppiumUtils waitForElement(int second){
        String  sec = second+"000";
        try {
            Thread.sleep(Integer.parseInt(sec));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return this;
    }

    public WebElement findElementByXpath(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }

    public WebElement findElementById(String id){
        WebElement element = driver.findElement(By.id(id));
        return element;
    }

    public List<WebElement> findElementsByXpath(String xpath){
        List<WebElement> element = driver.findElements(By.xpath(xpath));
        return element;
    }

    public List<WebElement> findElementsById(String id){
        List<WebElement> element = driver.findElements(By.id(id));
        return element;
    }

    public AppiumUtils scrollUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int endX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        (new TouchAction(driver))
                .longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
        return this;
    }

    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width /2;
        int endX = size.width /2;
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);
        (new TouchAction(driver))
                .longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    public AppiumUtils swipeLeft() {
        waitForElement(3);
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.9);
        int endX = (int) (size.width * 0.05);
        int startY = size.height / 2;
        (new TouchAction(driver))
                .press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, startY))
                .release().perform();
        return this;
    }

    public void swipeRight() {
        waitForElement(3);
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.05);
        int endX = (int) (size.width * 0.9);
        int startY = size.height / 2;
        (new TouchAction(driver))
                .press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, startY))
                .release().perform();
    }

    public AppiumUtils swipeMapLeft() {
        waitForElement(3);
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.7);
        int endX = (int) (size.width * 0.4);
        int startY = (int) (size.height * 0.65);
        (new TouchAction(driver))
                .longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, startY))
                .release().perform();
        return this;
    }

    public AppiumUtils swipeMapRight() {
        waitForElement(3);
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.4);
        int endX = (int) (size.width * 0.7);
        int startY = (int) (size.height * 0.65);
        (new TouchAction(driver))
                .longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, startY))
                .release().perform();
        return this;
    }

    public void swipeElementIOS(WebElement el, Direction dir) {
        System.out.println("swipeElementIOS(): dir: '" + dir + "'");
        final int ANIMATION_TIME = 200;
        final int PRESS_TIME = 500;

        Dimension dims = driver.manage().window().getSize();
        Rectangle rect = el.getRect();

        if (rect.x >= dims.width || rect.x + rect.width <= 0
                || rect.y >= dims.height || rect.y + rect.height <= 0) {
            throw new IllegalArgumentException("swipeElementIOS(): Element outside screen");
        }

        int leftBorder, rightBorder, upBorder, downBorder;
        leftBorder = 0;
        rightBorder = 0;
        upBorder = 0;
        downBorder = 0;

        if (rect.x < 0) {
            rect.width = rect.width + rect.x;
            rect.x = 0;
        }
        if (rect.y < 0) {
            rect.height = rect.height + rect.y;
            rect.y = 0;
        }
        if (rect.width > dims.width)
            rect.width = dims.width;
        if (rect.height > dims.height)
            rect.height = dims.height;

        PointOption pointOptionStart, pointOptionEnd;
        switch (dir) {
            case DOWN: // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + upBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - downBorder);
                break;
            case UP: // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - downBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + upBorder);
                break;
            case LEFT: // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - rightBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + leftBorder,
                        rect.y + rect.height / 2);
                break;
            case RIGHT: // from left to right
                pointOptionStart = PointOption.point(rect.x + leftBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - rightBorder,
                        rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementIOS(): dir: '" + dir + "' NOT supported");
        }

        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeElementIOS(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}