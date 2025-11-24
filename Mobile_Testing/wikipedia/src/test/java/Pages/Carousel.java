package Pages;

import Tools.SWIPE_DIRECTION;
import Tools.Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

/**
 * Cette classe représente la page de carousel (Page à l'ouverture de
 * l'application)dans l'application Wikipedia.
 * Elle contient des méthodes pour naviguer dans le carousel et cliquer sur le
 * bouton "Get Started".
 */
public class Carousel {
    private Tools tools;

    private static final By PRIMARY_TEXT = By.id("org.wikipedia.alpha:id/primaryTextView");
    private static final By GET_STARTED_BUTTON = By.id("org.wikipedia.alpha:id/fragment_onboarding_done_button");

    public Carousel() {
        tools = new Tools();
    }

    public void swipeCarousel(AndroidDriver driver) {
        WebElement element = driver.findElement(PRIMARY_TEXT);
        String primaryTextContent = element.getText();

        do {

            tools.swipe(SWIPE_DIRECTION.LEFT, driver);
            element = driver.findElement(PRIMARY_TEXT);
            primaryTextContent = element.getText();

        } while (!primaryTextContent.equals("Data & Privacy"));

        clickGetStarted(driver);
    }

    private void clickGetStarted(AndroidDriver driver) {
        driver.findElement(GET_STARTED_BUTTON).click();
    }

}
