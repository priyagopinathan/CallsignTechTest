package com.test.cmarketCap.stepDefs;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.given;

public abstract class BaseSteps
{
    private String url;
    private static final String BASEURL = "https://pro-api.coinmarketcap.com/v1";
    private static final String CRYPTO_MAP = "/cryptocurrency/map";
    private static final String PRICE_CONVERSION = "/tools/price-conversion";
    private static final String CURRENCY_INFO = "/cryptocurrency/info";
    public static List<String> ids = new ArrayList<>();

    private static ValidatableResponse response;

    protected void getCryptoCcyMap() {
        response = given().log().all().relaxedHTTPSValidation().config(RestAssured.config()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .encodeContentTypeAs("x-www-form-urlencoded",
                                ContentType.URLENC)))
                .contentType("application/x-www-form-urlencoded")
                .formParam("symbol", "BTC,USDT,ETH")
                .header("Content-Type","application/x-www-form-urlencoded")
                .header("Accept","application/json")
                .header("X-CMC_PRO_API_KEY","732a57ff-54ea-4e1a-807a-58f4004bbfa6")
                .get(url)
                .then().log().all();
    }

    protected void getCurrencyInfo() {
        response = given().log().all().relaxedHTTPSValidation().config(RestAssured.config()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .encodeContentTypeAs("x-www-form-urlencoded",
                                ContentType.URLENC)))
                .contentType("application/x-www-form-urlencoded")
                .formParam("id", "1027")
                .header("Content-Type","application/x-www-form-urlencoded")
                .header("Accept","application/json")
                .header("X-CMC_PRO_API_KEY","732a57ff-54ea-4e1a-807a-58f4004bbfa6")
                .get(url)
                .then().log().all();
    }

    protected void getPriceConversion(String id, String amount, String convertCcys) {
        response = given().log().all().relaxedHTTPSValidation().config(RestAssured.config()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .encodeContentTypeAs("x-www-form-urlencoded",
                                ContentType.URLENC)))
                .contentType("application/x-www-form-urlencoded")
                .formParam("id", id)
                .formParam("amount", amount)
                .formParam("convert", convertCcys)
                .header("Content-Type","application/x-www-form-urlencoded")
                .header("Accept","application/json")
                .header("X-CMC_PRO_API_KEY","732a57ff-54ea-4e1a-807a-58f4004bbfa6")
                .get(url)
                .then().log().all();
    }

    protected <T> T getResponseValue(String path) {
        return response.extract().jsonPath().get(path);
    }

    protected int getResponseCode() {
        return response.extract().statusCode();
    }

    protected List<HashMap<String, Object>> getResponeInList() {
        return response.extract().jsonPath().get("data");
    }

    protected void constructCryptoCcyMap() {
        url = BASEURL + CRYPTO_MAP;
    }

    protected void constructPriceConversionUrl() {
        url = BASEURL + PRICE_CONVERSION;
    }

    protected void constructCurrencyInfoUrl() {
        url = BASEURL + CURRENCY_INFO;
    }

    protected void userRetirveIds(String... ccys) {
        List<HashMap<String, Object>> cryptoCurrencies = getResponeInList();
        List<String> currencies = Arrays.asList(ccys);
        IntStream.range(0,3).forEach(iter-> ids.add(cryptoCurrencies.stream().filter(x -> x.get("symbol").equals(currencies.get(iter))).map(x -> x.get("id")).collect(Collectors.toList()).get(0).toString()));
    }
}
