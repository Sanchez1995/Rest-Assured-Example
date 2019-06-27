package com.spartaglobal.restassuredpostcodes.tests;

import com.spartaglobal.restassuredpostcodes.PropsReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MovieApiRestAssured {

    private static ValidatableResponse jsonBody;
    private static String movieSearch;

    @BeforeClass
    public static void setup(){
        PropsReader propsReader = new PropsReader();
        baseURI = "http://www.omdbapi.com/";
        movieSearch = "&t=c*";
        basePath = "?apikey=" + propsReader.getApiKey() + movieSearch;

        JSONObject movies = new JSONObject();
        JSONArray multipleMovies = new JSONArray();

        multipleMovies.add("Movies");

        System.out.println(movies);

        jsonBody = get("").then();
    }

    @Test
    public void setupTest(){
        jsonBody.body("Year", equalTo(1999));
    }

}
