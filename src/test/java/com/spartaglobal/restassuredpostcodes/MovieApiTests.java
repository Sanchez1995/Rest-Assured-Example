package com.spartaglobal.restassuredpostcodes;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class MovieApiTests {



    private static JsonPath jsonBody;

    @BeforeClass
    public static void setup(){
        baseURI = "http://www.omdbapi.com";
        basePath = "/?t=b*&type=movie&apikey=59fd240b";

        //client = omdb.OMDBClient(apikey=API_KEY)


        JSONObject movie = new JSONObject();
        JSONArray movieDetails = new JSONArray();

        //i want to add multiple movies into a JsonArray defined by
        //would i have to have multiple calls?
        movieDetails.add("t=a*");
        movieDetails.add("t=c*");


        movie.put("movies", movieDetails);

        System.out.println(movie.toJSONString());

        jsonBody = given()
                .contentType(ContentType.JSON)
                .body(movieDetails)
                .when()
                .post()
                .then()
                .extract()
                .jsonPath();
    }

    @Test
    public void sampleTest(){

        System.out.println((String) jsonBody.get("Writer"));
    }
}
