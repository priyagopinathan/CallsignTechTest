package com.test.cmarketCap.stepDefs;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber",
        "json:target/cucumber.json"
        },
        glue = {"classpath:com/test/cmarketCap/stepDefs"},
        features = "src/test/resources/features")
public class TestRunner {
}
