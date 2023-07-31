package org.example.gitsearch.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.gitsearch.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class HomeSteps {
    HomePage homePage;
    WebDriver driver;

    public HomeSteps() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://gh-users-search.netlify.app/");
        this.homePage = new HomePage(driver);
    }

    @When("the user searchs the profile {string}")
    public void aUsersSalaryFrequency(String profile) {
        homePage.searchName(profile);
    }

    @Then("the profile's follower are this many {string}")
    public void theProfileSFollowerAreThisMany(String follows) {
        assertTrue(homePage.isTheNumberOfFollowersEqualTO(follows));
    }

    @Then("the profile's followings are this many {string}")
    public void theProfileSFollowingsAreThisMany(String following) {
        assertTrue(homePage.isTheNumberOfFollowingEqualTO(following));
    }

    @Then("the profile's repos are this many {string}")
    public void theProfileSReposAreThisMany(String repos) {
        assertTrue(homePage.isTheNumberOfReposEqualTO(repos));
    }

    @Then("the profile's gists are this many {string}")
    public void theProfileSGistsAreThisMany(String gists) {
        assertTrue(homePage.isTheNumberOfReposEqualTO(gists));
    }

    @Then("the profile's location is {string}")
    public void theProfileSLocationIs(String arg0) {

    }

    @Then("the profile's job is {string}")
    public void theProfileSJobIs(String arg0) {
    }

    @Then("the profile's personal website is {string}")
    public void theProfileSPersonalWebsiteIs(String arg0) {
    }

    @Then("the profile's is followed by {string}")
    public void theProfileSIsFollowedBy(String arg0) {
    }
}
