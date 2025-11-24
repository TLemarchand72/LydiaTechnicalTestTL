package Steps;

import Pages.Carousel;
import Pages.Search;
import Pages.ArticlePage;
import Tools.LaunchApplication;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class UserCaseStep {
    private Carousel carousel;
    private Search search;
    private ArticlePage articlePage;

    private AndroidDriver driver;

    public UserCaseStep() {
        driver = LaunchApplication.driver;
        carousel = new Carousel();
        search = new Search();
        articlePage = new ArticlePage();
    }

    @Given("the application is launched")
    public void the_application_is_launched() {
        if (driver == null) {
            throw new RuntimeException("Application is not launched");
        }
    }

    @When("I swipe through the carousel until the last image without skipping")
    public void swipeCarouselUntilEnd() {
        carousel.swipeCarousel(driver);
    }

    @When("I search for {string}")
    public void searchLydia(String text) {
        search.search(text, driver);
    }

    @When("I scroll until I find the city Lydia")
    public void scrollUntilLydia() {
        search.clickSearchResult(driver);
    }

    @When("I change the website language to French")
    public void changeLanguage() {
        articlePage.changeLanguage(driver);
    }

    @When("I click on {string}")
    public void openCresusPage(String text) {
        articlePage.openCresusPage(driver, text);
    }
}
