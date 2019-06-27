package com.spartaglobal.restassuredpostcodes.tests;


import com.spartaglobal.restassuredpostcodes.services.MoviesDTO;
import io.restassured.response.ValidatableResponse;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MovieApiTests {

    private static ValidatableResponse jsonBody;
    private static MoviesDTO movies;

    @BeforeClass
    public static void setup(){

        movies = new MoviesDTO();
        movies.printMovie();
        //jsonBody = get(" ").then();

        //i want to create a JSONArray that contains multiple movie Jsons. may have to do multiple calls.
    }

    @Test
    public void movieYearTest(){
        Assert.assertEquals( "1999", movies.getYear());
        System.out.println(movies.getYear());
    }
    @Test
    public void movieTitleTest(){
        Assert.assertEquals("Fight Club", movies.getTitle());
        System.out.println(movies.getTitle());
    }

    @Test
    public void movieActorTest(){
        Assert.assertTrue(movies.getActors().contains("Edward Norton"));
    }

    @Test
    public void movieRatingsTest(){
        System.out.println(movies.getRatings());
    }
}
