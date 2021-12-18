package root;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;

public class DeviceManager {

    public OS executionOS = OS.IOS;
    public enum OS {
        ANDROID,
        IOS,
    }

    DesiredCapabilities capabilities = new DesiredCapabilities();

    protected void deviceController() {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/ScannerApps");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoDissmissAlerts", true);

        switch(executionOS){
            case ANDROID:
                File app = new File (appDir, "mobile-preRelease-release.apk");
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_30_x86");
                capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ru.x5.scango");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "x5.selfscan.feature.activity.MainActivity");
                break;

            case IOS:
                app = new File (appDir, "selfscan.app");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                capabilities.setCapability(MobileCapabilityType.VERSION, "14.5");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "ru.x5.selfscan");
                capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
                capabilities.setCapability("autoDissmissAlerts", "true");
                break;

            default:
                System.out.println("Wrong device is connected, check capabilities.");
        }
    }
}