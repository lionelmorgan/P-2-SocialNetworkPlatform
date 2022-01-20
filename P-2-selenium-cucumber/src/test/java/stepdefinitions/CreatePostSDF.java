package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.CreatePostPOM;

import java.sql.Driver;

public class CreatePostSDF {

    CreatePostPOM createPostPOM;

    @After
    public void tearDown() {
        DriverSingleton.quitInstance();
    }

    //may have to insert login info
    @Given("A user is on the account page")
    public void a_user_is_on_the_account_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/account");
        this.createPostPOM = new CreatePostPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/account", this.createPostPOM.getCurrentUrl());
    }

    @When("A user clicks new post button")
    public void a_user_clicks_the_new_post_button() {
        this.createPostPOM.clickNewPost();
    }

    @Then("A user inputs post description and image")
    public void a_user_inputs_post_description_and_image() {
        this.createPostPOM.enterDescription("Earth picture");
        this.createPostPOM.enterImg();
        this.createPostPOM.clickConfirm();
    }

}