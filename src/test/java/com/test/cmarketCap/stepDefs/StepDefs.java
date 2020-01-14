package com.test.cmarketCap.stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepDefs extends BaseSteps {

    @Then("^the response code is (\\d+)$")
    public void theResponseCodeIs(int responseCode) {
        assertThat(getResponseCode(), is(equalTo(responseCode)));
    }

    @Given("^user constructs the url to bring the latest crypto currencies$")
    public void userConstructsTheUrlToBringTheLatestCryptoCurrencies() {
        constructCryptoCcyMap();
    }

    @Given("^user constructs the url to fetch the currency info$")
    public void userConstructsTheUrlToFetchCurrencyInfo() {
        constructCurrencyInfoUrl();
    }

    @When("^user retrieves the ids for the currencies \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void userRetrieveTheIdsForTheCurrenciesbTCuSDeTH(String ccy1, String ccy2, String ccy3) {
        userRetirveIds(ccy1, ccy2, ccy3);
    }

    @When("^user converts the BTC,USDT,ETH to Bolivian Boliviano \"([^\"]*)\"$")
    public void userConvertsTheCurrencies(String targetCCy) {
        constructPriceConversionUrl();
        getPriceConversion(ids.get(0), "1", targetCCy);
        getPriceConversion(ids.get(1), "1", targetCCy);
        getPriceConversion(ids.get(2), "1", targetCCy);
    }

    @When("^get call is performed to bring the latest Ccys$")
    public void getCallIsPerformedToBringCcys() {
        getCryptoCcyMap();
    }

    @When("^get call is performed to fetch currency info$")
    public void getCallIsPerformedToFetchCurrencyInfo() {
        getCurrencyInfo();
    }

    @And("^\"([^\"]*)\" value is \"([^\"]*)\"$")
    public void valueIs(String path, String value) throws Throwable {
        assertThat(getResponseValue(path), is(equalTo(value.equals("null")?null:value)));
    }

    @And("^\"([^\"]*)\" value contains \"([^\"]*)\"$")
    public void valueContains(String path, String value) throws Throwable {
        assertThat(getResponseValue(path), hasItem(value));
    }
}
