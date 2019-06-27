package com.spartaglobal.restassuredpostcodes.services;

import com.spartaglobal.restassuredpostcodes.MoviesHTTPManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MoviesDTO {

    private JSONObject fullMoviesFile;

   public MoviesDTO() {
        //RatesFileReader ratesFile = new RatesFileReader(filePath);
        MoviesHTTPManager moviesJson = new MoviesHTTPManager();

        JSONParser parser = new JSONParser();
        try {
            Object moviesObj = parser.parse(moviesJson.getMovie());
            fullMoviesFile = (JSONObject) moviesObj;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void printMovie() {
        System.out.println(fullMoviesFile.toString());
    }

    public String getYear() {
        return (String) fullMoviesFile.get("Year");
    }

    public String getTitle(){
       return (String) fullMoviesFile.get("Title");
    }

    public String getActors(){
       return (String) fullMoviesFile.get("Actors");
    }

    public JSONArray getRatings(){
       return (JSONArray) fullMoviesFile.get("Ratings");
    }

}

