package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import hellocucumber.pages.GoogleHomePage;
import lombok.extern.java.Log;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

@Log
public class Stepdefs extends GoogleHomePage {

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
        checkPageTitle(pageTitleElement, pageTitle);
    }

    @When("^I search for the term \"([^\"]*)\"$")
    public void iSearchForTheTerm(String searchTerm) {
        enterText(searchTextBoxElement, searchTerm);
        clickButton(searchButtonElement);
    }

    @Then("^I will get a list of results to chose from$")
    public void iWillGetAListOfResultsToChoseFrom() {
        checkCollectionHasMoreThanOne(searchResultHeadings);
    }
}