package pages.userprofilescreens.purchasesscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import root.DeviceManager;

public class ConnectCardScreen extends AbstractScreen {

    public ConnectCardScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    @AndroidFindBy(id = "ru.x5.scango:id/edNumber")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement PHONE_NUMBER_FIELD;

    @AndroidFindBy(id = "ru.x5.scango:id/btnLink")
    @iOSXCUITFindBy(accessibility = "Найти")
    private WebElement FIND_PHONE_BUTTON;


    //Methods
    public ConnectCardScreen addPhoneOrCardNumber(String phoneNumber){
        appiumUtils.sendText(PHONE_NUMBER_FIELD, phoneNumber);
        return this;
    }

    public ConnectCardScreen tapOnFindPhoneNumber(){
        appiumUtils.click(FIND_PHONE_BUTTON);
        return this;
    }

    private void setSms(String sms){
        WebElement element;
        for(int i=0; i<=3; i++){
            if(device.executionOS.equals(DeviceManager.OS.IOS)) {
                element = appiumUtils.findElementByXpath("//XCUIElementTypeApplication[@name=\"E.S. STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField["+(i+1)+"]");
            }else {
                element = appiumUtils.findElementByXpath("//*[@class='android.widget.EditText' and @index='"+i+"']");
            }
            appiumUtils.sendText(element, sms).waitForElement(2);
        }
    }

    public ConnectCardScreen setSmsCode(String sms) {
        try{
            setSms(sms);
        }catch (NoSuchElementException | StaleElementReferenceException e){
            e.printStackTrace();
//            tapOnFindPhoneNumber();
            setSms(sms);
        }
        appiumUtils.waitForElement(10);
        return this;
    }
//
//    public static void main(String[] args) {
////creating an instance of an array
//        int[] arr = {78, 34, 1, 3, 90, 34, -1, -4, 6, 55, 20, -65};
//        System.out.println("Array elements after sorting:");
////sorting logic
////        for (int i = 0; i < arr.length; i++)
////        {
////            for (int j = i + 1; j < arr.length; j++)
////            {
////                int tmp = 0;
////                if (arr[i] < arr[j])
////                {
////                    tmp = arr[i];
////                    arr[i] = arr[j];
////                    arr[j] = tmp;
////                }
////            }
//////prints the sorted element of the array
////            System.out.println(arr[i]);
////        }
//        for(int i =0; i<arr.length-1; i++){
//                int sort=0;
//                if(arr[i]<arr[i+1]){
//                    sort = arr[i];
//                    arr[i]=arr[i+1];
//                    arr[i+1]=sort;
//                    i = -1;
//                }
//        }
//        for(int i=0; i<arr.length; i++){
//            System.out.println("arr["+i+"] = "+arr[i]);
//        }
//    }
}