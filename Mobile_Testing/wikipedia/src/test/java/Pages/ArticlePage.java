package Pages;

import Tools.Tools;
import Tools.SWIPE_DIRECTION;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import io.appium.java_client.android.AndroidDriver;

/**
 * Cette classe représente la page d'article dans l'application Wikipedia.
 * Elle contient des méthodes pour changer la langue et ouvrir une page
 * spécifique.
 */
public class ArticlePage {

    private Tools tools = new Tools();

    private static final By LANGUAGE_BUTTON = By.id("org.wikipedia.alpha:id/page_language");
    private static final By BTN_SEARCH_LANGUAGE = By.xpath(
            "//android.view.View[@content-desc='Search']//following-sibling::android.widget.Button");
    private static final By FRENCH_LANGUAGE = By.xpath("//android.widget.TextView[@text='French']");
    private static final By FRENCH_TITLE = By.xpath("(//android.widget.TextView[@text='Lydie'])[1]");

    private static final By VOIR_AUSSI_MENU = By.xpath("//android.widget.TextView[@resource-id=\"Voir_aussi\"]");
    private static final By LIRE_ARTICLE_BTN = By.id("org.wikipedia.alpha:id/link_preview_primary_button");

    public void changeLanguage(AndroidDriver driver) {
        driver.findElement(LANGUAGE_BUTTON).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(BTN_SEARCH_LANGUAGE));
        driver.findElement(BTN_SEARCH_LANGUAGE).click();

        driver.findElement(By.className("android.widget.EditText")).sendKeys("French");
        wait.until(ExpectedConditions.elementToBeClickable(FRENCH_LANGUAGE));
        driver.findElement(FRENCH_LANGUAGE).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(FRENCH_TITLE));
        Assert.assertTrue(driver.findElement(FRENCH_TITLE).isDisplayed());
    }

    public void openCresusPage(AndroidDriver driver, String text) {
        By PAGE_LINK = By.xpath("//android.widget.TextView[@text=\"" + text + "\"]");

        do {
            System.out.println("Scrolling to find the page link");
            tools.swipe(SWIPE_DIRECTION.UP, driver);
        } while (driver.findElements(VOIR_AUSSI_MENU).isEmpty());

        System.out.println("Page link found");
        driver.findElement(VOIR_AUSSI_MENU).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(PAGE_LINK));
        } catch (Exception e) {
            tools.swipe(SWIPE_DIRECTION.UP, driver);
        }

        driver.findElement(PAGE_LINK).click();

        wait.until(ExpectedConditions.elementToBeClickable(LIRE_ARTICLE_BTN));
        driver.findElement(LIRE_ARTICLE_BTN).click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@text=\"" + text + "\"])[1]")));
    }

}