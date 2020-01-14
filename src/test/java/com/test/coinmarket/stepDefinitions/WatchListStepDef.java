package com.test.coinmarket.stepDefinitions;


import com.test.coinmarket.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class WatchListStepDef {
    List<String> addedList = new ArrayList<>();

    @Given("user is able to view all currencies on homepage")
    public void userIsAbleToViewAllCurrenciesOnHomepage() throws InterruptedException {
        TestBase.getInstance().getDriver().get("https://coinmarketcap.com/");
        Thread.sleep(500);
        TestBase.getInstance().getDriver().findElement(By.linkText("View All")).click();
        Thread.sleep(500);
    }

    @When("^user is able to randomly select (\\d+) currencies$")
    public void user_is_able_randomly_select_currencies(int noOfSelections) throws Throwable {
        List<WebElement> rows = TestBase.getInstance().getDriver().findElements(By.cssSelector("[class='cmc-table__table-wrapper-outer'] tr"));
        if (CollectionUtils.isEmpty(rows)) {
            throw new RuntimeException("Could not find any currencies");
        }
        int count = 0;
        for (WebElement currency : rows) {
            System.out.println(currency.getText());
            if (count > 0) {
                WebElement dropdown = currency.findElement(By.className("cmc-link"));
                addedList.add(dropdown.getAttribute("title"));
                Thread.sleep(1000);

                WebElement svgObject = dropdown.findElement(By.xpath("//*[name()=\"svg\" and @class=\"svg-inline--fa fa-ellipsis-h fa-w-16 cmc-icon\"]"));
                Actions builder = new Actions(TestBase.getInstance().getDriver());
                builder.click(svgObject).build().perform();
                dropdown.findElement(By.linkText("Add to Watchlist")).click();
                Thread.sleep(1000);
            }


            count++;
            if (count > noOfSelections) {
                break;
            }
        }
        System.out.println(addedList);
    }

    @Then("^user is able to see the selected currencies on watchlist tab$")
    public void user_is_able_to_see_the_selected_currencies_on_watchlist_tab() throws Throwable {
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        TestBase.getInstance().getDriver().findElement(By.linkText("Watchlist")).sendKeys(selectLinkOpeninNewTab);
        List<WebElement> rows = TestBase.getInstance().getDriver().findElements(By.cssSelector("[class='cmc-table__table-wrapper-outer'] tr"));
        Assert.assertTrue(rows.size() == 5);
        TestBase.getInstance().getDriver().quit();
    }

    @And("^user is able to add them to watchlist$")
    public void userIsAbleToAddThemToWatchlist() {
    }
}
