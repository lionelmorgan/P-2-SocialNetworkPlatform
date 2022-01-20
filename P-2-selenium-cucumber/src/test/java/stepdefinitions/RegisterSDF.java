package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.RegisterPOM;

import java.sql.Driver;

public class RegisterSDF {

    RegisterPOM registerPOM;

    @After
    public void tearDown(){
        DriverSingleton.quitInstance();
    }

    @Given("a user is on the register page")
    public void a_user_is_on_the_register_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/register");
        this.registerPOM = new RegisterPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/register", this.registerPOM.getCurrentUrl());
    }
    @When("a user inputs unused credentials")
    public void a_user_inputs_unused_credentials() {
        this.registerPOM.enterUsername("joesi");
        this.registerPOM.enterPassword("password");
        this.registerPOM.enterFirstName("Joe");
        this.registerPOM.enterLastName("Si");
        this.registerPOM.enterEmail("joe.si@revature.net");
        this.registerPOM.enterFileImg();
        this.registerPOM.clickBtn();
    }
    @Then("a user is redirected to the login page")
    public void a_user_is_redirected_to_the_login_page() {
        this.registerPOM.waitForSuccessfulRegister();
        Assertions.assertEquals("http://localhost:4200/", this.registerPOM.getCurrentUrl());
    }


    @When("a user inputs used credentials")
    public void a_user_used_credentials() {
        this.registerPOM.enterUsername("joesi");
        this.registerPOM.enterPassword("password");
        this.registerPOM.enterFirstName("Joe");
        this.registerPOM.enterLastName("Si");
        this.registerPOM.enterEmail("joe.si@revature.net");
        this.registerPOM.enterFileImg();
        this.registerPOM.clickBtn();
    }
    @Then("an error message will be displayed")
    public void an_error_message_will_be_displayed() {
        String error = this.registerPOM.getErrorMessage();
        Assertions.assertEquals("This username already exists please try a different one", error);
        //This username already exists please try a different one
    }

}
