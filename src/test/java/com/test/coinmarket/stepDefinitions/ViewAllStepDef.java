package com.test.coinmarket.stepDefinitions;

import com.test.coinmarket.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewAllStepDef {


    @Given("^user is  on homepage$")
    public void user_is_on_homepage() {

        TestBase.getInstance().getDriver().get("https://coinmarketcap.com/");
    }


    @When("^user clicks on ViewAll link$")
    public void user_clicks_on_ViewAll_link() throws Throwable {
        TestBase.getInstance().getDriver().findElement(By.linkText("View All")).click();
    }


    @Then("^user is able to see a list of 100 crypto currency providers$")
    public void user_is_able_to_see_a_list_of_crypto_currency_providers() throws Throwable {
        List<WebElement> rows = TestBase.getInstance().getDriver().findElements(By.cssSelector("[class='cmc-table__table-wrapper-outer'] tr"));
        Assert.assertTrue(rows.size() > 100);
        TestBase.getInstance().getDriver().quit();
    }
}
