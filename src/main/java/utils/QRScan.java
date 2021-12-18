package utils;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRScan {

    AppiumDriver driver;
    AppiumUtils appiumUtils;
    public QRScan (AppiumDriver driver) {
        this.driver = driver;
        appiumUtils = new AppiumUtils(driver);
    }

    private BufferedImage generateImage(WebElement element, File screenshot) throws IOException {

        BufferedImage fullImage = ImageIO.read(screenshot);
        Point imageLocation = element.getLocation();

        int qrCodeImageWidth = element.getSize().getWidth();
        int qrCodeImageHeight = element.getSize().getHeight();
        int pointXPosition = imageLocation.getX();
        int pointYPosition = imageLocation.getY();

        BufferedImage qrCodeImage = fullImage.getSubimage(pointXPosition, pointYPosition, qrCodeImageWidth, qrCodeImageHeight);
        ImageIO.write(qrCodeImage, "png", screenshot);

        return qrCodeImage;
    }

    private static String decodeQRCode(BufferedImage qrCodeImage) throws NotFoundException, com.google.zxing.NotFoundException {
        LuminanceSource source = new BufferedImageLuminanceSource(qrCodeImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }

    public String readQRCode(String id) throws IOException, NotFoundException, com.google.zxing.NotFoundException {
        WebElement qrCodeElement = appiumUtils.findElementById(id);
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        String content = decodeQRCode(generateImage(qrCodeElement, screenshot));
        System.out.println("content = " + content);
        return content;
    }
}