package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.AccountPOM;

public class AccountSDF {

    AccountPOM accountPOM;

    String username = "joesi";
    String firstname = "joe";
    String lastname = "si";
    String email = "email.net";
    String password = "password";

    @Given("a user is on the account page")
    public void a_user_is_on_the_account_page() {
        this.accountPOM = new AccountPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/account", this.accountPOM.getCurrentUrl());
    }
    @When("a user inputs new first name")
    public void a_user_inputs_new_first_name() {
        this.accountPOM.enterFirstName(this.firstname);

        this.accountPOM.enterUsername(this.username);
        this.accountPOM.enterEmail(this.email);
        this.accountPOM.enterLastName(this.lastname);
        this.accountPOM.enterImage();
        this.accountPOM.enterPassword(this.password);

        this.accountPOM.clickAcceptBtn();

    }
    @Then("Updated user text displays")
    public void updated_user_text_displays() {

        Assertions.assertEquals("Updated User",this.accountPOM.getOkMessage());

    }


    @When("a user inputs new last name")
    public void a_user_inputs_new_last_name() {
        this.accountPOM.enterLastName("Dobby");

        this.accountPOM.enterUsername(this.username);
        this.accountPOM.enterEmail(this.email);
        this.accountPOM.enterFirstName(this.lastname);
        this.accountPOM.enterImage();
        this.accountPOM.enterPassword(this.password);

        this.accountPOM.clickAcceptBtn();
    }



    @When("a user inputs new username")
    public void a_user_inputs_new_username() {
        this.accountPOM.enterUsername(this.username);

        this.accountPOM.enterLastName(this.lastname);
        this.accountPOM.enterEmail(this.email);
        this.accountPOM.enterFirstName(this.lastname);
        this.accountPOM.enterImage();
        this.accountPOM.enterPassword(this.password);

        this.accountPOM.clickAcceptBtn();
    }



    @When("a user inputs used username")
    public void a_user_inputs_used_username() {
        this.accountPOM.enterUsername("test");

        this.accountPOM.enterLastName(this.lastname);
        this.accountPOM.enterEmail(this.email);
        this.accountPOM.enterFirstName(this.lastname);
        this.accountPOM.enterImage();
        this.accountPOM.enterPassword(this.password);

        this.accountPOM.clickAcceptBtn();
    }
    @Then("Username taken error displays")
    public void username_taken_error_displays() {
        Assertions.assertEquals("Username is already taken", this.accountPOM.getErrorMessage());
    }


    @When("a user inputs new Profile Picture")
    public void a_user_inputs_new_profile_picture() {
        this.accountPOM.enterImage();

        this.accountPOM.enterLastName(this.lastname);
        this.accountPOM.enterEmail(this.email);
        this.accountPOM.enterFirstName(this.lastname);
        this.accountPOM.enterUsername(this.username);
        this.accountPOM.enterPassword(this.password);

        this.accountPOM.clickAcceptBtn();
    }

    @When("a user clicks on the feed page")
    public void a_user_clicks_on_the_feed_page() {
        this.accountPOM.clickFeed();
    }
    @Then("the user is redirected to the feed page")
    public void the_user_is_redirected_to_the_feed_page() {
        Assertions.assertEquals("http://localhost:4200/feed", this.accountPOM.getCurrentUrl());
    }


}
