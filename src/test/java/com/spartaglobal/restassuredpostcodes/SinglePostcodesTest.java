package com.spartaglobal.restassuredpostcodes;


import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SinglePostcodesTest {

    private static ValidatableResponse jsonBody;

    @BeforeClass
    public static void setup(){
        baseURI = "https://api.postcodes.io";
        basePath = "/postcodes/";
        jsonBody = get("sw164dh").then();
    }

    @Test
    public void testSinglePostcodeService(){
        jsonBody.body("status", equalTo(200));
       /* get("sw164dh")
                .then()
                .statusCode(200)
                .body("result.postcode", equalTo("SW16 4DH"));*/
    }

    @Test
    public void testQuality(){
        jsonBody.body("result.quality", equalTo(1));
    }
}
