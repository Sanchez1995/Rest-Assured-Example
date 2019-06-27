package com.spartaglobal.restassuredpostcodes.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.apache.groovy.json.internal.JsonStringDecoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MultiplePostcodesTests {

    private static JsonPath jsonBody;

    @BeforeClass
    public static void setup(){
        baseURI = "https://api.postcodes.io";
        basePath = "/postcodes/";


        JSONObject postcodes = new JSONObject();
        JSONArray multiplesPostcodes = new JSONArray();

        multiplesPostcodes.add("sw164dh");
        multiplesPostcodes.add("cr78dz");

        postcodes.put("postcodes", multiplesPostcodes);

        System.out.println(postcodes.toJSONString());

        jsonBody = given()
                .contentType(ContentType.JSON)
                .body(postcodes)
                .when()
                .post()
                .then()
                .extract()
                .jsonPath();
    }

    @Test
    public void multiplePostcodeTest(){
        System.out.println((int) jsonBody.get("status"));
        Assert.assertEquals("SW16 4HD", jsonBody.get("result[1].postcodes"));

    }
}
