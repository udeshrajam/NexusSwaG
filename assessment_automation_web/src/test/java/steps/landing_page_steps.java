package steps;

import assessment.web.ui.pages.LandingPage;
import io.cucumber.java.en.When;

public class landing_page_steps {

    @When("select {string} as sorting")
    public void user_selects_sorting(String sort) {
       new LandingPage().dropDownSort(sort);
    }

    @When("add items to the cart")
    public void select_products() {
        new LandingPage().addProductsToCart();
    }

    @When("verify the product list")
    public void sort_and_verify() {
        new LandingPage().sortAndVerifyProductList();
    }





}
