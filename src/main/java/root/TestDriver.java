package root;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestDriver extends DeviceManager {

    protected AppiumDriver<MobileElement> driver;

    @BeforeMethod
    protected void beforeMethod() {
        try {
            deviceController();
            this.driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            this.driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        } catch (Exception exp) {
            System.out.println("Cause is : " + exp.getCause());
            System.out.println("Message is : " + exp.getMessage());
            exp.printStackTrace();
        }
    }

    @AfterMethod
    protected void afterMethod(){
        try{
            driver.closeApp();
        }catch (Exception e){
            e.printStackTrace();
            driver.closeApp();
        }
        try{
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            driver.quit();
        }
    }
}