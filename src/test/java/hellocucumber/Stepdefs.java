package hellocucumber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import lombok.extern.java.Log;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log
public class Stepdefs extends GoogleHomePage {

    @Before
    public void setUpTestEnvironment() throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream("environment.properties");
        properties.load(input);

        // Set up browser
        String browser = properties.getProperty("browser");
        if ("chrome".equals(browser)) {
            WebDriverRunner.setWebDriver(new ChromeDriver());
            log.info(String.format("Running tests using %s browser", browser));
        }

        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/surefire-reports";
    }


    @Given("^I am on the home page of the following site \"([^\"]*)\"$")
    public void iAmOnTheHomePageOfTheFollowingSite(String website) {
        open(website);
    }

    @When("^I get the page title$")
    public void iGetThePageTitle() {
        String webPageTitle = title();
        log.info("Page title: " + webPageTitle);
    }

    @Then("^the page title will be \"([^\"]*)\"$")
    public void thePageTitleWillBe(String pageTitle) {
        checkPageTitle(pageTitleElement(), pageTitle);
    }

    @When("^I search for the term \"([^\"]*)\"$")
    public void iSearchForTheTerm(String searchTerm) {
        enterText(searchTextBox(), searchTerm);
        clickButton(searchButton());
    }

    @Then("^I will get a list of results to chose from$")
    public void iWillGetAListOfResultsToChoseFrom() {
        checkCollectionHasMoreThanOne(searchResultHeadings());
    }

    @After
    public void closeDriver() {
        getWebDriver().close();
    }


}