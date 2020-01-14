$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("draysonProduct.feature");
formatter.feature({
  "line": 1,
  "name": "Price conversion - Crypto currencies",
  "description": "",
  "id": "price-conversion---crypto-currencies",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "verify price-conversion call convert the currencies to BOB",
  "description": "",
  "id": "price-conversion---crypto-currencies;verify-price-conversion-call-convert-the-currencies-to-bob",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user constructs the url to bring the latest crypto currencies",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "get call is performed to bring the latest Ccys",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the response code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user retrieves the ids for the currencies \"BTC\", \"USDT\", \"ETH\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user converts the BTC,USDT,ETH to Bolivian Boliviano \"BOB\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the response code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.userConstructsTheUrlToBringTheLatestCryptoCurrencies()"
});
formatter.result({
  "duration": 135267040,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs.getCallIsPerformedToBringCcys()"
});
formatter.result({
  "duration": 2151298117,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 21
    }
  ],
  "location": "StepDefs.theResponseCodeIs(int)"
});
formatter.result({
  "duration": 8019434,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BTC",
      "offset": 43
    },
    {
      "val": "USDT",
      "offset": 50
    },
    {
      "val": "ETH",
      "offset": 58
    }
  ],
  "location": "StepDefs.userRetrieveTheIdsForTheCurrenciesbTCuSDeTH(String,String,String)"
});
formatter.result({
  "duration": 449932026,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BOB",
      "offset": 54
    }
  ],
  "location": "StepDefs.userConvertsTheCurrencies(String)"
});
formatter.result({
  "duration": 990784733,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 21
    }
  ],
  "location": "StepDefs.theResponseCodeIs(int)"
});
formatter.result({
  "duration": 114739,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "verify currency info call fetch all the relevant information",
  "description": "",
  "id": "price-conversion---crypto-currencies;verify-currency-info-call-fetch-all-the-relevant-information",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "user constructs the url to fetch the currency info",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "get call is performed to fetch currency info",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the response code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "\"data.1027.logo\" value is \"https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "\"data.1027.urls.technical_doc\" value contains \"https://github.com/ethereum/wiki/wiki/White-Paper\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "\"data.1027.symbol\" value is \"ETH\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "\"data.1027.date_added\" value is \"2015-08-07T00:00:00.000Z\"",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "\"data.1027.platform\" value is \"null\"",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "\"data.1027.tags\" value contains \"mineable\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.userConstructsTheUrlToFetchCurrencyInfo()"
});
formatter.result({
  "duration": 47781,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs.getCallIsPerformedToFetchCurrencyInfo()"
});
formatter.result({
  "duration": 330713138,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 21
    }
  ],
  "location": "StepDefs.theResponseCodeIs(int)"
});
formatter.result({
  "duration": 122399,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "data.1027.logo",
      "offset": 1
    },
    {
      "val": "https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png",
      "offset": 27
    }
  ],
  "location": "StepDefs.valueIs(String,String)"
});
formatter.result({
  "duration": 38617016,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "data.1027.urls.technical_doc",
      "offset": 1
    },
    {
      "val": "https://github.com/ethereum/wiki/wiki/White-Paper",
      "offset": 47
    }
  ],
  "location": "StepDefs.valueContains(String,String)"
});
formatter.result({
  "duration": 18311645,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "data.1027.symbol",
      "offset": 1
    },
    {
      "val": "ETH",
      "offset": 29
    }
  ],
  "location": "StepDefs.valueIs(String,String)"
});
formatter.result({
  "duration": 15157986,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "data.1027.date_added",
      "offset": 1
    },
    {
      "val": "2015-08-07T00:00:00.000Z",
      "offset": 33
    }
  ],
  "location": "StepDefs.valueIs(String,String)"
});
formatter.result({
  "duration": 17401880,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "data.1027.platform",
      "offset": 1
    },
    {
      "val": "null",
      "offset": 31
    }
  ],
  "location": "StepDefs.valueIs(String,String)"
});
formatter.result({
  "duration": 18157570,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "data.1027.tags",
      "offset": 1
    },
    {
      "val": "mineable",
      "offset": 33
    }
  ],
  "location": "StepDefs.valueContains(String,String)"
});
formatter.result({
  "duration": 15354268,
  "status": "passed"
});
});