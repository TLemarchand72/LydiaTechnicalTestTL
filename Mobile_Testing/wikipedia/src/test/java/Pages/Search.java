package Pages;

import org.openqa.selenium.By;
import org.junit.Assert;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Search {

    private WebDriverWait wait;

    private static final By SEARCH_BAR = By.id("org.wikipedia.alpha:id/search_container");
    private static final By SEARCH_INPUT = By.id("org.wikipedia.alpha:id/search_src_text");
    private static final By SEARCH_RESULT = By.xpath(
            "//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/page_list_item_title\" and @text=\"Lydia\"]//following-sibling::android.widget.TextView[@text=\"Ancient Anatolian kingdom\"]");

    private static final By CLOSE_POPIN = By.id("org.wikipedia.alpha:id/closeButton");
    private static final By TITLE_DESCRIPTION = By.xpath(
            "//android.widget.TextView[@resource-id=\"pcs-edit-section-title-description\" and @text=\"Ancient Anatolian kingdom\"]");

    public void search(String text, AndroidDriver driver) {
        clickSearchBar(driver);
        driver.findElement(SEARCH_INPUT).sendKeys(text);

        Assert.assertTrue(driver.findElement(SEARCH_RESULT).isDisplayed());
    }

    public void clickSearchResult(AndroidDriver driver) {
        driver.findElement(SEARCH_RESULT).click();
        closePopin(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_DESCRIPTION));
        Assert.assertTrue(driver.findElement(TITLE_DESCRIPTION).getText().equals("Ancient Anatolian kingdom"));
    }

    private void clickSearchBar(AndroidDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BAR));
        driver.findElement(SEARCH_BAR).click();
    }

    private void closePopin(AndroidDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CLOSE_POPIN));
        driver.findElement(CLOSE_POPIN).click();
    }
}