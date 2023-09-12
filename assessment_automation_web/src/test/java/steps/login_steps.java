package steps;

import assessment.web.ui.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class login_steps {

    @When("user enters {string} username")
    public void enter_username(String userType) throws IOException {
        new LoginPage().textUsername(userType);
    }

    @When("user enters the password")
    public void enter_password() throws IOException {
        new LoginPage().textPassword();
    }

    @Then("user clicks on login button")
    public void click_login_button() {
        new LoginPage().clickLogin();
    }

    @Then("user logouts from application")
    public void userLogoutsFromApplication() throws InterruptedException {
        new LoginPage().logout();
    }
}
