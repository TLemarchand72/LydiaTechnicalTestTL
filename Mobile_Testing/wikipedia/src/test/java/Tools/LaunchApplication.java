package Tools;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LaunchApplication {

    public static AndroidDriver driver;

    @Before
    public void setUp() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setPlatformVersion("16");
        options.setDeviceName("emulator-5554");
        options.setAppPackage("org.wikipedia.alpha");
        options.setAppActivity("org.wikipedia.main.MainActivity");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\Thibault\\wks\\wikipedia\\data\\app\\app-alpha-universal-release.apk");

        try {
            URI url = new URI("http://169.254.123.204:4723/");
            driver = new AndroidDriver(url.toURL(), options);
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.id("org.wikipedia.alpha:id/primaryTextView"));
        Assert.assertTrue(element.isDisplayed());

        System.out.println("Application launched successfully");
    }

    // @After
    // public void tearDown() {
    // System.out.println("Application closed successfully");
    // driver.quit();
    // }

}