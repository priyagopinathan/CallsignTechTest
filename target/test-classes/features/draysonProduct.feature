Feature: Price conversion - Crypto currencies

  Scenario: verify price-conversion call convert the currencies to BOB
    Given user constructs the url to bring the latest crypto currencies
    When get call is performed to bring the latest Ccys
    Then the response code is 200
    When user retrieves the ids for the currencies "BTC", "USDT", "ETH"
    And user converts the BTC,USDT,ETH to Bolivian Boliviano "BOB"
    Then the response code is 200

  Scenario: verify currency info call fetch all the relevant information
    Given user constructs the url to fetch the currency info
    When get call is performed to fetch currency info
    Then the response code is 200
    And "data.1027.logo" value is "https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png"
    And "data.1027.urls.technical_doc" value contains "https://github.com/ethereum/wiki/wiki/White-Paper"
    And "data.1027.symbol" value is "ETH"
    And "data.1027.date_added" value is "2015-08-07T00:00:00.000Z"
    And "data.1027.platform" value is "null"
    And "data.1027.tags" value contains "mineable"