package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.FeedPOM;

import java.sql.Driver;

public class FeedSDF {

    FeedPOM feedPOM;

    @Given("a user is on the feed page")
    public void a_user_is_on_the_feed_page() {
        this.feedPOM = new FeedPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/feed", this.feedPOM.getCurrentUrl());
    }

    @When("A user clicks on the username of a user")
    public void a_user_clicks_on_the_username_of_a_user() {
        this.feedPOM.clickPost();
    }
    @Then("The user is brought to that user's account page")
    public void the_user_is_brought_to_that_user_s_account_page() {
        Assertions.assertEquals("http://localhost:4200/account", this.feedPOM.getCurrentUrl());
    }

}
